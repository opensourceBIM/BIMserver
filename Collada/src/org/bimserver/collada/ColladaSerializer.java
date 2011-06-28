package org.bimserver.collada;

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
import org.bimserver.models.ifc2x3.IfcColourOrFactor;
import org.bimserver.models.ifc2x3.IfcColourRgb;
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
import org.bimserver.models.ifc2x3.IfcProject;
import org.bimserver.models.ifc2x3.IfcRailing;
import org.bimserver.models.ifc2x3.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3.IfcRelDecomposes;
import org.bimserver.models.ifc2x3.IfcRepresentation;
import org.bimserver.models.ifc2x3.IfcRepresentationItem;
import org.bimserver.models.ifc2x3.IfcRoof;
import org.bimserver.models.ifc2x3.IfcSIUnit;
import org.bimserver.models.ifc2x3.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3.IfcSlab;
import org.bimserver.models.ifc2x3.IfcSlabTypeEnum;
import org.bimserver.models.ifc2x3.IfcStair;
import org.bimserver.models.ifc2x3.IfcStairFlight;
import org.bimserver.models.ifc2x3.IfcStyledItem;
import org.bimserver.models.ifc2x3.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3.IfcSurfaceStyleRendering;
import org.bimserver.models.ifc2x3.IfcUnit;
import org.bimserver.models.ifc2x3.IfcUnitAssignment;
import org.bimserver.models.ifc2x3.IfcUnitEnum;
import org.bimserver.models.ifc2x3.IfcWall;
import org.bimserver.models.ifc2x3.IfcWallStandardCase;
import org.bimserver.models.ifc2x3.IfcWindow;
import org.bimserver.models.store.SIPrefix;
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

