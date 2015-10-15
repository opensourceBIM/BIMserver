package org.bimserver.tests.emf;

import static org.junit.Assert.fail;

import java.nio.file.Paths;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcObjectPlacement;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class MoveObject extends TestWithEmbeddedServer{
	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());

			// Checkin the file
			bimServerClient.checkin(newProject.getOid(), "test", deserializer.getOid(), false, true, Paths.get("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));

			// Refresh project info
			newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());

			IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), true, false);
			for (IfcFurnishingElement ifcFurnishingElement : model.getAllWithSubTypes(IfcFurnishingElement.class)) {
				IfcObjectPlacement objectPlacement = ifcFurnishingElement.getObjectPlacement();
				if (objectPlacement != null && objectPlacement instanceof IfcLocalPlacement) {
					IfcLocalPlacement localPlacement = (IfcLocalPlacement)objectPlacement;
					IfcAxis2Placement relativePlacement = localPlacement.getRelativePlacement();
					if (relativePlacement != null) {
						if (relativePlacement instanceof IfcAxis2Placement3D) {
							IfcAxis2Placement3D axis2Placement3D = (IfcAxis2Placement3D)relativePlacement;
							IfcCartesianPoint location = axis2Placement3D.getLocation();
							double newValue = location.getCoordinates().get(2) + 50;
							System.out.println("Changing z value of " + ifcFurnishingElement.getName() + " from " + location.getCoordinates().get(2) + " to " + newValue);
							location.getCoordinates().set(2, newValue);
						}
					}
				}
			}
			long newRoid = model.commit("Moved all furniture 50 meters up");
			SSerializerPluginConfiguration ifcSerializer = bimServerClient.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
			bimServerClient.download(newRoid, ifcSerializer.getOid(), Paths.get("movedf.ifc"));
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}