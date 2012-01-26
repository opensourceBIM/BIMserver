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
 * A representation of the model object '<em><b>Ifc Quantity Count</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityCount#getCountValue <em>Count Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityCount#getCountValueAsString <em>Count Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityCount()
 * @model
 * @generated
 */
public interface IfcQuantityCount extends IfcPhysicalSimpleQuantity {
	/**
	 * Returns the value of the '<em><b>Count Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count Value</em>' attribute.
	 * @see #isSetCountValue()
	 * @see #unsetCountValue()
	 * @see #setCountValue(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityCount_CountValue()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCountValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityCount#getCountValue <em>Count Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count Value</em>' attribute.
	 * @see #isSetCountValue()
	 * @see #unsetCountValue()
	 * @see #getCountValue()
	 * @generated
	 */
	void setCountValue(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityCount#getCountValue <em>Count Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCountValue()
	 * @see #getCountValue()
	 * @see #setCountValue(double)
	 * @generated
	 */
	void unsetCountValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityCount#getCountValue <em>Count Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Count Value</em>' attribute is set.
	 * @see #unsetCountValue()
	 * @see #getCountValue()
	 * @see #setCountValue(double)
	 * @generated
	 */
	boolean isSetCountValue();

	/**
	 * Returns the value of the '<em><b>Count Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count Value As String</em>' attribute.
	 * @see #isSetCountValueAsString()
	 * @see #unsetCountValueAsString()
	 * @see #setCountValueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityCount_CountValueAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCountValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityCount#getCountValueAsString <em>Count Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count Value As String</em>' attribute.
	 * @see #isSetCountValueAsString()
	 * @see #unsetCountValueAsString()
	 * @see #getCountValueAsString()
	 * @generated
	 */
	void setCountValueAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityCount#getCountValueAsString <em>Count Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCountValueAsString()
	 * @see #getCountValueAsString()
	 * @see #setCountValueAsString(String)
	 * @generated
	 */
	void unsetCountValueAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityCount#getCountValueAsString <em>Count Value As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Count Value As String</em>' attribute is set.
	 * @see #unsetCountValueAsString()
	 * @see #getCountValueAsString()
	 * @see #setCountValueAsString(String)
	 * @generated
	 */
	boolean isSetCountValueAsString();

} // IfcQuantityCount
