package org.bimserver.database.actions;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.PluginBundleVersion;
import org.bimserver.plugins.GitHubPluginRepository;
import org.bimserver.plugins.PluginBundle;
import org.bimserver.plugins.PluginBundleIdentifier;
import org.bimserver.plugins.PluginLocation;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetInstalledPluginBundles extends PluginBundleDatabaseAction<List<SPluginBundle>> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetInstalledPluginBundle.class);
	private BimServer bimServer;
	private boolean strictVersionChecking;
	private DefaultArtifactVersion bimserverVersion;

	public GetInstalledPluginBundles(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, boolean strictVersionChecking) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.strictVersionChecking = strictVersionChecking;
	}

	@Override
	public List<SPluginBundle> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		List<SPluginBundle> result = Collections.synchronizedList(new ArrayList<>());

		bimserverVersion = new DefaultArtifactVersion(bimServer.getVersionChecker().getLocalVersion().getFullString());

		GitHubPluginRepository repository = new GitHubPluginRepository(bimServer.getMavenPluginRepository(), bimServer.getServerSettingsCache().getServerSettings().getServiceRepositoryUrl());

		Map<PluginBundleIdentifier, PluginLocation<?>> repositoryKnownLocation = new HashMap<>();
		for (PluginLocation<?> pluginLocation : repository.listPluginLocations()) {
			repositoryKnownLocation.put(pluginLocation.getPluginIdentifier(), pluginLocation);
		}
		
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 32, 1L, TimeUnit.HOURS, new ArrayBlockingQueue<>(100));
		
		for (PluginBundle currentlyInstalledPluginBundle : bimServer.getPluginBundleManager().getPluginBundles()) {
			SPluginBundleVersion installedVersion = currentlyInstalledPluginBundle.getPluginBundleVersion();
			for (PluginBundleVersion pluginBundleVersion : getDatabaseSession().getAll(PluginBundleVersion.class)) {
				if (pluginBundleVersion.getArtifactId().equals(installedVersion.getArtifactId()) && pluginBundleVersion.getGroupId().equals(installedVersion.getGroupId()) && pluginBundleVersion.getVersion().equals(installedVersion.getVersion())) {
					installedVersion.setOid(pluginBundleVersion.getOid());
				}
			}

			PluginBundleIdentifier pluginBundleIdentifier = new PluginBundleIdentifier(installedVersion.getGroupId(), installedVersion.getArtifactId());
			PluginLocation<?> pluginLocation = repositoryKnownLocation.get(pluginBundleIdentifier);

			threadPoolExecutor.submit(new Runnable(){
				@Override
				public void run() {
					SPluginBundle sPluginBundle = processPluginLocation(pluginLocation, strictVersionChecking, bimserverVersion);
					
					if (sPluginBundle == null) {
						// No versions found on repository
						sPluginBundle = currentlyInstalledPluginBundle.getPluginBundle();
					}
					
					boolean found = false;
					for (SPluginBundleVersion sPluginBundleVersion : sPluginBundle.getAvailableVersions()) {
						if (sPluginBundleVersion.getVersion().equals(currentlyInstalledPluginBundle.getPluginBundleVersion().getVersion())) {
							found = true;
						}
					}
					if (!found) {
						// Add the currently installed version if it's not in the list of available plugins
						sPluginBundle.getAvailableVersions().add(currentlyInstalledPluginBundle.getPluginBundleVersion());
					}
					sPluginBundle.setInstalledVersion(installedVersion);
					Collections.sort(sPluginBundle.getAvailableVersions(), new Comparator<SPluginBundleVersion>() {
						private List<Integer> split(String in) {
							List<Integer> result = new ArrayList<>();
							for (String s : in.split("\\.")) {
								if (s.endsWith("-SNAPSHOT")) {
									s = s.substring(0, s.length() - 9);
								}
								result.add(Integer.parseInt(s));
							}
							return result;
						}
						@Override
						public int compare(SPluginBundleVersion o1, SPluginBundleVersion o2) {
							// Ideally we would not depend on a specific versioning scheme, but alas
							String v1 = o1.getVersion();
							String v2 = o2.getVersion();
							if (v1.contains(".") && v2.contains(".")) {
								List<Integer> v1s = split(v1);
								List<Integer> v2s = split(v2);
								for (int i=0; i<v1s.size(); i++) {
									if (v1s.get(i) == v2s.get(i)) {
										// Continue
									} else {
										return v2s.get(i) - v1s.get(i);
									}
								}
							} else {
								// Fall back to string based compare
								return v1.compareTo(v2);
							}
							return 0;
						}});
					
					result.add(sPluginBundle);
				}});
		}


		threadPoolExecutor.shutdown();
		try {
			threadPoolExecutor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Collections.sort(result, new Comparator<SPluginBundle>(){

			@Override
			public int compare(SPluginBundle o1, SPluginBundle o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		return result;
	}
}