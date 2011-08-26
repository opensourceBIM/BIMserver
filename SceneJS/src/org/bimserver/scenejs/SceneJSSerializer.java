package org.bimserver.scenejs;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3.IfcBuildingElementProxy;
//import org.bimserver.models.ifc2x3.IfcColourOrFactor;
//import org.bimserver.models.ifc2x3.IfcColourRgb;
import org.bimserver.models.ifc2x3.IfcColumn;
import org.bimserver.models.ifc2x3.IfcCurtainWall;
import org.bimserver.models.ifc2x3.IfcDoor;
import org.bimserver.models.ifc2x3.IfcFlowSegment;
import org.bimserver.models.ifc2x3.IfcFurnishingElement;
import org.bimserver.models.ifc2x3.IfcMaterial;
import org.bimserver.models.ifc2x3.IfcMaterialLayer;
import org.bimserver.models.ifc2x3.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3.IfcMaterialSelect;
import org.bimserver.models.ifc2x3.IfcMember;
import org.bimserver.models.ifc2x3.IfcObjectDefinition;
import org.bimserver.models.ifc2x3.IfcPlate;
import org.bimserver.models.ifc2x3.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3.IfcProduct;
import org.bimserver.models.ifc2x3.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3.IfcProductRepresentation;
//import org.bimserver.models.ifc2x3.IfcProject;
import org.bimserver.models.ifc2x3.IfcRailing;
import org.bimserver.models.ifc2x3.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3.IfcRelDecomposes;
import org.bimserver.models.ifc2x3.IfcRepresentation;
import org.bimserver.models.ifc2x3.IfcRepresentationItem;
import org.bimserver.models.ifc2x3.IfcRoof;
//import org.bimserver.models.ifc2x3.IfcSIUnit;
import org.bimserver.models.ifc2x3.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3.IfcSlab;
import org.bimserver.models.ifc2x3.IfcSlabTypeEnum;
import org.bimserver.models.ifc2x3.IfcStair;
import org.bimserver.models.ifc2x3.IfcStairFlight;
import org.bimserver.models.ifc2x3.IfcStyledItem;
import org.bimserver.models.ifc2x3.IfcSurfaceStyle;
//import org.bimserver.models.ifc2x3.IfcSurfaceStyleElementSelect;
//import org.bimserver.models.ifc2x3.IfcSurfaceStyleRendering;
//import org.bimserver.models.ifc2x3.IfcUnit;
//import org.bimserver.models.ifc2x3.IfcUnitAssignment;
//import org.bimserver.models.ifc2x3.IfcUnitEnum;
import org.bimserver.models.ifc2x3.IfcWall;
import org.bimserver.models.ifc2x3.IfcWallStandardCase;
import org.bimserver.models.ifc2x3.IfcWindow;
//import org.bimserver.models.store.SIPrefix;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.serializers.BimModelSerializer;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SceneJSSerializer extends BimModelSerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(SceneJSSerializer.class);
	private IfcEngine ifcEngine;
	private Map<String, Set<String>> converted = new HashMap<String, Set<String>>();
	private List<String> surfaceStyleIds;
	
	/* JsWriter adds automatic indentation to the PrintWriter */ 
	private class JsWriter extends PrintWriter {
		private int indentation = 0;
		public JsWriter(OutputStream out) {
			super(out);
		}
		public void indent() {
			indentation += 1;
		}
		public void unindent() {
			indentation = Math.max(0, indentation - 1);
		}
		
		public void writeln(String s){
			for (int i = 0; i < indentation; ++i){
				super.print("  ");
			}
			super.println(s);
		}
		
		public void writetab(String s){
			for (int i = 0; i < indentation; ++i){
				super.print("  ");
			}
			super.print(s);
		}
	}

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException {
		super.init(model, projectInfo, pluginManager);
		this.surfaceStyleIds = new ArrayList<String>();
	}

	@Override
	protected void reset() {
		setMode(Mode.BODY);
	}

	@Override
	public boolean write(OutputStream out) throws SerializerException {
		if (getMode() == Mode.BODY) {
			try {
				ifcEngine = getPluginManager().requireIfcEngine().createIfcEngine();
			} catch (PluginException e) {
				throw new SerializerException(e);
			}
			JsWriter writer = new JsWriter(out);
			try {
				writeAssets(writer);

				writer.writeln("SceneJS.createScene({");
				writer.indent();
				writer.writeln("type: 'scene',");
				writer.writeln("id: 'Scene',");
				writer.writeln("canvasId: 'scenejsCanvas',");
				writer.writeln("loggingElementId: 'scenejsLog',");
				writer.writeln("flags:");
				writer.indent();
				writer.writeln("{");
				writer.writeln("backfaces: false,");
				writer.indent();
				writer.unindent();
				writer.writeln("},");
				writer.unindent();

				writer.writeln("nodes: [");
				writer.indent();

				writer.writeln("{");
				writer.indent();
				writer.writeln("type: 'library',");
				writer.writeln("nodes: [");
				writer.indent();
				writeMaterials(writer);
				writeGeometries(writer);
				writer.unindent();
				writer.writeln("],");

				writer.unindent();
				writer.writeln("},");

				writeCameras(writer);
				writeLights(writer);
				writeVisualScenes(writer);

				writer.unindent();
				writer.writeln("],");

				writer.unindent();
				writer.writeln("});");
				writer.flush();
			} catch (Exception e) {
				LOGGER.error("", e);
			}
			writer.flush();
			setMode(Mode.FINISHED);
			ifcEngine.close();
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	private void writeAssets(JsWriter writer) {
		writer.writeln("/* Author:      " + getProjectInfo().getAuthorName());
		writer.writeln("   Description: " + getProjectInfo().getDescription());
		writer.writeln("*/");

		/*if (lengthUnitPrefix == null) {
			writer.writeln("   Unit: 1 meter");
		} else {
			writer.writeln("   Unit: " + Math.pow(10.0, lengthUnitPrefix.getValue()) + " " + lengthUnitPrefix.name().toLowerCase());
		}*/
	}

	private void writeMaterials(JsWriter writer) {
		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'RoofMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'SpaceMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'SlabMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'WallMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'WindowMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'DoorMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'RailingMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'ColumnMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'FurnishingElementMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'CurtainWallMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'FurnishingElementMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'StairMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'FlowSegmentMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: 'BuildingElementProxyMaterial',");
		//todo: effect instance
		writer.unindent();
		writer.writeln("},");

		for (String surfaceStyleId : surfaceStyleIds) {
			writer.writeln("{");
			writer.indent();
			writer.writeln("type: 'material',");
			writer.writeln("coreId: '" + surfaceStyleId + "Material',");
			//todo: effect instance
			writer.unindent();
			writer.writeln("},");
		}
	}

	private void writeEffects(JsWriter writer) {
		/*out.writeln("	<library_effects>");
		writeEffect(out, "Space", new float[] { 0.137255f, 0.403922f, 0.870588f }, 1.0f);
		writeEffect(out, "Roof", new float[] { 0.837255f, 0.203922f, 0.270588f }, 1.0f);
		writeEffect(out, "Slab", new float[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeEffect(out, "Wall", new float[] { 0.537255f, 0.337255f, 0.237255f }, 1.0f);
		writeEffect(out, "Door", new float[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeEffect(out, "Window", new float[] { 0.2f, 0.2f, 0.8f }, 0.2f);
		writeEffect(out, "Railing", new float[] { 0.137255f, 0.203922f, 0.270588f }, 1.0f);
		writeEffect(out, "Column", new float[] { 0.437255f, 0.603922f, 0.370588f, }, 1.0f);
		writeEffect(out, "FurnishingElement", new float[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f);
		writeEffect(out, "CurtainWall", new float[] { 0.5f, 0.5f, 0.5f }, 0.5f);
		writeEffect(out, "Stair", new float[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeEffect(out, "BuildingElementProxy", new float[] { 0.5f, 0.5f, 0.5f }, 1.0f);
		writeEffect(out, "FlowSegment", new float[] { 0.6f, 0.4f, 0.5f }, 1.0f);
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
					surfaceStyleIds.add(name);

					writeEffect(out, name, new float[] { colour.getRed(), colour.getGreen(), colour.getBlue() }, (ssr.isSetTransparency() ? (ssr.getTransparency()) : 1.0f));
					break;
				}
			}
		}

		out.writeln("    </library_effects>");*/
	}

	private void writeEffect(JsWriter writer, String name, float[] colors, float transparency) {
		/*out.writeln("        <effect id=\"" + name + "-fx\">");
		out.writeln("            <profile_COMMON>");
		out.writeln("                <technique sid=\"common\">");
		out.writeln("                    <phong>");
		out.writeln("                        <emission>");
		out.writeln("                            <color>0 0 0 1</color>");
		out.writeln("                        </emission>");
		out.writeln("                        <ambient>");
		out.writeln("                            <color>0 0 0 1</color>");
		out.writeln("                        </ambient>");
		out.writeln("                        <diffuse>");
		out.writeln("                            <color>" + colors[0] + " " + colors[1] + " " + colors[2] + " " + transparency + "</color>");
		out.writeln("                        </diffuse>");
		out.writeln("                        <specular>");
		out.writeln("                            <color>0.5 0.5 0.5 1</color>");
		out.writeln("                        </specular>");
		out.writeln("                        <shininess>");
		out.writeln("                            <float>16</float>");
		out.writeln("                        </shininess>");
		out.writeln("                        <reflective>");
		out.writeln("                            <color>0 0 0 1</color>");
		out.writeln("                        </reflective>");
		out.writeln("                        <reflectivity>");
		out.writeln("                            <float>0.5</float>");
		out.writeln("                        </reflectivity>");
		out.writeln("                        <transparent>");
		out.writeln("                            <color>" + transparency + " " + transparency + " " + transparency + " " + 1 + "</color>");
		out.writeln("                        </transparent>");
		out.writeln("                        <transparency>");
		out.writeln("                            <float>" + transparency + "</float>");
		out.writeln("                        </transparency>");
		out.writeln("                        <index_of_refraction>");
		out.writeln("                            <float>0</float>");
		out.writeln("                        </index_of_refraction>");
		out.writeln("                    </phong>");
		out.writeln("                </technique>");
		out.writeln("            </profile_COMMON>");
		out.writeln("        </effect>");*/
	}

	private void writeGeometries(JsWriter writer) throws IfcEngineException, SerializerException {
		for (IfcRoof ifcRoof : model.getAll(IfcRoof.class)) {
			setGeometry(writer, ifcRoof, ifcRoof.getGlobalId().getWrappedValue(), "Roof");
		}
		for (IfcSlab ifcSlab : model.getAll(IfcSlab.class)) {
			if (ifcSlab.getPredefinedType() == IfcSlabTypeEnum.ROOF) {
				setGeometry(writer, ifcSlab, ifcSlab.getGlobalId().getWrappedValue(), "Roof");
			} else {
				setGeometry(writer, ifcSlab, ifcSlab.getGlobalId().getWrappedValue(), "Slab");
			}
		}
		for (IfcWindow ifcWindow : model.getAll(IfcWindow.class)) {
			setGeometry(writer, ifcWindow, ifcWindow.getGlobalId().getWrappedValue(), "Window");
		}
		for (IfcDoor ifcDoor : model.getAll(IfcDoor.class)) {
			setGeometry(writer, ifcDoor, ifcDoor.getGlobalId().getWrappedValue(), "Door");
		}
		for (IfcWall ifcWall : model.getAll(IfcWall.class)) {
			setGeometry(writer, ifcWall, ifcWall.getGlobalId().getWrappedValue(), "Wall");
		}
		for (IfcStair ifcStair : model.getAll(IfcStair.class)) {
			setGeometry(writer, ifcStair, ifcStair.getGlobalId().getWrappedValue(), "Stair");
		}
		for (IfcStairFlight ifcStairFlight : model.getAll(IfcStairFlight.class)) {
			setGeometry(writer, ifcStairFlight, ifcStairFlight.getGlobalId().getWrappedValue(), "StairFlight");
		}
		for (IfcFlowSegment ifcFlowSegment : model.getAll(IfcFlowSegment.class)) {
			setGeometry(writer, ifcFlowSegment, ifcFlowSegment.getGlobalId().getWrappedValue(), "FlowSegment");
		}
		for (IfcFurnishingElement ifcFurnishingElement : model.getAll(IfcFurnishingElement.class)) {
			setGeometry(writer, ifcFurnishingElement, ifcFurnishingElement.getGlobalId().getWrappedValue(), "FurnishingElement");
		}
		for (IfcPlate ifcPlate : model.getAll(IfcPlate.class)) {
			setGeometry(writer, ifcPlate, ifcPlate.getGlobalId().getWrappedValue(), "Plate");
		}
		for (IfcMember ifcMember : model.getAll(IfcMember.class)) {
			setGeometry(writer, ifcMember, ifcMember.getGlobalId().getWrappedValue(), "Member");
		}
		for (IfcWallStandardCase ifcWall : model.getAll(IfcWallStandardCase.class)) {
			setGeometry(writer, ifcWall, ifcWall.getGlobalId().getWrappedValue(), "WallStandardCase");
		}
		for (IfcCurtainWall ifcCurtainWall : model.getAll(IfcCurtainWall.class)) {
			setGeometry(writer, ifcCurtainWall, ifcCurtainWall.getGlobalId().getWrappedValue(), "CurtainWall");
		}
		for (IfcRailing ifcRailing : model.getAll(IfcRailing.class)) {
			setGeometry(writer, ifcRailing, ifcRailing.getGlobalId().getWrappedValue(), "Railing");
		}
		for (IfcColumn ifcColumn : model.getAll(IfcColumn.class)) {
			setGeometry(writer, ifcColumn, ifcColumn.getGlobalId().getWrappedValue(), "Column");
		}
		for (IfcBuildingElementProxy ifcBuildingElementProxy : model.getAll(IfcBuildingElementProxy.class)) {
			setGeometry(writer, ifcBuildingElementProxy, ifcBuildingElementProxy.getGlobalId().getWrappedValue(), "BuildingElementProxy");
		}
	}

	private void setGeometry(JsWriter writer, IdEObject ifcRootObject, String id, String material) throws IfcEngineException, SerializerException {
		id = id.replace('$', '-'); // Remove the $ character from geometry id's.
		//id = "_" + id; // Ensure that the id does not start with a digit

		boolean materialFound = false;
		if (ifcRootObject instanceof IfcProduct) {
			IfcProduct ifcProduct = (IfcProduct) ifcRootObject;

			// If this product is composed of other objects, output each object separately
			EList<IfcRelDecomposes> isDecomposedBy = ifcProduct.getIsDecomposedBy();
			for (IfcRelDecomposes dcmp : isDecomposedBy) {
				EList<IfcObjectDefinition> relatedObjects = dcmp.getRelatedObjects();
				for (IfcObjectDefinition relatedObject : relatedObjects) {
					setGeometry(writer, relatedObject, relatedObject.getGlobalId().getWrappedValue(), material);
				}
			}
			if (isDecomposedBy != null && isDecomposedBy.size() > 0) {
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

		// Add the object id to the related material in the hash map 
		if (!converted.containsKey(material)) {
			converted.put(material, new HashSet<String>());
		}
		converted.get(material).add(id);
		
		// Serialize the geometric data itself
		IfcModelInterface ifcModel = new IfcModel();
		convertToSubset(ifcRootObject.eClass(), ifcRootObject, ifcModel, new HashMap<EObject, EObject>());
		EmfSerializer serializer = getPluginManager().requireIfcStepSerializer();
		serializer.init(ifcModel, getProjectInfo(), getPluginManager());
		try {
			IfcEngineModel model = ifcEngine.openModel(serializer.getBytes());
			try {
				model.setPostProcessing(true);
				IfcEngineGeometry geometry = model.finalizeModelling(model.initializeModelling());
				if (geometry != null) {

					writer.writeln("{");
					writer.indent();
					writer.writeln("type: 'geometry',");
					writer.writeln("coreId: '" + id + "',");
					writer.writeln("primitive: 'triangles',");
					writer.writetab("positions: [");
					for (int i = 0; i < geometry.getNrVertices(); i += 1) {
						writer.print(geometry.getVertex(i) + ",");
					}
					writer.println("],");
					writer.writetab("normals: [");
					for (int i = 0; i < geometry.getNrNormals(); i++) {
						// Normals will also be scaled in Google Earth ...
						//writer.print(geometry.getNormal(i) * 1000.0f + " ");
						writer.print(geometry.getNormal(i) + ",");
					}
					writer.println("],");

					// TODO: Create subgeometries if there are multiple index buffers
					List<? extends IfcEngineInstance> instances = model.getInstances(ifcRootObject.eClass().getName().toUpperCase());
					if (instances.size() > 1)
						writer.writeln("// TODO: Create subgeometries");
					for (IfcEngineInstance instance : instances) {
						IfcEngineInstanceVisualisationProperties instanceInModelling = instance.getVisualisationProperties();
						//out.writeln("<triangles count=\"" + (instanceInModelling.getPrimitiveCount()) + "\" material=\"" + material + "SG\">");
						writer.writetab("indices: [");
						for (int i = instanceInModelling.getStartIndex(); i < instanceInModelling.getPrimitiveCount() * 3 + instanceInModelling.getStartIndex(); i += 3) {
							writer.print(geometry.getIndex(i) + ",");
							writer.print(geometry.getIndex(i + 2) + ",");
							writer.print(geometry.getIndex(i + 1) + ",");
						}
						writer.println("],");
					}

					writer.unindent();
					writer.writeln("},");
				}
			} finally {
				model.close();
			}
		} catch (IfcEngineException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	private void writeVisualScenes(JsWriter writer) {
		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'lookAt',");
		
		writer.writeln("eye: {");
		writer.indent();
		writer.writeln("x: -427.749,");
		writer.writeln("y: 333.855,");
		writer.writeln("z: 655.017,");
		writer.unindent();
		writer.writeln("},");
		
		writer.writeln("look: {");
		writer.indent();
		writer.writeln("x: 0.0,");
		writer.writeln("y: 0.0,");
		writer.writeln("z: 0.0,");
		writer.unindent();
		writer.writeln("},");
		
		writer.writeln("up: {");
		writer.indent();
		writer.writeln("x: 0.0,");
		writer.writeln("y: 1.0,");
		writer.writeln("z: 0.0,");
		writer.unindent();
		writer.writeln("},");
		
		writer.writeln("nodes: [");
		writer.indent();
		writer.writeln("{");
		writer.indent();
		
		writer.writeln("type: 'camera',");
		writer.writeln("optics: {");
		writer.indent();
		writer.writeln("type: 'perspective',");
		writer.writeln("far: 1000.0,");
		writer.writeln("near: 10.0,");
		writer.writeln("aspect: 1.0,");
		writer.writeln("fovy: 27.6380627952,");
		//writer.writeln("fovy: 37.8493,");
        writer.unindent();
		writer.writeln("},");

		writer.writeln("nodes: [");
		writer.indent();
		writer.writeln("{");
		writer.indent();
		
		writer.writeln("type: 'renderer',");
		
		writer.writeln("clear: {");
		writer.indent();
		writer.writeln("color: true,"); 
		writer.writeln("depth: true,"); 
		writer.writeln("stencil: false,");
        writer.unindent();
		writer.writeln("},");
        
        writer.writeln("clearColor: {");
		writer.indent();
		writer.writeln("r: 0.0,"); 
		writer.writeln("g: 0.0,"); 
		writer.writeln("b: 0.0,");
		writer.writeln("a: 0.0,");
        writer.unindent();
		writer.writeln("},");
        
		writer.writeln("nodes: [");
		writer.indent();
		
		// Add a simple light to the scene 
		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'light',");
		
		writer.writeln("color: {");
		writer.indent();
		writer.writeln("r: 1.0,"); 
		writer.writeln("g: 1.0,"); 
		writer.writeln("b: 1.0,");
		writer.unindent();
        writer.writeln("},");
        
        writer.writeln("pos: {");
		writer.indent();
		writer.writeln("x: 0.0,"); 
		writer.writeln("y: 0.0,"); 
		writer.writeln("z: 0.0,");
        writer.unindent();
		writer.writeln("},");
        
        writer.writeln("mode: 'point',");
        writer.writeln("constantAttenuation: 1.0,");
        writer.writeln("linearAttenuation: 0.0,");
        writer.writeln("quadraticAttenuation: 0.000555556,");        
        writer.unindent();
		writer.writeln("},"); // light
	
		// Output each geometry instance grouped by material
		for (String materialId : converted.keySet()) {
			writer.writeln("{");
			writer.indent();
			
			writer.writeln("type: 'material',");
			writer.writeln("coreId: '" + materialId + "Material',");
			
			Set<String> geometryIds = converted.get(materialId);
			
			writer.writeln("nodes: [");
			writer.indent();
			for (String geometryId : geometryIds) {
				writer.writeln("{");
				writer.indent();
				
				writer.writeln("type: 'geometry',");
				writer.writeln("coreId: '" + geometryId + "',");
				/*writer.writeln("            <node id=\"" + id + "-node\" name=\"" + id + "-node\">");
				writer.writeln("                <rotate sid=\"rotateX\">1 0 0 90</rotate>");
				writer.writeln("                <rotate sid=\"rotateY\">0 1 0 180</rotate>");
				writer.writeln("                <rotate sid=\"rotateZ\">0 0 1 90</rotate>");
				writer.writeln("                <instance_geometry url=\"#" + id + "\">");
				writer.writeln("                    <bind_material>");
				writer.writeln("                        <technique_common>");
				writer.writeln("                            <instance_material symbol=\"" + material + "SG\" target=\"#" + material + "Material\"/>");
				writer.writeln("                        </technique_common>");
				writer.writeln("                    </bind_material>");
				writer.writeln("                </instance_geometry>");
				writer.writeln("            </node>");*/
				writer.unindent();
				writer.writeln("},"); // geometry
			}
			writer.unindent();
			writer.writeln("],");
			
			writer.unindent();
			writer.writeln("},"); // material
		}
		
		writer.unindent();
		writer.writeln("],");
		
		writer.unindent();
		writer.writeln("},"); // renderer
		writer.unindent();
		writer.writeln("],");
		
		writer.unindent();
		writer.writeln("},"); // camera
		writer.unindent();
		writer.writeln("],");
		
		writer.unindent();
		writer.writeln("},"); // lookAt
		/*
		out.writeln("    <library_visual_scenes>");
		out.writeln("        <visual_scene id=\"VisualSceneNode\" name=\"VisualSceneNode\">");
		out.writeln("            <node id=\"Camera\" name=\"Camera\">");
		out.writeln("                <translate sid=\"translate\">-427.749 333.855 655.017</translate>");
		out.writeln("                <rotate sid=\"rotateX\">1 0 0 -22.1954</rotate>");
		out.writeln("                <rotate sid=\"rotateY\">0 1 0 -33</rotate>");
		out.writeln("                <rotate sid=\"rotateZ\">0 0 1 0</rotate>");
		out.writeln("                <instance_camera url=\"#PerspCamera\"/>");
		out.writeln("            </node>");
		out.writeln("            <node id=\"Light\" name=\"Light\">");
		out.writeln("                <translate sid=\"translate\">-500 1000 400</translate>");
		out.writeln("                <rotate sid=\"rotateX\">1 0 0 0</rotate>");
		out.writeln("                <rotate sid=\"rotateY\">0 1 0 0</rotate>");
		out.writeln("                <rotate sid=\"rotateZ\">0 0 1 0</rotate>");
		out.writeln("                <instance_light url=\"#light-lib\"/>");
		out.writeln("            </node>");
		for (String material : converted.keySet()) {
			Set<String> ids = converted.get(material);
			for (String id : ids) {
				out.writeln("            <node id=\"" + id + "-node\" name=\"" + id + "-node\">");
				out.writeln("                <rotate sid=\"rotateX\">1 0 0 90</rotate>");
				out.writeln("                <rotate sid=\"rotateY\">0 1 0 180</rotate>");
				out.writeln("                <rotate sid=\"rotateZ\">0 0 1 90</rotate>");
				out.writeln("                <instance_geometry url=\"#" + id + "\">");
				out.writeln("                    <bind_material>");
				out.writeln("                        <technique_common>");
				out.writeln("                            <instance_material symbol=\"" + material + "SG\" target=\"#" + material + "Material\"/>");
				out.writeln("                        </technique_common>");
				out.writeln("                    </bind_material>");
				out.writeln("                </instance_geometry>");
				out.writeln("            </node>");
			}
		}
		out.writeln("            <node id=\"testCamera\" name=\"testCamera\">");
		out.writeln("                <translate sid=\"translate\">-427.749 333.855 655.017</translate>");
		out.writeln("                <rotate sid=\"rotateY\">0 1 0 -33</rotate>");
		out.writeln("                <rotate sid=\"rotateX\">1 0 0 -22.1954</rotate>");
		out.writeln("                <rotate sid=\"rotateZ\">0 0 1 0</rotate>");
		out.writeln("                <instance_camera url=\"#testCameraShape\"/>");
		out.writeln("            </node>");
		out.writeln("            <node id=\"pointLight1\" name=\"pointLight1\">");
		out.writeln("                <translate sid=\"translate\">3 4 10</translate>");
		out.writeln("                <rotate sid=\"rotateZ\">0 0 1 0</rotate>");
		out.writeln("                <rotate sid=\"rotateY\">0 1 0 0</rotate>");
		out.writeln("                <rotate sid=\"rotateX\">1 0 0 0</rotate>");
		out.writeln("                <instance_light url=\"#pointLightShape1-lib\"/>");
		out.writeln("            </node>");
		out.writeln("        </visual_scene>");
		out.writeln("    </library_visual_scenes>");*/
	}

	private void writeLights(JsWriter writer) {
		/*
		out.writeln("    <library_lights>");
		out.writeln("        <light id=\"light-lib\" name=\"light\">");
		out.writeln("            <technique_common>");
		out.writeln("                <point>");
		out.writeln("                    <color>1 1 1</color>");
		out.writeln("                    <constant_attenuation>1</constant_attenuation>");
		out.writeln("                    <linear_attenuation>0</linear_attenuation>");
		out.writeln("                    <quadratic_attenuation>0</quadratic_attenuation>");
		out.writeln("                </point>");
		out.writeln("            </technique_common>");
		out.writeln("            <technique profile=\"MAX3D\">");
		out.writeln("                <intensity>1.000000</intensity>");
		out.writeln("            </technique>");
		out.writeln("        </light>");
		out.writeln("        <light id=\"pointLightShape1-lib\" name=\"pointLightShape1\">");
		out.writeln("            <technique_common>");
		out.writeln("                <point>");
		out.writeln("                    <color>1 1 1</color>");
		out.writeln("                    <constant_attenuation>1</constant_attenuation>");
		out.writeln("                    <linear_attenuation>0</linear_attenuation>");
		out.writeln("                    <quadratic_attenuation>0</quadratic_attenuation>");
		out.writeln("                </point>");
		out.writeln("            </technique_common>");
		out.writeln("        </light>");
		out.writeln("    </library_lights>");*/
	}

	private void writeCameras(JsWriter writer) {
		/*
		out.writeln("    <library_cameras>");
		out.writeln("        <camera id=\"PerspCamera\" name=\"PerspCamera\">");
		out.writeln("            <optics>");
		out.writeln("                <technique_common>");
		out.writeln("                    <perspective>");
		out.writeln("                        <yfov>37.8493</yfov>");
		out.writeln("                        <aspect_ratio>1</aspect_ratio>");
		out.writeln("                        <znear>10</znear>");
		out.writeln("                        <zfar>1000</zfar>");
		out.writeln("                    </perspective>");
		out.writeln("                </technique_common>");
		out.writeln("            </optics>");
		out.writeln("        </camera>");
		out.writeln("        <camera id=\"testCameraShape\" name=\"testCameraShape\">");
		out.writeln("            <optics>");
		out.writeln("                <technique_common>");
		out.writeln("                    <perspective>");
		out.writeln("                        <yfov>37.8501</yfov>");
		out.writeln("                        <aspect_ratio>1</aspect_ratio>");
		out.writeln("                        <znear>0.01</znear>");
		out.writeln("                        <zfar>1000</zfar>");
		out.writeln("                    </perspective>");
		out.writeln("                </technique_common>");
		out.writeln("            </optics>");
		out.writeln("        </camera>");
		out.writeln("    </library_cameras>");*/
	}
	
	private String fitNameForQualifiedName(String name) {
		if (name == null) {
			return "";
		}
		StringBuilder builder = new StringBuilder(name);
		int indexOfSpace = builder.indexOf(" ");
		while (indexOfSpace >= 0) {
			builder.deleteCharAt(indexOfSpace);
			indexOfSpace = builder.indexOf(" ");
		}
		indexOfSpace = builder.indexOf(",");
		while (indexOfSpace >= 0) {
			builder.setCharAt(indexOfSpace, '_');
			indexOfSpace = builder.indexOf(",");
		}
		indexOfSpace = builder.indexOf("/");
		while (indexOfSpace >= 0) {
			builder.setCharAt(indexOfSpace, '_');
			indexOfSpace = builder.indexOf("/");
		}
		indexOfSpace = builder.indexOf("*");
		while (indexOfSpace >= 0) {
			builder.setCharAt(indexOfSpace, '_');
			indexOfSpace = builder.indexOf("/");
		}
		return builder.toString();
	}
}
