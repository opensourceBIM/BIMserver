/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcQuantityArea;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Quantity Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcQuantityAreaImpl#getAreaValue <em>Area Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcQuantityAreaImpl#getAreaValueAsString <em>Area Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcQuantityAreaImpl extends IfcPhysicalSimpleQuantityImpl implements IfcQuantityArea {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcQuantityAreaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcQuantityArea();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getAreaValue() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcQuantityArea_AreaValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAreaValue(float newAreaValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcQuantityArea_AreaValue(), newAreaValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAreaValueAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcQuantityArea_AreaValueAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAreaValueAsString(String newAreaValueAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcQuantityArea_AreaValueAsString(), newAreaValueAsString);
	}

} //IfcQuantityAreaImpl
