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
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.GitHubPluginRepository;
import org.bimserver.plugins.PluginBundle;
import org.bimserver.plugins.PluginLocation;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class GetAvailablePluginBundles extends PluginBundleDatabaseAction<List<SPluginBundle>> {
	private BimServer bimServer;
	private boolean strictVersionChecking;
	private DefaultArtifactVersion bimserverVersion;

	public GetAvailablePluginBundles(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, boolean strictVersionChecking) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.strictVersionChecking = strictVersionChecking;
	}

	@Override
	public List<SPluginBundle> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		List<SPluginBundle> result = new ArrayList<>();

		GitHubPluginRepository repository = new GitHubPluginRepository(bimServer.getMavenPluginRepository(), bimServer.getServerSettingsCache().getServerSettings().getServiceRepositoryUrl());

		bimserverVersion = new DefaultArtifactVersion(bimServer.getVersionChecker().getLocalVersion().getFullString());

		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(32, 32, 1L, TimeUnit.HOURS, new ArrayBlockingQueue<>(100));

		for (PluginLocation<?> pluginLocation : repository.listPluginLocations()) {
			PluginBundle pluginBundle = bimServer.getPluginBundleManager().getPluginBundle(pluginLocation.getPluginIdentifier());
			// Skipping all plugin bundles that already have an installed version
			if (pluginBundle == null) {
				threadPoolExecutor.submit(new Runnable(){
					@Override
					public void run() {
						SPluginBundle sPluginBundle = processPluginLocation(pluginLocation, strictVersionChecking, bimserverVersion);
						if (sPluginBundle != null) {
							result.add(sPluginBundle);
						}
					}					
				});
			}
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