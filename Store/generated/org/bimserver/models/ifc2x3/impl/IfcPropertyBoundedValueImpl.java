/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcPropertyBoundedValue;
import org.bimserver.models.ifc2x3.IfcUnit;
import org.bimserver.models.ifc2x3.IfcValue;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Bounded Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyBoundedValueImpl#getUpperBoundValue <em>Upper Bound Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyBoundedValueImpl#getLowerBoundValue <em>Lower Bound Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyBoundedValueImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPropertyBoundedValueImpl extends IfcSimplePropertyImpl implements IfcPropertyBoundedValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyBoundedValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcValue getUpperBoundValue() {
		return (IfcValue)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_UpperBoundValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBoundValue(IfcValue newUpperBoundValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_UpperBoundValue(), newUpperBoundValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpperBoundValue() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_UpperBoundValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpperBoundValue() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_UpperBoundValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcValue getLowerBoundValue() {
		return (IfcValue)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_LowerBoundValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBoundValue(IfcValue newLowerBoundValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_LowerBoundValue(), newLowerBoundValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerBoundValue() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_LowerBoundValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerBoundValue() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_LowerBoundValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnit getUnit() {
		return (IfcUnit)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_Unit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(IfcUnit newUnit) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_Unit(), newUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUnit() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_Unit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUnit() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPropertyBoundedValue_Unit());
	}

} //IfcPropertyBoundedValueImpl
