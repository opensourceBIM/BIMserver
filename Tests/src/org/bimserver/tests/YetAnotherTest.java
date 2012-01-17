package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.Session;
import org.bimserver.client.factories.UsernamePasswordAuthenticationInfo;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3.IfcProject;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class YetAnotherTest {
	public static void main(String[] args) {
		new YetAnotherTest().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			BimServerClient bimServerClient = new BimServerClient(pluginManager);
			bimServerClient.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			bimServerClient.connectProtocolBuffers("localhost", 8020);
			String pName = "p java client" + new java.util.Date();
			SProject addProject = bimServerClient.getServiceInterface().addProject(pName);
			Session session = bimServerClient.createSession();
			session.startTransaction(addProject.getId());
			IfcProject ifcProject = session.create(IfcProject.class);
			ifcProject.setName("This is a test");
			long roid = session.commitTransaction("This is a test commitTransaction");

			Integer downloadId = bimServerClient.getServiceInterface().download(roid, "Ifc2x3", true, false);
			SDownloadResult downloadData = bimServerClient.getServiceInterface().getDownloadData(downloadId);
			IOUtils.copy(downloadData.getFile().getInputStream(), new FileOutputStream(new File("model.ifc")));
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
}
