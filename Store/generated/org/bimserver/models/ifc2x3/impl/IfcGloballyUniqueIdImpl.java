/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcRoot;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Globally Unique Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGloballyUniqueIdImpl#getWrappedValue <em>Wrapped Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGloballyUniqueIdImpl#getIfcRoot <em>Ifc Root</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcGloballyUniqueIdImpl extends WrappedValueImpl implements IfcGloballyUniqueId {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGloballyUniqueIdImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcGloballyUniqueId();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWrappedValue() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcGloballyUniqueId_WrappedValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWrappedValue(String newWrappedValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcGloballyUniqueId_WrappedValue(), newWrappedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRoot getIfcRoot() {
		return (IfcRoot)eGet(Ifc2x3Package.eINSTANCE.getIfcGloballyUniqueId_IfcRoot(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfcRoot(IfcRoot newIfcRoot) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcGloballyUniqueId_IfcRoot(), newIfcRoot);
	}

} //IfcGloballyUniqueIdImpl
