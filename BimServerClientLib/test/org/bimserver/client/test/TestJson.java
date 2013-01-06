package org.bimserver.client.test;

import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class TestJson {
	public static void main(String[] args) {
		BimServerClient bimServerClient = new BimServerClient("http://localhost:8080");
		bimServerClient.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin")); 
		try {
			bimServerClient.connectJson(false);
			List<SProject> allProjects = bimServerClient.getServiceInterface().getAllProjects(true);
			System.out.println(allProjects);
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} 
	}
}
