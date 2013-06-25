package org.bimserver.tests;

import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
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
		BimServerClient client;
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
