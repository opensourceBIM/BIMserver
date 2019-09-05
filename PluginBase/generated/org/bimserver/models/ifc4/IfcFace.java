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
 * A representation of the model object '<em><b>Ifc Face</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcFace#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcFace#getHasTextureMaps <em>Has Texture Maps</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFace()
 * @model
 * @generated
 */
public interface IfcFace extends IfcTopologicalRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Bounds</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcFaceBound}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFace_Bounds()
	 * @model
	 * @generated
	 */
	EList<IfcFaceBound> getBounds();

	/**
	 * Returns the value of the '<em><b>Has Texture Maps</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcTextureMap}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcTextureMap#getMappedTo <em>Mapped To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Texture Maps</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Texture Maps</em>' reference list.
	 * @see #isSetHasTextureMaps()
	 * @see #unsetHasTextureMaps()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFace_HasTextureMaps()
	 * @see org.bimserver.models.ifc4.IfcTextureMap#getMappedTo
	 * @model opposite="MappedTo" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcTextureMap> getHasTextureMaps();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFace#getHasTextureMaps <em>Has Texture Maps</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasTextureMaps()
	 * @see #getHasTextureMaps()
	 * @generated
	 */
	void unsetHasTextureMaps();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFace#getHasTextureMaps <em>Has Texture Maps</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Texture Maps</em>' reference list is set.
	 * @see #unsetHasTextureMaps()
	 * @see #getHasTextureMaps()
	 * @generated
	 */
	boolean isSetHasTextureMaps();

} // IfcFace
