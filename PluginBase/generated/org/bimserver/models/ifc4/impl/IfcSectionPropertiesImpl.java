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
import org.bimserver.models.ifc4.IfcProfileDef;
import org.bimserver.models.ifc4.IfcSectionProperties;
import org.bimserver.models.ifc4.IfcSectionTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Section Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSectionPropertiesImpl#getSectionType <em>Section Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSectionPropertiesImpl#getStartProfile <em>Start Profile</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSectionPropertiesImpl#getEndProfile <em>End Profile</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSectionPropertiesImpl extends IfcPreDefinedPropertiesImpl implements IfcSectionProperties {
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
		return Ifc4Package.Literals.IFC_SECTION_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSectionTypeEnum getSectionType() {
		return (IfcSectionTypeEnum) eGet(Ifc4Package.Literals.IFC_SECTION_PROPERTIES__SECTION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSectionType(IfcSectionTypeEnum newSectionType) {
		eSet(Ifc4Package.Literals.IFC_SECTION_PROPERTIES__SECTION_TYPE, newSectionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProfileDef getStartProfile() {
		return (IfcProfileDef) eGet(Ifc4Package.Literals.IFC_SECTION_PROPERTIES__START_PROFILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartProfile(IfcProfileDef newStartProfile) {
		eSet(Ifc4Package.Literals.IFC_SECTION_PROPERTIES__START_PROFILE, newStartProfile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProfileDef getEndProfile() {
		return (IfcProfileDef) eGet(Ifc4Package.Literals.IFC_SECTION_PROPERTIES__END_PROFILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndProfile(IfcProfileDef newEndProfile) {
		eSet(Ifc4Package.Literals.IFC_SECTION_PROPERTIES__END_PROFILE, newEndProfile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEndProfile() {
		eUnset(Ifc4Package.Literals.IFC_SECTION_PROPERTIES__END_PROFILE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEndProfile() {
		return eIsSet(Ifc4Package.Literals.IFC_SECTION_PROPERTIES__END_PROFILE);
	}

} //IfcSectionPropertiesImpl
