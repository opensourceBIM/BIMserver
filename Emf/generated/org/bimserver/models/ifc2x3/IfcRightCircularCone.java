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
 * A representation of the model object '<em><b>Ifc Right Circular Cone</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getHeight <em>Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getHeightAsString <em>Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getBottomRadius <em>Bottom Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getBottomRadiusAsString <em>Bottom Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRightCircularCone()
 * @model
 * @generated
 */
public interface IfcRightCircularCone extends IfcCsgPrimitive3D {
	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #isSetHeight()
	 * @see #unsetHeight()
	 * @see #setHeight(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRightCircularCone_Height()
	 * @model unsettable="true"
	 * @generated
	 */
	double getHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #isSetHeight()
	 * @see #unsetHeight()
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeight()
	 * @see #getHeight()
	 * @see #setHeight(double)
	 * @generated
	 */
	void unsetHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getHeight <em>Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Height</em>' attribute is set.
	 * @see #unsetHeight()
	 * @see #getHeight()
	 * @see #setHeight(double)
	 * @generated
	 */
	boolean isSetHeight();

	/**
	 * Returns the value of the '<em><b>Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height As String</em>' attribute.
	 * @see #isSetHeightAsString()
	 * @see #unsetHeightAsString()
	 * @see #setHeightAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRightCircularCone_HeightAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getHeightAsString <em>Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height As String</em>' attribute.
	 * @see #isSetHeightAsString()
	 * @see #unsetHeightAsString()
	 * @see #getHeightAsString()
	 * @generated
	 */
	void setHeightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getHeightAsString <em>Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeightAsString()
	 * @see #getHeightAsString()
	 * @see #setHeightAsString(String)
	 * @generated
	 */
	void unsetHeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getHeightAsString <em>Height As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Height As String</em>' attribute is set.
	 * @see #unsetHeightAsString()
	 * @see #getHeightAsString()
	 * @see #setHeightAsString(String)
	 * @generated
	 */
	boolean isSetHeightAsString();

	/**
	 * Returns the value of the '<em><b>Bottom Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Radius</em>' attribute.
	 * @see #isSetBottomRadius()
	 * @see #unsetBottomRadius()
	 * @see #setBottomRadius(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRightCircularCone_BottomRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBottomRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getBottomRadius <em>Bottom Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Radius</em>' attribute.
	 * @see #isSetBottomRadius()
	 * @see #unsetBottomRadius()
	 * @see #getBottomRadius()
	 * @generated
	 */
	void setBottomRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getBottomRadius <em>Bottom Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomRadius()
	 * @see #getBottomRadius()
	 * @see #setBottomRadius(double)
	 * @generated
	 */
	void unsetBottomRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getBottomRadius <em>Bottom Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom Radius</em>' attribute is set.
	 * @see #unsetBottomRadius()
	 * @see #getBottomRadius()
	 * @see #setBottomRadius(double)
	 * @generated
	 */
	boolean isSetBottomRadius();

	/**
	 * Returns the value of the '<em><b>Bottom Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Radius As String</em>' attribute.
	 * @see #isSetBottomRadiusAsString()
	 * @see #unsetBottomRadiusAsString()
	 * @see #setBottomRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRightCircularCone_BottomRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBottomRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getBottomRadiusAsString <em>Bottom Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Radius As String</em>' attribute.
	 * @see #isSetBottomRadiusAsString()
	 * @see #unsetBottomRadiusAsString()
	 * @see #getBottomRadiusAsString()
	 * @generated
	 */
	void setBottomRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getBottomRadiusAsString <em>Bottom Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomRadiusAsString()
	 * @see #getBottomRadiusAsString()
	 * @see #setBottomRadiusAsString(String)
	 * @generated
	 */
	void unsetBottomRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRightCircularCone#getBottomRadiusAsString <em>Bottom Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom Radius As String</em>' attribute is set.
	 * @see #unsetBottomRadiusAsString()
	 * @see #getBottomRadiusAsString()
	 * @see #setBottomRadiusAsString(String)
	 * @generated
	 */
	boolean isSetBottomRadiusAsString();

} // IfcRightCircularCone
