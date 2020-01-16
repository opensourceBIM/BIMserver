package org.bimserver.plugins;

import java.io.File;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.apache.maven.settings.Mirror;
import org.apache.maven.settings.Settings;
import org.apache.maven.settings.building.DefaultSettingsBuilder;
import org.apache.maven.settings.building.DefaultSettingsBuilderFactory;
import org.apache.maven.settings.building.DefaultSettingsBuildingRequest;
import org.apache.maven.settings.building.SettingsBuildingException;
import org.apache.maven.settings.building.SettingsBuildingRequest;
import org.apache.maven.settings.building.SettingsBuildingResult;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.repository.RepositoryPolicy;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transport.file.FileTransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;
import org.eclipse.aether.util.repository.DefaultMirrorSelector;
import org.jetbrains.idea.maven.aether.JreProxySelector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MavenPluginRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(MavenPluginRepository.class);
	private final RepositorySystem system;
	private final RepositorySystemSession session;
	private final Set<RemoteRepository> repositories = new LinkedHashSet<>();
	private final List<RemoteRepository> localRepositories;
	private final JreProxySelector proxySelector = new JreProxySelector();
	private RemoteRepository local;
	
	public MavenPluginRepository() {
		Settings settings = loadDefaultUserSettings();

		RemoteRepository central = new RemoteRepository.Builder("central", "default", "https://repo1.maven.org/maven2/").build();
		repositories.add(central);
		
		system = newRepositorySystem();
		String userHome = System.getProperty("user.home");
		File localRepository = new File(settings.getLocalRepository() == null ? userHome + "/.m2/repository" : settings.getLocalRepository());
		session = newRepositorySystemSession(system, localRepository, settings);

		localRepositories = new ArrayList<>();

		RemoteRepository.Builder localRepoBuilder = new RemoteRepository.Builder("local", "default", "file://" + localRepository.toString());
		localRepoBuilder.setPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_INTERVAL + ":60", RepositoryPolicy.CHECKSUM_POLICY_FAIL));
		local = localRepoBuilder.build();
		repositories.add(local);
		localRepositories.add(local);
	}

	private Settings loadDefaultUserSettings() {
		String userHome = System.getProperty("user.home");
	    File userMavenConfigurationHome = new File(userHome, ".m2");
	    String envM2Home = System.getenv("M2_HOME");
	    File DEFAULT_USER_SETTINGS_FILE = new File(userMavenConfigurationHome, "settings.xml");
	    File DEFAULT_GLOBAL_SETTINGS_FILE = new File(System.getProperty("maven.home", envM2Home != null ? envM2Home : ""), "conf/settings.xml");
	    SettingsBuildingRequest settingsBuildingRequest = new DefaultSettingsBuildingRequest();
	    settingsBuildingRequest.setSystemProperties(System.getProperties());
	    settingsBuildingRequest.setUserSettingsFile(DEFAULT_USER_SETTINGS_FILE);
	    settingsBuildingRequest.setGlobalSettingsFile(DEFAULT_GLOBAL_SETTINGS_FILE);

	    DefaultSettingsBuilderFactory mvnSettingBuilderFactory = new DefaultSettingsBuilderFactory();
	    DefaultSettingsBuilder settingsBuilder = mvnSettingBuilderFactory.newInstance();
	    try {
			SettingsBuildingResult settingsBuildingResult = settingsBuilder.build(settingsBuildingRequest);
			Settings settings = settingsBuildingResult.getEffectiveSettings();
			return settings;
		} catch (SettingsBuildingException e) {
			e.printStackTrace();
		}
	    return null;
	}

	public RemoteRepository getLocal() {
		return local;
	}	
	
	public MavenPluginLocation getPluginLocation(String groupId, String artifactId) {
		return new MavenPluginLocation(this, groupId, artifactId);
	}

	public MavenPluginLocation getPluginLocation(String repository, String groupId, String artifactId) {
		return new MavenPluginLocation(this, repository, groupId, artifactId);
	}
	
	private RepositorySystem newRepositorySystem() {
		DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
		
		locator.addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class);
		locator.addService(TransporterFactory.class, FileTransporterFactory.class);
		locator.addService(TransporterFactory.class, HttpTransporterFactory.class);

		locator.setErrorHandler(new DefaultServiceLocator.ErrorHandler() {
			@Override
			public void serviceCreationFailed(Class<?> type, Class<?> impl, Throwable exception) {
				exception.printStackTrace();
			}
		});

		return locator.getService(RepositorySystem.class);
	}

	private DefaultRepositorySystemSession newRepositorySystemSession(RepositorySystem system, File localRepoFile, Settings settings) {
		DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();
		if (!settings.getMirrors().isEmpty()) {
			DefaultMirrorSelector mirrorSelector = new DefaultMirrorSelector();
			for (Mirror mirror : settings.getMirrors()) {
				mirrorSelector.add(mirror.getId(), mirror.getUrl(), "default", true, mirror.getMirrorOf(), "*");
			}
			session.setMirrorSelector(mirrorSelector);
		}
		session.setProxySelector(proxySelector);

		LocalRepository localRepo = new LocalRepository(localRepoFile);
		session.setLocalRepositoryManager(system.newLocalRepositoryManager(session, localRepo));

		return session;
	}

	public Set<RemoteRepository> getRepositories() {
		return repositories;
	}

	public List<RemoteRepository> getRepositoriesAsList() {
		return new ArrayList<>(repositories);
	}
	
	public RepositorySystemSession getSession() {
		return session;
	}
	
	public RepositorySystem getSystem() {
		return system;
	}

	public void clearCache() throws IOException {
		LOGGER.error("clearCache not supported");
	}

	public List<RemoteRepository> getLocalRepositories() {
		return localRepositories;
	}

	public void addRepository(String id, String type, String url){
		repositories.add(
			new RemoteRepository.Builder(id, type, url).setProxy(proxySelector.getProxy(url)).build()
		);
	}
}