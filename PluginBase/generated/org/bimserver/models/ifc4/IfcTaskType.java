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

public interface IfcTaskType extends IfcTypeProcess {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcTaskTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcTaskTypeEnum
	 * @see #setPredefinedType(IfcTaskTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskType_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcTaskTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskType#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcTaskTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcTaskTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Work Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Work Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Work Method</em>' attribute.
	 * @see #isSetWorkMethod()
	 * @see #unsetWorkMethod()
	 * @see #setWorkMethod(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskType_WorkMethod()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWorkMethod();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskType#getWorkMethod <em>Work Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Work Method</em>' attribute.
	 * @see #isSetWorkMethod()
	 * @see #unsetWorkMethod()
	 * @see #getWorkMethod()
	 * @generated
	 */
	void setWorkMethod(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskType#getWorkMethod <em>Work Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWorkMethod()
	 * @see #getWorkMethod()
	 * @see #setWorkMethod(String)
	 * @generated
	 */
	void unsetWorkMethod();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskType#getWorkMethod <em>Work Method</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Work Method</em>' attribute is set.
	 * @see #unsetWorkMethod()
	 * @see #getWorkMethod()
	 * @see #setWorkMethod(String)
	 * @generated
	 */
	boolean isSetWorkMethod();

} // IfcTaskType
