//package org.bimserver.clients.j3d;
//
//import java.io.File;
//import java.util.List;
//
//import javax.media.j3d.Appearance;
//import javax.media.j3d.GeometryArray;
//import javax.media.j3d.Shape3D;
//import javax.media.j3d.TransformGroup;
//import javax.media.j3d.TriangleArray;
//import javax.vecmath.Point3f;
//import javax.vecmath.Vector3f;
//
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//
//import org.bimserver.ifc.IfcModel;
//import org.bimserver.ifc.file.writer.IfcStepSerializer;
//import org.bimserver.models.ifc2x3.IfcRoot;
//import org.bimserver.plugins.ifcengine.IfcEngineException;
//import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
//import org.bimserver.plugins.ifcengine.IfcEngineInstance;
//import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;
//import org.bimserver.plugins.ifcengine.IfcEngineModel;
//import org.bimserver.plugins.ifcengine.IfcEngineSurfaceProperties;
//import org.bimserver.shared.LocalDevelopmentResourceFetcher;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class CppIfcEngine implements IfcEngine {
//	private static final Logger LOGGER = LoggerFactory.getLogger(CppIfcEngine.class);
//	private IfcEngine ifcEngine;
//	private final SchemaDefinition schema;
//	private final Appearances appearances;
//
//	public CppIfcEngine(SchemaDefinition schema, Appearances appearances) {
//		this.schema = schema;
//		this.appearances = appearances;
//		LocalDevelopmentResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
//		try {
//			ifcEngine = new FailSafeIfcEngine(resourceFetcher.getFile("IFC2X3_FINAL.exp").getAbsoluteFile(), new File("../IFCEngine/lib/" + System.getProperty("sun.arch.data.model")), new File("tmp"), null);
//		} catch (IfcEngineException e) {
//			e.printStackTrace();
//		}
//	}	
//}