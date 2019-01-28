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

public interface IfcLightSourcePositional extends IfcLightSource {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' reference.
	 * @see #setPosition(IfcCartesianPoint)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourcePositional_Position()
	 * @model
	 * @generated
	 */
	IfcCartesianPoint getPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourcePositional#getPosition <em>Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' reference.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(IfcCartesianPoint value);

	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #setRadius(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourcePositional_Radius()
	 * @model
	 * @generated
	 */
	double getRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourcePositional#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(double value);

	/**
	 * Returns the value of the '<em><b>Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius As String</em>' attribute.
	 * @see #setRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourcePositional_RadiusAsString()
	 * @model
	 * @generated
	 */
	String getRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourcePositional#getRadiusAsString <em>Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius As String</em>' attribute.
	 * @see #getRadiusAsString()
	 * @generated
	 */
	void setRadiusAsString(String value);

	/**
	 * Returns the value of the '<em><b>Constant Attenuation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Attenuation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Attenuation</em>' attribute.
	 * @see #setConstantAttenuation(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourcePositional_ConstantAttenuation()
	 * @model
	 * @generated
	 */
	double getConstantAttenuation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourcePositional#getConstantAttenuation <em>Constant Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Attenuation</em>' attribute.
	 * @see #getConstantAttenuation()
	 * @generated
	 */
	void setConstantAttenuation(double value);

	/**
	 * Returns the value of the '<em><b>Constant Attenuation As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Attenuation As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Attenuation As String</em>' attribute.
	 * @see #setConstantAttenuationAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourcePositional_ConstantAttenuationAsString()
	 * @model
	 * @generated
	 */
	String getConstantAttenuationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourcePositional#getConstantAttenuationAsString <em>Constant Attenuation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Attenuation As String</em>' attribute.
	 * @see #getConstantAttenuationAsString()
	 * @generated
	 */
	void setConstantAttenuationAsString(String value);

	/**
	 * Returns the value of the '<em><b>Distance Attenuation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance Attenuation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance Attenuation</em>' attribute.
	 * @see #setDistanceAttenuation(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourcePositional_DistanceAttenuation()
	 * @model
	 * @generated
	 */
	double getDistanceAttenuation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourcePositional#getDistanceAttenuation <em>Distance Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance Attenuation</em>' attribute.
	 * @see #getDistanceAttenuation()
	 * @generated
	 */
	void setDistanceAttenuation(double value);

	/**
	 * Returns the value of the '<em><b>Distance Attenuation As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance Attenuation As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance Attenuation As String</em>' attribute.
	 * @see #setDistanceAttenuationAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourcePositional_DistanceAttenuationAsString()
	 * @model
	 * @generated
	 */
	String getDistanceAttenuationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourcePositional#getDistanceAttenuationAsString <em>Distance Attenuation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance Attenuation As String</em>' attribute.
	 * @see #getDistanceAttenuationAsString()
	 * @generated
	 */
	void setDistanceAttenuationAsString(String value);

	/**
	 * Returns the value of the '<em><b>Quadric Attenuation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quadric Attenuation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quadric Attenuation</em>' attribute.
	 * @see #setQuadricAttenuation(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourcePositional_QuadricAttenuation()
	 * @model
	 * @generated
	 */
	double getQuadricAttenuation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourcePositional#getQuadricAttenuation <em>Quadric Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quadric Attenuation</em>' attribute.
	 * @see #getQuadricAttenuation()
	 * @generated
	 */
	void setQuadricAttenuation(double value);

	/**
	 * Returns the value of the '<em><b>Quadric Attenuation As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quadric Attenuation As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quadric Attenuation As String</em>' attribute.
	 * @see #setQuadricAttenuationAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightSourcePositional_QuadricAttenuationAsString()
	 * @model
	 * @generated
	 */
	String getQuadricAttenuationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightSourcePositional#getQuadricAttenuationAsString <em>Quadric Attenuation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quadric Attenuation As String</em>' attribute.
	 * @see #getQuadricAttenuationAsString()
	 * @generated
	 */
	void setQuadricAttenuationAsString(String value);

} // IfcLightSourcePositional
