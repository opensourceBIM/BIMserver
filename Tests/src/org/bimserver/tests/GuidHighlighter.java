package org.bimserver.tests;

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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcPresentationLayerAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.utils.SerializerUtils;

import nl.tue.buildingsmart.schema.SchemaDefinition;

public class GuidHighlighter {
	public GuidHighlighter(SchemaDefinition schema, IfcModelInterface model, Path outputFile, Set<String> highlightedGuids) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			highlightGuids(model, highlightedGuids);
			SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
			Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
			try {
				serializer.init(model, null, false);
				SerializerUtils.writeToFile(serializer, outputFile);
			} catch (SerializerException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (PluginException e1) {
			e1.printStackTrace();
		}
	}
	
	private void highlightGuids(IfcModelInterface model, Set<String> highlightedGuids) {
		Set<IdEObject> newObjects = new HashSet<IdEObject>();
		IfcColourRgb gray = Ifc2x3tc1Factory.eINSTANCE.createIfcColourRgb();
		newObjects.add(gray);
		gray.setRed(0.5f);
		gray.setGreen(0.5f);
		gray.setBlue(0.5f);

		Set<IdEObject> toDelete = new HashSet<IdEObject>();
		for (IdEObject object : model.getValues()) {
			if (object instanceof IfcPresentationLayerAssignment) {
				toDelete.add(object);
			}
		}
		
		IfcPresentationLayerAssignment notSelectedLayer = Ifc2x3tc1Factory.eINSTANCE.createIfcPresentationLayerAssignment();
		notSelectedLayer.setName("Not Selected");
		notSelectedLayer.setIdentifier("Not Selected");
		newObjects.add(notSelectedLayer);

		IfcPresentationLayerAssignment selectedLayer = Ifc2x3tc1Factory.eINSTANCE.createIfcPresentationLayerAssignment();
		selectedLayer.setName("Selected");
		selectedLayer.setIdentifier("Selected");
		newObjects.add(selectedLayer);

		for (IdEObject idEObject : model.getValues()) {
			if (idEObject instanceof IfcProduct) {
				IfcProduct product = (IfcProduct)idEObject;
				String guid = product.getGlobalId();
				boolean hide = true;
				if (guid != null) {
					if (highlightedGuids.contains(guid)) {
						hide = false;
					}
				}
				if (hide) {
					System.out.println("Hiding " + guid);
					IfcProductRepresentation representation = product.getRepresentation();
					if (representation != null) {
						for (IfcRepresentation ifcRepresentation : representation.getRepresentations()) {
							notSelectedLayer.getAssignedItems().add(ifcRepresentation);
							for (IfcRepresentationItem ifcRepresentationItem : ifcRepresentation.getItems()) {
								notSelectedLayer.getAssignedItems().add(ifcRepresentationItem);
								for (IfcStyledItem ifcStyledItem : ifcRepresentationItem.getStyledByItem()) {
									for (IfcPresentationStyleAssignment ifcPresentationStyleAssignment : ifcStyledItem.getStyles()) {
										for (IfcPresentationStyleSelect ifcPresentationStyleSelect : ifcPresentationStyleAssignment.getStyles()) {
											if (ifcPresentationStyleSelect instanceof IfcSurfaceStyle) {
												IfcSurfaceStyle ifcSurfaceStyle = (IfcSurfaceStyle)ifcPresentationStyleSelect;
												for (IfcSurfaceStyleElementSelect ifcSurfaceStyleElementSelect : ifcSurfaceStyle.getStyles()) {
													if (ifcSurfaceStyleElementSelect instanceof IfcSurfaceStyleRendering) {
														IfcSurfaceStyleRendering ifcSurfaceStyleRendering = (IfcSurfaceStyleRendering)ifcSurfaceStyleElementSelect;
														ifcSurfaceStyleRendering.setTransparency(0.98f);
														ifcSurfaceStyleRendering.setDiffuseColour(gray);
														ifcSurfaceStyleRendering.setReflectionColour(gray);
														ifcSurfaceStyleRendering.setSpecularColour(gray);
														ifcSurfaceStyleRendering.setSurfaceColour(gray);
														ifcSurfaceStyleRendering.setTransmissionColour(gray);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				} else {
					System.out.println("Not hiding " + guid);
					IfcProductRepresentation representation = product.getRepresentation();
					if (representation != null) {
						for (IfcRepresentation ifcRepresentation : representation.getRepresentations()) {
							selectedLayer.getAssignedItems().add(ifcRepresentation);
							for (IfcRepresentationItem ifcRepresentationItem : ifcRepresentation.getItems()) {
								selectedLayer.getAssignedItems().add(ifcRepresentationItem);
							}
						}
					}
				}
			}
		}
		for (IdEObject toDeleteObject : toDelete) {
			model.remove(toDeleteObject);
		}
		for (IdEObject newObject : newObjects) {
			try {
				model.add(model.getHighestOid() + 1, newObject);
			} catch (IfcModelInterfaceException e) {
				e.printStackTrace();
			}
		}
	}
}