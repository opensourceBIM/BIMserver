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
	 * @see #isSetPosition()
	 * @see #unsetPosition()
	 * @see #setPosition(IfcCartesianPoint)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_Position()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCartesianPoint getPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getPosition <em>Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' reference.
	 * @see #isSetPosition()
	 * @see #unsetPosition()
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(IfcCartesianPoint value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getPosition <em>Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPosition()
	 * @see #getPosition()
	 * @see #setPosition(IfcCartesianPoint)
	 * @generated
	 */
	void unsetPosition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getPosition <em>Position</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Position</em>' reference is set.
	 * @see #unsetPosition()
	 * @see #getPosition()
	 * @see #setPosition(IfcCartesianPoint)
	 * @generated
	 */
	boolean isSetPosition();

	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #isSetRadius()
	 * @see #unsetRadius()
	 * @see #setRadius(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_Radius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #isSetRadius()
	 * @see #unsetRadius()
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRadius()
	 * @see #getRadius()
	 * @see #setRadius(double)
	 * @generated
	 */
	void unsetRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getRadius <em>Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Radius</em>' attribute is set.
	 * @see #unsetRadius()
	 * @see #getRadius()
	 * @see #setRadius(double)
	 * @generated
	 */
	boolean isSetRadius();

	/**
	 * Returns the value of the '<em><b>Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius As String</em>' attribute.
	 * @see #isSetRadiusAsString()
	 * @see #unsetRadiusAsString()
	 * @see #setRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_RadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getRadiusAsString <em>Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius As String</em>' attribute.
	 * @see #isSetRadiusAsString()
	 * @see #unsetRadiusAsString()
	 * @see #getRadiusAsString()
	 * @generated
	 */
	void setRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getRadiusAsString <em>Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRadiusAsString()
	 * @see #getRadiusAsString()
	 * @see #setRadiusAsString(String)
	 * @generated
	 */
	void unsetRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getRadiusAsString <em>Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Radius As String</em>' attribute is set.
	 * @see #unsetRadiusAsString()
	 * @see #getRadiusAsString()
	 * @see #setRadiusAsString(String)
	 * @generated
	 */
	boolean isSetRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Constant Attenuation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Attenuation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Attenuation</em>' attribute.
	 * @see #isSetConstantAttenuation()
	 * @see #unsetConstantAttenuation()
	 * @see #setConstantAttenuation(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_ConstantAttenuation()
	 * @model unsettable="true"
	 * @generated
	 */
	double getConstantAttenuation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getConstantAttenuation <em>Constant Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Attenuation</em>' attribute.
	 * @see #isSetConstantAttenuation()
	 * @see #unsetConstantAttenuation()
	 * @see #getConstantAttenuation()
	 * @generated
	 */
	void setConstantAttenuation(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getConstantAttenuation <em>Constant Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstantAttenuation()
	 * @see #getConstantAttenuation()
	 * @see #setConstantAttenuation(double)
	 * @generated
	 */
	void unsetConstantAttenuation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getConstantAttenuation <em>Constant Attenuation</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Constant Attenuation</em>' attribute is set.
	 * @see #unsetConstantAttenuation()
	 * @see #getConstantAttenuation()
	 * @see #setConstantAttenuation(double)
	 * @generated
	 */
	boolean isSetConstantAttenuation();

	/**
	 * Returns the value of the '<em><b>Constant Attenuation As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Attenuation As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Attenuation As String</em>' attribute.
	 * @see #isSetConstantAttenuationAsString()
	 * @see #unsetConstantAttenuationAsString()
	 * @see #setConstantAttenuationAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_ConstantAttenuationAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getConstantAttenuationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getConstantAttenuationAsString <em>Constant Attenuation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Attenuation As String</em>' attribute.
	 * @see #isSetConstantAttenuationAsString()
	 * @see #unsetConstantAttenuationAsString()
	 * @see #getConstantAttenuationAsString()
	 * @generated
	 */
	void setConstantAttenuationAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getConstantAttenuationAsString <em>Constant Attenuation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstantAttenuationAsString()
	 * @see #getConstantAttenuationAsString()
	 * @see #setConstantAttenuationAsString(String)
	 * @generated
	 */
	void unsetConstantAttenuationAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getConstantAttenuationAsString <em>Constant Attenuation As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Constant Attenuation As String</em>' attribute is set.
	 * @see #unsetConstantAttenuationAsString()
	 * @see #getConstantAttenuationAsString()
	 * @see #setConstantAttenuationAsString(String)
	 * @generated
	 */
	boolean isSetConstantAttenuationAsString();

	/**
	 * Returns the value of the '<em><b>Distance Attenuation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance Attenuation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance Attenuation</em>' attribute.
	 * @see #isSetDistanceAttenuation()
	 * @see #unsetDistanceAttenuation()
	 * @see #setDistanceAttenuation(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_DistanceAttenuation()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDistanceAttenuation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getDistanceAttenuation <em>Distance Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance Attenuation</em>' attribute.
	 * @see #isSetDistanceAttenuation()
	 * @see #unsetDistanceAttenuation()
	 * @see #getDistanceAttenuation()
	 * @generated
	 */
	void setDistanceAttenuation(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getDistanceAttenuation <em>Distance Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDistanceAttenuation()
	 * @see #getDistanceAttenuation()
	 * @see #setDistanceAttenuation(double)
	 * @generated
	 */
	void unsetDistanceAttenuation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getDistanceAttenuation <em>Distance Attenuation</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Distance Attenuation</em>' attribute is set.
	 * @see #unsetDistanceAttenuation()
	 * @see #getDistanceAttenuation()
	 * @see #setDistanceAttenuation(double)
	 * @generated
	 */
	boolean isSetDistanceAttenuation();

	/**
	 * Returns the value of the '<em><b>Distance Attenuation As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance Attenuation As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance Attenuation As String</em>' attribute.
	 * @see #isSetDistanceAttenuationAsString()
	 * @see #unsetDistanceAttenuationAsString()
	 * @see #setDistanceAttenuationAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_DistanceAttenuationAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDistanceAttenuationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getDistanceAttenuationAsString <em>Distance Attenuation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance Attenuation As String</em>' attribute.
	 * @see #isSetDistanceAttenuationAsString()
	 * @see #unsetDistanceAttenuationAsString()
	 * @see #getDistanceAttenuationAsString()
	 * @generated
	 */
	void setDistanceAttenuationAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getDistanceAttenuationAsString <em>Distance Attenuation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDistanceAttenuationAsString()
	 * @see #getDistanceAttenuationAsString()
	 * @see #setDistanceAttenuationAsString(String)
	 * @generated
	 */
	void unsetDistanceAttenuationAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getDistanceAttenuationAsString <em>Distance Attenuation As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Distance Attenuation As String</em>' attribute is set.
	 * @see #unsetDistanceAttenuationAsString()
	 * @see #getDistanceAttenuationAsString()
	 * @see #setDistanceAttenuationAsString(String)
	 * @generated
	 */
	boolean isSetDistanceAttenuationAsString();

	/**
	 * Returns the value of the '<em><b>Quadric Attenuation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quadric Attenuation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quadric Attenuation</em>' attribute.
	 * @see #isSetQuadricAttenuation()
	 * @see #unsetQuadricAttenuation()
	 * @see #setQuadricAttenuation(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_QuadricAttenuation()
	 * @model unsettable="true"
	 * @generated
	 */
	double getQuadricAttenuation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getQuadricAttenuation <em>Quadric Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quadric Attenuation</em>' attribute.
	 * @see #isSetQuadricAttenuation()
	 * @see #unsetQuadricAttenuation()
	 * @see #getQuadricAttenuation()
	 * @generated
	 */
	void setQuadricAttenuation(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getQuadricAttenuation <em>Quadric Attenuation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuadricAttenuation()
	 * @see #getQuadricAttenuation()
	 * @see #setQuadricAttenuation(double)
	 * @generated
	 */
	void unsetQuadricAttenuation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getQuadricAttenuation <em>Quadric Attenuation</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quadric Attenuation</em>' attribute is set.
	 * @see #unsetQuadricAttenuation()
	 * @see #getQuadricAttenuation()
	 * @see #setQuadricAttenuation(double)
	 * @generated
	 */
	boolean isSetQuadricAttenuation();

	/**
	 * Returns the value of the '<em><b>Quadric Attenuation As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quadric Attenuation As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quadric Attenuation As String</em>' attribute.
	 * @see #isSetQuadricAttenuationAsString()
	 * @see #unsetQuadricAttenuationAsString()
	 * @see #setQuadricAttenuationAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourcePositional_QuadricAttenuationAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getQuadricAttenuationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getQuadricAttenuationAsString <em>Quadric Attenuation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quadric Attenuation As String</em>' attribute.
	 * @see #isSetQuadricAttenuationAsString()
	 * @see #unsetQuadricAttenuationAsString()
	 * @see #getQuadricAttenuationAsString()
	 * @generated
	 */
	void setQuadricAttenuationAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getQuadricAttenuationAsString <em>Quadric Attenuation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuadricAttenuationAsString()
	 * @see #getQuadricAttenuationAsString()
	 * @see #setQuadricAttenuationAsString(String)
	 * @generated
	 */
	void unsetQuadricAttenuationAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourcePositional#getQuadricAttenuationAsString <em>Quadric Attenuation As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quadric Attenuation As String</em>' attribute is set.
	 * @see #unsetQuadricAttenuationAsString()
	 * @see #getQuadricAttenuationAsString()
	 * @see #setQuadricAttenuationAsString(String)
	 * @generated
	 */
	boolean isSetQuadricAttenuationAsString();

} // IfcLightSourcePositional
