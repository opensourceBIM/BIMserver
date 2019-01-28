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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcStructuralLoadSingleDisplacement;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Displacement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
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
 *
 * @generated
 */
public class IfcStructuralLoadSingleDisplacementImpl extends IfcStructuralLoadStaticImpl
		implements IfcStructuralLoadSingleDisplacement {
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
		return Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDisplacementX() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementX(double newDisplacementX) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_X, newDisplacementX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementX() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementX() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplacementXAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_XAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementXAsString(String newDisplacementXAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_XAS_STRING,
				newDisplacementXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementXAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementXAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDisplacementY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementY(double newDisplacementY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Y, newDisplacementY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplacementYAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_YAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementYAsString(String newDisplacementYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_YAS_STRING,
				newDisplacementYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDisplacementZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementZ(double newDisplacementZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Z, newDisplacementZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplacementZAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_ZAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementZAsString(String newDisplacementZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_ZAS_STRING,
				newDisplacementZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__DISPLACEMENT_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalDisplacementRX() {
		return (Double) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRX(double newRotationalDisplacementRX) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX,
				newRotationalDisplacementRX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRX() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRX() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalDisplacementRXAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRXAsString(String newRotationalDisplacementRXAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX_AS_STRING,
				newRotationalDisplacementRXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRXAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRXAsString() {
		return eIsSet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RX_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalDisplacementRY() {
		return (Double) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRY(double newRotationalDisplacementRY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY,
				newRotationalDisplacementRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalDisplacementRYAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRYAsString(String newRotationalDisplacementRYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY_AS_STRING,
				newRotationalDisplacementRYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRYAsString() {
		return eIsSet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalDisplacementRZ() {
		return (Double) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRZ(double newRotationalDisplacementRZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ,
				newRotationalDisplacementRZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalDisplacementRZAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRZAsString(String newRotationalDisplacementRZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ_AS_STRING,
				newRotationalDisplacementRZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRZAsString() {
		return eIsSet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT__ROTATIONAL_DISPLACEMENT_RZ_AS_STRING);
	}

} //IfcStructuralLoadSingleDisplacementImpl
