/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc4.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcPropertyBoundedValue;
import org.bimserver.models.ifc4.IfcUnit;
import org.bimserver.models.ifc4.IfcValue;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Bounded Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyBoundedValueImpl#getUpperBoundValue <em>Upper Bound Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyBoundedValueImpl#getLowerBoundValue <em>Lower Bound Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyBoundedValueImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyBoundedValueImpl#getSetPointValue <em>Set Point Value</em>}</li>
 * </ul>
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
		return Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcValue getUpperBoundValue() {
		return (IfcValue) eGet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__UPPER_BOUND_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpperBoundValue(IfcValue newUpperBoundValue) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__UPPER_BOUND_VALUE, newUpperBoundValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUpperBoundValue() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__UPPER_BOUND_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUpperBoundValue() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__UPPER_BOUND_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcValue getLowerBoundValue() {
		return (IfcValue) eGet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__LOWER_BOUND_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLowerBoundValue(IfcValue newLowerBoundValue) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__LOWER_BOUND_VALUE, newLowerBoundValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLowerBoundValue() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__LOWER_BOUND_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLowerBoundValue() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__LOWER_BOUND_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcUnit getUnit() {
		return (IfcUnit) eGet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnit(IfcUnit newUnit) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__UNIT, newUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUnit() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUnit() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcValue getSetPointValue() {
		return (IfcValue) eGet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__SET_POINT_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSetPointValue(IfcValue newSetPointValue) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__SET_POINT_VALUE, newSetPointValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSetPointValue() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__SET_POINT_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSetPointValue() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_BOUNDED_VALUE__SET_POINT_VALUE);
	}

} //IfcPropertyBoundedValueImpl
