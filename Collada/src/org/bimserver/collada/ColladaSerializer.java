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
import java.nio.ByteOrder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcBuildingElementProxy;
import org.bimserver.models.ifc2x3tc1.IfcColumn;
import org.bimserver.models.ifc2x3tc1.IfcCurtainWall;
import org.bimserver.models.ifc2x3tc1.IfcDoor;
import org.bimserver.models.ifc2x3tc1.IfcFeatureElementSubtraction;
import org.bimserver.models.ifc2x3tc1.IfcFlowFitting;
import org.bimserver.models.ifc2x3tc1.IfcFlowSegment;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcMember;
import org.bimserver.models.ifc2x3tc1.IfcPlate;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRailing;
import org.bimserver.models.ifc2x3tc1.IfcRoof;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcStair;
import org.bimserver.models.ifc2x3tc1.IfcStairFlight;
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
import org.openmali.vecmath2.Vector3d;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColladaSerializer extends AbstractGeometrySerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ColladaSerializer.class);
	// Prepare a transformer for floating-point numbers into a strings, clipping extraneous zeros.
	static final DecimalFormat decimalFormat = new DecimalFormat("#.###############");
	// Prepare a transformer for integers into strings.
	static final DecimalFormat intFormat = new DecimalFormat("#");
	// Provide a date formatter.
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");

	// Boundaries of geometry. Not necessarily used.
	private Vector3d lowestObserved = new Vector3d();
	private Vector3d highestObserved = new Vector3d();
	// Materials for converting a general class or a specific IfcProduct into a material (where an IfcProduct has a surface style).
	private ConvertorsKeyedCollection convertors = new ConvertorsKeyedCollection();
	private Map<IfcProduct, String> materialCalls = new HashMap<IfcProduct, String>();
	// Unit name.
	private SIPrefix lengthUnitPrefix;
	// Do not bother to configure the serializer if it's only being used by its parent plugin.
	public ColladaConfiguration configuration = null;

	public ColladaSerializer() {
		// WARN: Do not configure here, since "model" is not initialized at this point. Use the init method.
		// Add default convertors. More specific IfcProduct convertors may be created in the process of parsing IfcProduct objects. Only the materials that are used will be put in the Collada file. 
		convertors.add(new Convertor(IfcRoof.class, new double[] { 0.837255f, 0.203922f, 0.270588f }, 1.0f));
		convertors.add(new Convertor(IfcSlab.class, new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f));
		convertors.add(new Convertor(IfcWindow.class, new double[] { 0.2f, 0.2f, 0.8f }, 0.5f));
		convertors.add(new Convertor(IfcSpace.class, new double[] { 0.5f, 0.4f, 0.1f }, 0.05f));
		convertors.add(new Convertor(IfcDoor.class, new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f));
		convertors.add(new Convertor(IfcStair.class, new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f));
		convertors.add(new Convertor(IfcStairFlight.class, new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f));
		convertors.add(new Convertor(IfcFlowSegment.class, new double[] { 0.6f, 0.4f, 0.5f }, 1.0f));
		convertors.add(new Convertor(IfcFurnishingElement.class, new double[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f));
		convertors.add(new Convertor(IfcPlate.class, new double[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f));
		convertors.add(new Convertor(IfcMember.class, new double[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f));
		convertors.add(new Convertor(IfcWallStandardCase.class, new double[] { 0.537255f, 0.337255f, 0.237255f }, 1.0f));
		convertors.add(new Convertor(IfcWall.class, new double[] { 0.537255f, 0.337255f, 0.237255f }, 1.0f));
		convertors.add(new Convertor(IfcCurtainWall.class, new double[] { 0.5f, 0.5f, 0.5f }, 0.5f));
		convertors.add(new Convertor(IfcRailing.class, new double[] { 0.137255f, 0.203922f, 0.270588f }, 1.0f));
		convertors.add(new Convertor(IfcColumn.class, new double[] { 0.437255f, 0.603922f, 0.370588f, }, 1.0f));
		convertors.add(new Convertor(IfcBuildingElementProxy.class, new double[] { 0.5f, 0.5f, 0.5f }, 1.0f));
		convertors.add(new Convertor(IfcFlowFitting.class, new double[] { 0.7215686274509804f, 0.45098039215686275f, 0.2f }, 1.0f));
		convertors.add(new Convertor(IfcProduct.class, new double[] { 0.5f, 0.5f, 0.5f }, 1.0f));
	}

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin, PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException {
		this.lengthUnitPrefix = SupportFunctions.getLengthUnitPrefix(model);
		super.init(model, projectInfo, pluginManager, renderEnginePlugin, packageMetaData, normalizeOids);
		// Configure to export all objects.
		configuration = new ColladaConfiguration(model.getAllWithSubTypes(IfcProduct.class));
	}

	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin, PackageMetaData packageMetaData, boolean normalizeOids, ColladaConfiguration configuration) throws SerializerException {
		this.lengthUnitPrefix = SupportFunctions.getLengthUnitPrefix(model);
		super.init(model, projectInfo, pluginManager, renderEnginePlugin, packageMetaData, normalizeOids);
		// Honor whatever configuration comes in, except if it's null.
		this.configuration = (configuration != null)? configuration : new ColladaConfiguration(model.getAllWithSubTypes(IfcProduct.class));
	}

	@Override
	public void reset() {
		setMode(Mode.BODY);
		resetMaterialCalls();
	}

	public void resetMaterialCalls() {
		// Basically, remove all products from the purview of the serializer's write feature.
		materialCalls = new HashMap<IfcProduct, String>();
	}

	@Override
	public boolean write(OutputStream out) throws SerializerException {
		if (getMode() == Mode.BODY) {
			boolean exportCameras = configuration.wantCameras;
			boolean exportLights = configuration.wantLights;
			boolean exportGeometry = configuration.wantGeometry;
			// Figure out what materials will need to be generated.
			if (exportGeometry) {
				try {
					determineAllMaterialRequests();
				} catch (RenderEngineException e1) {
					e1.printStackTrace();
				}
			}
			// Figure out where the boundaries are, so the camera and light can be made.
			if (exportCameras || exportLights) {
				try {
					observeAllBoundaries();
				} catch (RenderEngineException e1) {
					e1.printStackTrace();
				}
			}
			//
			PrintWriter writer = new UTF8PrintWriter(out);
			try {
				writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				writer.println("<COLLADA xmlns=\"http://www.collada.org/2008/03/COLLADASchema\" version=\"1.5.0\">");
				// Write assets, which includes units and coordinate system.
				writeAssets(writer);
				// Write or ignore camera definition.
				if (exportCameras)
					writeCameras(writer);
				else
					writeEmptyCameras(writer);
				// Write or ignore light definition.
				if (exportLights)
					writeLights(writer);
				else
					writeEmptyLights(writer);
				// Write or ignore geometry-related definitions.
				if (exportGeometry) {
					writeEffects(writer);
					writeMaterials(writer);
					writeGeometries(writer);
				}
				else {
					writeEmptyEffects(writer);
					writeEmptyMaterials(writer);
					writeEmptyGeometries(writer);
				}
				//
				writeVisualScenes(writer);
				writeScene(writer);
				// End of root section.
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
		// Produce a date based on now.
		String date = dateFormat.format(new Date());
		// Determine what a meter is and what to logically refer to that transformation as.
		Number unitMeter = (lengthUnitPrefix == null) ? 1 : Math.pow(10.0, lengthUnitPrefix.getValue());
		String unitName = (lengthUnitPrefix == null) ? "meter" : lengthUnitPrefix.name().toLowerCase();
		// Write the asset block.
		out.println(" <asset>");
		out.println("  <contributor>");
		out.println("   <author>" + (getProjectInfo() == null ? "" : getProjectInfo().getAuthorName()) + "</author>");
		out.println("   <authoring_tool>BIMserver</authoring_tool>");
		out.println("   <comments>" + (getProjectInfo() == null ? "" : getProjectInfo().getDescription()) + "</comments>");
		out.println("   <copyright>Copyright</copyright>");
		out.println("  </contributor>");
		out.println("  <created>" + date + "</created>");
		out.println("  <modified>" + date + "</modified>");
		out.println("  <unit meter=\"" + unitMeter + "\" name=\"" + unitName + "\"/>");
		out.println("  <up_axis>Z_UP</up_axis>");
		out.println(" </asset>");
	}

	private void determineAllMaterialRequests() throws RenderEngineException, SerializerException {
		// Prepare storage to check against to make sure the same object doesn't go out more than once.
		Set<IfcProduct> convertedObjects = new HashSet<IfcProduct>();
		// For each IfcProduct, get the geometry for each object in the product.
		for (IfcProduct ifcProduct : configuration.exportedObjects) {
			// If the current object has not already been written, write it out.
			if (!convertedObjects.contains(ifcProduct)) {
				convertedObjects.add(ifcProduct);
				// Get the material out of the IfcProduct (may be a default material, as specified in the this serializer's constructor). 
				determineMaterialRequest(ifcProduct);
			}
		}
	}

	private void determineMaterialRequest(IfcProduct ifcProduct) throws RenderEngineException, SerializerException {
		// Mostly just skips IfcOpeningElements which one would probably not want to end up in the Collada file.
		if (ifcProduct instanceof IfcFeatureElementSubtraction)
			return;
		//
		GeometryInfo geometryInfo = ifcProduct.getGeometry();
		if (geometryInfo != null) {
			// Get the default material name in the form of: IfcWindow, IfcDoor, etc. For only default materials, use: convertors.getValidDefaultMaterialName(ifcProduct);
			String materialName = getMaterialNameForIfcProduct(ifcProduct);
			// For this IfcProduct, call the material name.
			materialCalls.put(ifcProduct, materialName);
		}
	}

	private void observeAllBoundaries() throws RenderEngineException, SerializerException {
		// Prepare storage to check against to make sure the same object doesn't go out more than once.
		Set<IfcProduct> convertedObjects = new HashSet<IfcProduct>();
		// For each IfcProduct, get the geometry for each object in the product.
		for (IfcProduct ifcProduct : configuration.exportedObjects) {
			// If the current object has not already been written, write it out.
			if (!convertedObjects.contains(ifcProduct)) {
				convertedObjects.add(ifcProduct);
				// Observe the boundaries of the geometry, pushing maximum/minimum values as observed. 
				observeBoundaries(ifcProduct);
			}
		}
	}

	private void observeBoundaries(IfcProduct ifcProduct) throws RenderEngineException, SerializerException {
		// Mostly just skips IfcOpeningElements which one would probably not want to end up in the Collada file.
		if (ifcProduct instanceof IfcFeatureElementSubtraction)
			return;
		// Get the geometry info from the IFC product.
		GeometryInfo geometryInfo = ifcProduct.getGeometry();
		if (geometryInfo != null) {
			// Get the actual data out of the geometry information.
			GeometryData geometryData = geometryInfo.getData();
			// Positions the X or the Y or the Z of (X, Y, Z).
			ByteBuffer positionsBuffer = ByteBuffer.wrap(geometryData.getVertices());
			positionsBuffer.order(ByteOrder.LITTLE_ENDIAN);
			// Do pass to find highest Z for considered objects.
			while (positionsBuffer.hasRemaining())
			{
				float x = positionsBuffer.getFloat();
				float y = positionsBuffer.getFloat();
				float z = positionsBuffer.getFloat();
				// X
				if (x > highestObserved.x())
					highestObserved.x(x);
				else if (x < lowestObserved.x())
					lowestObserved.x(x);
				// Y
				if (y > highestObserved.y())
					highestObserved.y(y);
				else if (y < lowestObserved.y())
					lowestObserved.y(y);
				// Z
				if (z > highestObserved.z())
					highestObserved.z(z);
				else if (z < lowestObserved.z())
					lowestObserved.z(z);
			}
			positionsBuffer.rewind();
		}
	}

	private void writeEmptyGeometries(PrintWriter out) throws RenderEngineException, SerializerException {
		// Open and close the section.
		out.println(" <library_geometries/>");
	}

	private void writeGeometries(PrintWriter out) throws RenderEngineException, SerializerException {
		// Prepare the section.
		out.println(" <library_geometries>");
		// Prepare storage to check against to make sure the same object doesn't go out more than once.
		Set<IfcProduct> convertedObjects = new HashSet<IfcProduct>();
		// For each IfcProduct, get the geometry for each object in the product.
		for (IfcProduct ifcProduct : configuration.exportedObjects) {
			// If the current object has not already been written, write it out.
			if (!convertedObjects.contains(ifcProduct)) {
				convertedObjects.add(ifcProduct);
				// Print out the geometry, and push the material to IfcProduct relationship. 
				setGeometry(out, ifcProduct);
			}
		}
		// Close the section.
		out.println(" </library_geometries>");
	}

	private void setGeometry(PrintWriter out, IfcProduct ifcProduct) throws RenderEngineException, SerializerException {
		// Mostly just skips IfcOpeningElements which one would probably not want to end up in the Collada file.
		if (ifcProduct instanceof IfcFeatureElementSubtraction)
			return;
		// Get the geometry info from the IFC product.
		GeometryInfo geometryInfo = ifcProduct.getGeometry();
		if (geometryInfo != null) {
			// Get the actual data out of the geometry information.
			GeometryData geometryData = geometryInfo.getData();
			// Positions the X or the Y or the Z of (X, Y, Z).
			ByteBuffer positionsBuffer = ByteBuffer.wrap(geometryData.getVertices());
			positionsBuffer.order(ByteOrder.LITTLE_ENDIAN);
			// Get the positions into a list for transmission.
			List<Float> positionsList = new ArrayList<Float>();
			while (positionsBuffer.hasRemaining())
				positionsList.add(positionsBuffer.getFloat());
			positionsBuffer.rewind();
			// Get the indices.
			ByteBuffer indicesBuffer = ByteBuffer.wrap(geometryData.getIndices());
			indicesBuffer.order(ByteOrder.LITTLE_ENDIAN);
			// Get the indices into a list for transmission.
			List<Integer> vertexIndexList = new ArrayList<Integer>();
			while (indicesBuffer.hasRemaining())
				vertexIndexList.add(indicesBuffer.getInt());
			indicesBuffer.rewind();
			// Create a normals buffer.
			ByteBuffer normalsBuffer = ByteBuffer.wrap(geometryData.getNormals());
			normalsBuffer.order(ByteOrder.LITTLE_ENDIAN);
			// Get the normals into a list for transmission.
			List<Float> normalsList = new ArrayList<Float>();
			while (normalsBuffer.hasRemaining())
				normalsList.add(normalsBuffer.getFloat());
			normalsBuffer.rewind();
			// Create storage for the actual vertices that will be used without losing the storage for the default order.
			List<Integer> actualIndices = new ArrayList<Integer>();
			// Best general output. Other options generally look terrible.
			reorderTriangleWinding(positionsList, vertexIndexList, actualIndices);
			// Option if normals can be uniformly trusted (unlikely).
			//makeTrianglesPointToProvidedNormals(positionsList, vertexIndexList, initialNormalsList, normalsList, actualIndices);
			// Create a geometry identification number in the form of: geom-320450
			long oid = ifcProduct.getOid();
			String id = String.format("geom-%d", oid);
			// Name for geometry.
			String name = (ifcProduct.getGlobalId() == null) ? "[NO_GUID]" : ifcProduct.getGlobalId();
			// Counts.
			int vertexComponentsTotal = positionsList.size(), normalComponentsTotal = normalsList.size();
			int verticesCount = vertexComponentsTotal / 3, normalsCount = normalComponentsTotal / 3, triangleCount = vertexIndexList.size() / 3;
			// Vertex scalars as one long string: 4.05 2 1 55.0 34.01 2
			//String stringPositionScalars = SupportFunctions.byteBufferToFloatingPointSpaceDelimitedString(positionsBuffer);
			String stringPositionScalars = SupportFunctions.listToSpaceDelimitedString(positionsList, decimalFormat);
			// Normal scalars as one long string: 4.05 2 1 55.0 34.01 2
			String stringNormalScalars = SupportFunctions.listToSpaceDelimitedString(normalsList, decimalFormat);
			//String stringNormalScalars = SupportFunctions.byteBufferToFloatingPointSpaceDelimitedString(normalsBuffer);
			// Vertex indices as one long string: 1 0 2 0 3 2 5 4 6
			String stringIndexScalars = SupportFunctions.listToSpaceDelimitedString(actualIndices, intFormat);
			// Write geometry block for this IfcProduct (i.e. IfcRoof, IfcSlab, etc).
			out.println(" <geometry id=\"" + id + "\" name=\"" + name + "\">");
			out.println("  <mesh>");
			out.println("   <source id=\"positions-" + oid + "\" name=\"positions-" + oid + "\">");
			out.println("    <float_array id=\"positions-array-" + oid + "\" count=\"" + vertexComponentsTotal + "\">" + stringPositionScalars + "</float_array>");
			out.println("    <technique_common>");
			out.println("     <accessor count=\"" + verticesCount + "\" offset=\"0\" source=\"#positions-array-" + oid + "\" stride=\"3\">");
			out.println("      <param name=\"X\" type=\"float\"></param>");
			out.println("      <param name=\"Y\" type=\"float\"></param>");
			out.println("      <param name=\"Z\" type=\"float\"></param>");
			out.println("     </accessor>");
			out.println("    </technique_common>");
			out.println("   </source>");
			out.println("   <source id=\"normals-" + oid + "\" name=\"normals-" + oid + "\">");
			out.println("    <float_array id=\"normals-array-" + oid + "\" count=\"" + normalComponentsTotal + "\">" + stringNormalScalars + "</float_array>");
			out.println("    <technique_common>");
			out.println("     <accessor count=\"" + normalsCount + "\" offset=\"0\" source=\"#normals-array-" + oid + "\" stride=\"3\">");
			out.println("      <param name=\"X\" type=\"float\"></param>");
			out.println("      <param name=\"Y\" type=\"float\"></param>");
			out.println("      <param name=\"Z\" type=\"float\"></param>");
			out.println("     </accessor>");
			out.println("    </technique_common>");
			out.println("   </source>");
			out.println("   <vertices id=\"vertices-" + oid + "\">");
			out.println("    <input semantic=\"POSITION\" source=\"#positions-" + oid + "\"/>");
			out.println("    <input semantic=\"NORMAL\" source=\"#normals-" + oid + "\"/>");
			out.println("   </vertices>");
			out.println("   <triangles count=\"" + triangleCount + "\" material=\"Material-" + oid + "\">");
			out.println("    <input offset=\"0\" semantic=\"VERTEX\" source=\"#vertices-" + oid + "\"/>");
			out.println("    <p>" + stringIndexScalars + "</p>");
			out.println("   </triangles>");
			out.println("  </mesh>");
			out.println(" </geometry>");
		}
	}

	private void reorderTriangleWinding(List<Float> positionsList, List<Integer> vertexIndexList, List<Integer> actualIndices) {
		// Pass through the data, rewriting it to be in the winding order that would match the provided normal (which will not be respected in an actual 3D space without a matching winding order; the actual provided normal probably isn't uniformly correct, either).
		int sizeAtStart = vertexIndexList.size();
		for (int i = 0; i < sizeAtStart; i += 3)
		{
			Integer first = getIndexNumber(i, vertexIndexList);
			Integer next = getIndexNumber(i + 1, vertexIndexList);
			Integer last = getIndexNumber(i + 2, vertexIndexList);
			//
			actualIndices.add(next);
			actualIndices.add(first);
			actualIndices.add(last);
		}
	}

	private Integer getIndexNumber(int i, List<Integer> vertices) {
		return vertices.get(i);
	}

	private void writeScene(PrintWriter out) {
		out.println(" <scene>");
		out.println("  <instance_visual_scene url=\"#VisualSceneNode\"/>");
		out.println(" </scene>");
	}

	private void writeVisualScenes(PrintWriter out) {
		// Open the section.
		out.println(" <library_visual_scenes>");
		out.println("  <visual_scene id=\"VisualSceneNode\" name=\"VisualSceneNode\">");
		// Write each IFC object as a node entry (maps to a displayed object). Will be empty if configuration.wantGeometry is false.
		for (Entry<IfcProduct, String> entry : materialCalls.entrySet())
		{
			IfcProduct ifcProduct = entry.getKey();
			String materialName = entry.getValue();
			GeometryInfo geometryInfo = ifcProduct.getGeometry();
			if (geometryInfo != null && geometryInfo.getTransformation() != null) {
				out.println("   <node id=\"node-" + ifcProduct.getOid() + "\" name=\"node-" + ifcProduct.getOid() + "\">");
				SupportFunctions.printMatrix(out, geometryInfo);
				out.println("    <instance_geometry url=\"#geom-" + ifcProduct.getOid() + "\">");
				out.println("     <bind_material>");
				out.println("      <technique_common>");
				out.println("       <instance_material symbol=\"Material-" + ifcProduct.getOid() + "\" target=\"#" + materialName + "Material\"/>");
				out.println("      </technique_common>");
				out.println("     </bind_material>");
				out.println("    </instance_geometry>");
				out.println("   </node>");
			}
		}
		// Write cameras and lights.
		if (configuration.wantCameras || configuration.wantLights) {
			// Create convenience variables to simplify the perceived complexity of the equations.
			float lx = (float) lowestObserved.x(), ly = (float) lowestObserved.y();
			float hx = (float) highestObserved.x(), hy = (float) highestObserved.y(), hz = (float) highestObserved.z();
			// Derive useful information from the observed boundary of the IFC objects.
			Vector3d delta = new Vector3d(hx, hy, hz);
			delta.sub(lowestObserved);
			// Move the light left (-x) and back (-y) and up (+z) at 20% of the size of the observed objects. 
			Vector3d leftLightLocation = new Vector3d(lx - (0.2 * delta.x()), ly - (0.2 * delta.y()), hz + (0.2 * delta.z()));
			float x = (float) leftLightLocation.x(), y = (float) leftLightLocation.y(), z = (float) leftLightLocation.z();
			// Move left (-x) and back (-y) at 500% and up (+z) at 200% of the light (so that the objects are in sensing range of the camera). 
			Vector3d leftCameraLocation = new Vector3d(x, y, z);
			float cx = (float) leftCameraLocation.x(), cy = (float) leftCameraLocation.y(), cz = (float) leftCameraLocation.z();
			// Include the camera.
			if (configuration.wantCameras) {
				out.println("   <node id=\"Camera\" name=\"Camera\">");
				out.println("    <translate>"+ cx + " " + cy + " " + cz + "</translate>");
				out.println("    <rotate>"+ 0f + " " + 0f + " " + 1f + " " + -45f + "</rotate>");
				out.println("    <rotate>"+ 1f + " " + 0f + " " + 0f + " " + 45f + "</rotate>");
				out.println("    <instance_camera url=\"#PerspCamera\"/>");
				out.println("   </node>");
			}
			// Include the light.
			if (configuration.wantLights) {
				out.println("   <node id=\"Light\" name=\"Light\">");
				out.println("    <translate>"+ x + " " + y + " " + z + "</translate>");
				out.println("    <rotate>"+ 0f + " " + 0f + " " + 1f + " " + 225f + "</rotate>");
				out.println("    <rotate>"+ 0f + " " + 1f + " " + 0f + " " + 45f + "</rotate>");
				out.println("    <instance_light url=\"#light-lib\"/>");
				out.println("   </node>");
			}
		}
		// Close the section.
		out.println("  </visual_scene>");
		out.println(" </library_visual_scenes>");
	}

	private void writeEmptyEffects(PrintWriter out) {
		// Open and close the section.
		out.println(" <library_effects/>");
	}

	private void writeEffects(PrintWriter out) {
		out.println(" <library_effects>");
		// Prepare storage to check against to make sure the same object doesn't go out more than once.
		Set<String> convertedObjects = new HashSet<String>();
		// Iterate all the calls in the material calls, looking beneath them at the effects.
		for (Entry<IfcProduct, String> entry : materialCalls.entrySet())
		{
			String materialName = entry.getValue();
			// Only write effects with names that have not already been written.
			if (!convertedObjects.contains(materialName))
			{
				convertedObjects.add(materialName);
				// Get the convertor.
				Convertor convertor = convertors.get(materialName);
				// Write the "effect" element for this effect.
				writeEffect(out, convertor);
			}
		}
		out.println(" </library_effects>");
	}

	private void writeEffect(PrintWriter out, Convertor convertor) {
		if (convertor != null)
			out.println(convertor.getEffectString());
	}

	private void writeEmptyLights(PrintWriter out) {
		// Open and close the section.
		out.println(" <library_lights/>");
	}

	private void writeLights(PrintWriter out) {
		// TODO: Lights defined in library_lights of COLLADA file must be used in some visual_scene to prevent crashes with collada2gltf (stand-alone OpenGL Transmission Format exporter).
		out.println(" <library_lights>");
		out.println("  <light id=\"light-lib\" name=\"light\">");
		out.println("   <technique_common>");
		out.println("    <directional>");
		out.println("     <color>1 1 1</color>");
		out.println("    </directional>");
		out.println("   </technique_common>");
		out.println("  </light>");
		out.println(" </library_lights>");
	}

	private void writeEmptyCameras(PrintWriter out) {
		// Open and close the section.
		out.println(" <library_cameras/>");
	}

	private void writeCameras(PrintWriter out) {
		out.println(" <library_cameras>");
		out.println("  <camera id=\"PerspCamera\" name=\"PerspCamera\">");
		out.println("   <optics>");
		out.println("    <technique_common>");
		out.println("     <perspective>");
		out.println("      <xfov>90</xfov>");
		out.println("      <yfov>37.8493</yfov>");
		out.println("      <znear>0.1</znear>");
		out.println("      <zfar>10000</zfar>");
		out.println("     </perspective>");
		out.println("    </technique_common>");
		out.println("   </optics>");
		out.println("  </camera>");
		out.println(" </library_cameras>");
	}

	private void writeEmptyMaterials(PrintWriter out) {
		// Open and close the section.
		out.println(" <library_materials/>");
	}

	private void writeMaterials(PrintWriter out) {
		out.println(" <library_materials>");
		// Prepare storage to check against to make sure the same object doesn't go out more than once.
		Set<String> convertedObjects = new HashSet<String>();
		// Iterate all the material calls, looking at the material definitions.
		for (Entry<IfcProduct, String> entry : materialCalls.entrySet())
		{
			String materialName = entry.getValue();
			// Only add the material definitions that haven't been defined yet.
			if (!convertedObjects.contains(materialName))
			{
				// Add it.
				convertedObjects.add(materialName);
				// Get the convertor.
				Convertor convertor = convertors.get(materialName);
				// Write the "material" element for this material name.
				if (convertor != null)
					writeMaterial(out, materialName);
			}
		}
		out.println(" </library_materials>");
	}

	private void writeMaterial(PrintWriter out, String materialName) {
		out.println("  <material id=\"" + materialName + "Material\" name=\"" + materialName + "Material\">");
		out.println("   <instance_effect url=\"#" + materialName + "-fx\"/>");
		out.println("  </material>");
	}

	// Try to parameterize materials that the IFC specifically defined.
	private String getMaterialNameForIfcProduct(IfcProduct ifcProduct) {
		ColladaMaterial material = ColladaMaterial.getMaterialForIfcProduct(ifcProduct);
		if (material != null)
		{
			// Create converter.
			Convertor thisConvertor = new Convertor(material);
			// Add converter.
			convertors.add(thisConvertor);
			// Send back something that's probably a specific material name (based on the oid field of the IfcProduct): 2345235, 1350285, etc.
			return material.name;
		}
		// Send back something that's probably a default material name (based on the more specific class of the IfcProduct): IfcRoof, IfcWindow, etc.
		return convertors.getValidMaterialName(ifcProduct);
	}
}
