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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcActorSelect;
import org.bimserver.models.ifc4x3.IfcApproval;
import org.bimserver.models.ifc4x3.IfcApprovalRelationship;
import org.bimserver.models.ifc4x3.IfcExternalReferenceRelationship;
import org.bimserver.models.ifc4x3.IfcRelAssociatesApproval;
import org.bimserver.models.ifc4x3.IfcResourceApprovalRelationship;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Approval</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getTimeOfApproval <em>Time Of Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getRequestingApproval <em>Requesting Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getGivingApproval <em>Giving Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getHasExternalReferences <em>Has External References</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getApprovedObjects <em>Approved Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getApprovedResources <em>Approved Resources</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getIsRelatedWith <em>Is Related With</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcApprovalImpl#getRelates <em>Relates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcApprovalImpl extends IdEObjectImpl implements IfcApproval {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcApprovalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcApproval();
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
	public String getIdentifier() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_Identifier(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentifier(String newIdentifier) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Identifier(), newIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIdentifier() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_Identifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIdentifier() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Identifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTimeOfApproval() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_TimeOfApproval(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeOfApproval(String newTimeOfApproval) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcApproval_TimeOfApproval(), newTimeOfApproval);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTimeOfApproval() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_TimeOfApproval());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTimeOfApproval() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_TimeOfApproval());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStatus() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_Status(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(String newStatus) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Status(), newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStatus() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_Status());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStatus() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Status());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLevel() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_Level(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLevel(String newLevel) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Level(), newLevel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLevel() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_Level());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLevel() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Level());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQualifier() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_Qualifier(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQualifier(String newQualifier) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Qualifier(), newQualifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetQualifier() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_Qualifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetQualifier() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Qualifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getRequestingApproval() {
		return (IfcActorSelect) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_RequestingApproval(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequestingApproval(IfcActorSelect newRequestingApproval) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcApproval_RequestingApproval(), newRequestingApproval);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRequestingApproval() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_RequestingApproval());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRequestingApproval() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_RequestingApproval());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getGivingApproval() {
		return (IfcActorSelect) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_GivingApproval(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGivingApproval(IfcActorSelect newGivingApproval) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcApproval_GivingApproval(), newGivingApproval);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetGivingApproval() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_GivingApproval());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetGivingApproval() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_GivingApproval());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcExternalReferenceRelationship> getHasExternalReferences() {
		return (EList<IfcExternalReferenceRelationship>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcApproval_HasExternalReferences(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasExternalReferences() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_HasExternalReferences());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasExternalReferences() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_HasExternalReferences());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssociatesApproval> getApprovedObjects() {
		return (EList<IfcRelAssociatesApproval>) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_ApprovedObjects(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetApprovedObjects() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_ApprovedObjects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetApprovedObjects() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_ApprovedObjects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcResourceApprovalRelationship> getApprovedResources() {
		return (EList<IfcResourceApprovalRelationship>) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_ApprovedResources(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetApprovedResources() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_ApprovedResources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetApprovedResources() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_ApprovedResources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcApprovalRelationship> getIsRelatedWith() {
		return (EList<IfcApprovalRelationship>) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_IsRelatedWith(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsRelatedWith() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_IsRelatedWith());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsRelatedWith() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_IsRelatedWith());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcApprovalRelationship> getRelates() {
		return (EList<IfcApprovalRelationship>) eGet(Ifc4x3Package.eINSTANCE.getIfcApproval_Relates(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRelates() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcApproval_Relates());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRelates() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcApproval_Relates());
	}

} //IfcApprovalImpl
