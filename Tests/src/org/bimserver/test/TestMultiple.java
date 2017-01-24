package org.bimserver.test;

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
import org.bimserver.plugins.services.Flow;
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
							client.checkin(project.getOid(), "Test", deserializer.getOid(), false, Flow.ASYNC, Paths.get("C:\\Git\\TestFiles\\TestData\\data\\HITOS_070308.ifc"));
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
