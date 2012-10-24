package org.bimserver.ifcengine.tests;

import java.io.File;
import java.util.List;

import org.bimserver.ifcengine.executable.ExecutableIfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineModel;

public class TestExecutable {
	public static void main(String[] args) {
		new TestExecutable().start(args[0]);
	}

	private void start(String args) {
		try {
			IfcEngine ifcEngine = new ExecutableIfcEngine(new File("IFC2X3_TC1.exp"), new File(args), new File("tmp"), System.getProperty("java.class.path"));
			IfcEngineModel model = ifcEngine.openModel(new File("AC11-Institute-Var-2-IFC.ifc"));
			model.setPostProcessing(true);
			IfcEngineGeometry geometry = model.finalizeModelling(model.initializeModelling());
			List<? extends IfcEngineInstance> walls = model.getInstances("IfcWall");
			for (IfcEngineInstance wall : walls) {
				int index = geometry.getIndex(wall.getVisualisationProperties().getStartIndex());
				System.out.println(geometry.getVertex(index * 3));
			}
			model.close();
			ifcEngine.close();
		} catch (IfcEngineException e) {
			e.printStackTrace();
		}
	}
}
