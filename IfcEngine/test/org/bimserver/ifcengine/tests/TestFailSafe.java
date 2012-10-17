package org.bimserver.ifcengine.tests;

import java.io.File;

import org.bimserver.ifcengine.JvmIfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineModel;

public class TestFailSafe {
	public static void main(String[] args) {
		new TestFailSafe().start();
	}

	private void start() {
		try {
			IfcEngine failSafeIfcEngine = new JvmIfcEngine(new File("../buildingSMARTLibrary/schema/IFC2X3_TC1.exp"), new File("lib/64"), new File("tmp"), System.getProperty("java.class.path"));
			IfcEngineModel model = failSafeIfcEngine.openModel(new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));
			IfcEngineGeometry geometry = model.finalizeModelling(model.initializeModelling());
			System.out.println(geometry);
			model.close();
			failSafeIfcEngine.close();
		} catch (IfcEngineException e) {
			e.printStackTrace();
		}
	}
}
