//package org.bimserver.tests;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;
//
//import org.bimserver.plugins.ifcengine.IfcEngine;
//import org.bimserver.plugins.ifcengine.IfcEngineClash;
//import org.bimserver.plugins.ifcengine.IfcEngineException;
//import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
//import org.bimserver.plugins.ifcengine.IfcEngineInstance;
//import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;
//import org.bimserver.plugins.ifcengine.IfcEngineSurfaceProperties;
//import org.bimserver.shared.LocalDevelopmentResourceFetcher;
//import org.bimserver.shared.ResourceFetcher;
//
//public class Test {
//	public static void main(String[] args) {
//		// IfcEngineJNA ifcEngineJNA = new IfcEngineJNA();
//		//		
//		// for (int i=0; i<100; i++) {
//		// Pointer model = ifcEngineJNA.sdaiOpenModelBN(1,
//		// "C:\\Users\\Ruben\\Workspaces\\BIMserver\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc",
//		// "C:\\Users\\Ruben\\Workspaces\\BIMserver\\BimServer\\deploy\\shared\\IFC2X3_FINAL.exp");
//		// ifcEngineJNA.setPostProcessing(model, 1);
//		// org.bimserver.ifcengine.IfcEngineJNA.SurfaceProperties
//		// initializeModelling = ifcEngineJNA.initializeModelling(model, 0.0);
//		// float[] coordinates = new
//		// float[initializeModelling.getVerticesCount() * 3];
//		// float[] normals = new float[initializeModelling.getVerticesCount() *
//		// 3];
//		// int[] indices = new int[initializeModelling.getIndicesCount() * 2];
//		// ifcEngineJNA.finalizeModelling(model, coordinates, normals, indices);
//		// Pointer sdaiGetEntityExtentBN =
//		// ifcEngineJNA.sdaiGetEntityExtentBN(model, "IFCSPACE");
//		// int nrObjects =
//		// ifcEngineJNA.sdaiGetMemberCount(sdaiGetEntityExtentBN);
//		// for (int k = 0; k < nrObjects; k++) {
//		// Object instanceId = (Pointer)
//		// ifcEngineJNA.engiGetAggrElement(sdaiGetEntityExtentBN, k,
//		// SdaiTypes.INSTANCE);
//		// if (instanceId instanceof Pointer) {
//		// }
//		// }
//		// ifcEngineJNA.sdaiCloseModel(model);
//		// System.out.println(i);
//		// }
//		// int initializeClashes = ifcEngineJNA.initializeClashes(model, 0.0);
//		// if (initializeClashes > 0) {
//		// Set<Clash> clashes = ifcEngineJNA.finalizeClashesByGuid(model,
//		// initializeClashes);
//		// for (Clash clash : clashes) {
//		// System.out.println(clash.getGuid1() + " " + clash.getGuid2());
//		// }
//		// } else {
//		// System.out.println("No clashes");
//		// }
//
//		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
//
//		testGeometry(resourceFetcher);
//		testClashes(resourceFetcher);
//	}
//
//	private static void testClashes(ResourceFetcher resourceFetcher) {
//		try {
//			IfcEngine failSafeIfcEngine = new FailSafeIfcEngine(resourceFetcher.getFile("IFC2X3_FINAL.exp").getAbsoluteFile(), resourceFetcher.getFile("lib/"), new File("tmp"), "");
//			try {
//				File file = TestFile.AC11.getFile();
//				IfcEngineModelImpl openModel = failSafeIfcEngine.openModel(new FileInputStream(file), (int)file.length());
//				try {
//					openModel.setPostProcessing(true);
//					Set<IfcEngineClash> findClashesByEid = openModel.findClashesWithEids(0.0);
//					System.out.println(findClashesByEid.size());
//				} finally {
//					openModel.close();
//				}
//			} catch (IfcEngineException e) {
//				e.printStackTrace();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} finally {
//				failSafeIfcEngine.close();
//			}
//		} catch (IfcEngineException e1) {
//			e1.printStackTrace();
//		}
//	}
//
//	private static void testGeometry(ResourceFetcher resourceFetcher) {
//		try {
//			FailSafeIfcEngine failSafeIfcEngine = new FailSafeIfcEngine(resourceFetcher.getFile("IFC2X3_FINAL.exp").getAbsoluteFile(), resourceFetcher.getFile("lib/"), new File("tmp"), "");
//			try {
//				File file = TestFile.AC11.getFile();
//				IfcEngineModelImpl openModel = failSafeIfcEngine.openModel(new FileInputStream(file), (int)file.length());
//				try {
//					openModel.setPostProcessing(true);
//					IfcEngineSurfaceProperties initializeModelling2 = openModel.initializeModelling();
//					IfcEngineGeometry geometry = openModel.finalizeModelling(initializeModelling2);
//					if (geometry != null) {
//						List<? extends IfcEngineInstance> instances = openModel.getInstances("IFCWINDOW");
//						for (IfcEngineInstance instance : instances) {
//							IfcEngineInstanceVisualisationProperties visualisationProperties = instance.getVisualisationProperties();
//							System.out.println("window");
//							for (int i = visualisationProperties.getStartIndex(); i < visualisationProperties.getPrimitiveCount() * 3 + visualisationProperties.getStartIndex(); i += 3) {
//								int i1 = geometry.getIndex(i);
//								int i2 = geometry.getIndex(i + 1);
//								int i3 = geometry.getIndex(i + 2);
//								Arrays.asList(new Double[] { (double) geometry.getVertex(i1 * 3), (double) geometry.getVertex(i1 * 3 + 1), (double) geometry.getVertex(i1 * 3 + 2),
//										(double) geometry.getVertex(i3 * 3), (double) geometry.getVertex(i3 * 3 + 1), (double) geometry.getVertex(i3 * 3 + 2),
//										(double) geometry.getVertex(i2 * 3), (double) geometry.getVertex(i2 * 3 + 1), (double) geometry.getVertex(i2 * 3 + 2),
//										(double) geometry.getVertex(i1 * 3), (double) geometry.getVertex(i1 * 3 + 1), (double) geometry.getVertex(i1 * 3 + 2) });
//							}
//						}
//					}
//				} finally {
//					openModel.close();
//				}
//			} catch (IfcEngineException e) {
//				e.printStackTrace();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} finally {
//				failSafeIfcEngine.close();
//			}
//		} catch (IfcEngineException e1) {
//			e1.printStackTrace();
//		}
//	}
//}