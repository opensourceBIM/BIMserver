/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcQuantityWeight;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Quantity Weight</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcQuantityWeightImpl#getWeightValue <em>Weight Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcQuantityWeightImpl#getWeightValueAsString <em>Weight Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcQuantityWeightImpl extends IfcPhysicalSimpleQuantityImpl implements IfcQuantityWeight {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcQuantityWeightImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcQuantityWeight();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWeightValue() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcQuantityWeight_WeightValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeightValue(float newWeightValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcQuantityWeight_WeightValue(), newWeightValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWeightValueAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcQuantityWeight_WeightValueAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeightValueAsString(String newWeightValueAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcQuantityWeight_WeightValueAsString(), newWeightValueAsString);
	}

} //IfcQuantityWeightImpl
