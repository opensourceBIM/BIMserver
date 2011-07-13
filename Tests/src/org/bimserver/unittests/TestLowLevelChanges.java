package org.bimserver.unittests;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.activation.DataHandler;

import org.bimserver.BimServer;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.ServerInfo.ServerState;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.emf.IdEObject;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.models.ifc2x3.IfcCartesianPoint;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcSite;
import org.bimserver.models.ifc2x3.IfcWall;
import org.bimserver.models.ifc2x3.IfcWindow;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.SDownloadResult;
import org.bimserver.shared.ServerException;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.UserException;
import org.eclipse.emf.common.util.EList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLowLevelChanges {

	private static BimServer bimServer;
	private static ServiceInterface service;
	private static PluginManager pluginManager;

	@BeforeClass
	public static void setup() {
		try {
			// Create a BIMserver
			bimServer = new BimServer(new File("home"), new LocalDevelopmentResourceFetcher());
			
			// Load plugins
			LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager());

			// Start
			bimServer.start();

			// Convenience, setup the server to make sure it is in RUNNING state
			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				bimServer.getSystemService().setup("http://localhost", "localhost", "Administrator", "admin@bimserver.org", "admin", true);
			}
			
			// Change a setting to normal users can create projects
			bimServer.getSettingsManager().getSettings().setAllowUsersToCreateTopLevelProjects(true);
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (DatabaseRestartRequiredException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}

		service = bimServer.getSystemService();
		pluginManager = bimServer.getPluginManager();
		createUserAndLogin();
	}

	@AfterClass
	public static void shutdown() {
		bimServer.stop();
	}

	private static long createUserAndLogin() {
		int nextInt = new Random().nextInt();
		try {
			String username = "test" + nextInt + "@bimserver.org";
			long addUser = service.addUser(username, "User " + nextInt, SUserType.USER, false);
			service.changePassword(addUser, null, "test");
			service.login(username, "test");
			return addUser;
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		}
		return -1;
	}

	private int createProject() {
		try {
			SProject project = service.addProject("Project " + new Random().nextInt());
			return project.getId();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@Test
	public void testCreateObject() {
		try {
			int pid = createProject();
			service.startTransaction(pid);
			long wallOid = service.createObject("IfcWall");
			long roid = service.commitTransaction();
			IfcModelInterface model = getSingleRevision(roid);
			if (model.size() != 1) {
				fail("1 object expected, found " + model.size());
			}
			IdEObject idEObject = model.getValues().iterator().next();
			if (!(idEObject instanceof IfcWall)) {
				fail("Object should be of type IfcWall but is " + idEObject.eClass().getName());
			}
			if (idEObject.getOid() != wallOid) {
				fail("Oids don't match " + idEObject.getOid() + ", " + wallOid);
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSetStringAttribute() {
		try {
			int pid = createProject();
			service.startTransaction(pid);
			long windowOid = service.createObject("IfcWindow");
			String name = "TestX";
			service.setStringAttribute(windowOid, "IfcWindow", "Name", name);
			long roid = service.commitTransaction();
			IfcModelInterface model = getSingleRevision(roid);
			if (model.size() != 1) {
				fail("1 object expected, found " + model.size());
			}
			IdEObject idEObject = model.getValues().iterator().next();
			if (!(idEObject instanceof IfcWindow)) {
				fail("Object should be of type IfcWindow but is " + idEObject.eClass().getName());
			}
			if (idEObject.getOid() != windowOid) {
				fail("Oids don't match " + idEObject.getOid() + ", " + windowOid);
			}
			String value = (String)idEObject.eGet(idEObject.eClass().getEStructuralFeature("Name"));
			if (!value.equals(name)) {
				fail("Values do not match: " + name + ", " + value);
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSetFloatAttribute() {
		try {
			int pid = createProject();
			service.startTransaction(pid);
			long windowOid = service.createObject("IfcWindow");
			float overallHeight = 200.5f;
			service.setFloatAttribute(windowOid, "IfcWindow", "OverallHeight", overallHeight);
			long roid = service.commitTransaction();
			IfcModelInterface model = getSingleRevision(roid);
			if (model.size() != 1) {
				fail("1 object expected, found " + model.size());
			}
			IdEObject idEObject = model.getValues().iterator().next();
			if (!(idEObject instanceof IfcWindow)) {
				fail("Object should be of type IfcWindow but is " + idEObject.eClass().getName());
			}
			if (idEObject.getOid() != windowOid) {
				fail("Oids don't match " + idEObject.getOid() + ", " + windowOid);
			}
			float value = (Float)idEObject.eGet(idEObject.eClass().getEStructuralFeature("OverallHeight"));
			if (value != overallHeight) {
				fail("Values do not match: " + overallHeight + ", " + value);
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSetReference() {
		try {
			int pid = createProject();
			service.startTransaction(pid);
			long siteId = service.createObject("IfcSite");
			long ownerHistoryId = service.createObject("IfcOwnerHistory");
			service.setReference(siteId, "IfcSite", "OwnerHistory", ownerHistoryId, "IfcOwnerHistory");
			long roid = service.commitTransaction();
			IfcModelInterface model = getSingleRevision(roid);
			if (model.size() != 2) {
				fail("2 objects expected, found " + model.size());
			}
			List<IfcSite> sites = model.getAll(IfcSite.class);
			if (sites.size() != 1) {
				fail("There should have been 1 site, there were " + sites.size());
			}
			List<IfcOwnerHistory> ownerHistories = model.getAll(IfcOwnerHistory.class);
			if (ownerHistories.size() != 1) {
				fail("There should have been 1 ownerhistory, there were " + ownerHistories.size());
			}
			IfcSite site = sites.iterator().next();
			IfcOwnerHistory ownerHistory = ownerHistories.iterator().next();
			if (site.getOwnerHistory() != ownerHistory) {
				fail("Site.OwnerHistory is not referencing the right object");
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testAddFloatAttribute() {
		try {
			int pid = createProject();
			service.startTransaction(pid);
			long cartesianPointId = service.createObject("IfcCartesianPoint");
			float firstVal = 5.1f;
			service.addFloatAttribute(cartesianPointId, "IfcCartesianPoint", "Coordinates", firstVal);
			float secondVal = 6.2f;
			service.addFloatAttribute(cartesianPointId, "IfcCartesianPoint", "Coordinates", secondVal);
			float thirdVal = 7.3f;
			service.addFloatAttribute(cartesianPointId, "IfcCartesianPoint", "Coordinates", thirdVal);
			long roid = service.commitTransaction();
			IfcModelInterface model = getSingleRevision(roid);
			List<IfcCartesianPoint> cartesianPoints = model.getAll(IfcCartesianPoint.class);
			if (cartesianPoints.size() != 1) {
				fail("There should have been 1 IfcCartesianPoint, not " + cartesianPoints.size());
			}
			IfcCartesianPoint ifcCartesianPoint = cartesianPoints.iterator().next();
			EList<Float> coordinates = ifcCartesianPoint.getCoordinates();
			if (coordinates.size() != 3) {
				fail("There should have been 3 coordinates, not " + coordinates.size());
			}
			if (coordinates.get(0) != firstVal || coordinates.get(1) != secondVal || coordinates.get(2) != thirdVal) {
				fail("Values did not match");
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testRemoveObject() {
		try {
			int pid = createProject();
			service.startTransaction(pid);
			long windowId = service.createObject("IfcWindow");
			service.commitTransaction();
			service.startTransaction(pid);
			service.removeObject("IfcWindow", windowId);
			long roid = service.commitTransaction();
			IfcModelInterface model = getSingleRevision(roid);
			if (model.size() != 0) {
				fail("Model should be empty");
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	private IfcModelInterface getSingleRevision(long roid) throws UserException, ServerException, DeserializeException, IOException {
		SRevision revision = service.getRevision(roid);
		SSerializer serializerByContentType = service.getSerializerByContentType("application/ifc");
		int downloadId = service.download(revision.getOid(), serializerByContentType.getName(), true);
		SDownloadResult downloadData = service.getDownloadData(downloadId);
		DataHandler dataHandler = downloadData.getFile();
		DeserializerPlugin deserializerPlugin;
		try {
			deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(pluginManager.requireSchemaDefinition());
			IfcModelInterface model = deserializer.read(dataHandler.getInputStream(), true, 0);
			return model;
		} catch (PluginException e) {
			e.printStackTrace();
		}
		return null;
	}
}