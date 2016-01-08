package org.bimserver.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

public class TestManyUsersAndLogin {
	public static void main(String[] args) {
		new TestManyUsersAndLogin().start();
	}

	private void start() {
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			int nrUsers = 10000;
			long totalTimeAdding = 0;
			List<Long> userIds = new ArrayList<>();
			for (int i=0; i<nrUsers; i++) {
				long s = System.nanoTime();
				try {
					SUser user = client.getServiceInterface().addUserWithPassword("test" + i + "@bimserver.org", "password", "Test " + i, SUserType.USER, true, "");
					userIds.add(user.getOid());
				} catch (Exception e) {
					
				}
				long e = System.nanoTime();
				totalTimeAdding += (e - s);
				if (i % 100 == 0) {
					System.out.println((totalTimeAdding / 1000000) + " ms for 100 users");
					totalTimeAdding = 0;
				}
			}
			long totalLoginTime = 0;
			
			int nrProjects = 10000;
			totalTimeAdding = 0;
			List<Long> projectIds = new ArrayList<>();
			for (int i=0; i<nrProjects; i++) {
				long s = System.nanoTime();
				try {
					SProject project = client.getBimsie1ServiceInterface().addProject("test" + i, "ifc2x3tc1");
					projectIds.add(project.getOid());
				} catch (Exception e) {
					
				}
				long e = System.nanoTime();
				totalTimeAdding += (e - s);
				if (i % 100 == 0) {
					System.out.println((totalTimeAdding / 1000000) + " ms for 100 projects");
					totalTimeAdding = 0;
				}
			}
			
			int nrProjectUserLinks = 100000;
			Random random = new Random();
			totalTimeAdding = 0;
			for (int i=0; i<nrProjectUserLinks ; i++) {
				long s = System.nanoTime();
				client.getServiceInterface().addUserToProject(userIds.get(random.nextInt(userIds.size())), projectIds.get(random.nextInt(projectIds.size())));
				long e = System.nanoTime();
				totalTimeAdding += (e - s);
				if (i % 100 == 0) {
					System.out.println((totalTimeAdding / 1000000) + " ms for 100 projects/user links");
					totalTimeAdding = 0;
				}
			}
			
			int loginAttempts = 100;
			for (int i=0; i<loginAttempts; i++) {
				long s = System.nanoTime();
				client.getBimsie1AuthInterface().login("test" + new Random().nextInt(nrUsers) + "@bimserver.org", "password");
				long e = System.nanoTime();
				totalLoginTime += (e - s);
			}
			System.out.println("Average login time with " + nrUsers + " users in system: " + ((((totalLoginTime / loginAttempts) / 1000000) + " ms")));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
