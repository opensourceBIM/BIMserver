/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
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
public interface IfcLightSourceSpot extends IfcLightSourcePositional
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_Orientation()
	 * @model
	 * @generated
	 */
	IfcDirection getOrientation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getOrientation <em>Orientation</em>}' reference.
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
	 * @see #setConcentrationExponent(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_ConcentrationExponent()
	 * @model unsettable="true"
	 * @generated
	 */
	float getConcentrationExponent();

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
	void setConcentrationExponent(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getConcentrationExponent <em>Concentration Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConcentrationExponent()
	 * @see #getConcentrationExponent()
	 * @see #setConcentrationExponent(float)
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
	 * @see #setConcentrationExponent(float)
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
	 * @see #setSpreadAngle(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_SpreadAngle()
	 * @model
	 * @generated
	 */
	float getSpreadAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getSpreadAngle <em>Spread Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spread Angle</em>' attribute.
	 * @see #getSpreadAngle()
	 * @generated
	 */
	void setSpreadAngle(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_SpreadAngleAsString()
	 * @model
	 * @generated
	 */
	String getSpreadAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getSpreadAngleAsString <em>Spread Angle As String</em>}' attribute.
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
	 * @see #setBeamWidthAngle(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_BeamWidthAngle()
	 * @model
	 * @generated
	 */
	float getBeamWidthAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getBeamWidthAngle <em>Beam Width Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Beam Width Angle</em>' attribute.
	 * @see #getBeamWidthAngle()
	 * @generated
	 */
	void setBeamWidthAngle(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceSpot_BeamWidthAngleAsString()
	 * @model
	 * @generated
	 */
	String getBeamWidthAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceSpot#getBeamWidthAngleAsString <em>Beam Width Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Beam Width Angle As String</em>' attribute.
	 * @see #getBeamWidthAngleAsString()
	 * @generated
	 */
	void setBeamWidthAngleAsString(String value);

} // IfcLightSourceSpot
