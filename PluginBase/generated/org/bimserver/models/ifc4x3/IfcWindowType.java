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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Window Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcWindowType#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcWindowType#getPartitioningType <em>Partitioning Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcWindowType#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcWindowType#getUserDefinedPartitioningType <em>User Defined Partitioning Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWindowType()
 * @model
 * @generated
 */
public interface IfcWindowType extends IfcBuiltElementType {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcWindowTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcWindowTypeEnum
	 * @see #setPredefinedType(IfcWindowTypeEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWindowType_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcWindowTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcWindowType#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcWindowTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcWindowTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Partitioning Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcWindowTypePartitioningEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partitioning Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcWindowTypePartitioningEnum
	 * @see #setPartitioningType(IfcWindowTypePartitioningEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWindowType_PartitioningType()
	 * @model
	 * @generated
	 */
	IfcWindowTypePartitioningEnum getPartitioningType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcWindowType#getPartitioningType <em>Partitioning Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partitioning Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcWindowTypePartitioningEnum
	 * @see #getPartitioningType()
	 * @generated
	 */
	void setPartitioningType(IfcWindowTypePartitioningEnum value);

	/**
	 * Returns the value of the '<em><b>Parameter Takes Precedence</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Takes Precedence</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #isSetParameterTakesPrecedence()
	 * @see #unsetParameterTakesPrecedence()
	 * @see #setParameterTakesPrecedence(Tristate)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWindowType_ParameterTakesPrecedence()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getParameterTakesPrecedence();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcWindowType#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Takes Precedence</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #isSetParameterTakesPrecedence()
	 * @see #unsetParameterTakesPrecedence()
	 * @see #getParameterTakesPrecedence()
	 * @generated
	 */
	void setParameterTakesPrecedence(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcWindowType#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParameterTakesPrecedence()
	 * @see #getParameterTakesPrecedence()
	 * @see #setParameterTakesPrecedence(Tristate)
	 * @generated
	 */
	void unsetParameterTakesPrecedence();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcWindowType#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>User Defined Partitioning Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Partitioning Type</em>' attribute.
	 * @see #isSetUserDefinedPartitioningType()
	 * @see #unsetUserDefinedPartitioningType()
	 * @see #setUserDefinedPartitioningType(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWindowType_UserDefinedPartitioningType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedPartitioningType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcWindowType#getUserDefinedPartitioningType <em>User Defined Partitioning Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Partitioning Type</em>' attribute.
	 * @see #isSetUserDefinedPartitioningType()
	 * @see #unsetUserDefinedPartitioningType()
	 * @see #getUserDefinedPartitioningType()
	 * @generated
	 */
	void setUserDefinedPartitioningType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcWindowType#getUserDefinedPartitioningType <em>User Defined Partitioning Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedPartitioningType()
	 * @see #getUserDefinedPartitioningType()
	 * @see #setUserDefinedPartitioningType(String)
	 * @generated
	 */
	void unsetUserDefinedPartitioningType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcWindowType#getUserDefinedPartitioningType <em>User Defined Partitioning Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Partitioning Type</em>' attribute is set.
	 * @see #unsetUserDefinedPartitioningType()
	 * @see #getUserDefinedPartitioningType()
	 * @see #setUserDefinedPartitioningType(String)
	 * @generated
	 */
	boolean isSetUserDefinedPartitioningType();

} // IfcWindowType
