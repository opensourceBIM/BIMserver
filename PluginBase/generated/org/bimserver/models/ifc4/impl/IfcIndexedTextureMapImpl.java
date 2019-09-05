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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcIndexedTextureMap;
import org.bimserver.models.ifc4.IfcTessellatedFaceSet;
import org.bimserver.models.ifc4.IfcTextureVertexList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Indexed Texture Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcIndexedTextureMapImpl#getMappedTo <em>Mapped To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcIndexedTextureMapImpl#getTexCoords <em>Tex Coords</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcIndexedTextureMapImpl extends IfcTextureCoordinateImpl implements IfcIndexedTextureMap {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcIndexedTextureMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_INDEXED_TEXTURE_MAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTessellatedFaceSet getMappedTo() {
		return (IfcTessellatedFaceSet) eGet(Ifc4Package.Literals.IFC_INDEXED_TEXTURE_MAP__MAPPED_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappedTo(IfcTessellatedFaceSet newMappedTo) {
		eSet(Ifc4Package.Literals.IFC_INDEXED_TEXTURE_MAP__MAPPED_TO, newMappedTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextureVertexList getTexCoords() {
		return (IfcTextureVertexList) eGet(Ifc4Package.Literals.IFC_INDEXED_TEXTURE_MAP__TEX_COORDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTexCoords(IfcTextureVertexList newTexCoords) {
		eSet(Ifc4Package.Literals.IFC_INDEXED_TEXTURE_MAP__TEX_COORDS, newTexCoords);
	}

} //IfcIndexedTextureMapImpl
