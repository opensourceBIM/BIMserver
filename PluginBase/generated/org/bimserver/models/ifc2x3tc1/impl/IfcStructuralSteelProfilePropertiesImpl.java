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
import org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Steel Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralSteelProfilePropertiesImpl#getShearAreaZ <em>Shear Area Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralSteelProfilePropertiesImpl#getShearAreaZAsString <em>Shear Area ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralSteelProfilePropertiesImpl#getShearAreaY <em>Shear Area Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralSteelProfilePropertiesImpl#getShearAreaYAsString <em>Shear Area YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralSteelProfilePropertiesImpl#getPlasticShapeFactorY <em>Plastic Shape Factor Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralSteelProfilePropertiesImpl#getPlasticShapeFactorYAsString <em>Plastic Shape Factor YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralSteelProfilePropertiesImpl#getPlasticShapeFactorZ <em>Plastic Shape Factor Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralSteelProfilePropertiesImpl#getPlasticShapeFactorZAsString <em>Plastic Shape Factor ZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralSteelProfilePropertiesImpl extends IfcStructuralProfilePropertiesImpl
		implements IfcStructuralSteelProfileProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralSteelProfilePropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getShearAreaZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearAreaZ(double newShearAreaZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_Z, newShearAreaZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearAreaZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearAreaZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearAreaZAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_ZAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearAreaZAsString(String newShearAreaZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_ZAS_STRING,
				newShearAreaZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearAreaZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearAreaZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getShearAreaY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearAreaY(double newShearAreaY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_Y, newShearAreaY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearAreaY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearAreaY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearAreaYAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_YAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearAreaYAsString(String newShearAreaYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_YAS_STRING,
				newShearAreaYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearAreaYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearAreaYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__SHEAR_AREA_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPlasticShapeFactorY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_Y,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticShapeFactorY(double newPlasticShapeFactorY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_Y,
				newPlasticShapeFactorY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticShapeFactorY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticShapeFactorY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlasticShapeFactorYAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_YAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticShapeFactorYAsString(String newPlasticShapeFactorYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_YAS_STRING,
				newPlasticShapeFactorYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticShapeFactorYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticShapeFactorYAsString() {
		return eIsSet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPlasticShapeFactorZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_Z,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticShapeFactorZ(double newPlasticShapeFactorZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_Z,
				newPlasticShapeFactorZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticShapeFactorZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticShapeFactorZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlasticShapeFactorZAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_ZAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticShapeFactorZAsString(String newPlasticShapeFactorZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_ZAS_STRING,
				newPlasticShapeFactorZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticShapeFactorZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticShapeFactorZAsString() {
		return eIsSet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES__PLASTIC_SHAPE_FACTOR_ZAS_STRING);
	}

} //IfcStructuralSteelProfilePropertiesImpl
