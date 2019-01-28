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
package org.bimserver.models.ifc2x3tc1;

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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Owner History</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getOwningUser <em>Owning User</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getOwningApplication <em>Owning Application</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getChangeAction <em>Change Action</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifiedDate <em>Last Modified Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifyingUser <em>Last Modifying User</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifyingApplication <em>Last Modifying Application</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getCreationDate <em>Creation Date</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOwnerHistory()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcOwnerHistory extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Owning User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning User</em>' reference.
	 * @see #setOwningUser(IfcPersonAndOrganization)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOwnerHistory_OwningUser()
	 * @model
	 * @generated
	 */
	IfcPersonAndOrganization getOwningUser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getOwningUser <em>Owning User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning User</em>' reference.
	 * @see #getOwningUser()
	 * @generated
	 */
	void setOwningUser(IfcPersonAndOrganization value);

	/**
	 * Returns the value of the '<em><b>Owning Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Application</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Application</em>' reference.
	 * @see #setOwningApplication(IfcApplication)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOwnerHistory_OwningApplication()
	 * @model
	 * @generated
	 */
	IfcApplication getOwningApplication();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getOwningApplication <em>Owning Application</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Application</em>' reference.
	 * @see #getOwningApplication()
	 * @generated
	 */
	void setOwningApplication(IfcApplication value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcStateEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcStateEnum
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #setState(IfcStateEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOwnerHistory_State()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcStateEnum getState();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcStateEnum
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #getState()
	 * @generated
	 */
	void setState(IfcStateEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetState()
	 * @see #getState()
	 * @see #setState(IfcStateEnum)
	 * @generated
	 */
	void unsetState();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getState <em>State</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>State</em>' attribute is set.
	 * @see #unsetState()
	 * @see #getState()
	 * @see #setState(IfcStateEnum)
	 * @generated
	 */
	boolean isSetState();

	/**
	 * Returns the value of the '<em><b>Change Action</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcChangeActionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Action</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcChangeActionEnum
	 * @see #setChangeAction(IfcChangeActionEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOwnerHistory_ChangeAction()
	 * @model
	 * @generated
	 */
	IfcChangeActionEnum getChangeAction();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getChangeAction <em>Change Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Action</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcChangeActionEnum
	 * @see #getChangeAction()
	 * @generated
	 */
	void setChangeAction(IfcChangeActionEnum value);

	/**
	 * Returns the value of the '<em><b>Last Modified Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Modified Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Modified Date</em>' attribute.
	 * @see #isSetLastModifiedDate()
	 * @see #unsetLastModifiedDate()
	 * @see #setLastModifiedDate(long)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOwnerHistory_LastModifiedDate()
	 * @model unsettable="true"
	 * @generated
	 */
	long getLastModifiedDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifiedDate <em>Last Modified Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modified Date</em>' attribute.
	 * @see #isSetLastModifiedDate()
	 * @see #unsetLastModifiedDate()
	 * @see #getLastModifiedDate()
	 * @generated
	 */
	void setLastModifiedDate(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifiedDate <em>Last Modified Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLastModifiedDate()
	 * @see #getLastModifiedDate()
	 * @see #setLastModifiedDate(long)
	 * @generated
	 */
	void unsetLastModifiedDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifiedDate <em>Last Modified Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Last Modified Date</em>' attribute is set.
	 * @see #unsetLastModifiedDate()
	 * @see #getLastModifiedDate()
	 * @see #setLastModifiedDate(long)
	 * @generated
	 */
	boolean isSetLastModifiedDate();

	/**
	 * Returns the value of the '<em><b>Last Modifying User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Modifying User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Modifying User</em>' reference.
	 * @see #isSetLastModifyingUser()
	 * @see #unsetLastModifyingUser()
	 * @see #setLastModifyingUser(IfcPersonAndOrganization)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOwnerHistory_LastModifyingUser()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPersonAndOrganization getLastModifyingUser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifyingUser <em>Last Modifying User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modifying User</em>' reference.
	 * @see #isSetLastModifyingUser()
	 * @see #unsetLastModifyingUser()
	 * @see #getLastModifyingUser()
	 * @generated
	 */
	void setLastModifyingUser(IfcPersonAndOrganization value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifyingUser <em>Last Modifying User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLastModifyingUser()
	 * @see #getLastModifyingUser()
	 * @see #setLastModifyingUser(IfcPersonAndOrganization)
	 * @generated
	 */
	void unsetLastModifyingUser();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifyingUser <em>Last Modifying User</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Last Modifying User</em>' reference is set.
	 * @see #unsetLastModifyingUser()
	 * @see #getLastModifyingUser()
	 * @see #setLastModifyingUser(IfcPersonAndOrganization)
	 * @generated
	 */
	boolean isSetLastModifyingUser();

	/**
	 * Returns the value of the '<em><b>Last Modifying Application</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Modifying Application</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Modifying Application</em>' reference.
	 * @see #isSetLastModifyingApplication()
	 * @see #unsetLastModifyingApplication()
	 * @see #setLastModifyingApplication(IfcApplication)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOwnerHistory_LastModifyingApplication()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcApplication getLastModifyingApplication();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifyingApplication <em>Last Modifying Application</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modifying Application</em>' reference.
	 * @see #isSetLastModifyingApplication()
	 * @see #unsetLastModifyingApplication()
	 * @see #getLastModifyingApplication()
	 * @generated
	 */
	void setLastModifyingApplication(IfcApplication value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifyingApplication <em>Last Modifying Application</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLastModifyingApplication()
	 * @see #getLastModifyingApplication()
	 * @see #setLastModifyingApplication(IfcApplication)
	 * @generated
	 */
	void unsetLastModifyingApplication();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getLastModifyingApplication <em>Last Modifying Application</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Last Modifying Application</em>' reference is set.
	 * @see #unsetLastModifyingApplication()
	 * @see #getLastModifyingApplication()
	 * @see #setLastModifyingApplication(IfcApplication)
	 * @generated
	 */
	boolean isSetLastModifyingApplication();

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(long)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOwnerHistory_CreationDate()
	 * @model
	 * @generated
	 */
	long getCreationDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOwnerHistory#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(long value);

} // IfcOwnerHistory
