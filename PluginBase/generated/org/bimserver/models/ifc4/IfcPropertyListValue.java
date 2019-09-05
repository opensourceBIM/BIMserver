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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Property List Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcPropertyListValue#getListValues <em>List Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPropertyListValue#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyListValue()
 * @model
 * @generated
 */
public interface IfcPropertyListValue extends IfcSimpleProperty {
	/**
	 * Returns the value of the '<em><b>List Values</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List Values</em>' reference list.
	 * @see #isSetListValues()
	 * @see #unsetListValues()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyListValue_ListValues()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcValue> getListValues();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyListValue#getListValues <em>List Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetListValues()
	 * @see #getListValues()
	 * @generated
	 */
	void unsetListValues();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyListValue#getListValues <em>List Values</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>List Values</em>' reference list is set.
	 * @see #unsetListValues()
	 * @see #getListValues()
	 * @generated
	 */
	boolean isSetListValues();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyListValue_Unit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcUnit getUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyListValue#getUnit <em>Unit</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyListValue#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcUnit)
	 * @generated
	 */
	void unsetUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyListValue#getUnit <em>Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unit</em>' reference is set.
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcUnit)
	 * @generated
	 */
	boolean isSetUnit();

} // IfcPropertyListValue
