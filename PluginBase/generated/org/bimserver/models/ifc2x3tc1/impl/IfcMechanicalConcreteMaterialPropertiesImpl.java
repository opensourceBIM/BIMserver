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
import org.bimserver.models.ifc2x3tc1.IfcMechanicalConcreteMaterialProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mechanical Concrete Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getCompressiveStrength <em>Compressive Strength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getCompressiveStrengthAsString <em>Compressive Strength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getMaxAggregateSize <em>Max Aggregate Size</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getMaxAggregateSizeAsString <em>Max Aggregate Size As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getAdmixturesDescription <em>Admixtures Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getWorkability <em>Workability</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getProtectivePoreRatio <em>Protective Pore Ratio</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getProtectivePoreRatioAsString <em>Protective Pore Ratio As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getWaterImpermeability <em>Water Impermeability</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMechanicalConcreteMaterialPropertiesImpl extends IfcMechanicalMaterialPropertiesImpl
		implements IfcMechanicalConcreteMaterialProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMechanicalConcreteMaterialPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCompressiveStrength() {
		return (Double) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__COMPRESSIVE_STRENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressiveStrength(double newCompressiveStrength) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__COMPRESSIVE_STRENGTH,
				newCompressiveStrength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressiveStrength() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__COMPRESSIVE_STRENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressiveStrength() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__COMPRESSIVE_STRENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompressiveStrengthAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__COMPRESSIVE_STRENGTH_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressiveStrengthAsString(String newCompressiveStrengthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__COMPRESSIVE_STRENGTH_AS_STRING,
				newCompressiveStrengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressiveStrengthAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__COMPRESSIVE_STRENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressiveStrengthAsString() {
		return eIsSet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__COMPRESSIVE_STRENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaxAggregateSize() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__MAX_AGGREGATE_SIZE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxAggregateSize(double newMaxAggregateSize) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__MAX_AGGREGATE_SIZE,
				newMaxAggregateSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxAggregateSize() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__MAX_AGGREGATE_SIZE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxAggregateSize() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__MAX_AGGREGATE_SIZE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxAggregateSizeAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__MAX_AGGREGATE_SIZE_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxAggregateSizeAsString(String newMaxAggregateSizeAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__MAX_AGGREGATE_SIZE_AS_STRING,
				newMaxAggregateSizeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxAggregateSizeAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__MAX_AGGREGATE_SIZE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxAggregateSizeAsString() {
		return eIsSet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__MAX_AGGREGATE_SIZE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdmixturesDescription() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__ADMIXTURES_DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdmixturesDescription(String newAdmixturesDescription) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__ADMIXTURES_DESCRIPTION,
				newAdmixturesDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAdmixturesDescription() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__ADMIXTURES_DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAdmixturesDescription() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__ADMIXTURES_DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWorkability() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__WORKABILITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkability(String newWorkability) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__WORKABILITY, newWorkability);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWorkability() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__WORKABILITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWorkability() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__WORKABILITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProtectivePoreRatio() {
		return (Double) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__PROTECTIVE_PORE_RATIO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtectivePoreRatio(double newProtectivePoreRatio) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__PROTECTIVE_PORE_RATIO,
				newProtectivePoreRatio);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProtectivePoreRatio() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__PROTECTIVE_PORE_RATIO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProtectivePoreRatio() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__PROTECTIVE_PORE_RATIO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProtectivePoreRatioAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__PROTECTIVE_PORE_RATIO_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtectivePoreRatioAsString(String newProtectivePoreRatioAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__PROTECTIVE_PORE_RATIO_AS_STRING,
				newProtectivePoreRatioAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProtectivePoreRatioAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__PROTECTIVE_PORE_RATIO_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProtectivePoreRatioAsString() {
		return eIsSet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__PROTECTIVE_PORE_RATIO_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWaterImpermeability() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__WATER_IMPERMEABILITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWaterImpermeability(String newWaterImpermeability) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__WATER_IMPERMEABILITY,
				newWaterImpermeability);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWaterImpermeability() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__WATER_IMPERMEABILITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWaterImpermeability() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES__WATER_IMPERMEABILITY);
	}

} //IfcMechanicalConcreteMaterialPropertiesImpl
