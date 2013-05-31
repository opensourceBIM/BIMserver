package org.bimserver.tests.emf;

import static org.junit.Assert.fail;

import java.io.File;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcParameterValue;
import org.bimserver.models.ifc2x3tc1.IfcTrimmedCurve;
import org.bimserver.models.ifc2x3tc1.IfcTrimmingSelect;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class ReadTrim extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random());
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc");
			
			// Checkin the file
			bimServerClient.checkin(newProject.getOid(), "test", deserializer.getOid(), false, true, new File("../TestData/data/TST.ifc"));
			
			// Refresh project info
			newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());
			
			ClientIfcModel model = bimServerClient.getModel(newProject.getOid(), newProject.getLastRevisionId(), true);
			for (IfcTrimmedCurve ifcTrimmedCurve : model.getAllWithSubTypes(IfcTrimmedCurve.class)) {
				for (IfcTrimmingSelect ifcTrimmingSelect : ifcTrimmedCurve.getTrim1()) {
					if (ifcTrimmingSelect instanceof IfcParameterValue) {
						IfcParameterValue ifcParameterValue = (IfcParameterValue)ifcTrimmingSelect;
						System.out.println("Trim1: " + ifcParameterValue.getWrappedValue());
					}
				}
				for (IfcTrimmingSelect ifcTrimmingSelect : ifcTrimmedCurve.getTrim2()) {
					if (ifcTrimmingSelect instanceof IfcParameterValue) {
						IfcParameterValue ifcParameterValue = (IfcParameterValue)ifcTrimmingSelect;
						System.out.println("Trim2: " + ifcParameterValue.getWrappedValue());
					}
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}