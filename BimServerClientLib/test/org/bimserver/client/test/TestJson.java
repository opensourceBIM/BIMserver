package org.bimserver.client.test;

import java.util.Random;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;

public class TestJson {
	public static void main(String[] args) {
		BimServerClient bimServerClient = new BimServerClient("http://localhost:8080");
		bimServerClient.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin")); 
		try {
			bimServerClient.connectJson();
			ServiceInterface serviceInterface = bimServerClient.getServiceInterface();
			for (int i=0; i<1000; i++) {
				long s = System.nanoTime();
				serviceInterface.addProject(new Random().nextInt() + " " + i);
				long e = System.nanoTime();
				System.out.println(((e - s) / 1000000) + " ms");
			}
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}
}