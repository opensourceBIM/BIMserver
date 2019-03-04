package org.bimserver.test;

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

import java.io.FileNotFoundException;
import java.io.IOException;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.nio.file.Paths;
import java.util.List;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.Schema;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.IncrementingOidProvider;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.utils.DeserializerUtils;
import org.bimserver.utils.SerializerUtils;

public class AddFurniture {
	public static void main(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			
			Deserializer deserializer = deserializerPlugin.createDeserializer(null);
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			
			IfcModelInterface model = DeserializerUtils.readFromFile(deserializer, Paths.get("../TestData/data/AC9R1-Haus-G-H-Ver2-2x3.ifc"));

			deserializer = deserializerPlugin.createDeserializer(null);
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			IfcModelInterface furnishingModel = DeserializerUtils.readFromFile(deserializer, Paths.get("test.ifc"));
			
			model.fixOids(new IncrementingOidProvider());
			long oid = model.getHighestOid();
			IncrementingOidProvider oidProvider = new IncrementingOidProvider(oid + 1);

			IfcFurnishingElement picknick = (IfcFurnishingElement) furnishingModel.getByName(Ifc2x3tc1Package.eINSTANCE.getIfcFurnishingElement(), "Picknik Bank");

			ModelHelper modelHelper = new ModelHelper(pluginManager.getMetaDataManager(), model);

			IfcProductDefinitionShape representation = (IfcProductDefinitionShape) picknick.getRepresentation();
			IfcRepresentation surfaceModel = null;
			IfcRepresentation boundingBox = null;
			for (IfcRepresentation ifcRepresentation : representation.getRepresentations()) {
				IfcShapeRepresentation ifcShapeRepresentation = (IfcShapeRepresentation)ifcRepresentation;
				if (ifcShapeRepresentation.getRepresentationType().equals("SurfaceModel")) {
					surfaceModel = (IfcRepresentation) modelHelper.copy(ifcShapeRepresentation, false);
				} else if (ifcShapeRepresentation.getRepresentationType().equals("BoundingBox")) {
					boundingBox	 = (IfcRepresentation) modelHelper.copy(ifcShapeRepresentation, false);
				}
			}

			IfcOwnerHistory ownerHistory = null;
			List<IfcOwnerHistory> all = model.getAll(IfcOwnerHistory.class);
			if (all.size() > 0) {
				 ownerHistory = all.get(0);
			}
			
			for (IfcBuildingStorey ifcBuildingStorey : model.getAll(IfcBuildingStorey.class)) {
				for (IfcRelDecomposes ifcRelDecomposes : ifcBuildingStorey.getIsDecomposedBy()) {
					for (IfcObjectDefinition ifcObjectDefinition : ifcRelDecomposes.getRelatedObjects()) {
						if (ifcObjectDefinition instanceof IfcSpace) {
							IfcSpace ifcSpace = (IfcSpace)ifcObjectDefinition;
//							IfcProductDefinitionShape slabRepr = (IfcProductDefinitionShape) ifcSpace.getRepresentation();
//							IfcBoundingBox box = null;
//							for (IfcRepresentation representation2 : slabRepr.getRepresentations()) {
//								IfcShapeRepresentation shapeRepresentation = (IfcShapeRepresentation)representation2;
//								if (shapeRepresentation.getRepresentationType().equals("BoundingBox")) {
//									for (IfcRepresentationItem i2 : shapeRepresentation.getItems()) {
//										box = (IfcBoundingBox)i2;
//									}
//								}
//							}
							
							IfcFurnishingElement newFurnishing = model.create(IfcFurnishingElement.class, oidProvider);
							
							IfcRelContainedInSpatialStructure containedInSpatialStructure2 = model.create(IfcRelContainedInSpatialStructure.class, oidProvider);
							containedInSpatialStructure2.setRelatingStructure(ifcBuildingStorey);
							containedInSpatialStructure2.getRelatedElements().add(newFurnishing);
							
							newFurnishing.setName("Generated");
							newFurnishing.setGlobalId("TEST");
							newFurnishing.setOwnerHistory(ownerHistory);
							IfcProductDefinitionShape definitionShape = model.create(IfcProductDefinitionShape.class, oidProvider);
							newFurnishing.setRepresentation(definitionShape);
							
							definitionShape.getRepresentations().add(boundingBox);
							definitionShape.getRepresentations().add(surfaceModel);
							
							IfcLocalPlacement localPlacement = model.create(IfcLocalPlacement.class, oidProvider);
							localPlacement.setPlacementRelTo(ifcSpace.getObjectPlacement());
							IfcAxis2Placement3D axis2Placement3D = model.create(IfcAxis2Placement3D.class, oidProvider);
							localPlacement.setRelativePlacement(axis2Placement3D);
							
							IfcCartesianPoint pos = model.create(IfcCartesianPoint.class, oidProvider);
							pos.getCoordinates().add(-3d);
							pos.getCoordinates().add(+0.5d);
							pos.getCoordinates().add(0d);
							axis2Placement3D.setLocation(pos);
							
							newFurnishing.setObjectPlacement(localPlacement);							
						}
					}
				}
			}

			model.resetExpressIds();

			SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
			Serializer serializer = serializerPlugin.createSerializer(null);
			serializer.init(model, null, true);
			SerializerUtils.writeToFile(serializer, Paths.get("withfurn.ifc"));
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (IfcModelInterfaceException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
