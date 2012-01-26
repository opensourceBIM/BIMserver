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
public interface IfcQuantityWeight extends IfcPhysicalSimpleQuantity {
	/**
	 * Returns the value of the '<em><b>Weight Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight Value</em>' attribute.
	 * @see #isSetWeightValue()
	 * @see #unsetWeightValue()
	 * @see #setWeightValue(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityWeight_WeightValue()
	 * @model unsettable="true"
	 * @generated
	 */
	double getWeightValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValue <em>Weight Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight Value</em>' attribute.
	 * @see #isSetWeightValue()
	 * @see #unsetWeightValue()
	 * @see #getWeightValue()
	 * @generated
	 */
	void setWeightValue(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValue <em>Weight Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWeightValue()
	 * @see #getWeightValue()
	 * @see #setWeightValue(double)
	 * @generated
	 */
	void unsetWeightValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValue <em>Weight Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Weight Value</em>' attribute is set.
	 * @see #unsetWeightValue()
	 * @see #getWeightValue()
	 * @see #setWeightValue(double)
	 * @generated
	 */
	boolean isSetWeightValue();

	/**
	 * Returns the value of the '<em><b>Weight Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight Value As String</em>' attribute.
	 * @see #isSetWeightValueAsString()
	 * @see #unsetWeightValueAsString()
	 * @see #setWeightValueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityWeight_WeightValueAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWeightValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValueAsString <em>Weight Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight Value As String</em>' attribute.
	 * @see #isSetWeightValueAsString()
	 * @see #unsetWeightValueAsString()
	 * @see #getWeightValueAsString()
	 * @generated
	 */
	void setWeightValueAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValueAsString <em>Weight Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWeightValueAsString()
	 * @see #getWeightValueAsString()
	 * @see #setWeightValueAsString(String)
	 * @generated
	 */
	void unsetWeightValueAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValueAsString <em>Weight Value As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Weight Value As String</em>' attribute is set.
	 * @see #unsetWeightValueAsString()
	 * @see #getWeightValueAsString()
	 * @see #setWeightValueAsString(String)
	 * @generated
	 */
	boolean isSetWeightValueAsString();

} // IfcQuantityWeight
