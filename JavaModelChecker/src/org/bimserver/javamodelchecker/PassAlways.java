package org.bimserver.javamodelchecker;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.ModelCheckerResult;
import org.bimserver.models.store.StoreFactory;

public class PassAlways implements JavaModelCheckerInterface {
	public ModelCheckerResult check(IfcModelInterface model) {
		ModelCheckerResult modelCheckerResult = StoreFactory.eINSTANCE.createModelCheckerResult();
		modelCheckerResult.setValid(true);
		return modelCheckerResult;
	}
}