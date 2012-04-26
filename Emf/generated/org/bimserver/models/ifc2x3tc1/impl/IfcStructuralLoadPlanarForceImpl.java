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
package org.bimserver.models.ifc2x3tc1.impl;

import org.bimserver.models.ifc2x3tc1.IfcStructuralLoadPlanarForce;
import org.bimserver.models.ifc2x3tc1.LogPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Planar Force</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceX <em>Planar Force X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceXAsString <em>Planar Force XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceY <em>Planar Force Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceYAsString <em>Planar Force YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceZ <em>Planar Force Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadPlanarForceImpl#getPlanarForceZAsString <em>Planar Force ZAs String</em>}</li>
 * </ul>
 * </p>
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
		return LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPlanarForceX() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlanarForceX(double newPlanarForceX) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_X, newPlanarForceX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlanarForceX() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlanarForceX() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlanarForceXAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlanarForceXAsString(String newPlanarForceXAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_XAS_STRING, newPlanarForceXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlanarForceXAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlanarForceXAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPlanarForceY() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlanarForceY(double newPlanarForceY) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Y, newPlanarForceY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlanarForceY() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlanarForceY() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlanarForceYAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlanarForceYAsString(String newPlanarForceYAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_YAS_STRING, newPlanarForceYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlanarForceYAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlanarForceYAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPlanarForceZ() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlanarForceZ(double newPlanarForceZ) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Z, newPlanarForceZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlanarForceZ() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlanarForceZ() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlanarForceZAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlanarForceZAsString(String newPlanarForceZAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_ZAS_STRING, newPlanarForceZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlanarForceZAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlanarForceZAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_PLANAR_FORCE__PLANAR_FORCE_ZAS_STRING);
	}

} //IfcStructuralLoadPlanarForceImpl
