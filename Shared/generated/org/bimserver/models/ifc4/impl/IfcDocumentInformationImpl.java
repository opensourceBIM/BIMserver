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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcActorSelect;
import org.bimserver.models.ifc4.IfcDocumentConfidentialityEnum;
import org.bimserver.models.ifc4.IfcDocumentInformation;
import org.bimserver.models.ifc4.IfcDocumentInformationRelationship;
import org.bimserver.models.ifc4.IfcDocumentReference;
import org.bimserver.models.ifc4.IfcDocumentStatusEnum;
import org.bimserver.models.ifc4.IfcRelAssociatesDocument;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Document Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getIntendedUse <em>Intended Use</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getDocumentOwner <em>Document Owner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getLastRevisionTime <em>Last Revision Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getElectronicFormat <em>Electronic Format</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getValidFrom <em>Valid From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getValidUntil <em>Valid Until</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getDocumentInfoForObjects <em>Document Info For Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getHasDocumentReferences <em>Has Document References</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getIsPointedTo <em>Is Pointed To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationImpl#getIsPointer <em>Is Pointer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDocumentInformationImpl extends IfcExternalInformationImpl implements IfcDocumentInformation {
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
		return Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentification() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__IDENTIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentification(String newIdentification) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__IDENTIFICATION, newIdentification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__LOCATION, newLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLocation() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLocation() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__PURPOSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__PURPOSE, newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPurpose() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPurpose() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIntendedUse() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__INTENDED_USE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntendedUse(String newIntendedUse) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__INTENDED_USE, newIntendedUse);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIntendedUse() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__INTENDED_USE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIntendedUse() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__INTENDED_USE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScope() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__SCOPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(String newScope) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__SCOPE, newScope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScope() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__SCOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScope() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__SCOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRevision() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(String newRevision) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__REVISION, newRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRevision() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__REVISION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRevision() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__REVISION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getDocumentOwner() {
		return (IfcActorSelect) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_OWNER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentOwner(IfcActorSelect newDocumentOwner) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_OWNER, newDocumentOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDocumentOwner() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_OWNER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDocumentOwner() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_OWNER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcActorSelect> getEditors() {
		return (EList<IfcActorSelect>) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__EDITORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEditors() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__EDITORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEditors() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__EDITORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreationTime() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__CREATION_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationTime(String newCreationTime) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__CREATION_TIME, newCreationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreationTime() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__CREATION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreationTime() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__CREATION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastRevisionTime() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__LAST_REVISION_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastRevisionTime(String newLastRevisionTime) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__LAST_REVISION_TIME, newLastRevisionTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastRevisionTime() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__LAST_REVISION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastRevisionTime() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__LAST_REVISION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElectronicFormat() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__ELECTRONIC_FORMAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElectronicFormat(String newElectronicFormat) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__ELECTRONIC_FORMAT, newElectronicFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElectronicFormat() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__ELECTRONIC_FORMAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElectronicFormat() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__ELECTRONIC_FORMAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValidFrom() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidFrom(String newValidFrom) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_FROM, newValidFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValidFrom() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValidFrom() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValidUntil() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_UNTIL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidUntil(String newValidUntil) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_UNTIL, newValidUntil);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValidUntil() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_UNTIL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValidUntil() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__VALID_UNTIL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentConfidentialityEnum getConfidentiality() {
		return (IfcDocumentConfidentialityEnum) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__CONFIDENTIALITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfidentiality(IfcDocumentConfidentialityEnum newConfidentiality) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__CONFIDENTIALITY, newConfidentiality);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConfidentiality() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__CONFIDENTIALITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConfidentiality() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__CONFIDENTIALITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentStatusEnum getStatus() {
		return (IfcDocumentStatusEnum) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__STATUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(IfcDocumentStatusEnum newStatus) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__STATUS, newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStatus() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStatus() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelAssociatesDocument> getDocumentInfoForObjects() {
		return (EList<IfcRelAssociatesDocument>) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_INFO_FOR_OBJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDocumentInfoForObjects() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_INFO_FOR_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDocumentInfoForObjects() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__DOCUMENT_INFO_FOR_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDocumentReference> getHasDocumentReferences() {
		return (EList<IfcDocumentReference>) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__HAS_DOCUMENT_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasDocumentReferences() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__HAS_DOCUMENT_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasDocumentReferences() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__HAS_DOCUMENT_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDocumentInformationRelationship> getIsPointedTo() {
		return (EList<IfcDocumentInformationRelationship>) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTED_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsPointedTo() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTED_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsPointedTo() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTED_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDocumentInformationRelationship> getIsPointer() {
		return (EList<IfcDocumentInformationRelationship>) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsPointer() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsPointer() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION__IS_POINTER);
	}

} //IfcDocumentInformationImpl
