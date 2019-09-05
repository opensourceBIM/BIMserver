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

public interface IfcMechanicalFastener extends IfcElementComponent {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMechanicalFastener_NominalDiameter()
	 * @model unsettable="true"
	 * @generated
	 */
	double getNominalDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalDiameter <em>Nominal Diameter</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalDiameter <em>Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalDiameter()
	 * @see #getNominalDiameter()
	 * @see #setNominalDiameter(double)
	 * @generated
	 */
	void unsetNominalDiameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalDiameter <em>Nominal Diameter</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMechanicalFastener_NominalDiameterAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getNominalDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalDiameterAsString()
	 * @see #getNominalDiameterAsString()
	 * @see #setNominalDiameterAsString(String)
	 * @generated
	 */
	void unsetNominalDiameterAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMechanicalFastener_NominalLength()
	 * @model unsettable="true"
	 * @generated
	 */
	double getNominalLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalLength <em>Nominal Length</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalLength <em>Nominal Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalLength()
	 * @see #getNominalLength()
	 * @see #setNominalLength(double)
	 * @generated
	 */
	void unsetNominalLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalLength <em>Nominal Length</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMechanicalFastener_NominalLengthAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getNominalLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalLengthAsString <em>Nominal Length As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalLengthAsString <em>Nominal Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalLengthAsString()
	 * @see #getNominalLengthAsString()
	 * @see #setNominalLengthAsString(String)
	 * @generated
	 */
	void unsetNominalLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getNominalLengthAsString <em>Nominal Length As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Length As String</em>' attribute is set.
	 * @see #unsetNominalLengthAsString()
	 * @see #getNominalLengthAsString()
	 * @see #setNominalLengthAsString(String)
	 * @generated
	 */
	boolean isSetNominalLengthAsString();

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
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcMechanicalFastenerTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMechanicalFastener_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcMechanicalFastenerTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcMechanicalFastenerTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcMechanicalFastenerTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcMechanicalFastenerTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMechanicalFastener#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcMechanicalFastenerTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

} // IfcMechanicalFastener
