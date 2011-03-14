/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcElement;
import org.bimserver.models.ifc2x3.IfcRelConnectsWithRealizingElements;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects With Realizing Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsWithRealizingElementsImpl#getRealizingElements <em>Realizing Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsWithRealizingElementsImpl#getConnectionType <em>Connection Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelConnectsWithRealizingElementsImpl extends IfcRelConnectsElementsImpl implements IfcRelConnectsWithRealizingElements {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsWithRealizingElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelConnectsWithRealizingElements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcElement> getRealizingElements() {
		return (EList<IfcElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsWithRealizingElements_RealizingElements(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionType() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsWithRealizingElements_ConnectionType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionType(String newConnectionType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsWithRealizingElements_ConnectionType(), newConnectionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConnectionType() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelConnectsWithRealizingElements_ConnectionType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConnectionType() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsWithRealizingElements_ConnectionType());
	}

} //IfcRelConnectsWithRealizingElementsImpl
