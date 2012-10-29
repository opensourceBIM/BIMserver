package org.bimserver.geometry.json;

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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.GeometryInstance;
import org.bimserver.models.ifc2x3tc1.IfcBuildingElementProxy;
import org.bimserver.models.ifc2x3tc1.IfcColourOrFactor;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcColumn;
import org.bimserver.models.ifc2x3tc1.IfcCurtainWall;
import org.bimserver.models.ifc2x3tc1.IfcDoor;
import org.bimserver.models.ifc2x3tc1.IfcFlowSegment;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayer;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcMember;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPlate;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRailing;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcRoof;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcSlabTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcStair;
import org.bimserver.models.ifc2x3tc1.IfcStairFlight;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.models.ifc2x3tc1.IfcWallStandardCase;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.scenejs.Extends;
import org.bimserver.scenejs.GeometrySerializer;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.gson.stream.JsonWriter;

public class JsonGeometrySerializer extends GeometrySerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonGeometrySerializer.class);

	private HashMap<String, HashMap<String, HashSet<String>>> typeMaterialGeometryRel = new HashMap<String, HashMap<String, HashSet<String>>>();
	private List<String> surfaceStyleIds;
	private IfcEngineModel ifcEngineModel;

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, IfcEngine ifcEngine) throws SerializerException {
		super.init(model, projectInfo, pluginManager, ifcEngine);
		this.surfaceStyleIds = new ArrayList<String>();
	}

	@Override
	protected void reset() {
		setMode(Mode.BODY);
	}

	@Override
	public boolean write(OutputStream out) throws SerializerException {
		if (getMode() == Mode.BODY) {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, Charsets.UTF_8);
			try {
				calculateGeometryExtents();
				
				JsonWriter jsonWriter = new JsonWriter(new BufferedWriter(outputStreamWriter));
				
				jsonWriter.beginObject();
				jsonWriter.name("geometry");
				jsonWriter.beginArray();
				writeGeometries(jsonWriter);
				jsonWriter.endArray();
				jsonWriter.endObject();
				
				jsonWriter.flush();
			} catch (Exception e) {
				LOGGER.error("", e);
			}
			setMode(Mode.FINISHED);
			if (getIfcEngine() != null) {
				getIfcEngine().close();
			}
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	private void writeMaterials(JsonWriter jsonWriter) throws IOException {
		writeMaterial(jsonWriter, "Space", new double[] { 0.137255f, 0.403922f, 0.870588f }, 1.0f);
		writeMaterial(jsonWriter, "Roof", new double[] { 0.837255f, 0.203922f, 0.270588f }, 1.0f);
		writeMaterial(jsonWriter, "Slab", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeMaterial(jsonWriter, "Wall", new double[] { 0.537255f, 0.337255f, 0.237255f }, 1.0f);
		writeMaterial(jsonWriter, "WallStandardCase", new double[] { 1.0f, 1.0f, 1.0f }, 1.0f);
		writeMaterial(jsonWriter, "Door", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeMaterial(jsonWriter, "Window", new double[] { 0.2f, 0.2f, 0.8f }, 0.2f);
		writeMaterial(jsonWriter, "Railing", new double[] { 0.137255f, 0.203922f, 0.270588f }, 1.0f);
		writeMaterial(jsonWriter, "Column", new double[] { 0.437255f, 0.603922f, 0.370588f, }, 1.0f);
		writeMaterial(jsonWriter, "FurnishingElement", new double[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f);
		writeMaterial(jsonWriter, "CurtainWall", new double[] { 0.5f, 0.5f, 0.5f }, 0.5f);
		writeMaterial(jsonWriter, "Stair", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeMaterial(jsonWriter, "BuildingElementProxy", new double[] { 0.5f, 0.5f, 0.5f }, 1.0f);
		writeMaterial(jsonWriter, "FlowSegment", new double[] { 0.6f, 0.4f, 0.5f }, 1.0f);

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
						writeMaterial(jsonWriter, name, 
								new double[] { colour.getRed(), colour.getGreen(), colour.getBlue() },
								ssr.isSetTransparency() && ssr.getTransparency() < 1.0f ? 1.0f - ssr.getTransparency() : 1.0f);
						break;
					}
				}
			}
		}
	}

	private void writeMaterial(JsonWriter jsonWriter, String name, double[] colors, double opacity) throws IOException {
		jsonWriter.beginObject();
		jsonWriter.name("type").value("material");
		jsonWriter.name("coreId").value(name + "Material");
		jsonWriter.name("baseColor").beginObject().name("r").value(colors[0]).name("g").value(colors[1]).name("b").value(colors[2]).endObject();
		jsonWriter.name("alpha").value(opacity);
		jsonWriter.name("emit").value(0.0);
		jsonWriter.endObject();
	}

	private void writeGeometries(JsonWriter jsonWriter) throws IfcEngineException, SerializerException, IOException {
		for (IfcRoof ifcRoof : model.getAll(IfcRoof.class)) {
			writeGeometricObject(jsonWriter, ifcRoof, ifcRoof.getGlobalId().getWrappedValue(), "Roof");
		}
		for (IfcSlab ifcSlab : model.getAll(IfcSlab.class)) {
			if (ifcSlab.getPredefinedType() == IfcSlabTypeEnum.ROOF) {
				writeGeometricObject(jsonWriter, ifcSlab, ifcSlab.getGlobalId().getWrappedValue(), "Roof");
			} else {
				writeGeometricObject(jsonWriter, ifcSlab, ifcSlab.getGlobalId().getWrappedValue(), "Slab");
			}
		}
		for (IfcWindow ifcWindow : model.getAll(IfcWindow.class)) {
			writeGeometricObject(jsonWriter, ifcWindow, ifcWindow.getGlobalId().getWrappedValue(), "Window");
		}
		for (IfcDoor ifcDoor : model.getAll(IfcDoor.class)) {
			writeGeometricObject(jsonWriter, ifcDoor, ifcDoor.getGlobalId().getWrappedValue(), "Door");
		}
		for (IfcWall ifcWall : model.getAll(IfcWall.class)) {
			writeGeometricObject(jsonWriter, ifcWall, ifcWall.getGlobalId().getWrappedValue(), "Wall");
		}
		for (IfcStair ifcStair : model.getAll(IfcStair.class)) {
			writeGeometricObject(jsonWriter, ifcStair, ifcStair.getGlobalId().getWrappedValue(), "Stair");
		}
		for (IfcStairFlight ifcStairFlight : model.getAll(IfcStairFlight.class)) {
			writeGeometricObject(jsonWriter, ifcStairFlight, ifcStairFlight.getGlobalId().getWrappedValue(), "StairFlight");
		}
		for (IfcFlowSegment ifcFlowSegment : model.getAll(IfcFlowSegment.class)) {
			writeGeometricObject(jsonWriter, ifcFlowSegment, ifcFlowSegment.getGlobalId().getWrappedValue(), "FlowSegment");
		}
		for (IfcFurnishingElement ifcFurnishingElement : model.getAll(IfcFurnishingElement.class)) {
			writeGeometricObject(jsonWriter, ifcFurnishingElement, ifcFurnishingElement.getGlobalId().getWrappedValue(), "FurnishingElement");
		}
		for (IfcPlate ifcPlate : model.getAll(IfcPlate.class)) {
			writeGeometricObject(jsonWriter, ifcPlate, ifcPlate.getGlobalId().getWrappedValue(), "Plate");
		}
		for (IfcMember ifcMember : model.getAll(IfcMember.class)) {
			writeGeometricObject(jsonWriter, ifcMember, ifcMember.getGlobalId().getWrappedValue(), "Member");
		}
		for (IfcWallStandardCase ifcWall : model.getAll(IfcWallStandardCase.class)) {
			writeGeometricObject(jsonWriter, ifcWall, ifcWall.getGlobalId().getWrappedValue(), "WallStandardCase");
		}
		for (IfcCurtainWall ifcCurtainWall : model.getAll(IfcCurtainWall.class)) {
			writeGeometricObject(jsonWriter, ifcCurtainWall, ifcCurtainWall.getGlobalId().getWrappedValue(), "CurtainWall");
		}
		for (IfcRailing ifcRailing : model.getAll(IfcRailing.class)) {
			writeGeometricObject(jsonWriter, ifcRailing, ifcRailing.getGlobalId().getWrappedValue(), "Railing");
		}
		for (IfcColumn ifcColumn : model.getAll(IfcColumn.class)) {
			writeGeometricObject(jsonWriter, ifcColumn, ifcColumn.getGlobalId().getWrappedValue(), "Column");
		}
		for (IfcBuildingElementProxy ifcBuildingElementProxy : model.getAll(IfcBuildingElementProxy.class)) {
			writeGeometricObject(jsonWriter, ifcBuildingElementProxy, ifcBuildingElementProxy.getGlobalId().getWrappedValue(), "BuildingElementProxy");
		}
	}

	private void writeGeometricObject(JsonWriter jsonWriter, IfcProduct ifcRootObject, String id, String ifcObjectType) throws IfcEngineException, SerializerException, IOException {
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
						writeGeometricObject(jsonWriter, (IfcProduct) relatedObject, relatedObject.getGlobalId().getWrappedValue(), ifcObjectType);
					}
				}
				return;
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
		writeGeometry(jsonWriter, ifcRootObject, id);
	}

	private void writeGeometry(JsonWriter jsonWriter, IfcProduct ifcObject, String id) throws IfcEngineException, SerializerException, IOException {
		// Calculate an offset for the model to find its relative coordinates inside the bounding box (in order to center the scene) 
		// TODO: In future use the geometry's bounding box to calculate a transformation matrix for the node along with relative coordinates
		Extends sceneExtends = getSceneExtends();
		float[] modelOffset = new float[] {
			-(sceneExtends.min[0] + sceneExtends.max[0]) * 0.5f,
			-(sceneExtends.min[1] + sceneExtends.max[1]) * 0.5f,
			-(sceneExtends.min[2] + sceneExtends.max[2]) * 0.5f };
		
		modelOffset[0] = Float.isInfinite(modelOffset[0]) || Float.isNaN(modelOffset[0])? 0.0f : modelOffset[0];
		modelOffset[1] = Float.isInfinite(modelOffset[1]) || Float.isNaN(modelOffset[1])? 0.0f : modelOffset[1];
		modelOffset[2] = Float.isInfinite(modelOffset[2]) || Float.isNaN(modelOffset[2])? 0.0f : modelOffset[2];

		jsonWriter.beginObject();
		
		if (ifcObject.getGeometryInstance() == null) {
			jsonWriter.name("type").value("geometry");
			jsonWriter.name("coreId").value(ifcObject.getOid());
			jsonWriter.name("primitive").value("triangles");
			jsonWriter.name("positions").beginArray();
			
			IfcEngineInstance instance = ifcEngineModel.getInstanceFromExpressId((int) ifcObject.getOid());
			IfcEngineInstanceVisualisationProperties instanceInModelling = instance.getVisualisationProperties();
			
			for (int i = instanceInModelling.getStartIndex(); i < instanceInModelling.getPrimitiveCount() * 3 + instanceInModelling.getStartIndex(); i++) {
				int index = getIndex(i) * 3;
				
				float x = getVertex(index);
				float y = getVertex(index + 1);
				float z = getVertex(index + 2);
				
				jsonWriter.value((Float.isInfinite(x) || Float.isNaN(x)? 0.0f : x) + modelOffset[0]);
				jsonWriter.value((Float.isInfinite(y) || Float.isNaN(y)? 0.0f : y) + modelOffset[1]);
				jsonWriter.value((Float.isInfinite(z) || Float.isNaN(z)? 0.0f : z) + modelOffset[2]);
			}
			
			jsonWriter.endArray();
			jsonWriter.name("normals").beginArray();
			
			for (int i = instanceInModelling.getStartIndex(); i < instanceInModelling.getPrimitiveCount() * 3 + instanceInModelling.getStartIndex(); i++) {
				int index = getIndex(i) * 3;
				
				float x = getNormal(index);
				float y = getNormal(index + 1);
				float z = getNormal(index + 2);
				
				jsonWriter.value(x).value(y).value(z);
			}
			
			jsonWriter.endArray();
			
			jsonWriter.name("indices").beginArray();
			for (int i = 0; i < instanceInModelling.getPrimitiveCount() * 3; i++) {
				jsonWriter.value(i);
			}
			jsonWriter.endArray();
		} else {
			writeGeometryFromInstancesGeometryObject(jsonWriter, ifcObject, modelOffset);
			//writeGeometryFromGenericGeometryObject(jsonWriter, ifcObject, modelOffset);
		}
		jsonWriter.endObject();
	}

	private void writeGeometryFromInstancesGeometryObject(JsonWriter jsonWriter, IfcProduct ifcObject, float[] modelOffset) throws IOException {
		GeometryInstance geometryInstance = ifcObject.getGeometryInstance();
		
		if (geometryInstance != null) {
			ByteBuffer verticesBuffer = ByteBuffer.wrap(geometryInstance.getVertices());
			ByteBuffer normalsBuffer = ByteBuffer.wrap(geometryInstance.getNormals());

			jsonWriter.name("type").value("geometry");
			jsonWriter.name("coreId").value(ifcObject.getOid());
			jsonWriter.name("primitive").value("triangles");
			jsonWriter.name("positions").beginArray();
			for (int i=0; i<geometryInstance.getPrimitiveCount() * 3 * 3; i++) {
				jsonWriter.value(verticesBuffer.getFloat() + modelOffset[i % 3]);
			}
			jsonWriter.endArray();
			jsonWriter.name("normals").beginArray();
			for (int i=0; i<geometryInstance.getPrimitiveCount() * 3 * 3; i++) {
				jsonWriter.value(normalsBuffer.getFloat());
			}
			jsonWriter.endArray();
			
			jsonWriter.name("indices").beginArray();
			for (int i = 0; i < geometryInstance.getPrimitiveCount() * 3; i++) {
				jsonWriter.value(i);
			}
			jsonWriter.endArray();
		}
	}

	@SuppressWarnings("unused")
	private void writeGeometryFromGenericGeometryObject(JsonWriter jsonWriter, IfcProduct ifcObject, float[] modelOffset) throws IOException {
		GeometryInstance geometryInstance = ifcObject.getGeometryInstance();
		
		if (geometryInstance != null) {
			jsonWriter.name("type").value("geometry");
			jsonWriter.name("coreId").value(ifcObject.getOid());
			jsonWriter.name("primitive").value("triangles");
			jsonWriter.name("positions").beginArray();
			
			for (int i = geometryInstance.getStartIndex(); i < geometryInstance.getPrimitiveCount() * 3 + geometryInstance.getStartIndex(); i++) {
				int index = getIndex(i) * 3;
				
				float x = getVertex(index);
				float y = getVertex(index + 1);
				float z = getVertex(index + 2);
				
				jsonWriter.value((Float.isInfinite(x) || Float.isNaN(x)? 0.0f : x) + modelOffset[0]);
				jsonWriter.value((Float.isInfinite(y) || Float.isNaN(y)? 0.0f : y) + modelOffset[1]);
				jsonWriter.value((Float.isInfinite(z) || Float.isNaN(z)? 0.0f : z) + modelOffset[2]);
			}
			
			jsonWriter.endArray();
			jsonWriter.name("normals").beginArray();
			
			for (int i = geometryInstance.getStartIndex(); i < geometryInstance.getPrimitiveCount() * 3 + geometryInstance.getStartIndex(); i++) {
				int index = getIndex(i) * 3;
				
				float x = getNormal(index);
				float y = getNormal(index + 1);
				float z = getNormal(index + 2);
				
				jsonWriter.value(x).value(y).value(z);
			}
			
			jsonWriter.endArray();
			
			jsonWriter.name("indices").beginArray();
			for (int i = 0; i < geometryInstance.getPrimitiveCount() * 3; i++) {
				jsonWriter.value(i);
			}
			jsonWriter.endArray();
		}
	}

	private String fitNameForQualifiedName(String name) {
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
}