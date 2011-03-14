/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcClassificationItem;
import org.bimserver.models.ifc2x3.IfcClassificationItemRelationship;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Classification Item Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcClassificationItemRelationshipImpl#getRelatingItem <em>Relating Item</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcClassificationItemRelationshipImpl#getRelatedItems <em>Related Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcClassificationItemRelationshipImpl extends IdEObjectImpl implements IfcClassificationItemRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcClassificationItemRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcClassificationItemRelationship();
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
	public IfcClassificationItem getRelatingItem() {
		return (IfcClassificationItem)eGet(Ifc2x3Package.eINSTANCE.getIfcClassificationItemRelationship_RelatingItem(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingItem(IfcClassificationItem newRelatingItem) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcClassificationItemRelationship_RelatingItem(), newRelatingItem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcClassificationItem> getRelatedItems() {
		return (EList<IfcClassificationItem>)eGet(Ifc2x3Package.eINSTANCE.getIfcClassificationItemRelationship_RelatedItems(), true);
	}

} //IfcClassificationItemRelationshipImpl
