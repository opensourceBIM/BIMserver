package org.bimserver.collada;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.GeometryData;
import org.bimserver.models.ifc2x3tc1.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcBuildingElementProxy;
import org.bimserver.models.ifc2x3tc1.IfcColumn;
import org.bimserver.models.ifc2x3tc1.IfcCurtainWall;
import org.bimserver.models.ifc2x3tc1.IfcDoor;
import org.bimserver.models.ifc2x3tc1.IfcFeatureElementSubtraction;
import org.bimserver.models.ifc2x3tc1.IfcFlowSegment;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcMember;
import org.bimserver.models.ifc2x3tc1.IfcPlate;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRailing;
import org.bimserver.models.ifc2x3tc1.IfcRoof;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcSlabTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcStair;
import org.bimserver.models.ifc2x3tc1.IfcStairFlight;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.models.ifc2x3tc1.IfcWallStandardCase;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.AbstractGeometrySerializer;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.UTF8PrintWriter;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColladaSerializer extends AbstractGeometrySerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ColladaSerializer.class);
	private static final Map<Class<? extends IfcProduct>, Convertor<? extends IfcProduct>> convertors = new LinkedHashMap<Class<? extends IfcProduct>, Convertor<? extends IfcProduct>>();
	private final Map<String, Set<String>> converted = new HashMap<String, Set<String>>();
	private SIPrefix lengthUnitPrefix;
	private int idCounter;

	private static <T extends IfcProduct> void addConvertor(Convertor<T> convertor) {
		convertors.put(convertor.getCl(), convertor);
	}

	static {
		addConvertor(new Convertor<IfcRoof>(IfcRoof.class, new double[] { 0.837255f, 0.203922f, 0.270588f }, 1.0f));
		addConvertor(new Convertor<IfcSlab>(IfcSlab.class, new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f) {
			@Override
			public String getMaterialName(Object ifcSlab) {
				if (ifcSlab == null || !(ifcSlab instanceof IfcSlab) || ((IfcSlab) ifcSlab).getPredefinedType() != IfcSlabTypeEnum.ROOF) {
					return "IfcSlab";
				} else {
					return "IfcRoof";
				}
			}
		});
		addConvertor(new Convertor<IfcWindow>(IfcWindow.class, new double[] { 0.2f, 0.2f, 0.8f }, 0.2f));
		addConvertor(new Convertor<IfcSpace>(IfcSpace.class, new double[] { 0.5f, 0.4f, 0.1f }, 0.2f));
		addConvertor(new Convertor<IfcDoor>(IfcDoor.class, new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f));
		addConvertor(new Convertor<IfcStair>(IfcStair.class, new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f));
		addConvertor(new Convertor<IfcStairFlight>(IfcStairFlight.class, new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f));
		addConvertor(new Convertor<IfcFlowSegment>(IfcFlowSegment.class, new double[] { 0.6f, 0.4f, 0.5f }, 1.0f));
		addConvertor(new Convertor<IfcFurnishingElement>(IfcFurnishingElement.class, new double[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f));
		addConvertor(new Convertor<IfcPlate>(IfcPlate.class, new double[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f));
		addConvertor(new Convertor<IfcMember>(IfcMember.class, new double[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f));
		addConvertor(new Convertor<IfcWallStandardCase>(IfcWallStandardCase.class, new double[] { 0.537255f, 0.337255f, 0.237255f }, 1.0f));
		addConvertor(new Convertor<IfcWall>(IfcWall.class, new double[] { 0.537255f, 0.337255f, 0.237255f }, 1.0f));
		addConvertor(new Convertor<IfcCurtainWall>(IfcCurtainWall.class, new double[] { 0.5f, 0.5f, 0.5f }, 0.5f));
		addConvertor(new Convertor<IfcRailing>(IfcRailing.class, new double[] { 0.137255f, 0.203922f, 0.270588f }, 1.0f));
		addConvertor(new Convertor<IfcColumn>(IfcColumn.class, new double[] { 0.437255f, 0.603922f, 0.370588f, }, 1.0f));
		addConvertor(new Convertor<IfcBuildingElementProxy>(IfcBuildingElementProxy.class, new double[] { 0.5f, 0.5f, 0.5f }, 1.0f));
		addConvertor(new Convertor<IfcProduct>(IfcProduct.class, new double[] { 0.5f, 0.5f, 0.5f }, 1.0f));
	}

	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin, boolean normalizeOids) throws SerializerException {
		super.init(model, projectInfo, pluginManager, renderEnginePlugin, normalizeOids);
		this.lengthUnitPrefix = getLengthUnitPrefix(model);
	}

	@Override
	public void reset() {
		setMode(Mode.BODY);
	}

	@Override
	public boolean write(OutputStream out) throws SerializerException {
		if (getMode() == Mode.BODY) {
			PrintWriter writer = new UTF8PrintWriter(out);
			try {
				writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				writer.println("<COLLADA xmlns=\"http://www.collada.org/2005/11/COLLADASchema\" version=\"1.4.1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.collada.org/2005/11/COLLADASchema http://www.khronos.org/files/collada_schema_1_4\" >");
				// writer.println("<COLLADA xmlns=\"http://www.collada.org/2008/03/COLLADASchema\" version=\"1.5.0\">");

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
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	private void writeAssets(PrintWriter out) {
		out.println("    <asset>");
		out.println("        <contributor>");
		out.println("            <author>" + (getProjectInfo() == null ? "" : getProjectInfo().getAuthorName()) + "</author>");
		out.println("            <authoring_tool>BIMserver</authoring_tool>");
		out.println("            <comments>" + (getProjectInfo() == null ? "" : getProjectInfo().getDescription()) + "</comments>");
		out.println("            <copyright>Copyright</copyright>");
		out.println("        </contributor>");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
		String date = dateFormat.format(new Date());
		out.println("        <created>" + date + "</created>");
		out.println("        <modified>" + date + "</modified>");
		if (lengthUnitPrefix == null) {
			out.println("        <unit meter=\"1\" name=\"meter\"/>");
		} else {
			out.println("        <unit meter=\"" + Math.pow(10.0, lengthUnitPrefix.getValue()) + "\" name=\"" + lengthUnitPrefix.name().toLowerCase() + "\"/>");
		}
		out.println("        <up_axis>Y_UP</up_axis>");
		out.println("    </asset>");
	}

	private void writeGeometries(PrintWriter out) throws RenderEngineException, SerializerException {
		out.println("      <library_geometries>");

		Set<IfcProduct> convertedObjects = new HashSet<IfcProduct>();

		for (Class<? extends IfcProduct> cl : convertors.keySet()) {
			Convertor<? extends IfcProduct> convertor = convertors.get(cl);
			for (IfcProduct object : model.getAllWithSubTypes(cl)) {
				if (!convertedObjects.contains(object)) {
					convertedObjects.add(object);
					setGeometry(out, object, convertor.getMaterialName(object));
				}
			}
		}
		out.println("      </library_geometries>");
	}

	private String generateId() {
		return "" + (idCounter++);
	}

	private void setGeometry(PrintWriter out, IfcProduct ifcProductObject, String material) throws RenderEngineException, SerializerException {
		// boolean materialFound = false;
		// boolean added = false;
		// if (ifcRootObject instanceof IfcProduct) {
		// IfcProduct ifcProduct = (IfcProduct) ifcRootObject;
		//
		// EList<IfcRelDecomposes> isDecomposedBy =
		// ifcProduct.getIsDecomposedBy();
		// for (IfcRelDecomposes dcmp : isDecomposedBy) {
		// EList<IfcObjectDefinition> relatedObjects = dcmp.getRelatedObjects();
		// for (IfcObjectDefinition relatedObject : relatedObjects) {
		// setGeometry(out, relatedObject, material);
		// }
		// }
		// if (isDecomposedBy != null && isDecomposedBy.size() > 0) {
		// return;
		// }
		//
		// Iterator<IfcRelAssociatesMaterial> ramIter =
		// model.getAll(IfcRelAssociatesMaterial.class).iterator();
		// boolean found = false;
		// IfcMaterialSelect relatingMaterial = null;
		// while (!found && ramIter.hasNext()) {
		// IfcRelAssociatesMaterial ram = ramIter.next();
		// if (ram.getRelatedObjects().contains(ifcProduct)) {
		// found = true;
		// relatingMaterial = ram.getRelatingMaterial();
		// }
		// }
		// if (found && relatingMaterial instanceof IfcMaterialLayerSetUsage) {
		// IfcMaterialLayerSetUsage mlsu = (IfcMaterialLayerSetUsage)
		// relatingMaterial;
		// IfcMaterialLayerSet forLayerSet = mlsu.getForLayerSet();
		// if (forLayerSet != null) {
		// EList<IfcMaterialLayer> materialLayers =
		// forLayerSet.getMaterialLayers();
		// for (IfcMaterialLayer ml : materialLayers) {
		// IfcMaterial ifcMaterial = ml.getMaterial();
		// if (ifcMaterial != null) {
		// String name = ifcMaterial.getName();
		// String filterSpaces = fitNameForQualifiedName(name);
		// materialFound = converted.containsKey(filterSpaces);
		// if (materialFound) {
		// material = filterSpaces;
		// }
		// }
		// }
		// }
		// } else if (found && relatingMaterial instanceof IfcMaterial) {
		// IfcMaterial ifcMaterial = (IfcMaterial) relatingMaterial;
		// String name = ifcMaterial.getName();
		// String filterSpaces = fitNameForQualifiedName(name);
		// materialFound = converted.containsKey(filterSpaces);
		// if (materialFound) {
		// material = filterSpaces;
		// }
		// }
		//
		// if (!materialFound) {
		// IfcProductRepresentation representation =
		// ifcProduct.getRepresentation();
		// if (representation instanceof IfcProductDefinitionShape) {
		// IfcProductDefinitionShape pds = (IfcProductDefinitionShape)
		// representation;
		// EList<IfcRepresentation> representations = pds.getRepresentations();
		// for (IfcRepresentation rep : representations) {
		// if (rep instanceof IfcShapeRepresentation) {
		// IfcShapeRepresentation sRep = (IfcShapeRepresentation) rep;
		// EList<IfcRepresentationItem> items = sRep.getItems();
		// for (IfcRepresentationItem item : items) {
		// EList<IfcStyledItem> styledByItem = item.getStyledByItem();
		// for (IfcStyledItem sItem : styledByItem) {
		// EList<IfcPresentationStyleAssignment> styles = sItem.getStyles();
		// for (IfcPresentationStyleAssignment sa : styles) {
		// EList<IfcPresentationStyleSelect> styles2 = sa.getStyles();
		// for (IfcPresentationStyleSelect pss : styles2) {
		// if (pss instanceof IfcSurfaceStyle) {
		// IfcSurfaceStyle ss = (IfcSurfaceStyle) pss;
		// String name = ss.getName();
		// String filterSpaces = fitNameForQualifiedName(name);
		// added = true;
		// if (!converted.containsKey(filterSpaces)) {
		// converted.put(filterSpaces, new HashSet<String>());
		// }
		// converted.get(filterSpaces).add(id);
		// }
		// }
		// }
		// }
		// }
		// }
		// }
		// }
		// }
		// }
		//
		// if (!added) {
		// }

		if (ifcProductObject instanceof IfcFeatureElementSubtraction) {
			// Mostly just skips IfcOpeningElements which one would probably not
			// want to end up in the Collada file.
			return;
		}

		GeometryInfo geometryInfo = ifcProductObject.getGeometry();
		if (geometryInfo != null) {
			GeometryData geometryData = geometryInfo.getData();
			ByteBuffer verticesBuffer = ByteBuffer.wrap(geometryData.getVertices());
			ByteBuffer normalsBuffer = ByteBuffer.wrap(geometryData.getNormals());

			String id = generateId();
			if (!converted.containsKey(material)) {
				converted.put(material, new HashSet<String>());
			}
			converted.get(material).add(id);

			String name = "[NO_GUID]";
			if (ifcProductObject.getGlobalId() != null && ifcProductObject.getGlobalId() != null) {
				name = ifcProductObject.getGlobalId();
			}

			int t = geometryInfo.getPrimitiveCount() * 3 * 3;

			out.println("      <geometry id=\"geom-" + id + "\" name=\"" + name + "\">");
			out.println("                      <mesh>");
			out.println("                                     <source id=\"positions-" + id + "\" name=\"positions-" + id + "\">");
			out.print("                                                         <float_array id=\"positions-array-" + id + "\" count=\""
					+ t + "\">");

			for (int i = 0; i < t; i++) {
				if (i < t - 1) {
					out.print(verticesBuffer.getFloat() + " ");
				} else {
					out.print(verticesBuffer.getFloat());
				}
			}

			out.println("</float_array>");
			out.println("                                                     <technique_common>");
			out.println("                                                                     <accessor count=\"" + (geometryInfo.getPrimitiveCount() * 3)
					+ "\" offset=\"0\" source=\"#positions-array-" + id + "\" stride=\"3\">");
			out.println("                                                                                    <param name=\"X\" type=\"float\"></param>");
			out.println("                                                                                    <param name=\"Y\" type=\"float\"></param>");
			out.println("                                                                                    <param name=\"Z\" type=\"float\"></param>");
			out.println("                                                                     </accessor>");
			out.println("                                                     </technique_common>");
			out.println("                                     </source>");

			out.println("                                     <source id=\"normals-" + id + "\" name=\"normals-" + id + "\">");
			out.print("                                                         <float_array id=\"normals-array-" + id + "\" count=\""
					+ t + "\">");
			
			for (int i = 0; i < t; i++) {
				if (i < t - 1) {
					out.print(normalsBuffer.getFloat() * 1000.0f + " ");
				} else {
					out.print(normalsBuffer.getFloat() * 1000.0f);
				}
			}

			out.println("</float_array>");
			out.println("                                                     <technique_common>");
			out.println("                                                                     <accessor count=\"" + (geometryInfo.getPrimitiveCount() * 3)
					+ "\" offset=\"0\" source=\"#normals-array-" + id + "\" stride=\"3\">");
			out.println("                                                                                    <param name=\"X\" type=\"float\"></param>");
			out.println("                                                                                    <param name=\"Y\" type=\"float\"></param>");
			out.println("                                                                                    <param name=\"Z\" type=\"float\"></param>");
			out.println("                                                                     </accessor>");
			out.println("                                                     </technique_common>");
			out.println("                                     </source>");

			out.println("                                     <vertices id=\"vertices-" + id + "\">");
			out.println("                                                     <input semantic=\"POSITION\" source=\"#positions-" + id + "\"/>");
			out.println("                                                     <input semantic=\"NORMAL\" source=\"#normals-" + id + "\"/>");
			out.println("                                     </vertices>");

			out.println("                                     <triangles count=\"" + (geometryInfo.getPrimitiveCount()) * 3 + "\" material=\"Material-" + id + "\">");
			out.println("                                                     <input offset=\"0\" semantic=\"VERTEX\" source=\"#vertices-" + id + "\"/>");
			out.print("                                                         <p>");

			int count = geometryInfo.getPrimitiveCount() * 3;
			for (int i = 0; i < count; i += 3) {
				out.print(i + " ");
				out.print((i + 2)  + " ");
				out.print(i + 1);
				if (i + 3 != count) {
					out.print(" ");
				}
			}
			out.println("</p>");
			out.println("                                     </triangles>");
			out.println("                      </mesh>");
			out.println("      </geometry>");
		}
	}

	private void writeScene(PrintWriter out) {
		out.println("      <scene>");
		out.println("                      <instance_visual_scene url=\"#VisualSceneNode\"/>");
		out.println("      </scene>");
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
				out.println("            <node id=\"node-" + id + "\" name=\"node-" + id + "\">");
				out.println("                <rotate sid=\"rotateX\">1 0 0 90</rotate>");
				out.println("                <rotate sid=\"rotateY\">0 1 0 180</rotate>");
				out.println("                <rotate sid=\"rotateZ\">0 0 1 90</rotate>");
				out.println("                <instance_geometry url=\"#geom-" + id + "\">");
				out.println("                    <bind_material>");
				out.println("                        <technique_common>");
				out.println("                            <instance_material symbol=\"Material-" + id + "\" target=\"#" + material + "Material\"/>");
				out.println("                        </technique_common>");
				out.println("                    </bind_material>");
				out.println("                </instance_geometry>");
				out.println("            </node>");
			}
		}
		// out.println("            <node id=\"testCamera\" name=\"testCamera\">");
		// out.println("                <translate sid=\"translate\">-427.749 333.855 655.017</translate>");
		// out.println("                <rotate sid=\"rotateY\">0 1 0 -33</rotate>");
		// out.println("                <rotate sid=\"rotateX\">1 0 0 -22.1954</rotate>");
		// out.println("                <rotate sid=\"rotateZ\">0 0 1 0</rotate>");
		// out.println("                <instance_camera url=\"#testCameraShape\"/>");
		// out.println("            </node>");
		// out.println("            <node id=\"pointLight1\" name=\"pointLight1\">");
		// out.println("                <translate sid=\"translate\">3 4 10</translate>");
		// out.println("                <rotate sid=\"rotateZ\">0 0 1 0</rotate>");
		// out.println("                <rotate sid=\"rotateY\">0 1 0 0</rotate>");
		// out.println("                <rotate sid=\"rotateX\">1 0 0 0</rotate>");
		// out.println("                <instance_light url=\"#pointLightShape1-lib\"/>");
		// out.println("            </node>");
		out.println("        </visual_scene>");
		out.println("    </library_visual_scenes>");
	}

	private void writeEffects(PrintWriter out) {
		out.println("      <library_effects>");
		for (Convertor<? extends IfcProduct> convertor : convertors.values()) {
			writeEffect(out, convertor.getMaterialName(null), convertor.getColors(), convertor.getOpacity());
		}
		// List<IfcSurfaceStyle> listSurfaceStyles =
		// model.getAll(IfcSurfaceStyle.class);
		// for (IfcSurfaceStyle ss : listSurfaceStyles) {
		// EList<IfcSurfaceStyleElementSelect> styles = ss.getStyles();
		// for (IfcSurfaceStyleElementSelect style : styles) {
		// if (style instanceof IfcSurfaceStyleRendering) {
		// IfcSurfaceStyleRendering ssr = (IfcSurfaceStyleRendering) style;
		// IfcColourRgb colour = null;
		// IfcColourOrFactor surfaceColour = ssr.getSurfaceColour();
		// if (surfaceColour instanceof IfcColourRgb) {
		// colour = (IfcColourRgb) surfaceColour;
		// }
		// String name = fitNameForQualifiedName(ss.getName());
		// writeEffect(out, name, new double[] { colour.getRed(),
		// colour.getGreen(), colour.getBlue() }, (ssr.isSetTransparency() ?
		// (ssr.getTransparency()) : 1.0f));
		// break;
		// }
		// }
		// }
		out.println("    </library_effects>");
	}

	// private String fitNameForQualifiedName(String name) {
	// if (name == null) {
	// return "";
	// }
	// StringBuilder builder = new StringBuilder(name);
	// int indexOfSpace = builder.indexOf(" ");
	// while (indexOfSpace >= 0) {
	// builder.deleteCharAt(indexOfSpace);
	// indexOfSpace = builder.indexOf(" ");
	// }
	// indexOfSpace = builder.indexOf(",");
	// while (indexOfSpace >= 0) {
	// builder.setCharAt(indexOfSpace, '_');
	// indexOfSpace = builder.indexOf(",");
	// }
	// indexOfSpace = builder.indexOf("/");
	// while (indexOfSpace >= 0) {
	// builder.setCharAt(indexOfSpace, '_');
	// indexOfSpace = builder.indexOf("/");
	// }
	// indexOfSpace = builder.indexOf("*");
	// while (indexOfSpace >= 0) {
	// builder.setCharAt(indexOfSpace, '_');
	// indexOfSpace = builder.indexOf("/");
	// }
	// return builder.toString();
	// }

	private void writeEffect(PrintWriter out, String name, double[] colors, double transparency) {
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
//		out.println("                        <transparent>");
//		out.println("                            <color>" + transparency + " " + transparency + " " + transparency + " " + 1 + "</color>");
//		out.println("                        </transparent>");
//		out.println("                        <transparency>");
//		out.println("                            <float>" + transparency + "</float>");
//		out.println("                        </transparency>");
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
		out.println("      <library_materials>");
		for (Convertor<? extends IfcProduct> convertor : convertors.values()) {
			writeMaterial(out, convertor.getMaterialName(null));
		}
		out.println("      </library_materials>");
	}

	private void writeMaterial(PrintWriter out, String materialName) {
		out.println("                      <material id=\"" + materialName + "Material\" name=\"" + materialName + "Material\">");
		out.println("                                     <instance_effect url=\"#" + materialName + "-fx\"/>");
		out.println("                      </material>");
	}

	private static SIPrefix getLengthUnitPrefix(IfcModelInterface model) {
		SIPrefix lengthUnitPrefix = null;
		boolean prefixFound = false;
		Map<Long, IdEObject> objects = model.getObjects();
		for (IdEObject object : objects.values()) {
			if (object instanceof IfcProject) {
				IfcUnitAssignment unitsInContext = ((IfcProject) object).getUnitsInContext();
				if (unitsInContext != null) {
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
			}
			if (prefixFound)
				break;
		}
		return lengthUnitPrefix;
	}
}
