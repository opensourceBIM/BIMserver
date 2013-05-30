//package org.bimserver.client;
//
///******************************************************************************
// * Copyright (C) 2009-2013  BIMserver.org
// * 
// * This program is free software: you can redistribute it and/or modify
// * it under the terms of the GNU Affero General Public License as
// * published by the Free Software Foundation, either version 3 of the
// * License, or (at your option) any later version.
// * 
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU Affero General Public License for more details.
// * 
// * You should have received a copy of the GNU Affero General Public License
// * along with this program.  If not, see <http://www.gnu.org/licenses/>.
// *****************************************************************************/
//
//import org.bimserver.client.ClientIfcModel.ModelState;
//import org.bimserver.emf.Delegate;
//import org.bimserver.emf.IdEObject;
//import org.bimserver.emf.QueryInterface;
//import org.bimserver.shared.PublicInterfaceNotFoundException;
//import org.bimserver.shared.exceptions.ServerException;
//import org.bimserver.shared.exceptions.ServiceException;
//import org.bimserver.shared.exceptions.UserException;
//import org.eclipse.emf.common.util.AbstractEList;
//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EReference;
//import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eclipse.emf.ecore.EcorePackage;
//import org.eclipse.emf.ecore.InternalEObject;
//import org.eclipse.emf.ecore.InternalEObject.EStore;
//
//public class ClientDelegate implements EStore {
//
//	private ClientIfcModel model;
//
//	public ClientDelegate(ClientIfcModel model, QueryInterface queryInterface) {
//		this.model = model;
//	}
//
//	@Override
//	protected void internalLoad(IdEObject idEObject) {
//		model.loadExplicit(idEObject.getOid());
//	}
//
//	@Override
//	public void loadForEdit() {
//	}
//
//	@Override
//	public void eUnset(EStructuralFeature eFeature) {
//		try {
//			model.getBimServerClient().getBimsie1LowLevelInterface().unsetAttribute(model.getTransactionId(), getOid(), eFeature.getName());
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		} catch (PublicInterfaceNotFoundException e) {
//			e.printStackTrace();
//		}
//		loadForEdit();
//	}
//
//	@Override
//	public void eSet(EStructuralFeature eFeature, Object newValue) {
//		loadForEdit();
//		if (model.getModelState() != ModelState.LOADING) {
//			try {
//				if (eFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
//					model.getBimServerClient().getBimsie1LowLevelInterface().setStringAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (String)newValue);
//				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getELong() || eFeature.getEType() == EcorePackage.eINSTANCE.getELongObject()) {
//					model.getBimServerClient().getBimsie1LowLevelInterface().setLongAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Long)newValue);
//				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
//					model.getBimServerClient().getBimsie1LowLevelInterface().setDoubleAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Double)newValue);
//				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() || eFeature.getEType() == EcorePackage.eINSTANCE.getEBooleanObject()) {
//					model.getBimServerClient().getBimsie1LowLevelInterface().setBooleanAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Boolean)newValue);
//				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEInt() || eFeature.getEType() == EcorePackage.eINSTANCE.getEIntegerObject()) {
//					model.getBimServerClient().getBimsie1LowLevelInterface().setIntegerAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Integer)newValue);
//				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEByteArray()) {
//					model.getBimServerClient().getBimsie1LowLevelInterface().setByteArrayAttribute(model.getTransactionId(), getOid(), eFeature.getName(), (Byte[])newValue);
//				} else if (eFeature.getEType() instanceof EEnum) {
//					model.getBimServerClient().getBimsie1LowLevelInterface().setEnumAttribute(model.getTransactionId(), getOid(), eFeature.getName(), ((Enum<?>)newValue).toString());
//				} else if (eFeature instanceof EReference) {
//					if (newValue == null) {
//						model.getBimServerClient().getBimsie1LowLevelInterface().setReference(model.getTransactionId(), getOid(), eFeature.getName(), -1L);
//					} else {
//						model.getBimServerClient().getBimsie1LowLevelInterface().setReference(model.getTransactionId(), getOid(), eFeature.getName(), ((IdEObject)newValue).getOid());
//					}
//				} else {
//					throw new RuntimeException("Unimplemented " + eFeature.getEType().getName() + " " + newValue);
//				}
//			} catch (ServiceException e) {
//				e.printStackTrace();
//			} catch (PublicInterfaceNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	@Override
//	public void eSet(int featureID, Object newValue) {
//		EStructuralFeature eStructuralFeature = getIdEObject().eClass().getEStructuralFeature(featureID);
//		eSet(eStructuralFeature, newValue);
//	}
//
//	@Override
//	public void remove() {
//		try {
//			model.getBimServerClient().getBimsie1LowLevelInterface().removeObject(model.getTransactionId(), getOid());
//		} catch (ServerException e) {
//			e.printStackTrace();
//		} catch (UserException e) {
//			e.printStackTrace();
//		} catch (PublicInterfaceNotFoundException e) {
//			e.printStackTrace();
//		}
//		super.remove();
//	}
//	
//	@Override
//	public <T> EList<T> createList(EList<T> delegate, EStructuralFeature feature) {
//		return new EDelegatingList<T>(model, getIdEObject(), feature, (AbstractEList<T>) delegate);
//	}
//
//	@Override
//	public void add(InternalEObject arg0, EStructuralFeature arg1, int arg2, Object arg3) {
//	}
//
//	@Override
//	public void clear(InternalEObject arg0, EStructuralFeature arg1) {
//	}
//
//	@Override
//	public boolean contains(InternalEObject arg0, EStructuralFeature arg1, Object arg2) {
//		return false;
//	}
//
//	@Override
//	public EObject create(EClass arg0) {
//		return null;
//	}
//
//	@Override
//	public Object get(InternalEObject arg0, EStructuralFeature arg1, int arg2) {
//		return null;
//	}
//
//	@Override
//	public InternalEObject getContainer(InternalEObject arg0) {
//		return null;
//	}
//
//	@Override
//	public EStructuralFeature getContainingFeature(InternalEObject arg0) {
//		return null;
//	}
//
//	@Override
//	public int hashCode(InternalEObject arg0, EStructuralFeature arg1) {
//		return 0;
//	}
//
//	@Override
//	public int indexOf(InternalEObject arg0, EStructuralFeature arg1, Object arg2) {
//		return 0;
//	}
//
//	@Override
//	public boolean isEmpty(InternalEObject arg0, EStructuralFeature arg1) {
//		return false;
//	}
//
//	@Override
//	public boolean isSet(InternalEObject arg0, EStructuralFeature arg1) {
//		return false;
//	}
//
//	@Override
//	public int lastIndexOf(InternalEObject arg0, EStructuralFeature arg1, Object arg2) {
//		return 0;
//	}
//
//	@Override
//	public Object move(InternalEObject arg0, EStructuralFeature arg1, int arg2, int arg3) {
//		return null;
//	}
//
//	@Override
//	public Object remove(InternalEObject arg0, EStructuralFeature arg1, int arg2) {
//		return null;
//	}
//
//	@Override
//	public Object set(InternalEObject arg0, EStructuralFeature arg1, int arg2, Object arg3) {
//		return null;
//	}
//
//	@Override
//	public int size(InternalEObject arg0, EStructuralFeature arg1) {
//		return 0;
//	}
//
//	@Override
//	public Object[] toArray(InternalEObject arg0, EStructuralFeature arg1) {
//		return null;
//	}
//
//	@Override
//	public <T> T[] toArray(InternalEObject arg0, EStructuralFeature arg1, T[] arg2) {
//		return null;
//	}
//
//	@Override
//	public void unset(InternalEObject arg0, EStructuralFeature arg1) {
//	}
//}