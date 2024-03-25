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

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcFace;
import org.bimserver.models.ifc4x3.IfcFaceBound;
import org.bimserver.models.ifc4x3.IfcTextureMap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Face</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcFaceImpl#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcFaceImpl#getHasTextureMaps <em>Has Texture Maps</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcFaceImpl extends IfcTopologicalRepresentationItemImpl implements IfcFace {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_FACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcFaceBound> getBounds() {
		return (EList<IfcFaceBound>) eGet(Ifc4x3Package.Literals.IFC_FACE__BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcTextureMap> getHasTextureMaps() {
		return (EList<IfcTextureMap>) eGet(Ifc4x3Package.Literals.IFC_FACE__HAS_TEXTURE_MAPS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasTextureMaps() {
		eUnset(Ifc4x3Package.Literals.IFC_FACE__HAS_TEXTURE_MAPS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasTextureMaps() {
		return eIsSet(Ifc4x3Package.Literals.IFC_FACE__HAS_TEXTURE_MAPS);
	}

} //IfcFaceImpl
