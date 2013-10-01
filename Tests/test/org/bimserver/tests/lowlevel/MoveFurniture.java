package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDataValue;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SReferenceDataValue;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class MoveFurniture extends TestWithEmbeddedServer {
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
			bimServerClient.checkin(newProject.getOid(), "test", deserializer.getOid(), false, true, new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));

			// Refresh project info
			newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());
			Bimsie1LowLevelInterface lowLevelInterface = bimServerClient.getBimsie1LowLevelInterface();
			
			long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			List<SDataObject> dataObjectsByType = lowLevelInterface.getDataObjectsByType(newProject.getLastRevisionId(), "IfcFurnishingElement", false);
			int i=0;
			for (SDataObject furnishingElement : dataObjectsByType) {
				i++;
				System.out.println(i + " / " + dataObjectsByType.size());
				if (i < 2) {
					long objectPlacementOid = getReference(furnishingElement, "ObjectPlacement");
					if (objectPlacementOid != -1) {
						SDataObject objectPlacement = lowLevelInterface.getDataObjectByOid(newProject.getLastRevisionId(), objectPlacementOid);
						if (objectPlacement.getType().equals("IfcLocalPlacement")) {
							Long axis2Placement3D = lowLevelInterface.getReference(tid, objectPlacement.getOid(), "RelativePlacement");
							Long location = lowLevelInterface.getReference(tid, axis2Placement3D, "Location");
							double z = lowLevelInterface.getDoubleAttributeAtIndex(tid, location, "Coordinates", 2);
							lowLevelInterface.setDoubleAttributeAtIndex(tid, location, "Coordinates", 2, z + 50);
						}
					}
				}
			}

			long newRoid = lowLevelInterface.commitTransaction(tid, "Moved furniture 50 meters up");

			System.out.println(lowLevelInterface.getDataObjectsByType(newRoid, "IfcFurnishingElement", false).size());

			SSerializerPluginConfiguration ifcSerializer = bimServerClient.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
			bimServerClient.download(newRoid, ifcSerializer.getOid(), new File("movedf.ifc"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private long getReference(SDataObject sDataObject, String name) {
		for (SDataValue value : sDataObject.getValues()) {
			if (value.getFieldName().equals(name)) {
				if (value instanceof SReferenceDataValue) {
					return ((SReferenceDataValue)value).getOid();
				}
			}
		}
		return -1;
	}
}
