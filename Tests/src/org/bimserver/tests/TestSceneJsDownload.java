package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.ServicesMap;

public class TestSceneJsDownload {
	public static void main(String[] args) {
		new TestSceneJsDownload().start();
	}

	private void start() {
		try {
			ServicesMap servicesMap = new ServicesMap();
			servicesMap.add(new SService(null, ServiceInterface.class));
			BimServerClient bimServerClient = new BimServerClient("http://localhost:8080", servicesMap);
			bimServerClient.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			bimServerClient.connectJson(false);
			ServiceInterface serviceInterface = bimServerClient.getServiceInterface();
			serviceInterface.login("admin@bimserver.org", "admin");
			SSerializerPluginConfiguration serializerByContentType = serviceInterface.getSerializerByContentType("application/json");
			List<SProject> projects = serviceInterface.getProjectsByName("test");
			if (!projects.isEmpty()) {
				SProject project = projects.get(0);
				if (project.getLastRevisionId() != -1) {
					long start = System.nanoTime();
					Long download = serviceInterface.download(project.getLastRevisionId(), serializerByContentType.getOid(), true, true);
					System.out.println(((System.nanoTime() - start) / 1000000) + " ms");
					start = System.nanoTime();
					InputStream inputStream = bimServerClient.getDownloadData(download, serializerByContentType.getOid(), bimServerClient.getChannel().getToken());
					FileOutputStream fileOutputStream = new FileOutputStream(new File("test.json"));
					IOUtils.copy(inputStream, fileOutputStream);
					fileOutputStream.close();
					System.out.println(((System.nanoTime() - start) / 1000000) + " ms");
				}
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
