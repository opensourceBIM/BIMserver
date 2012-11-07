package org.bimserver.scenejs;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcActorRole;
import org.bimserver.models.ifc2x3tc1.IfcApplication;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingElementProxy;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcColourOrFactor;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcColumn;
import org.bimserver.models.ifc2x3tc1.IfcCurtainWall;
import org.bimserver.models.ifc2x3tc1.IfcDoor;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcFlowSegment;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayer;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcMember;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcPlate;
import org.bimserver.models.ifc2x3tc1.IfcPostalAddress;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRailing;
import org.bimserver.models.ifc2x3tc1.IfcRelAssigns;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsElements;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsPortToElement;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsStructuralElement;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsWithRealizingElements;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelCoversBldgElements;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelFillsElement;
import org.bimserver.models.ifc2x3tc1.IfcRelReferencedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelServicesBuildings;
import org.bimserver.models.ifc2x3tc1.IfcRelSpaceBoundary;
import org.bimserver.models.ifc2x3tc1.IfcRelVoidsElement;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationContext;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcRoof;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcSlabTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.bimserver.models.ifc2x3tc1.IfcStair;
import org.bimserver.models.ifc2x3tc1.IfcStairFlight;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.models.ifc2x3tc1.IfcWallStandardCase;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SceneJSSerializer extends EmfSerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(SceneJSSerializer.class);

	/**
	 * Extents provides an axis-aligned bounding cuboid for geometric data, 
	 * represented as a pair of 3 dimensional vectors for the two opposing corners of the cuboid.
	 */
	private class Extents {
		public float[] min = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };
		public float[] max = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };
	}
	private Extents sceneExtents = new Extents();
	private HashMap<String, Extents> geometryExtents = new HashMap<String, Extents>();
	private HashMap<String, HashMap<String, HashSet<String>>> typeMaterialGeometryRel = new HashMap<String, HashMap<String, HashSet<String>>>();
	// private materialGeometryRel = new HashMap<String, Set<String>>();
	private List<String> surfaceStyleIds;
	private IfcEngineGeometry geometry;
	private IfcEngineModel ifcEngineModel;

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, IfcEngine ifcEngine, boolean normalizeOids) throws SerializerException {
		super.init(model, projectInfo, pluginManager, ifcEngine, false);
		this.surfaceStyleIds = new ArrayList<String>();
		try {
			ifcEngine.init();
			Serializer serializer = getPluginManager().requireIfcStepSerializer();
			serializer.init(model, getProjectInfo(), getPluginManager(), ifcEngine, false);
			ifcEngineModel = ifcEngine.openModel(serializer.getBytes());
			ifcEngineModel.setPostProcessing(true);
			geometry = ifcEngineModel.finalizeModelling(ifcEngineModel.initializeModelling());
		} catch (PluginException e) {
			throw new SerializerException(e);
		}
	}

	@Override
	public void reset() {
		setMode(Mode.BODY);
	}

	@Override
	public boolean write(OutputStream out) throws SerializerException {
		if (getMode() == Mode.BODY) {
			PrintWriter writer = new PrintWriter(out);
			try {
				// Pre-calculate information for use during the export
				calculateGeometryExtents();
				
				/* Write data to stream
				writer.writeln("\/* Author:      " + getProjectInfo().getAuthorName());
				writer.writeln("   Description: " + getProjectInfo().getDescription());
				writer.writeln("*\/");*/
				
				JSONObject jsonObj = new JSONObject()
					.put("type", "scene")
					.put("id", "Scene")
					.put("canvasId", "scenejsCanvas")
					.put("loggingElementId", "scenejsLog")
					.put("flags", new JSONObject().put("backfaces", false))
					.put("nodes", writeVisualScenes(new JSONArray()
						.put(new JSONObject()
							.put("type", "library")
							.put("nodes", writeGeometries(writeMaterials(new JSONArray())))))); // (Unfortunately JSONArray doesn't provide a concat method)
					

				// Append additional custom data to the scene node
				jsonObj.put("data", new JSONObject()
					.put("bounds", writeBounds())
					.put("unit", writeUnit())
					.put("ifcTypes", writeIfcTypes())
					.put("relationships", writeIfcTree())
					.put("properties", writeIfcProperties()));

//				String str = jsonObj.toString(2);
//				writer.print(str);
				jsonObj.write(writer);
				writer.flush();
			} catch (Exception e) {
				LOGGER.error("", e);
			}
			writer.flush();
			setMode(Mode.FINISHED);
			getIfcEngine().close();
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	private JSONArray writeMaterials(JSONArray array) throws JSONException {
		array.put(writeMaterial("Space", new double[] { 0.137255f, 0.403922f, 0.870588f }, 1.0f))
			.put(writeMaterial("Roof", new double[] { 0.837255f, 0.203922f, 0.270588f }, 1.0f))
			.put(writeMaterial("Slab", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f))
			.put(writeMaterial("Wall", new double[] { 0.537255f, 0.337255f, 0.237255f }, 1.0f))
			.put(writeMaterial("WallStandardCase", new double[] { 1.0f, 1.0f, 1.0f }, 1.0f))
			.put(writeMaterial("Door", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f))
			.put(writeMaterial("Window", new double[] { 0.2f, 0.2f, 0.8f }, 0.2f))
			.put(writeMaterial("Railing", new double[] { 0.137255f, 0.203922f, 0.270588f }, 1.0f))
			.put(writeMaterial("Column", new double[] { 0.437255f, 0.603922f, 0.370588f, }, 1.0f))
			.put(writeMaterial("FurnishingElement", new double[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f))
			.put(writeMaterial("CurtainWall", new double[] { 0.5f, 0.5f, 0.5f }, 0.5f))
			.put(writeMaterial("Stair", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f))
			.put(writeMaterial("BuildingElementProxy", new double[] { 0.5f, 0.5f, 0.5f }, 1.0f))
			.put(writeMaterial("FlowSegment", new double[] { 0.6f, 0.4f, 0.5f }, 1.0f));

		List<IfcSurfaceStyle> listSurfaceStyles = model.getAll(IfcSurfaceStyle.class);
		for (IfcSurfaceStyle ss : listSurfaceStyles) {
			EList<IfcSurfaceStyleElementSelect> styles = ss.getStyles();
			for (IfcSurfaceStyleElementSelect style : styles) {
				if (style instanceof IfcSurfaceStyleRendering) {
					IfcSurfaceStyleRendering ssr = (IfcSurfaceStyleRendering) style;
					IfcColourRgb colour = null;
					IfcColourOrFactor surfaceColour = ssr.getSurfaceColour();
					if (surfaceColour instanceof IfcColourRgb) {
						colour = (IfcColourRgb) surfaceColour;
					}
					String name = fitNameForQualifiedName(ss.getName());
					if (!surfaceStyleIds.contains(name)) {
						surfaceStyleIds.add(name);
						array.put(writeMaterial(name, 
								new double[] { colour.getRed(), colour.getGreen(), colour.getBlue() },
								ssr.isSetTransparency() && ssr.getTransparency() < 1.0f ? 1.0f - ssr.getTransparency() : 1.0f));
						break;
					}
				}
			}
		}
		return array;
	}

	private JSONObject writeMaterial(String name, double[] colors, double opacity) throws JSONException {
		return new JSONObject()
			.put("type", "material")
			.put("coreId", name + "Material")
			.put("baseColor", new JSONObject()
				.put("r", colors[0])
				.put("g", colors[1])
				.put("b", colors[2]))
			.put("alpha", opacity)
			.put("emit", 0.0);
	}

	private void calculateGeometryExtents() throws IfcEngineException, SerializerException {
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			calculateExtents(ifcProduct.getGlobalId().getWrappedValue(), ifcProduct);
		}
	}
	
	private void calculateExtents(String id, IdEObject ifcObject) throws IfcEngineException, SerializerException {
		// Get the extents object related to this geometric object 
		if (!geometryExtents.containsKey(id)) {
			geometryExtents.put(id, new Extents());
		}
		Extents extents = geometryExtents.get(id);

		for (int i = 0; i < geometry.getNrVertices(); i += 3) {
			// Use the vertex to calculate the boundaries of the geometric object
			addToExtents(extents, new float[] { geometry.getVertex(i + 0), geometry.getVertex(i + 1), geometry.getVertex(i + 2) });	
		}

		// Add the object's extents to the scene's total extents
		addToExtents(sceneExtents, extents.min);
		addToExtents(sceneExtents, extents.max);
	}

	private JSONArray writeGeometries(JSONArray array) throws IfcEngineException, JSONException, SerializerException {
		for (IfcRoof ifcRoof : model.getAll(IfcRoof.class)) {
			writeGeometricObject(array, ifcRoof, ifcRoof.getGlobalId().getWrappedValue(), "Roof");
		}
		for (IfcSlab ifcSlab : model.getAll(IfcSlab.class)) {
			if (ifcSlab.getPredefinedType() == IfcSlabTypeEnum.ROOF) {
				writeGeometricObject(array, ifcSlab, ifcSlab.getGlobalId().getWrappedValue(), "Roof");
			} else {
				writeGeometricObject(array, ifcSlab, ifcSlab.getGlobalId().getWrappedValue(), "Slab");
			}
		}
		for (IfcWindow ifcWindow : model.getAll(IfcWindow.class)) {
			writeGeometricObject(array, ifcWindow, ifcWindow.getGlobalId().getWrappedValue(), "Window");
		}
		for (IfcDoor ifcDoor : model.getAll(IfcDoor.class)) {
			writeGeometricObject(array, ifcDoor, ifcDoor.getGlobalId().getWrappedValue(), "Door");
		}
		for (IfcWall ifcWall : model.getAll(IfcWall.class)) {
			writeGeometricObject(array, ifcWall, ifcWall.getGlobalId().getWrappedValue(), "Wall");
		}
		for (IfcStair ifcStair : model.getAll(IfcStair.class)) {
			writeGeometricObject(array, ifcStair, ifcStair.getGlobalId().getWrappedValue(), "Stair");
		}
		for (IfcStairFlight ifcStairFlight : model.getAll(IfcStairFlight.class)) {
			writeGeometricObject(array, ifcStairFlight, ifcStairFlight.getGlobalId().getWrappedValue(), "StairFlight");
		}
		for (IfcFlowSegment ifcFlowSegment : model.getAll(IfcFlowSegment.class)) {
			writeGeometricObject(array, ifcFlowSegment, ifcFlowSegment.getGlobalId().getWrappedValue(), "FlowSegment");
		}
		for (IfcFurnishingElement ifcFurnishingElement : model.getAll(IfcFurnishingElement.class)) {
			writeGeometricObject(array, ifcFurnishingElement, ifcFurnishingElement.getGlobalId().getWrappedValue(), "FurnishingElement");
		}
		for (IfcPlate ifcPlate : model.getAll(IfcPlate.class)) {
			writeGeometricObject(array, ifcPlate, ifcPlate.getGlobalId().getWrappedValue(), "Plate");
		}
		for (IfcMember ifcMember : model.getAll(IfcMember.class)) {
			writeGeometricObject(array, ifcMember, ifcMember.getGlobalId().getWrappedValue(), "Member");
		}
		for (IfcWallStandardCase ifcWall : model.getAll(IfcWallStandardCase.class)) {
			writeGeometricObject(array, ifcWall, ifcWall.getGlobalId().getWrappedValue(), "WallStandardCase");
		}
		for (IfcCurtainWall ifcCurtainWall : model.getAll(IfcCurtainWall.class)) {
			writeGeometricObject(array, ifcCurtainWall, ifcCurtainWall.getGlobalId().getWrappedValue(), "CurtainWall");
		}
		for (IfcRailing ifcRailing : model.getAll(IfcRailing.class)) {
			writeGeometricObject(array, ifcRailing, ifcRailing.getGlobalId().getWrappedValue(), "Railing");
		}
		for (IfcColumn ifcColumn : model.getAll(IfcColumn.class)) {
			writeGeometricObject(array, ifcColumn, ifcColumn.getGlobalId().getWrappedValue(), "Column");
		}
		for (IfcBuildingElementProxy ifcBuildingElementProxy : model.getAll(IfcBuildingElementProxy.class)) {
			writeGeometricObject(array, ifcBuildingElementProxy, ifcBuildingElementProxy.getGlobalId().getWrappedValue(), "BuildingElementProxy");
		}
		return array;
	}

	private JSONArray writeGeometricObject(JSONArray array, IfcObjectDefinition ifcRootObject, String id, String ifcObjectType) throws IfcEngineException, JSONException, SerializerException {
		//id = id.replace('$', '-'); // Remove the $ character from geometry id's.
		//id = "_" + id; // Ensure that the id does not start with a digit

		boolean materialFound = false;
		String material = ifcObjectType;
		if (ifcRootObject instanceof IfcProduct) {
			IfcProduct ifcProduct = (IfcProduct) ifcRootObject;
			
			// If this product is composed of other objects, output each object separately
			EList<IfcRelDecomposes> isDecomposedBy = ifcProduct.getIsDecomposedBy();
			if (isDecomposedBy != null && !isDecomposedBy.isEmpty()) {
				for (IfcRelDecomposes dcmp : isDecomposedBy) {
					EList<IfcObjectDefinition> relatedObjects = dcmp.getRelatedObjects();
					for (IfcObjectDefinition relatedObject : relatedObjects) {
						writeGeometricObject(array, relatedObject, relatedObject.getGlobalId().getWrappedValue(), ifcObjectType);
					}
				}
				return array;
			}

			// Get the relating material for this model 
			Iterator<IfcRelAssociatesMaterial> ramIter = model.getAll(IfcRelAssociatesMaterial.class).iterator();
			boolean found = false;
			IfcMaterialSelect relatingMaterial = null;
			while (!found && ramIter.hasNext()) {
				IfcRelAssociatesMaterial ram = ramIter.next();
				if (ram.getRelatedObjects().contains(ifcProduct)) {
					found = true;
					relatingMaterial = ram.getRelatingMaterial();
				}
			}

			// Try to find the IFC material name
			if (found && relatingMaterial instanceof IfcMaterialLayerSetUsage) {
				IfcMaterialLayerSetUsage mlsu = (IfcMaterialLayerSetUsage) relatingMaterial;
				IfcMaterialLayerSet forLayerSet = mlsu.getForLayerSet();
				if (forLayerSet != null) {
					EList<IfcMaterialLayer> materialLayers = forLayerSet.getMaterialLayers();
					for (IfcMaterialLayer ml : materialLayers) {
						IfcMaterial ifcMaterial = ml.getMaterial();
						if (ifcMaterial != null) {
							String name = ifcMaterial.getName();
							String filterSpaces = fitNameForQualifiedName(name);
							materialFound = surfaceStyleIds.contains(filterSpaces);
							if (materialFound) {
								material = filterSpaces;
							}
						}
					}
				}
			} else if (found && relatingMaterial instanceof IfcMaterial) {
				IfcMaterial ifcMaterial = (IfcMaterial) relatingMaterial;
				String name = ifcMaterial.getName();
				String filterSpaces = fitNameForQualifiedName(name);
				materialFound = surfaceStyleIds.contains(filterSpaces);
				if (materialFound) {
					material = filterSpaces;
				}
			}

			// If no material was found then derive one from the presentation style
			if (!materialFound) {
				IfcProductRepresentation representation = ifcProduct.getRepresentation();
				if (representation instanceof IfcProductDefinitionShape) {
					IfcProductDefinitionShape pds = (IfcProductDefinitionShape) representation;
					EList<IfcRepresentation> representations = pds.getRepresentations();
					for (IfcRepresentation rep : representations) {
						if (rep instanceof IfcShapeRepresentation) {
							IfcShapeRepresentation sRep = (IfcShapeRepresentation) rep;
							EList<IfcRepresentationItem> items = sRep.getItems();
							for (IfcRepresentationItem item : items) {
								EList<IfcStyledItem> styledByItem = item.getStyledByItem();
								for (IfcStyledItem sItem : styledByItem) {
									EList<IfcPresentationStyleAssignment> styles = sItem.getStyles();
									for (IfcPresentationStyleAssignment sa : styles) {
										EList<IfcPresentationStyleSelect> styles2 = sa.getStyles();
										for (IfcPresentationStyleSelect pss : styles2) {
											if (pss instanceof IfcSurfaceStyle) {
												IfcSurfaceStyle ss = (IfcSurfaceStyle) pss;
												String name = ss.getName();
												String filterSpaces = fitNameForQualifiedName(name);
												materialFound = surfaceStyleIds.contains(filterSpaces);
												if (materialFound) {
													material = filterSpaces;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		// Add the object id to the related ifc type & material in the hash map
		HashMap<String, HashSet<String>> materialGeometryRel = null;
		if (!typeMaterialGeometryRel.containsKey(ifcObjectType)) {
			materialGeometryRel = new HashMap<String, HashSet<String>>();
			typeMaterialGeometryRel.put(ifcObjectType, materialGeometryRel);
		} else {
			materialGeometryRel = typeMaterialGeometryRel.get(ifcObjectType);
		}

		if (!materialGeometryRel.containsKey(material)) {
			materialGeometryRel.put(material, new HashSet<String>());
		}
		materialGeometryRel.get(material).add(id);

		// Serialize the geometric data itself
		array.put(writeGeometry(ifcRootObject, id));
		return array;
	}

	private JSONObject writeGeometry(IfcObjectDefinition ifcObject, String id) throws IfcEngineException, JSONException, SerializerException {
		// Calculate an offset for the model to find its relative coordinates inside the bounding box (in order to center the scene) 
		// TODO: In future use the geometry's bounding box to calculate a transformation matrix for the node along with relative coordinates
		float[] modelOffset = new float[] {
			-(sceneExtents.min[0] + sceneExtents.max[0]) * 0.5f,
			-(sceneExtents.min[1] + sceneExtents.max[1]) * 0.5f,
			-(sceneExtents.min[2] + sceneExtents.max[2]) * 0.5f };
		
		modelOffset[0] = Float.isInfinite(modelOffset[0]) || Float.isNaN(modelOffset[0])? 0.0f : modelOffset[0];
		modelOffset[1] = Float.isInfinite(modelOffset[1]) || Float.isNaN(modelOffset[1])? 0.0f : modelOffset[1];
		modelOffset[2] = Float.isInfinite(modelOffset[2]) || Float.isNaN(modelOffset[2])? 0.0f : modelOffset[2];

		JSONObject jsonObj = new JSONObject();
		
		JSONArray verticesArray = new JSONArray();
		jsonObj.put("type", "geometry")
			.put("coreId", ifcObject.getGlobalId().getWrappedValue())
			.put("primitive", "triangles")
			.put("positions", verticesArray);

		IfcEngineInstance instance = ifcEngineModel.getInstanceFromExpressId((int) ifcObject.getOid());
		IfcEngineInstanceVisualisationProperties instanceInModelling = instance.getVisualisationProperties();
		
		for (int i = instanceInModelling.getStartIndex(); i < instanceInModelling.getPrimitiveCount() * 3 + instanceInModelling.getStartIndex(); i++) {
			int index = geometry.getIndex(i) * 3;

			float x = geometry.getVertex(index);
			float y = geometry.getVertex(index + 1);
			float z = geometry.getVertex(index + 2);

			verticesArray
			.put((Float.isInfinite(x) || Float.isNaN(x)? 0.0f : x) + modelOffset[0])
			.put((Float.isInfinite(y) || Float.isNaN(y)? 0.0f : y) + modelOffset[1])
			.put((Float.isInfinite(z) || Float.isNaN(z)? 0.0f : z) + modelOffset[2]);
		}
		
		JSONArray normalsArray = new JSONArray();
		jsonObj.put("normals", normalsArray);
		for (int i = instanceInModelling.getStartIndex(); i < instanceInModelling.getPrimitiveCount() * 3 + instanceInModelling.getStartIndex(); i++) {
			int index = geometry.getIndex(i) * 3;

			float x = geometry.getNormal(index);
			float y = geometry.getNormal(index + 1);
			float z = geometry.getNormal(index + 2);

			normalsArray.put(x);
			normalsArray.put(y);
			normalsArray.put(z);
		}

		JSONArray indicesArray = new JSONArray(); 
		jsonObj.put("indices", indicesArray);
		for (int i = 0; i < instanceInModelling.getPrimitiveCount() * 3; i++) {
			indicesArray.put(i);
		}
		return jsonObj;
	}

	private JSONArray writeVisualScenes(JSONArray array) throws JSONException {
		// Calculate the maximum ray length through the scene (using the two extreme points of the scene's bounding box)
		float[] extentsDiff = new float[]{ sceneExtents.max[0] - sceneExtents.min[0], sceneExtents.max[1] - sceneExtents.min[1], sceneExtents.max[2] - sceneExtents.min[2] };
		if (Float.isInfinite(extentsDiff[0]))
			extentsDiff[0] = 50.0f;
		if (Float.isInfinite(extentsDiff[1]))
			extentsDiff[1] = 50.0f;
		if (Float.isInfinite(extentsDiff[2]))
			extentsDiff[2] = 50.0f;
		float extentsDiffLength = (float) Math.sqrt((double)(extentsDiff[0]*extentsDiff[0] + extentsDiff[1]*extentsDiff[1] + extentsDiff[2]*extentsDiff[2]));

		// Write the nodes to the stream
		JSONArray rendererNodes = new JSONArray();
		array.put(new JSONObject()	
			.put("type", "lookAt")
			.put("id", "main-lookAt")	
			.put("eye", new JSONObject()
				.put("x", extentsDiff[0] * 1.5f)
				.put("y", extentsDiff[1] * 1.5f)
				.put("z", extentsDiff[2] * 1.5f))
			.put("look", new JSONObject()
				.put("x", 0.0)
				.put("y", 0.0)
				.put("z", 0.0))
			.put("up", new JSONObject()
				.put("x", 0.0)
				.put("y", 0.0)
				.put("z", 1.0))
			.put("nodes", new JSONArray().put(new JSONObject()
					.put("type", "camera")
					.put("id", "main-camera")
					.put("optics", new JSONObject()
						.put("type", "perspective")
						.put("far", extentsDiffLength * 6)
						.put("near", extentsDiffLength * 0.001f)
						.put("aspect", 1.0)
						.put("fovy", 37.8493))
					.put("nodes", new JSONArray().put(new JSONObject()
						.put("type", "renderer")
						.put("id", "main-renderer")
						.put("clear", new JSONObject()
							.put("color", true)
							.put("depth", true)
							.put("stencil", false))
						.put("clearColor", new JSONObject()
							.put("r", 0.2)
							.put("g", 0.2)
							.put("b", 0.2)
							.put("a", 0.0))
						.put("nodes", rendererNodes.put(new JSONObject()
							// Add a simple light to the scene
							.put("type", "light")
							.put("id", "sun-light")
							.put("mode", "dir")
							.put("color", new JSONObject()
								.put("r", 0.8)
								.put("g", 0.8)
								.put("b", 0.8))
							.put("dir", new JSONObject()
								.put("x",-0.5)
								.put("y",-0.5)
								.put("z",-1.0))
							.put("diffuse", true)
							.put("specular", true))))))));

		// Output each geometry instance grouped by material
		HashSet<String> visitedNameIds = new HashSet<String>();
		for (String ifcObjectType : typeMaterialGeometryRel.keySet()) {
			String tagName = ifcObjectType.toLowerCase();
			JSONArray tagNodes = new JSONArray();
			rendererNodes.put(new JSONObject()
				.put("type", "tag")
				.put("tag", tagName)
				.put("id", tagName)
				.put("nodes", tagNodes));
			
			HashMap<String, HashSet<String>> materialGeometryRel = typeMaterialGeometryRel.get(ifcObjectType);
			for (String materialId : materialGeometryRel.keySet()) {
				JSONObject materialNode = new JSONObject();
				if (materialId == "Window") {
					tagNodes.put(new JSONObject()
						.put("type", "flags")
						.put("flags", new JSONObject().put("transparent", true))
						.put("nodes", new JSONArray().put(materialNode)));
				}
				else {
					tagNodes.put(materialNode);
				}
				materialNode
					.put("type", "material")
					.put("coreId", materialId + "Material");

				Set<String> geometryIds = materialGeometryRel.get(materialId);

				JSONArray materialNodes = new JSONArray();
				materialNode.put("nodes", materialNodes);
				for (String geometryId : geometryIds) {
					//Prevent duplicate id's
					String nameId = geometryId;
					if (visitedNameIds.contains(nameId)) {
						int n = 0;
						while (visitedNameIds.contains(nameId + "--" + Integer.toString(n))) {
							++n;
						}
						nameId = nameId + "--" + Integer.toString(n);
					}
					visitedNameIds.add(nameId);
					materialNodes.put(new JSONObject()
						.put("type", "name")
						.put("id", nameId)
						.put("nodes", new JSONArray().put(new JSONObject() 
							.put("type", "geometry")
							.put("coreId", geometryId))));
				}
			}
		}
		return array;
	}

	private JSONArray writeBounds() throws JSONException {
		float[] bounds = {sceneExtents.max[0] - sceneExtents.min[0], sceneExtents.max[1] - sceneExtents.min[1], sceneExtents.max[2] - sceneExtents.min[2]};
		return new JSONArray()
			.put(Float.isInfinite(bounds[0])? 50.0f : bounds[0])
			.put(Float.isInfinite(bounds[1])? 50.0f : bounds[1])
			.put(Float.isInfinite(bounds[2])? 50.0f : bounds[2]);
	}

	private String writeUnit() {
		SIPrefix lengthUnitPrefix = getLengthUnitPrefix(model);
		return lengthUnitPrefix == null? "1 meter" : Math.pow(10.0, lengthUnitPrefix.getValue()) + " " + lengthUnitPrefix.name().toLowerCase();
	}

	private JSONObject writeIfcTreeRelatedObject(HashSet<String> visitedIds, IfcObject object) throws JSONException {
		JSONObject jsonObj = new JSONObject()
			.put("type", object.isSetObjectType() ? object.getObjectType() : stripClassName(object.getClass()))
			.put("name", object.isSetName() ? object.getName() : "unknown")
			.put("id", object.getGlobalId().getWrappedValue())
			.put("decomposedBy", writeIfcTreeDecomposedBy(visitedIds, object))
			.put("definedBy", writeIfcTreeDefinedBy(visitedIds, (IfcObject) object));
		
		if (object instanceof IfcSpatialStructureElement) {
			jsonObj.put("contains", writeIfcTreeContainsElements(visitedIds, (IfcSpatialStructureElement) object));
		}
		return jsonObj;
	}

	private JSONArray writeIfcTree() throws JSONException {
		HashSet<String> visitedIds = new HashSet<String>();

		// Output the object relationships
		JSONArray jsonArray = new JSONArray();
		Map<Long, IdEObject> objects = model.getObjects();
		for (IdEObject object : objects.values()) {
			if (object instanceof IfcProject) {
				jsonArray.put(writeIfcTreeRelatedObject(visitedIds, (IfcProject) object));
			}
		}
		return jsonArray;
	}

	private JSONArray writeIfcTreeDecomposedBy(HashSet<String> visitedIds, IfcObjectDefinition objectDefinition) throws JSONException {
		JSONArray jsonArray = new JSONArray();
		EList<IfcRelDecomposes> relList = objectDefinition.getIsDecomposedBy();
		if (relList != null && !relList.isEmpty()) {
			for (IfcRelDecomposes rel : relList) {
				EList<IfcObjectDefinition> relatedObjects = rel.getRelatedObjects();
				for (IfcObjectDefinition relatedObject : relatedObjects) {
					if (relatedObject instanceof IfcObject) {
						if (!visitedIds.contains(relatedObject.getGlobalId().getWrappedValue())) {
							visitedIds.add(relatedObject.getGlobalId().getWrappedValue());
							jsonArray.put(writeIfcTreeRelatedObject(visitedIds, (IfcObject) relatedObject));
						}
					}
				}
			}
		}
		return jsonArray;
	}

	private JSONArray writeIfcTreeDefinedBy(HashSet<String> visitedIds, IfcObject object) throws JSONException {
		JSONArray jsonArray = new JSONArray();
		EList<IfcRelDefines> relList = object.getIsDefinedBy();
		if (relList != null && !relList.isEmpty()) {
			for (IfcRelDefines rel : relList) {
				EList<IfcObject> relatedObjects = rel.getRelatedObjects();
				for (IfcObject relatedObject : relatedObjects) {
					if (!visitedIds.contains(relatedObject.getGlobalId().getWrappedValue())) {
						visitedIds.add(relatedObject.getGlobalId().getWrappedValue());
						jsonArray.put(writeIfcTreeRelatedObject(visitedIds, relatedObject));
					}
				}
			}
		}
		return jsonArray;
	}

	private JSONObject writeIfcTreeProduct(IfcProduct object) throws JSONException {
		return new JSONObject()
			.put("type", object.isSetObjectType() ? object.getObjectType() : stripClassName(object.getClass()))
			.put("name", object.isSetName() ? object.getName() : "unknown")
			.put("id", object.getGlobalId().getWrappedValue());
		// writeIfcTreeDecomposedBy(object);
		// writeIfcTreeDefinedBy((IfcObject) object);
		// if (object instanceof IfcSpatialStructureElement) {
		// 		writeIfcTreeContainsElements((IfcSpatialStructureElement) object);
		// }
	}

	private JSONArray writeIfcTreeContainsElements(HashSet<String> visitedIds, IfcSpatialStructureElement spatialStructureElement) throws JSONException {
		JSONArray jsonArray = new JSONArray(); 
		EList<IfcRelContainedInSpatialStructure> relList = spatialStructureElement.getContainsElements();
		if (relList != null && !relList.isEmpty()) {
			for (IfcRelContainedInSpatialStructure rel : relList) {
				for (IfcProduct relatedObject : rel.getRelatedElements()) {
					if (!visitedIds.contains(relatedObject.getGlobalId().getWrappedValue())){
						visitedIds.add(relatedObject.getGlobalId().getWrappedValue());
						jsonArray.put(writeIfcTreeProduct(relatedObject));
					}
				}
			}
		}
		return jsonArray;
	}

	private JSONObject writeIfcProperties() throws JSONException {
		JSONObject jsonObj = new JSONObject(); 
		Map<Long, IdEObject> objects = model.getObjects();
		for (IdEObject object : objects.values()) {
			if (object instanceof IfcObject) {
				IfcObject ifcObject = (IfcObject) object;
				JSONObject wrappedJsonObj = new JSONObject();
				jsonObj.put(ifcObject.getGlobalId().getWrappedValue(), wrappedJsonObj);

				writeIfcPropertiesObject(wrappedJsonObj, ifcObject);
				if (object instanceof IfcProject) {
					writeIfcPropertiesProject(wrappedJsonObj, (IfcProject) object);
				} else if (object instanceof IfcSite) {
					writeIfcPropertiesSite(wrappedJsonObj, (IfcSite) object);
				} else if (object instanceof IfcBuilding) {
					writeIfcPropertiesBuilding(wrappedJsonObj, (IfcBuilding) object);
				} else if (object instanceof IfcBuildingStorey) {
					writeIfcPropertiesBuildingStorey(wrappedJsonObj, (IfcBuildingStorey) object);
				} else if (object instanceof IfcElement) {
					writeIfcPropertiesElement(wrappedJsonObj, (IfcElement) object);
				} else if (object instanceof IfcSpatialStructureElement) {
					writeIfcPropertiesSpatialStructureElement(wrappedJsonObj, (IfcSpatialStructureElement) object);
				} else if (object instanceof IfcProduct) {
					writeIfcPropertiesProduct(wrappedJsonObj, (IfcProduct) object);
				}
			}
		}
		return jsonObj;
	}

	private JSONObject writeIfcPropertiesProject(JSONObject jsonObj, IfcProject object) throws JSONException {
		if (object.isSetLongName()) {
			jsonObj.put("LongName", object.getLongName());
		}
		if (object.isSetPhase()) {
			jsonObj.put("Phase", object.getPhase());
		}
		if (object.getRepresentationContexts() != null && !object.getRepresentationContexts().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Representation Contexts", jsonArray);
			for (IfcRepresentationContext context : object.getRepresentationContexts()) {
				jsonArray.put(context.getContextIdentifier());
			}
		}
		/* TODO: It doesn't look like there's currently any useful information to be written for units?
		if (object.getUnitsInContext() != null) {
			EList<IfcUnit> units = object.getUnitsInContext().getUnits();
			if (units != null && !units.isEmpty()) {
				JSONArray jsonArray = new JSONArray();
				jsonObj.put("Units in Context", jsonArray); 
				for (IfcUnit unit : units) {
					jsonArray.put(unit.toString());
				}
			}
		}//*/
		return jsonObj;
	}

	private static JSONObject writeIfcPropertiesSite(JSONObject jsonObj, IfcSite object) throws JSONException {
		writeIfcPropertiesSpatialStructureElement(jsonObj, object);
		if (object.isSetRefLatitude()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Ref Latitude", jsonArray);
			for (Integer val : object.getRefLatitude()) {
				jsonArray.put(val.toString());
			}
		}
		if (object.isSetRefLongitude()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Ref Longtitude", jsonArray);
			for (Integer val : object.getRefLongitude()) {
				jsonArray.put(val.toString());
			}
		}
		if (object.isSetRefElevationAsString()) {
			jsonObj.put("Ref Elevation", object.getRefElevationAsString() );
		} else if (object.isSetRefElevation()) {
			jsonObj.put("Ref Elevation", new DecimalFormat("#.##").format(object.getRefElevation()));
		}
		if (object.isSetLandTitleNumber()) {
			jsonObj.put("Land Title Number", object.getLandTitleNumber());
		}
		if (object.isSetSiteAddress()) {
			jsonObj.put("Site Address", addressToString(object.getSiteAddress()));
		}
		return jsonObj;
	}
	
	private static JSONObject writeIfcPropertiesBuilding(JSONObject jsonObj, IfcBuilding object) throws JSONException {
		writeIfcPropertiesSpatialStructureElement(jsonObj, object);
		if (object.isSetElevationOfRefHeightAsString()) {
			jsonObj.put("Elevation of Ref Height", object.getElevationOfRefHeightAsString());
		} else if (object.isSetElevationOfRefHeight()) {
			jsonObj.put("Elevation of Ref Height", new DecimalFormat("#.##").format(object.getElevationOfRefHeight()) + ",");
		}
		if (object.isSetElevationOfTerrainAsString()) {
			jsonObj.put("Elevation of Terrain", object.getElevationOfTerrainAsString());
		} else if (object.isSetElevationOfTerrain()) {
			jsonObj.put("Elevation of Terrain", object.getElevationOfTerrain());
		}
		if (object.isSetBuildingAddress()) {
			jsonObj.put("Building Address", addressToString(object.getBuildingAddress()));
		}
		return jsonObj;
	}
	private static JSONObject writeIfcPropertiesBuildingStorey(JSONObject jsonObj, IfcBuildingStorey object) throws JSONException {
		writeIfcPropertiesSpatialStructureElement(jsonObj, object);
		if (object.isSetElevationAsString()) {
			jsonObj.put("Elevation", object.getElevationAsString());
		}
		if (object.isSetElevation()) {
			jsonObj.put("Elevation", new DecimalFormat("#.##").format(object.getElevation()));
		}
		return jsonObj;
	}
	private static JSONObject writeIfcPropertiesElement(JSONObject jsonObj, IfcElement object) throws JSONException {
		writeIfcPropertiesProduct(jsonObj, object);
		if (object.isSetTag()) {
			jsonObj.put("Tag", object.getTag());
		}
		if (object.getFillsVoids() != null && !object.getFillsVoids().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Fills Voids", jsonArray);
			for (IfcRelFillsElement rel : object.getFillsVoids()) {
				jsonArray.put(writeLink(rel));
				/* TODO
				new JSONObject()
					.put("Relating Opening Element", writeLink(rel.getRelatingOpeningElement()))
					.put("Related Building Element", writeLink(rel.getRelatedBuildingElement())));//*/
			}
		}
		if (object.getConnectedTo() != null	&& !object.getConnectedTo().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Connected To", jsonArray);
			for (IfcRelConnectsElements rel : object.getConnectedTo()) {
				jsonArray.put(writeLink(rel));
				/* TODO: 
				JSONObject jsonConectedTo = new JSONObject();
				jsonArray.put(jsonConectedTo);
				/* TODO: Nothing to write for connection geometry...?
				if (rel.isSetConnectionGeometry()) {
					jsonConectedTo.put("Connection Geometry", writeConnectionGeometry(rel.getConnectionGeometry()));
				}//*/
				/* TODO:
				boolean isSetConnectionGeometry();
				IfcElement getRelatingElement();
				void setRelatingElement(IfcElement value);
				IfcElement getRelatedElement(); //*/
			}
		}
		if (object.getHasCoverings() != null && !object.getHasCoverings().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Has Coverings", jsonArray);
			for (IfcRelCoversBldgElements rel : object.getHasCoverings()) {
				jsonArray.put(writeLink(rel));
				/* TODO:
				getRelatingBuildingElement();
				EList<IfcCovering> getRelatedCoverings();
				//*/
			}
		}
		if (object.getHasProjections() != null && !object.getHasProjections().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Has Projections", jsonArray);
//			for (IfcRelProjectsElement rel : object.getHasProjections()) {
				/* TODO:
				jsonArray.put(new JSONObject());
				IfcElement getRelatingElement();
				IfcFeatureElementAddition getRelatedFeatureElement();//*/				
//			}
		}
		if (object.getHasStructuralMember() != null && !object.getHasStructuralMember().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Has Structural Member", jsonArray); // TODO: Shouldn't this be "Has Structural Member(s)"?
			for (IfcRelConnectsStructuralElement rel : object.getHasStructuralMember()) {
				jsonArray.put(writeLink(rel));
				/* TODO:
				IfcElement getRelatingElement();
				IfcStructuralMember getRelatedStructuralMember();
				//*/
			}
		}
		if (object.getReferencedInStructures() != null && !object.getReferencedInStructures().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Referenced In Structures", jsonArray); // TODO: Shouldn't this be "Has Structural Member(s)"?
			for (IfcRelReferencedInSpatialStructure rel : object.getReferencedInStructures()) {
				jsonArray.put(writeLink(rel));
				/* TODO:
				EList<IfcProduct> getRelatedElements();
				IfcSpatialStructureElement getRelatingStructure();//*/
			}
		}
		if (object.getHasPorts() != null && !object.getHasPorts().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Has Ports", jsonArray);
			for (IfcRelConnectsPortToElement rel : object.getHasPorts()) {
				jsonArray.put(writeLink(rel));
				/* TODO:
				getRelatingPort();
				IfcElement getRelatedElement();//*/
			}
		}
		if (object.getHasOpenings() != null && !object.getHasOpenings().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Has Openings", jsonArray);
			for (IfcRelVoidsElement rel : object.getHasOpenings()) {
				jsonArray.put(writeLink(rel));
				/* TODO:
				getRelatingBuildingElement();
				IfcFeatureElementSubtraction getRelatedOpeningElement();
				//*/
			}
		}
		if (object.getIsConnectionRealization() != null && !object.getIsConnectionRealization().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Is Connection Realization", jsonArray); // TODO: Should this rather be something like "Realizing Elements"? 
			for (IfcRelConnectsWithRealizingElements rel : object.getIsConnectionRealization()) {
				jsonArray.put(writeLink(rel));
				/* TODO:
				getRealizingElements();
				String getConnectionType();
				void setConnectionType(String value);
				void unsetConnectionType();
				boolean isSetConnectionType();
				//*/
			}
		}
		if (object.getProvidesBoundaries() != null && !object.getProvidesBoundaries().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Provides Boundaries", jsonArray); 
			for (IfcRelSpaceBoundary rel : object.getProvidesBoundaries()) {
				jsonArray.put(writeLink(rel));
			}
		}
		if (object.getConnectedFrom() != null && !object.getConnectedFrom().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Connected From", jsonArray); 
			for (IfcRelConnectsElements rel : object.getConnectedFrom()) {
				jsonArray.put(writeLink(rel));
				//TODO
			}
		}
		if (object.getContainedInStructure() != null && !object.getContainedInStructure().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Contained In Structure", jsonArray); 
			for (IfcRelContainedInSpatialStructure rel : object.getContainedInStructure()) {
				jsonArray.put(writeLink(rel));
				//TODO
			}
		}
		return jsonObj;
	}

	private static JSONObject writeIfcPropertiesSpatialStructureElement(JSONObject jsonObj, IfcSpatialStructureElement object) throws JSONException {
		writeIfcPropertiesProduct(jsonObj, object);
		if (object.isSetLongName()) {
			jsonObj.put("Long Name", object.getLongName());
		}
		if (object.getCompositionType() != null) {
			jsonObj.put("Composition Type", object.getCompositionType().toString());
		}
		if (object.getReferencesElements() != null && !object.getReferencesElements().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("References Elements", jsonArray); 
			for (IfcRelReferencedInSpatialStructure rel : object.getReferencesElements()) {
				jsonArray.put(writeLink(rel));
				//TODO
			}
		}
		if (object.getServicedBySystems() != null && !object.getServicedBySystems().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Serviced By Systems", jsonArray); 
			for (IfcRelServicesBuildings rel : object.getServicedBySystems()) {
				jsonArray.put(writeLink(rel));
				//TODO
			}
		}
		if (object.getContainsElements() != null && !object.getContainsElements().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Contains Elements", jsonArray); 
			for (IfcRelContainedInSpatialStructure rel : object.getContainsElements()) {
				jsonArray.put(writeLink(rel));
				//TODO
			}
		}
		return jsonObj;
	}

	private static JSONObject writeIfcPropertiesProduct(JSONObject jsonObj, IfcProduct object) throws JSONException {
		writeIfcPropertiesObject(jsonObj, object);
		if (object.isSetObjectPlacement()) {
			object.getObjectPlacement().getPlacesObject();
		}
		if (object.isSetRepresentation()) {
			object.getRepresentation();
		}
		if (object.getReferencedBy() != null && !object.getReferencedBy().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Referenced By", jsonArray); 
			for (IfcRelAssignsToProduct rel : object.getReferencedBy()) {
				jsonArray.put(writeLink(rel));
				//TODO
			}
		}
		return jsonObj;
	}
	
	private static JSONObject writeIfcPropertiesObject(JSONObject jsonObj, IfcObject object) throws JSONException {
		writeIfcPropertiesObjectDefinition(jsonObj, object);
		if (object.isSetObjectType()) {
			object.getObjectType();
		}
		if (object.getIsDefinedBy() != null && !object.getIsDefinedBy().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Is Defined By", jsonArray); 
			for (IfcRelDefines rel : object.getIsDefinedBy()) {
				jsonArray.put(writeLink(rel));
				//TODO
			}
		}
		return jsonObj;
	}

	private static JSONObject writeIfcPropertiesObjectDefinition(JSONObject jsonObj, IfcObjectDefinition object) throws JSONException {
		writeIfcPropertiesRoot(jsonObj, object);

		if (object.getHasAssignments() != null && !object.getHasAssignments().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Is Defined By", jsonArray); 
			for (IfcRelAssigns rel : object.getHasAssignments()) {
				jsonArray.put(writeLink(rel));
				//TODO
			}
		}
		if (object.getIsDecomposedBy() != null && !object.getIsDecomposedBy().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Is Defined By", jsonArray); 
			for (IfcRelDecomposes rel : object.getIsDecomposedBy()) {
				jsonArray.put(writeLink(rel));
				//TODO
			}
		}
		if (object.getDecomposes() != null && !object.getDecomposes().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Is Defined By", jsonArray); 
			for (IfcRelDecomposes rel : object.getDecomposes()) {
				jsonArray.put(writeLink(rel));
				//TODO
			}
		}
		if (object.getHasAssociations() != null && !object.getHasAssociations().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			jsonObj.put("Has Associations", jsonArray); 
			for (IfcRelAssociates rel : object.getHasAssociations()) {
				jsonArray.put(writeLink(rel));
				//TODO
			}
		}
		return jsonObj;
	}

	private static JSONObject writeIfcPropertiesRoot(JSONObject jsonObj, IfcRoot object) throws JSONException {
		/* NOT NEEDED:
		if (object.getGlobalId() != null) {			
			jsonObj.put("Global Id", object.getGlobalId().getWrappedValue());
		}//*/
		if (object.getOwnerHistory() != null) {
			IfcOwnerHistory history = object.getOwnerHistory();
			JSONObject jsonOwningUser = new JSONObject();
			jsonObj.put("Owner History", new JSONObject()
				.put("Owning User", jsonOwningUser)
				.put("Owning Application", writeApplication(history.getOwningApplication()))
				.put("State", history.getState().getName())
				.put("Change Action", history.getChangeAction().getName())
				.put("Creation Date", history.getCreationDate()));

			jsonOwningUser.put("The Person", writePerson(history.getOwningUser().getThePerson()));
			jsonOwningUser.put("The Organization", writeOrganization(history.getOwningUser().getTheOrganization()));
			if (history.getOwningUser().isSetRoles()) {
				jsonOwningUser.put("Roles", writeActorRoles(history.getOwningUser().getRoles()));
			}
			
			if (history.isSetLastModifiedDate()) {
				jsonObj.put("Last Modified Date", history.getLastModifiedDate()); // TODO: Format as date?
			}
			
			if (history.isSetLastModifyingUser()) {
				// TODO IfcPersonAndOrganization getLastModifyingUser();
			}
			
			if (history.isSetLastModifyingApplication()) {
				// TODO IfcApplication getLastModifyingApplication();
			}
		}
		if (object.isSetName()) {
			object.getName();
		}
		if (object.getDescription() != null) {
			jsonObj.put("Description", object.getDescription());
		}
		return jsonObj;
	}
	
	private static JSONObject writePerson(IfcPerson person) {
		JSONObject jsonObj = new JSONObject();
		/* TODO
		String getId();
		boolean isSetId();
		
		String getFamilyName();
		void setFamilyName(String value);
		boolean isSetFamilyName();

		String getGivenName();
		void setGivenName(String value);
		boolean isSetGivenName();

		EList<String> getMiddleNames();
		boolean isSetMiddleNames();

		EList<String> getPrefixTitles();
		boolean isSetPrefixTitles();

		EList<String> getSuffixTitles();
		boolean isSetSuffixTitles();

		EList<IfcActorRole> getRoles();
		boolean isSetRoles();

		EList<IfcAddress> getAddresses();
		void unsetAddresses();
		boolean isSetAddresses();
		
		EList<IfcPersonAndOrganization> getEngagedIn();//*/
		return jsonObj;
	}
	
	private static JSONObject writeOrganization(IfcOrganization organization) {
		JSONObject jsonObj = new JSONObject();
		// TODO
		return jsonObj;
	}
	
	private static JSONObject writeActorRoles(EList<IfcActorRole> actorRoles) {
		JSONObject jsonObj = new JSONObject();
		// TODO
		return jsonObj;
	}
	
	private static JSONObject writeApplication(IfcApplication application) {
		JSONObject jsonObj = new JSONObject();
		/* TODO
		IfcOrganization getApplicationDeveloper();
		void setApplicationDeveloper(IfcOrganization value);
		String getVersion();
		void setVersion(String value);
		String getApplicationFullName();
		String getApplicationIdentifier(); //*/
		return jsonObj;
	}

	private JSONArray writeIfcTypes() throws JSONException {
		JSONArray jsonArray = new JSONArray();
		for (String ifcObjectType : typeMaterialGeometryRel.keySet()) {
			jsonArray.put(ifcObjectType);
		}
		return jsonArray;
	}
	
	private static JSONObject writeLink(IfcRoot root) throws JSONException {
		// TODO: Might return a JSONObject later (with link name & global id)
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("link", root.getGlobalId().getWrappedValue());
		return jsonObj;
	}

	private static String fitNameForQualifiedName(String name) {
		if (name == null) {
			return "Null";
		}
		StringBuilder builder = new StringBuilder(name);
		int indexOfChar = builder.indexOf(" ");
		while (indexOfChar >= 0) {
			builder.deleteCharAt(indexOfChar);
			indexOfChar = builder.indexOf(" ");
		}
		indexOfChar = builder.indexOf(",");
		while (indexOfChar >= 0) {
			builder.setCharAt(indexOfChar, '_');
			indexOfChar = builder.indexOf(",");
		}
		indexOfChar = builder.indexOf("/");
		while (indexOfChar >= 0) {
			builder.setCharAt(indexOfChar, '_');
			indexOfChar = builder.indexOf("/");
		}
		indexOfChar = builder.indexOf("*");
		while (indexOfChar >= 0) {
			builder.setCharAt(indexOfChar, '_');
			indexOfChar = builder.indexOf("/");
		}
		return builder.toString();
	}

	private void addToExtents(Extents extents, float[] vertex) {
		// if (!materialGeometryRel.containsKey(material)) {
		// materialGeometryRel.put(material, new Extents);
		// }
		// materialGeometryRel.get(material).add(id);
		// geometryExtents.
		extents.min[0] = Math.min(vertex[0], extents.min[0]);
		extents.min[1] = Math.min(vertex[1], extents.min[1]);
		extents.min[2] = Math.min(vertex[2], extents.min[2]);
		extents.max[0] = Math.max(vertex[0], extents.max[0]);
		extents.max[1] = Math.max(vertex[1], extents.max[1]);
		extents.max[2] = Math.max(vertex[2], extents.max[2]);
	}

	private static String stripClassName(Class<?> classObject) {
		String name = classObject.getName();
		int ifcIndex = name.lastIndexOf("Ifc");
		int implIndex = name.lastIndexOf("Impl");
		return name.substring(Math.max(name.lastIndexOf('.', ifcIndex < 0? 0 : ifcIndex)+1, ifcIndex < 0? 0 : ifcIndex+3), implIndex < 0? name.length() : implIndex);
	}
	
	private static String addressToString(IfcPostalAddress address) {
		// TODO: is this formatting correct?
		String str = new String();
		boolean firstLine = true;
		if (address.isSetAddressLines()) {
			for (String line : address.getAddressLines()) {
				str += firstLine ? "" : "\n";
				firstLine = false;
				str += line;
			}
		}
		//* TODO: Are these perhaps captured by address lines?
		else if (address.isSetInternalLocation()) {
			str += firstLine ? "" : "\n";
			firstLine = false;
			str = address.getInternalLocation();
		}
		if (address.isSetPostalBox()) {
			str += firstLine ? "" : "\n";
			firstLine = false;
			str += "\n" + address.getPostalBox();
		}
		if (address.isSetTown()) {
			str += firstLine ? "" : "\n";
			firstLine = false;
			str += address.getTown();
		}
		if (address.isSetRegion()) {
			str += firstLine ? "" : "\n";
			firstLine = false;
			str += address.getRegion();
		}
		if (address.isSetPostalCode()) {
			str += firstLine ? "" : "\n";
			firstLine = false;
			str += address.getPostalCode();
		}
		if (address.isSetCountry()) {
			str += firstLine ? "" : "\n";
			firstLine = false;
			str += address.getCountry();
		}//*/
		return str;
	}

	private static SIPrefix getLengthUnitPrefix(IfcModelInterface model) {
		SIPrefix lengthUnitPrefix = null;
		boolean prefixFound = false;
		Map<Long, IdEObject> objects = model.getObjects();
		for (IdEObject object : objects.values()) {
			if (object instanceof IfcProject) {
				IfcUnitAssignment unitsInContext = ((IfcProject) object).getUnitsInContext();
				EList<IfcUnit> units = unitsInContext.getUnits();
				for (IfcUnit unit : units) {
					if (unit instanceof IfcSIUnit) {
						IfcSIUnit ifcSIUnit = (IfcSIUnit) unit;
						IfcUnitEnum unitType = ifcSIUnit.getUnitType();
						if (unitType == IfcUnitEnum.LENGTHUNIT) {
							prefixFound = true;
							switch (ifcSIUnit.getPrefix()) {
							case EXA:
								lengthUnitPrefix = SIPrefix.EXAMETER;
								break;
							case PETA:
								lengthUnitPrefix = SIPrefix.PETAMETER;
								break;
							case TERA:
								lengthUnitPrefix = SIPrefix.TERAMETER;
								break;
							case GIGA:
								lengthUnitPrefix = SIPrefix.GIGAMETER;
								break;
							case MEGA:
								lengthUnitPrefix = SIPrefix.MEGAMETER;
								break;
							case KILO:
								lengthUnitPrefix = SIPrefix.KILOMETER;
								break;
							case HECTO:
								lengthUnitPrefix = SIPrefix.HECTOMETER;
								break;
							case DECA:
								lengthUnitPrefix = SIPrefix.DECAMETER;
								break;
							case DECI:
								lengthUnitPrefix = SIPrefix.DECIMETER;
								break;
							case CENTI:
								lengthUnitPrefix = SIPrefix.CENTIMETER;
								break;
							case MILLI:
								lengthUnitPrefix = SIPrefix.MILLIMETER;
								break;
							case MICRO:
								lengthUnitPrefix = SIPrefix.MICROMETER;
								break;
							case NANO:
								lengthUnitPrefix = SIPrefix.NANOMETER;
								break;
							case PICO:
								lengthUnitPrefix = SIPrefix.PICOMETER;
								break;
							case FEMTO:
								lengthUnitPrefix = SIPrefix.FEMTOMETER;
								break;
							case ATTO:
								lengthUnitPrefix = SIPrefix.ATTOMETER;
								break;
							case NULL:
								lengthUnitPrefix = SIPrefix.METER;
								break;
							}
							break;
						}
					}
				}
			}
			if (prefixFound)
				break;
		}
		return lengthUnitPrefix;
	}
}
