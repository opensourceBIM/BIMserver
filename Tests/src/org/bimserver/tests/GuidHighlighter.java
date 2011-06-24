package org.bimserver.tests;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcColourRgb;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcPresentationLayerAssignment;
import org.bimserver.models.ifc2x3.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3.IfcProduct;
import org.bimserver.models.ifc2x3.IfcProductRepresentation;
import org.bimserver.models.ifc2x3.IfcRepresentation;
import org.bimserver.models.ifc2x3.IfcRepresentationItem;
import org.bimserver.models.ifc2x3.IfcStyledItem;
import org.bimserver.models.ifc2x3.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3.IfcSurfaceStyleRendering;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class GuidHighlighter {
	public GuidHighlighter(SchemaDefinition schema, IfcModelInterface model, File outputFile, Set<String> highlightedGuids) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			highlightGuids(model, highlightedGuids);
			SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/ifc", true);
			EmfSerializer serializer = serializerPlugin.createSerializer();
			try {
				serializer.init(model, null, null);
				serializer.writeToFile(outputFile);
			} catch (SerializerException e) {
				e.printStackTrace();
			}
		} catch (PluginException e1) {
			e1.printStackTrace();
		}
	}
	
	private void highlightGuids(IfcModelInterface model, Set<String> highlightedGuids) {
		Set<IdEObject> newObjects = new HashSet<IdEObject>();
		IfcColourRgb gray = Ifc2x3Factory.eINSTANCE.createIfcColourRgb();
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
		
		IfcPresentationLayerAssignment notSelectedLayer = Ifc2x3Factory.eINSTANCE.createIfcPresentationLayerAssignment();
		notSelectedLayer.setName("Not Selected");
		notSelectedLayer.setIdentifier("Not Selected");
		newObjects.add(notSelectedLayer);

		IfcPresentationLayerAssignment selectedLayer = Ifc2x3Factory.eINSTANCE.createIfcPresentationLayerAssignment();
		selectedLayer.setName("Selected");
		selectedLayer.setIdentifier("Selected");
		newObjects.add(selectedLayer);

		for (IdEObject idEObject : model.getValues()) {
			if (idEObject instanceof IfcProduct) {
				IfcProduct product = (IfcProduct)idEObject;
				IfcGloballyUniqueId globalId = product.getGlobalId();
				boolean hide = true;
				if (globalId != null) {
					if (highlightedGuids.contains(globalId.getWrappedValue())) {
						hide = false;
					}
				}
				if (hide) {
					System.out.println("Hiding " + globalId.getWrappedValue());
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
					System.out.println("Not hiding " + globalId.getWrappedValue());
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
			model.add(model.getHighestOid() + 1, newObject);
		}
	}
}