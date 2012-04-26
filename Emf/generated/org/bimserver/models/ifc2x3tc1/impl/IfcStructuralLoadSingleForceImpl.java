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

import org.bimserver.models.ifc2x3tc1.IfcStructuralLoadSingleForce;
import org.bimserver.models.ifc2x3tc1.LogPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Force</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getForceX <em>Force X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getForceXAsString <em>Force XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getForceY <em>Force Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getForceYAsString <em>Force YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getForceZ <em>Force Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getForceZAsString <em>Force ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getMomentX <em>Moment X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getMomentXAsString <em>Moment XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getMomentY <em>Moment Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getMomentYAsString <em>Moment YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getMomentZ <em>Moment Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleForceImpl#getMomentZAsString <em>Moment ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralLoadSingleForceImpl extends IfcStructuralLoadStaticImpl implements IfcStructuralLoadSingleForce {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadSingleForceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getForceX() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForceX(double newForceX) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_X, newForceX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetForceX() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetForceX() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getForceXAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForceXAsString(String newForceXAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_XAS_STRING, newForceXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetForceXAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetForceXAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getForceY() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForceY(double newForceY) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_Y, newForceY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetForceY() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetForceY() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getForceYAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForceYAsString(String newForceYAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_YAS_STRING, newForceYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetForceYAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetForceYAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getForceZ() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForceZ(double newForceZ) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_Z, newForceZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetForceZ() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetForceZ() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getForceZAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForceZAsString(String newForceZAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_ZAS_STRING, newForceZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetForceZAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetForceZAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__FORCE_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMomentX() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentX(double newMomentX) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_X, newMomentX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentX() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentX() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMomentXAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentXAsString(String newMomentXAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_XAS_STRING, newMomentXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentXAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentXAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMomentY() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentY(double newMomentY) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_Y, newMomentY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentY() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentY() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMomentYAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentYAsString(String newMomentYAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_YAS_STRING, newMomentYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentYAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentYAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMomentZ() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentZ(double newMomentZ) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_Z, newMomentZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentZ() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentZ() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMomentZAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentZAsString(String newMomentZAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_ZAS_STRING, newMomentZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentZAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentZAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_FORCE__MOMENT_ZAS_STRING);
	}

} //IfcStructuralLoadSingleForceImpl
