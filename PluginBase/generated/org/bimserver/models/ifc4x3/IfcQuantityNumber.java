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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Quantity Number</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcQuantityNumber#getNumberValue <em>Number Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcQuantityNumber#getNumberValueAsString <em>Number Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcQuantityNumber#getFormula <em>Formula</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcQuantityNumber()
 * @model
 * @generated
 */
public interface IfcQuantityNumber extends IfcPhysicalSimpleQuantity {
	/**
	 * Returns the value of the '<em><b>Number Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Value</em>' attribute.
	 * @see #setNumberValue(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcQuantityNumber_NumberValue()
	 * @model
	 * @generated
	 */
	double getNumberValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcQuantityNumber#getNumberValue <em>Number Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Value</em>' attribute.
	 * @see #getNumberValue()
	 * @generated
	 */
	void setNumberValue(double value);

	/**
	 * Returns the value of the '<em><b>Number Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Value As String</em>' attribute.
	 * @see #setNumberValueAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcQuantityNumber_NumberValueAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getNumberValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcQuantityNumber#getNumberValueAsString <em>Number Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Value As String</em>' attribute.
	 * @see #getNumberValueAsString()
	 * @generated
	 */
	void setNumberValueAsString(String value);

	/**
	 * Returns the value of the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula</em>' attribute.
	 * @see #isSetFormula()
	 * @see #unsetFormula()
	 * @see #setFormula(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcQuantityNumber_Formula()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFormula();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcQuantityNumber#getFormula <em>Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula</em>' attribute.
	 * @see #isSetFormula()
	 * @see #unsetFormula()
	 * @see #getFormula()
	 * @generated
	 */
	void setFormula(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcQuantityNumber#getFormula <em>Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFormula()
	 * @see #getFormula()
	 * @see #setFormula(String)
	 * @generated
	 */
	void unsetFormula();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcQuantityNumber#getFormula <em>Formula</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Formula</em>' attribute is set.
	 * @see #unsetFormula()
	 * @see #getFormula()
	 * @see #setFormula(String)
	 * @generated
	 */
	boolean isSetFormula();

} // IfcQuantityNumber
