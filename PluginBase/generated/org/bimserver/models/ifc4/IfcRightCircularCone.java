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
package org.bimserver.models.ifc4;

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
	 * @see #setHeight(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRightCircularCone_Height()
	 * @model
	 * @generated
	 */
	double getHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRightCircularCone#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(double value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRightCircularCone_HeightAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRightCircularCone#getHeightAsString <em>Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height As String</em>' attribute.
	 * @see #getHeightAsString()
	 * @generated
	 */
	void setHeightAsString(String value);

	/**
	 * Returns the value of the '<em><b>Bottom Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Radius</em>' attribute.
	 * @see #setBottomRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRightCircularCone_BottomRadius()
	 * @model
	 * @generated
	 */
	double getBottomRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRightCircularCone#getBottomRadius <em>Bottom Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Radius</em>' attribute.
	 * @see #getBottomRadius()
	 * @generated
	 */
	void setBottomRadius(double value);

	/**
	 * Returns the value of the '<em><b>Bottom Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Radius As String</em>' attribute.
	 * @see #setBottomRadiusAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRightCircularCone_BottomRadiusAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getBottomRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRightCircularCone#getBottomRadiusAsString <em>Bottom Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Radius As String</em>' attribute.
	 * @see #getBottomRadiusAsString()
	 * @generated
	 */
	void setBottomRadiusAsString(String value);

} // IfcRightCircularCone
