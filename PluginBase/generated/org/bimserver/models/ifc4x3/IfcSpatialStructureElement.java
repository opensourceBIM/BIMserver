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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Spatial Structure Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSpatialStructureElement#getCompositionType <em>Composition Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSpatialStructureElement()
 * @model
 * @generated
 */
public interface IfcSpatialStructureElement extends IfcSpatialElement {
	/**
	 * Returns the value of the '<em><b>Composition Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcElementCompositionEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcElementCompositionEnum
	 * @see #isSetCompositionType()
	 * @see #unsetCompositionType()
	 * @see #setCompositionType(IfcElementCompositionEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSpatialStructureElement_CompositionType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcElementCompositionEnum getCompositionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSpatialStructureElement#getCompositionType <em>Composition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composition Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcElementCompositionEnum
	 * @see #isSetCompositionType()
	 * @see #unsetCompositionType()
	 * @see #getCompositionType()
	 * @generated
	 */
	void setCompositionType(IfcElementCompositionEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSpatialStructureElement#getCompositionType <em>Composition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompositionType()
	 * @see #getCompositionType()
	 * @see #setCompositionType(IfcElementCompositionEnum)
	 * @generated
	 */
	void unsetCompositionType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSpatialStructureElement#getCompositionType <em>Composition Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Composition Type</em>' attribute is set.
	 * @see #unsetCompositionType()
	 * @see #getCompositionType()
	 * @see #setCompositionType(IfcElementCompositionEnum)
	 * @generated
	 */
	boolean isSetCompositionType();

} // IfcSpatialStructureElement
