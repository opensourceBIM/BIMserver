package org.bimserver.client;

import org.bimserver.client.ClientIfcModel.ModelState;
import org.bimserver.emf.BimServerEStore;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EStoreEObjectImpl.EStoreImpl;

public class ClientEStore extends EStoreImpl implements BimServerEStore {

	private ClientIfcModel clientIfcModel;

	public ClientEStore(ClientIfcModel clientIfcModel) {
		this.clientIfcModel = clientIfcModel;
	}

	@Override
	public void load(IdEObject object) {
		clientIfcModel.loadExplicit(object.getOid());
	}

	@Override
	public void remove(IdEObject object) {
		try {
			lowLevelInterface().removeObject(clientIfcModel.getTransactionId(), object.getOid());
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(InternalEObject eObject, EStructuralFeature eFeature, int index, Object newValue) {
		IdEObject idEObject = (IdEObject) eObject;
		if (clientIfcModel.getModelState() != ModelState.LOADING) {
			try {
				if (eFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
					lowLevelInterface().addStringAttribute(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), (String) newValue);
				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getELong() || eFeature.getEType() == EcorePackage.eINSTANCE.getELongObject()) {
					throw new UnsupportedOperationException();
				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
					lowLevelInterface().addDoubleAttribute(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), (Double) newValue);
				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() || eFeature.getEType() == EcorePackage.eINSTANCE.getEBooleanObject()) {
					lowLevelInterface().addBooleanAttribute(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), (Boolean) newValue);
				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEInt() || eFeature.getEType() == EcorePackage.eINSTANCE.getEIntegerObject()) {
					lowLevelInterface().addIntegerAttribute(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), (Integer) newValue);
				} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEByteArray()) {
					throw new UnsupportedOperationException();
				} else if (eFeature.getEType() instanceof EEnum) {
					throw new UnsupportedOperationException();
				} else if (eFeature instanceof EReference) {
					if (newValue == null) {
					} else {
						lowLevelInterface().addReference(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), ((IdEObject) newValue).getOid());
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
		super.add(eObject, eFeature, index, newValue);
	}

	@Override
	public Object set(InternalEObject eObject, EStructuralFeature eFeature, int index, Object newValue) {
		IdEObject idEObject = (IdEObject) eObject;
		if (index == NO_INDEX) {
			if (clientIfcModel.getModelState() != ModelState.LOADING) {
				try {
					if (newValue != EStructuralFeature.Internal.DynamicValueHolder.NIL) {
						Bimsie1LowLevelInterface lowLevelInterface = clientIfcModel.getBimServerClient().getBimsie1LowLevelInterface();
						if (eFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
							lowLevelInterface.setStringAttribute(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), (String) newValue);
						} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getELong() || eFeature.getEType() == EcorePackage.eINSTANCE.getELongObject()) {
							lowLevelInterface.setLongAttribute(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), (Long) newValue);
						} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
							lowLevelInterface.setDoubleAttribute(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), (Double) newValue);
						} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() || eFeature.getEType() == EcorePackage.eINSTANCE.getEBooleanObject()) {
							lowLevelInterface.setBooleanAttribute(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), (Boolean) newValue);
						} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEInt() || eFeature.getEType() == EcorePackage.eINSTANCE.getEIntegerObject()) {
							lowLevelInterface.setIntegerAttribute(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), (Integer) newValue);
						} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEByteArray()) {
							lowLevelInterface.setByteArrayAttribute(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), (Byte[]) newValue);
						} else if (eFeature.getEType() instanceof EEnum) {
							lowLevelInterface.setEnumAttribute(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), ((Enum<?>) newValue).toString());
						} else if (eFeature instanceof EReference) {
							if (newValue == null) {
								lowLevelInterface.setReference(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), -1L);
							} else {
								lowLevelInterface.setReference(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), ((IdEObject) newValue).getOid());
							}
						} else {
							throw new RuntimeException("Unimplemented " + eFeature.getEType().getName() + " " + newValue);
						}
					}
				} catch (ServiceException e) {
					e.printStackTrace();
				} catch (PublicInterfaceNotFoundException e) {
					e.printStackTrace();
				}
			}
		} else {
			if (clientIfcModel.getModelState() != ModelState.LOADING) {
				try {
					Bimsie1LowLevelInterface lowLevelInterface = clientIfcModel.getBimServerClient().getBimsie1LowLevelInterface();
					if (newValue instanceof String) {
						lowLevelInterface.setStringAttributeAtIndex(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), index, (String) newValue);
					} else if (newValue instanceof Double) {
						lowLevelInterface.setDoubleAttributeAtIndex(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), index, (Double) newValue);
					} else if (newValue instanceof Boolean) {
						lowLevelInterface.setBooleanAttributeAtIndex(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), index, (Boolean) newValue);
					} else if (newValue instanceof Integer) {
						lowLevelInterface.setIntegerAttributeAtIndex(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), index, (Integer) newValue);
					} else if (newValue instanceof IdEObject) {
						lowLevelInterface.addReference(clientIfcModel.getTransactionId(), idEObject.getOid(), eFeature.getName(), ((IdEObject) newValue).getOid());
					} else {
						throw new RuntimeException("Unimplemented " + eFeature.getEType().getName() + " " + newValue);
					}
				} catch (ServerException e) {
					e.printStackTrace();
				} catch (UserException e) {
					e.printStackTrace();
				} catch (PublicInterfaceNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return super.set(eObject, eFeature, index, newValue);
	}

	private Bimsie1LowLevelInterface lowLevelInterface() throws PublicInterfaceNotFoundException {
		return clientIfcModel.getBimServerClient().getBimsie1LowLevelInterface();
	}
}