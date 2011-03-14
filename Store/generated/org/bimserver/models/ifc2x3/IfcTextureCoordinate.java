/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Texture Coordinate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextureCoordinate#getAnnotatedSurface <em>Annotated Surface</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextureCoordinate()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcTextureCoordinate extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Annotated Surface</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcAnnotationSurface}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcAnnotationSurface#getTextureCoordinates <em>Texture Coordinates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotated Surface</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotated Surface</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextureCoordinate_AnnotatedSurface()
	 * @see org.bimserver.models.ifc2x3.IfcAnnotationSurface#getTextureCoordinates
	 * @model opposite="TextureCoordinates" upper="2"
	 * @generated
	 */
	EList<IfcAnnotationSurface> getAnnotatedSurface();

} // IfcTextureCoordinate
