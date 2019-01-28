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

public interface IfcEnvironmentalImpactValue extends IfcAppliedValue {
	/**
	 * Returns the value of the '<em><b>Impact Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Impact Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Impact Type</em>' attribute.
	 * @see #setImpactType(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcEnvironmentalImpactValue_ImpactType()
	 * @model
	 * @generated
	 */
	String getImpactType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcEnvironmentalImpactValue#getImpactType <em>Impact Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impact Type</em>' attribute.
	 * @see #getImpactType()
	 * @generated
	 */
	void setImpactType(String value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcEnvironmentalImpactCategoryEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcEnvironmentalImpactCategoryEnum
	 * @see #setCategory(IfcEnvironmentalImpactCategoryEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcEnvironmentalImpactValue_Category()
	 * @model
	 * @generated
	 */
	IfcEnvironmentalImpactCategoryEnum getCategory();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcEnvironmentalImpactValue#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcEnvironmentalImpactCategoryEnum
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(IfcEnvironmentalImpactCategoryEnum value);

	/**
	 * Returns the value of the '<em><b>User Defined Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Category</em>' attribute.
	 * @see #isSetUserDefinedCategory()
	 * @see #unsetUserDefinedCategory()
	 * @see #setUserDefinedCategory(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcEnvironmentalImpactValue_UserDefinedCategory()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedCategory();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcEnvironmentalImpactValue#getUserDefinedCategory <em>User Defined Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Category</em>' attribute.
	 * @see #isSetUserDefinedCategory()
	 * @see #unsetUserDefinedCategory()
	 * @see #getUserDefinedCategory()
	 * @generated
	 */
	void setUserDefinedCategory(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcEnvironmentalImpactValue#getUserDefinedCategory <em>User Defined Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedCategory()
	 * @see #getUserDefinedCategory()
	 * @see #setUserDefinedCategory(String)
	 * @generated
	 */
	void unsetUserDefinedCategory();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcEnvironmentalImpactValue#getUserDefinedCategory <em>User Defined Category</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Category</em>' attribute is set.
	 * @see #unsetUserDefinedCategory()
	 * @see #getUserDefinedCategory()
	 * @see #setUserDefinedCategory(String)
	 * @generated
	 */
	boolean isSetUserDefinedCategory();

} // IfcEnvironmentalImpactValue
