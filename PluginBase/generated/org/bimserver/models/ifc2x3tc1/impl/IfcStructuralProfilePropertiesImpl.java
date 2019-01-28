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
import org.bimserver.models.ifc2x3tc1.IfcStructuralProfileProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getTorsionalConstantX <em>Torsional Constant X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getTorsionalConstantXAsString <em>Torsional Constant XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaYZ <em>Moment Of Inertia YZ</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaYZAsString <em>Moment Of Inertia YZ As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaY <em>Moment Of Inertia Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaYAsString <em>Moment Of Inertia YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaZ <em>Moment Of Inertia Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaZAsString <em>Moment Of Inertia ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getWarpingConstant <em>Warping Constant</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getWarpingConstantAsString <em>Warping Constant As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getShearCentreZ <em>Shear Centre Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getShearCentreZAsString <em>Shear Centre ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getShearCentreY <em>Shear Centre Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getShearCentreYAsString <em>Shear Centre YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getShearDeformationAreaZ <em>Shear Deformation Area Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getShearDeformationAreaZAsString <em>Shear Deformation Area ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getShearDeformationAreaY <em>Shear Deformation Area Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getShearDeformationAreaYAsString <em>Shear Deformation Area YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMaximumSectionModulusY <em>Maximum Section Modulus Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMaximumSectionModulusYAsString <em>Maximum Section Modulus YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMinimumSectionModulusY <em>Minimum Section Modulus Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMinimumSectionModulusYAsString <em>Minimum Section Modulus YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMaximumSectionModulusZ <em>Maximum Section Modulus Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMaximumSectionModulusZAsString <em>Maximum Section Modulus ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMinimumSectionModulusZ <em>Minimum Section Modulus Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getMinimumSectionModulusZAsString <em>Minimum Section Modulus ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getTorsionalSectionModulus <em>Torsional Section Modulus</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getTorsionalSectionModulusAsString <em>Torsional Section Modulus As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralProfilePropertiesImpl#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralProfilePropertiesImpl extends IfcGeneralProfilePropertiesImpl
		implements IfcStructuralProfileProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralProfilePropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTorsionalConstantX() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_CONSTANT_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTorsionalConstantX(double newTorsionalConstantX) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_CONSTANT_X, newTorsionalConstantX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTorsionalConstantX() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_CONSTANT_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTorsionalConstantX() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_CONSTANT_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTorsionalConstantXAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_CONSTANT_XAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTorsionalConstantXAsString(String newTorsionalConstantXAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_CONSTANT_XAS_STRING,
				newTorsionalConstantXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTorsionalConstantXAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_CONSTANT_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTorsionalConstantXAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_CONSTANT_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMomentOfInertiaYZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YZ, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaYZ(double newMomentOfInertiaYZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YZ, newMomentOfInertiaYZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaYZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaYZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMomentOfInertiaYZAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YZ_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaYZAsString(String newMomentOfInertiaYZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YZ_AS_STRING,
				newMomentOfInertiaYZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaYZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YZ_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaYZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YZ_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMomentOfInertiaY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaY(double newMomentOfInertiaY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_Y, newMomentOfInertiaY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMomentOfInertiaYAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaYAsString(String newMomentOfInertiaYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YAS_STRING,
				newMomentOfInertiaYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMomentOfInertiaZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaZ(double newMomentOfInertiaZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_Z, newMomentOfInertiaZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMomentOfInertiaZAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_ZAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaZAsString(String newMomentOfInertiaZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_ZAS_STRING,
				newMomentOfInertiaZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MOMENT_OF_INERTIA_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWarpingConstant() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__WARPING_CONSTANT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarpingConstant(double newWarpingConstant) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__WARPING_CONSTANT, newWarpingConstant);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWarpingConstant() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__WARPING_CONSTANT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWarpingConstant() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__WARPING_CONSTANT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWarpingConstantAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__WARPING_CONSTANT_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarpingConstantAsString(String newWarpingConstantAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__WARPING_CONSTANT_AS_STRING,
				newWarpingConstantAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWarpingConstantAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__WARPING_CONSTANT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWarpingConstantAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__WARPING_CONSTANT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getShearCentreZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearCentreZ(double newShearCentreZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_Z, newShearCentreZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearCentreZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearCentreZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearCentreZAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_ZAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearCentreZAsString(String newShearCentreZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_ZAS_STRING,
				newShearCentreZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearCentreZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearCentreZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getShearCentreY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearCentreY(double newShearCentreY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_Y, newShearCentreY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearCentreY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearCentreY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearCentreYAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_YAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearCentreYAsString(String newShearCentreYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_YAS_STRING,
				newShearCentreYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearCentreYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearCentreYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_CENTRE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getShearDeformationAreaZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_Z,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearDeformationAreaZ(double newShearDeformationAreaZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_Z,
				newShearDeformationAreaZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearDeformationAreaZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearDeformationAreaZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearDeformationAreaZAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearDeformationAreaZAsString(String newShearDeformationAreaZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_ZAS_STRING,
				newShearDeformationAreaZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearDeformationAreaZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearDeformationAreaZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getShearDeformationAreaY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_Y,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearDeformationAreaY(double newShearDeformationAreaY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_Y,
				newShearDeformationAreaY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearDeformationAreaY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearDeformationAreaY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearDeformationAreaYAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearDeformationAreaYAsString(String newShearDeformationAreaYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_YAS_STRING,
				newShearDeformationAreaYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearDeformationAreaYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearDeformationAreaYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__SHEAR_DEFORMATION_AREA_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaximumSectionModulusY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_Y,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumSectionModulusY(double newMaximumSectionModulusY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_Y,
				newMaximumSectionModulusY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumSectionModulusY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumSectionModulusY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumSectionModulusYAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumSectionModulusYAsString(String newMaximumSectionModulusYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_YAS_STRING,
				newMaximumSectionModulusYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumSectionModulusYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumSectionModulusYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinimumSectionModulusY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_Y,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumSectionModulusY(double newMinimumSectionModulusY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_Y,
				newMinimumSectionModulusY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumSectionModulusY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumSectionModulusY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinimumSectionModulusYAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumSectionModulusYAsString(String newMinimumSectionModulusYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_YAS_STRING,
				newMinimumSectionModulusYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumSectionModulusYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumSectionModulusYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaximumSectionModulusZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_Z,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumSectionModulusZ(double newMaximumSectionModulusZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_Z,
				newMaximumSectionModulusZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumSectionModulusZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumSectionModulusZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumSectionModulusZAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumSectionModulusZAsString(String newMaximumSectionModulusZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_ZAS_STRING,
				newMaximumSectionModulusZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumSectionModulusZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumSectionModulusZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MAXIMUM_SECTION_MODULUS_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinimumSectionModulusZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_Z,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumSectionModulusZ(double newMinimumSectionModulusZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_Z,
				newMinimumSectionModulusZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumSectionModulusZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumSectionModulusZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinimumSectionModulusZAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumSectionModulusZAsString(String newMinimumSectionModulusZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_ZAS_STRING,
				newMinimumSectionModulusZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumSectionModulusZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumSectionModulusZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__MINIMUM_SECTION_MODULUS_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTorsionalSectionModulus() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_SECTION_MODULUS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTorsionalSectionModulus(double newTorsionalSectionModulus) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_SECTION_MODULUS,
				newTorsionalSectionModulus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTorsionalSectionModulus() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_SECTION_MODULUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTorsionalSectionModulus() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_SECTION_MODULUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTorsionalSectionModulusAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_SECTION_MODULUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTorsionalSectionModulusAsString(String newTorsionalSectionModulusAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_SECTION_MODULUS_AS_STRING,
				newTorsionalSectionModulusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTorsionalSectionModulusAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_SECTION_MODULUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTorsionalSectionModulusAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__TORSIONAL_SECTION_MODULUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCentreOfGravityInX() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInX(double newCentreOfGravityInX) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_X,
				newCentreOfGravityInX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInX() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInX() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInXAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInXAsString(String newCentreOfGravityInXAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_XAS_STRING,
				newCentreOfGravityInXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInXAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInXAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCentreOfGravityInY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInY(double newCentreOfGravityInY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_Y,
				newCentreOfGravityInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInYAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInYAsString(String newCentreOfGravityInYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_YAS_STRING,
				newCentreOfGravityInYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_PROFILE_PROPERTIES__CENTRE_OF_GRAVITY_IN_YAS_STRING);
	}

} //IfcStructuralProfilePropertiesImpl
