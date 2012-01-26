/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Measure With Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMeasureWithUnit#getValueComponent <em>Value Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMeasureWithUnit#getUnitComponent <em>Unit Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMeasureWithUnit()
 * @model
 * @generated
 */
public interface IfcMeasureWithUnit extends IfcAppliedValueSelect, IfcConditionCriterionSelect, IfcMetricValueSelect {
	/**
	 * Returns the value of the '<em><b>Value Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Component</em>' reference.
	 * @see #isSetValueComponent()
	 * @see #unsetValueComponent()
	 * @see #setValueComponent(IfcValue)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMeasureWithUnit_ValueComponent()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcValue getValueComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMeasureWithUnit#getValueComponent <em>Value Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Component</em>' reference.
	 * @see #isSetValueComponent()
	 * @see #unsetValueComponent()
	 * @see #getValueComponent()
	 * @generated
	 */
	void setValueComponent(IfcValue value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMeasureWithUnit#getValueComponent <em>Value Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValueComponent()
	 * @see #getValueComponent()
	 * @see #setValueComponent(IfcValue)
	 * @generated
	 */
	void unsetValueComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMeasureWithUnit#getValueComponent <em>Value Component</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Value Component</em>' reference is set.
	 * @see #unsetValueComponent()
	 * @see #getValueComponent()
	 * @see #setValueComponent(IfcValue)
	 * @generated
	 */
	boolean isSetValueComponent();

	/**
	 * Returns the value of the '<em><b>Unit Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Component</em>' reference.
	 * @see #isSetUnitComponent()
	 * @see #unsetUnitComponent()
	 * @see #setUnitComponent(IfcUnit)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMeasureWithUnit_UnitComponent()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcUnit getUnitComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMeasureWithUnit#getUnitComponent <em>Unit Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Component</em>' reference.
	 * @see #isSetUnitComponent()
	 * @see #unsetUnitComponent()
	 * @see #getUnitComponent()
	 * @generated
	 */
	void setUnitComponent(IfcUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMeasureWithUnit#getUnitComponent <em>Unit Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnitComponent()
	 * @see #getUnitComponent()
	 * @see #setUnitComponent(IfcUnit)
	 * @generated
	 */
	void unsetUnitComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMeasureWithUnit#getUnitComponent <em>Unit Component</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unit Component</em>' reference is set.
	 * @see #unsetUnitComponent()
	 * @see #getUnitComponent()
	 * @see #setUnitComponent(IfcUnit)
	 * @generated
	 */
	boolean isSetUnitComponent();

} // IfcMeasureWithUnit
