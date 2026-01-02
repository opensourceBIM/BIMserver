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

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcActorSelect;
import org.bimserver.models.ifc4x3.IfcDocumentConfidentialityEnum;
import org.bimserver.models.ifc4x3.IfcDocumentInformation;
import org.bimserver.models.ifc4x3.IfcDocumentInformationRelationship;
import org.bimserver.models.ifc4x3.IfcDocumentReference;
import org.bimserver.models.ifc4x3.IfcDocumentStatusEnum;
import org.bimserver.models.ifc4x3.IfcRelAssociatesDocument;

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
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getIntendedUse <em>Intended Use</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getDocumentOwner <em>Document Owner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getLastRevisionTime <em>Last Revision Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getElectronicFormat <em>Electronic Format</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getValidFrom <em>Valid From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getValidUntil <em>Valid Until</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getDocumentInfoForObjects <em>Document Info For Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getHasDocumentReferences <em>Has Document References</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getIsPointedTo <em>Is Pointed To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDocumentInformationImpl#getIsPointer <em>Is Pointer</em>}</li>
 * </ul>
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
		return Ifc4x3Package.eINSTANCE.getIfcDocumentInformation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIdentification() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Identification(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentification(String newIdentification) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Identification(), newIdentification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLocation() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Location(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocation(String newLocation) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Location(), newLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLocation() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Location());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLocation() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Location());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPurpose() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Purpose(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPurpose(String newPurpose) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Purpose(), newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPurpose() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Purpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPurpose() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Purpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIntendedUse() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_IntendedUse(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIntendedUse(String newIntendedUse) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_IntendedUse(), newIntendedUse);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIntendedUse() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_IntendedUse());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIntendedUse() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_IntendedUse());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScope() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Scope(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScope(String newScope) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Scope(), newScope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScope() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Scope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScope() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Scope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRevision() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Revision(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRevision(String newRevision) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Revision(), newRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRevision() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Revision());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRevision() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Revision());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getDocumentOwner() {
		return (IfcActorSelect) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_DocumentOwner(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDocumentOwner(IfcActorSelect newDocumentOwner) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_DocumentOwner(), newDocumentOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDocumentOwner() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_DocumentOwner());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDocumentOwner() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_DocumentOwner());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcActorSelect> getEditors() {
		return (EList<IfcActorSelect>) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Editors(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEditors() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Editors());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEditors() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Editors());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreationTime() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_CreationTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationTime(String newCreationTime) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_CreationTime(), newCreationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCreationTime() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_CreationTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCreationTime() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_CreationTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLastRevisionTime() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_LastRevisionTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastRevisionTime(String newLastRevisionTime) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_LastRevisionTime(), newLastRevisionTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLastRevisionTime() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_LastRevisionTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLastRevisionTime() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_LastRevisionTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getElectronicFormat() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ElectronicFormat(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElectronicFormat(String newElectronicFormat) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ElectronicFormat(), newElectronicFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetElectronicFormat() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ElectronicFormat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetElectronicFormat() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ElectronicFormat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValidFrom() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ValidFrom(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValidFrom(String newValidFrom) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ValidFrom(), newValidFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetValidFrom() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ValidFrom());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetValidFrom() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ValidFrom());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValidUntil() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ValidUntil(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValidUntil(String newValidUntil) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ValidUntil(), newValidUntil);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetValidUntil() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ValidUntil());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetValidUntil() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_ValidUntil());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDocumentConfidentialityEnum getConfidentiality() {
		return (IfcDocumentConfidentialityEnum) eGet(
				Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Confidentiality(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConfidentiality(IfcDocumentConfidentialityEnum newConfidentiality) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Confidentiality(), newConfidentiality);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConfidentiality() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Confidentiality());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConfidentiality() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Confidentiality());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDocumentStatusEnum getStatus() {
		return (IfcDocumentStatusEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Status(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(IfcDocumentStatusEnum newStatus) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Status(), newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStatus() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Status());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStatus() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_Status());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssociatesDocument> getDocumentInfoForObjects() {
		return (EList<IfcRelAssociatesDocument>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_DocumentInfoForObjects(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDocumentInfoForObjects() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_DocumentInfoForObjects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDocumentInfoForObjects() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_DocumentInfoForObjects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcDocumentReference> getHasDocumentReferences() {
		return (EList<IfcDocumentReference>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_HasDocumentReferences(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasDocumentReferences() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_HasDocumentReferences());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasDocumentReferences() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_HasDocumentReferences());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcDocumentInformationRelationship> getIsPointedTo() {
		return (EList<IfcDocumentInformationRelationship>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_IsPointedTo(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsPointedTo() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_IsPointedTo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsPointedTo() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_IsPointedTo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcDocumentInformationRelationship> getIsPointer() {
		return (EList<IfcDocumentInformationRelationship>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_IsPointer(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsPointer() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_IsPointer());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsPointer() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDocumentInformation_IsPointer());
	}

} //IfcDocumentInformationImpl
