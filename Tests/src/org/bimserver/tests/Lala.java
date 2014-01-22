package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.List;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lala {
	private Logger log = LoggerFactory.getLogger(Lala.class);
	
	public static void main(String[] args) {
		new Lala().start();
	}

	private void start() {
		BimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
		UsernamePasswordAuthenticationInfo info = new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin");
		BimServerClientInterface client;
		try {
			client = factory.create(info);
			// ..Snippet..//
			log.info("Getting User details:");
			
			if (client.getBimsie1AuthInterface().isLoggedIn()) {
				log.info("Current User");
				System.out.println(client.getBimServerAuthInterface().getLoggedInUser());
				
				if (client.getBimServerAuthInterface().getLoggedInUser().getUserType() == SUserType.ADMIN) {
					log.info("Administrator Detected, Listing All Users.");
					List<SUser> users = client.getServiceInterface().getAllUsers();
					log.info(String.format("All Users[%s]:", users.size()));
					for (SUser usr : users) {
						System.out.println(usr);
					}
				} else {
					log.info("Administrator Rights required to list all users.");
				}
			} else {
				log.warn("Not Logged into server?\nNeed to be logged in to request User Details\nMoving Along.");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}

	}
}
