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
import org.bimserver.models.ifc2x3.IfcRoot;
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
import org.bimserver.models.ifc2x3.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3.IfcSurfaceStyleRendering;
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
	
	/**
	 * Extents provides an axis-aligned bounding cuboid for geometric data, 
	 * represented as a pair of 3 dimensional vectors for the two opposing corners of the cuboid.
	 */
	private class Extents {
		public float[] min = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };
		public float[] max = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };
	}
	private Extents sceneExtents = new Extents();
	private Map<String, Extents> geometryExtents = new HashMap<String, Extents>();
	private Map<String, Set<String>> materialGeometryRel = new HashMap<String, Set<String>>();
	private List<String> surfaceStyleIds;
	
	/** 
	 * JsWriter adds automatic indentation to the PrintWriter 
	 */ 
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
				// Pre-calculate information for use during the export
				calculateGeometryExtents();
				
				// Write data to stream
				writer.writeln("/* Author:      " + getProjectInfo().getAuthorName());
				writer.writeln("   Description: " + getProjectInfo().getDescription());
				writer.writeln("*/");
				
				writer.writeln("SceneJS.createScene({");
				writer.indent();
				writer.writeln("type: 'scene',");
				writer.writeln("id: 'Scene',");
				writer.writeln("canvasId: 'scenejsCanvas',");
				writer.writeln("loggingElementId: 'scenejsLog',");
				writer.writeln("flags: {");
				writer.indent();
				writer.writeln("backfaces: false,");
				writer.unindent();
				writer.writeln("},"); // flags
				
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
				writer.writeln("},"); // library

				writeVisualScenes(writer);

				writer.unindent();
				writer.writeln("],");
				
				// Append additional custom data to the scene node
				writer.writeln("data: {");
				writer.indent();
				writer.writeln("extents: [[" 
						+ sceneExtents.min[0] + "," + sceneExtents.min[1] + "," + sceneExtents.min[2] + "],["
						+ sceneExtents.max[0] + "," + sceneExtents.max[1] + "," + sceneExtents.max[2] + "]],");
				writer.unindent();
				
				/*if (lengthUnitPrefix == null) {
					writer.writeln("   Unit: 1 meter");
				} else {
					writer.writeln("   Unit: " + Math.pow(10.0, lengthUnitPrefix.getValue()) + " " + lengthUnitPrefix.name().toLowerCase());
				}*/
				writer.writeln("},");

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

	private void writeMaterials(JsWriter writer) {
		
		writeMaterial(writer, "Space", new float[] { 0.137255f, 0.403922f, 0.870588f }, 1.0f);
		writeMaterial(writer, "Roof", new float[] { 0.837255f, 0.203922f, 0.270588f }, 1.0f);
		writeMaterial(writer, "Slab", new float[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeMaterial(writer, "Wall", new float[] { 0.537255f, 0.337255f, 0.237255f }, 1.0f);
		writeMaterial(writer, "Door", new float[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeMaterial(writer, "Window", new float[] { 0.2f, 0.2f, 0.8f }, 0.2f);
		writeMaterial(writer, "Railing", new float[] { 0.137255f, 0.203922f, 0.270588f }, 1.0f);
		writeMaterial(writer, "Column", new float[] { 0.437255f, 0.603922f, 0.370588f, }, 1.0f);
		writeMaterial(writer, "FurnishingElement", new float[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f);
		writeMaterial(writer, "CurtainWall", new float[] { 0.5f, 0.5f, 0.5f }, 0.5f);
		writeMaterial(writer, "Stair", new float[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
		writeMaterial(writer, "BuildingElementProxy", new float[] { 0.5f, 0.5f, 0.5f }, 1.0f);
		writeMaterial(writer, "FlowSegment", new float[] { 0.6f, 0.4f, 0.5f }, 1.0f);

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
					if(!surfaceStyleIds.contains(name)) {
						surfaceStyleIds.add(name);
						writeMaterial(writer, name, new float[] { colour.getRed(), colour.getGreen(), colour.getBlue() }, (ssr.isSetTransparency() ? (ssr.getTransparency()) : 1.0f));
						break;
					}					
				}
			}
		}
	}
	
	private void writeMaterial(JsWriter writer, String name, float[] colors, float opacity) {
		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'material',");
		writer.writeln("coreId: '" + name + "Material',");
		writer.writeln("baseColor: {");
		writer.indent();
		writer.writeln("r: " + colors[0] + ",");
		writer.writeln("g: " + colors[1] + ",");
		writer.writeln("b: " + colors[2] + ",");
		writer.unindent();
		writer.writeln("},");
        writer.writeln("alpha: " + opacity + ",");
        writer.writeln("emit: 0.0,");
		writer.unindent();
		writer.writeln("},");
	}

	private void calculateGeometryExtents() throws IfcEngineException, SerializerException {
		// TODO: Please review (is there a simpler way to fetch geometric objects?)
		for (IfcRoof ifcRoof : model.getAll(IfcRoof.class)) {
			calculateExtents(ifcRoof.getGlobalId().getWrappedValue(), ifcRoof);
		}
		for (IfcSlab ifcSlab : model.getAll(IfcSlab.class)) {
			calculateExtents(ifcSlab.getGlobalId().getWrappedValue(), ifcSlab);
		}
		for (IfcWindow ifcWindow : model.getAll(IfcWindow.class)) {
			calculateExtents(ifcWindow.getGlobalId().getWrappedValue(), ifcWindow);
		}
		for (IfcDoor ifcDoor : model.getAll(IfcDoor.class)) {
			calculateExtents(ifcDoor.getGlobalId().getWrappedValue(), ifcDoor);
		}
		for (IfcWall ifcWall : model.getAll(IfcWall.class)) {
			calculateExtents(ifcWall.getGlobalId().getWrappedValue(), ifcWall);
		}
		for (IfcStair ifcStair : model.getAll(IfcStair.class)) {
			calculateExtents(ifcStair.getGlobalId().getWrappedValue(), ifcStair);
		}
		for (IfcStairFlight ifcStairFlight : model.getAll(IfcStairFlight.class)) {
			calculateExtents(ifcStairFlight.getGlobalId().getWrappedValue(), ifcStairFlight);
		}
		for (IfcFlowSegment ifcFlowSegment : model.getAll(IfcFlowSegment.class)) {
			calculateExtents(ifcFlowSegment.getGlobalId().getWrappedValue(), ifcFlowSegment);
		}
		for (IfcFurnishingElement ifcFurnishingElement : model.getAll(IfcFurnishingElement.class)) {
			calculateExtents(ifcFurnishingElement.getGlobalId().getWrappedValue(), ifcFurnishingElement);
		}
		for (IfcPlate ifcPlate : model.getAll(IfcPlate.class)) {
			calculateExtents(ifcPlate.getGlobalId().getWrappedValue(), ifcPlate);
		}
		for (IfcMember ifcMember : model.getAll(IfcMember.class)) {
			calculateExtents(ifcMember.getGlobalId().getWrappedValue(), ifcMember);
		}
		for (IfcWallStandardCase ifcWall : model.getAll(IfcWallStandardCase.class)) {
			calculateExtents(ifcWall.getGlobalId().getWrappedValue(), ifcWall);
		}
		for (IfcCurtainWall ifcCurtainWall : model.getAll(IfcCurtainWall.class)) {
			calculateExtents(ifcCurtainWall.getGlobalId().getWrappedValue(), ifcCurtainWall);
		}
		for (IfcRailing ifcRailing : model.getAll(IfcRailing.class)) {
			calculateExtents(ifcRailing.getGlobalId().getWrappedValue(), ifcRailing);
		}
		for (IfcColumn ifcColumn : model.getAll(IfcColumn.class)) {
			calculateExtents(ifcColumn.getGlobalId().getWrappedValue(), ifcColumn);
		}
		for (IfcBuildingElementProxy ifcBuildingElementProxy : model.getAll(IfcBuildingElementProxy.class)) {
			calculateExtents(ifcBuildingElementProxy.getGlobalId().getWrappedValue(), ifcBuildingElementProxy);
		}
	}
	
	private void calculateExtents(String id, IdEObject ifcRootObject) throws IfcEngineException, SerializerException {
		// Get the extents object related to this geometric object 
		if (!geometryExtents.containsKey(id)) {
			geometryExtents.put(id, new Extents());
		}
		Extents extents = geometryExtents.get(id);
		
		// Create a geometric model to for calculating the extents of the object 
		IfcModelInterface ifcModel = new IfcModel();
		convertToSubset(ifcRootObject.eClass(), ifcRootObject, ifcModel, new HashMap<EObject, EObject>());
		EmfSerializer serializer = getPluginManager().requireIfcStepSerializer();
		serializer.init(ifcModel, getProjectInfo(), getPluginManager());
		try {
			IfcEngineModel model = ifcEngine.openModel(serializer.getBytes());
			try {
				model.setPostProcessing(true); // TODO: Please review - what does setPostProcessing do?
				IfcEngineGeometry geometry = model.finalizeModelling(model.initializeModelling());
				if (geometry != null) {
					for (int i = 0; i < geometry.getNrVertices(); i += 3) {
						// Use the vertex to calculate the boundaries of the geometric object
						addToExtents(extents, new float[] { geometry.getVertex(i + 0), geometry.getVertex(i + 1), geometry.getVertex(i + 2) });	
					}
				}
			}
			finally {
				model.close();
			}
		} catch (IfcEngineException e) {
			throw e;
		} //catch (Exception e) {
		//}
		
		// Add the object's extents to the scene's total extents
		addToExtents(sceneExtents, extents.min);
		addToExtents(sceneExtents, extents.max);
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
		if (!materialGeometryRel.containsKey(material)) {
			materialGeometryRel.put(material, new HashSet<String>());
		}
		materialGeometryRel.get(material).add(id);
		
		// Serialize the geometric data itself
		writeGeometry(writer, ifcRootObject, id);
	}
	
	private void writeGeometry(JsWriter writer, IdEObject ifcRootObject, String id) throws IfcEngineException, SerializerException {
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
					for (int i = 0; i < geometry.getNrVertices(); i += 3) {
						// Use the vertex to calculate the bounds of the model
						//addToExtents(new float[] { geometry.getVertex(i + 0), geometry.getVertex(i + 1), geometry.getVertex(i + 2) });
						
						// Write the vertex to output
						writer.print(geometry.getVertex(i + 0) + "," + geometry.getVertex(i + 1) + "," + geometry.getVertex(i + 2) + ",");
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
		// Calculate the maximum ray length through the scene (using the two extreme points of the scene's bounding box)
		float[] extentsDiff = new float[]{ sceneExtents.max[0] - sceneExtents.min[0], sceneExtents.max[1] - sceneExtents.min[1], sceneExtents.max[2] - sceneExtents.min[2] };
		float extentsDiffLength = (float) Math.sqrt((double)(extentsDiff[0]*extentsDiff[0] + extentsDiff[1]*extentsDiff[1] + extentsDiff[2]*extentsDiff[2]));
		
		// Write the nodes to the stream
		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'lookAt',");
		
		writer.writeln("eye: {");
		writer.indent();
		writer.writeln("x: " + (-extentsDiff[0] * 0.5f) + ",");
		writer.writeln("y: " + (extentsDiff[1] * 0.5f) + ",");
		writer.writeln("z: " + (extentsDiff[2] * 0.5f) + ",");
		writer.unindent();
		writer.writeln("},"); // eye
		
		writer.writeln("look: {");
		writer.indent();
		writer.writeln("x: 0.0,");
		writer.writeln("y: 0.0,");
		writer.writeln("z: 0.0,");
		writer.unindent();
		writer.writeln("},"); // look
		
		writer.writeln("up: {");
		writer.indent();
		writer.writeln("x: 0.0,");
		writer.writeln("y: 1.0,");
		writer.writeln("z: 0.0,");
		writer.unindent();
		writer.writeln("},"); // up
		
		writer.writeln("nodes: [");
		writer.indent();
		writer.writeln("{");
		writer.indent();
		
		writer.writeln("type: 'camera',");
		writer.writeln("optics: {");
		writer.indent();
		writer.writeln("type: 'perspective',");
		writer.writeln("far: " + (extentsDiffLength * 2) + ",");
		writer.writeln("near: " + (extentsDiffLength * 0.001f) + ",");
		writer.writeln("aspect: 1.0,");
		writer.writeln("fovy: 27.6380627952,");
		//writer.writeln("fovy: 37.8493,");
        writer.unindent();
		writer.writeln("},"); // optics

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
		writer.writeln("},"); // clear
        
        writer.writeln("clearColor: {");
		writer.indent();
		writer.writeln("r: 0.0,"); 
		writer.writeln("g: 0.0,"); 
		writer.writeln("b: 0.0,");
		writer.writeln("a: 0.0,");
        writer.unindent();
		writer.writeln("},"); // clearColor 
        
		writer.writeln("nodes: [");
		writer.indent();
		
		// Add a simple light to the scene 
		writer.writeln("{");
		writer.indent();
		writer.writeln("type: 'light',");
		writer.writeln("id: 'sunlight',");
		writer.writeln("mode: 'dir',");
		
		writer.writeln("color: {");
		writer.indent();
		writer.writeln("r: 1.0,"); 
		writer.writeln("g: 1.0,"); 
		writer.writeln("b: 1.0,");
		writer.unindent();
        writer.writeln("},"); // color
        
        writer.writeln("dir: {");
		writer.indent();
		writer.writeln("x: 0.3,"); 
		writer.writeln("y:-1.0,"); 
		writer.writeln("z: 0.3,");
        writer.unindent();
		writer.writeln("},"); // dir
		writer.writeln("diffuse: true,");
		writer.writeln("specular: true,");
        writer.unindent();
		writer.writeln("},"); // light
	
		// Output each geometry instance grouped by material
		for (String materialId : materialGeometryRel.keySet()) {
			writer.writeln("{");
			writer.indent();
			
			writer.writeln("type: 'material',");
			writer.writeln("coreId: '" + materialId + "Material',");
			
			Set<String> geometryIds = materialGeometryRel.get(materialId);
			
			writer.writeln("nodes: [");
			writer.indent();
			for (String geometryId : geometryIds) {
				writer.writeln("{");
				writer.indent();
				
				writer.writeln("type: 'geometry',");
				writer.writeln("coreId: '" + geometryId + "',");
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
	
	private void addToExtents(Extents extents, float[] vertex) {
		//if (!materialGeometryRel.containsKey(material)) {
		//	materialGeometryRel.put(material, new Extents);
		//}
		//materialGeometryRel.get(material).add(id);
		// geometryExtents.
		extents.min[0] = Math.min(vertex[0], extents.min[0]);
		extents.min[1] = Math.min(vertex[1], extents.min[1]);
		extents.min[2] = Math.min(vertex[2], extents.min[2]);
		extents.max[0] = Math.max(vertex[0], extents.max[0]);
		extents.max[1] = Math.max(vertex[1], extents.max[1]);
		extents.max[2] = Math.max(vertex[2], extents.max[2]);
	}
}
