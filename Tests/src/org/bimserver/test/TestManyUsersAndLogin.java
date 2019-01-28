package org.bimserver.test;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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
					SProject project = client.getServiceInterface().addProject("test" + i, "ifc2x3tc1");
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
				client.getAuthInterface().login("test" + new Random().nextInt(nrUsers) + "@bimserver.org", "password");
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
