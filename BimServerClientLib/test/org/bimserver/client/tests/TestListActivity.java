package org.bimserver.client.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SServerInfo;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.junit.Test;

public class TestListActivity {
	@Test
	public void test() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("[address]")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("[un]", "[pw]"))) {
				SServerInfo serverInfo = client.getAdminInterface().getServerInfo();

				Map<Date, SRevision> revisions = new TreeMap<>();
				
				for (SProject sProject : client.getServiceInterface().getAllProjects(true, true)) {
					for (Long roid : sProject.getRevisions()) {
						SRevision revision = client.getServiceInterface().getRevision(roid);
						Date date = revision.getDate();
						revisions.put(date, revision);
					}
				}
				
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				for (SRevision revision : revisions.values()) {
					System.out.println(dateFormatter.format(revision.getDate()) + " " + revision.getComment());
				}
			}
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
