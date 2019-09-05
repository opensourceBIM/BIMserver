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
	public void test() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				Path path = Paths.get("C:\\Git\\TestFiles\\TestData\\data\\ADT-FZK-Haus-2005-2006.ifc");
				
				try (InputStream fis = Files.newInputStream(path)) {
					byte[] initialBytes = ByteUtils.extractHead(new BufferedInputStream(fis), 4096);
					client.getServiceInterface().determineIfcVersion(initialBytes, false);
				}
			}
		} catch (UserException e1) {
			if (e1.getErrorCode() == DeserializerErrorCode.UNSUPPORTED_IFC_SCHEMA_VERSION) {
				System.out.println("OK " + e1.getErrorCode());
				// OK
			} else {
				e1.printStackTrace();
				Assert.fail();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			Assert.fail();
		}
	}
}
