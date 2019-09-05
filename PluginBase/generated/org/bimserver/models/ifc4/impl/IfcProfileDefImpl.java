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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcExternalReferenceRelationship;
import org.bimserver.models.ifc4.IfcProfileDef;
import org.bimserver.models.ifc4.IfcProfileProperties;
import org.bimserver.models.ifc4.IfcProfileTypeEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcProfileDefImpl#getProfileType <em>Profile Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcProfileDefImpl#getProfileName <em>Profile Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcProfileDefImpl#getHasExternalReference <em>Has External Reference</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcProfileDefImpl#getHasProperties <em>Has Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcProfileDefImpl extends IdEObjectImpl implements IfcProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProfileTypeEnum getProfileType() {
		return (IfcProfileTypeEnum) eGet(Ifc4Package.Literals.IFC_PROFILE_DEF__PROFILE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProfileType(IfcProfileTypeEnum newProfileType) {
		eSet(Ifc4Package.Literals.IFC_PROFILE_DEF__PROFILE_TYPE, newProfileType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProfileName() {
		return (String) eGet(Ifc4Package.Literals.IFC_PROFILE_DEF__PROFILE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProfileName(String newProfileName) {
		eSet(Ifc4Package.Literals.IFC_PROFILE_DEF__PROFILE_NAME, newProfileName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetProfileName() {
		eUnset(Ifc4Package.Literals.IFC_PROFILE_DEF__PROFILE_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetProfileName() {
		return eIsSet(Ifc4Package.Literals.IFC_PROFILE_DEF__PROFILE_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcExternalReferenceRelationship> getHasExternalReference() {
		return (EList<IfcExternalReferenceRelationship>) eGet(Ifc4Package.Literals.IFC_PROFILE_DEF__HAS_EXTERNAL_REFERENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasExternalReference() {
		eUnset(Ifc4Package.Literals.IFC_PROFILE_DEF__HAS_EXTERNAL_REFERENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasExternalReference() {
		return eIsSet(Ifc4Package.Literals.IFC_PROFILE_DEF__HAS_EXTERNAL_REFERENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcProfileProperties> getHasProperties() {
		return (EList<IfcProfileProperties>) eGet(Ifc4Package.Literals.IFC_PROFILE_DEF__HAS_PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasProperties() {
		eUnset(Ifc4Package.Literals.IFC_PROFILE_DEF__HAS_PROPERTIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasProperties() {
		return eIsSet(Ifc4Package.Literals.IFC_PROFILE_DEF__HAS_PROPERTIES);
	}

} //IfcProfileDefImpl
