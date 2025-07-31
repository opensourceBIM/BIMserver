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

import org.apache.commons.lang.RandomStringUtils;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static org.junit.Assert.fail;

public class GetAllAccounts {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetAllAccounts.class);
	public static void main(String[] args){
		new GetAllAccounts().start();
	}

	private void start() {
		try (BimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")){
			try (BimServerClientInterface client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				ArrayList<String> users = new ArrayList<>();
				//if the server already has users
				for (SUser user : client.getServiceInterface().getAllUsers()) {
					users.add(user.getUsername().toLowerCase());
				}
				for (int i = 0; i < 20; i++) {
					String username = RandomStringUtils.randomAlphanumeric(5) + "@bimserver.org";
					String password = RandomStringUtils.randomAlphanumeric(5);
					users.add(username.toLowerCase());
					client.getServiceInterface().addUserWithPassword(username,password,username, SUserType.USER,false, "https://bimserver.org");
				}
				for (SUser user : client.getServiceInterface().getAllUsers()) {
					if (!users.contains(user.getUsername().toLowerCase())) {
						fail("User " + user.getUsername() + " not found");
					}
				}
				System.out.println("done");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (BimServerClientException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
