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
 * A representation of the model object '<em><b>Ifc Vector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcVector#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcVector#getMagnitude <em>Magnitude</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcVector#getMagnitudeAsString <em>Magnitude As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcVector#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVector()
 * @model
 * @generated
 */
public interface IfcVector extends IfcGeometricRepresentationItem, IfcVectorOrDirection {
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVector_Orientation()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirection getOrientation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getOrientation <em>Orientation</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getOrientation <em>Orientation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOrientation()
	 * @see #getOrientation()
	 * @see #setOrientation(IfcDirection)
	 * @generated
	 */
	void unsetOrientation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getOrientation <em>Orientation</em>}' reference is set.
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
	 * Returns the value of the '<em><b>Magnitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Magnitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Magnitude</em>' attribute.
	 * @see #isSetMagnitude()
	 * @see #unsetMagnitude()
	 * @see #setMagnitude(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVector_Magnitude()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMagnitude();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getMagnitude <em>Magnitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Magnitude</em>' attribute.
	 * @see #isSetMagnitude()
	 * @see #unsetMagnitude()
	 * @see #getMagnitude()
	 * @generated
	 */
	void setMagnitude(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getMagnitude <em>Magnitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMagnitude()
	 * @see #getMagnitude()
	 * @see #setMagnitude(double)
	 * @generated
	 */
	void unsetMagnitude();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getMagnitude <em>Magnitude</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Magnitude</em>' attribute is set.
	 * @see #unsetMagnitude()
	 * @see #getMagnitude()
	 * @see #setMagnitude(double)
	 * @generated
	 */
	boolean isSetMagnitude();

	/**
	 * Returns the value of the '<em><b>Magnitude As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Magnitude As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Magnitude As String</em>' attribute.
	 * @see #isSetMagnitudeAsString()
	 * @see #unsetMagnitudeAsString()
	 * @see #setMagnitudeAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVector_MagnitudeAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMagnitudeAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getMagnitudeAsString <em>Magnitude As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Magnitude As String</em>' attribute.
	 * @see #isSetMagnitudeAsString()
	 * @see #unsetMagnitudeAsString()
	 * @see #getMagnitudeAsString()
	 * @generated
	 */
	void setMagnitudeAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getMagnitudeAsString <em>Magnitude As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMagnitudeAsString()
	 * @see #getMagnitudeAsString()
	 * @see #setMagnitudeAsString(String)
	 * @generated
	 */
	void unsetMagnitudeAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getMagnitudeAsString <em>Magnitude As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Magnitude As String</em>' attribute is set.
	 * @see #unsetMagnitudeAsString()
	 * @see #getMagnitudeAsString()
	 * @see #setMagnitudeAsString(String)
	 * @generated
	 */
	boolean isSetMagnitudeAsString();

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #setDim(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVector_Dim()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	void unsetDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getDim <em>Dim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dim</em>' attribute is set.
	 * @see #unsetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	boolean isSetDim();

} // IfcVector
