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
import org.bimserver.models.ifc4.IfcStructuralLoadPlanarForce;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Planar Force</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceX <em>Planar Force X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceXAsString <em>Planar Force XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceY <em>Planar Force Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceYAsString <em>Planar Force YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceZ <em>Planar Force Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceZAsString <em>Planar Force ZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadPlanarForceImpl extends IfcStructuralLoadStaticImpl implements IfcStructuralLoadPlanarForce {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadPlanarForceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPlanarForceX() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlanarForceX(double newPlanarForceX) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_X, newPlanarForceX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPlanarForceX() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPlanarForceX() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPlanarForceXAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlanarForceXAsString(String newPlanarForceXAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_XAS_STRING, newPlanarForceXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPlanarForceXAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPlanarForceXAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPlanarForceY() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlanarForceY(double newPlanarForceY) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Y, newPlanarForceY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPlanarForceY() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPlanarForceY() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPlanarForceYAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlanarForceYAsString(String newPlanarForceYAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_YAS_STRING, newPlanarForceYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPlanarForceYAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPlanarForceYAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPlanarForceZ() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlanarForceZ(double newPlanarForceZ) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Z, newPlanarForceZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPlanarForceZ() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPlanarForceZ() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPlanarForceZAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlanarForceZAsString(String newPlanarForceZAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_ZAS_STRING, newPlanarForceZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPlanarForceZAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPlanarForceZAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_ZAS_STRING);
	}

} //IfcStructuralLoadPlanarForceImpl
