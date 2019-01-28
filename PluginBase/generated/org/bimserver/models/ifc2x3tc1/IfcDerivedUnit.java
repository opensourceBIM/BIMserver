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
package org.bimserver.models.ifc2x3tc1;

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
 * A representation of the model object '<em><b>Ifc Derived Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDerivedUnit#getElements <em>Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDerivedUnit#getUnitType <em>Unit Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDerivedUnit#getUserDefinedType <em>User Defined Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDerivedUnit()
 * @model
 * @generated
 */
public interface IfcDerivedUnit extends IfcUnit {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcDerivedUnitElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDerivedUnit_Elements()
	 * @model
	 * @generated
	 */
	EList<IfcDerivedUnitElement> getElements();

	/**
	 * Returns the value of the '<em><b>Unit Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcDerivedUnitEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcDerivedUnitEnum
	 * @see #setUnitType(IfcDerivedUnitEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDerivedUnit_UnitType()
	 * @model
	 * @generated
	 */
	IfcDerivedUnitEnum getUnitType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDerivedUnit#getUnitType <em>Unit Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcDerivedUnitEnum
	 * @see #getUnitType()
	 * @generated
	 */
	void setUnitType(IfcDerivedUnitEnum value);

	/**
	 * Returns the value of the '<em><b>User Defined Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Type</em>' attribute.
	 * @see #isSetUserDefinedType()
	 * @see #unsetUserDefinedType()
	 * @see #setUserDefinedType(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDerivedUnit_UserDefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDerivedUnit#getUserDefinedType <em>User Defined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Type</em>' attribute.
	 * @see #isSetUserDefinedType()
	 * @see #unsetUserDefinedType()
	 * @see #getUserDefinedType()
	 * @generated
	 */
	void setUserDefinedType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDerivedUnit#getUserDefinedType <em>User Defined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedType()
	 * @see #getUserDefinedType()
	 * @see #setUserDefinedType(String)
	 * @generated
	 */
	void unsetUserDefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDerivedUnit#getUserDefinedType <em>User Defined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Type</em>' attribute is set.
	 * @see #unsetUserDefinedType()
	 * @see #getUserDefinedType()
	 * @see #setUserDefinedType(String)
	 * @generated
	 */
	boolean isSetUserDefinedType();

} // IfcDerivedUnit
