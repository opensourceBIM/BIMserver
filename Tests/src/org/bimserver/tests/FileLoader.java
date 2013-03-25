package org.bimserver.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.JsonBimServerClientFactory;
import org.bimserver.client.PublicInterfaceNotFoundException;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;

public class FileLoader {
	public static void main(String[] args) {
		new FileLoader().load(new File("C:\\Users\\Ruben de Laat\\Dropbox\\Shared\\BIMserver\\LOD modellen"));
	}

	private void load(File dir) {
//		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://sandbox.bimserver.org");
		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
		try {
			final BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			ExecutorService executorService = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(200));
			for (final File file : dir.listFiles()) {
				executorService.submit(new Runnable(){
					@Override
					public void run() {
						System.out.println(file.getName());
						SProject project;
						try {
							project = client.getServiceInterface().addProject(file.getName());
							SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc");
							client.checkin(project.getOid(), file.getName(), deserializer.getOid(), false, true, file);
						} catch (ServerException e) {
							e.printStackTrace();
						} catch (UserException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (PublicInterfaceNotFoundException e) {
							e.printStackTrace();
						}
					}});
			}
			executorService.awaitTermination(1, TimeUnit.HOURS);
			System.out.println("Done");
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}