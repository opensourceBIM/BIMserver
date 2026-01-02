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
import org.bimserver.models.ifc4x3.IfcStructuralLoadSingleForceWarping;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Force Warping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceWarpingImpl#getWarpingMoment <em>Warping Moment</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceWarpingImpl#getWarpingMomentAsString <em>Warping Moment As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadSingleForceWarpingImpl extends IfcStructuralLoadSingleForceImpl
		implements IfcStructuralLoadSingleForceWarping {
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
		return Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWarpingMoment() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWarpingMoment(double newWarpingMoment) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment(), newWarpingMoment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWarpingMoment() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWarpingMoment() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWarpingMomentAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWarpingMomentAsString(String newWarpingMomentAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString(),
				newWarpingMomentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWarpingMomentAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWarpingMomentAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString());
	}

} //IfcStructuralLoadSingleForceWarpingImpl
