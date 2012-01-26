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
 * A representation of the model object '<em><b>Ifc Stair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStair#getShapeType <em>Shape Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStair()
 * @model
 * @generated
 */
public interface IfcStair extends IfcBuildingElement {
	/**
	 * Returns the value of the '<em><b>Shape Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcStairTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcStairTypeEnum
	 * @see #isSetShapeType()
	 * @see #unsetShapeType()
	 * @see #setShapeType(IfcStairTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStair_ShapeType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcStairTypeEnum getShapeType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStair#getShapeType <em>Shape Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcStairTypeEnum
	 * @see #isSetShapeType()
	 * @see #unsetShapeType()
	 * @see #getShapeType()
	 * @generated
	 */
	void setShapeType(IfcStairTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStair#getShapeType <em>Shape Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShapeType()
	 * @see #getShapeType()
	 * @see #setShapeType(IfcStairTypeEnum)
	 * @generated
	 */
	void unsetShapeType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStair#getShapeType <em>Shape Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shape Type</em>' attribute is set.
	 * @see #unsetShapeType()
	 * @see #getShapeType()
	 * @see #setShapeType(IfcStairTypeEnum)
	 * @generated
	 */
	boolean isSetShapeType();

} // IfcStair
