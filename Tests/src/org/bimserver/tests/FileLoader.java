package org.bimserver.tests;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.PathUtils;

public class FileLoader {
	public static void main(String[] args) {
		new FileLoader().load(Paths.get("C:\\Users\\Ruben de Laat\\Dropbox\\Shared\\BIMserver\\LOD modellen"));
	}

	private void load(Path dir) {
//		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://sandbox.bimserver.org");
		try {
			final BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			ExecutorService executorService = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(200));
			for (final Path file : PathUtils.getDirectories(dir)) {
				executorService.submit(new Runnable(){
					@Override
					public void run() {
						System.out.println(file.getFileName());
						SProject project;
						try {
							project = client.getBimsie1ServiceInterface().addProject(file.getFileName().toString(), "ifc2x3tc1");
							SDeserializerPluginConfiguration deserializer = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
							client.checkin(project.getOid(), file.getFileName().toString(), deserializer.getOid(), false, true, file);
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
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}