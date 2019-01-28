package org.bimserver.tests.emf;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.ifc.step.serializer.Ifc2x3tc1StepSerializer;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcElementCompositionEnum;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcInternalOrExternalEnum;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationContext;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.utils.RichIfcModel;
import org.junit.Test;

import com.google.common.io.Files;

public class TestBigModelEmfRemote {
	
	private IfcProductRepresentation spaceRep;
	private IfcProductRepresentation furnishingRep;

	@Test
	public void test() {
		boolean doreuse = true;
		boolean useLowLevelCalls = false;
		
		try (BimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")){
			BimServerClientInterface bimServerClient = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			IfcModelInterface model = null;
			if (useLowLevelCalls) {
				model = bimServerClient.newModel(newProject, true);
			} else {
				model = new BasicIfcModel(bimServerClient.getMetaDataManager().getPackageMetaData("ifc2x3tc1"), null);
			}
			RichIfcModel richIfcModel = new RichIfcModel(model, !useLowLevelCalls);
			
			IfcBuilding ifcBuilding = richIfcModel.createDefaultProjectStructure();
			
			IfcRelAggregates buildingAggregation = richIfcModel.create(IfcRelAggregates.class);
			buildingAggregation.setRelatingObject(ifcBuilding);
			for (int i=1; i<=200; i++) {
				IfcBuildingStorey ifcBuildingStorey = richIfcModel.create(IfcBuildingStorey.class);
				ifcBuildingStorey.setName("Storey " + i);
				ifcBuildingStorey.setCompositionType(IfcElementCompositionEnum.ELEMENT);
				ifcBuildingStorey.setElevation(3000 * i);
				
				IfcLocalPlacement storeyPlacement = richIfcModel.create(IfcLocalPlacement.class);
				storeyPlacement.setRelativePlacement(richIfcModel.createBasicPosition(0, 0, i * 3000));
				ifcBuildingStorey.setObjectPlacement(storeyPlacement);
				
				buildingAggregation.getRelatedObjects().add(ifcBuildingStorey);
				
				IfcRelAggregates storeyAggregation = richIfcModel.create(IfcRelAggregates.class);
				storeyAggregation.setRelatingObject(ifcBuildingStorey);
				
				for (int x=1; x<=40; x++) {
					for (int y=1; y<=40; y++) {
						createSpace(richIfcModel, richIfcModel.getDefaultRepresentationContext(), storeyPlacement, storeyAggregation, x, y, doreuse);
					}
				}
			}
			
			long roid = -1;
			if (useLowLevelCalls) {
				roid = model.commit("Initial model");
			} else {
				Serializer serializer = new Ifc2x3tc1StepSerializer(null);
				serializer.init(model, null, true);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				serializer.writeToOutputStream(baos, null);
				java.nio.file.Files.write(Paths.get("tmp.ifc"), baos.toByteArray());
				
				SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());
				SLongCheckinActionState checkinSync = bimServerClient.checkinSync(newProject.getOid(), "New", deserializer.getOid(), false, baos.size(), "newfile", new ByteArrayInputStream(baos.toByteArray()));
				roid = checkinSync.getRoid();
			}

			SSerializerPluginConfiguration serializerByContentType = bimServerClient.getServiceInterface().getSerializerByName("Ifc2x3tc1 (Streaming)");
			bimServerClient.download(roid, serializerByContentType.getOid(), new FileOutputStream(new File("created.ifc")));
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}

	private void createSpace(RichIfcModel richIfcModel, IfcRepresentationContext representationContext, IfcLocalPlacement storeyPlacement, IfcRelAggregates storeyAggregation, int x, int y, boolean doreuse) throws IfcModelInterfaceException {
		IfcSpace ifcSpace = richIfcModel.create(IfcSpace.class);
		ifcSpace.setName("Space " + ((y * 10) + x));
		ifcSpace.setCompositionType(IfcElementCompositionEnum.ELEMENT);
		ifcSpace.setInteriorOrExteriorSpace(IfcInternalOrExternalEnum.INTERNAL);

		IfcLocalPlacement spacePlacement = richIfcModel.create(IfcLocalPlacement.class);
		spacePlacement.setPlacementRelTo(storeyPlacement);
		spacePlacement.setRelativePlacement(richIfcModel.createBasicPosition(x * 6000, y * 6000, 0));
		ifcSpace.setObjectPlacement(spacePlacement);

		storeyAggregation.getRelatedObjects().add(ifcSpace);
		
		IfcProductRepresentation rep = null;
		if (doreuse) {
			if (this.spaceRep == null) {
				this.spaceRep = richIfcModel.createRectangularExtrusionProductRepresentation(5000, 5000, 2000);
			}
			rep = this.spaceRep;
		} else {
			rep = richIfcModel.createRectangularExtrusionProductRepresentation(5000, 5000, 2000);
		}
		ifcSpace.setRepresentation(rep);
		
		createFurnishing(richIfcModel, representationContext, y, ifcSpace, spacePlacement, doreuse);
	}

	private void createFurnishing(RichIfcModel richIfcModel, IfcRepresentationContext representationContext, int number, IfcSpace ifcSpace, IfcLocalPlacement spacePlacement, boolean doreuse) throws IfcModelInterfaceException {
		IfcFurnishingElement furnishing = richIfcModel.create(IfcFurnishingElement.class);
		furnishing.setName("Furnishing " + number);
		
		IfcLocalPlacement furnishingPlacement = richIfcModel.create(IfcLocalPlacement.class);
		furnishingPlacement.setPlacementRelTo(spacePlacement);
		IfcAxis2Placement3D furnitureAxisPlacement = richIfcModel.create(IfcAxis2Placement3D.class);
		furnitureAxisPlacement.setLocation(richIfcModel.createIfcCartesianPoint(500, 500, 2));
		furnishingPlacement.setRelativePlacement(furnitureAxisPlacement);
		
		furnishing.setObjectPlacement(furnishingPlacement);
		IfcProductRepresentation rep = null;
		if (doreuse) {
			if (this.furnishingRep == null) {
				this.furnishingRep = richIfcModel.createRectangularExtrusionProductRepresentation(4000, 4000, 1200);
			}
			rep = this.furnishingRep;
		} else {
			rep = richIfcModel.createRectangularExtrusionProductRepresentation(4000, 4000, 1200);
		}
		furnishing.setRepresentation(rep);
		
		richIfcModel.addContains(ifcSpace, furnishing);
	}
}
