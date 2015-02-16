package org.bimserver.geometry.jsonshell;

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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.IfcActorRole;
import org.bimserver.models.ifc2x3tc1.IfcApplication;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcColourOrFactor;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayer;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3tc1.IfcPostalAddress;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcProject;
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
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.AbstractGeometrySerializer;
import org.bimserver.plugins.serializers.Extends;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.gson.stream.JsonWriter;

public class SceneJsShellSerializer extends AbstractGeometrySerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(SceneJsShellSerializer.class);
	private final HashMap<String, HashMap<String, HashSet<Long>>> typeMaterialGeometryRel = new HashMap<String, HashMap<String, HashSet<Long>>>();
	private final List<Long> surfaceStyleIds = new ArrayList<Long>();

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin, PackageMetaData packageMetaData, boolean normalizeOids)
			throws SerializerException {
		super.init(model, projectInfo, pluginManager, renderEnginePlugin, packageMetaData, normalizeOids);
	}

	@Override
	public void reset() {
		surfaceStyleIds.clear();
		typeMaterialGeometryRel.clear();
		setMode(Mode.BODY);
	}

	@Override
	public boolean write(OutputStream out, ProgressReporter progressReporter) throws SerializerException {
		try {
			if (getMode() == Mode.BODY) {
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, Charsets.UTF_8);
				try {
					calculateGeometryExtents();
					JsonWriter jsonWriter = new JsonWriter(new BufferedWriter(outputStreamWriter));

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
					jsonWriter.name("bounds2");
					writeBounds2(jsonWriter);
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
				return true;
			} else if (getMode() == Mode.FINISHED) {
				return false;
			}
		} catch (Throwable e) {
			throw new SerializerException(e);
		}
		return false;
	}

	private void writeMaterials(JsonWriter jsonWriter) throws IOException {
		writeMaterial(jsonWriter, "IfcSpace", new double[] { 0.137255f, 0.403922f, 0.870588f }, 1.0f);
		writeMaterial(jsonWriter, "IfcRoof", new double[] { 0.837255f, 0.203922f, 0.270588f }, 1.0f);
		writeMaterial(jsonWriter, "IfcSlab", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeMaterial(jsonWriter, "IfcWall", new double[] { 0.537255f, 0.337255f, 0.237255f }, 1.0f);
		writeMaterial(jsonWriter, "IfcWallStandardCase", new double[] { 1.0f, 1.0f, 1.0f }, 1.0f);
		writeMaterial(jsonWriter, "IfcDoor", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeMaterial(jsonWriter, "IfcWindow", new double[] { 0.2f, 0.2f, 0.8f }, 0.2f);
		writeMaterial(jsonWriter, "IfcRailing", new double[] { 0.137255f, 0.203922f, 0.270588f }, 1.0f);
		writeMaterial(jsonWriter, "IfcColumn", new double[] { 0.437255f, 0.603922f, 0.370588f, }, 1.0f);
		writeMaterial(jsonWriter, "IfcBeam", new double[] { 0.437255f, 0.603922f, 0.370588f, }, 1.0f);
		writeMaterial(jsonWriter, "IfcFurnishingElement", new double[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f);
		writeMaterial(jsonWriter, "IfcCurtainWall", new double[] { 0.5f, 0.5f, 0.5f }, 0.5f);
		writeMaterial(jsonWriter, "IfcStair", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeMaterial(jsonWriter, "IfcBuildingElementProxy", new double[] { 0.5f, 0.5f, 0.5f }, 1.0f);
		writeMaterial(jsonWriter, "IfcFlowSegment", new double[] { 0.8470588235f, 0.427450980392f, 0f }, 1.0f);
		writeMaterial(jsonWriter, "IfcFlowFitting", new double[] { 0.8470588235f, 0.427450980392f, 0f }, 1.0f);
		writeMaterial(jsonWriter, "IfcFlowTerminal", new double[] { 0.8470588235f, 0.427450980392f, 0f }, 1.0f);
		writeMaterial(jsonWriter, "IfcProxy", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeMaterial(jsonWriter, "IfcSite", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeMaterial(jsonWriter, "IfcLightFixture", new double[] {0.8470588235f, 0.8470588235f, 0f }, 1.0f);
		writeMaterial(jsonWriter, "IfcDuctSegment", new double[] {0.8470588235f, 0.427450980392f, 0f }, 1.0f);
		writeMaterial(jsonWriter, "IfcDuctFitting", new double[] {0.8470588235f, 0.427450980392f, 0f }, 1.0f);
		writeMaterial(jsonWriter, "IfcAirTerminal", new double[] {0.8470588235f, 0.427450980392f, 0f }, 1.0f);

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
					if (!surfaceStyleIds.contains(ss.getOid())) {
						surfaceStyleIds.add(ss.getOid());
						double[] colors;
						if (colour != null) {
							colors = new double[] { colour.getRed(), colour.getGreen(), colour.getBlue() };
						} else {
							colors = new double[] { 0.5, 0.5, 0.5};
						}
						writeMaterial(jsonWriter, "" + ss.getOid(), colors, ssr.isSetTransparency()	&& ssr.getTransparency() < 1.0f ? 1.0f - ssr.getTransparency() : 1.0f);
						break;
					}
				}
			}
		}
	}

	private void writeMaterial(JsonWriter jsonWriter, String materialName, double[] colors, double opacity) throws IOException {
		jsonWriter.beginObject();
		jsonWriter.name("type").value("material");
		jsonWriter.name("coreId").value(materialName + "Material");
		jsonWriter.name("baseColor").beginObject().name("r").value(colors[0]).name("g").value(colors[1]).name("b").value(colors[2]).endObject();
		jsonWriter.name("alpha").value(opacity);
		jsonWriter.name("emit").value(0.0);
		jsonWriter.endObject();
	}

	private void writeVisualScenes(JsonWriter jsonWriter) throws IOException {
		Extends sceneExtends = getSceneExtends();
		// Calculate the maximum ray length through the scene (using the two
		// extreme points of the scene's bounding box)
		float[] extentsDiff = new float[] { sceneExtends.max[0] - sceneExtends.min[0], sceneExtends.max[1] - sceneExtends.min[1], sceneExtends.max[2] - sceneExtends.min[2] };
		if (Float.isInfinite(extentsDiff[0]))
			extentsDiff[0] = 50.0f;
		if (Float.isInfinite(extentsDiff[1]))
			extentsDiff[1] = 50.0f;
		if (Float.isInfinite(extentsDiff[2]))
			extentsDiff[2] = 50.0f;
		float extentsDiffLength = (float) Math.sqrt((double) (extentsDiff[0] * extentsDiff[0] + extentsDiff[1] * extentsDiff[1] + extentsDiff[2] * extentsDiff[2]));

		// Write the nodes to the stream
		jsonWriter.beginObject().name("type").value("lookAt").name("id").value("main-lookAt").name("eye").beginObject().name("x").value(extentsDiff[0] * 1.5f).name("y")
				.value(extentsDiff[1] * 1.5f).name("z").value(extentsDiff[2] * 1.5f).endObject().name("look").beginObject().name("x").value(0.0).name("y").value(0.0).name("z")
				.value(0.0).endObject().name("up").beginObject().name("x").value(0.0).name("y").value(0.0).name("z").value(1.0).endObject().name("nodes").beginArray()
				.beginObject().name("type").value("camera").name("id").value("main-camera").name("optics").beginObject().name("type").value("perspective").name("far")
				.value(extentsDiffLength * 6).name("near").value(extentsDiffLength * 0.001f).name("aspect").value(1.0).name("fovy").value(37.8493).endObject().name("nodes")
				.beginArray().beginObject().name("type").value("renderer").name("id").value("main-renderer").name("clear").beginObject().name("color").value(true).name("depth")
				.value(true).name("stencil").value(false).endObject().name("clearColor").beginObject().name("r").value(0.2).name("g").value(0.2).name("b").value(0.2).name("a")
				.value(0.2).endObject().name("nodes").beginArray().beginObject().name("type").value("light").name("id").value("sun-light").name("mode").value("dir").name("color")
				.beginObject().name("r").value(0.8).name("g").value(0.8).name("b").value(0.8).endObject().name("dir").beginObject().name("x").value(-0.5).name("y").value(-0.5)
				.name("z").value(-1.0).endObject().name("diffuse").value(true).name("specular").value(true).endObject().endArray().endObject().endArray().endObject().endArray()
				.endObject();
	}

	private void writeGeometricObject(JsonWriter jsonWriter, IfcProduct ifcProduct) throws RenderEngineException, SerializerException, IOException {
		boolean materialFound = false;
		String material = ifcProduct.eClass().getName();

		// If this product is composed of other objects, output each object
		// separately
		EList<IfcRelDecomposes> isDecomposedBy = ifcProduct.getIsDecomposedBy();
		if (isDecomposedBy != null && !isDecomposedBy.isEmpty()) {
			for (IfcRelDecomposes dcmp : isDecomposedBy) {
				EList<IfcObjectDefinition> relatedObjects = dcmp.getRelatedObjects();
				for (IfcObjectDefinition relatedObject : relatedObjects) {
					writeGeometricObject(jsonWriter, (IfcProduct) relatedObject);
				}
			}
			// return;
		}

		IfcMaterialSelect relatingMaterial = null;
		for (IfcRelAssociates ifcRelAssociates : ifcProduct.getHasAssociations()) {
			if (ifcRelAssociates instanceof IfcRelAssociatesMaterial) {
				IfcRelAssociatesMaterial ifcRelAssociatesMaterial = (IfcRelAssociatesMaterial) ifcRelAssociates;
				relatingMaterial = ifcRelAssociatesMaterial.getRelatingMaterial();
			}
		}

		// Try to find the IFC material name
		if (relatingMaterial instanceof IfcMaterialLayerSetUsage) {
			IfcMaterialLayerSetUsage mlsu = (IfcMaterialLayerSetUsage) relatingMaterial;
			IfcMaterialLayerSet forLayerSet = mlsu.getForLayerSet();
			if (forLayerSet != null) {
				EList<IfcMaterialLayer> materialLayers = forLayerSet.getMaterialLayers();
				for (IfcMaterialLayer ml : materialLayers) {
					IfcMaterial ifcMaterial = ml.getMaterial();
					if (ifcMaterial != null) {
						String name = ifcMaterial.getName();
						String filterSpaces = fitNameForQualifiedName(name);
//						materialFound = surfaceStyleIds.contains(filterSpaces);
//						if (materialFound) {
							material = filterSpaces;
//						}
					}
				}
			}
		} else if (relatingMaterial instanceof IfcMaterial) {
			IfcMaterial ifcMaterial = (IfcMaterial) relatingMaterial;
			String name = ifcMaterial.getName();
			String filterSpaces = fitNameForQualifiedName(name);
//			materialFound = surfaceStyleIds.contains(filterSpaces);
//			if (materialFound) {
				material = filterSpaces;
//			}
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

		HashMap<String, HashSet<Long>> materialGeometryRel = typeMaterialGeometryRel.get(ifcProduct.eClass().getName());
		if (materialGeometryRel == null) {
			materialGeometryRel = new HashMap<String, HashSet<Long>>();
			typeMaterialGeometryRel.put(ifcProduct.eClass().getName(), materialGeometryRel);
		}

		HashSet<Long> hashSet = materialGeometryRel.get(material);
		if (hashSet == null) {
			hashSet = new HashSet<Long>();
			materialGeometryRel.put(material, hashSet);
		}
		hashSet.add(ifcProduct.getOid());
	}

	private void writeGeometries(JsonWriter jsonWriter) throws RenderEngineException, SerializerException, IOException {
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			writeGeometricObject(jsonWriter, ifcProduct);
		}
	}

	private void writeBounds(JsonWriter jsonWriter) throws IOException {
		Extends sceneExtends = getSceneExtends();
		float[] bounds = { sceneExtends.max[0] - sceneExtends.min[0], sceneExtends.max[1] - sceneExtends.min[1], sceneExtends.max[2] - sceneExtends.min[2] };
		jsonWriter.beginArray();
		jsonWriter.value(Float.isInfinite(bounds[0]) ? 50.0f : bounds[0]);
		jsonWriter.value(Float.isInfinite(bounds[1]) ? 50.0f : bounds[1]);
		jsonWriter.value(Float.isInfinite(bounds[2]) ? 50.0f : bounds[2]);
		jsonWriter.endArray();
	}

	private void writeBounds2(JsonWriter jsonWriter) throws IOException {
		Extends sceneExtends = getSceneExtends();
		float[] bounds = { (sceneExtends.max[0] + sceneExtends.min[0]) * 0.5f, (sceneExtends.max[1] + sceneExtends.min[1]) * 0.5f,
				(sceneExtends.max[2] + sceneExtends.min[2]) * 0.5f };
		jsonWriter.beginArray();
		jsonWriter.value(Float.isInfinite(bounds[0]) || Float.isNaN(bounds[0]) ? 50.0f : bounds[0]);
		jsonWriter.value(Float.isInfinite(bounds[1]) || Float.isNaN(bounds[1]) ? 50.0f : bounds[1]);
		jsonWriter.value(Float.isInfinite(bounds[2]) || Float.isNaN(bounds[2]) ? 50.0f : bounds[2]);
		jsonWriter.endArray();
	}

	private void writeUnit(JsonWriter jsonWriter) throws IOException {
		SIPrefix lengthUnitPrefix = getLengthUnitPrefix(model);
		jsonWriter.value(lengthUnitPrefix == null ? "1 meter" : Math.pow(10.0, lengthUnitPrefix.getValue()) + " " + lengthUnitPrefix.name().toLowerCase());
	}

	private void writeIfcTreeRelatedObject(JsonWriter jsonWriter, HashSet<Long> visitedIds, IfcObject object) throws IOException {
		jsonWriter.beginObject();
		jsonWriter.name("type").value(object.isSetObjectType() ? object.getObjectType() : stripClassName(object.getClass()));
		jsonWriter.name("name").value(object.isSetName() ? object.getName() : "unknown");
		jsonWriter.name("id").value(object.getOid());
		jsonWriter.name("decomposedBy");
		writeIfcTreeDecomposedBy(jsonWriter, visitedIds, object);
		jsonWriter.name("definedBy");
		writeIfcTreeDefinedBy(jsonWriter, visitedIds, (IfcObject) object);

		if (object instanceof IfcSpatialStructureElement) {
			jsonWriter.name("contains");
			writeIfcTreeContainsElements(jsonWriter, visitedIds, (IfcSpatialStructureElement) object);
		}
		jsonWriter.endObject();
	}

	private void writeIfcTree(JsonWriter jsonWriter) throws IOException {
		jsonWriter.beginArray();
		HashSet<Long> visitedIds = new HashSet<Long>();

		// Output the object relationships
		Map<Long, IdEObject> objects = model.getObjects();
		for (IdEObject object : objects.values()) {
			if (object instanceof IfcProject) {
				writeIfcTreeRelatedObject(jsonWriter, visitedIds, (IfcProject) object);
			}
		}
		jsonWriter.endArray();
	}

	private void writeIfcTreeDecomposedBy(JsonWriter jsonWriter, HashSet<Long> visitedIds, IfcObjectDefinition objectDefinition) throws IOException {
		jsonWriter.beginArray();
		EList<IfcRelDecomposes> relList = objectDefinition.getIsDecomposedBy();
		if (relList != null && !relList.isEmpty()) {
			for (IfcRelDecomposes rel : relList) {
				EList<IfcObjectDefinition> relatedObjects = rel.getRelatedObjects();
				for (IfcObjectDefinition relatedObject : relatedObjects) {
					if (relatedObject instanceof IfcObject) {
						if (!visitedIds.contains(relatedObject.getOid())) {
							visitedIds.add(relatedObject.getOid());
							writeIfcTreeRelatedObject(jsonWriter, visitedIds, (IfcObject) relatedObject);
						}
					}
				}
			}
		}
		jsonWriter.endArray();
	}

	private void writeIfcTreeDefinedBy(JsonWriter jsonWriter, HashSet<Long> visitedIds, IfcObject object) throws IOException {
		jsonWriter.beginArray();
		EList<IfcRelDefines> relList = object.getIsDefinedBy();
		if (relList != null && !relList.isEmpty()) {
			for (IfcRelDefines rel : relList) {
				if (rel instanceof IfcRelContainedInSpatialStructure) {
					EList<IfcObject> relatedObjects = rel.getRelatedObjects();
					for (IfcObject relatedObject : relatedObjects) {
						if (!visitedIds.contains(relatedObject.getOid())) {
							if (relatedObject instanceof IfcObject) {
								visitedIds.add(relatedObject.getOid());
								writeIfcTreeRelatedObject(jsonWriter, visitedIds, relatedObject);
							}
						}
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
		jsonWriter.name("id").value(object.getOid());
		jsonWriter.endObject();
		// writeIfcTreeDecomposedBy(object);
		// writeIfcTreeDefinedBy((IfcObject) object);
		// if (object instanceof IfcSpatialStructureElement) {
		// writeIfcTreeContainsElements((IfcSpatialStructureElement) object);
		// }
	}

	private void writeIfcTreeContainsElements(JsonWriter jsonWriter, HashSet<Long> visitedIds, IfcSpatialStructureElement spatialStructureElement) throws IOException {
		jsonWriter.beginArray();
		EList<IfcRelContainedInSpatialStructure> relList = spatialStructureElement.getContainsElements();
		if (relList != null && !relList.isEmpty()) {
			for (IfcRelContainedInSpatialStructure rel : relList) {
				for (IfcProduct relatedObject : rel.getRelatedElements()) {
					if (!visitedIds.contains(relatedObject.getOid())) {
						visitedIds.add(relatedObject.getOid());
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
				jsonWriter.name("" + object.getOid());
				jsonWriter.beginObject();
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
		/*
		 * TODO: It doesn't look like there's currently any useful information
		 * to be written for units? if (object.getUnitsInContext() != null) {
		 * EList<IfcUnit> units = object.getUnitsInContext().getUnits(); if
		 * (units != null && !units.isEmpty()) { JSONArray jsonArray = new
		 * JSONArray(); jsonObj.put("Units in Context", jsonArray); for (IfcUnit
		 * unit : units) { jsonArray.put(unit.toString()); } } }//
		 */
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
				/*
				 * TODO new JSONObject() .put("Relating Opening Element",
				 * writeLink(rel.getRelatingOpeningElement()))
				 * .put("Related Building Element",
				 * writeLink(rel.getRelatedBuildingElement())));//
				 */
			}
			jsonWriter.endArray();
		}
		if (object.getConnectedTo() != null && !object.getConnectedTo().isEmpty()) {
			jsonWriter.name("Connected To");
			jsonWriter.beginArray();
			for (IfcRelConnectsElements rel : object.getConnectedTo()) {
				writeLink(jsonWriter, rel);
				/*
				 * TODO: JSONObject jsonConectedTo = new JSONObject();
				 * jsonArray.put(jsonConectedTo); /* TODO: Nothing to write for
				 * connection geometry...? if (rel.isSetConnectionGeometry()) {
				 * jsonConectedTo.put("Connection Geometry",
				 * writeConnectionGeometry(rel.getConnectionGeometry())); }//
				 */
				/*
				 * TODO: boolean isSetConnectionGeometry(); IfcElement
				 * getRelatingElement(); void setRelatingElement(IfcElement
				 * value); IfcElement getRelatedElement(); //
				 */
			}
			jsonWriter.endArray();
		}
		if (object.getHasCoverings() != null && !object.getHasCoverings().isEmpty()) {
			jsonWriter.name("Has Coverings");
			jsonWriter.beginArray();
			for (IfcRelCoversBldgElements rel : object.getHasCoverings()) {
				writeLink(jsonWriter, rel);
				/*
				 * TODO: getRelatingBuildingElement(); EList<IfcCovering>
				 * getRelatedCoverings(); //
				 */
			}
			jsonWriter.endArray();
		}
		if (object.getHasProjections() != null && !object.getHasProjections().isEmpty()) {
			jsonWriter.name("Has Projections");
			jsonWriter.beginArray();
			// for (IfcRelProjectsElement rel : object.getHasProjections()) {
			/*
			 * TODO: jsonArray.put(new JSONObject()); IfcElement
			 * getRelatingElement(); IfcFeatureElementAddition
			 * getRelatedFeatureElement();//
			 */
			// }
			jsonWriter.endArray();
		}
		if (object.getHasStructuralMember() != null && !object.getHasStructuralMember().isEmpty()) {
			jsonWriter.name("Has Structural Member"); // TODO: Shouldn't this be
														// "Has Structural Member(s)"?
			jsonWriter.beginArray();
			for (IfcRelConnectsStructuralElement rel : object.getHasStructuralMember()) {
				writeLink(jsonWriter, rel);
				/*
				 * TODO: IfcElement getRelatingElement(); IfcStructuralMember
				 * getRelatedStructuralMember(); //
				 */
			}
			jsonWriter.endArray();
		}
		if (object.getReferencedInStructures() != null && !object.getReferencedInStructures().isEmpty()) {
			jsonWriter.name("Referenced In Structures"); // TODO: Shouldn't this
															// be
															// "Has Structural Member(s)"?
			jsonWriter.beginArray();
			for (IfcRelReferencedInSpatialStructure rel : object.getReferencedInStructures()) {
				writeLink(jsonWriter, rel);
				/*
				 * TODO: EList<IfcProduct> getRelatedElements();
				 * IfcSpatialStructureElement getRelatingStructure();//
				 */
			}
			jsonWriter.endArray();
		}
		if (object.getHasPorts() != null && !object.getHasPorts().isEmpty()) {
			jsonWriter.name("Has Ports");
			jsonWriter.beginArray();
			for (IfcRelConnectsPortToElement rel : object.getHasPorts()) {
				writeLink(jsonWriter, rel);
				/*
				 * TODO: getRelatingPort(); IfcElement getRelatedElement();//
				 */
			}
			jsonWriter.endArray();
		}
		if (object.getHasOpenings() != null && !object.getHasOpenings().isEmpty()) {
			jsonWriter.name("Has Openings");
			jsonWriter.beginArray();
			for (IfcRelVoidsElement rel : object.getHasOpenings()) {
				writeLink(jsonWriter, rel);
				/*
				 * TODO: getRelatingBuildingElement();
				 * IfcFeatureElementSubtraction getRelatedOpeningElement(); //
				 */
			}
			jsonWriter.endArray();
		}
		if (object.getIsConnectionRealization() != null && !object.getIsConnectionRealization().isEmpty()) {
			jsonWriter.name("Is Connection Realization"); // TODO: Should this
															// rather be
															// something like
															// "Realizing Elements"?
			jsonWriter.beginArray();
			for (IfcRelConnectsWithRealizingElements rel : object.getIsConnectionRealization()) {
				writeLink(jsonWriter, rel);
				/*
				 * TODO: getRealizingElements(); String getConnectionType();
				 * void setConnectionType(String value); void
				 * unsetConnectionType(); boolean isSetConnectionType(); //
				 */
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
				// TODO
			}
			jsonWriter.endArray();
		}
		if (object.getContainedInStructure() != null && !object.getContainedInStructure().isEmpty()) {
			jsonWriter.name("Contained In Structure");
			jsonWriter.beginArray();
			for (IfcRelContainedInSpatialStructure rel : object.getContainedInStructure()) {
				writeLink(jsonWriter, rel);
				// TODO
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
				// TODO
			}
			jsonWriter.endArray();
		}
		if (object.getServicedBySystems() != null && !object.getServicedBySystems().isEmpty()) {
			jsonWriter.name("Serviced By Systems");
			jsonWriter.beginArray();
			for (IfcRelServicesBuildings rel : object.getServicedBySystems()) {
				writeLink(jsonWriter, rel);
				// TODO
			}
			jsonWriter.endArray();
		}
		if (object.getContainsElements() != null && !object.getContainsElements().isEmpty()) {
			jsonWriter.name("Contains Elements");
			jsonWriter.beginArray();
			for (IfcRelContainedInSpatialStructure rel : object.getContainsElements()) {
				writeLink(jsonWriter, rel);
				// TODO
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
				// TODO
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
				// TODO
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
				// TODO
			}
			jsonWriter.endArray();
		}
		if (object.getIsDecomposedBy() != null && !object.getIsDecomposedBy().isEmpty()) {
			jsonWriter.name("Is Defined By");
			jsonWriter.beginArray();
			for (IfcRelDecomposes rel : object.getIsDecomposedBy()) {
				writeLink(jsonWriter, rel);
				// TODO
			}
			jsonWriter.endArray();
		}
		if (object.getDecomposes() != null && !object.getDecomposes().isEmpty()) {
			jsonWriter.name("Is Defined By");
			jsonWriter.beginArray();
			for (IfcRelDecomposes rel : object.getDecomposes()) {
				writeLink(jsonWriter, rel);
				// TODO
			}
			jsonWriter.endArray();
		}
		if (object.getHasAssociations() != null && !object.getHasAssociations().isEmpty()) {
			jsonWriter.name("Has Associations");
			jsonWriter.beginArray();
			for (IfcRelAssociates rel : object.getHasAssociations()) {
				writeLink(jsonWriter, rel);
				// TODO
			}
			jsonWriter.endArray();
		}
	}

	private void writeIfcPropertiesRoot(JsonWriter jsonWriter, IfcRoot object) throws IOException {
		/*
		 * NOT NEEDED: if (object.getGlobalId() != null) {
		 * jsonObj.put("Global Id", object.getGlobalId().getWrappedValue()); }//
		 */
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
				jsonWriter.name("Last Modified Date").value(history.getLastModifiedDate()); // TODO:
																							// Format
																							// as
																							// date?
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
		/*
		 * TODO String getId(); boolean isSetId();
		 * 
		 * String getFamilyName(); void setFamilyName(String value); boolean
		 * isSetFamilyName();
		 * 
		 * String getGivenName(); void setGivenName(String value); boolean
		 * isSetGivenName();
		 * 
		 * EList<String> getMiddleNames(); boolean isSetMiddleNames();
		 * 
		 * EList<String> getPrefixTitles(); boolean isSetPrefixTitles();
		 * 
		 * EList<String> getSuffixTitles(); boolean isSetSuffixTitles();
		 * 
		 * EList<IfcActorRole> getRoles(); boolean isSetRoles();
		 * 
		 * EList<IfcAddress> getAddresses(); void unsetAddresses(); boolean
		 * isSetAddresses();
		 * 
		 * EList<IfcPersonAndOrganization> getEngagedIn();//
		 */
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
		/*
		 * TODO IfcOrganization getApplicationDeveloper(); void
		 * setApplicationDeveloper(IfcOrganization value); String getVersion();
		 * void setVersion(String value); String getApplicationFullName();
		 * String getApplicationIdentifier(); //
		 */
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
		jsonWriter.name("link").value(root.getOid());
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
		return name.substring(Math.max(name.lastIndexOf('.', ifcIndex < 0 ? 0 : ifcIndex) + 1, ifcIndex < 0 ? 0 : ifcIndex + 3), implIndex < 0 ? name.length() : implIndex);
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
		// * TODO: Are these perhaps captured by address lines?
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
		}// */
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