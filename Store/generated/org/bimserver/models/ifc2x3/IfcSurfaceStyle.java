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
 * A representation of the model object '<em><b>Ifc Surface Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceStyle#getSide <em>Side</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceStyle#getStyles <em>Styles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyle()
 * @model
 * @generated
 */
public interface IfcSurfaceStyle extends IfcPresentationStyle, IfcPresentationStyleSelect {
	/**
	 * Returns the value of the '<em><b>Side</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcSurfaceSide}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Side</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Side</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcSurfaceSide
	 * @see #setSide(IfcSurfaceSide)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyle_Side()
	 * @model
	 * @generated
	 */
	IfcSurfaceSide getSide();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyle#getSide <em>Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Side</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcSurfaceSide
	 * @see #getSide()
	 * @generated
	 */
	void setSide(IfcSurfaceSide value);

	/**
	 * Returns the value of the '<em><b>Styles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcSurfaceStyleElementSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Styles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Styles</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyle_Styles()
	 * @model
	 * @generated
	 */
	EList<IfcSurfaceStyleElementSelect> getStyles();

} // IfcSurfaceStyle
