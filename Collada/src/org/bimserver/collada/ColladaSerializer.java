package org.bimserver.collada;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.database.store.Project;
import org.bimserver.database.store.SIPrefix;
import org.bimserver.database.store.User;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.BimModelSerializer;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.PackageDefinition;
import org.bimserver.ifc.SerializerException;
import org.bimserver.ifc.database.IfcDatabase;
import org.bimserver.ifc.emf.Ifc2x3.IfcColumn;
import org.bimserver.ifc.emf.Ifc2x3.IfcCurtainWall;
import org.bimserver.ifc.emf.Ifc2x3.IfcDoor;
import org.bimserver.ifc.emf.Ifc2x3.IfcFlowSegment;
import org.bimserver.ifc.emf.Ifc2x3.IfcFurnishingElement;
import org.bimserver.ifc.emf.Ifc2x3.IfcMember;
import org.bimserver.ifc.emf.Ifc2x3.IfcPlate;
import org.bimserver.ifc.emf.Ifc2x3.IfcProject;
import org.bimserver.ifc.emf.Ifc2x3.IfcRailing;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoof;
import org.bimserver.ifc.emf.Ifc2x3.IfcSIUnit;
import org.bimserver.ifc.emf.Ifc2x3.IfcSlab;
import org.bimserver.ifc.emf.Ifc2x3.IfcSlabTypeEnum;
import org.bimserver.ifc.emf.Ifc2x3.IfcStairFlight;
import org.bimserver.ifc.emf.Ifc2x3.IfcUnit;
import org.bimserver.ifc.emf.Ifc2x3.IfcUnitAssignment;
import org.bimserver.ifc.emf.Ifc2x3.IfcUnitEnum;
import org.bimserver.ifc.emf.Ifc2x3.IfcWall;
import org.bimserver.ifc.emf.Ifc2x3.IfcWallStandardCase;
import org.bimserver.ifc.emf.Ifc2x3.IfcWindow;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.ifcengine.FailSafeIfcEngine;
import org.bimserver.ifcengine.Geometry;
import org.bimserver.ifcengine.IfcEngineException;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.ifcengine.IfcEngineModel;
import org.bimserver.ifcengine.Instance;
import org.bimserver.ifcengine.IfcEngineJNA.InstanceVisualisationProperties;
import org.bimserver.shared.ResultType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColladaSerializer extends BimModelSerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ColladaSerializer.class);
	private final FailSafeIfcEngine ifcEngine;
	private final SchemaDefinition schemaDefinition;
	private final Map<String, Set<String>> converted = new HashMap<String, Set<String>>();
	private SimpleMode mode = SimpleMode.BUSY;
	private final Project project;
	private final User user;
	private final SIPrefix lengthUnitPrefix;
	private final PackageDefinition packageDefinition;

	public ColladaSerializer(Project project, User user, String fileName, IfcModel model, SchemaDefinition schemaDefinition, FieldIgnoreMap fieldIgnoreMap,
			IfcEngineFactory ifcEngineFactory, PackageDefinition packageDefinition) throws SerializerException {
		super(fileName, model, fieldIgnoreMap);
		this.project = project;
		this.user = user;
		this.schemaDefinition = schemaDefinition;
		this.packageDefinition = packageDefinition;
		try {
			this.ifcEngine = ifcEngineFactory.createFailSafeIfcEngine();
		} catch (IfcEngineException e) {
			throw new SerializerException(e);
		}
		lengthUnitPrefix = getLengthUnitPrefix(model);
	}

	@Override
	public int write(OutputStream out) {
		if (mode == SimpleMode.BUSY) {
			PrintWriter writer = new PrintWriter(out);
			try {
				writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>");
				writer
						.println("<COLLADA xmlns=\"http://www.collada.org/2005/11/COLLADASchema\" version=\"1.4.1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.collada.org/2005/11/COLLADASchema http://www.khronos.org/files/collada_schema_1_4\" >");

				writeAssets(writer);
				writeCameras(writer);
				writeLights(writer);
				writeMaterials(writer);
				writeEffects(writer);
				writeGeometries(writer);
				writeVisualScenes(writer);
				writeScene(writer);

				writer.print("</COLLADA>");
				writer.flush();
			} catch (Exception e) {
				LOGGER.error("", e);
			}
			writer.flush();
			mode = SimpleMode.DONE;
			ifcEngine.close();
			return 1;
		} else if (mode == SimpleMode.DONE) {
			return -1;
		}
		return -1;
	}

	private void writeAssets(PrintWriter out) {
		out.println("    <asset>");
		out.println("        <contributor>");
		out.println("            <author>" + user.getName() + "</author>");
		out.println("            <authoring_tool>BIMserver</authoring_tool>");
		out.println("            <comments>" + project.getDescription() + "</comments>");
		out.println("            <copyright>Copyright</copyright>");
		out.println("        </contributor>");
		out.println("        <created>2006-06-21T21:23:22Z</created>");
		out.println("        <modified>2006-06-21T21:23:22Z</modified>");

		// Ruben 23-09-2010 Why is this commented out? Can we throw it away?

		// double scale = Math.pow(10.0, project.getExportLengthMeasurePrefix()
		// .getValue());
		// out.println("        <unit meter=\"" + scale + "\" name=\""
		// + project.getExportLengthMeasurePrefix().name().toLowerCase()
		// + "\"/>");

		if (lengthUnitPrefix == null) {
			out.println("        <unit meter=\"1\" name=\"meter\"/>");
		} else {
			out.println("        <unit meter=\"" + Math.pow(10.0, lengthUnitPrefix.getValue()) + "\" name=\"" + lengthUnitPrefix.name().toLowerCase() + "\"/>");
		}
		out.println("        <up_axis>Y_UP</up_axis>");
		out.println("    </asset>");
	}

	private void writeGeometries(PrintWriter out) throws IfcEngineException {
		out.println("	<library_geometries>");
		IfcDatabase ifcDatabase = new IfcDatabase(model, null);

		if (packageDefinition.hasClassDefinition("IfcRoof")) {
			for (IfcRoof ifcRoof : ifcDatabase.getAll(IfcRoof.class)) {
				setGeometry(out, ifcRoof, ifcRoof.getGlobalId().getWrappedValue(), "Roof");
			}
		}

		// Ruben 29-10-2010 A long time ago this code made the IFCEngine crash,
		// should try to enable it again

		// for (IfcSpace ifcSpace : ifcDatabase.getAll(IfcSpace.class)) {
		// setGeometry(out, (IfcRootObject) ifcSpace,
		// ifcSpace.getGlobalId().getWrappedValue(), "Space");
		// }

		if (packageDefinition.hasClassDefinition("IfcSlab")) {
			for (IfcSlab ifcSlab : ifcDatabase.getAll(IfcSlab.class)) {
				if (ifcSlab.getPredefinedType() == IfcSlabTypeEnum.ROOF) {
					setGeometry(out, ifcSlab, ifcSlab.getGlobalId().getWrappedValue(), "Roof");
				} else {
					setGeometry(out, ifcSlab, ifcSlab.getGlobalId().getWrappedValue(), "Slab");
				}
			}
		}
		if (packageDefinition.hasClassDefinition("IfcWindow")) {
			for (IfcWindow ifcWindow : ifcDatabase.getAll(IfcWindow.class)) {
				setGeometry(out, ifcWindow, ifcWindow.getGlobalId().getWrappedValue(), "Window");
			}
		}
		if (packageDefinition.hasClassDefinition("IfcDoor")) {
			for (IfcDoor ifcDoor : ifcDatabase.getAll(IfcDoor.class)) {
				setGeometry(out, ifcDoor, ifcDoor.getGlobalId().getWrappedValue(), "Door");
			}
		}
		if (packageDefinition.hasClassDefinition("IfcWall")) {
			for (IfcWall ifcWall : ifcDatabase.getAll(IfcWall.class)) {
				setGeometry(out, ifcWall, ifcWall.getGlobalId().getWrappedValue(), "Wall");
			}
		}
		if (packageDefinition.hasClassDefinition("IfcStairFlight")) {
			for (IfcStairFlight ifcStairFlight : ifcDatabase.getAll(IfcStairFlight.class)) {
				setGeometry(out, ifcStairFlight, ifcStairFlight.getGlobalId().getWrappedValue(), "StairFlight");
			}
		}
		if (packageDefinition.hasClassDefinition("IfcFlowSegment")) {
			for (IfcFlowSegment ifcFlowSegment : ifcDatabase.getAll(IfcFlowSegment.class)) {
				setGeometry(out, ifcFlowSegment, ifcFlowSegment.getGlobalId().getWrappedValue(), "Railing");
			}
		}
		if (packageDefinition.hasClassDefinition("IfcFurnishingElement")) {
			for (IfcFurnishingElement ifcFurnishingElement : ifcDatabase.getAll(IfcFurnishingElement.class)) {
				setGeometry(out, ifcFurnishingElement, ifcFurnishingElement.getGlobalId().getWrappedValue(), "FurnishingElement");
			}
		}
		if (packageDefinition.hasClassDefinition("IfcPlate")) {
			for (IfcPlate ifcPlate : ifcDatabase.getAll(IfcPlate.class)) {
				setGeometry(out, ifcPlate, ifcPlate.getGlobalId().getWrappedValue(), "Wall");
			}
		}
		if (packageDefinition.hasClassDefinition("IfcMember")) {
			for (IfcMember ifcMember : ifcDatabase.getAll(IfcMember.class)) {
				setGeometry(out, ifcMember, ifcMember.getGlobalId().getWrappedValue(), "Member");
			}
		}
		if (packageDefinition.hasClassDefinition("IfcWallStandardCase")) {
			for (IfcWallStandardCase ifcWall : ifcDatabase.getAll(IfcWallStandardCase.class)) {
				setGeometry(out, ifcWall, ifcWall.getGlobalId().getWrappedValue(), "Wall");
			}
		}
		if (packageDefinition.hasClassDefinition("IfcCurtainWall")) {
			for (IfcCurtainWall ifcCurtainWall : ifcDatabase.getAll(IfcCurtainWall.class)) {
				setGeometry(out, ifcCurtainWall, ifcCurtainWall.getGlobalId().getWrappedValue(), "Window");
			}
		}
		if (packageDefinition.hasClassDefinition("IfcRailing")) {
			for (IfcRailing ifcRailing : ifcDatabase.getAll(IfcRailing.class)) {
				setGeometry(out, ifcRailing, ifcRailing.getGlobalId().getWrappedValue(), "Railing");
			}
		}
		if (packageDefinition.hasClassDefinition("IfcColumn")) {
			for (IfcColumn ifcColumn : ifcDatabase.getAll(IfcColumn.class)) {
				setGeometry(out, ifcColumn, ifcColumn.getGlobalId().getWrappedValue(), "Column");
			}
		}
		out.println("	</library_geometries>");
	}

	private void setGeometry(PrintWriter out, IdEObject ifcRootObject, String id, String material) throws IfcEngineException {
		id = id.replace('$', '-'); // XML QNAME may not contain a $ character.
		id = "_" + id; // XML QNAME may not start with a digit.

		if (!converted.containsKey(material)) {
			converted.put(material, new HashSet<String>());
		}
		converted.get(material).add(id);

		IfcModel ifcModel = new IfcModel();
		convertToSubset(ifcRootObject.eClass(), ifcRootObject, ifcModel, new HashMap<EObject, EObject>());
		IfcStepSerializer ifcSerializer = new IfcStepSerializer(project, user, "", ifcModel, schemaDefinition);
		try {
			IfcEngineModel model = ifcEngine.openModel(ifcSerializer.getBytes());
			try {
				model.setPostProcessing(true);
				Geometry geometry = model.finalizeModelling(model.initializeModelling());
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
					for (Instance instance : model.getInstances(ifcRootObject.eClass().getName().toUpperCase())) {
						InstanceVisualisationProperties instanceInModelling = instance.getVisualisationProperties();
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
		writeEffect(out, "Space", new float[] { 0.137255f, 0.403922f, 0.870588f });
		writeEffect(out, "Roof", new float[] { 0.837255f, 0.203922f, 0.270588f });
		writeEffect(out, "Slab", new float[] { 0.637255f, 0.603922f, 0.670588f });
		writeEffect(out, "Wall", new float[] { 0.537255f, 0.337255f, 0.237255f });
		writeEffect(out, "Door", new float[] { 0.637255f, 0.603922f, 0.670588f });
		writeEffect(out, "Window", new float[] { 0.2f, 0.2f, 0.8f });
		writeEffect(out, "Railing", new float[] { 0.137255f, 0.203922f, 0.270588f });
		writeEffect(out, "Column", new float[] { 0.437255f, 0.603922f, 0.370588f, });
		writeEffect(out, "FurnishingElement", new float[] { 0.437255f, 0.603922f, 0.370588f });
		out.println("    </library_effects>");
	}

	private void writeEffect(PrintWriter out, String name, float[] colors) {
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
		out.println("                            <color>" + colors[0] + " " + colors[1] + " " + colors[2] + " 1</color>");
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
		out.println("                            <color>0 0 0 1</color>");
		out.println("                        </transparent>");
		out.println("                        <transparency>");
		out.println("                            <float>1</float>");
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
		out.println("		<material id=\"FurnishingElement\" name=\"FurnishingElement\">");
		out.println("			<instance_effect url=\"#FurnishingElement-fx\"/>");
		out.println("		</material>");
		out.println("	</library_materials>");
	}

	@Override
	public String getContentType() {
		return ResultType.COLLADA.getContentType();
	}

	private static SIPrefix getLengthUnitPrefix(IfcModel model) {
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