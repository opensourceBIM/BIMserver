package org.bimserver.ifcengine.tests;

import java.io.File;

import org.bimserver.ifcengine.executable.ExecutableIfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineModel;

public class TestExecutable {
	public static void main(String[] args) {
		new TestExecutable().start();
	}

	private void start() {
		try {
			IfcEngine failSafeIfcEngine = new ExecutableIfcEngine(new File("../buildingSMARTLibrary/schema/IFC2X3_TC1.exp"), new File("lib/32"), new File("tmp"), System.getProperty("java.class.path"));
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
