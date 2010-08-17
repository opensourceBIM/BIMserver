package org.bimserver.tests;


public class TestFailSafeIfcEngine {
	public static void main(String[] args) {
		new TestFailSafeIfcEngine().start();
	}

	private void start() {
//		FailSafeIfcEngine ifcEngine = new FailSafeIfcEngine(new File("C:\\Newer Workspaces\\BimServer\\BimServer\\deploy\\shared\\IFC2X3_FINAL.exp"), new File("C:\\Newer Workspaces\\BimServer\\IFCEngine\\lib"));
//		try {
//			IfcEngineModel model = ifcEngine.openModel(new File("C:\\Newer Workspaces\\BimServer\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc"));
//			try {
//				model.setPostProcessing(true);
//				Geometry geometry = model.finalizeModelling(model.initializeModelling());
//				ArrayList<Instance> instances = model.getInstances("IfcWindow");
//				for (Instance instance : instances) {
//					InstanceVisualisationProperties instanceInModelling = instance.getVisualisationProperties();
//					for (int i = instanceInModelling.getStartIndex(); i < instanceInModelling.getPrimitiveCount()*3 + instanceInModelling.getStartIndex(); i += 3) {
//						int i1 = geometry.getIndex(i);
//						int i2 = geometry.getIndex(i + 1);
//						int i3 = geometry.getIndex(i + 2);
//						System.out.println(geometry.getVertex(i1 * 3) + ", " + geometry.getVertex(i1 * 3 + 1) + ", " + geometry.getVertex(i1 * 3 + 2));
//						System.out.println(geometry.getVertex(i3 * 3) + ", " + geometry.getVertex(i3 * 3 + 1) + ", " + geometry.getVertex(i3 * 3 + 2));
//						System.out.println(geometry.getVertex(i2 * 3) + ", " + geometry.getVertex(i2 * 3 + 1) + ", " + geometry.getVertex(i2 * 3 + 2));
//					}
//				}
//			} finally {
//				model.close();
//			}
//		} catch (IfcEngineException e) {
//			e.printStackTrace();
//		} finally {
//			ifcEngine.close();
//		}
	}
}