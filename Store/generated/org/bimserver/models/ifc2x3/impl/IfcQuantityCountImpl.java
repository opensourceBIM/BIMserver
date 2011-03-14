/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcQuantityCount;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Quantity Count</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcQuantityCountImpl#getCountValue <em>Count Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcQuantityCountImpl#getCountValueAsString <em>Count Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcQuantityCountImpl extends IfcPhysicalSimpleQuantityImpl implements IfcQuantityCount {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcQuantityCountImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcQuantityCount();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCountValue() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcQuantityCount_CountValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountValue(float newCountValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcQuantityCount_CountValue(), newCountValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCountValueAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcQuantityCount_CountValueAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountValueAsString(String newCountValueAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcQuantityCount_CountValueAsString(), newCountValueAsString);
	}

} //IfcQuantityCountImpl
