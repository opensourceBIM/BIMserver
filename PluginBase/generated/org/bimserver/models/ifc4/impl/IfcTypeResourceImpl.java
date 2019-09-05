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
import org.bimserver.models.ifc4.IfcRelAssignsToResource;
import org.bimserver.models.ifc4.IfcTypeResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Type Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTypeResourceImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTypeResourceImpl#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTypeResourceImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTypeResourceImpl#getResourceOf <em>Resource Of</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTypeResourceImpl extends IfcTypeObjectImpl implements IfcTypeResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTypeResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TYPE_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIdentification() {
		return (String) eGet(Ifc4Package.Literals.IFC_TYPE_RESOURCE__IDENTIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentification(String newIdentification) {
		eSet(Ifc4Package.Literals.IFC_TYPE_RESOURCE__IDENTIFICATION, newIdentification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIdentification() {
		eUnset(Ifc4Package.Literals.IFC_TYPE_RESOURCE__IDENTIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIdentification() {
		return eIsSet(Ifc4Package.Literals.IFC_TYPE_RESOURCE__IDENTIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_TYPE_RESOURCE__LONG_DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongDescription(String newLongDescription) {
		eSet(Ifc4Package.Literals.IFC_TYPE_RESOURCE__LONG_DESCRIPTION, newLongDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongDescription() {
		eUnset(Ifc4Package.Literals.IFC_TYPE_RESOURCE__LONG_DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_TYPE_RESOURCE__LONG_DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceType() {
		return (String) eGet(Ifc4Package.Literals.IFC_TYPE_RESOURCE__RESOURCE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceType(String newResourceType) {
		eSet(Ifc4Package.Literals.IFC_TYPE_RESOURCE__RESOURCE_TYPE, newResourceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetResourceType() {
		eUnset(Ifc4Package.Literals.IFC_TYPE_RESOURCE__RESOURCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetResourceType() {
		return eIsSet(Ifc4Package.Literals.IFC_TYPE_RESOURCE__RESOURCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssignsToResource> getResourceOf() {
		return (EList<IfcRelAssignsToResource>) eGet(Ifc4Package.Literals.IFC_TYPE_RESOURCE__RESOURCE_OF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetResourceOf() {
		eUnset(Ifc4Package.Literals.IFC_TYPE_RESOURCE__RESOURCE_OF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetResourceOf() {
		return eIsSet(Ifc4Package.Literals.IFC_TYPE_RESOURCE__RESOURCE_OF);
	}

} //IfcTypeResourceImpl
