package org.bimserver.ifcengine.tests;

import java.io.File;
import java.util.List;

import org.bimserver.ifcengine.executable.ExecutableIfcEngine;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.bimserver.plugins.renderengine.RenderEngineModel;

public class TestExecutable {
	public static void main(String[] args) {
		new TestExecutable().start();
	}

	private void start() {
		try {
			RenderEngine ifcEngine = new ExecutableIfcEngine(new File("IFC2X3_TC1.exp"), new File("lib/32"), new File("tmp"), System.getProperty("java.class.path"));
			RenderEngineModel model = ifcEngine.openModel(new File("AC11-Institute-Var-2-IFC.ifc"));
			RenderEngineGeometry geometry = model.finalizeModelling(model.initializeModelling());
			List<? extends RenderEngineInstance> walls = model.getInstances("IfcWall");
			for (RenderEngineInstance wall : walls) {
				int index = geometry.getIndex(wall.getVisualisationProperties().getStartIndex());
				System.out.println(geometry.getVertex(index * 3));
			}
			model.close();
			ifcEngine.close();
		} catch (RenderEngineException e) {
			e.printStackTrace();
		}
	}
}
