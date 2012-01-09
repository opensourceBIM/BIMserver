package org.bimserver.unittests;

import java.util.List;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.factories.UsernamePasswordAuthenticationInfo;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDataValue;
import org.bimserver.plugins.PluginException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.junit.Test;

public class TestUnknown {
	@Test
	public void test() {
		try {
			BimServerClient bimServerClient = new BimServerClient(LocalDevPluginLoader.createPluginManager());
			bimServerClient.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			bimServerClient.connectProtocolBuffers("localhost", 8020);
			Long roid = 47L;
			List<SDataObject> dataObjectsByType = bimServerClient.getServiceInterface().getDataObjectsByType(roid, "IfcWindow");
			for (SDataObject sDataObject : dataObjectsByType) {
				System.out.println(sDataObject.getType() + ": " + sDataObject.getOid());
				for (SDataValue sDataValue : sDataObject.getValues()) {
					System.out.println(sDataValue.getClass().getName());
				}
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}
}
