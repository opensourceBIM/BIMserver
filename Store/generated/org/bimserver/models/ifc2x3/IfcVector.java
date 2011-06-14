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
public interface IfcVector extends IfcGeometricRepresentationItem, IfcVectorOrDirection
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVector_Orientation()
	 * @model
	 * @generated
	 */
	IfcDirection getOrientation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getOrientation <em>Orientation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation</em>' reference.
	 * @see #getOrientation()
	 * @generated
	 */
	void setOrientation(IfcDirection value);

	/**
	 * Returns the value of the '<em><b>Magnitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Magnitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Magnitude</em>' attribute.
	 * @see #setMagnitude(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVector_Magnitude()
	 * @model
	 * @generated
	 */
	float getMagnitude();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getMagnitude <em>Magnitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Magnitude</em>' attribute.
	 * @see #getMagnitude()
	 * @generated
	 */
	void setMagnitude(float value);

	/**
	 * Returns the value of the '<em><b>Magnitude As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Magnitude As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Magnitude As String</em>' attribute.
	 * @see #setMagnitudeAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVector_MagnitudeAsString()
	 * @model
	 * @generated
	 */
	String getMagnitudeAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getMagnitudeAsString <em>Magnitude As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Magnitude As String</em>' attribute.
	 * @see #getMagnitudeAsString()
	 * @generated
	 */
	void setMagnitudeAsString(String value);

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #setDim(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVector_Dim()
	 * @model derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcVector#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

} // IfcVector
