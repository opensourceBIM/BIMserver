/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
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
public interface IfcEnvironmentalImpactValue extends IfcAppliedValue
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnvironmentalImpactValue_ImpactType()
	 * @model
	 * @generated
	 */
	String getImpactType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getImpactType <em>Impact Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impact Type</em>' attribute.
	 * @see #getImpactType()
	 * @generated
	 */
	void setImpactType(String value);

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
	 * @see #setCategory(IfcEnvironmentalImpactCategoryEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnvironmentalImpactValue_Category()
	 * @model
	 * @generated
	 */
	IfcEnvironmentalImpactCategoryEnum getCategory();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcEnvironmentalImpactCategoryEnum
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
