/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcActor;
import org.bimserver.models.ifc2x3.IfcActorRole;
import org.bimserver.models.ifc2x3.IfcRelAssignsToActor;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Assigns To Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssignsToActorImpl#getRelatingActor <em>Relating Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssignsToActorImpl#getActingRole <em>Acting Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelAssignsToActorImpl extends IfcRelAssignsImpl implements IfcRelAssignsToActor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssignsToActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelAssignsToActor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActor getRelatingActor() {
		return (IfcActor)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToActor_RelatingActor(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingActor(IfcActor newRelatingActor) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToActor_RelatingActor(), newRelatingActor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorRole getActingRole() {
		return (IfcActorRole)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToActor_ActingRole(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActingRole(IfcActorRole newActingRole) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToActor_ActingRole(), newActingRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActingRole() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToActor_ActingRole());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActingRole() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToActor_ActingRole());
	}

} //IfcRelAssignsToActorImpl
