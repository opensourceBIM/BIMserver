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

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.queries.om.DefaultQueries;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerState;
import org.bimserver.plugins.serializers.CacheStoringEmfSerializerDataSource;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.utils.PathUtils;
import org.bimserver.webservices.ServiceMap;

public class TestSimultaniousDownloadWithCaching {
	public static void main(String[] args) {
		new TestSimultaniousDownloadWithCaching().start();
	}

	private void start() {
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
		final BimServer bimServer = new BimServer(config);
		try {
			LocalDevPluginLoader.loadPlugins(bimServer.getPluginBundleManager(), null);
			bimServer.start();
			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				bimServer.getService(AdminInterface.class).setup("http://localhost", "Administrator", "admin@bimserver.org", "admin", null, null, null);
			}
		} catch (PluginException e2) {
			e2.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (DatabaseRestartRequiredException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}

		try {
			final ServiceMap serviceMap = bimServer.getServiceFactory().get(AccessMethod.INTERNAL);
			ServiceInterface serviceInterface = serviceMap.get(ServiceInterface.class);
			SettingsInterface settingsInterface = serviceMap.get(SettingsInterface.class);
			final AuthInterface authInterface = serviceMap.get(AuthInterface.class);
			serviceInterface = bimServer.getServiceFactory().get(authInterface.login("admin@bimserver.org", "admin"), AccessMethod.INTERNAL).get(ServiceInterface.class);
			settingsInterface.setCacheOutputFiles(true);
			settingsInterface.setGenerateGeometryOnCheckin(false);
			final SProject project = serviceMap.getServiceInterface().addProject("test", "ifc2x3tc1");
			SDeserializerPluginConfiguration deserializerByName = serviceMap.getServiceInterface().getDeserializerByName("IfcStepDeserializer");
			Path file = Paths.get("../TestData/data/AC11-Institute-Var-2-IFC.ifc");
			serviceInterface.checkinSync(project.getOid(), "test", deserializerByName.getOid(), file.toFile().length(), file.getFileName().toString(), new DataHandler(new FileDataSource(file.toFile())), false);
			final SProject projectUpdate = serviceMap.getServiceInterface().getProjectByPoid(project.getOid());
			ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 20, 1, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(1000));
			for (int i=0; i<20; i++) {
				executor.execute(new Runnable(){
					@Override
					public void run() {
						try {
							ServiceMap serviceMap2 = bimServer.getServiceFactory().get(authInterface.login("admin@bimserver.org", "admin"), AccessMethod.INTERNAL);
							SSerializerPluginConfiguration serializerPluginConfiguration = serviceMap.getServiceInterface().getSerializerByName("Ifc2x3");
							Long download = serviceMap2.getServiceInterface().download(Collections.singleton(projectUpdate.getLastRevisionId()), DefaultQueries.allAsString(), serializerPluginConfiguration.getOid(), true);
							SDownloadResult downloadData = serviceMap2.getServiceInterface().getDownloadData(download);
							if (downloadData.getFile().getDataSource() instanceof CacheStoringEmfSerializerDataSource) {
								CacheStoringEmfSerializerDataSource c = (CacheStoringEmfSerializerDataSource)downloadData.getFile().getDataSource();
								try {
									ByteArrayOutputStream baos = new ByteArrayOutputStream();
									c.writeToOutputStream(baos, null);
									System.out.println(baos.size());
								} catch (SerializerException e) {
									e.printStackTrace();
								}
							} else {
								ByteArrayOutputStream baos = new ByteArrayOutputStream();
								IOUtils.copy(downloadData.getFile().getInputStream(), baos);
								System.out.println(baos.size());
							}
							serviceMap2.getServiceInterface().cleanupLongAction(download);
						} catch (ServerException e) {
							e.printStackTrace();
						} catch (UserException e) {
							e.printStackTrace();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (PublicInterfaceNotFoundException e1) {
							e1.printStackTrace();
						}
					}});
			}
			executor.shutdown();
			executor.awaitTermination(1, TimeUnit.HOURS);
			bimServer.stop();
		} catch (ServerException e1) {
			e1.printStackTrace();
		} catch (UserException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e2) {
			e2.printStackTrace();
		}
	}
}