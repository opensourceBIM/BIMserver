package org.bimserver.client;

import org.bimserver.client.ClientIfcModel.ModelState;
import org.bimserver.emf.Delegate;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.QueryInterface;
import org.bimserver.shared.exceptions.ServiceException;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ClientDelegate extends Delegate {

	private ClientIfcModel model;

	public ClientDelegate(ClientIfcModel model, IdEObject idEObject, QueryInterface queryInterface) {
		super(idEObject, queryInterface);
		this.model = model;
	}

	@Override
	protected void internalLoad(IdEObject idEObject) {
	}

	@Override
	public void loadForEdit() {
	}

	@Override
	public void eUnset(EStructuralFeature eFeature) {
		try {
			model.getBimServerClient().getServiceInterface().unsetAttribute(model.getTransactionId(), getOid(), eFeature.getName());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		loadForEdit();
	}

	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		loadForEdit();
		if (model.getModelState() != ModelState.LOADING) {
			try {
				if (newValue instanceof String) {
					model.getBimServerClient().getServiceInterface().setStringAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (String)newValue);
				} else if (newValue instanceof Long) {
					model.getBimServerClient().getServiceInterface().setLongAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Long)newValue);
				} else if (newValue instanceof Double) {
					model.getBimServerClient().getServiceInterface().setDoubleAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Double)newValue);
				} else if (newValue instanceof Boolean) {
					model.getBimServerClient().getServiceInterface().setBooleanAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Boolean)newValue);
				} else if (newValue instanceof Boolean) {
					model.getBimServerClient().getServiceInterface().setIntegerAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Integer)newValue);
				} else if (newValue instanceof Enum) {
					model.getBimServerClient().getServiceInterface().setEnumAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (String)newValue);
				} else if (newValue instanceof IdEObject) {
					model.getBimServerClient().getServiceInterface().setReference(model.getTransactionId(), getOid(), eFeature.getName(), ((IdEObject)newValue).getOid());
				} else {
					throw new RuntimeException("Unimplemented " + eFeature.getEType().getName());
				}
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
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
		EStructuralFeature eStructuralFeature = getIdEObject().eClass().getEStructuralFeature(featureID);
		eSet(eStructuralFeature, newValue);
	}
}