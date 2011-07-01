package org.bimserver.unittests;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.activation.DataHandler;

import org.bimserver.BimServer;
import org.bimserver.emf.IdEObject;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.models.ifc2x3.IfcWall;
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
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLowLevelChanges {
	
	private static BimServer bimServer;
	private static ServiceInterface service;
	private static SProject project;
	private static PluginManager pluginManager;

	@BeforeClass
	public static void setup() {
		bimServer = new BimServer(new File("home"), new LocalDevelopmentResourceFetcher());
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
			project = service.addProject("Project " + new Random().nextInt());
			service.addUserToProject(addUser, project.getOid());
			service.login(username, "test");
			return addUser;
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
			service.startTransaction(project.getId());
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
		} catch (UserException e) {
			fail(e.getMessage());
		} catch (ServerException e) {
			fail(e.getMessage());
		} catch (DeserializeException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSetAttribute() {
		try {
			service.startTransaction(project.getId());
			long wallOid = service.createObject("IfcWindow");
			service.setAttribute(wallOid, "IfcWall", "OverallHeight", "200");
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
		} catch (UserException e) {
			fail(e.getMessage());
		} catch (ServerException e) {
			fail(e.getMessage());
		} catch (DeserializeException e) {
			fail(e.getMessage());
		} catch (IOException e) {
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