public class ColladaSerializer extends BimModelSerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ColladaSerializer.class);
	private IfcEngine ifcEngine;
	private Map<String, Set<String>> converted = new HashMap<String, Set<String>>();
	private SIPrefix lengthUnitPrefix;
	private List<String> surfaceStyleIds;

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException {
		super.init(model, projectInfo, pluginManager);
		lengthUnitPrefix = getLengthUnitPrefix(model);
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
				writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>");
				writer
						.println("<COLLADA xmlns=\"http://www.collada.org/2005/11/COLLADASchema\" version=\"1.4.1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.collada.org/2005/11/COLLADASchema http://www.khronos.org/files/collada_schema_1_4\" >");

				writeAssets(writer);
				writeCameras(writer);
				writeLights(writer);
				writeEffects(writer);
				writeMaterials(writer);
				writeGeometries(writer);
				writeVisualScenes(writer);
				writeScene(writer);

				writer.print("</COLLADA>");
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

	private void writeAssets(PrintWriter out) {
		out.println("    <asset>");
		out.println("        <contributor>");
		out.println("            <author>" + getProjectInfo().getAuthorName() + "</author>");
		out.println("            <authoring_tool>BIMserver</authoring_tool>");
		out.println("            <comments>" + getProjectInfo().getDescription() + "</comments>");
		out.println("            <copyright>Copyright</copyright>");
		out.println("        </contributor>");
		out.println("        <created>2006-06-21T21:23:22Z</created>");
		out.println("        <modified>2006-06-21T21:23:22Z</modified>");
		if (lengthUnitPrefix == null) {
			out.println("        <unit meter=\"1\" name=\"meter\"/>");
		} else {
			out.println("        <unit meter=\"" + Math.pow(10.0, lengthUnitPrefix.getValue()) + "\" name=\"" + lengthUnitPrefix.name().toLowerCase() + "\"/>");
		}
		out.println("        <up_axis>Y_UP</up_axis>");
		out.println("    </asset>");
	}

	private void writeGeometries(PrintWriter out) throws IfcEngineException, SerializerException {
		out.println("	<library_geometries>");

		for (IfcRoof ifcRoof : model.getAll(IfcRoof.class)) {
			setGeometry(out, ifcRoof, ifcRoof.getGlobalId().getWrappedValue(), "Roof");
		}
		for (IfcSlab ifcSlab : model.getAll(IfcSlab.class)) {
			if (ifcSlab.getPredefinedType() == IfcSlabTypeEnum.ROOF) {
				setGeometry(out, ifcSlab, ifcSlab.getGlobalId().getWrappedValue(), "Roof");
			} else {
				setGeometry(out, ifcSlab, ifcSlab.getGlobalId().getWrappedValue(), "Slab");
			}
		}
		for (IfcWindow ifcWindow : model.getAll(IfcWindow.class)) {
			setGeometry(out, ifcWindow, ifcWindow.getGlobalId().getWrappedValue(), "Window");
		}
		for (IfcDoor ifcDoor : model.getAll(IfcDoor.class)) {
			setGeometry(out, ifcDoor, ifcDoor.getGlobalId().getWrappedValue(), "Door");
		}
		for (IfcWall ifcWall : model.getAll(IfcWall.class)) {
			setGeometry(out, ifcWall, ifcWall.getGlobalId().getWrappedValue(), "Wall");
		}
		for (IfcStair ifcStair : model.getAll(IfcStair.class)) {
			setGeometry(out, ifcStair, ifcStair.getGlobalId().getWrappedValue(), "Stair");
		}
		for (IfcStairFlight ifcStairFlight : model.getAll(IfcStairFlight.class)) {
			setGeometry(out, ifcStairFlight, ifcStairFlight.getGlobalId().getWrappedValue(), "StairFlight");
		}
		for (IfcFlowSegment ifcFlowSegment : model.getAll(IfcFlowSegment.class)) {
			setGeometry(out, ifcFlowSegment, ifcFlowSegment.getGlobalId().getWrappedValue(), "FlowSegment");
		}
		for (IfcFurnishingElement ifcFurnishingElement : model.getAll(IfcFurnishingElement.class)) {
			setGeometry(out, ifcFurnishingElement, ifcFurnishingElement.getGlobalId().getWrappedValue(), "FurnishingElement");
		}
		for (IfcPlate ifcPlate : model.getAll(IfcPlate.class)) {
			setGeometry(out, ifcPlate, ifcPlate.getGlobalId().getWrappedValue(), "Plate");
		}
		for (IfcMember ifcMember : model.getAll(IfcMember.class)) {
			setGeometry(out, ifcMember, ifcMember.getGlobalId().getWrappedValue(), "Member");
		}
		for (IfcWallStandardCase ifcWall : model.getAll(IfcWallStandardCase.class)) {
			setGeometry(out, ifcWall, ifcWall.getGlobalId().getWrappedValue(), "WallStandardCase");
		}
		for (IfcCurtainWall ifcCurtainWall : model.getAll(IfcCurtainWall.class)) {
			setGeometry(out, ifcCurtainWall, ifcCurtainWall.getGlobalId().getWrappedValue(), "CurtainWall");
		}
		for (IfcRailing ifcRailing : model.getAll(IfcRailing.class)) {
			setGeometry(out, ifcRailing, ifcRailing.getGlobalId().getWrappedValue(), "Railing");
		}
		for (IfcColumn ifcColumn : model.getAll(IfcColumn.class)) {
			setGeometry(out, ifcColumn, ifcColumn.getGlobalId().getWrappedValue(), "Column");
		}
		for (IfcBuildingElementProxy ifcBuildingElementProxy : model.getAll(IfcBuildingElementProxy.class)) {
			setGeometry(out, ifcBuildingElementProxy, ifcBuildingElementProxy.getGlobalId().getWrappedValue(), "BuildingElementProxy");
		}
		out.println("	</library_geometries>");
	}

	private void setGeometry(PrintWriter out, IdEObject ifcRootObject, String id, String material) throws IfcEngineException, SerializerException {

		id = id.replace('$', '-'); // XML QNAME may not contain a $ character.
		id = "_" + id; // XML QNAME may not start with a digit.

		boolean materialFound = false;
		if (ifcRootObject instanceof IfcProduct) {
			IfcProduct ifcProduct = (IfcProduct) ifcRootObject;

			EList<IfcRelDecomposes> isDecomposedBy = ifcProduct.getIsDecomposedBy();
			for (IfcRelDecomposes dcmp : isDecomposedBy) {
				EList<IfcObjectDefinition> relatedObjects = dcmp.getRelatedObjects();
				for (IfcObjectDefinition relatedObject : relatedObjects) {
					setGeometry(out, relatedObject, relatedObject.getGlobalId().getWrappedValue(), material);
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
		converted.get(material).add(id);

		IfcModel ifcModel = new IfcModel();
		convertToSubset(ifcRootObject.eClass(), ifcRootObject, ifcModel, new HashMap<EObject, EObject>());
		EmfSerializer serializer = getPluginManager().requireIfcStepSerializer();
		serializer.init(ifcModel, getProjectInfo(), getPluginManager());
		try {
			IfcEngineModel model = ifcEngine.openModel(serializer.getBytes());
			try {
				model.setPostProcessing(true);
				IfcEngineGeometry geometry = model.finalizeModelling(model.initializeModelling());
				if (geometry != null) {
					out.println("<geometry id=\"" + id + "\" name=\"" + id + "\">");
					out.println("<mesh>");
					out.println("<source id=\"" + id + "-positions\" name=\"" + id + "-positions\">");
					out.print("<float_array id=\"" + id + "-positions-array\" count=\"" + geometry.getNrVertices() + "\">");
					for (int i = 0; i < geometry.getNrVertices(); i += 1) {
						out.print(geometry.getVertex(i) + " ");
					}
					out.println("</float_array>");
					out.println("<technique_common>");
					out.println("<accessor count=\"" + (geometry.getNrVertices() / 3) + "\" offset=\"0\" source=\"#" + id + "-positions-array\" stride=\"3\">");
					out.println("<param name=\"X\" type=\"float\"></param>");
					out.println("<param name=\"Y\" type=\"float\"></param>");
					out.println("<param name=\"Z\" type=\"float\"></param>");
					out.println("</accessor>");
					out.println("</technique_common>");
					out.println("</source>");

					out.println("<source id=\"" + id + "-normals\" name=\"" + id + "-normals\">");
					out.print("<float_array id=\"" + id + "-normals-array\" count=\"" + geometry.getNrNormals() + "\">");
					for (int i = 0; i < geometry.getNrNormals(); i++) {
						// Normals will also be scaled in Google Earth ...
						out.print(geometry.getNormal(i) * 1000.0f + " ");
					}
					out.println("</float_array>");
					out.println("<technique_common>");
					out.println("<accessor count=\"" + (geometry.getNrNormals() / 3) + "\" offset=\"0\" source=\"#" + id + "-normals-array\" stride=\"3\">");
					out.println("<param name=\"X\" type=\"float\"></param>");
					out.println("<param name=\"Y\" type=\"float\"></param>");
					out.println("<param name=\"Z\" type=\"float\"></param>");
					out.println("</accessor>");
					out.println("</technique_common>");
					out.println("</source>");

					out.println("<vertices id=\"" + id + "-vertices\">");
					out.println("<input semantic=\"POSITION\" source=\"#" + id + "-positions\"/>");
					out.println("<input semantic=\"NORMAL\" source=\"#" + id + "-normals\"/>");
					out.println("</vertices>");
					for (IfcEngineInstance instance : model.getInstances(ifcRootObject.eClass().getName().toUpperCase())) {
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
					}
					out.println("</mesh>");
					out.println("</geometry>");
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

	private void writeScene(PrintWriter out) {
		out.println("	<scene>");
		out.println("		<instance_visual_scene url=\"#VisualSceneNode\"/>");
		out.println("	</scene>");
	}

	private void writeVisualScenes(PrintWriter out) {
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
		out.println("    </library_visual_scenes>");
	}

	private void writeEffects(PrintWriter out) {
		out.println("	<library_effects>");
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

		out.println("    </library_effects>");
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

	private void writeEffect(PrintWriter out, String name, float[] colors, float transparency) {
		out.println("        <effect id=\"" + name + "-fx\">");
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
		out.println("        </effect>");
	}

	private void writeLights(PrintWriter out) {
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
		out.println("    </library_lights>");
	}

	private void writeCameras(PrintWriter out) {
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
		out.println("    </library_cameras>");
	}

	private void writeMaterials(PrintWriter out) {
		out.println("	<library_materials>");
		out.println("		<material id=\"RoofMaterial\" name=\"RoofMaterial\">");
		out.println("			<instance_effect url=\"#Roof-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"SpaceMaterial\" name=\"SpaceMaterial\">");
		out.println("			<instance_effect url=\"#Space-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"SlabMaterial\" name=\"SlabMaterial\">");
		out.println("			<instance_effect url=\"#Slab-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"WallMaterial\" name=\"WallMaterial\">");
		out.println("			<instance_effect url=\"#Wall-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"WindowMaterial\" name=\"WindowMaterial\">");
		out.println("			<instance_effect url=\"#Window-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"DoorMaterial\" name=\"DoorMaterial\">");
		out.println("			<instance_effect url=\"#Door-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"RailingMaterial\" name=\"RailingMaterial\">");
		out.println("			<instance_effect url=\"#Railing-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"ColumnMaterial\" name=\"ColumnMaterial\">");
		out.println("			<instance_effect url=\"#Column-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"FurnishingElementMaterial\" name=\"FurnishingElementMaterial\">");
		out.println("			<instance_effect url=\"#FurnishingElement-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"CurtainWallMaterial\" name=\"CurtainWallMaterial\">");
		out.println("			<instance_effect url=\"#CurtainWall-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"StairMaterial\" name=\"StairMaterial\">");
		out.println("			<instance_effect url=\"#Stair-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"FlowSegmentMaterial\" name=\"FlowSegmentMaterial\">");
		out.println("			<instance_effect url=\"#FlowSegment-fx\"/>");
		out.println("		</material>");
		out.println("		<material id=\"BuildingElementProxyMaterial\" name=\"BuildingElementProxyMaterial\">");
		out.println("			<instance_effect url=\"#BuildingElementProxy-fx\"/>");
		out.println("		</material>");

		for (String surfaceStyleId : surfaceStyleIds) {
			out.println("		<material id=\"" + surfaceStyleId + "Material\" name=\"" + surfaceStyleId + "Material\">");
			out.println("			<instance_effect url=\"#" + surfaceStyleId + "-fx\"/>");
			out.println("		</material>");
		}

		out.println("	</library_materials>");
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