package org.bimserver.plugins;

import java.io.ByteArrayInputStream;
import java.io.Closeable;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.artifact.versioning.VersionRange;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.Schema;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleType;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.bimserver.interfaces.objects.SPluginInformation;
import org.bimserver.interfaces.objects.SPluginType;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.classloaders.DelegatingClassLoader;
import org.bimserver.plugins.classloaders.EclipsePluginClassloader;
import org.bimserver.plugins.classloaders.FileJarClassLoader;
import org.bimserver.plugins.classloaders.JarClassLoader;
import org.bimserver.plugins.classloaders.PublicFindClassClassLoader;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.StreamingDeserializerPlugin;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;
import org.bimserver.plugins.modelmerger.ModelMergerPlugin;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.MessagingSerializerPlugin;
import org.bimserver.plugins.serializers.MessagingStreamingSerializerPlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewExtendedDataOnProjectHandler;
import org.bimserver.plugins.services.NewExtendedDataOnRevisionHandler;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.plugins.stillimagerenderer.StillImageRenderPlugin;
import org.bimserver.plugins.web.WebModulePlugin;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.utils.FakeClosingInputStream;
import org.bimserver.utils.PathUtils;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.collection.CollectRequest;
import org.eclipse.aether.collection.DependencyCollectionException;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.graph.DependencyNode;
import org.eclipse.aether.resolution.ArtifactRequest;
import org.eclipse.aether.resolution.ArtifactResolutionException;
import org.eclipse.aether.resolution.ArtifactResult;
import org.eclipse.aether.resolution.DependencyRequest;
import org.eclipse.aether.resolution.DependencyResolutionException;
import org.eclipse.aether.util.graph.visitor.PreorderNodeListGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PluginManager implements PluginManagerInterface {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final Logger LOGGER = LoggerFactory.getLogger(PluginManager.class);
	private final Map<Class<? extends Plugin>, Set<PluginContext>> implementations = new LinkedHashMap<>();
	private final Map<Plugin, PluginContext> pluginToPluginContext = new HashMap<>();
	
	private final Map<PluginBundleIdentifier, PluginBundle> pluginBundleIdentifierToPluginBundle = new HashMap<>();
	private final Map<PluginBundleVersionIdentifier, PluginBundle> pluginBundleVersionIdentifierToPluginBundle = new HashMap<>();
	private final Map<PluginBundleIdentifier, PluginBundleVersionIdentifier> pluginBundleIdentifierToCurrentPluginBundleVersionIdentifier = new HashMap<>();
	
	private final Path tempDir;
	private final String baseClassPath;
	private final ServiceFactory serviceFactory;
	private final NotificationsManagerInterface notificationsManagerInterface;
	private final SServicesMap servicesMap;
	private final Path pluginsDir;
	private PluginChangeListener pluginChangeListener;
	private BimServerClientFactory bimServerClientFactory;
	private MetaDataManager metaDataManager;
	private MavenPluginRepository mavenPluginRepository;
	private final List<FileJarClassLoader> jarClassLoaders = new ArrayList<>();

	public PluginManager(Path tempDir, Path pluginsDir, MavenPluginRepository mavenPluginRepository, String baseClassPath, ServiceFactory serviceFactory, NotificationsManagerInterface notificationsManagerInterface, SServicesMap servicesMap) {
		this.mavenPluginRepository = mavenPluginRepository;
		LOGGER.debug("Creating new PluginManager");
		this.pluginsDir = pluginsDir;
		this.tempDir = tempDir;
		this.baseClassPath = baseClassPath;
		this.serviceFactory = serviceFactory;
		this.notificationsManagerInterface = notificationsManagerInterface;
		this.servicesMap = servicesMap;

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
	
//	public void installLocalPlugins() {
//		if (pluginsDir != null) {
//			if (!Files.isDirectory(pluginsDir)) {
//				try {
//					Files.createDirectories(pluginsDir);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			} else {
//				try {
//					for (Path file : PathUtils.list(pluginsDir)) {
//						try {
//							PluginBundleVersionIdentifier pluginBundleVersionIdentifier = PluginBundleVersionIdentifier.fromFileName(file.getFileName().toString());
//							SPluginBundle extractPluginBundleFromJar = extractPluginBundleFromJar(file);
//							install(pluginBundleVersionIdentifier, pluginBundleVersionIdentifier.getPluginBundleIdentifier(), pluginBundleVersionIdentifier, file, pomFile, plugins, false);
////							loadPluginsFromJar(pluginBundleVersionIdentifier, file, extractPluginBundleFromJar(file), extractPluginBundleVersionFromJar(file));
//							LOGGER.info("Loading " + pluginBundleVersionIdentifier.getHumanReadable());
//						} catch (PluginException e) {
//							LOGGER.error("", e);
//						}
//					}
//				} catch (IOException e) {
//					LOGGER.error("", e);
//				}
//			}
//		}
//	}

	public void loadPluginsFromEclipseProjectNoExceptions(Path projectRoot) {
		try {
			loadPluginsFromEclipseProject(projectRoot);
		} catch (PluginException e) {
			LOGGER.error("", e);
		}
	}

	public PluginBundle loadJavaProject(Path projectRoot, Path pomFile, Path pluginFolder, PluginDescriptor pluginDescriptor) throws PluginException, FileNotFoundException, IOException, XmlPullParserException {
		MavenXpp3Reader mavenreader = new MavenXpp3Reader();
		Model model = null;
		try (FileReader reader = new FileReader(pomFile.toFile())) {
			model = mavenreader.read(reader);
		}
		PluginBundleVersionIdentifier pluginBundleVersionIdentifier = new PluginBundleVersionIdentifier(model.getGroupId(), model.getArtifactId(), model.getVersion());
		
		if (pluginBundleIdentifierToPluginBundle.containsKey(pluginBundleVersionIdentifier.getPluginBundleIdentifier())) {
			throw new PluginException("Plugin " + pluginBundleVersionIdentifier.getPluginBundleIdentifier().getHumanReadable() + " already loaded (version " + pluginBundleIdentifierToPluginBundle.get(pluginBundleVersionIdentifier.getPluginBundleIdentifier()).getPluginBundleVersion().getVersion() + ")");
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
		
		List<org.apache.maven.model.Dependency> dependencies = model.getDependencies();
		Iterator<org.apache.maven.model.Dependency> it = dependencies.iterator();

		Path workspaceDir = Paths.get("..");
		bimServerDependencies.add(new org.bimserver.plugins.Dependency(workspaceDir.resolve("PluginBase/target/classes")));
		bimServerDependencies.add(new org.bimserver.plugins.Dependency(workspaceDir.resolve("Shared/target/classes")));

		while (it.hasNext()) {
			org.apache.maven.model.Dependency depend = it.next();
			try {
				if (depend.getGroupId().equals("org.opensourcebim") && (depend.getArtifactId().equals("shared") || depend.getArtifactId().equals("pluginbase"))) {
					// Skip this one, because we have already
					// TODO we might want to check the version though
					continue;
				}
				Dependency dependency2 = new Dependency(new DefaultArtifact(depend.getGroupId() + ":" + depend.getArtifactId() + ":jar:" + depend.getVersion()), "compile");

				if (!dependency2.getArtifact().isSnapshot()) {
					if (dependency2.getArtifact().getFile() != null) {
						bimServerDependencies.add(new org.bimserver.plugins.Dependency(dependency2.getArtifact().getFile().toPath()));
					} else {
						ArtifactRequest request = new ArtifactRequest();
						request.setArtifact(dependency2.getArtifact());
						request.setRepositories(mavenPluginRepository.getRepositories());
						try {
							ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
							if (resolveArtifact.getArtifact().getFile() != null) {
								bimServerDependencies.add(new org.bimserver.plugins.Dependency(resolveArtifact.getArtifact().getFile().toPath()));
							} else {
								// TODO error?
							}
						} catch (ArtifactResolutionException e) {
							e.printStackTrace();
						}
					}
				} else {
					// Snapshot projects linked in Eclipse
					ArtifactRequest request = new ArtifactRequest();
					if (!depend.getScope().equals("test")) {
						request.setArtifact(dependency2.getArtifact());
						request.setRepositories(mavenPluginRepository.getLocalRepositories());
						try {
							ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
							if (resolveArtifact.getArtifact().getFile() != null) {
								bimServerDependencies.add(new org.bimserver.plugins.Dependency(resolveArtifact.getArtifact().getFile().toPath()));
							} else {
								// TODO error?
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						
//					bimServerDependencies.add(new org.bimserver.plugins.Dependency(resolveArtifact.getArtifact().getFile().toPath()));
					}
				}
				
				CollectRequest collectRequest = new CollectRequest();
				collectRequest.setRoot(dependency2);
				DependencyNode node = mavenPluginRepository.getSystem().collectDependencies(mavenPluginRepository.getSession(), collectRequest).getRoot();

				DependencyRequest dependencyRequest = new DependencyRequest();
				dependencyRequest.setRoot(node);

				try {
					mavenPluginRepository.getSystem().resolveDependencies(mavenPluginRepository.getSession(), dependencyRequest);
				} catch (DependencyResolutionException e) {
					// Ignore
				}

				PreorderNodeListGenerator nlg = new PreorderNodeListGenerator();
				node.accept(nlg);

				DelegatingClassLoader depDelLoader = new DelegatingClassLoader(previous);
				for (Artifact artifact : nlg.getArtifacts(false)) {
					Path jarFile = Paths.get(artifact.getFile().getAbsolutePath());

					LOGGER.debug("Loading " + jarFile);

					// Path path =
					// projectRoot.getParent().resolve(nlg.getClassPath());

					loadDependencies(jarFile, depDelLoader);
//					EclipsePluginClassloader depLoader = new EclipsePluginClassloader(depDelLoader, projectRoot);

					bimServerDependencies.add(new org.bimserver.plugins.Dependency(jarFile));

				}
				previous = depDelLoader;
			} catch (DependencyCollectionException e) {
				e.printStackTrace();
			}
		}

		delegatingClassLoader.add(previous);
		// Path libFolder = projectRoot.resolve("lib");
		// loadDependencies(libFolder, delegatingClassLoader);
		EclipsePluginClassloader pluginClassloader = new EclipsePluginClassloader(delegatingClassLoader, projectRoot);
//		pluginClassloader.dumpStructure(0);

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
		sPluginBundle.setOrganization(model.getOrganization().getName());
		sPluginBundle.setName(model.getName());
		
		SPluginBundleVersion sPluginBundleVersion = createPluginBundleVersionFromMavenModel(model, true);
		
		Path icon = projectRoot.resolve("icon.png");
		if (Files.exists(icon)) {
			byte[] iconBytes = Files.readAllBytes(icon);
			sPluginBundleVersion.setIcon(iconBytes);
		}
		
		sPluginBundle.setInstalledVersion(sPluginBundleVersion);

		return loadPlugins(pluginBundleVersionIdentifier, resourceLoader, pluginClassloader, projectRoot.toUri(), projectRoot.resolve("target/classes").toString(), pluginDescriptor, PluginSourceType.ECLIPSE_PROJECT, bimServerDependencies, sPluginBundle, sPluginBundleVersion);
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

			PluginDescriptor pluginDescriptor = getPluginDescriptor(Files.newInputStream(pluginFile));
			
			Path pomFile = projectRoot.resolve("pom.xml");
			if (!Files.exists(pomFile)) {
				throw new PluginException("No pom.xml found in " + projectRoot);
			}
//			Path packageFile = projectRoot.resolve("package.json");
			
//			if (Files.exists(packageFile)) {
//				return loadJavaScriptProject(projectRoot, packageFile, pluginFolder, pluginDescriptor);
//			} else if (Files.exists(pomFile)) {
			PluginBundle pluginBundle = loadJavaProject(projectRoot, pomFile, pluginFolder, pluginDescriptor);
//			} else {
//				throw new PluginException("No pom.xml or package.json found in " + projectRoot.toString());
//			}
				
			List<SPluginInformation> plugins = new ArrayList<>();
			processPluginDescriptor(pluginDescriptor, plugins);
			
			for (SPluginInformation sPluginInformation : plugins) {
				if (sPluginInformation.isEnabled()) {
					// For local plugins, we assume to install for all users
					sPluginInformation.setInstallForAllUsers(true);
					sPluginInformation.setInstallForNewUsers(true);
					
					PluginContext pluginContext = pluginBundle.getPluginContext(sPluginInformation.getIdentifier());
					if (pluginContext == null) {
						throw new PluginException("No plugin context found for " + sPluginInformation.getIdentifier());
					}
					pluginContext.getPlugin().init(pluginContext);
				}
			}
			
			try {
				long pluginBundleVersionId = pluginChangeListener.pluginBundleInstalled(pluginBundle);
				for (SPluginInformation sPluginInformation : plugins) {
					if (sPluginInformation.isEnabled()) {
						PluginContext pluginContext = pluginBundle.getPluginContext(sPluginInformation.getIdentifier());
						pluginChangeListener.pluginInstalled(pluginBundleVersionId, pluginContext, sPluginInformation);
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

	@SuppressWarnings("unused")
	private PluginBundle loadJavaScriptProject(Path projectRoot, Path packageFile, Path pluginFolder, PluginDescriptor pluginDescriptor) {
		ObjectNode packageModel;
		try {
			packageModel = OBJECT_MAPPER.readValue(packageFile.toFile(), ObjectNode.class);
			SPluginBundle sPluginBundle = new SPluginBundle();
			
			if (!packageModel.has("organization")) {
				throw new PluginException("package.json does not contain 'organization'");
			}
			
			sPluginBundle.setOrganization(packageModel.get("organization").asText());
			sPluginBundle.setName(packageModel.get("name").asText());
			
			SPluginBundleVersion sPluginBundleVersion = new SPluginBundleVersion();
			sPluginBundleVersion.setType(SPluginBundleType.GITHUB);

			if (!packageModel.has("organization")) {
				throw new PluginException("package.json does not contain 'groupId'");
			}
			sPluginBundleVersion.setGroupId(packageModel.get("groupId").asText());
			
			if (!packageModel.has("organization")) {
				throw new PluginException("package.json does not contain 'artifactId'");
			}
			sPluginBundleVersion.setArtifactId(packageModel.get("artifactId").asText());
			
			if (!packageModel.has("organization")) {
				throw new PluginException("package.json does not contain 'version'");
			}
			sPluginBundleVersion.setVersion(packageModel.get("version").asText());
			
			if (!packageModel.has("organization")) {
				throw new PluginException("package.json does not contain 'description'");
			}
			sPluginBundleVersion.setDescription(packageModel.get("description").asText());
			
			sPluginBundleVersion.setRepository("local");
			sPluginBundleVersion.setType(SPluginBundleType.LOCAL);
			sPluginBundleVersion.setMismatch(false); // TODO
			
			sPluginBundle.setInstalledVersion(sPluginBundleVersion);
			
			PluginBundleVersionIdentifier pluginBundleVersionIdentifier = new PluginBundleVersionIdentifier(new PluginBundleIdentifier(packageModel.get("groupId").asText(), packageModel.get("artifactId").asText()), packageModel.get("version").asText());
			
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
			
			return loadPlugins(pluginBundleVersionIdentifier, resourceLoader, null, projectRoot.toUri(), null, pluginDescriptor, PluginSourceType.ECLIPSE_PROJECT, null, sPluginBundle, sPluginBundleVersion);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void loadDependencies(Path libFile, DelegatingClassLoader classLoader) throws FileNotFoundException, IOException {
		if (libFile.getFileName().toString().toLowerCase().endsWith(".jar")) {
			FileJarClassLoader jarClassLoader = new FileJarClassLoader(this, classLoader, libFile);
			jarClassLoaders.add(jarClassLoader);
			classLoader.add(jarClassLoader);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PluginBundle loadPlugins(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, ResourceLoader resourceLoader, ClassLoader classLoader, URI location, String classLocation, PluginDescriptor pluginDescriptor, PluginSourceType pluginType,
			Set<org.bimserver.plugins.Dependency> dependencies, SPluginBundle sPluginBundle, SPluginBundleVersion sPluginBundleVersion) throws PluginException {
		sPluginBundle.setInstalledVersion(sPluginBundleVersion);
		PluginBundle pluginBundle = new PluginBundleImpl(pluginBundleVersionIdentifier, sPluginBundle, sPluginBundleVersion, pluginDescriptor);
		
		if (classLoader != null && classLoader instanceof Closeable) {
			pluginBundle.addCloseable((Closeable) classLoader);
		}
		
		for (AbstractPlugin pluginImplementation : pluginDescriptor.getPlugins()) {
			if (pluginImplementation instanceof JavaPlugin) {
				JavaPlugin javaPlugin = (JavaPlugin)pluginImplementation;
				String interfaceClassName = javaPlugin.getInterfaceClass().trim().replace("\n", "");
				try {
					Class interfaceClass = getClass().getClassLoader().loadClass(interfaceClassName);
					if (javaPlugin.getImplementationClass() != null) {
						String implementationClassName = javaPlugin.getImplementationClass().trim().replace("\n", "");
						try {
							Class implementationClass = classLoader.loadClass(implementationClassName);
							Plugin plugin = (Plugin) implementationClass.newInstance();
							pluginBundle.add(loadPlugin(pluginBundle, interfaceClass, location, classLocation, plugin, classLoader, pluginType, pluginImplementation, dependencies, plugin.getClass().getName()));
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
				org.bimserver.plugins.WebModulePlugin webModulePlugin = (org.bimserver.plugins.WebModulePlugin)pluginImplementation;
				JsonWebModule jsonWebModule = new JsonWebModule(webModulePlugin);
				pluginBundle.add(loadPlugin(pluginBundle, WebModulePlugin.class, location, classLocation, jsonWebModule, classLoader, pluginType, pluginImplementation, dependencies, webModulePlugin.getIdentifier()));
			}
		}
		pluginBundleIdentifierToPluginBundle.put(pluginBundleVersionIdentifier.getPluginBundleIdentifier(), pluginBundle);
		pluginBundleVersionIdentifierToPluginBundle.put(pluginBundleVersionIdentifier, pluginBundle);
		pluginBundleIdentifierToCurrentPluginBundleVersionIdentifier.put(pluginBundleVersionIdentifier.getPluginBundleIdentifier(), pluginBundleVersionIdentifier);

		return pluginBundle;
	}

	public PluginDescriptor getPluginDescriptor(InputStream inputStream) throws JAXBException, IOException {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(PluginDescriptor.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			PluginDescriptor pluginDescriptor = (PluginDescriptor) unmarshaller.unmarshal(inputStream);
			return pluginDescriptor;
		} finally {
			inputStream.close();
		}
	}

	public PluginDescriptor getPluginDescriptor(byte[] bytes) throws JAXBException, IOException {
		return getPluginDescriptor(new ByteArrayInputStream(bytes));
	}
	
//	public void loadAllPluginsFromDirectoryOfJars(Path directory) throws PluginException, IOException {
//		LOGGER.debug("Loading all plugins from " + directory.toString());
//		if (!Files.isDirectory(directory)) {
//			throw new PluginException("No directory: " + directory.toString());
//		}
//		for (Path file : PathUtils.list(directory)) {
//			if (file.getFileName().toString().toLowerCase().endsWith(".jar")) {
//				try {
//					PluginBundleVersionIdentifier pluginBundleVersionIdentifier = PluginBundleVersionIdentifier.fromFileName(file.getFileName().toString());
//
//					loadPluginsFromJar(pluginBundleVersionIdentifier, file, extractPluginBundleFromJar(file), extractPluginBundleVersionFromJar(file));
//				} catch (PluginException e) {
//					LOGGER.error("", e);
//				}
//			}
//		}
//	}

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
	
	public SPluginBundleVersion extractPluginBundleVersionFromJar(Path jarFilePath, boolean isLocal) throws PluginException {
		String filename = jarFilePath.getFileName().toString();
		PluginBundleVersionIdentifier pluginBundleVersionIdentifier = PluginBundleVersionIdentifier.fromFileName(filename);
		PluginBundleIdentifier pluginBundleIdentifier = pluginBundleVersionIdentifier.getPluginBundleIdentifier();
		try (JarFile jarFile = new JarFile(jarFilePath.toFile())) {
			ZipEntry pomEntry = jarFile.getEntry("META-INF/maven/" + pluginBundleIdentifier.getGroupId() + "/" + pluginBundleIdentifier.getArtifactId() + "/" + "pom.xml");
			if (pomEntry == null) {
				throw new PluginException("No pom.xml found in JAR file " + jarFilePath.toString());
			}
			MavenXpp3Reader mavenreader = new MavenXpp3Reader();

			Model model = mavenreader.read(jarFile.getInputStream(pomEntry));
			SPluginBundleVersion sPluginBundleVersion = createPluginBundleVersionFromMavenModel(model, isLocal);
			return sPluginBundleVersion;
		} catch (IOException e) {
			throw new PluginException(e);
		} catch (XmlPullParserException e) {
			throw new PluginException(e);
		}
	}

	private SPluginBundleVersion createPluginBundleVersionFromMavenModel(Model model, boolean isLocal) {
		SPluginBundleVersion sPluginBundleVersion = new SPluginBundleVersion();
		sPluginBundleVersion.setType(isLocal ? SPluginBundleType.LOCAL : SPluginBundleType.MAVEN);
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

	public PluginBundle loadPluginsFromJar(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, Path file, SPluginBundle sPluginBundle, SPluginBundleVersion pluginBundleVersion, ClassLoader parentClassLoader) throws PluginException {
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
			jarClassLoader = new FileJarClassLoader(this, parentClassLoader, file);
			jarClassLoaders.add(jarClassLoader);
			final JarClassLoader finalLoader = jarClassLoader;
			InputStream pluginStream = jarClassLoader.getResourceAsStream("plugin/plugin.xml");
			if (pluginStream == null) {
				jarClassLoader.close();
				throw new PluginException("No plugin/plugin.xml found in " + file.getFileName().toString());
			}
			PluginDescriptor pluginDescriptor = getPluginDescriptor(pluginStream);
			if (pluginDescriptor == null) {
				jarClassLoader.close();
				throw new PluginException("No plugin descriptor could be created");
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

			return loadPlugins(pluginBundleVersionIdentifier, resourceLoader, jarClassLoader, jarUri, file.toAbsolutePath().toString(), pluginDescriptor, PluginSourceType.JAR_FILE, new HashSet<org.bimserver.plugins.Dependency>(), sPluginBundle, pluginBundleVersion);
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private <T> Map<PluginContext, T> getPlugins(Class<T> requiredInterfaceClass, boolean onlyEnabled) {
		Map<PluginContext, T> plugins = new HashMap<>();
		for (Class interfaceClass : implementations.keySet()) {
			if (requiredInterfaceClass.isAssignableFrom(interfaceClass)) {
				for (PluginContext pluginContext : implementations.get(interfaceClass)) {
					if (!onlyEnabled || pluginContext.isEnabled()) {
						plugins.put(pluginContext, (T) pluginContext.getPlugin());
					}
				}
			}
		}
		return plugins;
	}

	public Map<PluginContext, ObjectIDMPlugin> getAllObjectIDMPlugins(boolean onlyEnabled) {
		return getPlugins(ObjectIDMPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, RenderEnginePlugin> getAllRenderEnginePlugins(boolean onlyEnabled) {
		return getPlugins(RenderEnginePlugin.class, onlyEnabled);
	}

	public Map<PluginContext, StillImageRenderPlugin> getAllStillImageRenderPlugins(boolean onlyEnabled) {
		return getPlugins(StillImageRenderPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, QueryEnginePlugin> getAllQueryEnginePlugins(boolean onlyEnabled) {
		return getPlugins(QueryEnginePlugin.class, onlyEnabled);
	}

	public Map<PluginContext, SerializerPlugin> getAllSerializerPlugins(boolean onlyEnabled) {
		return getPlugins(SerializerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, MessagingSerializerPlugin> getAllMessagingSerializerPlugins(boolean onlyEnabled) {
		return getPlugins(MessagingSerializerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, MessagingStreamingSerializerPlugin> getAllMessagingStreamingSerializerPlugins(boolean onlyEnabled) {
		return getPlugins(MessagingStreamingSerializerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, DeserializerPlugin> getAllDeserializerPlugins(boolean onlyEnabled) {
		return getPlugins(DeserializerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, StreamingDeserializerPlugin> getAllStreamingDeserializerPlugins(boolean onlyEnabled) {
		return getPlugins(StreamingDeserializerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, StreamingSerializerPlugin> getAllStreamingSeserializerPlugins(boolean onlyEnabled) {
		return getPlugins(StreamingSerializerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, Plugin> getAllPlugins(boolean onlyEnabled) {
		return getPlugins(Plugin.class, onlyEnabled);
	}

	public PluginContext getPluginContext(Plugin plugin) {
		PluginContext pluginContext = pluginToPluginContext.get(plugin);
		if (pluginContext == null) {
			throw new RuntimeException("No plugin context found for " + plugin);
		}
		return pluginContext;
	}

	public void enablePlugin(String name) {
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getPlugin().getClass().getName().equals(name)) {
					pluginContext.setEnabled(true, true);
				}
			}
		}
	}

	public void disablePlugin(String name) {
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getPlugin().getClass().getName().equals(name)) {
					pluginContext.setEnabled(false, true);
				}
			}
		}
	}

	public Plugin getPlugin(String identifier, boolean onlyEnabled) {
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getIdentifier().equals(identifier)) {
					if (!onlyEnabled || pluginContext.isEnabled()) {
						return pluginContext.getPlugin();
					}
				}
			}
		}
		return null;
	}

	public boolean isEnabled(String className) {
		return getPlugin(className, true) != null;
	}

	public void setPluginChangeListener(PluginChangeListener pluginChangeListener) {
		this.pluginChangeListener = pluginChangeListener;
	}

	public Collection<DeserializerPlugin> getAllDeserializerPlugins(String extension, boolean onlyEnabled) {
		Collection<DeserializerPlugin> allDeserializerPlugins = getAllDeserializerPlugins(onlyEnabled).values();
		Iterator<DeserializerPlugin> iterator = allDeserializerPlugins.iterator();
		while (iterator.hasNext()) {
			DeserializerPlugin deserializerPlugin = iterator.next();
			if (!deserializerPlugin.canHandleExtension(extension)) {
				iterator.remove();
			}
		}
		return allDeserializerPlugins;
	}

	public DeserializerPlugin requireDeserializer(String extension) throws DeserializeException {
		Collection<DeserializerPlugin> allDeserializerPlugins = getAllDeserializerPlugins(extension, true);
		if (allDeserializerPlugins.size() == 0) {
			throw new DeserializeException("No deserializers found for type '" + extension + "'");
		} else {
			return allDeserializerPlugins.iterator().next();
		}
	}

	public Path getTempDir() {
		if (!Files.isDirectory(tempDir)) {
			try {
				Files.createDirectories(tempDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return tempDir;
	}

	public PluginContext loadPlugin(PluginBundle pluginBundle, Class<? extends Plugin> interfaceClass, URI location, String classLocation, Plugin plugin, ClassLoader classLoader, PluginSourceType pluginType,
			AbstractPlugin pluginImplementation, Set<org.bimserver.plugins.Dependency> dependencies, String identifier) throws PluginException {
		LOGGER.debug("Loading plugin " + plugin.getClass().getSimpleName() + " of type " + interfaceClass.getSimpleName());
		if (!Plugin.class.isAssignableFrom(interfaceClass)) {
			throw new PluginException("Given interface class (" + interfaceClass.getName() + ") must be a subclass of " + Plugin.class.getName());
		}
		if (!implementations.containsKey(interfaceClass)) {
			implementations.put(interfaceClass, new LinkedHashSet<PluginContext>());
		}
		Set<PluginContext> set = (Set<PluginContext>) implementations.get(interfaceClass);
		try {
			PluginContext pluginContext = new PluginContext(this, pluginBundle, interfaceClass, classLoader, pluginType, pluginImplementation.getDescription(), location, plugin, classLocation, dependencies, identifier);
			pluginToPluginContext.put(plugin, pluginContext);
			set.add(pluginContext);
			return pluginContext;
		} catch (IOException e) {
			throw new PluginException(e);
		}
	}

	/**
	 * This method will initialize all the loaded plugins
	 * 
	 * @throws PluginException
	 */
	public void initAllLoadedPlugins() throws PluginException {
		LOGGER.debug("Initializig all loaded plugins");
		for (Class<? extends Plugin> pluginClass : implementations.keySet()) {
			Set<PluginContext> set = implementations.get(pluginClass);
			for (PluginContext pluginContext : set) {
				try {
					pluginContext.initialize();
				} catch (Throwable e) {
					LOGGER.error("", e);
					pluginContext.setEnabled(false, false);
				}
			}
		}
	}

	/*
	 * Returns a complete classpath for all loaded plugins
	 */
	public String getCompleteClassPath() {
		StringBuilder sb = new StringBuilder();
		if (baseClassPath != null) {
			sb.append(baseClassPath + File.pathSeparator);
		}
		for (Class<? extends Plugin> pluginClass : implementations.keySet()) {
			Set<PluginContext> set = implementations.get(pluginClass);
			for (PluginContext pluginContext : set) {
				sb.append(pluginContext.getClassLocation() + File.pathSeparator);
			}
		}
		return sb.toString();
	}

	public DeserializerPlugin getFirstDeserializer(String extension, Schema schema, boolean onlyEnabled) throws PluginException {
		Collection<DeserializerPlugin> allDeserializerPlugins = getAllDeserializerPlugins(extension, onlyEnabled);
		Iterator<DeserializerPlugin> iterator = allDeserializerPlugins.iterator();
		while (iterator.hasNext()) {
			DeserializerPlugin next = iterator.next();
			if (!next.getSupportedSchemas().contains(schema)) {
				iterator.remove();
			}
		}
		if (allDeserializerPlugins.size() == 0) {
			throw new PluginException("No deserializers with extension " + extension + " found");
		}
		return allDeserializerPlugins.iterator().next();
	}

	public ObjectIDMPlugin getObjectIDMByName(String className, boolean onlyEnabled) {
		return getPluginByClassName(ObjectIDMPlugin.class, className, onlyEnabled);
	}

	public RenderEnginePlugin getRenderEnginePlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(RenderEnginePlugin.class, className, onlyEnabled);
	}

	private <T extends Plugin> T getPluginByClassName(Class<T> clazz, String className, boolean onlyEnabled) {
		Collection<T> allPlugins = getPlugins(clazz, onlyEnabled).values();
		for (T t : allPlugins) {
			if (t.getClass().getName().equals(className)) {
				return t;
			}
		}
		return null;
	}

	public QueryEnginePlugin getQueryEngine(String className, boolean onlyEnabled) {
		return getPluginByClassName(QueryEnginePlugin.class, className, onlyEnabled);
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

	public Map<PluginContext, ModelMergerPlugin> getAllModelMergerPlugins(boolean onlyEnabled) {
		return getPlugins(ModelMergerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, ModelComparePlugin> getAllModelComparePlugins(boolean onlyEnabled) {
		return getPlugins(ModelComparePlugin.class, onlyEnabled);
	}

	public ModelMergerPlugin getModelMergerPlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(ModelMergerPlugin.class, className, onlyEnabled);
	}

	public ModelComparePlugin getModelComparePlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(ModelComparePlugin.class, className, onlyEnabled);
	}

	public Map<PluginContext, ServicePlugin> getAllServicePlugins(boolean onlyEnabled) {
		return getPlugins(ServicePlugin.class, onlyEnabled);
	}

	public ServicePlugin getServicePlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(ServicePlugin.class, className, onlyEnabled);
	}

	public ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void registerNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewRevisionHandler newRevisionHandler) {
		if (notificationsManagerInterface != null) {
			notificationsManagerInterface.registerInternalNewRevisionHandler(uoid, serviceDescriptor, newRevisionHandler);
		}
	}

	public void unregisterNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor) {
		if (notificationsManagerInterface != null) {
			notificationsManagerInterface.unregisterInternalNewRevisionHandler(uoid, serviceDescriptor.getIdentifier());
		}
	}

	public SServicesMap getServicesMap() {
		return servicesMap;
	}

	// public StillImageRenderPlugin getFirstStillImageRenderPlugin() throws
	// PluginException {
	// Collection<StillImageRenderPlugin> allPlugins =
	// getAllStillImageRenderPlugins(true).values();
	// if (allPlugins.size() == 0) {
	// throw new PluginException("No still image render plugins found");
	// }
	// StillImageRenderPlugin plugin = allPlugins.iterator().next();
	// if (!plugin.isInitialized()) {
	// plugin.init(this);
	// }
	// return plugin;
	//
	// }

	public Parameter getParameter(PluginContext pluginContext, String name) {
		return null;
	}

	public SerializerPlugin getSerializerPlugin(String className, boolean onlyEnabled) {
		return (SerializerPlugin) getPlugin(className, onlyEnabled);
	}

	public MessagingSerializerPlugin getMessagingSerializerPlugin(String className, boolean onlyEnabled) {
		return (MessagingSerializerPlugin) getPlugin(className, onlyEnabled);
	}

	public WebModulePlugin getWebModulePlugin(String className, boolean onlyEnabled) {
		return (WebModulePlugin) getPlugin(className, onlyEnabled);
	}

	public Map<PluginContext, WebModulePlugin> getAllWebPlugins(boolean onlyEnabled) {
		return getPlugins(WebModulePlugin.class, onlyEnabled);
	}

	public Map<PluginContext, ModelCheckerPlugin> getAllModelCheckerPlugins(boolean onlyEnabled) {
		return getPlugins(ModelCheckerPlugin.class, onlyEnabled);
	}

	public ModelCheckerPlugin getModelCheckerPlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(ModelCheckerPlugin.class, className, onlyEnabled);
	}

	public BimServerClientInterface getLocalBimServerClientInterface(AuthenticationInfo tokenAuthentication) throws ServiceException, ChannelConnectionException {
		return bimServerClientFactory.create(tokenAuthentication);
	}

	public void setBimServerClientFactory(BimServerClientFactory bimServerClientFactory) {
		this.bimServerClientFactory = bimServerClientFactory;
	}

	public void registerNewExtendedDataOnProjectHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnProjectHandler newExtendedDataHandler) {
		if (notificationsManagerInterface != null) {
			notificationsManagerInterface.registerInternalNewExtendedDataOnProjectHandler(uoid, serviceDescriptor, newExtendedDataHandler);
		}
	}

	public void registerNewExtendedDataOnRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnRevisionHandler newExtendedDataHandler) {
		if (notificationsManagerInterface != null) {
			notificationsManagerInterface.registerInternalNewExtendedDataOnRevisionHandler(uoid, serviceDescriptor, newExtendedDataHandler);
		}
	}

	public DeserializerPlugin getDeserializerPlugin(String pluginClassName, boolean onlyEnabled) {
		return getPluginByClassName(DeserializerPlugin.class, pluginClassName, onlyEnabled);
	}

	public StreamingDeserializerPlugin getStreamingDeserializerPlugin(String pluginClassName, boolean onlyEnabled) {
		return getPluginByClassName(StreamingDeserializerPlugin.class, pluginClassName, onlyEnabled);
	}

	public StreamingSerializerPlugin getStreamingSerializerPlugin(String pluginClassName, boolean onlyEnabled) {
		return getPluginByClassName(StreamingSerializerPlugin.class, pluginClassName, onlyEnabled);
	}

	public MetaDataManager getMetaDataManager() {
		return metaDataManager;
	}

	public void setMetaDataManager(MetaDataManager metaDataManager) {
		this.metaDataManager = metaDataManager;
	}

	public FileSystem getOrCreateFileSystem(URI uri) throws IOException {
		FileSystem fileSystem = null;
		try {
			fileSystem = FileSystems.getFileSystem(uri);
		} catch (FileSystemNotFoundException e) {
			Map<String, String> env = new HashMap<>();
			env.put("create", "true");
			fileSystem = FileSystems.newFileSystem(uri, env, null);
			LOGGER.debug("Created VFS for " + uri);
		}
		return fileSystem;
	}

	public MessagingStreamingSerializerPlugin getMessagingStreamingSerializerPlugin(String className, boolean onlyEnabled) {
		return (MessagingStreamingSerializerPlugin) getPlugin(className, onlyEnabled);
	}

	public List<SPluginInformation> getPluginInformationFromJar(Path file) throws PluginException, FileNotFoundException, IOException, JAXBException {
		try (JarFile jarFile = new JarFile(file.toFile())) {
			ZipEntry entry = jarFile.getEntry("plugin/plugin.xml");
			if (entry == null) {
				throw new PluginException("No plugin/plugin.xml found in " + file.getFileName().toString());
			}
			InputStream pluginStream = jarFile.getInputStream(entry);
			return getPluginInformationFromPluginFile(pluginStream);
		}
	}

	public List<SPluginInformation> getPluginInformationFromJar(InputStream jarInputStream) throws PluginException, FileNotFoundException, IOException, JAXBException {
		try (JarInputStream jarInputStream2 = new JarInputStream(jarInputStream)) {
			JarEntry next = jarInputStream2.getNextJarEntry();
			while (next != null) {
				if (next.getName().equals("plugin/plugin.xml")) {
					return getPluginInformationFromPluginFile(jarInputStream2);
				}
				next = jarInputStream2.getNextJarEntry();
			}
		}
		return null;
	}

	public List<SPluginInformation> getPluginInformationFromPluginFile(InputStream inputStream) throws PluginException, FileNotFoundException, IOException, JAXBException {
		PluginDescriptor pluginDescriptor = getPluginDescriptor(inputStream);
		if (pluginDescriptor == null) {
			throw new PluginException("No plugin descriptor could be created");
		}
		List<SPluginInformation> list = new ArrayList<>();
		processPluginDescriptor(pluginDescriptor, list);
		return list;
	}

	private void processPluginDescriptor(PluginDescriptor pluginDescriptor, List<SPluginInformation> list) {
		for (AbstractPlugin pluginImplementation : pluginDescriptor.getPlugins()) {
			if (pluginImplementation instanceof JavaPlugin) {
				JavaPlugin javaPlugin = (JavaPlugin)pluginImplementation;
				SPluginInformation sPluginInformation = new SPluginInformation();
				String name = javaPlugin.getName();
				// TODO when all plugins have a name, this code can go
				if (name == null) {
					name = javaPlugin.getImplementationClass();
				}
				sPluginInformation.setName(name);
				sPluginInformation.setDescription(javaPlugin.getDescription());
				sPluginInformation.setEnabled(true);

				// For java plugins we use the implementation class as identifier
				sPluginInformation.setIdentifier(javaPlugin.getImplementationClass());
				
				sPluginInformation.setType(getPluginTypeFromClass(javaPlugin.getInterfaceClass()));
				list.add(sPluginInformation);
			} else if (pluginImplementation instanceof org.bimserver.plugins.WebModulePlugin) {
				org.bimserver.plugins.WebModulePlugin webModulePlugin = (org.bimserver.plugins.WebModulePlugin)pluginImplementation;
				SPluginInformation sPluginInformation = new SPluginInformation();
				sPluginInformation.setIdentifier(webModulePlugin.getIdentifier());
				sPluginInformation.setName(webModulePlugin.getName());
				sPluginInformation.setDescription(webModulePlugin.getDescription());
				sPluginInformation.setType(SPluginType.WEB_MODULE);
				sPluginInformation.setEnabled(true);
				list.add(sPluginInformation);
			}
		}
	}

	public List<SPluginInformation> getPluginInformationFromPluginFile(Path file) throws PluginException, FileNotFoundException, IOException, JAXBException {
		List<SPluginInformation> list = new ArrayList<>();
		try (InputStream pluginStream = Files.newInputStream(file)) {
			PluginDescriptor pluginDescriptor = getPluginDescriptor(pluginStream);
			if (pluginDescriptor == null) {
				throw new PluginException("No plugin descriptor could be created");
			}
			processPluginDescriptor(pluginDescriptor, list);
		}
		return list;
	}
	
	public SPluginType getPluginTypeFromClass(String className) {
		switch (className) {
		case "org.bimserver.plugins.deserializers.DeserializerPlugin":
			return SPluginType.DESERIALIZER;
		case "org.bimserver.plugins.deserializers.StreamingDeserializerPlugin":
			return SPluginType.DESERIALIZER;
		case "org.bimserver.plugins.serializers.SerializerPlugin":
			return SPluginType.SERIALIZER;
		case "org.bimserver.plugins.serializers.StreamingSerializerPlugin":
			return SPluginType.SERIALIZER;
		case "org.bimserver.plugins.serializers.MessagingStreamingSerializerPlugin":
			return SPluginType.SERIALIZER;
		case "org.bimserver.plugins.serializers.MessagingSerializerPlugin":
			return SPluginType.SERIALIZER;
		case "org.bimserver.plugins.modelchecker.ModelCheckerPlugin":
			return SPluginType.MODEL_CHECKER;
		case "org.bimserver.plugins.modelmerger.ModelMergerPlugin":
			return SPluginType.MODEL_MERGER;
		case "org.bimserver.plugins.modelcompare.ModelComparePlugin":
			return SPluginType.MODEL_COMPARE;
		case "org.bimserver.plugins.objectidms.ObjectIDMPlugin":
			return SPluginType.OBJECT_IDM;
		case "org.bimserver.plugins.queryengine.QueryEnginePlugin":
			return SPluginType.QUERY_ENGINE;
		case "org.bimserver.plugins.services.ServicePlugin":
			return SPluginType.SERVICE;
		case "org.bimserver.plugins.renderengine.RenderEnginePlugin":
			return SPluginType.RENDER_ENGINE;
		case "org.bimserver.plugins.stillimagerenderer.StillImageRenderPlugin":
			return SPluginType.STILL_IMAGE_RENDER;
		case "org.bimserver.plugins.web.WebModulePlugin":
			return SPluginType.WEB_MODULE;
		}
		return null;
	}

	public PluginBundle loadFromPluginDir(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, SPluginBundleVersion pluginBundleVersion, List<SPluginInformation> plugins, boolean strictDependencyChecking) throws Exception {
		Path target = pluginsDir.resolve(pluginBundleVersionIdentifier.getFileName());
		if (!Files.exists(target)) {
			throw new PluginException(target.toString() + " not found");
		}

		SPluginBundle sPluginBundle = new SPluginBundle();

		MavenXpp3Reader mavenreader = new MavenXpp3Reader();

		try (JarFile jarFile = new JarFile(target.toFile())) {
			ZipEntry entry = jarFile.getEntry("META-INF/maven/" + pluginBundleVersion.getGroupId() + "/" + pluginBundleVersion.getArtifactId() + "/pom.xml");
			Model model = mavenreader.read(jarFile.getInputStream(entry));

			sPluginBundle.setOrganization(model.getOrganization().getName());
			sPluginBundle.setName(model.getName());
			
			DelegatingClassLoader delegatingClassLoader = new DelegatingClassLoader(getClass().getClassLoader());
			
			for (org.apache.maven.model.Dependency dependency : model.getDependencies()) {
				if (dependency.getGroupId().equals("org.opensourcebim") && (dependency.getArtifactId().equals("shared") || dependency.getArtifactId().equals("pluginbase"))) {
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
						if (pluginBundleIdentifier.getGroupId().equals("org.opensourcebim")) {
							throw new Exception("Required dependency " + pluginBundleIdentifier + " is not installed");
						} else {
							MavenPluginLocation mavenPluginLocation = mavenPluginRepository.getPluginLocation(model.getRepositories().get(0).getUrl(), dependency.getGroupId(), dependency.getArtifactId());
							
							try {
								Path depJarFile = mavenPluginLocation.getVersionJar(dependency.getVersion());
								
								FileJarClassLoader jarClassLoader = new FileJarClassLoader(this, delegatingClassLoader, depJarFile);
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
	}
	
	public PluginBundle loadPlugin(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, Path target, SPluginBundle sPluginBundle, SPluginBundleVersion pluginBundleVersion, List<SPluginInformation> plugins, ClassLoader parentClassLoader) throws Exception {
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
					}
					pluginContext.getPlugin().init(pluginContext);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (pluginBundle != null) {
				pluginBundle.close();
			}
			pluginBundleVersionIdentifierToPluginBundle.remove(pluginBundleVersionIdentifier);
			pluginBundleIdentifierToPluginBundle.remove(pluginBundleVersionIdentifier.getPluginBundleIdentifier());
			Files.delete(target);
			LOGGER.error("", e);
			throw e;
		}
		// Stage 2, if all went well, notify the listeners of this plugin, if
		// anything goes wrong in the notifications, the plugin bundle will be
		// uninstalled
		try {
			long pluginBundleVersionId = pluginChangeListener.pluginBundleInstalled(pluginBundle);
			for (SPluginInformation sPluginInformation : plugins) {
				if (sPluginInformation.isEnabled()) {
					PluginContext pluginContext = pluginBundle.getPluginContext(sPluginInformation.getIdentifier());
					pluginChangeListener.pluginInstalled(pluginBundleVersionId, pluginContext, sPluginInformation);
				}
			}
			return pluginBundle;
		} catch (Exception e) {
			uninstall(pluginBundleVersionIdentifier);
			LOGGER.error("", e);
			throw e;
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
			try (JarInputStream jarInputStream = new JarInputStream(mavenPluginBundle.getJarInputStream())) {
				JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
				while (nextJarEntry != null) {
					if (nextJarEntry.getName().equals("plugin/plugin.xml")) {
						// Install all plugins
						PluginDescriptor pluginDescriptor = getPluginDescriptor(new FakeClosingInputStream(jarInputStream));
						plugins = new ArrayList<>();
						processPluginDescriptor(pluginDescriptor, plugins);
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
		
		DelegatingClassLoader delegatingClassLoader = new DelegatingClassLoader(getClass().getClassLoader());
		
		for (org.apache.maven.model.Dependency dependency : model.getDependencies()) {
			if (dependency.getGroupId().equals("org.opensourcebim") && (dependency.getArtifactId().equals("shared") || dependency.getArtifactId().equals("pluginbase"))) {
				// TODO Skip, we should also check the version though
			} else {
				PluginBundleIdentifier pluginBundleIdentifier = new PluginBundleIdentifier(dependency.getGroupId(), dependency.getArtifactId());
				if (pluginBundleIdentifierToPluginBundle.containsKey(pluginBundleIdentifier)) {
					if (strictDependencyChecking) {
						VersionRange versionRange = VersionRange.createFromVersion(dependency.getVersion());
//						String version = pluginBundleIdentifierToPluginBundle.get(pluginBundleIdentifier).getPluginBundleVersion().getVersion();
						ArtifactVersion artifactVersion = new DefaultArtifactVersion(mavenPluginBundle.getVersion());
						if (versionRange.containsVersion(artifactVersion)) {
							// OK
						} else {
							throw new Exception("Required dependency " + pluginBundleIdentifier + " is installed, but it's version (" + mavenPluginBundle.getVersion() + ") does not comply to the required version (" + dependency.getVersion() + ")");
						}
					} else {
						LOGGER.info("Skipping strict dependency checking for dependency " + dependency.getArtifactId());
					}
				} else {
					try {
						MavenPluginLocation mavenPluginLocation = mavenPluginRepository.getPluginLocation(dependency.getGroupId(), dependency.getArtifactId());
						Path depJarFile = mavenPluginLocation.getVersionJar(dependency.getVersion());
						
						FileJarClassLoader jarClassLoader = new FileJarClassLoader(this, delegatingClassLoader, depJarFile);
						jarClassLoaders.add(jarClassLoader);
						delegatingClassLoader.add(jarClassLoader);
					} catch (Exception e) {
						throw new Exception("Required dependency " + pluginBundleIdentifier + " is not installed");
					}
				}
			}
		}
		
		Path target = pluginsDir.resolve(pluginBundleVersionIdentifier.getFileName());
		if (Files.exists(target)) {
			throw new PluginException("This plugin has already been installed " + target.getFileName().toString());
		}
		Files.copy(mavenPluginBundle.getJarInputStream(), target);

		return loadPlugin(pluginBundleVersionIdentifier, target, mavenPluginBundle.getPluginBundle(), mavenPluginBundle.getPluginBundleVersion(), plugins, delegatingClassLoader);
	}
	
//	public PluginBundle install(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, SPluginBundle sPluginBundle, SPluginBundleVersion pluginBundleVersion, List<SPluginInformation> plugins, boolean strictDependencyChecking) throws Exception {
//		MavenXpp3Reader mavenreader = new MavenXpp3Reader();
//		Model model = mavenreader.read(new FileReader(pomFile.toFile()));
//		
//		DelegatingClassLoader delegatingClassLoader = new DelegatingClassLoader(getClass().getClassLoader());
//		
//		for (org.apache.maven.model.Dependency dependency : model.getDependencies()) {
//			if (dependency.getGroupId().equals("org.opensourcebim") && (dependency.getArtifactId().equals("shared") || dependency.getArtifactId().equals("pluginbase"))) {
//				// TODO Skip, we should also check the version though
//			} else {
//				PluginBundleIdentifier pluginBundleIdentifier = new PluginBundleIdentifier(dependency.getGroupId(), dependency.getArtifactId());
//				if (pluginBundleIdentifierToPluginBundle.containsKey(pluginBundleIdentifier)) {
//					if (strictDependencyChecking) {
//						VersionRange versionRange = VersionRange.createFromVersion(dependency.getVersion());
//						String version = pluginBundleIdentifierToPluginBundle.get(pluginBundleIdentifier).getPluginBundleVersion().getVersion();
//						ArtifactVersion artifactVersion = new DefaultArtifactVersion(version);
//						if (versionRange.containsVersion(artifactVersion)) {
//							// OK
//						} else {
//							throw new Exception("Required dependency " + pluginBundleIdentifier + " is installed, but it's version (" + version + ") does not comply to the required version (" + dependency.getVersion() + ")");
//						}
//					} else {
//						LOGGER.info("Skipping strict dependency checking for dependency " + dependency.getArtifactId());
//					}
//				} else {
//					try {
//						MavenPluginLocation mavenPluginLocation = mavenPluginRepository.getPluginLocation(dependency.getGroupId(), dependency.getArtifactId());
//						Path depJarFile = mavenPluginLocation.getVersionJar(dependency.getVersion());
//						
//						FileJarClassLoader jarClassLoader = new FileJarClassLoader(this, delegatingClassLoader, depJarFile); 
//						delegatingClassLoader.add(jarClassLoader);
//					} catch (Exception e) {
//						throw new Exception("Required dependency " + pluginBundleIdentifier + " is not installed");
//					}
//				}
//			}
//		}
//		
//		Path target = pluginsDir.resolve(pluginBundleVersionIdentifier.getFileName());
//		if (Files.exists(target)) {
//			throw new PluginException("This plugin has already been installed " + target.getFileName().toString());
//		}
//		Files.copy(jarFile, target);
//
//		return loadPlugin(pluginBundleVersionIdentifier, target, sPluginBundle, pluginBundleVersion, plugins, delegatingClassLoader);
//	}

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
				Set<PluginContext> set = implementations.get(pluginContext.getPluginInterface());
				set.remove(pluginContext);
			}
			
			Path target = pluginsDir.resolve(pluginBundleVersionIdentifier.getFileName());
			Files.delete(target);
			
			for (PluginContext pluginContext : pluginBundle) {
				pluginChangeListener.pluginUninstalled(pluginContext);
			}
			pluginChangeListener.pluginBundleUninstalled(pluginBundle);

		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public PluginBundle getPluginBundle(PluginBundleIdentifier pluginIdentifier) {
		return pluginBundleIdentifierToPluginBundle.get(pluginIdentifier);
	}

	public Collection<PluginBundle> getPluginBundles() {
		return pluginBundleVersionIdentifierToPluginBundle.values();
	}

	@Override
	public ObjectIDM getDefaultObjectIDM() throws ObjectIDMException {
		// TODO add a mechanism that can be used to ask a database what the
		// default plugin is
		
		return null;
	}

	@Override
	public void notifyPluginStateChange(PluginContext pluginContext, boolean enabled) {
		if (pluginChangeListener != null) {
			pluginChangeListener.pluginStateChanged(pluginContext, enabled);
		}
	}

	public PluginBundle update(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, SPluginBundle sPluginBundle, SPluginBundleVersion pluginBundleVersion, Path jarFile, Path pomFile, List<SPluginInformation> plugins) throws Exception {
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
				Set<PluginContext> set = implementations.get(pluginContext.getPluginInterface());
				set.remove(pluginContext);
			}
			
			if (existingPluginBundle.getPluginBundle().getInstalledVersion().getType() == SPluginBundleType.MAVEN) {
				Path target = pluginsDir.resolve(currentVersion.getFileName());
				Files.delete(target);
			}
			
//			for (PluginContext pluginContext : existingPluginBundle) {
//				pluginChangeListener.pluginUninstalled(pluginContext);
//			}
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
//					if (false) {
//						VersionRange versionRange = VersionRange.createFromVersion(dependency.getVersion());
//						String version = pluginBundleIdentifierToPluginBundle.get(pluginBundleIdentifier).getPluginBundleVersion().getVersion();
//						ArtifactVersion artifactVersion = new DefaultArtifactVersion(version);
//						if (versionRange.containsVersion(artifactVersion)) {
//							// OK
//						} else {
//							throw new Exception("Required dependency " + pluginBundleIdentifier + " is installed, but it's version (" + version + ") does not comply to the required version (" + dependency.getVersion() + ")");
//						}
//					} else {
						LOGGER.info("Skipping strict dependency checking for dependency " + dependency.getArtifactId());
//					}
				} else {
					if (dependency.getGroupId().equals("org.opensourcebim") && (dependency.getArtifactId().equals("shared") || dependency.getArtifactId().equals("pluginbase"))) {
						throw new Exception("Required dependency " + pluginBundleIdentifier + " is not installed");
					} else {
						MavenPluginLocation mavenPluginLocation = mavenPluginRepository.getPluginLocation(model.getRepositories().get(0).getUrl(), dependency.getGroupId(), dependency.getArtifactId());
						
						try {
							Path depJarFile = mavenPluginLocation.getVersionJar(dependency.getVersion());
							
							FileJarClassLoader jarClassLoader = new FileJarClassLoader(this, delegatingClassLoader, depJarFile); 
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
					pluginContext.getPlugin().init(pluginContext);
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
			long pluginBundleVersionId = pluginChangeListener.pluginBundleUpdated(pluginBundle);
			
			for (SPluginInformation sPluginInformation : plugins) {
				if (sPluginInformation.isEnabled()) {
					PluginContext pluginContext = pluginBundle.getPluginContext(sPluginInformation.getIdentifier());
					pluginChangeListener.pluginUpdated(pluginBundleVersionId, pluginContext, sPluginInformation);
				}
			}
			return pluginBundle;
		} catch (Exception e) {
			uninstall(pluginBundleVersionIdentifier);
			LOGGER.error("", e);
			throw e;
		}
	}

	@Override
	public SerializerPlugin getSerializerPlugin(String pluginClassName) {
		return getPluginByClassName(SerializerPlugin.class, pluginClassName, true);
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
}