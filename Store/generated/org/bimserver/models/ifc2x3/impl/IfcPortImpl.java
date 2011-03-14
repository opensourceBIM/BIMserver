/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcPort;
import org.bimserver.models.ifc2x3.IfcRelConnectsPortToElement;
import org.bimserver.models.ifc2x3.IfcRelConnectsPorts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPortImpl#getContainedIn <em>Contained In</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPortImpl#getConnectedFrom <em>Connected From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPortImpl#getConnectedTo <em>Connected To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPortImpl extends IfcProductImpl implements IfcPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcPort();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsPortToElement getContainedIn() {
		return (IfcRelConnectsPortToElement)eGet(Ifc2x3Package.eINSTANCE.getIfcPort_ContainedIn(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainedIn(IfcRelConnectsPortToElement newContainedIn) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPort_ContainedIn(), newContainedIn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsPorts> getConnectedFrom() {
		return (EList<IfcRelConnectsPorts>)eGet(Ifc2x3Package.eINSTANCE.getIfcPort_ConnectedFrom(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsPorts> getConnectedTo() {
		return (EList<IfcRelConnectsPorts>)eGet(Ifc2x3Package.eINSTANCE.getIfcPort_ConnectedTo(), true);
	}

} //IfcPortImpl
