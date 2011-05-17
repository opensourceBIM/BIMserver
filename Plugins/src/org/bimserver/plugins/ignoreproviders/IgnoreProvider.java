package org.bimserver.plugins.ignoreproviders;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface IgnoreProvider {

	boolean shouldIgnoreField(EClass originalClass, EClass eClass, EStructuralFeature eStructuralFeature);
}
