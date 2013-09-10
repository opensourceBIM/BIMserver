package org.bimserver.javamodelchecker;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.ModelCheckerResult;
import org.bimserver.plugins.modelchecker.ModelCheckException;
import org.bimserver.plugins.modelchecker.ModelChecker;

public class JavaModelChecker implements ModelChecker {

	@Override
	public ModelCheckerResult check(IfcModelInterface model) throws ModelCheckException {
		return null;
	}
}