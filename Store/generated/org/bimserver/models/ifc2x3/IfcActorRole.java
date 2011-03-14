/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Actor Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcActorRole#getRole <em>Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcActorRole#getUserDefinedRole <em>User Defined Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcActorRole#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcActorRole()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcActorRole extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcRoleEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcRoleEnum
	 * @see #setRole(IfcRoleEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcActorRole_Role()
	 * @model
	 * @generated
	 */
	IfcRoleEnum getRole();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcActorRole#getRole <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcRoleEnum
	 * @see #getRole()
	 * @generated
	 */
	void setRole(IfcRoleEnum value);

	/**
	 * Returns the value of the '<em><b>User Defined Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Role</em>' attribute.
	 * @see #isSetUserDefinedRole()
	 * @see #unsetUserDefinedRole()
	 * @see #setUserDefinedRole(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcActorRole_UserDefinedRole()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedRole();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcActorRole#getUserDefinedRole <em>User Defined Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Role</em>' attribute.
	 * @see #isSetUserDefinedRole()
	 * @see #unsetUserDefinedRole()
	 * @see #getUserDefinedRole()
	 * @generated
	 */
	void setUserDefinedRole(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcActorRole#getUserDefinedRole <em>User Defined Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedRole()
	 * @see #getUserDefinedRole()
	 * @see #setUserDefinedRole(String)
	 * @generated
	 */
	void unsetUserDefinedRole();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcActorRole#getUserDefinedRole <em>User Defined Role</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Role</em>' attribute is set.
	 * @see #unsetUserDefinedRole()
	 * @see #getUserDefinedRole()
	 * @see #setUserDefinedRole(String)
	 * @generated
	 */
	boolean isSetUserDefinedRole();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #setDescription(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcActorRole_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcActorRole#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcActorRole#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcActorRole#getDescription <em>Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Description</em>' attribute is set.
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	boolean isSetDescription();

} // IfcActorRole
