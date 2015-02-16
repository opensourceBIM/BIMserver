package org.bimserver.tests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

public class RegenerateGeometry {
	public static void main(String[] args) {
		new RegenerateGeometry().start();
	}

	private void start() {
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			List<SProject> allProjects = client.getBimsie1ServiceInterface().getAllProjects(false, true);
			Set<Long> croids = new HashSet<Long>();
			for (SProject project : allProjects) {
				for (Long roid : project.getRevisions()) {
					SRevision revision = client.getBimsie1ServiceInterface().getRevision(roid);
					for (long croid : revision.getConcreteRevisions()) {
						croids.add(croid);
					}
				}
			}
			for (long croid : croids) {
				client.getAdminInterface().regenerateGeometry(croid);
			}
			System.out.println("Done");
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
