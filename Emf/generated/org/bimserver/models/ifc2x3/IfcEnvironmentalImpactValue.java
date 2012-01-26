/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Environmental Impact Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getImpactType <em>Impact Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getCategory <em>Category</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getUserDefinedCategory <em>User Defined Category</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnvironmentalImpactValue()
 * @model
 * @generated
 */
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
	 * @see #isSetImpactType()
	 * @see #unsetImpactType()
	 * @see #setImpactType(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnvironmentalImpactValue_ImpactType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getImpactType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getImpactType <em>Impact Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impact Type</em>' attribute.
	 * @see #isSetImpactType()
	 * @see #unsetImpactType()
	 * @see #getImpactType()
	 * @generated
	 */
	void setImpactType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getImpactType <em>Impact Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetImpactType()
	 * @see #getImpactType()
	 * @see #setImpactType(String)
	 * @generated
	 */
	void unsetImpactType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getImpactType <em>Impact Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Impact Type</em>' attribute is set.
	 * @see #unsetImpactType()
	 * @see #getImpactType()
	 * @see #setImpactType(String)
	 * @generated
	 */
	boolean isSetImpactType();

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactCategoryEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcEnvironmentalImpactCategoryEnum
	 * @see #isSetCategory()
	 * @see #unsetCategory()
	 * @see #setCategory(IfcEnvironmentalImpactCategoryEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnvironmentalImpactValue_Category()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcEnvironmentalImpactCategoryEnum getCategory();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcEnvironmentalImpactCategoryEnum
	 * @see #isSetCategory()
	 * @see #unsetCategory()
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(IfcEnvironmentalImpactCategoryEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCategory()
	 * @see #getCategory()
	 * @see #setCategory(IfcEnvironmentalImpactCategoryEnum)
	 * @generated
	 */
	void unsetCategory();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getCategory <em>Category</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Category</em>' attribute is set.
	 * @see #unsetCategory()
	 * @see #getCategory()
	 * @see #setCategory(IfcEnvironmentalImpactCategoryEnum)
	 * @generated
	 */
	boolean isSetCategory();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnvironmentalImpactValue_UserDefinedCategory()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedCategory();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getUserDefinedCategory <em>User Defined Category</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getUserDefinedCategory <em>User Defined Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedCategory()
	 * @see #getUserDefinedCategory()
	 * @see #setUserDefinedCategory(String)
	 * @generated
	 */
	void unsetUserDefinedCategory();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getUserDefinedCategory <em>User Defined Category</em>}' attribute is set.
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
