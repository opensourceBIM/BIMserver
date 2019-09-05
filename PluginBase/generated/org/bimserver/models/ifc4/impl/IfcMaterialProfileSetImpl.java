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
import org.bimserver.models.ifc4.IfcCompositeProfileDef;
import org.bimserver.models.ifc4.IfcMaterialProfile;
import org.bimserver.models.ifc4.IfcMaterialProfileSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Profile Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileSetImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileSetImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileSetImpl#getMaterialProfiles <em>Material Profiles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileSetImpl#getCompositeProfile <em>Composite Profile</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialProfileSetImpl extends IfcMaterialDefinitionImpl implements IfcMaterialProfileSet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialProfileSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcMaterialProfile> getMaterialProfiles() {
		return (EList<IfcMaterialProfile>) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__MATERIAL_PROFILES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCompositeProfileDef getCompositeProfile() {
		return (IfcCompositeProfileDef) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__COMPOSITE_PROFILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompositeProfile(IfcCompositeProfileDef newCompositeProfile) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__COMPOSITE_PROFILE, newCompositeProfile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCompositeProfile() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__COMPOSITE_PROFILE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCompositeProfile() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET__COMPOSITE_PROFILE);
	}

} //IfcMaterialProfileSetImpl
