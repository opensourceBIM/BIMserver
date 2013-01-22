package org.bimserver.emf;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface QueryInterface {

	int getPid();

	int getRid();

	boolean isDeep();

	int getStopRid();

	boolean shouldFollowReference(EClass originalQueryClass, EClass eClass, EStructuralFeature feature);

	boolean shouldIncludeClass(EClass eClass);
}
