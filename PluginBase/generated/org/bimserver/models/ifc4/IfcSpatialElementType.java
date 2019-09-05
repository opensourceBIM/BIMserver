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

public interface IfcSpatialElementType extends IfcTypeProduct {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' attribute.
	 * @see #isSetElementType()
	 * @see #unsetElementType()
	 * @see #setElementType(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpatialElementType_ElementType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getElementType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElementType#getElementType <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' attribute.
	 * @see #isSetElementType()
	 * @see #unsetElementType()
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElementType#getElementType <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElementType()
	 * @see #getElementType()
	 * @see #setElementType(String)
	 * @generated
	 */
	void unsetElementType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSpatialElementType#getElementType <em>Element Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Element Type</em>' attribute is set.
	 * @see #unsetElementType()
	 * @see #getElementType()
	 * @see #setElementType(String)
	 * @generated
	 */
	boolean isSetElementType();

} // IfcSpatialElementType
