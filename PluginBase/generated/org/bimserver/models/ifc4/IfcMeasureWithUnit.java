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

public interface IfcMeasureWithUnit extends IfcAppliedValueSelect, IfcMetricValueSelect {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMeasureWithUnit_ValueComponent()
	 * @model
	 * @generated
	 */
	IfcValue getValueComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMeasureWithUnit#getValueComponent <em>Value Component</em>}' reference.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMeasureWithUnit_UnitComponent()
	 * @model
	 * @generated
	 */
	IfcUnit getUnitComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMeasureWithUnit#getUnitComponent <em>Unit Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Component</em>' reference.
	 * @see #getUnitComponent()
	 * @generated
	 */
	void setUnitComponent(IfcUnit value);

} // IfcMeasureWithUnit
