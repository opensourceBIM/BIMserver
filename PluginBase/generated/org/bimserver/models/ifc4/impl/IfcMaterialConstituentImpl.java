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
import org.bimserver.models.ifc4.IfcMaterial;
import org.bimserver.models.ifc4.IfcMaterialConstituent;
import org.bimserver.models.ifc4.IfcMaterialConstituentSet;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Constituent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialConstituentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialConstituentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialConstituentImpl#getMaterial <em>Material</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialConstituentImpl#getFraction <em>Fraction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialConstituentImpl#getFractionAsString <em>Fraction As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialConstituentImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialConstituentImpl#getToMaterialConstituentSet <em>To Material Constituent Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialConstituentImpl extends IfcMaterialDefinitionImpl implements IfcMaterialConstituent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialConstituentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterial getMaterial() {
		return (IfcMaterial) eGet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__MATERIAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaterial(IfcMaterial newMaterial) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__MATERIAL, newMaterial);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFraction() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__FRACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFraction(double newFraction) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__FRACTION, newFraction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFraction() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__FRACTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFraction() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__FRACTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFractionAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__FRACTION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFractionAsString(String newFractionAsString) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__FRACTION_AS_STRING, newFractionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFractionAsString() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__FRACTION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFractionAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__FRACTION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCategory() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__CATEGORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCategory(String newCategory) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__CATEGORY, newCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCategory() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__CATEGORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCategory() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__CATEGORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialConstituentSet getToMaterialConstituentSet() {
		return (IfcMaterialConstituentSet) eGet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__TO_MATERIAL_CONSTITUENT_SET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setToMaterialConstituentSet(IfcMaterialConstituentSet newToMaterialConstituentSet) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__TO_MATERIAL_CONSTITUENT_SET, newToMaterialConstituentSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetToMaterialConstituentSet() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__TO_MATERIAL_CONSTITUENT_SET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetToMaterialConstituentSet() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_CONSTITUENT__TO_MATERIAL_CONSTITUENT_SET);
	}

} //IfcMaterialConstituentImpl
