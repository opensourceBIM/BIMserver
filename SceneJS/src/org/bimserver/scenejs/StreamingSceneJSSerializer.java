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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.GeometryInstance;
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
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
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
import org.bimserver.models.store.Bounds;
import org.bimserver.models.store.SIPrefix;
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
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.gson.stream.JsonWriter;

public class StreamingSceneJSSerializer extends EmfSerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(StreamingSceneJSSerializer.class);

	/**
	 * Extents provides an axis-aligned bounding cuboid for geometric data, 
	 * represented as a pair of 3 dimensional vectors for the two opposing corners of the cuboid.
	 */
	private class Extents {
		public float[] min = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };
		public float[] max = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };
		
		public void addToMinExtents(EList<Float> extents) {
			addToMinExtents(new float[]{extents.get(0), extents.get(1), extents.get(2)});
		}

		public void addToMaxExtents(EList<Float> extents) {
			addToMaxExtents(new float[]{extents.get(0), extents.get(1), extents.get(2)});
		}

		public void addToMinExtents(float[] vertex) {
			for (int i=0; i<vertex.length; i++) {
				min[i] = Math.min(vertex[i], min[i]);
			}
		}
		
		public void addToMaxExtents(float[] vertex) {
			for (int i=0; i<vertex.length; i++) {
				max[i] = Math.max(vertex[i], max[i]);
			}
		}
		
		@Override
		public String toString() {
			return "min: " + Arrays.toString(min) + ", max: " + Arrays.toString(max);
		}

		public void integrate(Bounds bounds) {
			addToMinExtents(new float[]{bounds.getMin().getX(), bounds.getMin().getY(), bounds.getMin().getZ()});
			addToMaxExtents(new float[]{bounds.getMax().getX(), bounds.getMax().getY(), bounds.getMax().getZ()});
		}
	}
	private Extents sceneExtents = new Extents();
	private HashMap<String, Extents> geometryExtents = new HashMap<String, Extents>();
	private HashMap<String, HashMap<String, HashSet<String>>> typeMaterialGeometryRel = new HashMap<String, HashMap<String, HashSet<String>>>();
	private List<String> surfaceStyleIds;
	private IfcEngineGeometry geometry;
	private IfcEngineModel ifcEngineModel;
	private IfcEngine ifcEngine;

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, IfcEngine ifcEngine) throws SerializerException {
		super.init(model, projectInfo, pluginManager, ifcEngine);
		this.ifcEngine = ifcEngine;
		this.surfaceStyleIds = new ArrayList<String>();
	}

	private IfcEngineGeometry getGeometry() {
		if (geometry == null) {
			try {
				ifcEngine.init();
				Serializer serializer = getPluginManager().requireIfcStepSerializer();
				serializer.init(model, getProjectInfo(), getPluginManager(), ifcEngine);
				ifcEngineModel = ifcEngine.openModel(serializer.getBytes());
				ifcEngineModel.setPostProcessing(true);
				geometry = ifcEngineModel.finalizeModelling(ifcEngineModel.initializeModelling());
			} catch (IfcEngineException e) {
				e.printStackTrace();
			} catch (SerializerException e) {
				e.printStackTrace();
			}
		}
		return geometry;
	}
	
	@SuppressWarnings("unused")
	private int getNrIndices() {
		if (getModel().getGeometry() != null) {
			return getModel().getGeometry().getIndices().size();
		} else {
			return getGeometry().getNrIndices();
		}
	}
	
	private int getNrVertices() {
		if (getModel().getGeometry() != null) {
			return getModel().getGeometry().getVertices().size();
		} else {
			return getGeometry().getNrVertices();
		}
	}
	
	private float getVertex(int index) {
		if (getModel().getGeometry() != null) {
			return getModel().getGeometry().getVertices().get(index);
		} else {
			return getGeometry().getVertex(index);
		}
	}
	
	private float getNormal(int index) {
		if (getModel().getGeometry() != null) {
			return getModel().getGeometry().getNormals().get(index);
		} else {
			return getGeometry().getNormal(index);
		}
	}
	
	private int getIndex(int index) {
		if (getModel().getGeometry() != null) {
			return getModel().getGeometry().getIndices().get(index);
		} else {
			return getGeometry().getIndex(index);
		}
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
				System.out.println(sceneExtents);
				
				JsonWriter jsonWriter = new JsonWriter(new BufferedWriter(outputStreamWriter));
//				jsonWriter.setIndent("  ");
				
				/* Write data to stream
				writer.writeln("\/* Author:      " + getProjectInfo().getAuthorName());
				writer.writeln("   Description: " + getProjectInfo().getDescription());
				writer.writeln("*\/");*/
				
				jsonWriter.beginObject();
				jsonWriter.name("type").value("scene");
				jsonWriter.name("id").value("Scene");
				jsonWriter.name("canvasId").value("scenejsCanvas");
				jsonWriter.name("loggingElementId").value("scenejsLog");
				jsonWriter.name("flags").beginObject().name("backfaces").value(false).endObject();
				jsonWriter.name("nodes");
				jsonWriter.beginArray();
				jsonWriter.beginObject().name("id").value("library").name("type").value("library").name("nodes").beginArray();
				writeMaterials(jsonWriter);
				writeGeometries(jsonWriter);
				jsonWriter.endArray();
				jsonWriter.endObject();
				writeVisualScenes(jsonWriter);
				jsonWriter.endArray();
				
				// Append additional custom data to the scene node
				jsonWriter.name("data").beginObject();
				jsonWriter.name("bounds");
				writeBounds(jsonWriter);
				jsonWriter.name("unit");
				writeUnit(jsonWriter);
				jsonWriter.name("ifcTypes");
				writeIfcTypes(jsonWriter);
				jsonWriter.name("relationships");
				writeIfcTree(jsonWriter);
				jsonWriter.name("properties");
				writeIfcProperties(jsonWriter);
				jsonWriter.endObject();
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

	private void calculateGeometryExtents() throws IfcEngineException, SerializerException {
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			calculateExtents(ifcProduct.getGlobalId().getWrappedValue(), ifcProduct);
		}
	}
	
	private void calculateExtents(String id, IfcProduct ifcObject) throws IfcEngineException, SerializerException {
		// Get the extents object related to this geometric object 
		if (!geometryExtents.containsKey(id)) {
			geometryExtents.put(id, new Extents());
		}
		Extents extents = geometryExtents.get(id);

		if (ifcObject.getGeometryInstance() == null) {
			for (int i = 0; i < getNrVertices(); i += 3) {
				extents.addToMinExtents(new float[] { getVertex(i + 0), getVertex(i + 1), getVertex(i + 2) });
				extents.addToMaxExtents(new float[] { getVertex(i + 0), getVertex(i + 1), getVertex(i + 2) });
			}
		} else {
			extents.integrate(ifcObject.getGeometryInstance().getBounds());
		}
		sceneExtents.addToMinExtents(extents.min);
		sceneExtents.addToMaxExtents(extents.max);
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
		float[] modelOffset = new float[] {
			-(sceneExtents.min[0] + sceneExtents.max[0]) * 0.5f,
			-(sceneExtents.min[1] + sceneExtents.max[1]) * 0.5f,
			-(sceneExtents.min[2] + sceneExtents.max[2]) * 0.5f };
		
		modelOffset[0] = Float.isInfinite(modelOffset[0]) || Float.isNaN(modelOffset[0])? 0.0f : modelOffset[0];
		modelOffset[1] = Float.isInfinite(modelOffset[1]) || Float.isNaN(modelOffset[1])? 0.0f : modelOffset[1];
		modelOffset[2] = Float.isInfinite(modelOffset[2]) || Float.isNaN(modelOffset[2])? 0.0f : modelOffset[2];

		jsonWriter.beginObject();
		
		if (ifcObject.getGeometryInstance() == null) {
			jsonWriter.name("type").value("geometry");
			jsonWriter.name("coreId").value(ifcObject.getGlobalId().getWrappedValue());
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
			jsonWriter.name("coreId").value(ifcObject.getGlobalId().getWrappedValue());
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
			jsonWriter.name("coreId").value(ifcObject.getGlobalId().getWrappedValue());
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

	private void writeVisualScenes(JsonWriter jsonWriter) throws IOException {
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
		jsonWriter.
			beginObject()
				.name("type").value("lookAt")
				.name("id").value("main-lookAt")
				.name("eye")
				.beginObject()
					.name("x").value(extentsDiff[0] * 1.5f)
					.name("y").value(extentsDiff[1] * 1.5f)
					.name("z").value(extentsDiff[2] * 1.5f)
				.endObject()
				.name("look")
				.beginObject()
					.name("x").value(0.0)
					.name("y").value(0.0)
					.name("z").value(0.0)
				.endObject()
				.name("up")
				.beginObject()
					.name("x").value(0.0)
					.name("y").value(0.0)
					.name("z").value(1.0)
				.endObject()
				.name("nodes")
				.beginArray()
					.beginObject()
						.name("type").value("camera")
						.name("id").value("main-camera")
						.name("optics")
						.beginObject()
							.name("type").value("perspective")
							.name("far").value(extentsDiffLength * 6)
							.name("near").value(extentsDiffLength * 0.001f)
							.name("aspect").value(1.0)
							.name("fovy").value(37.8493)
						.endObject()
						.name("nodes")
						.beginArray()
							.beginObject()
								.name("type").value("renderer")
								.name("id").value("main-renderer")
								.name("clear")
								.beginObject()
									.name("color").value(true)
									.name("depth").value(true)
									.name("stencil").value(false)
								.endObject()
								.name("clearColor")
								.beginObject()
									.name("r").value(0.2)
									.name("g").value(0.2)
									.name("b").value(0.2)
									.name("a").value(0.2)
								.endObject()
								.name("nodes")
								.beginArray()
									.beginObject()
										.name("type").value("light")
										.name("id").value("sun-light")
										.name("mode").value("dir")
										.name("color")
										.beginObject()
											.name("r").value(0.8)
											.name("g").value(0.8)
											.name("b").value(0.8)
										.endObject()
										.name("dir")
										.beginObject()
											.name("x").value(-0.5)
											.name("y").value(-0.5)
											.name("z").value(-1.0)
										.endObject()
										.name("diffuse").value(true)
										.name("specular").value(true)
									.endObject();
									writeNodes(jsonWriter);
jsonWriter						.endArray()
							.endObject()
						.endArray()
					.endObject()
				.endArray()
			.endObject();
	}

	private void writeNodes(JsonWriter jsonWriter) throws IOException {
		// Output each geometry instance grouped by material
		HashSet<String> visitedNameIds = new HashSet<String>();
		for (String ifcObjectType : typeMaterialGeometryRel.keySet()) {
			String tagName = ifcObjectType.toLowerCase();
			jsonWriter.beginObject();
			jsonWriter.name("type").value("tag");
			jsonWriter.name("tag").value(tagName);
			jsonWriter.name("id").value(tagName);
			jsonWriter.name("nodes");
			jsonWriter.beginArray();
			
			HashMap<String, HashSet<String>> materialGeometryRel = typeMaterialGeometryRel.get(ifcObjectType);
			for (String materialId : materialGeometryRel.keySet()) {
				jsonWriter.beginObject();
				if (materialId == "Window") {
					jsonWriter.name("type").value("flags");
					jsonWriter.name("flags").beginObject().name("transparent").value(true).endObject();
					jsonWriter.name("nodes").beginArray().endArray();
				}
				jsonWriter.name("type").value("material");
				jsonWriter.name("coreId").value(materialId + "Material");

				Set<String> geometryIds = materialGeometryRel.get(materialId);

				jsonWriter.name("nodes");
				jsonWriter.beginArray();
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
					jsonWriter.beginObject();
					jsonWriter.name("type").value("name");
					jsonWriter.name("id").value(nameId);
					jsonWriter.name("nodes").beginArray().beginObject();
					jsonWriter.name("type").value("geometry");
					jsonWriter.name("coreId").value(geometryId);
					jsonWriter.endObject();
					jsonWriter.endArray();
					jsonWriter.endObject();
				}
				jsonWriter.endArray();
				jsonWriter.endObject();
			}
			jsonWriter.endArray();
			jsonWriter.endObject();
		}	
	}

	private void writeBounds(JsonWriter jsonWriter) throws IOException {
		float[] bounds = {sceneExtents.max[0] - sceneExtents.min[0], sceneExtents.max[1] - sceneExtents.min[1], sceneExtents.max[2] - sceneExtents.min[2]};
		jsonWriter.beginArray();
		jsonWriter.value(Float.isInfinite(bounds[0])? 50.0f : bounds[0]);
		jsonWriter.value(Float.isInfinite(bounds[1])? 50.0f : bounds[1]);
		jsonWriter.value(Float.isInfinite(bounds[2])? 50.0f : bounds[2]);
		jsonWriter.endArray();
	}

	private void writeUnit(JsonWriter jsonWriter) throws IOException {
		SIPrefix lengthUnitPrefix = getLengthUnitPrefix(model);
		jsonWriter.value(lengthUnitPrefix == null? "1 meter" : Math.pow(10.0, lengthUnitPrefix.getValue()) + " " + lengthUnitPrefix.name().toLowerCase());
	}

	private void writeIfcTreeRelatedObject(JsonWriter jsonWriter, HashSet<String> visitedIds, IfcObject object) throws IOException {
		jsonWriter.beginObject();
		jsonWriter.name("type").value(object.isSetObjectType() ? object.getObjectType() : stripClassName(object.getClass()));
		jsonWriter.name("name").value(object.isSetName() ? object.getName() : "unknown");
		jsonWriter.name("id").value(object.getGlobalId().getWrappedValue());
		jsonWriter.name("decomposedBy");
		writeIfcTreeDecomposedBy(jsonWriter, visitedIds, object);
		jsonWriter.name("definedBy");
		writeIfcTreeDefinedBy(jsonWriter, visitedIds, (IfcObject)object);
		
		if (object instanceof IfcSpatialStructureElement) {
			jsonWriter.name("contains");
			writeIfcTreeContainsElements(jsonWriter, visitedIds, (IfcSpatialStructureElement) object);
		}
		jsonWriter.endObject();
	}

	private void writeIfcTree(JsonWriter jsonWriter) throws IOException {
		jsonWriter.beginArray();
		HashSet<String> visitedIds = new HashSet<String>();

		// Output the object relationships
		Map<Long, IdEObject> objects = model.getObjects();
		for (IdEObject object : objects.values()) {
			if (object instanceof IfcProject) {
				writeIfcTreeRelatedObject(jsonWriter, visitedIds, (IfcProject) object);
			}
		}
		jsonWriter.endArray();
	}

	private void writeIfcTreeDecomposedBy(JsonWriter jsonWriter, HashSet<String> visitedIds, IfcObjectDefinition objectDefinition) throws IOException {
		jsonWriter.beginArray();
		EList<IfcRelDecomposes> relList = objectDefinition.getIsDecomposedBy();
		if (relList != null && !relList.isEmpty()) {
			for (IfcRelDecomposes rel : relList) {
				EList<IfcObjectDefinition> relatedObjects = rel.getRelatedObjects();
				for (IfcObjectDefinition relatedObject : relatedObjects) {
					if (relatedObject instanceof IfcObject) {
						if (!visitedIds.contains(relatedObject.getGlobalId().getWrappedValue())) {
							visitedIds.add(relatedObject.getGlobalId().getWrappedValue());
							writeIfcTreeRelatedObject(jsonWriter, visitedIds, (IfcObject) relatedObject);
						}
					}
				}
			}
		}
		jsonWriter.endArray();
	}

	private void writeIfcTreeDefinedBy(JsonWriter jsonWriter, HashSet<String> visitedIds, IfcObject object) throws IOException {
		jsonWriter.beginArray();
		EList<IfcRelDefines> relList = object.getIsDefinedBy();
		if (relList != null && !relList.isEmpty()) {
			for (IfcRelDefines rel : relList) {
				EList<IfcObject> relatedObjects = rel.getRelatedObjects();
				for (IfcObject relatedObject : relatedObjects) {
					if (!visitedIds.contains(relatedObject.getGlobalId().getWrappedValue())) {
						visitedIds.add(relatedObject.getGlobalId().getWrappedValue());
						writeIfcTreeRelatedObject(jsonWriter, visitedIds, relatedObject);
					}
				}
			}
		}
		jsonWriter.endArray();
	}

	private void writeIfcTreeProduct(JsonWriter jsonWriter, IfcProduct object) throws IOException {
		jsonWriter.beginObject();
		jsonWriter.name("type").value(object.isSetObjectType() ? object.getObjectType() : stripClassName(object.getClass()));
		jsonWriter.name("name").value(object.isSetName() ? object.getName() : "unknown");
		jsonWriter.name("id").value(object.getGlobalId().getWrappedValue());
		jsonWriter.endObject();
		// writeIfcTreeDecomposedBy(object);
		// writeIfcTreeDefinedBy((IfcObject) object);
		// if (object instanceof IfcSpatialStructureElement) {
		// 		writeIfcTreeContainsElements((IfcSpatialStructureElement) object);
		// }
	}

	private void writeIfcTreeContainsElements(JsonWriter jsonWriter, HashSet<String> visitedIds, IfcSpatialStructureElement spatialStructureElement) throws IOException {
		jsonWriter.beginArray();
		EList<IfcRelContainedInSpatialStructure> relList = spatialStructureElement.getContainsElements();
		if (relList != null && !relList.isEmpty()) {
			for (IfcRelContainedInSpatialStructure rel : relList) {
				for (IfcProduct relatedObject : rel.getRelatedElements()) {
					if (!visitedIds.contains(relatedObject.getGlobalId().getWrappedValue())){
						visitedIds.add(relatedObject.getGlobalId().getWrappedValue());
						writeIfcTreeProduct(jsonWriter, relatedObject);
					}
				}
			}
		}
		jsonWriter.endArray();
	}

	private void writeIfcProperties(JsonWriter jsonWriter) throws IOException {
		jsonWriter.beginObject();
		Map<Long, IdEObject> objects = model.getObjects();
		for (IdEObject object : objects.values()) {
			if (object instanceof IfcObject) {
				IfcObject ifcObject = (IfcObject) object;
				jsonWriter.name(ifcObject.getGlobalId().getWrappedValue());
				jsonWriter.beginObject();

				writeIfcPropertiesObject(jsonWriter, ifcObject);
				if (object instanceof IfcProject) {
					writeIfcPropertiesProject(jsonWriter, (IfcProject) object);
				} else if (object instanceof IfcSite) {
					writeIfcPropertiesSite(jsonWriter, (IfcSite) object);
				} else if (object instanceof IfcBuilding) {
					writeIfcPropertiesBuilding(jsonWriter, (IfcBuilding) object);
				} else if (object instanceof IfcBuildingStorey) {
					writeIfcPropertiesBuildingStorey(jsonWriter, (IfcBuildingStorey) object);
				} else if (object instanceof IfcElement) {
					writeIfcPropertiesElement(jsonWriter, (IfcElement) object);
				} else if (object instanceof IfcSpatialStructureElement) {
					writeIfcPropertiesSpatialStructureElement(jsonWriter, (IfcSpatialStructureElement) object);
				} else if (object instanceof IfcProduct) {
					writeIfcPropertiesProduct(jsonWriter, (IfcProduct) object);
				}
				jsonWriter.endObject();
			}
		}
		jsonWriter.endObject();
	}

	private void writeIfcPropertiesProject(JsonWriter jsonWriter, IfcProject object) throws IOException {
		if (object.isSetLongName()) {
			jsonWriter.name("LongName").value(object.getLongName());
		}
		if (object.isSetPhase()) {
			jsonWriter.name("Phase").value(object.getPhase());
		}
		if (object.getRepresentationContexts() != null && !object.getRepresentationContexts().isEmpty()) {
			jsonWriter.name("Representation Contexts");
			jsonWriter.beginArray();
			for (IfcRepresentationContext context : object.getRepresentationContexts()) {
				jsonWriter.value(context.getContextIdentifier());
			}
			jsonWriter.endArray();
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
	}

	private void writeIfcPropertiesSite(JsonWriter jsonWriter, IfcSite object) throws IOException {
		writeIfcPropertiesSpatialStructureElement(jsonWriter, object);
		if (object.isSetRefLatitude()) {
			jsonWriter.name("Ref Latitude");
			jsonWriter.beginArray();
			for (Integer val : object.getRefLatitude()) {
				jsonWriter.value(val.toString());
			}
			jsonWriter.endArray();
		}
		if (object.isSetRefLongitude()) {
			jsonWriter.name("Ref Longtitude");
			jsonWriter.beginArray();
			for (Integer val : object.getRefLongitude()) {
				jsonWriter.value(val.toString());
			}
			jsonWriter.endArray();
		}
		if (object.isSetRefElevationAsString()) {
			jsonWriter.name("Ref Elevation").value(object.getRefElevationAsString());
		} else if (object.isSetRefElevation()) {
			jsonWriter.name("Ref Elevation").value(new DecimalFormat("#.##").format(object.getRefElevation()));
		}
		if (object.isSetLandTitleNumber()) {
			jsonWriter.name("Land Title Number").value(object.getLandTitleNumber());
		}
		if (object.isSetSiteAddress()) {
			jsonWriter.name("Site Address").value(addressToString(object.getSiteAddress()));
		}
	}
	
	private void writeIfcPropertiesBuilding(JsonWriter jsonWriter, IfcBuilding object) throws IOException {
		writeIfcPropertiesSpatialStructureElement(jsonWriter, object);
		if (object.isSetElevationOfRefHeightAsString()) {
			jsonWriter.name("Elevation of Ref Height").value(object.getElevationOfRefHeightAsString());
		} else if (object.isSetElevationOfRefHeight()) {
			jsonWriter.name("Elevation of Ref Height").value(new DecimalFormat("#.##").format(object.getElevationOfRefHeight()) + ",");
		}
		if (object.isSetElevationOfTerrainAsString()) {
			jsonWriter.name("Elevation of Terrain").value(object.getElevationOfTerrainAsString());
		} else if (object.isSetElevationOfTerrain()) {
			jsonWriter.name("Elevation of Terrain").value(object.getElevationOfTerrain());
		}
		if (object.isSetBuildingAddress()) {
			jsonWriter.name("Building Address").value(addressToString(object.getBuildingAddress()));
		}
	}
	
	private void writeIfcPropertiesBuildingStorey(JsonWriter jsonWriter, IfcBuildingStorey object) throws IOException {
		writeIfcPropertiesSpatialStructureElement(jsonWriter, object);
		if (object.isSetElevationAsString()) {
			jsonWriter.name("Elevation").value(object.getElevationAsString());
		}
		if (object.isSetElevation()) {
			jsonWriter.name("Elevation").value(new DecimalFormat("#.##").format(object.getElevation()));
		}
	}
	
	private void writeIfcPropertiesElement(JsonWriter jsonWriter, IfcElement object) throws IOException {
		writeIfcPropertiesProduct(jsonWriter, object);
		if (object.isSetTag()) {
			jsonWriter.name("Tag").value(object.getTag());
		}
		if (object.getFillsVoids() != null && !object.getFillsVoids().isEmpty()) {
			jsonWriter.name("Fills Voids");
			jsonWriter.beginArray();
			for (IfcRelFillsElement rel : object.getFillsVoids()) {
				writeLink(jsonWriter, rel);
				/* TODO
				new JSONObject()
					.put("Relating Opening Element", writeLink(rel.getRelatingOpeningElement()))
					.put("Related Building Element", writeLink(rel.getRelatedBuildingElement())));//*/
			}
			jsonWriter.endArray();
		}
		if (object.getConnectedTo() != null	&& !object.getConnectedTo().isEmpty()) {
			jsonWriter.name("Connected To");
			jsonWriter.beginArray();
			for (IfcRelConnectsElements rel : object.getConnectedTo()) {
				writeLink(jsonWriter, rel);
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
			jsonWriter.endArray();
		}
		if (object.getHasCoverings() != null && !object.getHasCoverings().isEmpty()) {
			jsonWriter.name("Has Coverings");
			jsonWriter.beginArray();
			for (IfcRelCoversBldgElements rel : object.getHasCoverings()) {
				writeLink(jsonWriter, rel);
				/* TODO:
				getRelatingBuildingElement();
				EList<IfcCovering> getRelatedCoverings();
				//*/
			}
			jsonWriter.endArray();
		}
		if (object.getHasProjections() != null && !object.getHasProjections().isEmpty()) {
			jsonWriter.name("Has Projections");
			jsonWriter.beginArray();
//			for (IfcRelProjectsElement rel : object.getHasProjections()) {
				/* TODO:
				jsonArray.put(new JSONObject());
				IfcElement getRelatingElement();
				IfcFeatureElementAddition getRelatedFeatureElement();//*/				
//			}
			jsonWriter.endArray();
		}
		if (object.getHasStructuralMember() != null && !object.getHasStructuralMember().isEmpty()) {
			jsonWriter.name("Has Structural Member"); // TODO: Shouldn't this be "Has Structural Member(s)"?
			jsonWriter.beginArray();
			for (IfcRelConnectsStructuralElement rel : object.getHasStructuralMember()) {
				writeLink(jsonWriter, rel);
				/* TODO:
				IfcElement getRelatingElement();
				IfcStructuralMember getRelatedStructuralMember();
				//*/
			}
			jsonWriter.endArray();
		}
		if (object.getReferencedInStructures() != null && !object.getReferencedInStructures().isEmpty()) {
			jsonWriter.name("Referenced In Structures"); // TODO: Shouldn't this be "Has Structural Member(s)"?
			jsonWriter.beginArray();
			for (IfcRelReferencedInSpatialStructure rel : object.getReferencedInStructures()) {
				writeLink(jsonWriter, rel);
				/* TODO:
				EList<IfcProduct> getRelatedElements();
				IfcSpatialStructureElement getRelatingStructure();//*/
			}
			jsonWriter.endArray();
		}
		if (object.getHasPorts() != null && !object.getHasPorts().isEmpty()) {
			jsonWriter.name("Has Ports");
			jsonWriter.beginArray();
			for (IfcRelConnectsPortToElement rel : object.getHasPorts()) {
				writeLink(jsonWriter, rel);
				/* TODO:
				getRelatingPort();
				IfcElement getRelatedElement();//*/
			}
			jsonWriter.endArray();
		}
		if (object.getHasOpenings() != null && !object.getHasOpenings().isEmpty()) {
			jsonWriter.name("Has Openings");
			jsonWriter.beginArray();
			for (IfcRelVoidsElement rel : object.getHasOpenings()) {
				writeLink(jsonWriter, rel);
				/* TODO:
				getRelatingBuildingElement();
				IfcFeatureElementSubtraction getRelatedOpeningElement();
				//*/
			}
			jsonWriter.endArray();
		}
		if (object.getIsConnectionRealization() != null && !object.getIsConnectionRealization().isEmpty()) {
			jsonWriter.name("Is Connection Realization"); // TODO: Should this rather be something like "Realizing Elements"?
			jsonWriter.beginArray();
			for (IfcRelConnectsWithRealizingElements rel : object.getIsConnectionRealization()) {
				writeLink(jsonWriter, rel);
				/* TODO:
				getRealizingElements();
				String getConnectionType();
				void setConnectionType(String value);
				void unsetConnectionType();
				boolean isSetConnectionType();
				//*/
			}
			jsonWriter.endArray();
		}
		if (object.getProvidesBoundaries() != null && !object.getProvidesBoundaries().isEmpty()) {
			jsonWriter.name("Provides Boundaries");
			jsonWriter.beginArray();
			for (IfcRelSpaceBoundary rel : object.getProvidesBoundaries()) {
				writeLink(jsonWriter, rel);
			}
			jsonWriter.endArray();
		}
		if (object.getConnectedFrom() != null && !object.getConnectedFrom().isEmpty()) {
			jsonWriter.name("Connected From");
			jsonWriter.beginArray();
			for (IfcRelConnectsElements rel : object.getConnectedFrom()) {
				writeLink(jsonWriter, rel);
				//TODO
			}
			jsonWriter.endArray();
		}
		if (object.getContainedInStructure() != null && !object.getContainedInStructure().isEmpty()) {
			jsonWriter.name("Contained In Structure");
			jsonWriter.beginArray();
			for (IfcRelContainedInSpatialStructure rel : object.getContainedInStructure()) {
				writeLink(jsonWriter, rel);
				//TODO
			}
			jsonWriter.endArray();
		}
	}

	private void writeIfcPropertiesSpatialStructureElement(JsonWriter jsonWriter, IfcSpatialStructureElement object) throws IOException {
		writeIfcPropertiesProduct(jsonWriter, object);
		if (object.isSetLongName()) {
			jsonWriter.name("Long Name").value(object.getLongName());
		}
		if (object.getCompositionType() != null) {
			jsonWriter.name("Composition Type").value(object.getCompositionType().toString());
		}
		if (object.getReferencesElements() != null && !object.getReferencesElements().isEmpty()) {
			jsonWriter.name("References Elements");
			jsonWriter.beginArray();
			for (IfcRelReferencedInSpatialStructure rel : object.getReferencesElements()) {
				writeLink(jsonWriter, rel);
				//TODO
			}
			jsonWriter.endArray();
		}
		if (object.getServicedBySystems() != null && !object.getServicedBySystems().isEmpty()) {
			jsonWriter.name("Serviced By Systems");
			jsonWriter.beginArray();
			for (IfcRelServicesBuildings rel : object.getServicedBySystems()) {
				writeLink(jsonWriter, rel);
				//TODO
			}
			jsonWriter.endArray();
		}
		if (object.getContainsElements() != null && !object.getContainsElements().isEmpty()) {
			jsonWriter.name("Contains Elements");
			jsonWriter.beginArray(); 
			for (IfcRelContainedInSpatialStructure rel : object.getContainsElements()) {
				writeLink(jsonWriter, rel);
				//TODO
			}
			jsonWriter.endArray();
		}
	}

	private void writeIfcPropertiesProduct(JsonWriter jsonWriter, IfcProduct object) throws IOException {
		writeIfcPropertiesObject(jsonWriter, object);
		if (object.isSetObjectPlacement()) {
			object.getObjectPlacement().getPlacesObject();
		}
		if (object.isSetRepresentation()) {
			object.getRepresentation();
		}
		if (object.getReferencedBy() != null && !object.getReferencedBy().isEmpty()) {
			jsonWriter.name("Referenced By");
			jsonWriter.beginArray();
			for (IfcRelAssignsToProduct rel : object.getReferencedBy()) {
				writeLink(jsonWriter, rel);
				//TODO
			}
			jsonWriter.endArray();
		}
	}
	
	private void writeIfcPropertiesObject(JsonWriter jsonWriter, IfcObject object) throws IOException {
		writeIfcPropertiesObjectDefinition(jsonWriter, object);
		if (object.isSetObjectType()) {
			object.getObjectType();
		}
		if (object.getIsDefinedBy() != null && !object.getIsDefinedBy().isEmpty()) {
			jsonWriter.name("Is Defined By");
			jsonWriter.beginArray();
			for (IfcRelDefines rel : object.getIsDefinedBy()) {
				writeLink(jsonWriter, rel);
				//TODO
			}
			jsonWriter.endArray();
		}
	}

	private void writeIfcPropertiesObjectDefinition(JsonWriter jsonWriter, IfcObjectDefinition object) throws IOException {
		writeIfcPropertiesRoot(jsonWriter, object);

		if (object.getHasAssignments() != null && !object.getHasAssignments().isEmpty()) {
			jsonWriter.name("Is Defined By");
			jsonWriter.beginArray(); 
			for (IfcRelAssigns rel : object.getHasAssignments()) {
				writeLink(jsonWriter, rel);
				//TODO
			}
			jsonWriter.endArray();
		}
		if (object.getIsDecomposedBy() != null && !object.getIsDecomposedBy().isEmpty()) {
			jsonWriter.name("Is Defined By");
			jsonWriter.beginArray(); 
			for (IfcRelDecomposes rel : object.getIsDecomposedBy()) {
				writeLink(jsonWriter, rel);
				//TODO
			}
			jsonWriter.endArray();
		}
		if (object.getDecomposes() != null && !object.getDecomposes().isEmpty()) {
			jsonWriter.name("Is Defined By");
			jsonWriter.beginArray();
			for (IfcRelDecomposes rel : object.getDecomposes()) {
				writeLink(jsonWriter, rel);
				//TODO
			}
			jsonWriter.endArray();
		}
		if (object.getHasAssociations() != null && !object.getHasAssociations().isEmpty()) {
			jsonWriter.name("Has Associations");
			jsonWriter.beginArray();
			for (IfcRelAssociates rel : object.getHasAssociations()) {
				writeLink(jsonWriter, rel);
				//TODO
			}
			jsonWriter.endArray();
		}
	}

	private void writeIfcPropertiesRoot(JsonWriter jsonWriter, IfcRoot object) throws IOException {
		/* NOT NEEDED:
		if (object.getGlobalId() != null) {			
			jsonObj.put("Global Id", object.getGlobalId().getWrappedValue());
		}//*/
		if (object.getOwnerHistory() != null) {
			IfcOwnerHistory history = object.getOwnerHistory();
			jsonWriter.name("Owner History").beginObject();
			jsonWriter.name("Owning User");
			writeOwningUser(jsonWriter, history.getOwningUser());
			jsonWriter.name("Owning Application");
			writeApplication(jsonWriter, history.getOwningApplication());
			jsonWriter.name("State").value(history.getState().getName());
			jsonWriter.name("Change Action").value(history.getChangeAction().getName());
			jsonWriter.name("Creation Date").value(history.getCreationDate());

			if (history.isSetLastModifiedDate()) {
				jsonWriter.name("Last Modified Date").value(history.getLastModifiedDate()); // TODO: Format as date?
			}
			
			if (history.isSetLastModifyingUser()) {
				// TODO IfcPersonAndOrganization getLastModifyingUser();
			}
			
			if (history.isSetLastModifyingApplication()) {
				// TODO IfcApplication getLastModifyingApplication();
			}
			jsonWriter.endObject();
		}
		if (object.isSetName()) {
			jsonWriter.name("Name").value(object.getName());
		}
		if (object.getDescription() != null) {
			jsonWriter.name("Description").value(object.getDescription());
		}
	}
	
	private void writeOwningUser(JsonWriter jsonWriter, IfcPersonAndOrganization owningUser) throws IOException {
		jsonWriter.beginObject();
		jsonWriter.name("The Person");
		writePerson(jsonWriter, owningUser.getThePerson());
		jsonWriter.name("The Organization");
		writeOrganization(jsonWriter, owningUser.getTheOrganization());
		if (owningUser.isSetRoles()) {
			jsonWriter.name("Roles");
			writeActorRoles(jsonWriter, owningUser.getRoles());
		}
		jsonWriter.endObject();
	}

	private void writePerson(JsonWriter jsonWriter, IfcPerson person) throws IOException {
		jsonWriter.beginObject().endObject();
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
	}
	
	private void writeOrganization(JsonWriter jsonWriter, IfcOrganization organization) throws IOException {
		// TODO
		jsonWriter.beginObject().endObject();
	}
	
	private void writeActorRoles(JsonWriter jsonWriter, EList<IfcActorRole> actorRoles) throws IOException {
		// TODO
		jsonWriter.beginObject().endObject();
	}
	
	private void writeApplication(JsonWriter jsonWriter, IfcApplication application) throws IOException {
		jsonWriter.beginObject().endObject();
		/* TODO
		IfcOrganization getApplicationDeveloper();
		void setApplicationDeveloper(IfcOrganization value);
		String getVersion();
		void setVersion(String value);
		String getApplicationFullName();
		String getApplicationIdentifier(); //*/
	}

	private void writeIfcTypes(JsonWriter out) throws IOException {
		out.beginArray();
		for (String ifcObjectType : typeMaterialGeometryRel.keySet()) {
			out.value(ifcObjectType);
		}
		out.endArray();
	}
	
	private void writeLink(JsonWriter jsonWriter, IfcRoot root) throws IOException {
		// TODO: Might return a JSONObject later (with link name & global id)
		jsonWriter.beginObject();
		jsonWriter.name("link").value(root.getGlobalId().getWrappedValue());
		jsonWriter.endObject();
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

	private String stripClassName(Class<?> classObject) {
		String name = classObject.getName();
		int ifcIndex = name.lastIndexOf("Ifc");
		int implIndex = name.lastIndexOf("Impl");
		return name.substring(Math.max(name.lastIndexOf('.', ifcIndex < 0? 0 : ifcIndex)+1, ifcIndex < 0? 0 : ifcIndex+3), implIndex < 0? name.length() : implIndex);
	}
	
	private String addressToString(IfcPostalAddress address) {
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

	private SIPrefix getLengthUnitPrefix(IfcModelInterface model) {
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