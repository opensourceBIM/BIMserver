/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDocumentInformation;
import org.bimserver.models.ifc2x3.IfcDocumentInformationRelationship;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Document Information Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationRelationshipImpl#getRelatingDocument <em>Relating Document</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationRelationshipImpl#getRelatedDocuments <em>Related Documents</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationRelationshipImpl#getRelationshipType <em>Relationship Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDocumentInformationRelationshipImpl extends IdEObjectImpl implements IfcDocumentInformationRelationship {
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
		return Ifc2x3Package.eINSTANCE.getIfcDocumentInformationRelationship();
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
	public IfcDocumentInformation getRelatingDocument() {
		return (IfcDocumentInformation)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformationRelationship_RelatingDocument(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingDocument(IfcDocumentInformation newRelatingDocument) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformationRelationship_RelatingDocument(), newRelatingDocument);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDocumentInformation> getRelatedDocuments() {
		return (EList<IfcDocumentInformation>)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformationRelationship_RelatedDocuments(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelationshipType() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformationRelationship_RelationshipType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelationshipType(String newRelationshipType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformationRelationship_RelationshipType(), newRelationshipType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRelationshipType() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformationRelationship_RelationshipType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelationshipType() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformationRelationship_RelationshipType());
	}

} //IfcDocumentInformationRelationshipImpl
