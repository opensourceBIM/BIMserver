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
import org.bimserver.models.ifc4.IfcActorSelect;
import org.bimserver.models.ifc4.IfcApproval;
import org.bimserver.models.ifc4.IfcApprovalRelationship;
import org.bimserver.models.ifc4.IfcExternalReferenceRelationship;
import org.bimserver.models.ifc4.IfcRelAssociatesApproval;
import org.bimserver.models.ifc4.IfcResourceApprovalRelationship;
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
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getTimeOfApproval <em>Time Of Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getRequestingApproval <em>Requesting Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getGivingApproval <em>Giving Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getHasExternalReferences <em>Has External References</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getApprovedObjects <em>Approved Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getApprovedResources <em>Approved Resources</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getIsRelatedWith <em>Is Related With</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApprovalImpl#getRelates <em>Relates</em>}</li>
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
		return Ifc4Package.Literals.IFC_APPROVAL;
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
		return (String) eGet(Ifc4Package.Literals.IFC_APPROVAL__IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentifier(String newIdentifier) {
		eSet(Ifc4Package.Literals.IFC_APPROVAL__IDENTIFIER, newIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIdentifier() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIdentifier() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPROVAL__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_APPROVAL__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPROVAL__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_APPROVAL__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTimeOfApproval() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPROVAL__TIME_OF_APPROVAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeOfApproval(String newTimeOfApproval) {
		eSet(Ifc4Package.Literals.IFC_APPROVAL__TIME_OF_APPROVAL, newTimeOfApproval);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTimeOfApproval() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__TIME_OF_APPROVAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTimeOfApproval() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__TIME_OF_APPROVAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStatus() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPROVAL__STATUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(String newStatus) {
		eSet(Ifc4Package.Literals.IFC_APPROVAL__STATUS, newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStatus() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStatus() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLevel() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPROVAL__LEVEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLevel(String newLevel) {
		eSet(Ifc4Package.Literals.IFC_APPROVAL__LEVEL, newLevel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLevel() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__LEVEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLevel() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__LEVEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQualifier() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPROVAL__QUALIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQualifier(String newQualifier) {
		eSet(Ifc4Package.Literals.IFC_APPROVAL__QUALIFIER, newQualifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetQualifier() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__QUALIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetQualifier() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__QUALIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getRequestingApproval() {
		return (IfcActorSelect) eGet(Ifc4Package.Literals.IFC_APPROVAL__REQUESTING_APPROVAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequestingApproval(IfcActorSelect newRequestingApproval) {
		eSet(Ifc4Package.Literals.IFC_APPROVAL__REQUESTING_APPROVAL, newRequestingApproval);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRequestingApproval() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__REQUESTING_APPROVAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRequestingApproval() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__REQUESTING_APPROVAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getGivingApproval() {
		return (IfcActorSelect) eGet(Ifc4Package.Literals.IFC_APPROVAL__GIVING_APPROVAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGivingApproval(IfcActorSelect newGivingApproval) {
		eSet(Ifc4Package.Literals.IFC_APPROVAL__GIVING_APPROVAL, newGivingApproval);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetGivingApproval() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__GIVING_APPROVAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetGivingApproval() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__GIVING_APPROVAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcExternalReferenceRelationship> getHasExternalReferences() {
		return (EList<IfcExternalReferenceRelationship>) eGet(Ifc4Package.Literals.IFC_APPROVAL__HAS_EXTERNAL_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasExternalReferences() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__HAS_EXTERNAL_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasExternalReferences() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__HAS_EXTERNAL_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssociatesApproval> getApprovedObjects() {
		return (EList<IfcRelAssociatesApproval>) eGet(Ifc4Package.Literals.IFC_APPROVAL__APPROVED_OBJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetApprovedObjects() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__APPROVED_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetApprovedObjects() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__APPROVED_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcResourceApprovalRelationship> getApprovedResources() {
		return (EList<IfcResourceApprovalRelationship>) eGet(Ifc4Package.Literals.IFC_APPROVAL__APPROVED_RESOURCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetApprovedResources() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__APPROVED_RESOURCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetApprovedResources() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__APPROVED_RESOURCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcApprovalRelationship> getIsRelatedWith() {
		return (EList<IfcApprovalRelationship>) eGet(Ifc4Package.Literals.IFC_APPROVAL__IS_RELATED_WITH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsRelatedWith() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__IS_RELATED_WITH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsRelatedWith() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__IS_RELATED_WITH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcApprovalRelationship> getRelates() {
		return (EList<IfcApprovalRelationship>) eGet(Ifc4Package.Literals.IFC_APPROVAL__RELATES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRelates() {
		eUnset(Ifc4Package.Literals.IFC_APPROVAL__RELATES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRelates() {
		return eIsSet(Ifc4Package.Literals.IFC_APPROVAL__RELATES);
	}

} //IfcApprovalImpl
