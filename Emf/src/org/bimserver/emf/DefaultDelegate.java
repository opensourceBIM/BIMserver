package org.bimserver.emf;

import org.eclipse.emf.ecore.EStructuralFeature;

public class DefaultDelegate extends Delegate {

	public DefaultDelegate(IdEObject idEObject, QueryInterface queryInterface) {
		super(idEObject, queryInterface);
	}

	@Override
	protected void internalLoad(IdEObject idEObject) {
	}

	@Override
	public void loadForEdit() {
	}

	@Override
	public void eUnset(EStructuralFeature eFeature) {
	}

	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
	}

	@Override
	public void eGet(EStructuralFeature eFeature) {
	}

	@Override
	public void eIsSet(EStructuralFeature eFeature) {
	}

	@Override
	public void eGet(EStructuralFeature eFeature, boolean resolve, boolean coreType) {
	}

	@Override
	public void eGet(EStructuralFeature eFeature, boolean resolve) {
	}

	@Override
	public void eGet(int featureID, boolean resolve, boolean coreType) {
	}

	@Override
	public void eSet(int featureID, Object newValue) {
	}

	@Override
	public void remove() {
		super.remove();
	}
}