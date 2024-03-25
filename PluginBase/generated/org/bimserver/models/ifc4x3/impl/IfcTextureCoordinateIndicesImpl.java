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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcIndexedPolygonalFace;
import org.bimserver.models.ifc4x3.IfcIndexedPolygonalTextureMap;
import org.bimserver.models.ifc4x3.IfcTextureCoordinateIndices;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Texture Coordinate Indices</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTextureCoordinateIndicesImpl#getTexCoordIndex <em>Tex Coord Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTextureCoordinateIndicesImpl#getTexCoordsOf <em>Tex Coords Of</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTextureCoordinateIndicesImpl#getToTexMap <em>To Tex Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTextureCoordinateIndicesImpl extends IdEObjectImpl implements IfcTextureCoordinateIndices {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextureCoordinateIndicesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_TEXTURE_COORDINATE_INDICES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Long> getTexCoordIndex() {
		return (EList<Long>) eGet(Ifc4x3Package.Literals.IFC_TEXTURE_COORDINATE_INDICES__TEX_COORD_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIndexedPolygonalFace getTexCoordsOf() {
		return (IfcIndexedPolygonalFace) eGet(Ifc4x3Package.Literals.IFC_TEXTURE_COORDINATE_INDICES__TEX_COORDS_OF,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTexCoordsOf(IfcIndexedPolygonalFace newTexCoordsOf) {
		eSet(Ifc4x3Package.Literals.IFC_TEXTURE_COORDINATE_INDICES__TEX_COORDS_OF, newTexCoordsOf);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIndexedPolygonalTextureMap getToTexMap() {
		return (IfcIndexedPolygonalTextureMap) eGet(Ifc4x3Package.Literals.IFC_TEXTURE_COORDINATE_INDICES__TO_TEX_MAP,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setToTexMap(IfcIndexedPolygonalTextureMap newToTexMap) {
		eSet(Ifc4x3Package.Literals.IFC_TEXTURE_COORDINATE_INDICES__TO_TEX_MAP, newToTexMap);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetToTexMap() {
		eUnset(Ifc4x3Package.Literals.IFC_TEXTURE_COORDINATE_INDICES__TO_TEX_MAP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetToTexMap() {
		return eIsSet(Ifc4x3Package.Literals.IFC_TEXTURE_COORDINATE_INDICES__TO_TEX_MAP);
	}

} //IfcTextureCoordinateIndicesImpl
