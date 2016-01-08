package org.bimserver.test;

import java.io.IOException;
import java.nio.file.Paths;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void start() {
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			final SSerializerPluginConfiguration serializer = client.getBimsie1ServiceInterface().getSerializerByName("BinaryGeometrySerializer");
			SProject project = client.getBimsie1ServiceInterface().getProjectByPoid(131073L);
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
