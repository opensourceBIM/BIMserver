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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcProfileDef;
import org.bimserver.models.ifc2x3tc1.IfcSectionProperties;
import org.bimserver.models.ifc2x3tc1.IfcSectionTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Section Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionPropertiesImpl#getSectionType <em>Section Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionPropertiesImpl#getStartProfile <em>Start Profile</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionPropertiesImpl#getEndProfile <em>End Profile</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSectionPropertiesImpl extends IdEObjectImpl implements IfcSectionProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSectionPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_SECTION_PROPERTIES;
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
	public IfcSectionTypeEnum getSectionType() {
		return (IfcSectionTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_SECTION_PROPERTIES__SECTION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSectionType(IfcSectionTypeEnum newSectionType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SECTION_PROPERTIES__SECTION_TYPE, newSectionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileDef getStartProfile() {
		return (IfcProfileDef) eGet(Ifc2x3tc1Package.Literals.IFC_SECTION_PROPERTIES__START_PROFILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartProfile(IfcProfileDef newStartProfile) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SECTION_PROPERTIES__START_PROFILE, newStartProfile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileDef getEndProfile() {
		return (IfcProfileDef) eGet(Ifc2x3tc1Package.Literals.IFC_SECTION_PROPERTIES__END_PROFILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndProfile(IfcProfileDef newEndProfile) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SECTION_PROPERTIES__END_PROFILE, newEndProfile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEndProfile() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SECTION_PROPERTIES__END_PROFILE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEndProfile() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SECTION_PROPERTIES__END_PROFILE);
	}

} //IfcSectionPropertiesImpl
