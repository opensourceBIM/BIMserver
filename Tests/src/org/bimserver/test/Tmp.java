package org.bimserver.test;

import java.io.File;
import java.io.IOException;

import org.bimserver.LocalDevSetup;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class Tmp {
	public static void main(String[] args) {
		BimServerClientInterface bimServerClient = LocalDevSetup.setupJson("http://localhost:8080");
		
		// Create a project
		try {
			SProject project = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");

			// Look for a deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
			
			// Checkin file
			bimServerClient.checkin(project.getOid(), "test", deserializer.getOid(), false, true, new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));
			
			// Refresh project
			project = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(project.getOid());
			
			// Load model without lazy loading (complete model at once)
			IfcModelInterface model = bimServerClient.getModel(project, project.getLastRevisionId(), false, false);
			
			System.out.println(model.getAllWithSubTypes(IfcWall.class).size());
		} catch (ServerException | UserException | PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		}
	}
}
