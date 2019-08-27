package org.bimserver.client.tests;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc4.IfcBSplineCurveWithKnots;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.junit.Test;

import com.google.common.base.Joiner;

public class TestIfc4TwoDimensional2 {
	@Test
	public void test() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = client.getServiceInterface().getTopLevelProjectByName("IFC4");

				ClientIfcModel model = client.getModel(project, project.getLastRevisionId(), true, false);
				for (IfcBSplineCurveWithKnots ifcBSplineCurveWithKnots : model.getAll(IfcBSplineCurveWithKnots.class)) {
					System.out.println(ifcBSplineCurveWithKnots.eClass().getName() + " " + ifcBSplineCurveWithKnots.getOid());
					for (org.bimserver.models.ifc4.IfcCartesianPoint ifcCartesianPoint : ifcBSplineCurveWithKnots.getControlPointsList()) {
						System.out.println(Joiner.on(", ").join(ifcCartesianPoint.getCoordinates()));
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
