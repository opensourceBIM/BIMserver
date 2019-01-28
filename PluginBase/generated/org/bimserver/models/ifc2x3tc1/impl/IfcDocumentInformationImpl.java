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
import org.bimserver.models.ifc2x3tc1.IfcActorSelect;
import org.bimserver.models.ifc2x3tc1.IfcCalendarDate;
import org.bimserver.models.ifc2x3tc1.IfcDateAndTime;
import org.bimserver.models.ifc2x3tc1.IfcDocumentConfidentialityEnum;
import org.bimserver.models.ifc2x3tc1.IfcDocumentElectronicFormat;
import org.bimserver.models.ifc2x3tc1.IfcDocumentInformation;
import org.bimserver.models.ifc2x3tc1.IfcDocumentInformationRelationship;
import org.bimserver.models.ifc2x3tc1.IfcDocumentReference;
import org.bimserver.models.ifc2x3tc1.IfcDocumentStatusEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Document Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getDocumentId <em>Document Id</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getDocumentReferences <em>Document References</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getIntendedUse <em>Intended Use</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getDocumentOwner <em>Document Owner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getLastRevisionTime <em>Last Revision Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getElectronicFormat <em>Electronic Format</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getValidFrom <em>Valid From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getValidUntil <em>Valid Until</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getIsPointedTo <em>Is Pointed To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDocumentInformationImpl#getIsPointer <em>Is Pointer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDocumentInformationImpl extends IdEObjectImpl implements IfcDocumentInformation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDocumentInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION;
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
	public String getDocumentId() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentId(String newDocumentId) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_ID, newDocumentId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDocumentReference> getDocumentReferences() {
		return (EList<IfcDocumentReference>) eGet(
				Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDocumentReferences() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDocumentReferences() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__PURPOSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__PURPOSE, newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPurpose() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPurpose() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIntendedUse() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__INTENDED_USE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntendedUse(String newIntendedUse) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__INTENDED_USE, newIntendedUse);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIntendedUse() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__INTENDED_USE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIntendedUse() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__INTENDED_USE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScope() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__SCOPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(String newScope) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__SCOPE, newScope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScope() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__SCOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScope() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__SCOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRevision() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(String newRevision) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__REVISION, newRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRevision() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__REVISION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRevision() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__REVISION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getDocumentOwner() {
		return (IfcActorSelect) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_OWNER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentOwner(IfcActorSelect newDocumentOwner) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_OWNER, newDocumentOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDocumentOwner() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_OWNER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDocumentOwner() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_OWNER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcActorSelect> getEditors() {
		return (EList<IfcActorSelect>) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__EDITORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEditors() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__EDITORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEditors() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__EDITORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateAndTime getCreationTime() {
		return (IfcDateAndTime) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__CREATION_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationTime(IfcDateAndTime newCreationTime) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__CREATION_TIME, newCreationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreationTime() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__CREATION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreationTime() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__CREATION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateAndTime getLastRevisionTime() {
		return (IfcDateAndTime) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__LAST_REVISION_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastRevisionTime(IfcDateAndTime newLastRevisionTime) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__LAST_REVISION_TIME, newLastRevisionTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastRevisionTime() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__LAST_REVISION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastRevisionTime() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__LAST_REVISION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentElectronicFormat getElectronicFormat() {
		return (IfcDocumentElectronicFormat) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__ELECTRONIC_FORMAT,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElectronicFormat(IfcDocumentElectronicFormat newElectronicFormat) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__ELECTRONIC_FORMAT, newElectronicFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElectronicFormat() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__ELECTRONIC_FORMAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElectronicFormat() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__ELECTRONIC_FORMAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate getValidFrom() {
		return (IfcCalendarDate) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidFrom(IfcCalendarDate newValidFrom) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_FROM, newValidFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValidFrom() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValidFrom() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate getValidUntil() {
		return (IfcCalendarDate) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_UNTIL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidUntil(IfcCalendarDate newValidUntil) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_UNTIL, newValidUntil);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValidUntil() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_UNTIL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValidUntil() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_UNTIL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentConfidentialityEnum getConfidentiality() {
		return (IfcDocumentConfidentialityEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__CONFIDENTIALITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfidentiality(IfcDocumentConfidentialityEnum newConfidentiality) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__CONFIDENTIALITY, newConfidentiality);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConfidentiality() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__CONFIDENTIALITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConfidentiality() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__CONFIDENTIALITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentStatusEnum getStatus() {
		return (IfcDocumentStatusEnum) eGet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__STATUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(IfcDocumentStatusEnum newStatus) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__STATUS, newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStatus() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStatus() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDocumentInformationRelationship> getIsPointedTo() {
		return (EList<IfcDocumentInformationRelationship>) eGet(
				Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTED_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsPointedTo() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTED_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsPointedTo() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTED_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDocumentInformationRelationship> getIsPointer() {
		return (EList<IfcDocumentInformationRelationship>) eGet(
				Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsPointer() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsPointer() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTER);
	}

} //IfcDocumentInformationImpl
