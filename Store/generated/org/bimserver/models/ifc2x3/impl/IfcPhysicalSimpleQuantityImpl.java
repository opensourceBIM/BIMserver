/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcNamedUnit;
import org.bimserver.models.ifc2x3.IfcPhysicalSimpleQuantity;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Physical Simple Quantity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPhysicalSimpleQuantityImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPhysicalSimpleQuantityImpl extends IfcPhysicalQuantityImpl implements IfcPhysicalSimpleQuantity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPhysicalSimpleQuantityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcPhysicalSimpleQuantity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcNamedUnit getUnit() {
		return (IfcNamedUnit)eGet(Ifc2x3Package.eINSTANCE.getIfcPhysicalSimpleQuantity_Unit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(IfcNamedUnit newUnit) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPhysicalSimpleQuantity_Unit(), newUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUnit() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPhysicalSimpleQuantity_Unit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUnit() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPhysicalSimpleQuantity_Unit());
	}

} //IfcPhysicalSimpleQuantityImpl
