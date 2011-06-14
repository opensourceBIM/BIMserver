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
 * A representation of the model object '<em><b>Ifc Right Circular Cylinder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRightCircularCylinder#getHeight <em>Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRightCircularCylinder#getHeightAsString <em>Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRightCircularCylinder#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRightCircularCylinder#getRadiusAsString <em>Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRightCircularCylinder()
 * @model
 * @generated
 */
public interface IfcRightCircularCylinder extends IfcCsgPrimitive3D
{
	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRightCircularCylinder_Height()
	 * @model
	 * @generated
	 */
	float getHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCylinder#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(float value);

	/**
	 * Returns the value of the '<em><b>Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height As String</em>' attribute.
	 * @see #setHeightAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRightCircularCylinder_HeightAsString()
	 * @model
	 * @generated
	 */
	String getHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCylinder#getHeightAsString <em>Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height As String</em>' attribute.
	 * @see #getHeightAsString()
	 * @generated
	 */
	void setHeightAsString(String value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRightCircularCylinder_Radius()
	 * @model
	 * @generated
	 */
	float getRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCylinder#getRadius <em>Radius</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRightCircularCylinder_RadiusAsString()
	 * @model
	 * @generated
	 */
	String getRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCylinder#getRadiusAsString <em>Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius As String</em>' attribute.
	 * @see #getRadiusAsString()
	 * @generated
	 */
	void setRadiusAsString(String value);

} // IfcRightCircularCylinder
