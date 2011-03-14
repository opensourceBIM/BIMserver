/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDraughtingCallout;
import org.bimserver.models.ifc2x3.IfcDraughtingCalloutRelationship;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Draughting Callout Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutRelationshipImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutRelationshipImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutRelationshipImpl#getRelatingDraughtingCallout <em>Relating Draughting Callout</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutRelationshipImpl#getRelatedDraughtingCallout <em>Related Draughting Callout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDraughtingCalloutRelationshipImpl extends IdEObjectImpl implements IfcDraughtingCalloutRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDraughtingCalloutRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship();
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
	public String getName() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDraughtingCallout getRelatingDraughtingCallout() {
		return (IfcDraughtingCallout)eGet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_RelatingDraughtingCallout(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingDraughtingCallout(IfcDraughtingCallout newRelatingDraughtingCallout) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_RelatingDraughtingCallout(), newRelatingDraughtingCallout);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDraughtingCallout getRelatedDraughtingCallout() {
		return (IfcDraughtingCallout)eGet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_RelatedDraughtingCallout(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedDraughtingCallout(IfcDraughtingCallout newRelatedDraughtingCallout) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCalloutRelationship_RelatedDraughtingCallout(), newRelatedDraughtingCallout);
	}

} //IfcDraughtingCalloutRelationshipImpl
