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
package org.bimserver.models.ifc2x3tc1;

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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Texture Coordinate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTextureCoordinate#getAnnotatedSurface <em>Annotated Surface</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextureCoordinate()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcTextureCoordinate extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Annotated Surface</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcAnnotationSurface}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcAnnotationSurface#getTextureCoordinates <em>Texture Coordinates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotated Surface</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotated Surface</em>' reference list.
	 * @see #isSetAnnotatedSurface()
	 * @see #unsetAnnotatedSurface()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextureCoordinate_AnnotatedSurface()
	 * @see org.bimserver.models.ifc2x3tc1.IfcAnnotationSurface#getTextureCoordinates
	 * @model opposite="TextureCoordinates" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcAnnotationSurface> getAnnotatedSurface();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextureCoordinate#getAnnotatedSurface <em>Annotated Surface</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAnnotatedSurface()
	 * @see #getAnnotatedSurface()
	 * @generated
	 */
	void unsetAnnotatedSurface();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextureCoordinate#getAnnotatedSurface <em>Annotated Surface</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Annotated Surface</em>' reference list is set.
	 * @see #unsetAnnotatedSurface()
	 * @see #getAnnotatedSurface()
	 * @generated
	 */
	boolean isSetAnnotatedSurface();

} // IfcTextureCoordinate
