package org.bimserver.emf;

import org.eclipse.emf.ecore.EStructuralFeature.Internal.DynamicValueHolder;

public class FakeDynamicValueHolder implements DynamicValueHolder {

	@Override
	public Object dynamicGet(int dynamicFeatureID) {
		return null;
	}

	@Override
	public void dynamicSet(int dynamicFeatureID, Object newValue) {
	}

	@Override
	public void dynamicUnset(int dynamicFeatureID) {
	}
}