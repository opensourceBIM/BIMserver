package org.bimserver.ifcengine.tests;

import java.io.File;
import java.nio.file.Paths;

import org.bimserver.ifcengine.JvmIfcEngine;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.plugins.renderengine.RenderEngineSettings;

public class TestFailSafe {
	public static void main(String[] args) {
		new TestFailSafe().start();
	}

	private void start() {
		try {
			RenderEngine failSafeIfcEngine = new JvmIfcEngine(Paths.get("../buildingSMARTLibrary/schema/IFC2X3_TC1.exp"), Paths.get("lib/64"), Paths.get("tmp"), System.getProperty("java.class.path"));
			failSafeIfcEngine.init();
			RenderEngineModel model = failSafeIfcEngine.openModel(new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));
			model.setSettings(new RenderEngineSettings());
			RenderEngineInstance instance = model.getInstanceFromExpressId(3008);
			RenderEngineGeometry geometry = instance.generateGeometry();
			System.out.println(geometry);
			
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
