package org.bimserver.tests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;

public class RegenerateGeometry {
	public static void main(String[] args) {
		new RegenerateGeometry().start();
	}

	private void start() {
		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
		try {
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
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
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
