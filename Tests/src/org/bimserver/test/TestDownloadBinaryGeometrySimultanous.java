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

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

public class TestDownloadBinaryGeometrySimultanous {
	public static void main(String[] args) {
		new TestDownloadBinaryGeometrySimultanous().start();
	}

	private class Runner extends Thread {

		private BimServerClientInterface client;
		private SSerializerPluginConfiguration serializer;
		private SProject project;
		private int i;

		public Runner(BimServerClientInterface client, SSerializerPluginConfiguration serializer, SProject project, int i) {
			this.client = client;
			this.serializer = serializer;
			this.project = project;
			this.i = i;
		}
		
		@Override
		public void run() {
			try {
				client.download(project.getLastRevisionId(), serializer.getOid(), Paths.get("output" + i + ".data"));
			} catch (IOException | BimServerClientException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void start() {
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			final SSerializerPluginConfiguration serializer = client.getServiceInterface().getSerializerByName("BinaryGeometrySerializer");
			SProject project = client.getServiceInterface().getProjectByPoid(131073L);
			for (int i=0; i<10; i++) {
				Thread.sleep(200);
				new Runner(client, serializer, project, i).start();
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
