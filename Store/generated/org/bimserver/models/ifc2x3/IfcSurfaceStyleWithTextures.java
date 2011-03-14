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
 * A representation of the model object '<em><b>Ifc Surface Style With Textures</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleWithTextures#getTextures <em>Textures</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleWithTextures()
 * @model
 * @generated
 */
public interface IfcSurfaceStyleWithTextures extends IfcSurfaceStyleElementSelect {
	/**
	 * Returns the value of the '<em><b>Textures</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcSurfaceTexture}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textures</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Textures</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleWithTextures_Textures()
	 * @model
	 * @generated
	 */
	EList<IfcSurfaceTexture> getTextures();

} // IfcSurfaceStyleWithTextures
