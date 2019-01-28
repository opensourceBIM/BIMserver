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
