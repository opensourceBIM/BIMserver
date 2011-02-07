//package org.bimserver.tests;
//
//import java.io.File;
//import java.util.Set;
//
//import org.bimserver.database.store.Clash;
//
//public class ClashTest {
//	public static void main(String[] args) {
//		new ClashTest().start();
//	}
//
//	private void start() {
//		IfcEngine ifcEngine = new IfcEngine(new File("../IFCEngine/lib"));
//		try {
//			int modelId = ifcEngine.sdaiOpenModelBN(0, TestFile.AC11.getFile().getAbsolutePath(), "../BimServer/deploy/shared/IFC2X3_FINAL.exp");
//			int nrClashes = ifcEngine.initializeClashes(modelId, 0.0);
//			Set<Clash> clashes = ifcEngine.finalizeClashesByGuid(modelId, nrClashes);
//			for (Clash clash : clashes) {
//				System.out.println(clash.getGuid1() + " - " + clash.getGuid2());
//			}
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//	}
//}