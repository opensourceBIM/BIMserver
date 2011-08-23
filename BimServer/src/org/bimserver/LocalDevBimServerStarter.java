package org.bimserver;

import java.io.File;

import org.bimserver.ServerInfo.ServerState;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.plugins.PluginException;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.ServerException;
import org.bimserver.shared.UserException;

public class LocalDevBimServerStarter {
	public static void main(String[] args) {
		BimServer bimServer = new BimServer(new File("home"), new LocalDevelopmentResourceFetcher());
		try {
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../CityGML"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../Collada"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../IfcPlugins"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../MiscSerializers"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../O3d"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../IFCEngine"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../buildingSMARTLibrary"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../DeserializerExample"));
			bimServer.start();
			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				bimServer.getSystemService().setup("http://localhost", "localhost", "Administrator", "admin@bimserver.org", "admin", true);
			}
		} catch (PluginException e1) {
			e1.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (DatabaseRestartRequiredException e) {
			e.printStackTrace();
		}
	}
}
