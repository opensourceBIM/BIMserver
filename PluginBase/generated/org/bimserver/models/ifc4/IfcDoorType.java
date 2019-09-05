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

public interface IfcDoorType extends IfcBuildingElementType {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcDoorTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDoorTypeEnum
	 * @see #setPredefinedType(IfcDoorTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDoorType_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcDoorTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDoorType#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDoorTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcDoorTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Operation Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcDoorTypeOperationEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDoorTypeOperationEnum
	 * @see #setOperationType(IfcDoorTypeOperationEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDoorType_OperationType()
	 * @model
	 * @generated
	 */
	IfcDoorTypeOperationEnum getOperationType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDoorType#getOperationType <em>Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDoorTypeOperationEnum
	 * @see #getOperationType()
	 * @generated
	 */
	void setOperationType(IfcDoorTypeOperationEnum value);

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
	 * @see #isSetParameterTakesPrecedence()
	 * @see #unsetParameterTakesPrecedence()
	 * @see #setParameterTakesPrecedence(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDoorType_ParameterTakesPrecedence()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getParameterTakesPrecedence();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDoorType#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Takes Precedence</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetParameterTakesPrecedence()
	 * @see #unsetParameterTakesPrecedence()
	 * @see #getParameterTakesPrecedence()
	 * @generated
	 */
	void setParameterTakesPrecedence(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDoorType#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParameterTakesPrecedence()
	 * @see #getParameterTakesPrecedence()
	 * @see #setParameterTakesPrecedence(Tristate)
	 * @generated
	 */
	void unsetParameterTakesPrecedence();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDoorType#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parameter Takes Precedence</em>' attribute is set.
	 * @see #unsetParameterTakesPrecedence()
	 * @see #getParameterTakesPrecedence()
	 * @see #setParameterTakesPrecedence(Tristate)
	 * @generated
	 */
	boolean isSetParameterTakesPrecedence();

	/**
	 * Returns the value of the '<em><b>User Defined Operation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Operation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Operation Type</em>' attribute.
	 * @see #isSetUserDefinedOperationType()
	 * @see #unsetUserDefinedOperationType()
	 * @see #setUserDefinedOperationType(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDoorType_UserDefinedOperationType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedOperationType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDoorType#getUserDefinedOperationType <em>User Defined Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Operation Type</em>' attribute.
	 * @see #isSetUserDefinedOperationType()
	 * @see #unsetUserDefinedOperationType()
	 * @see #getUserDefinedOperationType()
	 * @generated
	 */
	void setUserDefinedOperationType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDoorType#getUserDefinedOperationType <em>User Defined Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedOperationType()
	 * @see #getUserDefinedOperationType()
	 * @see #setUserDefinedOperationType(String)
	 * @generated
	 */
	void unsetUserDefinedOperationType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDoorType#getUserDefinedOperationType <em>User Defined Operation Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Operation Type</em>' attribute is set.
	 * @see #unsetUserDefinedOperationType()
	 * @see #getUserDefinedOperationType()
	 * @see #setUserDefinedOperationType(String)
	 * @generated
	 */
	boolean isSetUserDefinedOperationType();

} // IfcDoorType
