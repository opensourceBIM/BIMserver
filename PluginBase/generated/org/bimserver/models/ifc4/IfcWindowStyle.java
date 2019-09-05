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

public interface IfcWindowStyle extends IfcTypeProduct {
	/**
	 * Returns the value of the '<em><b>Construction Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcWindowStyleConstructionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Construction Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Construction Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcWindowStyleConstructionEnum
	 * @see #setConstructionType(IfcWindowStyleConstructionEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowStyle_ConstructionType()
	 * @model
	 * @generated
	 */
	IfcWindowStyleConstructionEnum getConstructionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowStyle#getConstructionType <em>Construction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Construction Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcWindowStyleConstructionEnum
	 * @see #getConstructionType()
	 * @generated
	 */
	void setConstructionType(IfcWindowStyleConstructionEnum value);

	/**
	 * Returns the value of the '<em><b>Operation Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcWindowStyleOperationEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcWindowStyleOperationEnum
	 * @see #setOperationType(IfcWindowStyleOperationEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowStyle_OperationType()
	 * @model
	 * @generated
	 */
	IfcWindowStyleOperationEnum getOperationType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowStyle#getOperationType <em>Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcWindowStyleOperationEnum
	 * @see #getOperationType()
	 * @generated
	 */
	void setOperationType(IfcWindowStyleOperationEnum value);

	/**
	 * Returns the value of the '<em><b>Parameter Takes Precedence</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Takes Precedence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Takes Precedence</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setParameterTakesPrecedence(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowStyle_ParameterTakesPrecedence()
	 * @model
	 * @generated
	 */
	Tristate getParameterTakesPrecedence();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowStyle#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Takes Precedence</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getParameterTakesPrecedence()
	 * @generated
	 */
	void setParameterTakesPrecedence(Tristate value);

	/**
	 * Returns the value of the '<em><b>Sizeable</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sizeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sizeable</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setSizeable(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowStyle_Sizeable()
	 * @model
	 * @generated
	 */
	Tristate getSizeable();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowStyle#getSizeable <em>Sizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sizeable</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getSizeable()
	 * @generated
	 */
	void setSizeable(Tristate value);

} // IfcWindowStyle
