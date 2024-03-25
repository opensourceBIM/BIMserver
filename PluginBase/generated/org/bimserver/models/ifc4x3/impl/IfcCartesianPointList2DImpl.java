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
import org.bimserver.models.ifc4x3.IfcCartesianPointList2D;
import org.bimserver.models.ifc4x3.ListOfIfcLengthMeasure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cartesian Point List2 D</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCartesianPointList2DImpl#getCoordList <em>Coord List</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCartesianPointList2DImpl#getTagList <em>Tag List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCartesianPointList2DImpl extends IfcCartesianPointListImpl implements IfcCartesianPointList2D {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCartesianPointList2DImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_CARTESIAN_POINT_LIST2_D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ListOfIfcLengthMeasure> getCoordList() {
		return (EList<ListOfIfcLengthMeasure>) eGet(Ifc4x3Package.Literals.IFC_CARTESIAN_POINT_LIST2_D__COORD_LIST,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getTagList() {
		return (EList<String>) eGet(Ifc4x3Package.Literals.IFC_CARTESIAN_POINT_LIST2_D__TAG_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTagList() {
		eUnset(Ifc4x3Package.Literals.IFC_CARTESIAN_POINT_LIST2_D__TAG_LIST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTagList() {
		return eIsSet(Ifc4x3Package.Literals.IFC_CARTESIAN_POINT_LIST2_D__TAG_LIST);
	}

} //IfcCartesianPointList2DImpl
