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
import org.bimserver.models.ifc2x3tc1.IfcOrientationSelect;
import org.bimserver.models.ifc2x3tc1.IfcProfileProperties;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesProfileProperties;
import org.bimserver.models.ifc2x3tc1.IfcShapeAspect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Associates Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelAssociatesProfilePropertiesImpl#getRelatingProfileProperties <em>Relating Profile Properties</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelAssociatesProfilePropertiesImpl#getProfileSectionLocation <em>Profile Section Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelAssociatesProfilePropertiesImpl#getProfileOrientation <em>Profile Orientation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelAssociatesProfilePropertiesImpl extends IfcRelAssociatesImpl
		implements IfcRelAssociatesProfileProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssociatesProfilePropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileProperties getRelatingProfileProperties() {
		return (IfcProfileProperties) eGet(
				Ifc2x3tc1Package.Literals.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES__RELATING_PROFILE_PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingProfileProperties(IfcProfileProperties newRelatingProfileProperties) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES__RELATING_PROFILE_PROPERTIES,
				newRelatingProfileProperties);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect getProfileSectionLocation() {
		return (IfcShapeAspect) eGet(
				Ifc2x3tc1Package.Literals.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES__PROFILE_SECTION_LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileSectionLocation(IfcShapeAspect newProfileSectionLocation) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES__PROFILE_SECTION_LOCATION,
				newProfileSectionLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProfileSectionLocation() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES__PROFILE_SECTION_LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProfileSectionLocation() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES__PROFILE_SECTION_LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOrientationSelect getProfileOrientation() {
		return (IfcOrientationSelect) eGet(
				Ifc2x3tc1Package.Literals.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES__PROFILE_ORIENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileOrientation(IfcOrientationSelect newProfileOrientation) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES__PROFILE_ORIENTATION,
				newProfileOrientation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProfileOrientation() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES__PROFILE_ORIENTATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProfileOrientation() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES__PROFILE_ORIENTATION);
	}

} //IfcRelAssociatesProfilePropertiesImpl
