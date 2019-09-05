package org.bimserver.client.tests;

import java.util.Arrays;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcPoint;
import org.bimserver.models.ifc4.IfcIndexedPolyCurve;
import org.bimserver.models.ifc4.IfcLineIndex;
import org.bimserver.models.ifc4.IfcSegmentIndexSelect;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.junit.Test;

import com.google.common.base.Joiner;

public class TestIfc4TwoDimensional3 {
	@Test
	public void test() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = client.getServiceInterface().getTopLevelProjectByName("$4");

				ClientIfcModel model = client.getModel(project, project.getLastRevisionId(), true, false);
				for (IfcIndexedPolyCurve ifcIndexedPolyCurve : model.getAll(IfcIndexedPolyCurve.class)) {
					for (IfcSegmentIndexSelect ifcSegmentIndexSelect : ifcIndexedPolyCurve.getSegments()) {
						if (ifcSegmentIndexSelect instanceof IfcLineIndex) {
							IfcLineIndex ifcLineIndex = (IfcLineIndex)ifcSegmentIndexSelect;
							System.out.println(Joiner.on(", ").join(ifcLineIndex.getWrappedValue()));
						}
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
