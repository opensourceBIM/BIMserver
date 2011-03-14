/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcApproval;
import org.bimserver.models.ifc2x3.IfcApprovalPropertyRelationship;
import org.bimserver.models.ifc2x3.IfcProperty;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Approval Property Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalPropertyRelationshipImpl#getApprovedProperties <em>Approved Properties</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalPropertyRelationshipImpl#getApproval <em>Approval</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcApprovalPropertyRelationshipImpl extends IdEObjectImpl implements IfcApprovalPropertyRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcApprovalPropertyRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcApprovalPropertyRelationship();
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
	@SuppressWarnings("unchecked")
	public EList<IfcProperty> getApprovedProperties() {
		return (EList<IfcProperty>)eGet(Ifc2x3Package.eINSTANCE.getIfcApprovalPropertyRelationship_ApprovedProperties(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcApproval getApproval() {
		return (IfcApproval)eGet(Ifc2x3Package.eINSTANCE.getIfcApprovalPropertyRelationship_Approval(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApproval(IfcApproval newApproval) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcApprovalPropertyRelationship_Approval(), newApproval);
	}

} //IfcApprovalPropertyRelationshipImpl
