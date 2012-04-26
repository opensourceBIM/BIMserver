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

import org.bimserver.models.ifc2x3tc1.IfcStructuralLoadSingleDisplacement;
import org.bimserver.models.ifc2x3tc1.LogPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Displacement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementX <em>Displacement X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementXAsString <em>Displacement XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementY <em>Displacement Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementYAsString <em>Displacement YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementZ <em>Displacement Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementZAsString <em>Displacement ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRX <em>Rotational Displacement RX</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRXAsString <em>Rotational Displacement RX As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRY <em>Rotational Displacement RY</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRYAsString <em>Rotational Displacement RY As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRZ <em>Rotational Displacement RZ</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRZAsString <em>Rotational Displacement RZ As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralLoadSingleDisplacementImpl extends IfcStructuralLoadStaticImpl implements IfcStructuralLoadSingleDisplacement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadSingleDisplacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDisplacementX() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementX(double newDisplacementX) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_X, newDisplacementX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementX() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementX() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplacementXAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementXAsString(String newDisplacementXAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_XAS_STRING, newDisplacementXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementXAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementXAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDisplacementY() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementY(double newDisplacementY) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Y, newDisplacementY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementY() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementY() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplacementYAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementYAsString(String newDisplacementYAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_YAS_STRING, newDisplacementYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementYAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementYAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDisplacementZ() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementZ(double newDisplacementZ) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Z, newDisplacementZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementZ() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementZ() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplacementZAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementZAsString(String newDisplacementZAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_ZAS_STRING, newDisplacementZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementZAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementZAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalDisplacementRX() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRX(double newRotationalDisplacementRX) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX, newRotationalDisplacementRX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRX() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRX() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalDisplacementRXAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRXAsString(String newRotationalDisplacementRXAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX_AS_STRING, newRotationalDisplacementRXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRXAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRXAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalDisplacementRY() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRY(double newRotationalDisplacementRY) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY, newRotationalDisplacementRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRY() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRY() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalDisplacementRYAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRYAsString(String newRotationalDisplacementRYAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY_AS_STRING, newRotationalDisplacementRYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRYAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRYAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalDisplacementRZ() {
		return (Double) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRZ(double newRotationalDisplacementRZ) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ, newRotationalDisplacementRZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRZ() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRZ() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalDisplacementRZAsString() {
		return (String) eGet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRZAsString(String newRotationalDisplacementRZAsString) {
		eSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ_AS_STRING, newRotationalDisplacementRZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRZAsString() {
		eUnset(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRZAsString() {
		return eIsSet(LogPackage.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ_AS_STRING);
	}

} //IfcStructuralLoadSingleDisplacementImpl
