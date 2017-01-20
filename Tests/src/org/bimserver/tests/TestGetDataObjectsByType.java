package org.bimserver.tests;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

public class TestGetDataObjectsByType {
	public static void main(String[] args) {
		new TestGetDataObjectsByType().start();
	}

	private void start() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			SProject project = client.getServiceInterface().addProject(new Random().nextInt() + "", "ifc2x3tc1");
			SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
			client.checkin(project.getOid(), "test", deserializer.getOid(), false, Flow.SYNC, Paths.get("C:\\Git\\TestFiles\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc"));
			project = client.getServiceInterface().getProjectByPoid(project.getOid());
			List<SDataObject> result = client.getLowLevelInterface().getDataObjectsByType(project.getLastRevisionId(), "ifc2x3tc1", "IfcRelContainedInSpatialStructure", false);
			for (SDataObject dataObject : result) {
				System.out.println(dataObject.getGuid() + " " + dataObject.getName() + "");
				System.out.println(dataObject.getValues().size());
			}
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
