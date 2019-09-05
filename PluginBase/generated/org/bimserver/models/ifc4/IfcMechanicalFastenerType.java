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
package org.bimserver.models.ifc4;

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

public interface IfcMechanicalFastenerType extends IfcElementComponentType {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcMechanicalFastenerTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcMechanicalFastenerTypeEnum
	 * @see #setPredefinedType(IfcMechanicalFastenerTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMechanicalFastenerType_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcMechanicalFastenerTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcMechanicalFastenerTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcMechanicalFastenerTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Nominal Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Diameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Diameter</em>' attribute.
	 * @see #isSetNominalDiameter()
	 * @see #unsetNominalDiameter()
	 * @see #setNominalDiameter(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMechanicalFastenerType_NominalDiameter()
	 * @model unsettable="true"
	 * @generated
	 */
	double getNominalDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalDiameter <em>Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Diameter</em>' attribute.
	 * @see #isSetNominalDiameter()
	 * @see #unsetNominalDiameter()
	 * @see #getNominalDiameter()
	 * @generated
	 */
	void setNominalDiameter(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalDiameter <em>Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalDiameter()
	 * @see #getNominalDiameter()
	 * @see #setNominalDiameter(double)
	 * @generated
	 */
	void unsetNominalDiameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalDiameter <em>Nominal Diameter</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Diameter</em>' attribute is set.
	 * @see #unsetNominalDiameter()
	 * @see #getNominalDiameter()
	 * @see #setNominalDiameter(double)
	 * @generated
	 */
	boolean isSetNominalDiameter();

	/**
	 * Returns the value of the '<em><b>Nominal Diameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Diameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Diameter As String</em>' attribute.
	 * @see #isSetNominalDiameterAsString()
	 * @see #unsetNominalDiameterAsString()
	 * @see #setNominalDiameterAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMechanicalFastenerType_NominalDiameterAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getNominalDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Diameter As String</em>' attribute.
	 * @see #isSetNominalDiameterAsString()
	 * @see #unsetNominalDiameterAsString()
	 * @see #getNominalDiameterAsString()
	 * @generated
	 */
	void setNominalDiameterAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalDiameterAsString()
	 * @see #getNominalDiameterAsString()
	 * @see #setNominalDiameterAsString(String)
	 * @generated
	 */
	void unsetNominalDiameterAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Diameter As String</em>' attribute is set.
	 * @see #unsetNominalDiameterAsString()
	 * @see #getNominalDiameterAsString()
	 * @see #setNominalDiameterAsString(String)
	 * @generated
	 */
	boolean isSetNominalDiameterAsString();

	/**
	 * Returns the value of the '<em><b>Nominal Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Length</em>' attribute.
	 * @see #isSetNominalLength()
	 * @see #unsetNominalLength()
	 * @see #setNominalLength(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMechanicalFastenerType_NominalLength()
	 * @model unsettable="true"
	 * @generated
	 */
	double getNominalLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalLength <em>Nominal Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Length</em>' attribute.
	 * @see #isSetNominalLength()
	 * @see #unsetNominalLength()
	 * @see #getNominalLength()
	 * @generated
	 */
	void setNominalLength(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalLength <em>Nominal Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalLength()
	 * @see #getNominalLength()
	 * @see #setNominalLength(double)
	 * @generated
	 */
	void unsetNominalLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalLength <em>Nominal Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Length</em>' attribute is set.
	 * @see #unsetNominalLength()
	 * @see #getNominalLength()
	 * @see #setNominalLength(double)
	 * @generated
	 */
	boolean isSetNominalLength();

	/**
	 * Returns the value of the '<em><b>Nominal Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Length As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Length As String</em>' attribute.
	 * @see #isSetNominalLengthAsString()
	 * @see #unsetNominalLengthAsString()
	 * @see #setNominalLengthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMechanicalFastenerType_NominalLengthAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getNominalLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalLengthAsString <em>Nominal Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Length As String</em>' attribute.
	 * @see #isSetNominalLengthAsString()
	 * @see #unsetNominalLengthAsString()
	 * @see #getNominalLengthAsString()
	 * @generated
	 */
	void setNominalLengthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalLengthAsString <em>Nominal Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalLengthAsString()
	 * @see #getNominalLengthAsString()
	 * @see #setNominalLengthAsString(String)
	 * @generated
	 */
	void unsetNominalLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastenerType#getNominalLengthAsString <em>Nominal Length As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Length As String</em>' attribute is set.
	 * @see #unsetNominalLengthAsString()
	 * @see #getNominalLengthAsString()
	 * @see #setNominalLengthAsString(String)
	 * @generated
	 */
	boolean isSetNominalLengthAsString();

} // IfcMechanicalFastenerType
