/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcActorRole;
import org.bimserver.models.ifc2x3.IfcRoleEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Actor Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcActorRoleImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcActorRoleImpl#getUserDefinedRole <em>User Defined Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcActorRoleImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcActorRoleImpl extends IdEObjectImpl implements IfcActorRole {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcActorRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcActorRole();
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
	public IfcRoleEnum getRole() {
		return (IfcRoleEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcActorRole_Role(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(IfcRoleEnum newRole) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcActorRole_Role(), newRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedRole() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcActorRole_UserDefinedRole(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedRole(String newUserDefinedRole) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcActorRole_UserDefinedRole(), newUserDefinedRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedRole() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcActorRole_UserDefinedRole());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedRole() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcActorRole_UserDefinedRole());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcActorRole_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcActorRole_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcActorRole_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcActorRole_Description());
	}

} //IfcActorRoleImpl
