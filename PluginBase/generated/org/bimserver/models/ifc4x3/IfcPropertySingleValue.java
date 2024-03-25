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
 * A representation of the model object '<em><b>Ifc Property Single Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPropertySingleValue#getNominalValue <em>Nominal Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPropertySingleValue#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPropertySingleValue()
 * @model
 * @generated
 */
public interface IfcPropertySingleValue extends IfcSimpleProperty {
	/**
	 * Returns the value of the '<em><b>Nominal Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Value</em>' reference.
	 * @see #isSetNominalValue()
	 * @see #unsetNominalValue()
	 * @see #setNominalValue(IfcValue)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPropertySingleValue_NominalValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcValue getNominalValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySingleValue#getNominalValue <em>Nominal Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Value</em>' reference.
	 * @see #isSetNominalValue()
	 * @see #unsetNominalValue()
	 * @see #getNominalValue()
	 * @generated
	 */
	void setNominalValue(IfcValue value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySingleValue#getNominalValue <em>Nominal Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalValue()
	 * @see #getNominalValue()
	 * @see #setNominalValue(IfcValue)
	 * @generated
	 */
	void unsetNominalValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySingleValue#getNominalValue <em>Nominal Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Value</em>' reference is set.
	 * @see #unsetNominalValue()
	 * @see #getNominalValue()
	 * @see #setNominalValue(IfcValue)
	 * @generated
	 */
	boolean isSetNominalValue();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' reference.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #setUnit(IfcUnit)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPropertySingleValue_Unit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcUnit getUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySingleValue#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(IfcUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySingleValue#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcUnit)
	 * @generated
	 */
	void unsetUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySingleValue#getUnit <em>Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unit</em>' reference is set.
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcUnit)
	 * @generated
	 */
	boolean isSetUnit();

} // IfcPropertySingleValue
