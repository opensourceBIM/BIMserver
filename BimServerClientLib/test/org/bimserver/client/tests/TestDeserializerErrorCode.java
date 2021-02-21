package org.bimserver.client.tests;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.plugins.deserializers.DeserializerErrorCode;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.ByteUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestDeserializerErrorCode {
	@Test
	public void test() throws Exception {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				Path path = Paths.get("../../TestFiles/TestData/data/ADT-FZK-Haus-2005-2006.ifc");
				
				try (InputStream fis = Files.newInputStream(path)) {
					byte[] initialBytes = ByteUtils.extractHead(new BufferedInputStream(fis), 4096);
					client.getServiceInterface().determineIfcVersion(initialBytes, false);
				}
			}
			Assert.fail("Expected UserException to be thrown");
		} catch (UserException e1) {
			Assert.assertEquals(DeserializerErrorCode.UNSUPPORTED_IFC_SCHEMA_VERSION, e1.getErrorCode());
    	}
	}
}
