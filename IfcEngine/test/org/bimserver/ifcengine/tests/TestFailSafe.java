package org.bimserver.ifcengine.tests;

import java.io.File;
import java.util.List;

import org.bimserver.ifcengine.JvmIfcEngine;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.plugins.renderengine.RenderEngineSettings;
import org.bimserver.plugins.renderengine.RenderEngineSurfaceProperties;

public class TestFailSafe {
	public static void main(String[] args) {
		new TestFailSafe().start();
	}

	private void start() {
		try {
//			RenderEngine failSafeIfcEngine = new JvmIfcEngine(new File("../buildingSMARTLibrary/schema/IFC2X3_TC1.exp"), new File("lib/64"), new File("tmp"), System.getProperty("java.class.path"));
			RenderEngine failSafeIfcEngine = new JvmIfcEngine(new File("../buildingSMARTLibrary/schema/IFC4.exp"), new File("lib/64"), new File("tmp"), System.getProperty("java.class.path"));
			failSafeIfcEngine.init();
//			RenderEngineModel model = failSafeIfcEngine.openModel(new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));
			RenderEngineModel model = failSafeIfcEngine.openModel(new File("E:\\Dropbox\\Shared\\IFC files\\IFC4\\rac_basic_sample_project.ifc"));
			model.setSettings(new RenderEngineSettings());
			List<? extends RenderEngineInstance> instances = model.getInstances("IFCWALLSTANDARDCASE");
			for (RenderEngineInstance instance : instances) {
				RenderEngineSurfaceProperties initializeModelling = instance.initializeModelling();
				RenderEngineGeometry geometry = model.finalizeModelling(initializeModelling);
				System.out.println(geometry.getNrIndices());
			}
			model.close();
			failSafeIfcEngine.close();
		} catch (RenderEngineException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void dumpMatrix(float...fs) {
		for (int i=0; i<16; i++) {
			System.out.print(fs[i]);
			if ((i + 1) % 4 == 0) {
				System.out.println();
			} else {
				System.out.print(", ");
			}
		}
	}
}
