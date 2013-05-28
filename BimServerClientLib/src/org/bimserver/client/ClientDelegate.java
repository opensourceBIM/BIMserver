package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.client.ClientIfcModel.ModelState;
import org.bimserver.emf.Delegate;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.QueryInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class ClientDelegate extends Delegate {

	private ClientIfcModel model;

	public ClientDelegate(ClientIfcModel model, IdEObject idEObject, QueryInterface queryInterface) {
		super(idEObject, queryInterface);
		this.model = model;
	}

	@Override
	protected void internalLoad(IdEObject idEObject) {
		model.loadExplicit(idEObject.getOid());
	}

	@Override
	public void loadForEdit() {
	}

	@Override
	public void eUnset(EStructuralFeature eFeature) {
		try {
			model.getBimServerClient().getBimsie1LowLevelInterface().unsetAttribute(model.getTransactionId(), getOid(), eFeature.getName());
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
		loadForEdit();
	}

	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		loadForEdit();
		if (model.getModelState() != ModelState.LOADING) {
			try {
				if (eFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
					model.getBimServerClient().getBimsie1LowLevelInterface().setStringAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (String)newValue);
				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getELong() || eFeature.getEType() == EcorePackage.eINSTANCE.getELongObject()) {
					model.getBimServerClient().getBimsie1LowLevelInterface().setLongAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Long)newValue);
				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
					model.getBimServerClient().getBimsie1LowLevelInterface().setDoubleAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Double)newValue);
				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() || eFeature.getEType() == EcorePackage.eINSTANCE.getEBooleanObject()) {
					model.getBimServerClient().getBimsie1LowLevelInterface().setBooleanAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Boolean)newValue);
				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEInt() || eFeature.getEType() == EcorePackage.eINSTANCE.getEIntegerObject()) {
					model.getBimServerClient().getBimsie1LowLevelInterface().setIntegerAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Integer)newValue);
				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEByteArray()) {
					model.getBimServerClient().getBimsie1LowLevelInterface().setByteArrayAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Byte[])newValue);
				} else if (eFeature.getEType() instanceof EEnum) {
					model.getBimServerClient().getBimsie1LowLevelInterface().setEnumAttribute(model.getTransactionId(), getOid(), eFeature.getName(), ((Enum<?>)newValue).toString());
				} else if (eFeature instanceof EReference) {
					if (newValue == null) {
						model.getBimServerClient().getBimsie1LowLevelInterface().setReference(model.getTransactionId(), getOid(), eFeature.getName(), -1L);
					} else {
						model.getBimServerClient().getBimsie1LowLevelInterface().setReference(model.getTransactionId(), getOid(), eFeature.getName(), ((IdEObject)newValue).getOid());
					}
				} else {
					throw new RuntimeException("Unimplemented " + eFeature.getEType().getName() + " " + newValue);
				}
			} catch (ServiceException e) {
				e.printStackTrace();
			} catch (PublicInterfaceNotFoundException e) {
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

	@Override
	public void remove() {
		try {
			model.getBimServerClient().getBimsie1LowLevelInterface().removeObject(model.getTransactionId(), getOid());
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
		super.remove();
	}
	
	@Override
	public <T> EList<T> createList(EList<T> delegate, EStructuralFeature feature) {
		return new EDelegatingList<T>(model, getIdEObject(), feature, (AbstractEList<T>) delegate);
	}
}