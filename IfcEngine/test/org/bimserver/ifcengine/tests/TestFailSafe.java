package org.bimserver.ifcengine.tests;

import java.io.File;

import org.bimserver.ifcengine.JvmIfcEngine;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineModel;

public class TestFailSafe {
	public static void main(String[] args) {
		new TestFailSafe().start();
	}

	private void start() {
		try {
			RenderEngine failSafeIfcEngine = new JvmIfcEngine(new File("../buildingSMARTLibrary/schema/IFC2X3_TC1.exp"), new File("lib/64"), new File("tmp"), System.getProperty("java.class.path"));
			RenderEngineModel model = failSafeIfcEngine.openModel(new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));
			RenderEngineGeometry geometry = model.finalizeModelling(model.initializeModelling());
			System.out.println(geometry);
			model.close();
			failSafeIfcEngine.close();
		} catch (RenderEngineException e) {
			e.printStackTrace();
		}
	}
}
