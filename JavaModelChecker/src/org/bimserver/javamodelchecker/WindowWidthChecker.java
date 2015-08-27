package org.bimserver.javamodelchecker;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.store.ModelCheckerResult;
import org.bimserver.models.store.ModelCheckerResultLine;
import org.bimserver.models.store.ModelCheckerResultType;
import org.bimserver.models.store.StoreFactory;

public class WindowWidthChecker implements JavaModelCheckerInterface {
	public ModelCheckerResult check(IfcModelInterface model) {
		ModelCheckerResult modelCheckerResult = StoreFactory.eINSTANCE.createModelCheckerResult();
		modelCheckerResult.setValid(true);
		for (IfcWindow ifcWindow : model.getAllWithSubTypes(IfcWindow.class)) {
			ModelCheckerResultLine line = StoreFactory.eINSTANCE.createModelCheckerResultLine();
			line.setFieldOrClass("IfcWindow");
			line.setObjectId(ifcWindow.getOid());
			line.setShouldBe("> 50");
			line.setValue("" + ifcWindow.getOverallWidth());
			modelCheckerResult.getItems().add(line);
			if (ifcWindow.getOverallWidth() < 50) {
				modelCheckerResult.setValid(false);
				line.setType(ModelCheckerResultType.ERROR);
			} else {
				line.setType(ModelCheckerResultType.SUCCESS);
			}
		}
		return modelCheckerResult;
	}
}