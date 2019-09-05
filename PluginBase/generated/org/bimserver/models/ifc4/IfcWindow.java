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

public interface IfcWindow extends IfcBuildingElement {
	/**
	 * Returns the value of the '<em><b>Overall Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Height</em>' attribute.
	 * @see #isSetOverallHeight()
	 * @see #unsetOverallHeight()
	 * @see #setOverallHeight(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindow_OverallHeight()
	 * @model unsettable="true"
	 * @generated
	 */
	double getOverallHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallHeight <em>Overall Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Height</em>' attribute.
	 * @see #isSetOverallHeight()
	 * @see #unsetOverallHeight()
	 * @see #getOverallHeight()
	 * @generated
	 */
	void setOverallHeight(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallHeight <em>Overall Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOverallHeight()
	 * @see #getOverallHeight()
	 * @see #setOverallHeight(double)
	 * @generated
	 */
	void unsetOverallHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallHeight <em>Overall Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Overall Height</em>' attribute is set.
	 * @see #unsetOverallHeight()
	 * @see #getOverallHeight()
	 * @see #setOverallHeight(double)
	 * @generated
	 */
	boolean isSetOverallHeight();

	/**
	 * Returns the value of the '<em><b>Overall Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Height As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Height As String</em>' attribute.
	 * @see #isSetOverallHeightAsString()
	 * @see #unsetOverallHeightAsString()
	 * @see #setOverallHeightAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindow_OverallHeightAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getOverallHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallHeightAsString <em>Overall Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Height As String</em>' attribute.
	 * @see #isSetOverallHeightAsString()
	 * @see #unsetOverallHeightAsString()
	 * @see #getOverallHeightAsString()
	 * @generated
	 */
	void setOverallHeightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallHeightAsString <em>Overall Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOverallHeightAsString()
	 * @see #getOverallHeightAsString()
	 * @see #setOverallHeightAsString(String)
	 * @generated
	 */
	void unsetOverallHeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallHeightAsString <em>Overall Height As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Overall Height As String</em>' attribute is set.
	 * @see #unsetOverallHeightAsString()
	 * @see #getOverallHeightAsString()
	 * @see #setOverallHeightAsString(String)
	 * @generated
	 */
	boolean isSetOverallHeightAsString();

	/**
	 * Returns the value of the '<em><b>Overall Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Width</em>' attribute.
	 * @see #isSetOverallWidth()
	 * @see #unsetOverallWidth()
	 * @see #setOverallWidth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindow_OverallWidth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getOverallWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallWidth <em>Overall Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Width</em>' attribute.
	 * @see #isSetOverallWidth()
	 * @see #unsetOverallWidth()
	 * @see #getOverallWidth()
	 * @generated
	 */
	void setOverallWidth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallWidth <em>Overall Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOverallWidth()
	 * @see #getOverallWidth()
	 * @see #setOverallWidth(double)
	 * @generated
	 */
	void unsetOverallWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallWidth <em>Overall Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Overall Width</em>' attribute is set.
	 * @see #unsetOverallWidth()
	 * @see #getOverallWidth()
	 * @see #setOverallWidth(double)
	 * @generated
	 */
	boolean isSetOverallWidth();

	/**
	 * Returns the value of the '<em><b>Overall Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Width As String</em>' attribute.
	 * @see #isSetOverallWidthAsString()
	 * @see #unsetOverallWidthAsString()
	 * @see #setOverallWidthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindow_OverallWidthAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getOverallWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallWidthAsString <em>Overall Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Width As String</em>' attribute.
	 * @see #isSetOverallWidthAsString()
	 * @see #unsetOverallWidthAsString()
	 * @see #getOverallWidthAsString()
	 * @generated
	 */
	void setOverallWidthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallWidthAsString <em>Overall Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOverallWidthAsString()
	 * @see #getOverallWidthAsString()
	 * @see #setOverallWidthAsString(String)
	 * @generated
	 */
	void unsetOverallWidthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getOverallWidthAsString <em>Overall Width As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Overall Width As String</em>' attribute is set.
	 * @see #unsetOverallWidthAsString()
	 * @see #getOverallWidthAsString()
	 * @see #setOverallWidthAsString(String)
	 * @generated
	 */
	boolean isSetOverallWidthAsString();

	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcWindowTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcWindowTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcWindowTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindow_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcWindowTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcWindowTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcWindowTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcWindowTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcWindowTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

	/**
	 * Returns the value of the '<em><b>Partitioning Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcWindowTypePartitioningEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partitioning Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partitioning Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcWindowTypePartitioningEnum
	 * @see #isSetPartitioningType()
	 * @see #unsetPartitioningType()
	 * @see #setPartitioningType(IfcWindowTypePartitioningEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindow_PartitioningType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcWindowTypePartitioningEnum getPartitioningType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getPartitioningType <em>Partitioning Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partitioning Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcWindowTypePartitioningEnum
	 * @see #isSetPartitioningType()
	 * @see #unsetPartitioningType()
	 * @see #getPartitioningType()
	 * @generated
	 */
	void setPartitioningType(IfcWindowTypePartitioningEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getPartitioningType <em>Partitioning Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPartitioningType()
	 * @see #getPartitioningType()
	 * @see #setPartitioningType(IfcWindowTypePartitioningEnum)
	 * @generated
	 */
	void unsetPartitioningType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getPartitioningType <em>Partitioning Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Partitioning Type</em>' attribute is set.
	 * @see #unsetPartitioningType()
	 * @see #getPartitioningType()
	 * @see #setPartitioningType(IfcWindowTypePartitioningEnum)
	 * @generated
	 */
	boolean isSetPartitioningType();

	/**
	 * Returns the value of the '<em><b>User Defined Partitioning Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Partitioning Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Partitioning Type</em>' attribute.
	 * @see #isSetUserDefinedPartitioningType()
	 * @see #unsetUserDefinedPartitioningType()
	 * @see #setUserDefinedPartitioningType(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindow_UserDefinedPartitioningType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedPartitioningType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getUserDefinedPartitioningType <em>User Defined Partitioning Type</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getUserDefinedPartitioningType <em>User Defined Partitioning Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedPartitioningType()
	 * @see #getUserDefinedPartitioningType()
	 * @see #setUserDefinedPartitioningType(String)
	 * @generated
	 */
	void unsetUserDefinedPartitioningType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindow#getUserDefinedPartitioningType <em>User Defined Partitioning Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Partitioning Type</em>' attribute is set.
	 * @see #unsetUserDefinedPartitioningType()
	 * @see #getUserDefinedPartitioningType()
	 * @see #setUserDefinedPartitioningType(String)
	 * @generated
	 */
	boolean isSetUserDefinedPartitioningType();

} // IfcWindow
