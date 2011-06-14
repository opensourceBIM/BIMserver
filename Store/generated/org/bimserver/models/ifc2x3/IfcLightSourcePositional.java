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
 * A representation of the model object '<em><b>Ifc Light Source Positional</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getRadiusAsString <em>Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getConstantAttenuation <em>Constant Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getConstantAttenuationAsString <em>Constant Attenuation As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getDistanceAttenuation <em>Distance Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getDistanceAttenuationAsString <em>Distance Attenuation As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getQuadricAttenuation <em>Quadric Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getQuadricAttenuationAsString <em>Quadric Attenuation As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional()
 * @model
 * @generated
 */
public interface IfcLightSourcePositional extends IfcLightSource
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_Position()
	 * @model
	 * @generated
	 */
	IfcCartesianPoint getPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getPosition <em>Position</em>}' reference.
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
	 * @see #setRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_Radius()
	 * @model
	 * @generated
	 */
	float getRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_RadiusAsString()
	 * @model
	 * @generated
	 */
	String getRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getRadiusAsString <em>Radius As String</em>}' attribute.
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
	 * @see #setConstantAttenuation(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_ConstantAttenuation()
	 * @model
	 * @generated
	 */
	float getConstantAttenuation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getConstantAttenuation <em>Constant Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Attenuation</em>' attribute.
	 * @see #getConstantAttenuation()
	 * @generated
	 */
	void setConstantAttenuation(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_ConstantAttenuationAsString()
	 * @model
	 * @generated
	 */
	String getConstantAttenuationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getConstantAttenuationAsString <em>Constant Attenuation As String</em>}' attribute.
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
	 * @see #setDistanceAttenuation(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_DistanceAttenuation()
	 * @model
	 * @generated
	 */
	float getDistanceAttenuation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getDistanceAttenuation <em>Distance Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance Attenuation</em>' attribute.
	 * @see #getDistanceAttenuation()
	 * @generated
	 */
	void setDistanceAttenuation(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_DistanceAttenuationAsString()
	 * @model
	 * @generated
	 */
	String getDistanceAttenuationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getDistanceAttenuationAsString <em>Distance Attenuation As String</em>}' attribute.
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
	 * @see #setQuadricAttenuation(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_QuadricAttenuation()
	 * @model
	 * @generated
	 */
	float getQuadricAttenuation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getQuadricAttenuation <em>Quadric Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quadric Attenuation</em>' attribute.
	 * @see #getQuadricAttenuation()
	 * @generated
	 */
	void setQuadricAttenuation(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_QuadricAttenuationAsString()
	 * @model
	 * @generated
	 */
	String getQuadricAttenuationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getQuadricAttenuationAsString <em>Quadric Attenuation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quadric Attenuation As String</em>' attribute.
	 * @see #getQuadricAttenuationAsString()
	 * @generated
	 */
	void setQuadricAttenuationAsString(String value);

} // IfcLightSourcePositional
