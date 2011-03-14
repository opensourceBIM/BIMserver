/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDraughtingCallout;
import org.bimserver.models.ifc2x3.IfcDraughtingCalloutElement;
import org.bimserver.models.ifc2x3.IfcDraughtingCalloutRelationship;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Draughting Callout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutImpl#getIsRelatedFromCallout <em>Is Related From Callout</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutImpl#getIsRelatedToCallout <em>Is Related To Callout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDraughtingCalloutImpl extends IfcGeometricRepresentationItemImpl implements IfcDraughtingCallout {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDraughtingCalloutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcDraughtingCallout();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDraughtingCalloutElement> getContents() {
		return (EList<IfcDraughtingCalloutElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCallout_Contents(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDraughtingCalloutRelationship> getIsRelatedFromCallout() {
		return (EList<IfcDraughtingCalloutRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCallout_IsRelatedFromCallout(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDraughtingCalloutRelationship> getIsRelatedToCallout() {
		return (EList<IfcDraughtingCalloutRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCallout_IsRelatedToCallout(), true);
	}

} //IfcDraughtingCalloutImpl
