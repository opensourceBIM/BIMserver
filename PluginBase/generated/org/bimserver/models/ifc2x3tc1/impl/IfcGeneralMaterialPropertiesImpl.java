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
import org.bimserver.models.ifc2x3tc1.IfcGeneralMaterialProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc General Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralMaterialPropertiesImpl#getMolecularWeight <em>Molecular Weight</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralMaterialPropertiesImpl#getMolecularWeightAsString <em>Molecular Weight As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralMaterialPropertiesImpl#getPorosity <em>Porosity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralMaterialPropertiesImpl#getPorosityAsString <em>Porosity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralMaterialPropertiesImpl#getMassDensity <em>Mass Density</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralMaterialPropertiesImpl#getMassDensityAsString <em>Mass Density As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcGeneralMaterialPropertiesImpl extends IfcMaterialPropertiesImpl
		implements IfcGeneralMaterialProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGeneralMaterialPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMolecularWeight() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MOLECULAR_WEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMolecularWeight(double newMolecularWeight) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MOLECULAR_WEIGHT, newMolecularWeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMolecularWeight() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MOLECULAR_WEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMolecularWeight() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MOLECULAR_WEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMolecularWeightAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MOLECULAR_WEIGHT_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMolecularWeightAsString(String newMolecularWeightAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MOLECULAR_WEIGHT_AS_STRING,
				newMolecularWeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMolecularWeightAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MOLECULAR_WEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMolecularWeightAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MOLECULAR_WEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPorosity() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__POROSITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPorosity(double newPorosity) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__POROSITY, newPorosity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPorosity() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__POROSITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPorosity() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__POROSITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPorosityAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__POROSITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPorosityAsString(String newPorosityAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__POROSITY_AS_STRING, newPorosityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPorosityAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__POROSITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPorosityAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__POROSITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMassDensity() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MASS_DENSITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMassDensity(double newMassDensity) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MASS_DENSITY, newMassDensity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMassDensity() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MASS_DENSITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMassDensity() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MASS_DENSITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMassDensityAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MASS_DENSITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMassDensityAsString(String newMassDensityAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MASS_DENSITY_AS_STRING, newMassDensityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMassDensityAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MASS_DENSITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMassDensityAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_MATERIAL_PROPERTIES__MASS_DENSITY_AS_STRING);
	}

} //IfcGeneralMaterialPropertiesImpl
