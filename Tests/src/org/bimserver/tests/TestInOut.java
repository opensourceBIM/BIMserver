package org.bimserver.tests;

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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.LocalDevSetup;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerState;
import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.tests.diff.CompareException;
import org.bimserver.tests.diff.Diff;
import org.bimserver.utils.PathUtils;
import org.bimserver.webservices.authorization.SystemAuthorization;

public class TestInOut {
	public static void main(String[] args) {
		new TestInOut().start(args);
	}

	private void start(String[] args) {
		BimServerConfig config = new BimServerConfig();
		Path homeDir = Paths.get("home");
		try {
			if (Files.isDirectory(homeDir)) {
				PathUtils.removeDirectoryWithContent(homeDir);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		config.setClassPath(System.getProperty("java.class.path"));
		config.setHomeDir(homeDir);
		config.setPort(8080);
		config.setStartEmbeddedWebServer(true);
		config.setResourceFetcher(new LocalDevelopmentResourceFetcher(Paths.get("../")));

		BimServer bimServer = new BimServer(config);
		try {
			LocalDevPluginLoader.loadPlugins(bimServer.getPluginBundleManager(), new OptionsParser(args).getPluginDirectories());
			bimServer.start();
			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				AdminInterface adminInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(AdminInterface.class);
				adminInterface.setup("http://localhost:8080", "Administrator", "admin@bimserver.org", "admin", null, null, null);
				SettingsInterface settingsInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(SettingsInterface.class);
				settingsInterface.setCacheOutputFiles(false);
			}
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			SProject project = client.getServiceInterface().addProject("test", "ifc2x3tc1");
			SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
			Path inputFile = Paths.get("../TestData/data/AC11-Institute-Var-2-IFC.ifc");
			client.checkinSync(project.getOid(), "test", deserializer.getOid(), false, inputFile);
			project = client.getServiceInterface().getProjectByPoid(project.getOid());
			SSerializerPluginConfiguration serializer = client.getServiceInterface().getSerializerByContentType("application/ifc");
			Path outputFile = Paths.get("output.ifc");
			client.download(project.getLastRevisionId(), serializer.getOid(), outputFile);
			
			Diff diff = new Diff(false, false, false, inputFile, outputFile);
			diff.start();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DatabaseRestartRequiredException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CompareException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		}
	}
}