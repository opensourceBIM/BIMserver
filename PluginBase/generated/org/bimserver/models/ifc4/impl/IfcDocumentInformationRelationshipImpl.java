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
import org.bimserver.models.ifc4.IfcDocumentInformation;
import org.bimserver.models.ifc4.IfcDocumentInformationRelationship;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Document Information Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationRelationshipImpl#getRelatingDocument <em>Relating Document</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationRelationshipImpl#getRelatedDocuments <em>Related Documents</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDocumentInformationRelationshipImpl#getRelationshipType <em>Relationship Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDocumentInformationRelationshipImpl extends IfcResourceLevelRelationshipImpl implements IfcDocumentInformationRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDocumentInformationRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDocumentInformation getRelatingDocument() {
		return (IfcDocumentInformation) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION_RELATIONSHIP__RELATING_DOCUMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingDocument(IfcDocumentInformation newRelatingDocument) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION_RELATIONSHIP__RELATING_DOCUMENT, newRelatingDocument);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcDocumentInformation> getRelatedDocuments() {
		return (EList<IfcDocumentInformation>) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION_RELATIONSHIP__RELATED_DOCUMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRelationshipType() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION_RELATIONSHIP__RELATIONSHIP_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelationshipType(String newRelationshipType) {
		eSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION_RELATIONSHIP__RELATIONSHIP_TYPE, newRelationshipType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRelationshipType() {
		eUnset(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION_RELATIONSHIP__RELATIONSHIP_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRelationshipType() {
		return eIsSet(Ifc4Package.Literals.IFC_DOCUMENT_INFORMATION_RELATIONSHIP__RELATIONSHIP_TYPE);
	}

} //IfcDocumentInformationRelationshipImpl
