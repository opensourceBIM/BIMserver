package org.bimserver.clients.j3d;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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
//import org.bimserver.models.ifc2x3tc1.IfcRoot;
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
//			ifcEngine = new FailSafeIfcEngine(resourceFetcher.getFile("IFC2X3_TC1.exp").getAbsoluteFile(), new File("../IfcEngine/lib/" + System.getProperty("sun.arch.data.model")), new File("tmp"), null);
//		} catch (IfcEngineException e) {
//			LOGGER.error("", e);
//		}
//	}	
//}