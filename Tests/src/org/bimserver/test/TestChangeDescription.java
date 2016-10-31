package org.bimserver.test;

import org.bimserver.LocalDevSetup;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class TestChangeDescription {
	public static void main(String[] args) {
		new TestChangeDescription().start();
	}

	private void start() {
		BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
		try {
			SProject project = client.getServiceInterface().getProjectsByName("dfgfgdf").get(0);
			IfcModelInterface model = client.getModel(project, project.getLastRevisionId(), false, true);
			for (IfcWall wall : model.getAllWithSubTypes(IfcWall.class)) {
				wall.setDescription(wall.getDescription() + " Changed");
			}
			model.commit("test");
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		}
	}
}
