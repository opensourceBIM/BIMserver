/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
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
public interface IfcMeasureWithUnit extends IfcAppliedValueSelect, IfcConditionCriterionSelect, IfcMetricValueSelect
{
	/**
	 * Returns the value of the '<em><b>Value Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Component</em>' reference.
	 * @see #setValueComponent(IfcValue)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMeasureWithUnit_ValueComponent()
	 * @model
	 * @generated
	 */
	IfcValue getValueComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMeasureWithUnit#getValueComponent <em>Value Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Component</em>' reference.
	 * @see #getValueComponent()
	 * @generated
	 */
	void setValueComponent(IfcValue value);

	/**
	 * Returns the value of the '<em><b>Unit Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Component</em>' reference.
	 * @see #setUnitComponent(IfcUnit)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMeasureWithUnit_UnitComponent()
	 * @model
	 * @generated
	 */
	IfcUnit getUnitComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMeasureWithUnit#getUnitComponent <em>Unit Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Component</em>' reference.
	 * @see #getUnitComponent()
	 * @generated
	 */
	void setUnitComponent(IfcUnit value);

} // IfcMeasureWithUnit
