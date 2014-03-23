package org.bimserver;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerState;
import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.PluginException;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.webservices.authorization.SystemAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemoryLeakTester {
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDevBimServerStarter.class);
	private BimServer bimServer;
	
	public static void main(String[] args) {
		new MemoryLeakTester().start(1, "localhost", 8080, 8085, new OptionsParser(args).getPluginDirectories());
	}

	public void start(int id, String address, int port, int pbport, File[] pluginDirectories) {
		BimServerConfig config = new BimServerConfig();
		config.setHomeDir(new File("home" + id));
		config.setResourceFetcher(new LocalDevelopmentResourceFetcher(new File("../")));
		config.setStartEmbeddedWebServer(true);
		config.setClassPath(System.getProperty("java.class.path"));
		config.setInitialProtocolBuffersPort(pbport);
		config.setStartCommandLine(false);
		config.setLocalDev(true);
		config.setPort(port);
		bimServer = new BimServer(config);
		bimServer.getVersionChecker().getLocalVersion().setDate(new Date());
		try {
	 		LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), new File(".."), pluginDirectories);
			bimServer.start();
			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				AdminInterface adminInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(AdminInterface.class);
				adminInterface.setup("http://localhost:" + port, "localhost", "no-reply@bimserver.org", "Administrator", "admin@bimserver.org", "admin");
				SettingsInterface settingsInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(SettingsInterface.class);
				settingsInterface.setCacheOutputFiles(false);
			}
			bimServer.stop();
			bimServer = null;
			Thread.sleep(1000000);
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (DatabaseInitException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} catch (DatabaseRestartRequiredException e) {
			LOGGER.error("", e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
