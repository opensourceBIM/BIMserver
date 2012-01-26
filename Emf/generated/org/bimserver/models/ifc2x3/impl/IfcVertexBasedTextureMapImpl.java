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
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCartesianPoint;
import org.bimserver.models.ifc2x3.IfcTextureVertex;
import org.bimserver.models.ifc2x3.IfcVertexBasedTextureMap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Vertex Based Texture Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVertexBasedTextureMapImpl#getTextureVertices <em>Texture Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVertexBasedTextureMapImpl#getTexturePoints <em>Texture Points</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcVertexBasedTextureMapImpl extends IdEObjectImpl implements IfcVertexBasedTextureMap {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcVertexBasedTextureMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.Literals.IFC_VERTEX_BASED_TEXTURE_MAP;
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
	public EList<IfcTextureVertex> getTextureVertices() {
		return (EList<IfcTextureVertex>) eGet(Ifc2x3Package.Literals.IFC_VERTEX_BASED_TEXTURE_MAP__TEXTURE_VERTICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextureVertices() {
		eUnset(Ifc2x3Package.Literals.IFC_VERTEX_BASED_TEXTURE_MAP__TEXTURE_VERTICES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextureVertices() {
		return eIsSet(Ifc2x3Package.Literals.IFC_VERTEX_BASED_TEXTURE_MAP__TEXTURE_VERTICES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcCartesianPoint> getTexturePoints() {
		return (EList<IfcCartesianPoint>) eGet(Ifc2x3Package.Literals.IFC_VERTEX_BASED_TEXTURE_MAP__TEXTURE_POINTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTexturePoints() {
		eUnset(Ifc2x3Package.Literals.IFC_VERTEX_BASED_TEXTURE_MAP__TEXTURE_POINTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTexturePoints() {
		return eIsSet(Ifc2x3Package.Literals.IFC_VERTEX_BASED_TEXTURE_MAP__TEXTURE_POINTS);
	}

} //IfcVertexBasedTextureMapImpl
