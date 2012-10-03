package org.bimserver.unittests;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.activation.DataHandler;

import org.apache.commons.io.FileUtils;
import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.store.ServerState;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.ServiceInterface;
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
			File home = new File("home");
			if (home.isDirectory()) {
				FileUtils.deleteDirectory(home);
			}
			
			// Create a BIMserver
			BimServerConfig config = new BimServerConfig();
			config.setHomeDir(new File("home"));
			config.setResourceFetcher(new LocalDevelopmentResourceFetcher());
			bimServer = new BimServer(config);
			
			// Load plugins
			LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager());

			// Start
			bimServer.start();

			// Convenience, setup the server to make sure it is in RUNNING state
			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				bimServer.getSystemService().setup("http://localhost", "localhost", "no-reply@bimserver.org", "Administrator", "admin@bimserver.org", "admin");
			}
			
			// Change a setting to normal users can create projects
//			bimServer.getSettingsManager().getSettings().setAllowUsersToCreateTopLevelProjects(true);
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (DatabaseRestartRequiredException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
			long addUser = service.addUser(username, "User " + nextInt, SUserType.USER, false).getOid();
			service.changePassword(addUser, null, "test");
			service.login(username, "test");
			return addUser;
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return -1;
	}

	private long createProject() {
		try {
			SProject project = service.addProject("Project " + new Random().nextInt());
			return project.getOid();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@Test
	public void test() {
		testCreateObject();
		testSetStringAttribute();
		testSetFloatAttribute();
		testSetReference();
		testAddFloatAttribute();
		testRemoveObject();
	}
	
	public void testCreateObject() {
		try {
			long poid = createProject();
			service.startTransaction(poid);
			long wallOid = service.createObject("IfcWall");
			long roid = service.commitTransaction("test");
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

	public void testSetStringAttribute() {
		try {
			long poid = createProject();
			service.startTransaction(poid);
			long windowOid = service.createObject("IfcWindow");
			String name = "TestX";
			service.setStringAttribute(windowOid, "Name", name);
			long roid = service.commitTransaction("test");
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

	public void testSetFloatAttribute() {
		try {
			long poid = createProject();
			service.startTransaction(poid);
			long windowOid = service.createObject("IfcWindow");
			double overallHeight = 200.5;
			service.setDoubleAttribute(windowOid, "OverallHeight", overallHeight);
			long roid = service.commitTransaction("test");
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
			double value = (Double)idEObject.eGet(idEObject.eClass().getEStructuralFeature("OverallHeight"));
			if (value != overallHeight) {
				fail("Values do not match: " + overallHeight + ", " + value);
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	public void testSetReference() {
		try {
			long poid = createProject();
			service.startTransaction(poid);
			long siteId = service.createObject("IfcSite");
			long ownerHistoryId = service.createObject("IfcOwnerHistory");
			service.setReference(siteId, "OwnerHistory", ownerHistoryId); // TODO test
			long roid = service.commitTransaction("test");
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

	public void testAddFloatAttribute() {
		try {
			long poid = createProject();
			service.startTransaction(poid);
			long cartesianPointId = service.createObject("IfcCartesianPoint");
			double firstVal = 5.1;
			service.addDoubleAttribute(cartesianPointId, "Coordinates", firstVal);
			double secondVal = 6.2;
			service.addDoubleAttribute(cartesianPointId, "Coordinates", secondVal);
			double thirdVal = 7.3;
			service.addDoubleAttribute(cartesianPointId, "Coordinates", thirdVal);
			long roid = service.commitTransaction("test");
			IfcModelInterface model = getSingleRevision(roid);
			List<IfcCartesianPoint> cartesianPoints = model.getAll(IfcCartesianPoint.class);
			if (cartesianPoints.size() != 1) {
				fail("There should have been 1 IfcCartesianPoint, not " + cartesianPoints.size());
			}
			IfcCartesianPoint ifcCartesianPoint = cartesianPoints.iterator().next();
			EList<Double> coordinates = ifcCartesianPoint.getCoordinates();
			if (coordinates.size() != 3) {
				fail("There should have been 3 coordinates, not " + coordinates.size());
			}
			if (coordinates.get(0) != firstVal || coordinates.get(1) != secondVal || coordinates.get(2) != thirdVal) {
				fail("Values did not match");
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	public void testRemoveObject() {
		try {
			long poid = createProject();
			service.startTransaction(poid);
			long windowId = service.createObject("IfcWindow");
			service.commitTransaction("test");
			service.startTransaction(poid);
			service.removeObject(windowId);
			long roid = service.commitTransaction("test");
			IfcModelInterface model = getSingleRevision(roid);
			if (model.size() != 0) {
				fail("Model should be empty");
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	private IfcModelInterface getSingleRevision(long roid) throws ServiceException, DeserializeException, IOException {
		SRevision revision = service.getRevision(roid);
		SSerializerPluginConfiguration serializerByContentType = service.getSerializerByContentType("application/ifc");
		long downloadId = service.download(revision.getOid(), serializerByContentType.getOid(), true, true);
		SDownloadResult downloadData = service.getDownloadData(downloadId);
		DataHandler dataHandler = downloadData.getFile();
		try {
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			Deserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(pluginManager.requireSchemaDefinition());
			IfcModelInterface model = deserializer.read(dataHandler.getInputStream(), "test.ifc", true, 0);
			return model;
		} catch (PluginException e) {
			e.printStackTrace();
		}
		return null;
	}
}