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
 * A representation of the model object '<em><b>Ifc Fill Area Style Tiles</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcFillAreaStyleTiles#getTilingPattern <em>Tiling Pattern</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcFillAreaStyleTiles#getTiles <em>Tiles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcFillAreaStyleTiles#getTilingScale <em>Tiling Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcFillAreaStyleTiles#getTilingScaleAsString <em>Tiling Scale As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFillAreaStyleTiles()
 * @model
 * @generated
 */
public interface IfcFillAreaStyleTiles extends IfcGeometricRepresentationItem, IfcFillStyleSelect {
	/**
	 * Returns the value of the '<em><b>Tiling Pattern</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcVector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiling Pattern</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiling Pattern</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFillAreaStyleTiles_TilingPattern()
	 * @model
	 * @generated
	 */
	EList<IfcVector> getTilingPattern();

	/**
	 * Returns the value of the '<em><b>Tiles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcStyledItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiles</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFillAreaStyleTiles_Tiles()
	 * @model
	 * @generated
	 */
	EList<IfcStyledItem> getTiles();

	/**
	 * Returns the value of the '<em><b>Tiling Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiling Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiling Scale</em>' attribute.
	 * @see #setTilingScale(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFillAreaStyleTiles_TilingScale()
	 * @model
	 * @generated
	 */
	double getTilingScale();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFillAreaStyleTiles#getTilingScale <em>Tiling Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiling Scale</em>' attribute.
	 * @see #getTilingScale()
	 * @generated
	 */
	void setTilingScale(double value);

	/**
	 * Returns the value of the '<em><b>Tiling Scale As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiling Scale As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiling Scale As String</em>' attribute.
	 * @see #setTilingScaleAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFillAreaStyleTiles_TilingScaleAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTilingScaleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFillAreaStyleTiles#getTilingScaleAsString <em>Tiling Scale As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiling Scale As String</em>' attribute.
	 * @see #getTilingScaleAsString()
	 * @generated
	 */
	void setTilingScaleAsString(String value);

} // IfcFillAreaStyleTiles
