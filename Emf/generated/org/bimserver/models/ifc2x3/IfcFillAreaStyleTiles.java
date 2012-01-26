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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Fill Area Style Tiles</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingPattern <em>Tiling Pattern</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTiles <em>Tiles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingScale <em>Tiling Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingScaleAsString <em>Tiling Scale As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyleTiles()
 * @model
 * @generated
 */
public interface IfcFillAreaStyleTiles extends IfcGeometricRepresentationItem, IfcFillStyleSelect {
	/**
	 * Returns the value of the '<em><b>Tiling Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiling Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiling Pattern</em>' reference.
	 * @see #isSetTilingPattern()
	 * @see #unsetTilingPattern()
	 * @see #setTilingPattern(IfcOneDirectionRepeatFactor)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyleTiles_TilingPattern()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcOneDirectionRepeatFactor getTilingPattern();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingPattern <em>Tiling Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiling Pattern</em>' reference.
	 * @see #isSetTilingPattern()
	 * @see #unsetTilingPattern()
	 * @see #getTilingPattern()
	 * @generated
	 */
	void setTilingPattern(IfcOneDirectionRepeatFactor value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingPattern <em>Tiling Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTilingPattern()
	 * @see #getTilingPattern()
	 * @see #setTilingPattern(IfcOneDirectionRepeatFactor)
	 * @generated
	 */
	void unsetTilingPattern();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingPattern <em>Tiling Pattern</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tiling Pattern</em>' reference is set.
	 * @see #unsetTilingPattern()
	 * @see #getTilingPattern()
	 * @see #setTilingPattern(IfcOneDirectionRepeatFactor)
	 * @generated
	 */
	boolean isSetTilingPattern();

	/**
	 * Returns the value of the '<em><b>Tiles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTileShapeSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiles</em>' reference list.
	 * @see #isSetTiles()
	 * @see #unsetTiles()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyleTiles_Tiles()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcFillAreaStyleTileShapeSelect> getTiles();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTiles <em>Tiles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTiles()
	 * @see #getTiles()
	 * @generated
	 */
	void unsetTiles();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTiles <em>Tiles</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tiles</em>' reference list is set.
	 * @see #unsetTiles()
	 * @see #getTiles()
	 * @generated
	 */
	boolean isSetTiles();

	/**
	 * Returns the value of the '<em><b>Tiling Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiling Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiling Scale</em>' attribute.
	 * @see #isSetTilingScale()
	 * @see #unsetTilingScale()
	 * @see #setTilingScale(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyleTiles_TilingScale()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTilingScale();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingScale <em>Tiling Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiling Scale</em>' attribute.
	 * @see #isSetTilingScale()
	 * @see #unsetTilingScale()
	 * @see #getTilingScale()
	 * @generated
	 */
	void setTilingScale(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingScale <em>Tiling Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTilingScale()
	 * @see #getTilingScale()
	 * @see #setTilingScale(double)
	 * @generated
	 */
	void unsetTilingScale();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingScale <em>Tiling Scale</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tiling Scale</em>' attribute is set.
	 * @see #unsetTilingScale()
	 * @see #getTilingScale()
	 * @see #setTilingScale(double)
	 * @generated
	 */
	boolean isSetTilingScale();

	/**
	 * Returns the value of the '<em><b>Tiling Scale As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiling Scale As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiling Scale As String</em>' attribute.
	 * @see #isSetTilingScaleAsString()
	 * @see #unsetTilingScaleAsString()
	 * @see #setTilingScaleAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyleTiles_TilingScaleAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTilingScaleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingScaleAsString <em>Tiling Scale As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiling Scale As String</em>' attribute.
	 * @see #isSetTilingScaleAsString()
	 * @see #unsetTilingScaleAsString()
	 * @see #getTilingScaleAsString()
	 * @generated
	 */
	void setTilingScaleAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingScaleAsString <em>Tiling Scale As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTilingScaleAsString()
	 * @see #getTilingScaleAsString()
	 * @see #setTilingScaleAsString(String)
	 * @generated
	 */
	void unsetTilingScaleAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingScaleAsString <em>Tiling Scale As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tiling Scale As String</em>' attribute is set.
	 * @see #unsetTilingScaleAsString()
	 * @see #getTilingScaleAsString()
	 * @see #setTilingScaleAsString(String)
	 * @generated
	 */
	boolean isSetTilingScaleAsString();

} // IfcFillAreaStyleTiles
