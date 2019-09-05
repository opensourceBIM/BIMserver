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
import org.bimserver.models.ifc4.IfcPlanarExtent;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Planar Extent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPlanarExtentImpl#getSizeInX <em>Size In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPlanarExtentImpl#getSizeInXAsString <em>Size In XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPlanarExtentImpl#getSizeInY <em>Size In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPlanarExtentImpl#getSizeInYAsString <em>Size In YAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPlanarExtentImpl extends IfcGeometricRepresentationItemImpl implements IfcPlanarExtent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPlanarExtentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_PLANAR_EXTENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSizeInX() {
		return (Double) eGet(Ifc4Package.Literals.IFC_PLANAR_EXTENT__SIZE_IN_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSizeInX(double newSizeInX) {
		eSet(Ifc4Package.Literals.IFC_PLANAR_EXTENT__SIZE_IN_X, newSizeInX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSizeInXAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_PLANAR_EXTENT__SIZE_IN_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSizeInXAsString(String newSizeInXAsString) {
		eSet(Ifc4Package.Literals.IFC_PLANAR_EXTENT__SIZE_IN_XAS_STRING, newSizeInXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSizeInY() {
		return (Double) eGet(Ifc4Package.Literals.IFC_PLANAR_EXTENT__SIZE_IN_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSizeInY(double newSizeInY) {
		eSet(Ifc4Package.Literals.IFC_PLANAR_EXTENT__SIZE_IN_Y, newSizeInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSizeInYAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_PLANAR_EXTENT__SIZE_IN_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSizeInYAsString(String newSizeInYAsString) {
		eSet(Ifc4Package.Literals.IFC_PLANAR_EXTENT__SIZE_IN_YAS_STRING, newSizeInYAsString);
	}

} //IfcPlanarExtentImpl
