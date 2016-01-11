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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcMaterial;
import org.bimserver.models.ifc4.IfcMaterialProfile;
import org.bimserver.models.ifc4.IfcMaterialProfileSet;
import org.bimserver.models.ifc4.IfcProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileImpl#getMaterial <em>Material</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileImpl#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileImpl#getPriorityAsString <em>Priority As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileImpl#getToMaterialProfileSet <em>To Material Profile Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialProfileImpl extends IfcMaterialDefinitionImpl implements IfcMaterialProfile {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialProfileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_MATERIAL_PROFILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterial getMaterial() {
		return (IfcMaterial) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__MATERIAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaterial(IfcMaterial newMaterial) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__MATERIAL, newMaterial);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaterial() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__MATERIAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaterial() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__MATERIAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileDef getProfile() {
		return (IfcProfileDef) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__PROFILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfile(IfcProfileDef newProfile) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__PROFILE, newProfile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPriority() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__PRIORITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(double newPriority) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__PRIORITY, newPriority);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPriority() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__PRIORITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPriority() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__PRIORITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPriorityAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__PRIORITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriorityAsString(String newPriorityAsString) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__PRIORITY_AS_STRING, newPriorityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPriorityAsString() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__PRIORITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPriorityAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__PRIORITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCategory() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__CATEGORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(String newCategory) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__CATEGORY, newCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCategory() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__CATEGORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCategory() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__CATEGORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialProfileSet getToMaterialProfileSet() {
		return (IfcMaterialProfileSet) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__TO_MATERIAL_PROFILE_SET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToMaterialProfileSet(IfcMaterialProfileSet newToMaterialProfileSet) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__TO_MATERIAL_PROFILE_SET, newToMaterialProfileSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetToMaterialProfileSet() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__TO_MATERIAL_PROFILE_SET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetToMaterialProfileSet() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE__TO_MATERIAL_PROFILE_SET);
	}

} //IfcMaterialProfileImpl
