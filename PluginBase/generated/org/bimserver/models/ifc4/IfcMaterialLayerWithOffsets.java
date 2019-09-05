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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Material Layer With Offsets</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterialLayerWithOffsets#getOffsetDirection <em>Offset Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterialLayerWithOffsets#getOffsetValues <em>Offset Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterialLayerWithOffsets#getOffsetValuesAsString <em>Offset Values As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayerWithOffsets()
 * @model
 * @generated
 */
public interface IfcMaterialLayerWithOffsets extends IfcMaterialLayer {
	/**
	 * Returns the value of the '<em><b>Offset Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcLayerSetDirectionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Direction</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcLayerSetDirectionEnum
	 * @see #setOffsetDirection(IfcLayerSetDirectionEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayerWithOffsets_OffsetDirection()
	 * @model
	 * @generated
	 */
	IfcLayerSetDirectionEnum getOffsetDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayerWithOffsets#getOffsetDirection <em>Offset Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Direction</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcLayerSetDirectionEnum
	 * @see #getOffsetDirection()
	 * @generated
	 */
	void setOffsetDirection(IfcLayerSetDirectionEnum value);

	/**
	 * Returns the value of the '<em><b>Offset Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Values</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayerWithOffsets_OffsetValues()
	 * @model unique="false"
	 * @generated
	 */
	EList<Double> getOffsetValues();

	/**
	 * Returns the value of the '<em><b>Offset Values As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset Values As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Values As String</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayerWithOffsets_OffsetValuesAsString()
	 * @model unique="false"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getOffsetValuesAsString();

} // IfcMaterialLayerWithOffsets
