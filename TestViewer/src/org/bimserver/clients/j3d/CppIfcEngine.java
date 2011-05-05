package org.bimserver.clients.j3d;

import java.io.File;
import java.util.List;

import javax.media.j3d.Appearance;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TriangleArray;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.ifcengine.FailSafeIfcEngine;
import org.bimserver.ifcengine.Geometry;
import org.bimserver.ifcengine.IfcEngineException;
import org.bimserver.ifcengine.IfcEngineModel;
import org.bimserver.ifcengine.Instance;
import org.bimserver.ifcengine.SurfaceProperties;
import org.bimserver.ifcengine.jvm.IfcEngine.InstanceVisualisationProperties;
import org.bimserver.models.ifc2x3.IfcRoot;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CppIfcEngine implements IfcEngine {
	private static final Logger LOGGER = LoggerFactory.getLogger(CppIfcEngine.class);
	private FailSafeIfcEngine ifcEngine;
	private final SchemaDefinition schema;
	private final Appearances appearances;

	public CppIfcEngine(SchemaDefinition schema, Appearances appearances) {
		this.schema = schema;
		this.appearances = appearances;
		LocalDevelopmentResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
		try {
			ifcEngine = new FailSafeIfcEngine(resourceFetcher.getFile("IFC2X3_FINAL.exp").getAbsoluteFile(), resourceFetcher.getFile("lib/32"), new File("tmp"), null);
		} catch (IfcEngineException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void createTriangles(IfcRoot ifcRootObject, IfcModel ifcModel, TransformGroup buildingTransformGroup) {
		IfcStepSerializer ifcSerializer = new IfcStepSerializer(null, null, "", ifcModel, schema);
		try {
			IfcEngineModel model = ifcEngine.openModel(ifcSerializer.getBytes());
			try {
				model.setPostProcessing(true);
				SurfaceProperties initializeModelling = model.initializeModelling();
				Geometry geometry = model.finalizeModelling(initializeModelling);
				if (geometry != null) {
					List<Instance> instances = model.getInstances(ifcRootObject.eClass().getName().toUpperCase());
					for (Instance instance : instances) {
						InstanceVisualisationProperties instanceInModelling = instance.getVisualisationProperties();
						if (instanceInModelling.getPrimitiveCount() != 0) {
							Appearance appearance = appearances.getAppearance(ifcRootObject);
							if (appearance != null) {
								Point3f[] coordinates = new Point3f[instanceInModelling.getPrimitiveCount() * 3];
								Vector3f[] normals = new Vector3f[instanceInModelling.getPrimitiveCount() * 3];
								for (int i = instanceInModelling.getStartIndex(); i < instanceInModelling.getPrimitiveCount() * 3 + instanceInModelling.getStartIndex(); i += 3) {
									int offsetIndex = i - instanceInModelling.getStartIndex();
									int i1 = geometry.getIndex(i);
									int i2 = geometry.getIndex(i + 1);
									int i3 = geometry.getIndex(i + 2);

									coordinates[offsetIndex] = new Point3f(geometry.getVertex(i1 * 3), geometry.getVertex(i1 * 3 + 1), geometry.getVertex(i1 * 3 + 2));
									coordinates[offsetIndex + 1] = new Point3f(geometry.getVertex(i3 * 3), geometry.getVertex(i3 * 3 + 1), geometry.getVertex(i3 * 3 + 2));
									coordinates[offsetIndex + 2] = new Point3f(geometry.getVertex(i2 * 3), geometry.getVertex(i2 * 3 + 1), geometry.getVertex(i2 * 3 + 2));

									normals[offsetIndex] = new Vector3f(geometry.getNormal(i1 * 3), geometry.getNormal(i1 * 3 + 1), geometry.getNormal(i1 * 3 + 2));
									normals[offsetIndex + 1] = new Vector3f(geometry.getNormal(i3 * 3), geometry.getNormal(i3 * 3 + 1), geometry.getNormal(i3 * 3 + 2));
									normals[offsetIndex + 2] = new Vector3f(geometry.getNormal(i2 * 3), geometry.getNormal(i2 * 3 + 1), geometry.getNormal(i2 * 3 + 2));
								}
								TriangleArray triangleArray = new TriangleArray(coordinates.length, GeometryArray.COORDINATES | GeometryArray.NORMALS);
								triangleArray.setCoordinates(0, coordinates);
								triangleArray.setNormals(0, normals);
								Shape3D myShape = new Shape3D(triangleArray, appearance);
								buildingTransformGroup.addChild(myShape);
								myShape.setUserData(ifcRootObject);
							}
						}
					}
				}
			} finally {
				model.close();
			}
		} catch (IfcEngineException e) {
			LOGGER.error("", e);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}