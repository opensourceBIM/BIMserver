package org.bimserver.test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

public class TestNewQueryViaClient {
	public static void main(String[] args) {
		new TestNewQueryViaClient().start();
	}

	private void start() {
		try {
			JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			String projectName = "Test " + new Random().nextInt();
			SProject project = client.getServiceInterface().addProject(projectName, "ifc2x3tc1");
			
			SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
			
			client.checkin(project.getOid(), "Test Model", deserializer.getOid(), false, Flow.SYNC, Paths.get("C:/Git/TestFiles/TestData/data/AC11-FZK-Haus-IFC.ifc"));
			
			project = client.getServiceInterface().getProjectByPoid(project.getOid());
			
			System.out.println(project.getName());
			
			ClientIfcModel model = client.getModel(project, project.getLastRevisionId(), false, false);
			
			Query query = new Query(model.getPackageMetaData());
			
			QueryPart queryPart = query.createQueryPart();
			queryPart.addType(Ifc2x3tc1Package.eINSTANCE.getIfcWall(), true);
			
			for (IfcWall ifcWall : model.getAllWithSubTypes(IfcWall.class)) {
				System.out.println(ifcWall.getGlobalId());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		}
	}
}