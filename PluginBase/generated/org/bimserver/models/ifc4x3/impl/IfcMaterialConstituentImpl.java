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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcMaterial;
import org.bimserver.models.ifc4x3.IfcMaterialConstituent;
import org.bimserver.models.ifc4x3.IfcMaterialConstituentSet;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Constituent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialConstituentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialConstituentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialConstituentImpl#getMaterial <em>Material</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialConstituentImpl#getFraction <em>Fraction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialConstituentImpl#getFractionAsString <em>Fraction As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialConstituentImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialConstituentImpl#getToMaterialConstituentSet <em>To Material Constituent Set</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterial getMaterial() {
		return (IfcMaterial) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Material(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaterial(IfcMaterial newMaterial) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Material(), newMaterial);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFraction() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Fraction(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFraction(double newFraction) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Fraction(), newFraction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFraction() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Fraction());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFraction() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Fraction());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFractionAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_FractionAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFractionAsString(String newFractionAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_FractionAsString(), newFractionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFractionAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_FractionAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFractionAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_FractionAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCategory() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Category(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCategory(String newCategory) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Category(), newCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCategory() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Category());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCategory() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_Category());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialConstituentSet getToMaterialConstituentSet() {
		return (IfcMaterialConstituentSet) eGet(
				Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_ToMaterialConstituentSet(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setToMaterialConstituentSet(IfcMaterialConstituentSet newToMaterialConstituentSet) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_ToMaterialConstituentSet(), newToMaterialConstituentSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetToMaterialConstituentSet() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_ToMaterialConstituentSet());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetToMaterialConstituentSet() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialConstituent_ToMaterialConstituentSet());
	}

} //IfcMaterialConstituentImpl
