package org.bimserver.database;

import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class DummyGuidanceProvider implements GuidanceProvider {

	@Override
	public boolean shouldIgnoreField(EClass originalClass, EClass eClass, EStructuralFeature eStructuralFeature) {
		return false;
	}

	@Override
	public boolean shouldIgnoreClass(EClass eClass) {
		return false;
	}
}