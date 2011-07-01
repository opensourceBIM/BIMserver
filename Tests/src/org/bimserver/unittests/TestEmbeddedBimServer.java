package org.bimserver.unittests;

import java.io.File;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.bimserver.BimServer;
import org.bimserver.ServerInfo.ServerState;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.models.ifc2x3.IfcWall;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.ServerException;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.UserException;
import org.bimserver.tests.TestFile;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * This class tests several functionalities on an embedded BIMserver
 */
public class TestEmbeddedBimServer {

	private static String username;
	private static String password;
	private static BimServer bimServer;

	/*
	 * Setup a BIMserver
	 */
	@BeforeClass
	public static void initClass() {
		try {
			// Create a BIMserver
			bimServer = new BimServer(new File("home"), new LocalDevelopmentResourceFetcher());

			// Load plugins
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../CityGML"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../Collada"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../IfcPlugins"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../MiscSerializers"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../O3d"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../IFCEngine"));
			bimServer.getPluginManager().loadPluginsFromEclipseProject(new File("../buildingSMARTLibrary"));

			// Start
			bimServer.start();

			// Convenience, setup the server to make sure it is in RUNNING state
			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				bimServer.getSystemService().setup("http://localhost", "localhost", "Administrator", "admin@bimserver.org", "admin", true);
			}

			// Change a setting to normal users can create projects
			bimServer.getSettingsManager().getSettings().setAllowUsersToCreateTopLevelProjects(true);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (DatabaseRestartRequiredException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Cleanup
	 */
	@AfterClass
	public static void shutdownClass() {
		bimServer.stop();
	}

	/*
	 * Tests whether a user can be created and it's password reset, this user is
	 * also used for subsequent tests
	 */
	@Test
	public void testEmbeddedBimServerCreateUser() {
		try {
			username = "test" + new Random().nextInt() + "@bimserver.org";
			password = "test";
			long userId = bimServer.getSystemService().addUser(username, "Test", SUserType.USER, false);
			bimServer.getSystemService().changePassword(userId, null, password);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This will create a project and checkin the AC11 IFC file
	 */
	@Test
	public void testEmbeddedBimServerUpload() {
		try {
			ServiceInterface service = bimServer.getServiceFactory().newService(AccessMethod.INTERNAL);
			service.login(username, password);
			SProject project = service.addProject("test " + new Random().nextInt());
			File sourceFile = TestFile.AC11.getFile();
			service.checkinSync(project.getOid(), "test", sourceFile.length(), new DataHandler(new FileDataSource(sourceFile)), false);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This will list all projects, select the first project with at least one
	 * revision and dump the names of all walls within the last revision of that
	 * project
	 */
	@Test
	public void testEmbeddedBimServerDump() {
		try {
			ServiceInterface service = bimServer.getServiceFactory().newService(AccessMethod.INTERNAL);
			service.login(username, password);
			BimDatabase database = bimServer.getDatabase();
			BimDatabaseSession session = database.createReadOnlySession();
			SProject firstProjectWithRevisions = null;
			for (SProject project : service.getAllProjects()) {
				System.out.println(project.getName());
				if (!project.getRevisions().isEmpty() && firstProjectWithRevisions == null) {
					firstProjectWithRevisions = project;
				}
			}
			if (firstProjectWithRevisions != null) {
				long roid = firstProjectWithRevisions.getLastRevisionId();
				DownloadDatabaseAction downloadDatabaseAction = new DownloadDatabaseAction(bimServer, session, AccessMethod.INTERNAL, roid, service.getCurrentUser().getOid());
				IfcModelInterface ifcModelInterface = downloadDatabaseAction.execute();
				for (IfcWall ifcWall : ifcModelInterface.getAllWithSubTypes(IfcWall.class)) {
					System.out.println(ifcWall.getName());
				}
			}
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		}
	}
}
