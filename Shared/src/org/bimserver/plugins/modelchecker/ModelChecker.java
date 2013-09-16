package org.bimserver.plugins.modelchecker;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.ModelCheckerResult;

public interface ModelChecker {
	ModelCheckerResult check(IfcModelInterface model, String code) throws ModelCheckException;
	byte[] compile(String code) throws ModelCheckException;
}
