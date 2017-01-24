package org.bimserver.test;

import java.io.File;
import java.util.ArrayList;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.utils.FileDataSource;

public class TestInstall {
	public static void main(String[] args) {
		ArrayList<String> pluginList = new ArrayList<>();
		pluginList.add("C:/plugins/ifcplugins-0.0.15.jar");

		try (BimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			BimServerClientInterface client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			for (String each : pluginList) {
				try {
					DataSource fds = new FileDataSource(new File(each));
					DataHandler handler = new DataHandler(fds);
					client.getPluginInterface().installPluginBundleFromFile(handler, true, true);
					System.out.println("Plugin " + each + " successfully installed !");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (BimServerClientException e1) {
			e1.printStackTrace();
		} catch (ServiceException e1) {
			e1.printStackTrace();
		} catch (ChannelConnectionException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
