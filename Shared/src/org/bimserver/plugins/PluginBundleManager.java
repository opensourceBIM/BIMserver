package org.bimserver.plugins;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

import javax.xml.bind.JAXBException;

import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.artifact.versioning.InvalidVersionSpecificationException;
import org.apache.maven.artifact.versioning.VersionRange;
import org.apache.maven.model.Model;
import org.apache.maven.model.Repository;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleType;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.bimserver.interfaces.objects.SPluginInformation;
import org.bimserver.plugins.classloaders.DelegatingClassLoader;
import org.bimserver.plugins.classloaders.EclipsePluginClassloader;
import org.bimserver.plugins.classloaders.FileJarClassLoader;
import org.bimserver.plugins.classloaders.JarClassLoader;
import org.bimserver.plugins.classloaders.PublicFindClassClassLoader;
import org.bimserver.plugins.web.WebModulePlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.FakeClosingInputStream;
import org.bimserver.utils.PathUtils;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.collection.CollectRequest;
import org.eclipse.aether.collection.CollectResult;
import org.eclipse.aether.collection.DependencyCollectionException;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.graph.DependencyNode;
import org.eclipse.aether.graph.Exclusion;
import org.eclipse.aether.resolution.ArtifactDescriptorException;
import org.eclipse.aether.resolution.ArtifactDescriptorRequest;
import org.eclipse.aether.resolution.ArtifactDescriptorResult;
import org.eclipse.aether.resolution.ArtifactRequest;
import org.eclipse.aether.resolution.ArtifactResolutionException;
import org.eclipse.aether.resolution.ArtifactResult;
import org.eclipse.aether.resolution.DependencyRequest;
import org.eclipse.aether.resolution.DependencyResolutionException;
import org.eclipse.aether.util.graph.visitor.PreorderNodeListGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginBundleManager implements AutoCloseable {
	private static final Logger LOGGER = LoggerFactory.getLogger(PluginBundleManager.class);
	
	private final Map<PluginBundleIdentifier, PluginBundle> pluginBundleIdentifierToPluginBundle = new HashMap<>();
	private final Map<PluginBundleVersionIdentifier, PluginBundle> pluginBundleVersionIdentifierToPluginBundle = new HashMap<>();
	private final Map<PluginBundleIdentifier, PluginBundleVersionIdentifier> pluginBundleIdentifierToCurrentPluginBundleVersionIdentifier = new HashMap<>();

	private PluginManager pluginManager;
	private final Path pluginsDir;
	private MavenPluginRepository mavenPluginRepository;
	private final List<FileJarClassLoader> jarClassLoaders = new ArrayList<>();

	public PluginBundleManager(PluginManager pluginManager, MavenPluginRepository mavenPluginRepository, Path pluginsDir) {
		this.pluginManager = pluginManager;
		this.mavenPluginRepository = mavenPluginRepository;
		this.pluginsDir = pluginsDir;
		
		if (pluginsDir != null) {
			if (!Files.isDirectory(pluginsDir)) {
				try {
					Files.createDirectories(pluginsDir);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public PluginBundle install(MavenPluginBundle mavenPluginBundle, boolean strictDependencyChecking) throws Exception {
		return install(mavenPluginBundle, null, strictDependencyChecking);
	}

	public PluginBundle install(MavenPluginBundle mavenPluginBundle, List<SPluginInformation> plugins, boolean strictDependencyChecking) throws Exception {
		PluginBundleVersionIdentifier pluginBundleVersionIdentifier = mavenPluginBundle.getPluginVersionIdentifier();
		MavenXpp3Reader mavenreader = new MavenXpp3Reader();
		Model model = null;
		try (InputStream pomInputStream = mavenPluginBundle.getPomInputStream()) {
			model = mavenreader.read(pomInputStream);
		}

		if (plugins == null) {
			try (InputStream inputStream = mavenPluginBundle.getJarInputStream()) {
				try (JarInputStream jarInputStream = new JarInputStream(inputStream)) {
					JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
					while (nextJarEntry != null) {
						if (nextJarEntry.getName().equals("plugin/plugin.xml")) {
							// Install all plugins
							PluginDescriptor pluginDescriptor = pluginManager.getPluginDescriptor(new FakeClosingInputStream(jarInputStream));
							plugins = new ArrayList<>();
							pluginManager.processPluginDescriptor(pluginDescriptor, plugins);
							for (SPluginInformation info : plugins) {
								info.setInstallForAllUsers(true);
								info.setInstallForNewUsers(true);
							}
							break;
						}
						nextJarEntry = jarInputStream.getNextJarEntry();
					}
				}
			}
		}

		DelegatingClassLoader delegatingClassLoader = new DelegatingClassLoader(getClass().getClassLoader());

		loadDependencies(mavenPluginBundle.getVersion(), strictDependencyChecking, model, delegatingClassLoader);

		Path target = pluginsDir.resolve(pluginBundleVersionIdentifier.getFileName());
		if (Files.exists(target)) {
			throw new PluginException("This plugin has already been installed " + target.getFileName().toString());
		}
		InputStream jarInputStream = mavenPluginBundle.getJarInputStream();
		try {
			Files.copy(jarInputStream, target);
		} finally {
			jarInputStream.close();
		}

		return loadPlugin(pluginBundleVersionIdentifier, target, mavenPluginBundle.getPluginBundle(), mavenPluginBundle.getPluginBundleVersion(), plugins, delegatingClassLoader);
	}

	private void loadDependencies(String pluginBundleVersion, boolean strictDependencyChecking, Model model,
			DelegatingClassLoader delegatingClassLoader)
			throws DependencyCollectionException, InvalidVersionSpecificationException, Exception {
		if (model.getRepositories() != null) {
			for (Repository repository : model.getRepositories()) {
				mavenPluginRepository.addRepository(repository.getId(), "default", repository.getUrl());
			}
		}

		List<Dependency> dependenciesToResolve = new ArrayList<>();
		for (org.apache.maven.model.Dependency dependency2 : model.getDependencies()) {
			String scope = dependency2.getScope();
			if (scope != null && (scope.contentEquals("test"))) {
				// Skip
				continue;
			}
			Dependency d = new Dependency(new DefaultArtifact(dependency2.getGroupId(), dependency2.getArtifactId(), dependency2.getType(), dependency2.getVersion()), dependency2.getScope());
			Set<Exclusion> exclusions = new HashSet<>();
			d.setExclusions(exclusions);
			exclusions.add(new Exclusion("org.opensourcebim", "pluginbase", null, "jar"));
			exclusions.add(new Exclusion("org.opensourcebim", "shared", null, "jar"));
			exclusions.add(new Exclusion("org.opensourcebim", "ifcplugins", null, "jar"));
			dependenciesToResolve.add(d);
		}
		CollectRequest collectRequest = new CollectRequest(dependenciesToResolve, null, null);
		collectRequest.setRepositories(mavenPluginRepository.getRepositoriesAsList());
		CollectResult collectDependencies = mavenPluginRepository.getSystem().collectDependencies(mavenPluginRepository.getSession(), collectRequest);
		PreorderNodeListGenerator nlg = new PreorderNodeListGenerator();
		DependencyNode rootDep = collectDependencies.getRoot();
		rootDep.accept(nlg);
		
		for (Dependency dependency : nlg.getDependencies(true)) {
			if (dependency.getScope().contentEquals("test")) {
				continue;
			}
//			LOGGER.info(dependency.getArtifact().getGroupId() + "." + dependency.getArtifact().getArtifactId());
			Artifact dependencyArtifact = dependency.getArtifact();
			PluginBundleIdentifier pluginBundleIdentifier = new PluginBundleIdentifier(dependencyArtifact.getGroupId(), dependencyArtifact.getArtifactId());
			if (pluginBundleIdentifierToPluginBundle.containsKey(pluginBundleIdentifier)) {
				if (strictDependencyChecking) {
					String version = dependencyArtifact.getVersion();
					if (!version.contains("[") && !version.contains("(")) {
						version = "[" + version + "]";
					}
					VersionRange versionRange = VersionRange.createFromVersionSpec(version);
					// String version =
					// pluginBundleIdentifierToPluginBundle.get(pluginBundleIdentifier).getPluginBundleVersion().getVersion();
					ArtifactVersion artifactVersion = new DefaultArtifactVersion(pluginBundleVersion);
					if (versionRange.containsVersion(artifactVersion)) {
						// OK
					} else {
						throw new Exception(
								"Required dependency " + pluginBundleIdentifier + " is installed, but it's version (" + pluginBundleVersion + ") does not comply to the required version (" + dependencyArtifact.getVersion() + ")");
					}
				} else {
					LOGGER.info("Skipping strict dependency checking for dependency " + dependencyArtifact.getArtifactId());
				}
			} else {
				try {
					if (dependencyArtifact.getGroupId().contentEquals("com.sun.xml.ws")) {
						continue;
					}
					MavenPluginLocation mavenPluginLocation = mavenPluginRepository.getPluginLocation(dependencyArtifact.getGroupId(), dependencyArtifact.getArtifactId());
					if (dependencyArtifact.getExtension().contentEquals("jar")) {
						Path depJarFile = mavenPluginLocation.getVersionJar(dependencyArtifact.getVersion());
						
						FileJarClassLoader jarClassLoader = new FileJarClassLoader(pluginManager, delegatingClassLoader, depJarFile);
						jarClassLoaders.add(jarClassLoader);
						delegatingClassLoader.add(jarClassLoader);
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("Required dependency " + pluginBundleIdentifier + " is not installed");
				}
			}
		}
	}
	
	public PluginBundle loadFromPluginDir(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, SPluginBundleVersion pluginBundleVersion, List<SPluginInformation> plugins, boolean strictDependencyChecking) throws Exception {
		Path target = pluginsDir.resolve(pluginBundleVersionIdentifier.getFileName());
		if (!Files.exists(target)) {
			throw new PluginException(target.toString() + " not found");
		}

		SPluginBundle sPluginBundle = new SPluginBundle();

		MavenXpp3Reader mavenreader = new MavenXpp3Reader();

		Model model = null;
		try (JarFile jarFile = new JarFile(target.toFile())) {
			ZipEntry entry = jarFile.getEntry("META-INF/maven/" + pluginBundleVersion.getGroupId() + "/" + pluginBundleVersion.getArtifactId() + "/pom.xml");
			try (InputStream inputStream = jarFile.getInputStream(entry)) {
				model = mavenreader.read(inputStream);
			}
		}
		sPluginBundle.setOrganization(model.getOrganization().getName());
		sPluginBundle.setName(model.getName());

		DelegatingClassLoader delegatingClassLoader = new DelegatingClassLoader(getClass().getClassLoader());

		loadDependencies(model.getVersion(), strictDependencyChecking, model, delegatingClassLoader);
		
		for (org.apache.maven.model.Dependency dependency : model.getDependencies()) {
			if (dependency.getGroupId().equals("org.opensourcebim") && (dependency.getArtifactId().equals("shared") || dependency.getArtifactId().equals("pluginbase") || dependency.getArtifactId().equals("ifcplugins"))) {
				// TODO Skip, we should also check the version though
			} else {
				PluginBundleIdentifier pluginBundleIdentifier = new PluginBundleIdentifier(dependency.getGroupId(), dependency.getArtifactId());
				if (pluginBundleIdentifierToPluginBundle.containsKey(pluginBundleIdentifier)) {
					if (strictDependencyChecking) {
						VersionRange versionRange = VersionRange.createFromVersion(dependency.getVersion());
						String version = pluginBundleIdentifierToPluginBundle.get(pluginBundleIdentifier).getPluginBundleVersion().getVersion();
						ArtifactVersion artifactVersion = new DefaultArtifactVersion(version);
						if (versionRange.containsVersion(artifactVersion)) {
							// OK
						} else {
							throw new Exception("Required dependency " + pluginBundleIdentifier + " is installed, but it's version (" + version + ") does not comply to the required version (" + dependency.getVersion() + ")");
						}
					} else {
						LOGGER.info("Skipping strict dependency checking for dependency " + dependency.getArtifactId());
					}
				} else {
					if (dependency.getGroupId().equals("org.opensourcebim") && (dependency.getArtifactId().equals("shared") || dependency.getArtifactId().equals("pluginbase"))) {
					} else {
						MavenPluginLocation mavenPluginLocation = mavenPluginRepository.getPluginLocation(dependency.getGroupId(), dependency.getArtifactId());

						try {
							Path depJarFile = mavenPluginLocation.getVersionJar(dependency.getVersion());

							FileJarClassLoader jarClassLoader = new FileJarClassLoader(pluginManager, delegatingClassLoader, depJarFile);
							jarClassLoaders.add(jarClassLoader);
							delegatingClassLoader.add(jarClassLoader);
						} catch (Exception e) {

						}
					}
				}
			}
		}
		return loadPlugin(pluginBundleVersionIdentifier, target, sPluginBundle, pluginBundleVersion, plugins, delegatingClassLoader);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PluginBundle loadPlugins(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, ResourceLoader resourceLoader, ClassLoader classLoader, URI location, String classLocation, PluginDescriptor pluginDescriptor,
			PluginSourceType pluginType, Set<org.bimserver.plugins.Dependency> dependencies, SPluginBundle sPluginBundle, SPluginBundleVersion sPluginBundleVersion) throws PluginException {
		sPluginBundle.setInstalledVersion(sPluginBundleVersion);
		PluginBundle pluginBundle = new PluginBundleImpl(pluginBundleVersionIdentifier, sPluginBundle, sPluginBundleVersion, pluginDescriptor);

		if (classLoader != null && classLoader instanceof Closeable) {
			pluginBundle.addCloseable((Closeable) classLoader);
		}

		for (AbstractPlugin pluginImplementation : pluginDescriptor.getPlugins()) {
			if (pluginImplementation instanceof JavaPlugin) {
				JavaPlugin javaPlugin = (JavaPlugin) pluginImplementation;
				String interfaceClassName = javaPlugin.getInterfaceClass().trim().replace("\n", "");
				try {
					Class interfaceClass = getClass().getClassLoader().loadClass(interfaceClassName);
					if (javaPlugin.getImplementationClass() != null) {
						String implementationClassName = javaPlugin.getImplementationClass().trim().replace("\n", "");
						try {
							Class implementationClass = classLoader.loadClass(implementationClassName);
							Plugin plugin = (Plugin) implementationClass.newInstance();
							pluginBundle.add(pluginManager.loadPlugin(pluginBundle, interfaceClass, location, classLocation, plugin, classLoader, pluginType, pluginImplementation, dependencies, plugin.getClass().getName()));
						} catch (NoClassDefFoundError e) {
							throw new PluginException("Implementation class '" + implementationClassName + "' not found", e);
						} catch (ClassNotFoundException e) {
							throw new PluginException("Implementation class '" + e.getMessage() + "' not found in " + location, e);
						} catch (InstantiationException e) {
							throw new PluginException(e);
						} catch (IllegalAccessException e) {
							throw new PluginException(e);
						}
					}
				} catch (ClassNotFoundException e) {
					throw new PluginException("Interface class '" + interfaceClassName + "' not found", e);
				} catch (Error e) {
					throw new PluginException(e);
				}
			} else if (pluginImplementation instanceof org.bimserver.plugins.WebModulePlugin) {
				org.bimserver.plugins.WebModulePlugin webModulePlugin = (org.bimserver.plugins.WebModulePlugin) pluginImplementation;
				JsonWebModule jsonWebModule = new JsonWebModule(webModulePlugin);
				pluginBundle.add(pluginManager.loadPlugin(pluginBundle, WebModulePlugin.class, location, classLocation, jsonWebModule, classLoader, pluginType, pluginImplementation, dependencies, webModulePlugin.getIdentifier()));
			}
		}
		pluginBundleIdentifierToPluginBundle.put(pluginBundleVersionIdentifier.getPluginBundleIdentifier(), pluginBundle);
		pluginBundleVersionIdentifierToPluginBundle.put(pluginBundleVersionIdentifier, pluginBundle);
		pluginBundleIdentifierToCurrentPluginBundleVersionIdentifier.put(pluginBundleVersionIdentifier.getPluginBundleIdentifier(), pluginBundleVersionIdentifier);

		return pluginBundle;
	}
	
	public PluginBundle loadPluginsFromJar(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, Path file, SPluginBundle sPluginBundle, SPluginBundleVersion pluginBundleVersion, ClassLoader parentClassLoader)
			throws PluginException {
		PluginBundleIdentifier pluginBundleIdentifier = pluginBundleVersionIdentifier.getPluginBundleIdentifier();
		if (pluginBundleIdentifierToPluginBundle.containsKey(pluginBundleIdentifier)) {
			throw new PluginException("Plugin " + pluginBundleIdentifier.getHumanReadable() + " already loaded (version " + pluginBundleIdentifierToPluginBundle.get(pluginBundleIdentifier).getPluginBundleVersion().getVersion() + ")");
		}
		LOGGER.debug("Loading plugins from " + file.toString());
		if (!Files.exists(file)) {
			throw new PluginException("Not a file: " + file.toString());
		}
		FileJarClassLoader jarClassLoader = null;
		try {
			jarClassLoader = new FileJarClassLoader(pluginManager, parentClassLoader, file);
			jarClassLoaders.add(jarClassLoader);
			final JarClassLoader finalLoader = jarClassLoader;
			URL resource = jarClassLoader.findResource("plugin/plugin.xml");
			if (resource == null) {
				throw new PluginException("No plugin/plugin.xml found in " + file.getFileName().toString());
			}
			PluginDescriptor pluginDescriptor = null;
			try (InputStream pluginStream = resource.openStream()) {
				pluginDescriptor = pluginManager.getPluginDescriptor(pluginStream);
				if (pluginDescriptor == null) {
					jarClassLoader.close();
					throw new PluginException("No plugin descriptor could be created");
				}
			}
			LOGGER.debug(pluginDescriptor.toString());

			URI fileUri = file.toAbsolutePath().toUri();
			URI jarUri = new URI("jar:" + fileUri.toString());

			ResourceLoader resourceLoader = new ResourceLoader() {
				@Override
				public InputStream load(String name) {
					return finalLoader.getResourceAsStream(name);
				}
			};

			return loadPlugins(pluginBundleVersionIdentifier, resourceLoader, jarClassLoader, jarUri, file.toAbsolutePath().toString(), pluginDescriptor, PluginSourceType.JAR_FILE, new HashSet<org.bimserver.plugins.Dependency>(),
					sPluginBundle, pluginBundleVersion);
		} catch (Exception e) {
			if (jarClassLoader != null) {
				try {
					jarClassLoader.close();
				} catch (IOException e1) {
					LOGGER.error("", e1);
				}
			}
			throw new PluginException(e);
		}
	}
	
	public PluginBundle loadJavaProject(Path projectRoot, Path pomFile, Path pluginFolder, PluginDescriptor pluginDescriptor, boolean resolveRemoteDependencies) throws PluginException, FileNotFoundException, IOException, XmlPullParserException {
		MavenXpp3Reader mavenreader = new MavenXpp3Reader();
		Model model = null;
		try (FileReader reader = new FileReader(pomFile.toFile())) {
			model = mavenreader.read(reader);
		}
		PluginBundleVersionIdentifier pluginBundleVersionIdentifier = new PluginBundleVersionIdentifier(model.getGroupId(), model.getArtifactId(), model.getVersion());

		if (pluginBundleIdentifierToPluginBundle.containsKey(pluginBundleVersionIdentifier.getPluginBundleIdentifier())) {
			throw new PluginException("Plugin " + pluginBundleVersionIdentifier.getPluginBundleIdentifier().getHumanReadable() + " already loaded (version "
					+ pluginBundleIdentifierToPluginBundle.get(pluginBundleVersionIdentifier.getPluginBundleIdentifier()).getPluginBundleVersion().getVersion() + ")");
		}
		DelegatingClassLoader delegatingClassLoader = new DelegatingClassLoader(getClass().getClassLoader());
		PublicFindClassClassLoader previous = new PublicFindClassClassLoader(getClass().getClassLoader()) {
			@Override
			public Class<?> findClass(String name) throws ClassNotFoundException {
				return null;
			}

			@Override
			public URL findResource(String name) {
				return null;
			}

			@Override
			public void dumpStructure(int indent) {
			}
		};

		Set<org.bimserver.plugins.Dependency> bimServerDependencies = new HashSet<>();

		pluginBundleVersionIdentifier = new PluginBundleVersionIdentifier(new PluginBundleIdentifier(model.getGroupId(), model.getArtifactId()), model.getVersion());

		previous = loadDependencies(bimServerDependencies, model, previous, resolveRemoteDependencies);
		delegatingClassLoader.add(previous);

		// Path libFolder = projectRoot.resolve("lib");
		// loadDependencies(libFolder, delegatingClassLoader);
		EclipsePluginClassloader pluginClassloader = new EclipsePluginClassloader(delegatingClassLoader, projectRoot);
		// pluginClassloader.dumpStructure(0);

		ResourceLoader resourceLoader = new ResourceLoader() {
			@Override
			public InputStream load(String name) {
				try {
					return Files.newInputStream(pluginFolder.resolve(name));
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
		};

		SPluginBundle sPluginBundle = new SPluginBundle();
		if (model.getOrganization() == null) {
			throw new PluginException("Plugis are required to have an organization in the pom.xml file");
		}
		sPluginBundle.setOrganization(model.getOrganization().getName());
		sPluginBundle.setName(model.getName());

		SPluginBundleVersion sPluginBundleVersion = createPluginBundleVersionFromMavenModel(model, true);

		Path icon = projectRoot.resolve("icon.png");
		if (Files.exists(icon)) {
			byte[] iconBytes = Files.readAllBytes(icon);
			sPluginBundleVersion.setIcon(iconBytes);
		}

		sPluginBundle.setInstalledVersion(sPluginBundleVersion);

		return loadPlugins(pluginBundleVersionIdentifier, resourceLoader, pluginClassloader, projectRoot.toUri(), projectRoot.resolve("target/classes").toString(), pluginDescriptor, PluginSourceType.ECLIPSE_PROJECT, bimServerDependencies,
				sPluginBundle, sPluginBundleVersion);
	}
	
	public PluginBundle loadPluginsFromEclipseProject(Path projectRoot) throws PluginException {
		try {
			if (!Files.isDirectory(projectRoot)) {
				throw new PluginException("No directory: " + projectRoot.toString());
			}
			final Path pluginFolder = projectRoot.resolve("plugin");
			if (!Files.isDirectory(pluginFolder)) {
				throw new PluginException("No 'plugin' directory found in " + projectRoot.toString());
			}
			Path pluginFile = pluginFolder.resolve("plugin.xml");
			if (!Files.exists(pluginFile)) {
				throw new PluginException("No 'plugin.xml' found in " + pluginFolder.toString());
			}

			PluginDescriptor pluginDescriptor = null;
			try (InputStream newInputStream = Files.newInputStream(pluginFile)) {
				pluginDescriptor = pluginManager.getPluginDescriptor(newInputStream);
			}

			Path pomFile = projectRoot.resolve("pom.xml");
			if (!Files.exists(pomFile)) {
				throw new PluginException("No pom.xml found in " + projectRoot);
			}
			// Path packageFile = projectRoot.resolve("package.json");

			// if (Files.exists(packageFile)) {
			// return loadJavaScriptProject(projectRoot, packageFile,
			// pluginFolder, pluginDescriptor);
			// } else if (Files.exists(pomFile)) {
			PluginBundle pluginBundle = loadJavaProject(projectRoot, pomFile, pluginFolder, pluginDescriptor, false);
			// } else {
			// throw new PluginException("No pom.xml or package.json found in "
			// + projectRoot.toString());
			// }

			List<SPluginInformation> plugins = new ArrayList<>();
			pluginManager.processPluginDescriptor(pluginDescriptor, plugins);

			for (SPluginInformation sPluginInformation : plugins) {
				if (sPluginInformation.isEnabled()) {
					// For local plugins, we assume to install for all users
					sPluginInformation.setInstallForAllUsers(true);
					sPluginInformation.setInstallForNewUsers(true);

					PluginContext pluginContext = pluginBundle.getPluginContext(sPluginInformation.getIdentifier());
					if (pluginContext == null) {
						throw new PluginException("No plugin context found for " + sPluginInformation.getIdentifier());
					}
				}
			}

			try {
				long pluginBundleVersionId = pluginManager.pluginBundleInstalled(pluginBundle);
				for (SPluginInformation sPluginInformation : plugins) {
					if (sPluginInformation.isEnabled()) {
						PluginContext pluginContext = pluginBundle.getPluginContext(sPluginInformation.getIdentifier());
//						PluginConfiguration pluginConfiguration = PluginConfiguration.fromDefaults(pluginContext.getPlugin().getSystemSettingsDefinition());
//						pluginContext.initialize(pluginConfiguration);
						pluginManager.pluginInstalled(pluginBundleVersionId, pluginContext, sPluginInformation);
					}
				}
			} catch (Exception e) {
				LOGGER.error("", e);
				throw new PluginException(e);
			}
			return pluginBundle;
		} catch (JAXBException e) {
			throw new PluginException(e);
		} catch (FileNotFoundException e) {
			throw new PluginException(e);
		} catch (IOException e) {
			throw new PluginException(e);
		} catch (XmlPullParserException e) {
			throw new PluginException(e);
		}
	}
	
	private PublicFindClassClassLoader loadDependencies(Set<org.bimserver.plugins.Dependency> bimServerDependencies, Model model, PublicFindClassClassLoader previous, boolean resolveRemoteDependencies) throws FileNotFoundException, IOException {
		List<org.apache.maven.model.Dependency> dependencies = model.getDependencies();
		Iterator<org.apache.maven.model.Dependency> it = dependencies.iterator();

		Path workspaceDir = Paths.get("..");
		bimServerDependencies.add(new org.bimserver.plugins.Dependency(workspaceDir.resolve("PluginBase/target/classes")));
		bimServerDependencies.add(new org.bimserver.plugins.Dependency(workspaceDir.resolve("Shared/target/classes")));

		while (it.hasNext()) {
			org.apache.maven.model.Dependency depend = it.next();
			try {
				if (depend.getGroupId().equals("org.opensourcebim") && (depend.getArtifactId().equals("shared") || depend.getArtifactId().equals("pluginbase") || depend.getArtifactId().equals("ifcplugins"))) {
					// Skip this one, because we have already
					// TODO we might want to check the version though
					continue;
				}
				if (depend.isOptional() || "test".equals(depend.getScope())) {
					continue;
				}
				Dependency dependency2 = new Dependency(new DefaultArtifact(depend.getGroupId() + ":" + depend.getArtifactId() + ":jar:" + depend.getVersion()), "compile");
				DelegatingClassLoader depDelLoader = new DelegatingClassLoader(previous);

				if (!dependency2.getArtifact().isSnapshot()) {
					if (dependency2.getArtifact().getFile() != null) {
						bimServerDependencies.add(new org.bimserver.plugins.Dependency(dependency2.getArtifact().getFile().toPath()));
						loadDependencies(dependency2.getArtifact().getFile().toPath(), depDelLoader);
					} else {
						ArtifactRequest request = new ArtifactRequest();
						request.setArtifact(dependency2.getArtifact());
						request.setRepositories(resolveRemoteDependencies ? mavenPluginRepository.getRepositoriesAsList() : mavenPluginRepository.getLocalRepositories());
						try {
							ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
							if (resolveArtifact.getArtifact().getFile() != null) {
								bimServerDependencies.add(new org.bimserver.plugins.Dependency(resolveArtifact.getArtifact().getFile().toPath()));
								loadDependencies(resolveArtifact.getArtifact().getFile().toPath(), depDelLoader);
							} else {
								// TODO error?
							}
						} catch (ArtifactResolutionException e) {
							LOGGER.error(model.getGroupId() + "." + model.getArtifactId(), e);
						}
					}
				} else {
					// Snapshot projects linked in Eclipse
					ArtifactRequest request = new ArtifactRequest();
					if ((!"test".equals(dependency2.getScope()) && !dependency2.getArtifact().isSnapshot())) {
						request.setArtifact(dependency2.getArtifact());
						request.setRepositories(mavenPluginRepository.getLocalRepositories());
						try {
							ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
							if (resolveArtifact.getArtifact().getFile() != null) {
								bimServerDependencies.add(new org.bimserver.plugins.Dependency(resolveArtifact.getArtifact().getFile().toPath()));
								loadDependencies(resolveArtifact.getArtifact().getFile().toPath(), depDelLoader);
							} else {
								// TODO error?
							}
						} catch (Exception e) {
							LOGGER.info(dependency2.getArtifact().toString());
							e.printStackTrace();
						}

						// bimServerDependencies.add(new
						// org.bimserver.plugins.Dependency(resolveArtifact.getArtifact().getFile().toPath()));
					}
				}
				ArtifactDescriptorRequest descriptorRequest = new ArtifactDescriptorRequest();
				descriptorRequest.setArtifact(dependency2.getArtifact());
				descriptorRequest.setRepositories(mavenPluginRepository.getRepositoriesAsList());
				ArtifactDescriptorResult descriptorResult = mavenPluginRepository.getSystem().readArtifactDescriptor(mavenPluginRepository.getSession(), descriptorRequest);

				CollectRequest collectRequest = new CollectRequest();
				collectRequest.setRootArtifact(descriptorResult.getArtifact());
				collectRequest.setDependencies(descriptorResult.getDependencies());
				collectRequest.setManagedDependencies(descriptorResult.getManagedDependencies());
				collectRequest.setRepositories(descriptorResult.getRepositories());
				DependencyNode node = mavenPluginRepository.getSystem().collectDependencies(mavenPluginRepository.getSession(), collectRequest).getRoot();

				DependencyRequest dependencyRequest = new DependencyRequest();
				dependencyRequest.setRoot(node);

				CollectResult collectResult = mavenPluginRepository.getSystem().collectDependencies(mavenPluginRepository.getSession(), collectRequest);

				PreorderNodeListGenerator nlg = new PreorderNodeListGenerator();
				// collectResult.getRoot().accept(new
				// ConsoleDependencyGraphDumper());
				collectResult.getRoot().accept(nlg);

				try {
					mavenPluginRepository.getSystem().resolveDependencies(mavenPluginRepository.getSession(), dependencyRequest);
				} catch (DependencyResolutionException e) {
					// Ignore
				}

				for (DependencyNode dependencyNode : nlg.getNodes()) {
					ArtifactRequest newRequest = new ArtifactRequest(dependencyNode);
					newRequest.setRepositories(mavenPluginRepository.getRepositoriesAsList());
					ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), newRequest);

					Artifact artifact = resolveArtifact.getArtifact();
					Path jarFile = Paths.get(artifact.getFile().getAbsolutePath());

					loadDependencies(jarFile, depDelLoader);

					Artifact versionArtifact = new DefaultArtifact(artifact.getGroupId(), artifact.getArtifactId(), "pom", artifact.getVersion());

					ArtifactRequest request = new ArtifactRequest();
					request.setArtifact(versionArtifact);
					request.setRepositories(mavenPluginRepository.getRepositoriesAsList());

					// try {
					// ArtifactResult resolveArtifact =
					// mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(),
					// request);
					// File depPomFile =
					// resolveArtifact.getArtifact().getFile();
					// if (depPomFile != null) {
					// MavenXpp3Reader mavenreader = new MavenXpp3Reader();
					// Model depModel = null;
					// try (FileReader reader = new FileReader(depPomFile)) {
					// try {
					// depModel = mavenreader.read(reader);
					// } catch (XmlPullParserException e) {
					// e.printStackTrace();
					// }
					// }
					// previous = loadDependencies(bimServerDependencies,
					// depModel, previous);
					// } else {
					// LOGGER.info("Artifact not found " + versionArtifact);
					// }
					// } catch (ArtifactResolutionException e1) {
					// LOGGER.error(e1.getMessage());
					// }

					// EclipsePluginClassloader depLoader = new
					// EclipsePluginClassloader(depDelLoader, projectRoot);

					bimServerDependencies.add(new org.bimserver.plugins.Dependency(jarFile));

				}
				previous = depDelLoader;
			} catch (DependencyCollectionException e) {
				e.printStackTrace();
			} catch (ArtifactDescriptorException e2) {
				e2.printStackTrace();
			} catch (ArtifactResolutionException e) {
				e.printStackTrace();
			}
		}
		return previous;
	}
	

	private void loadDependencies(Path libFile, DelegatingClassLoader classLoader) throws FileNotFoundException, IOException {
		if (libFile.getFileName().toString().toLowerCase().endsWith(".jar")) {
			FileJarClassLoader jarClassLoader = new FileJarClassLoader(pluginManager, classLoader, libFile);
			jarClassLoaders.add(jarClassLoader);
			classLoader.add(jarClassLoader);
		}
	}
	
	public void loadPluginsFromEclipseProjectNoExceptions(Path projectRoot) {
		try {
			loadPluginsFromEclipseProject(projectRoot);
		} catch (PluginException e) {
			LOGGER.error("", e);
		}
	}
	

	public void loadAllPluginsFromEclipseWorkspace(Path file, boolean showExceptions) throws PluginException, IOException {
		if (file != null && Files.isDirectory(file)) {
			for (Path project : PathUtils.list(file)) {
				if (Files.isDirectory(project)) {
					Path pluginDir = project.resolve("plugin");
					if (Files.exists(pluginDir)) {
						Path pluginFile = pluginDir.resolve("plugin.xml");
						if (Files.exists(pluginFile)) {
							if (showExceptions) {
								loadPluginsFromEclipseProject(project);
							} else {
								loadPluginsFromEclipseProjectNoExceptions(project);
							}
						}
					}
				}
			}
		}
	}

	public void loadAllPluginsFromEclipseWorkspaces(Path directory, boolean showExceptions) throws PluginException, IOException {
		if (!Files.isDirectory(directory)) {
			return;
		}
		if (Files.exists(directory.resolve("plugin/plugin.xml"))) {
			if (showExceptions) {
				loadPluginsFromEclipseProject(directory);
			} else {
				loadPluginsFromEclipseProjectNoExceptions(directory);
			}
		}
		loadAllPluginsFromEclipseWorkspace(directory, showExceptions);
		for (Path workspace : PathUtils.list(directory)) {
			if (Files.isDirectory(workspace)) {
				loadAllPluginsFromEclipseWorkspace(workspace, showExceptions);
			}
		}
	}
	
	public PluginBundle loadPlugin(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, Path target, SPluginBundle sPluginBundle, SPluginBundleVersion pluginBundleVersion, List<SPluginInformation> plugins,
			ClassLoader parentClassLoader) throws Exception {
		PluginBundle pluginBundle = null;
		// Stage 1, load all plugins from the JAR file and initialize them
		try {
			pluginBundle = loadPluginsFromJar(pluginBundleVersionIdentifier, target, sPluginBundle, pluginBundleVersion, parentClassLoader);
			if (plugins.isEmpty()) {
				LOGGER.warn("No plugins given to install for bundle " + sPluginBundle.getName());
			}
			for (SPluginInformation sPluginInformation : plugins) {
				if (sPluginInformation.isEnabled()) {
					PluginContext pluginContext = pluginBundle.getPluginContext(sPluginInformation.getIdentifier());
					if (pluginContext == null) {
						LOGGER.info("No plugin context found for " + sPluginInformation.getIdentifier());
					} else {
						PluginConfiguration pluginConfiguration = PluginConfiguration.fromDefaults(pluginContext.getPlugin().getSystemSettingsDefinition());
						pluginContext.initialize(pluginConfiguration);
					}
				}
			}
		} catch (Exception e) {
			if (pluginBundle != null) {
				pluginBundle.close();
			}
			pluginBundleVersionIdentifierToPluginBundle.remove(pluginBundleVersionIdentifier);
			pluginBundleIdentifierToPluginBundle.remove(pluginBundleVersionIdentifier.getPluginBundleIdentifier());
			Files.deleteIfExists(target);
			throw e;
		}
		// Stage 2, if all went well, notify the listeners of this plugin, if
		// anything goes wrong in the notifications, the plugin bundle will be
		// uninstalled
		try {
			long pluginBundleVersionId = pluginManager.pluginBundleInstalled(pluginBundle);
			for (SPluginInformation sPluginInformation : plugins) {
				if (sPluginInformation.isEnabled()) {
					PluginContext pluginContext = pluginBundle.getPluginContext(sPluginInformation.getIdentifier());
					if (pluginContext != null) {
						pluginManager.pluginInstalled(pluginBundleVersionId, pluginContext, sPluginInformation);
					}
				}
			}
			return pluginBundle;
		} catch (Exception e) {
			uninstall(pluginBundleVersionIdentifier);
			LOGGER.error("", e);
			throw e;
		}
	}

	public void uninstall(PluginBundleVersionIdentifier pluginBundleVersionIdentifier) {
		PluginBundle pluginBundle = pluginBundleVersionIdentifierToPluginBundle.get(pluginBundleVersionIdentifier);
		if (pluginBundle == null) {
			return;
		}
		try {
			pluginBundle.close();
			pluginBundleVersionIdentifierToPluginBundle.remove(pluginBundleVersionIdentifier);
			pluginBundleIdentifierToPluginBundle.remove(pluginBundleVersionIdentifier.getPluginBundleIdentifier());
			pluginBundleIdentifierToCurrentPluginBundleVersionIdentifier.remove(pluginBundleVersionIdentifier.getPluginBundleIdentifier());

			for (PluginContext pluginContext : pluginBundle) {
				pluginManager.removeImplementation(pluginContext);
			}

			Path target = pluginsDir.resolve(pluginBundleVersionIdentifier.getFileName());
			Files.delete(target);

			for (PluginContext pluginContext : pluginBundle) {
				pluginManager.pluginUninstalled(pluginContext);
			}
			pluginManager.pluginBundleUninstalled(pluginBundle);

		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public PluginBundle update(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, SPluginBundle sPluginBundle, SPluginBundleVersion pluginBundleVersion, Path jarFile, Path pomFile, List<SPluginInformation> plugins)
			throws Exception {
		PluginBundle existingPluginBundle = pluginBundleIdentifierToPluginBundle.get(pluginBundleVersionIdentifier.getPluginBundleIdentifier());
		if (existingPluginBundle == null) {
			throw new UserException("No previous version of plugin bundle " + pluginBundleVersionIdentifier.getPluginBundleIdentifier() + " found");
		}
		try {
			existingPluginBundle.close();

			if (pluginBundleIdentifierToPluginBundle.remove(pluginBundleVersionIdentifier.getPluginBundleIdentifier()) == null) {
				LOGGER.warn("Previous version of " + pluginBundleVersionIdentifier.getPluginBundleIdentifier() + " not found");
			}
			PluginBundleVersionIdentifier currentVersion = pluginBundleIdentifierToCurrentPluginBundleVersionIdentifier.get(pluginBundleVersionIdentifier.getPluginBundleIdentifier());
			if (pluginBundleIdentifierToCurrentPluginBundleVersionIdentifier.remove(pluginBundleVersionIdentifier.getPluginBundleIdentifier()) == null) {
				LOGGER.warn("Previous version of " + pluginBundleVersionIdentifier.getPluginBundleIdentifier() + " not found");
			}
			if (pluginBundleVersionIdentifierToPluginBundle.remove(currentVersion) == null) {
				LOGGER.warn("Previous version (" + currentVersion + ") of " + pluginBundleVersionIdentifier.getPluginBundleIdentifier() + " not found");
			}

			for (PluginContext pluginContext : existingPluginBundle) {
				pluginManager.removeImplementation(pluginContext);
			}

			// TODO in case the update fails (new plugin does not load successfully), we need to be able to replace the removed file... So we should not remove it here but rename it and then remove it later on
			
			if (existingPluginBundle.getPluginBundle().getInstalledVersion().getType() == SPluginBundleType.MAVEN) {
				Path target = pluginsDir.resolve(currentVersion.getFileName());
				Files.delete(target);
			}

			// for (PluginContext pluginContext : existingPluginBundle) {
			// pluginChangeListener.pluginUninstalled(pluginContext);
			// }
		} catch (IOException e) {
			LOGGER.error("", e);
		}

		Path target = pluginsDir.resolve(pluginBundleVersionIdentifier.getFileName());
		if (Files.exists(target)) {
			throw new PluginException("This plugin has already been installed " + target.getFileName().toString());
		}
		Files.copy(jarFile, target);

		MavenXpp3Reader mavenreader = new MavenXpp3Reader();

		Model model = null;
		try (FileReader fileReader = new FileReader(pomFile.toFile())) {
			model = mavenreader.read(fileReader);
		}

		DelegatingClassLoader delegatingClassLoader = new DelegatingClassLoader(getClass().getClassLoader());

		for (org.apache.maven.model.Dependency dependency : model.getDependencies()) {
			if (dependency.getGroupId().equals("org.opensourcebim") && (dependency.getArtifactId().equals("shared") || dependency.getArtifactId().equals("pluginbase"))) {
				// TODO Skip, we should also check the version though
			} else {
				PluginBundleIdentifier pluginBundleIdentifier = new PluginBundleIdentifier(dependency.getGroupId(), dependency.getArtifactId());
				if (pluginBundleIdentifierToPluginBundle.containsKey(pluginBundleIdentifier)) {
					// if (false) {
					// VersionRange versionRange =
					// VersionRange.createFromVersion(dependency.getVersion());
					// String version =
					// pluginBundleIdentifierToPluginBundle.get(pluginBundleIdentifier).getPluginBundleVersion().getVersion();
					// ArtifactVersion artifactVersion = new
					// DefaultArtifactVersion(version);
					// if (versionRange.containsVersion(artifactVersion)) {
					// // OK
					// } else {
					// throw new Exception("Required dependency " +
					// pluginBundleIdentifier + " is installed, but it's version
					// (" + version + ") does not comply to the required version
					// (" + dependency.getVersion() + ")");
					// }
					// } else {
					LOGGER.info("Skipping strict dependency checking for dependency " + dependency.getArtifactId());
					// }
				} else {
					if (dependency.getGroupId().equals("org.opensourcebim") && (dependency.getArtifactId().equals("shared") || dependency.getArtifactId().equals("pluginbase"))) {
						throw new Exception("Required dependency " + pluginBundleIdentifier + " is not installed");
					} else {
						MavenPluginLocation mavenPluginLocation = mavenPluginRepository.getPluginLocation(model.getRepositories().get(0).getUrl(), dependency.getGroupId(), dependency.getArtifactId());

						try {
							Path depJarFile = mavenPluginLocation.getVersionJar(dependency.getVersion());

							FileJarClassLoader jarClassLoader = new FileJarClassLoader(pluginManager, delegatingClassLoader, depJarFile);
							jarClassLoaders.add(jarClassLoader);
							delegatingClassLoader.add(jarClassLoader);
						} catch (Exception e) {

						}
					}
				}
			}
		}

		PluginBundle pluginBundle = null;
		// Stage 1, load all plugins from the JAR file and initialize them
		try {
			pluginBundle = loadPluginsFromJar(pluginBundleVersionIdentifier, target, sPluginBundle, pluginBundleVersion, delegatingClassLoader);

			for (SPluginInformation sPluginInformation : plugins) {
				if (sPluginInformation.isEnabled()) {
					PluginContext pluginContext = pluginBundle.getPluginContext(sPluginInformation.getIdentifier());
					PluginContext previousContext = existingPluginBundle.getPluginContext(pluginContext.getIdentifier());
					// TODO when there was no previous plugin (new plugin in bundle for example), we should use the default system settings of the particular plugin... not null
					pluginContext.getPlugin().init(pluginContext, previousContext == null ? null : previousContext.getSystemSettings());
				}
			}
		} catch (Exception e) {
			Files.delete(target);
			LOGGER.error("", e);
			throw e;
		}
		// Stage 2, if all went well, notify the listeners of this plugin, if
		// anything goes wrong in the notifications, the plugin bundle will be
		// uninstalled
		try {
			long pluginBundleVersionId = pluginManager.pluginBundleUpdated(pluginBundle);

			for (SPluginInformation sPluginInformation : plugins) {
				if (sPluginInformation.isEnabled()) {
					PluginContext pluginContext = pluginBundle.getPluginContext(sPluginInformation.getIdentifier());
					pluginManager.pluginUpdated(pluginBundleVersionId, pluginContext, sPluginInformation);
				}
			}
			return pluginBundle;
		} catch (Exception e) {
			uninstall(pluginBundleVersionIdentifier);
			LOGGER.error("", e);
			throw e;
		}
	}

	public PluginBundle getPluginBundle(PluginBundleIdentifier pluginIdentifier) {
		return pluginBundleIdentifierToPluginBundle.get(pluginIdentifier);
	}

	public Collection<PluginBundle> getPluginBundles() {
		return pluginBundleVersionIdentifierToPluginBundle.values();
	}
	
	public void close() {
		for (FileJarClassLoader fileJarClassLoader : jarClassLoaders) {
			try {
				fileJarClassLoader.close();
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
	}
	
	private SPluginBundleVersion createPluginBundleVersionFromMavenModel(Model model, boolean isLocalDev) {
		SPluginBundleVersion sPluginBundleVersion = new SPluginBundleVersion();
		sPluginBundleVersion.setType(isLocalDev ? SPluginBundleType.LOCAL_DEV : SPluginBundleType.MAVEN);
		sPluginBundleVersion.setGroupId(model.getGroupId());
		sPluginBundleVersion.setArtifactId(model.getArtifactId());
		sPluginBundleVersion.setVersion(model.getVersion());
		sPluginBundleVersion.setDescription(model.getDescription());
		sPluginBundleVersion.setRepository("local");
		sPluginBundleVersion.setMismatch(false); // TODO
		sPluginBundleVersion.setOrganization(model.getOrganization().getName());
		sPluginBundleVersion.setName(model.getName());
		return sPluginBundleVersion;
	}
	

	public SPluginBundle extractPluginBundleFromJar(Path jarFilePath) throws PluginException {
		String filename = jarFilePath.getFileName().toString();
		PluginBundleVersionIdentifier pluginBundleVersionIdentifier = PluginBundleVersionIdentifier.fromFileName(filename);
		try (JarFile jarFile = new JarFile(jarFilePath.toFile())) {
			String pomLocation = "META-INF/maven/" + pluginBundleVersionIdentifier.getPluginBundleIdentifier().getGroupId() + "/" + pluginBundleVersionIdentifier.getPluginBundleIdentifier().getArtifactId() + "/" + "pom.xml";
			ZipEntry pomEntry = jarFile.getEntry(pomLocation);
			if (pomEntry == null) {
				throw new PluginException("No pom.xml found in JAR file " + jarFilePath.toString() + ", " + pomLocation);
			}
			MavenXpp3Reader mavenreader = new MavenXpp3Reader();

			Model model = mavenreader.read(jarFile.getInputStream(pomEntry));
			SPluginBundle sPluginBundle = new SPluginBundle();
			sPluginBundle.setOrganization(model.getOrganization().getName());
			sPluginBundle.setName(model.getName());
			return sPluginBundle;
		} catch (IOException e) {
			throw new PluginException(e);
		} catch (XmlPullParserException e) {
			throw new PluginException(e);
		}
	}
}