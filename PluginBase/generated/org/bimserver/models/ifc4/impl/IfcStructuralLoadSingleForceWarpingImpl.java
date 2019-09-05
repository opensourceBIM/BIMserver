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
import org.bimserver.models.ifc4.IfcStructuralLoadSingleForceWarping;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Force Warping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadSingleForceWarpingImpl#getWarpingMoment <em>Warping Moment</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadSingleForceWarpingImpl#getWarpingMomentAsString <em>Warping Moment As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadSingleForceWarpingImpl extends IfcStructuralLoadSingleForceImpl implements IfcStructuralLoadSingleForceWarping {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadSingleForceWarpingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWarpingMoment() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING__WARPING_MOMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWarpingMoment(double newWarpingMoment) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING__WARPING_MOMENT, newWarpingMoment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWarpingMoment() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING__WARPING_MOMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWarpingMoment() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING__WARPING_MOMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWarpingMomentAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING__WARPING_MOMENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWarpingMomentAsString(String newWarpingMomentAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING__WARPING_MOMENT_AS_STRING, newWarpingMomentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWarpingMomentAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING__WARPING_MOMENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWarpingMomentAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING__WARPING_MOMENT_AS_STRING);
	}

} //IfcStructuralLoadSingleForceWarpingImpl
