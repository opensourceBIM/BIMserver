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
import org.bimserver.models.ifc2x3tc1.IfcActorSelect;
import org.bimserver.models.ifc2x3tc1.IfcSubContractResource;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Sub Contract Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSubContractResourceImpl#getSubContractor <em>Sub Contractor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSubContractResourceImpl#getJobDescription <em>Job Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSubContractResourceImpl extends IfcConstructionResourceImpl implements IfcSubContractResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSubContractResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_SUB_CONTRACT_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getSubContractor() {
		return (IfcActorSelect) eGet(Ifc2x3tc1Package.Literals.IFC_SUB_CONTRACT_RESOURCE__SUB_CONTRACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubContractor(IfcActorSelect newSubContractor) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SUB_CONTRACT_RESOURCE__SUB_CONTRACTOR, newSubContractor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSubContractor() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SUB_CONTRACT_RESOURCE__SUB_CONTRACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSubContractor() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SUB_CONTRACT_RESOURCE__SUB_CONTRACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJobDescription() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SUB_CONTRACT_RESOURCE__JOB_DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJobDescription(String newJobDescription) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SUB_CONTRACT_RESOURCE__JOB_DESCRIPTION, newJobDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJobDescription() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SUB_CONTRACT_RESOURCE__JOB_DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJobDescription() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SUB_CONTRACT_RESOURCE__JOB_DESCRIPTION);
	}

} //IfcSubContractResourceImpl
