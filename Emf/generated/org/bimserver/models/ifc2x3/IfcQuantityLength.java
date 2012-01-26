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
 * A representation of the model object '<em><b>Ifc Quantity Length</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityLength#getLengthValue <em>Length Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityLength#getLengthValueAsString <em>Length Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityLength()
 * @model
 * @generated
 */
public interface IfcQuantityLength extends IfcPhysicalSimpleQuantity {
	/**
	 * Returns the value of the '<em><b>Length Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length Value</em>' attribute.
	 * @see #isSetLengthValue()
	 * @see #unsetLengthValue()
	 * @see #setLengthValue(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityLength_LengthValue()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLengthValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityLength#getLengthValue <em>Length Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length Value</em>' attribute.
	 * @see #isSetLengthValue()
	 * @see #unsetLengthValue()
	 * @see #getLengthValue()
	 * @generated
	 */
	void setLengthValue(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityLength#getLengthValue <em>Length Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLengthValue()
	 * @see #getLengthValue()
	 * @see #setLengthValue(double)
	 * @generated
	 */
	void unsetLengthValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityLength#getLengthValue <em>Length Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Length Value</em>' attribute is set.
	 * @see #unsetLengthValue()
	 * @see #getLengthValue()
	 * @see #setLengthValue(double)
	 * @generated
	 */
	boolean isSetLengthValue();

	/**
	 * Returns the value of the '<em><b>Length Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length Value As String</em>' attribute.
	 * @see #isSetLengthValueAsString()
	 * @see #unsetLengthValueAsString()
	 * @see #setLengthValueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityLength_LengthValueAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLengthValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityLength#getLengthValueAsString <em>Length Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length Value As String</em>' attribute.
	 * @see #isSetLengthValueAsString()
	 * @see #unsetLengthValueAsString()
	 * @see #getLengthValueAsString()
	 * @generated
	 */
	void setLengthValueAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityLength#getLengthValueAsString <em>Length Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLengthValueAsString()
	 * @see #getLengthValueAsString()
	 * @see #setLengthValueAsString(String)
	 * @generated
	 */
	void unsetLengthValueAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityLength#getLengthValueAsString <em>Length Value As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Length Value As String</em>' attribute is set.
	 * @see #unsetLengthValueAsString()
	 * @see #getLengthValueAsString()
	 * @see #setLengthValueAsString(String)
	 * @generated
	 */
	boolean isSetLengthValueAsString();

} // IfcQuantityLength
