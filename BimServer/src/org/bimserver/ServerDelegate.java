package org.bimserver;

import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.Delegate;
import org.bimserver.emf.IdEObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ServerDelegate extends Delegate {

	private DatabaseSession databaseSession;

	public ServerDelegate(DatabaseSession databaseSession, IdEObject idEObject) {
		super(idEObject);
		this.databaseSession = databaseSession;
	}

	@Override
	protected void internalLoad(IdEObject idEObject) {
		databaseSession.load(idEObject);
	}

	@Override
	public void loadForEdit() {
	}

	@Override
	public void eUnset(EStructuralFeature eFeature) {
		load();
	}

	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		load();
	}

	@Override
	public void eGet(EStructuralFeature eFeature) {
		load();
	}

	@Override
	public void eIsSet(EStructuralFeature eFeature) {
		load();
	}

	@Override
	public void eGet(EStructuralFeature eFeature, boolean resolve, boolean coreType) {
		load();
	}

	@Override
	public void eGet(EStructuralFeature eFeature, boolean resolve) {
		load();
	}

	@Override
	public void eGet(int featureID, boolean resolve, boolean coreType) {
		load();
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		load();
	}
}