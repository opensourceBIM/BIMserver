package org.bimserver.client.tests;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang.RandomStringUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.deserializers.DeserializerErrorCode;
import org.bimserver.plugins.services.CheckinProgressHandler;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ErrorCode;
import org.bimserver.shared.exceptions.UserException;
import org.junit.Assert;
import org.junit.Test;

public class TestDeserializerErrorCode2 {
	@Test
	public void test() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = client.getServiceInterface().addProject(RandomStringUtils.randomAlphanumeric(10), "ifc2x3tc1");
				Path path = Paths.get("C:\\Git\\TestFiles\\TestData\\data\\ADT-FZK-Haus-2005-2006.ifc");
				SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
				SLongCheckinActionState checkinSync = client.checkinSync(project.getOid(), "test", deserializer.getOid(), path, new CheckinProgressHandler() {
					@Override
					public void progress(String title, int progress) {
						System.out.println(title + ": " + progress);
					}
				});
				Assert.assertEquals(DeserializerErrorCode.IFC_SCHEMA_NOT_SUPPORTED_BY_DESERIALIZER, ErrorCode.fromCode(checkinSync.getDeserializeErrorCode()));
			}
		} catch (UserException e1) {
			e1.printStackTrace();
			Assert.fail();
		} catch (Exception e1) {
			e1.printStackTrace();
			Assert.fail();
		}
	}
}
