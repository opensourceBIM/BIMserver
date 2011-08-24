package org.bimserver.scenejs;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
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
//import org.bimserver.models.ifc2x3.IfcMaterial;
//import org.bimserver.models.ifc2x3.IfcMaterialLayer;
//import org.bimserver.models.ifc2x3.IfcMaterialLayerSet;
//import org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage;
//import org.bimserver.models.ifc2x3.IfcMaterialSelect;
import org.bimserver.models.ifc2x3.IfcMember;
//import org.bimserver.models.ifc2x3.IfcObjectDefinition;
import org.bimserver.models.ifc2x3.IfcPlate;
//import org.bimserver.models.ifc2x3.IfcPresentationStyleAssignment;
//import org.bimserver.models.ifc2x3.IfcPresentationStyleSelect;
//import org.bimserver.models.ifc2x3.IfcProduct;
//import org.bimserver.models.ifc2x3.IfcProductDefinitionShape;
//import org.bimserver.models.ifc2x3.IfcProductRepresentation;
//import org.bimserver.models.ifc2x3.IfcProject;
import org.bimserver.models.ifc2x3.IfcRailing;
//import org.bimserver.models.ifc2x3.IfcRelAssociatesMaterial;
//import org.bimserver.models.ifc2x3.IfcRelDecomposes;
//import org.bimserver.models.ifc2x3.IfcRepresentation;
//import org.bimserver.models.ifc2x3.IfcRepresentationItem;
import org.bimserver.models.ifc2x3.IfcRoof;
//import org.bimserver.models.ifc2x3.IfcSIUnit;
//import org.bimserver.models.ifc2x3.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3.IfcSlab;
import org.bimserver.models.ifc2x3.IfcSlabTypeEnum;
import org.bimserver.models.ifc2x3.IfcStair;
import org.bimserver.models.ifc2x3.IfcStairFlight;
//import org.bimserver.models.ifc2x3.IfcStyledItem;
//import org.bimserver.models.ifc2x3.IfcSurfaceStyle;
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
//import org.bimserver.plugins.ifcengine.IfcEngineInstance;
//import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.serializers.BimModelSerializer;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
//import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SceneJSSerializer extends BimModelSerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(SceneJSSerializer.class);
	private IfcEngine ifcEngine;
	//private Map<String, Set<String>> converted = new HashMap<String, Set<String>>();
	private List<String> surfaceStyleIds;

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
			PrintWriter writer = new PrintWriter(out);
			try {
				writeAssets(writer);

				writer.println("SceneJS.createScene({");
				//writer.indent();
				writer.println("type: 'scene',");
				writer.println("id: 'Scene',");
				writer.println("canvasId: 'scenejsCanvas',");
				writer.println("loggingElementId: 'scenejsLog',");
				writer.println("flags:");
				//writer.indent();
				writer.println("{");
				//writer.indent();
				//writer.undent();
				writer.println("},");
				//writer.undent();

				writer.println("nodes: [");
				//writer.indent();

				writer.println("{");
				//writer.indent();
				writer.println("type: 'library',");
				writer.println("nodes: [");
				//writer.indent()
				writeMaterials(writer);
				writeGeometries(writer);
				//writer.undent();
				writer.println("],");

				//writer.undent();
				writer.println("},");

				writeCameras(writer);
				writeLights(writer);
				writeVisualScenes(writer);

				//writer.undent();
				writer.println("],");

				//writer.undent();
				writer.print("});");
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

	private void writeAssets(PrintWriter writer) {
		writer.println("/* Author:      " + getProjectInfo().getAuthorName());
		writer.println("   Description: " + getProjectInfo().getDescription());
		writer.println("*/");

		/*if (lengthUnitPrefix == null) {
			writer.println("   Unit: 1 meter");
		} else {
			writer.println("   Unit: " + Math.pow(10.0, lengthUnitPrefix.getValue()) + " " + lengthUnitPrefix.name().toLowerCase());
		}*/
	}

	private void writeMaterials(PrintWriter writer) {
		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'RoofMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'SpaceMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'SlabMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'WallMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'WindowMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'DoorMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'RailingMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'ColumnMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'FurnishingElementMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'CurtainWallMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'FurnishingElementMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'StairMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'FlowSegmentMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		writer.println("{");
		//writer.indent();
		writer.println("type: 'material'");
		writer.println("coreId: 'BuildingElementProxyMaterial'");
		//todo: effect instance
		//writer.undent();
		writer.println("},");

		for (String surfaceStyleId : surfaceStyleIds) {
			writer.println("{");
			//writer.indent();
			writer.println("type: 'material'");
			writer.println("coreId: '" + surfaceStyleId + "Material'");
			//todo: effect instance
			//writer.undent();
			writer.println("},");
		}
	}

	private void writeEffects(PrintWriter writer) {
		/*out.println("	<library_effects>");
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

		out.println("    </library_effects>");*/
	}

	private void writeEffect(PrintWriter writer, String name, float[] colors, float transparency) {
		/*out.println("        <effect id=\"" + name + "-fx\">");
		out.println("            <profile_COMMON>");
		out.println("                <technique sid=\"common\">");
		out.println("                    <phong>");
		out.println("                        <emission>");
		out.println("                            <color>0 0 0 1</color>");
		out.println("                        </emission>");
		out.println("                        <ambient>");
		out.println("                            <color>0 0 0 1</color>");
		out.println("                        </ambient>");
		out.println("                        <diffuse>");
		out.println("                            <color>" + colors[0] + " " + colors[1] + " " + colors[2] + " " + transparency + "</color>");
		out.println("                        </diffuse>");
		out.println("                        <specular>");
		out.println("                            <color>0.5 0.5 0.5 1</color>");
		out.println("                        </specular>");
		out.println("                        <shininess>");
		out.println("                            <float>16</float>");
		out.println("                        </shininess>");
		out.println("                        <reflective>");
		out.println("                            <color>0 0 0 1</color>");
		out.println("                        </reflective>");
		out.println("                        <reflectivity>");
		out.println("                            <float>0.5</float>");
		out.println("                        </reflectivity>");
		out.println("                        <transparent>");
		out.println("                            <color>" + transparency + " " + transparency + " " + transparency + " " + 1 + "</color>");
		out.println("                        </transparent>");
		out.println("                        <transparency>");
		out.println("                            <float>" + transparency + "</float>");
		out.println("                        </transparency>");
		out.println("                        <index_of_refraction>");
		out.println("                            <float>0</float>");
		out.println("                        </index_of_refraction>");
		out.println("                    </phong>");
		out.println("                </technique>");
		out.println("            </profile_COMMON>");
		out.println("        </effect>");*/
	}

	private void writeGeometries(PrintWriter writer) throws IfcEngineException, SerializerException {
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

	private void setGeometry(PrintWriter writer, IdEObject ifcRootObject, String id, String material) throws IfcEngineException, SerializerException {
		id = id.replace('$', '-'); // Remove the $ character from geometry id's.
		//id = "_" + id; // Ensure that the id does not start with a digit

		/*boolean materialFound = false;
		if (ifcRootObject instanceof IfcProduct) {
			IfcProduct ifcProduct = (IfcProduct) ifcRootObject;

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

		if (!converted.containsKey(material)) {
			converted.put(material, new HashSet<String>());
		}
		converted.get(material).add(id);*/

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

					writer.println("{");
					//writer.indent();
					writer.println("type: 'geometry',");
					writer.println("coreId: '" + id + "',");
					writer.println("resource: '" + id + "',");
					writer.println("primitive: 'triangles',");
					writer.print("positions: [");
					for (int i = 0; i < geometry.getNrVertices(); i += 1) {
						writer.print(geometry.getVertex(i) + ",");
					}
					writer.println("],");
					writer.print("normals: [");
					for (int i = 0; i < geometry.getNrNormals(); i++) {
						// Normals will also be scaled in Google Earth ...
						//out.print(geometry.getNormal(i) * 1000.0f + " ");
//						out.print(geometry.getNormal(i) + ",");
					}
					writer.println("],");

					// TODO: Create subgeometries if there are multiple index buffers
					/*for (IfcEngineInstance instance : model.getInstances(ifcRootObject.eClass().getName().toUpperCase())) {
						IfcEngineInstanceVisualisationProperties instanceInModelling = instance.getVisualisationProperties();
						out.println("<triangles count=\"" + (instanceInModelling.getPrimitiveCount()) + "\" material=\"" + material + "SG\">");
						out.println("<input offset=\"0\" semantic=\"VERTEX\" source=\"#" + id + "-vertices\"/>");
						out.print("<p>");
						for (int i = instanceInModelling.getStartIndex(); i < instanceInModelling.getPrimitiveCount() * 3 + instanceInModelling.getStartIndex(); i += 3) {
							out.print(geometry.getIndex(i) + " ");
							out.print(geometry.getIndex(i + 2) + " ");
							out.print(geometry.getIndex(i + 1) + " ");
						}
						out.println("</p>");
						out.println("</triangles>");
					}*/

					//writer.undent();
					writer.println("},");
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

	private void writeVisualScenes(PrintWriter writer) {
		/*
		out.println("    <library_visual_scenes>");
		out.println("        <visual_scene id=\"VisualSceneNode\" name=\"VisualSceneNode\">");
		out.println("            <node id=\"Camera\" name=\"Camera\">");
		out.println("                <translate sid=\"translate\">-427.749 333.855 655.017</translate>");
		out.println("                <rotate sid=\"rotateX\">1 0 0 -22.1954</rotate>");
		out.println("                <rotate sid=\"rotateY\">0 1 0 -33</rotate>");
		out.println("                <rotate sid=\"rotateZ\">0 0 1 0</rotate>");
		out.println("                <instance_camera url=\"#PerspCamera\"/>");
		out.println("            </node>");
		out.println("            <node id=\"Light\" name=\"Light\">");
		out.println("                <translate sid=\"translate\">-500 1000 400</translate>");
		out.println("                <rotate sid=\"rotateX\">1 0 0 0</rotate>");
		out.println("                <rotate sid=\"rotateY\">0 1 0 0</rotate>");
		out.println("                <rotate sid=\"rotateZ\">0 0 1 0</rotate>");
		out.println("                <instance_light url=\"#light-lib\"/>");
		out.println("            </node>");
		for (String material : converted.keySet()) {
			Set<String> ids = converted.get(material);
			for (String id : ids) {
				out.println("            <node id=\"" + id + "-node\" name=\"" + id + "-node\">");
				out.println("                <rotate sid=\"rotateX\">1 0 0 90</rotate>");
				out.println("                <rotate sid=\"rotateY\">0 1 0 180</rotate>");
				out.println("                <rotate sid=\"rotateZ\">0 0 1 90</rotate>");
				out.println("                <instance_geometry url=\"#" + id + "\">");
				out.println("                    <bind_material>");
				out.println("                        <technique_common>");
				out.println("                            <instance_material symbol=\"" + material + "SG\" target=\"#" + material + "Material\"/>");
				out.println("                        </technique_common>");
				out.println("                    </bind_material>");
				out.println("                </instance_geometry>");
				out.println("            </node>");
			}
		}
		out.println("            <node id=\"testCamera\" name=\"testCamera\">");
		out.println("                <translate sid=\"translate\">-427.749 333.855 655.017</translate>");
		out.println("                <rotate sid=\"rotateY\">0 1 0 -33</rotate>");
		out.println("                <rotate sid=\"rotateX\">1 0 0 -22.1954</rotate>");
		out.println("                <rotate sid=\"rotateZ\">0 0 1 0</rotate>");
		out.println("                <instance_camera url=\"#testCameraShape\"/>");
		out.println("            </node>");
		out.println("            <node id=\"pointLight1\" name=\"pointLight1\">");
		out.println("                <translate sid=\"translate\">3 4 10</translate>");
		out.println("                <rotate sid=\"rotateZ\">0 0 1 0</rotate>");
		out.println("                <rotate sid=\"rotateY\">0 1 0 0</rotate>");
		out.println("                <rotate sid=\"rotateX\">1 0 0 0</rotate>");
		out.println("                <instance_light url=\"#pointLightShape1-lib\"/>");
		out.println("            </node>");
		out.println("        </visual_scene>");
		out.println("    </library_visual_scenes>");*/
	}

	private void writeLights(PrintWriter writer) {
		/*
		out.println("    <library_lights>");
		out.println("        <light id=\"light-lib\" name=\"light\">");
		out.println("            <technique_common>");
		out.println("                <point>");
		out.println("                    <color>1 1 1</color>");
		out.println("                    <constant_attenuation>1</constant_attenuation>");
		out.println("                    <linear_attenuation>0</linear_attenuation>");
		out.println("                    <quadratic_attenuation>0</quadratic_attenuation>");
		out.println("                </point>");
		out.println("            </technique_common>");
		out.println("            <technique profile=\"MAX3D\">");
		out.println("                <intensity>1.000000</intensity>");
		out.println("            </technique>");
		out.println("        </light>");
		out.println("        <light id=\"pointLightShape1-lib\" name=\"pointLightShape1\">");
		out.println("            <technique_common>");
		out.println("                <point>");
		out.println("                    <color>1 1 1</color>");
		out.println("                    <constant_attenuation>1</constant_attenuation>");
		out.println("                    <linear_attenuation>0</linear_attenuation>");
		out.println("                    <quadratic_attenuation>0</quadratic_attenuation>");
		out.println("                </point>");
		out.println("            </technique_common>");
		out.println("        </light>");
		out.println("    </library_lights>");*/
	}

	private void writeCameras(PrintWriter writer) {
		/*
		out.println("    <library_cameras>");
		out.println("        <camera id=\"PerspCamera\" name=\"PerspCamera\">");
		out.println("            <optics>");
		out.println("                <technique_common>");
		out.println("                    <perspective>");
		out.println("                        <yfov>37.8493</yfov>");
		out.println("                        <aspect_ratio>1</aspect_ratio>");
		out.println("                        <znear>10</znear>");
		out.println("                        <zfar>1000</zfar>");
		out.println("                    </perspective>");
		out.println("                </technique_common>");
		out.println("            </optics>");
		out.println("        </camera>");
		out.println("        <camera id=\"testCameraShape\" name=\"testCameraShape\">");
		out.println("            <optics>");
		out.println("                <technique_common>");
		out.println("                    <perspective>");
		out.println("                        <yfov>37.8501</yfov>");
		out.println("                        <aspect_ratio>1</aspect_ratio>");
		out.println("                        <znear>0.01</znear>");
		out.println("                        <zfar>1000</zfar>");
		out.println("                    </perspective>");
		out.println("                </technique_common>");
		out.println("            </optics>");
		out.println("        </camera>");
		out.println("    </library_cameras>");*/
	}
}
