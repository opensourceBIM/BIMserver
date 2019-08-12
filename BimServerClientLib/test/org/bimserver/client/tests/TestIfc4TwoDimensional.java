package org.bimserver.client.tests;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang.RandomStringUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc4.IfcColourRgbList;
import org.bimserver.models.ifc4.IfcNormalisedRatioMeasure;
import org.bimserver.models.ifc4.ListOfIfcNormalisedRatioMeasure;
import org.bimserver.plugins.services.CheckinProgressHandler;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.junit.Test;

public class TestIfc4TwoDimensional {
	@Test
	public void test() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = client.getServiceInterface().getTopLevelProjectByName("ifc4file");

				ClientIfcModel model = client.getModel(project, project.getLastRevisionId(), true, false);
				for (IfcColourRgbList ifcColourRgbList : model.getAll(IfcColourRgbList.class)) {
					System.out.println(ifcColourRgbList.eClass().getName() + " " + ifcColourRgbList.getOid());
					for (ListOfIfcNormalisedRatioMeasure listOfIfcNormalisedRatioMeasure : ifcColourRgbList.getColourList()) {
						for (IfcNormalisedRatioMeasure ifcNormalisedRatioMeasure : listOfIfcNormalisedRatioMeasure.getList()) {
							System.out.print(ifcNormalisedRatioMeasure.getWrappedValue() + " ");
						}
						System.out.println();
					}
				}
			}
			Thread.sleep(500);
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
