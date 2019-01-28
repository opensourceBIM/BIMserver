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

public interface IfcProcedure extends IfcProcess {
	/**
	 * Returns the value of the '<em><b>Procedure ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedure ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedure ID</em>' attribute.
	 * @see #setProcedureID(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcProcedure_ProcedureID()
	 * @model
	 * @generated
	 */
	String getProcedureID();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProcedure#getProcedureID <em>Procedure ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Procedure ID</em>' attribute.
	 * @see #getProcedureID()
	 * @generated
	 */
	void setProcedureID(String value);

	/**
	 * Returns the value of the '<em><b>Procedure Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcProcedureTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedure Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedure Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcProcedureTypeEnum
	 * @see #setProcedureType(IfcProcedureTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcProcedure_ProcedureType()
	 * @model
	 * @generated
	 */
	IfcProcedureTypeEnum getProcedureType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProcedure#getProcedureType <em>Procedure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Procedure Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcProcedureTypeEnum
	 * @see #getProcedureType()
	 * @generated
	 */
	void setProcedureType(IfcProcedureTypeEnum value);

	/**
	 * Returns the value of the '<em><b>User Defined Procedure Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Procedure Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Procedure Type</em>' attribute.
	 * @see #isSetUserDefinedProcedureType()
	 * @see #unsetUserDefinedProcedureType()
	 * @see #setUserDefinedProcedureType(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcProcedure_UserDefinedProcedureType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedProcedureType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProcedure#getUserDefinedProcedureType <em>User Defined Procedure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Procedure Type</em>' attribute.
	 * @see #isSetUserDefinedProcedureType()
	 * @see #unsetUserDefinedProcedureType()
	 * @see #getUserDefinedProcedureType()
	 * @generated
	 */
	void setUserDefinedProcedureType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProcedure#getUserDefinedProcedureType <em>User Defined Procedure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedProcedureType()
	 * @see #getUserDefinedProcedureType()
	 * @see #setUserDefinedProcedureType(String)
	 * @generated
	 */
	void unsetUserDefinedProcedureType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProcedure#getUserDefinedProcedureType <em>User Defined Procedure Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Procedure Type</em>' attribute is set.
	 * @see #unsetUserDefinedProcedureType()
	 * @see #getUserDefinedProcedureType()
	 * @see #setUserDefinedProcedureType(String)
	 * @generated
	 */
	boolean isSetUserDefinedProcedureType();

} // IfcProcedure
