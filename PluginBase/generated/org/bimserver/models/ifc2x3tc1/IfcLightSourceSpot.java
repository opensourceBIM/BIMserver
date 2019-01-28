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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcLightSourceSpot extends IfcLightSourcePositional {
	/**
	 * Returns the value of the '<em><b>Orientation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orientation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientation</em>' reference.
	 * @see #setOrientation(IfcDirection)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourceSpot_Orientation()
	 * @model
	 * @generated
	 */
	IfcDirection getOrientation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot#getOrientation <em>Orientation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation</em>' reference.
	 * @see #getOrientation()
	 * @generated
	 */
	void setOrientation(IfcDirection value);

	/**
	 * Returns the value of the '<em><b>Concentration Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concentration Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concentration Exponent</em>' attribute.
	 * @see #isSetConcentrationExponent()
	 * @see #unsetConcentrationExponent()
	 * @see #setConcentrationExponent(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourceSpot_ConcentrationExponent()
	 * @model unsettable="true"
	 * @generated
	 */
	double getConcentrationExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot#getConcentrationExponent <em>Concentration Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concentration Exponent</em>' attribute.
	 * @see #isSetConcentrationExponent()
	 * @see #unsetConcentrationExponent()
	 * @see #getConcentrationExponent()
	 * @generated
	 */
	void setConcentrationExponent(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot#getConcentrationExponent <em>Concentration Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConcentrationExponent()
	 * @see #getConcentrationExponent()
	 * @see #setConcentrationExponent(double)
	 * @generated
	 */
	void unsetConcentrationExponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot#getConcentrationExponent <em>Concentration Exponent</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Concentration Exponent</em>' attribute is set.
	 * @see #unsetConcentrationExponent()
	 * @see #getConcentrationExponent()
	 * @see #setConcentrationExponent(double)
	 * @generated
	 */
	boolean isSetConcentrationExponent();

	/**
	 * Returns the value of the '<em><b>Concentration Exponent As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concentration Exponent As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concentration Exponent As String</em>' attribute.
	 * @see #isSetConcentrationExponentAsString()
	 * @see #unsetConcentrationExponentAsString()
	 * @see #setConcentrationExponentAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourceSpot_ConcentrationExponentAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getConcentrationExponentAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot#getConcentrationExponentAsString <em>Concentration Exponent As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concentration Exponent As String</em>' attribute.
	 * @see #isSetConcentrationExponentAsString()
	 * @see #unsetConcentrationExponentAsString()
	 * @see #getConcentrationExponentAsString()
	 * @generated
	 */
	void setConcentrationExponentAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot#getConcentrationExponentAsString <em>Concentration Exponent As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConcentrationExponentAsString()
	 * @see #getConcentrationExponentAsString()
	 * @see #setConcentrationExponentAsString(String)
	 * @generated
	 */
	void unsetConcentrationExponentAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot#getConcentrationExponentAsString <em>Concentration Exponent As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Concentration Exponent As String</em>' attribute is set.
	 * @see #unsetConcentrationExponentAsString()
	 * @see #getConcentrationExponentAsString()
	 * @see #setConcentrationExponentAsString(String)
	 * @generated
	 */
	boolean isSetConcentrationExponentAsString();

	/**
	 * Returns the value of the '<em><b>Spread Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spread Angle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spread Angle</em>' attribute.
	 * @see #setSpreadAngle(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourceSpot_SpreadAngle()
	 * @model
	 * @generated
	 */
	double getSpreadAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot#getSpreadAngle <em>Spread Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spread Angle</em>' attribute.
	 * @see #getSpreadAngle()
	 * @generated
	 */
	void setSpreadAngle(double value);

	/**
	 * Returns the value of the '<em><b>Spread Angle As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spread Angle As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spread Angle As String</em>' attribute.
	 * @see #setSpreadAngleAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourceSpot_SpreadAngleAsString()
	 * @model
	 * @generated
	 */
	String getSpreadAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot#getSpreadAngleAsString <em>Spread Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spread Angle As String</em>' attribute.
	 * @see #getSpreadAngleAsString()
	 * @generated
	 */
	void setSpreadAngleAsString(String value);

	/**
	 * Returns the value of the '<em><b>Beam Width Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Beam Width Angle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Beam Width Angle</em>' attribute.
	 * @see #setBeamWidthAngle(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourceSpot_BeamWidthAngle()
	 * @model
	 * @generated
	 */
	double getBeamWidthAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot#getBeamWidthAngle <em>Beam Width Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Beam Width Angle</em>' attribute.
	 * @see #getBeamWidthAngle()
	 * @generated
	 */
	void setBeamWidthAngle(double value);

	/**
	 * Returns the value of the '<em><b>Beam Width Angle As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Beam Width Angle As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Beam Width Angle As String</em>' attribute.
	 * @see #setBeamWidthAngleAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourceSpot_BeamWidthAngleAsString()
	 * @model
	 * @generated
	 */
	String getBeamWidthAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot#getBeamWidthAngleAsString <em>Beam Width Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Beam Width Angle As String</em>' attribute.
	 * @see #getBeamWidthAngleAsString()
	 * @generated
	 */
	void setBeamWidthAngleAsString(String value);

} // IfcLightSourceSpot
