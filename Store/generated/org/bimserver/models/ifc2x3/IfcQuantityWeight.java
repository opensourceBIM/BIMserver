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
 * A representation of the model object '<em><b>Ifc Quantity Weight</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValue <em>Weight Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValueAsString <em>Weight Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityWeight()
 * @model
 * @generated
 */
public interface IfcQuantityWeight extends IfcPhysicalSimpleQuantity
{
	/**
	 * Returns the value of the '<em><b>Weight Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight Value</em>' attribute.
	 * @see #setWeightValue(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityWeight_WeightValue()
	 * @model
	 * @generated
	 */
	float getWeightValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValue <em>Weight Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight Value</em>' attribute.
	 * @see #getWeightValue()
	 * @generated
	 */
	void setWeightValue(float value);

	/**
	 * Returns the value of the '<em><b>Weight Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight Value As String</em>' attribute.
	 * @see #setWeightValueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityWeight_WeightValueAsString()
	 * @model
	 * @generated
	 */
	String getWeightValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValueAsString <em>Weight Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight Value As String</em>' attribute.
	 * @see #getWeightValueAsString()
	 * @generated
	 */
	void setWeightValueAsString(String value);

} // IfcQuantityWeight
