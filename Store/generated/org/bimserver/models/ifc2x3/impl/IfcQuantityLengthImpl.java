/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcQuantityLength;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Quantity Length</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcQuantityLengthImpl#getLengthValue <em>Length Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcQuantityLengthImpl#getLengthValueAsString <em>Length Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcQuantityLengthImpl extends IfcPhysicalSimpleQuantityImpl implements IfcQuantityLength {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcQuantityLengthImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcQuantityLength();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLengthValue() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcQuantityLength_LengthValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLengthValue(float newLengthValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcQuantityLength_LengthValue(), newLengthValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLengthValueAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcQuantityLength_LengthValueAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLengthValueAsString(String newLengthValueAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcQuantityLength_LengthValueAsString(), newLengthValueAsString);
	}

} //IfcQuantityLengthImpl
