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
package org.bimserver.models.ifc4;

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

public interface IfcPropertyBoundedValue extends IfcSimpleProperty {
	/**
	 * Returns the value of the '<em><b>Upper Bound Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound Value</em>' reference.
	 * @see #isSetUpperBoundValue()
	 * @see #unsetUpperBoundValue()
	 * @see #setUpperBoundValue(IfcValue)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyBoundedValue_UpperBoundValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcValue getUpperBoundValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getUpperBoundValue <em>Upper Bound Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound Value</em>' reference.
	 * @see #isSetUpperBoundValue()
	 * @see #unsetUpperBoundValue()
	 * @see #getUpperBoundValue()
	 * @generated
	 */
	void setUpperBoundValue(IfcValue value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getUpperBoundValue <em>Upper Bound Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUpperBoundValue()
	 * @see #getUpperBoundValue()
	 * @see #setUpperBoundValue(IfcValue)
	 * @generated
	 */
	void unsetUpperBoundValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getUpperBoundValue <em>Upper Bound Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Upper Bound Value</em>' reference is set.
	 * @see #unsetUpperBoundValue()
	 * @see #getUpperBoundValue()
	 * @see #setUpperBoundValue(IfcValue)
	 * @generated
	 */
	boolean isSetUpperBoundValue();

	/**
	 * Returns the value of the '<em><b>Lower Bound Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound Value</em>' reference.
	 * @see #isSetLowerBoundValue()
	 * @see #unsetLowerBoundValue()
	 * @see #setLowerBoundValue(IfcValue)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyBoundedValue_LowerBoundValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcValue getLowerBoundValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getLowerBoundValue <em>Lower Bound Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound Value</em>' reference.
	 * @see #isSetLowerBoundValue()
	 * @see #unsetLowerBoundValue()
	 * @see #getLowerBoundValue()
	 * @generated
	 */
	void setLowerBoundValue(IfcValue value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getLowerBoundValue <em>Lower Bound Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLowerBoundValue()
	 * @see #getLowerBoundValue()
	 * @see #setLowerBoundValue(IfcValue)
	 * @generated
	 */
	void unsetLowerBoundValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getLowerBoundValue <em>Lower Bound Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lower Bound Value</em>' reference is set.
	 * @see #unsetLowerBoundValue()
	 * @see #getLowerBoundValue()
	 * @see #setLowerBoundValue(IfcValue)
	 * @generated
	 */
	boolean isSetLowerBoundValue();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' reference.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #setUnit(IfcUnit)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyBoundedValue_Unit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcUnit getUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(IfcUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcUnit)
	 * @generated
	 */
	void unsetUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getUnit <em>Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unit</em>' reference is set.
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcUnit)
	 * @generated
	 */
	boolean isSetUnit();

	/**
	 * Returns the value of the '<em><b>Set Point Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Point Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Point Value</em>' reference.
	 * @see #isSetSetPointValue()
	 * @see #unsetSetPointValue()
	 * @see #setSetPointValue(IfcValue)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyBoundedValue_SetPointValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcValue getSetPointValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getSetPointValue <em>Set Point Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Point Value</em>' reference.
	 * @see #isSetSetPointValue()
	 * @see #unsetSetPointValue()
	 * @see #getSetPointValue()
	 * @generated
	 */
	void setSetPointValue(IfcValue value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getSetPointValue <em>Set Point Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSetPointValue()
	 * @see #getSetPointValue()
	 * @see #setSetPointValue(IfcValue)
	 * @generated
	 */
	void unsetSetPointValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyBoundedValue#getSetPointValue <em>Set Point Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Set Point Value</em>' reference is set.
	 * @see #unsetSetPointValue()
	 * @see #getSetPointValue()
	 * @see #setSetPointValue(IfcValue)
	 * @generated
	 */
	boolean isSetSetPointValue();

} // IfcPropertyBoundedValue
