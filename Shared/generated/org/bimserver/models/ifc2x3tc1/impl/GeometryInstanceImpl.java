/**
 * Copyright (C) 2009-2013 BIMserver.org
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
package org.bimserver.models.ifc2x3tc1.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3tc1.GeometryData;
import org.bimserver.models.ifc2x3tc1.GeometryInstance;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geometry Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInstanceImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInstanceImpl#getTransformation <em>Transformation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeometryInstanceImpl extends IdEObjectImpl implements GeometryInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeometryInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE;
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
	public GeometryData getData() {
		return (GeometryData) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(GeometryData newData) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__DATA, newData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getTransformation() {
		return (byte[]) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__TRANSFORMATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformation(byte[] newTransformation) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__TRANSFORMATION, newTransformation);
	}

} //GeometryInstanceImpl
