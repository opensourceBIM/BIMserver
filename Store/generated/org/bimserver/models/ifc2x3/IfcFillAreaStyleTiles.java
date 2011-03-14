/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
	 * @see #setTilingPattern(IfcOneDirectionRepeatFactor)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyleTiles_TilingPattern()
	 * @model
	 * @generated
	 */
	IfcOneDirectionRepeatFactor getTilingPattern();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingPattern <em>Tiling Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiling Pattern</em>' reference.
	 * @see #getTilingPattern()
	 * @generated
	 */
	void setTilingPattern(IfcOneDirectionRepeatFactor value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyleTiles_Tiles()
	 * @model
	 * @generated
	 */
	EList<IfcFillAreaStyleTileShapeSelect> getTiles();

	/**
	 * Returns the value of the '<em><b>Tiling Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tiling Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiling Scale</em>' attribute.
	 * @see #setTilingScale(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyleTiles_TilingScale()
	 * @model
	 * @generated
	 */
	float getTilingScale();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingScale <em>Tiling Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiling Scale</em>' attribute.
	 * @see #getTilingScale()
	 * @generated
	 */
	void setTilingScale(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyleTiles_TilingScaleAsString()
	 * @model
	 * @generated
	 */
	String getTilingScaleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTiles#getTilingScaleAsString <em>Tiling Scale As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiling Scale As String</em>' attribute.
	 * @see #getTilingScaleAsString()
	 * @generated
	 */
	void setTilingScaleAsString(String value);

} // IfcFillAreaStyleTiles
