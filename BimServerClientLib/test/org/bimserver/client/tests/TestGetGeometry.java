package org.bimserver.client.tests;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.GeometryLoader;
import org.bimserver.client.GeometryTargetImpl;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.junit.Test;

public class TestGetGeometry {
	@Test
	public void test() throws Exception {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = client.getServiceInterface().addProject(RandomStringUtils.randomAlphanumeric(10), "ifc2x3tc1");

				SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
				Path path = Paths.get("../../TestFiles/TestData/data/export1.ifc");
				SLongCheckinActionState actionState = client.checkinSync(project.getOid(), "test", deserializer.getOid(), path, (title, progress) ->
						System.out.println(title + ": " + progress)
				);
				PackageMetaData packageMetaData = client.getMetaDataManager().getPackageMetaData("ifc2x3tc1");
				GeometryTargetImpl geometryTargetImpl = new GeometryTargetImpl(packageMetaData);
				GeometryLoader geometryLoader = new GeometryLoader(client, packageMetaData, geometryTargetImpl);
				
				Set<Long> oids = new HashSet<>();
				
				// Only to gather oids
				ClientIfcModel model = client.getModel(project, actionState.getRoid(), true, false, false);
				for (IfcWall ifcWall : model.getAllWithSubTypes(IfcWall.class)) {
					oids.add(ifcWall.getOid());
				}

				geometryLoader.loadProducts(actionState.getRoid(), oids);
				System.out.println(geometryTargetImpl);
				
				Set<Long> geometryDataOids = new HashSet<>();
				
				for (GeometryInfo geometryInfo : geometryTargetImpl.getAllGeometryInfo()) {
					GeometryData geometryData = geometryInfo.getData();
					System.out.println(geometryInfo.getPrimitiveCount());
					System.out.println(geometryData.getNrIndices());
					geometryDataOids.add(geometryData.getOid());
				}
				
				geometryTargetImpl = new GeometryTargetImpl(packageMetaData);
				geometryLoader = new GeometryLoader(client, packageMetaData, geometryTargetImpl);
				geometryLoader.loadGeometryData(actionState.getRoid(), geometryDataOids);
				System.out.println(geometryTargetImpl);
			}
		}
		Thread.sleep(1000);
	}
}
