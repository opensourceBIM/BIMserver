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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Derived Unit Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getExponent <em>Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDerivedUnitElement()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcDerivedUnitElement extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' reference.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #setUnit(IfcNamedUnit)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDerivedUnitElement_Unit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcNamedUnit getUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(IfcNamedUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcNamedUnit)
	 * @generated
	 */
	void unsetUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getUnit <em>Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unit</em>' reference is set.
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcNamedUnit)
	 * @generated
	 */
	boolean isSetUnit();

	/**
	 * Returns the value of the '<em><b>Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exponent</em>' attribute.
	 * @see #isSetExponent()
	 * @see #unsetExponent()
	 * @see #setExponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDerivedUnitElement_Exponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getExponent <em>Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exponent</em>' attribute.
	 * @see #isSetExponent()
	 * @see #unsetExponent()
	 * @see #getExponent()
	 * @generated
	 */
	void setExponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getExponent <em>Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExponent()
	 * @see #getExponent()
	 * @see #setExponent(int)
	 * @generated
	 */
	void unsetExponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getExponent <em>Exponent</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Exponent</em>' attribute is set.
	 * @see #unsetExponent()
	 * @see #getExponent()
	 * @see #setExponent(int)
	 * @generated
	 */
	boolean isSetExponent();

} // IfcDerivedUnitElement
