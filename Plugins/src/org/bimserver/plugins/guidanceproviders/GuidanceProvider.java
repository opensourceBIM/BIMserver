package org.bimserver.plugins.guidanceproviders;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface GuidanceProvider {

	boolean shouldIgnoreField(EClass originalClass, EClass eClass, EStructuralFeature eStructuralFeature);
	boolean shouldIgnoreClass(EClass eClass);
}
