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
 * A representation of the model object '<em><b>Ifc Light Source Spot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getConcentrationExponent <em>Concentration Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getConcentrationExponentAsString <em>Concentration Exponent As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getSpreadAngle <em>Spread Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getSpreadAngleAsString <em>Spread Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getBeamWidthAngle <em>Beam Width Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getBeamWidthAngleAsString <em>Beam Width Angle As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot()
 * @model
 * @generated
 */
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
	 * @see #isSetOrientation()
	 * @see #unsetOrientation()
	 * @see #setOrientation(IfcDirection)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_Orientation()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirection getOrientation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getOrientation <em>Orientation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation</em>' reference.
	 * @see #isSetOrientation()
	 * @see #unsetOrientation()
	 * @see #getOrientation()
	 * @generated
	 */
	void setOrientation(IfcDirection value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getOrientation <em>Orientation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOrientation()
	 * @see #getOrientation()
	 * @see #setOrientation(IfcDirection)
	 * @generated
	 */
	void unsetOrientation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getOrientation <em>Orientation</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Orientation</em>' reference is set.
	 * @see #unsetOrientation()
	 * @see #getOrientation()
	 * @see #setOrientation(IfcDirection)
	 * @generated
	 */
	boolean isSetOrientation();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_ConcentrationExponent()
	 * @model unsettable="true"
	 * @generated
	 */
	double getConcentrationExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getConcentrationExponent <em>Concentration Exponent</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getConcentrationExponent <em>Concentration Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConcentrationExponent()
	 * @see #getConcentrationExponent()
	 * @see #setConcentrationExponent(double)
	 * @generated
	 */
	void unsetConcentrationExponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getConcentrationExponent <em>Concentration Exponent</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_ConcentrationExponentAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getConcentrationExponentAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getConcentrationExponentAsString <em>Concentration Exponent As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getConcentrationExponentAsString <em>Concentration Exponent As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConcentrationExponentAsString()
	 * @see #getConcentrationExponentAsString()
	 * @see #setConcentrationExponentAsString(String)
	 * @generated
	 */
	void unsetConcentrationExponentAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getConcentrationExponentAsString <em>Concentration Exponent As String</em>}' attribute is set.
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
	 * @see #isSetSpreadAngle()
	 * @see #unsetSpreadAngle()
	 * @see #setSpreadAngle(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_SpreadAngle()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSpreadAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getSpreadAngle <em>Spread Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spread Angle</em>' attribute.
	 * @see #isSetSpreadAngle()
	 * @see #unsetSpreadAngle()
	 * @see #getSpreadAngle()
	 * @generated
	 */
	void setSpreadAngle(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getSpreadAngle <em>Spread Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpreadAngle()
	 * @see #getSpreadAngle()
	 * @see #setSpreadAngle(double)
	 * @generated
	 */
	void unsetSpreadAngle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getSpreadAngle <em>Spread Angle</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Spread Angle</em>' attribute is set.
	 * @see #unsetSpreadAngle()
	 * @see #getSpreadAngle()
	 * @see #setSpreadAngle(double)
	 * @generated
	 */
	boolean isSetSpreadAngle();

	/**
	 * Returns the value of the '<em><b>Spread Angle As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spread Angle As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spread Angle As String</em>' attribute.
	 * @see #isSetSpreadAngleAsString()
	 * @see #unsetSpreadAngleAsString()
	 * @see #setSpreadAngleAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_SpreadAngleAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSpreadAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getSpreadAngleAsString <em>Spread Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spread Angle As String</em>' attribute.
	 * @see #isSetSpreadAngleAsString()
	 * @see #unsetSpreadAngleAsString()
	 * @see #getSpreadAngleAsString()
	 * @generated
	 */
	void setSpreadAngleAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getSpreadAngleAsString <em>Spread Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpreadAngleAsString()
	 * @see #getSpreadAngleAsString()
	 * @see #setSpreadAngleAsString(String)
	 * @generated
	 */
	void unsetSpreadAngleAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getSpreadAngleAsString <em>Spread Angle As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Spread Angle As String</em>' attribute is set.
	 * @see #unsetSpreadAngleAsString()
	 * @see #getSpreadAngleAsString()
	 * @see #setSpreadAngleAsString(String)
	 * @generated
	 */
	boolean isSetSpreadAngleAsString();

	/**
	 * Returns the value of the '<em><b>Beam Width Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Beam Width Angle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Beam Width Angle</em>' attribute.
	 * @see #isSetBeamWidthAngle()
	 * @see #unsetBeamWidthAngle()
	 * @see #setBeamWidthAngle(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_BeamWidthAngle()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBeamWidthAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getBeamWidthAngle <em>Beam Width Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Beam Width Angle</em>' attribute.
	 * @see #isSetBeamWidthAngle()
	 * @see #unsetBeamWidthAngle()
	 * @see #getBeamWidthAngle()
	 * @generated
	 */
	void setBeamWidthAngle(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getBeamWidthAngle <em>Beam Width Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBeamWidthAngle()
	 * @see #getBeamWidthAngle()
	 * @see #setBeamWidthAngle(double)
	 * @generated
	 */
	void unsetBeamWidthAngle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getBeamWidthAngle <em>Beam Width Angle</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Beam Width Angle</em>' attribute is set.
	 * @see #unsetBeamWidthAngle()
	 * @see #getBeamWidthAngle()
	 * @see #setBeamWidthAngle(double)
	 * @generated
	 */
	boolean isSetBeamWidthAngle();

	/**
	 * Returns the value of the '<em><b>Beam Width Angle As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Beam Width Angle As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Beam Width Angle As String</em>' attribute.
	 * @see #isSetBeamWidthAngleAsString()
	 * @see #unsetBeamWidthAngleAsString()
	 * @see #setBeamWidthAngleAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_BeamWidthAngleAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBeamWidthAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getBeamWidthAngleAsString <em>Beam Width Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Beam Width Angle As String</em>' attribute.
	 * @see #isSetBeamWidthAngleAsString()
	 * @see #unsetBeamWidthAngleAsString()
	 * @see #getBeamWidthAngleAsString()
	 * @generated
	 */
	void setBeamWidthAngleAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getBeamWidthAngleAsString <em>Beam Width Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBeamWidthAngleAsString()
	 * @see #getBeamWidthAngleAsString()
	 * @see #setBeamWidthAngleAsString(String)
	 * @generated
	 */
	void unsetBeamWidthAngleAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getBeamWidthAngleAsString <em>Beam Width Angle As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Beam Width Angle As String</em>' attribute is set.
	 * @see #unsetBeamWidthAngleAsString()
	 * @see #getBeamWidthAngleAsString()
	 * @see #setBeamWidthAngleAsString(String)
	 * @generated
	 */
	boolean isSetBeamWidthAngleAsString();

} // IfcLightSourceSpot
