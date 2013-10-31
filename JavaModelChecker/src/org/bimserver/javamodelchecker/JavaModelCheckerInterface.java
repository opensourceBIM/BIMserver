package org.bimserver.javamodelchecker;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.ModelCheckerResult;

public interface JavaModelCheckerInterface {

	ModelCheckerResult check(IfcModelInterface model);
}