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

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;

public class TestMultiple {
	public static void main(String[] args) throws InterruptedException {
		try (BimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			BimServerClientInterface client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.DAYS, new ArrayBlockingQueue<>(2));
			for (int i=0; i<2; i++) {
				executor.submit(new Runnable(){
					@Override
					public void run() {
						try {
							SProject project = client.getServiceInterface().addProject("P" + new Random().nextInt(), "ifc2x3tc1");
							SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
							long topicId = client.getServiceInterface().initiateCheckin(project.getOid(), deserializer.getOid());
							client.checkinAsync(project.getOid(), "Test", deserializer.getOid(), false, Paths.get("C:\\Git\\TestFiles\\TestData\\data\\HITOS_070308.ifc"), topicId);
						} catch (ServerException e) {
							e.printStackTrace();
						} catch (UserException e) {
							e.printStackTrace();
						} catch (PublicInterfaceNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}});
			}
			executor.shutdown();
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
