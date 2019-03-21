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
package org.bimserver.models.store;

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
 * A representation of the model object '<em><b>Project Small</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.ProjectSmall#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.ProjectSmall#getParentId <em>Parent Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.ProjectSmall#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.store.ProjectSmall#getNrRevisions <em>Nr Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.ProjectSmall#getNrSubProjects <em>Nr Sub Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.ProjectSmall#isHasCheckinRights <em>Has Checkin Rights</em>}</li>
 *   <li>{@link org.bimserver.models.store.ProjectSmall#getLastRevisionId <em>Last Revision Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.ProjectSmall#getSchema <em>Schema</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getProjectSmall()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface ProjectSmall extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.store.StorePackage#getProjectSmall_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ProjectSmall#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parent Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Id</em>' attribute.
	 * @see #setParentId(long)
	 * @see org.bimserver.models.store.StorePackage#getProjectSmall_ParentId()
	 * @model
	 * @generated
	 */
	long getParentId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ProjectSmall#getParentId <em>Parent Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Id</em>' attribute.
	 * @see #getParentId()
	 * @generated
	 */
	void setParentId(long value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.ObjectState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.ObjectState
	 * @see #setState(ObjectState)
	 * @see org.bimserver.models.store.StorePackage#getProjectSmall_State()
	 * @model
	 * @generated
	 */
	ObjectState getState();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ProjectSmall#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.ObjectState
	 * @see #getState()
	 * @generated
	 */
	void setState(ObjectState value);

	/**
	 * Returns the value of the '<em><b>Nr Revisions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nr Revisions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Revisions</em>' attribute.
	 * @see #setNrRevisions(int)
	 * @see org.bimserver.models.store.StorePackage#getProjectSmall_NrRevisions()
	 * @model
	 * @generated
	 */
	int getNrRevisions();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ProjectSmall#getNrRevisions <em>Nr Revisions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Revisions</em>' attribute.
	 * @see #getNrRevisions()
	 * @generated
	 */
	void setNrRevisions(int value);

	/**
	 * Returns the value of the '<em><b>Nr Sub Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nr Sub Projects</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Sub Projects</em>' attribute.
	 * @see #setNrSubProjects(int)
	 * @see org.bimserver.models.store.StorePackage#getProjectSmall_NrSubProjects()
	 * @model
	 * @generated
	 */
	int getNrSubProjects();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ProjectSmall#getNrSubProjects <em>Nr Sub Projects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Sub Projects</em>' attribute.
	 * @see #getNrSubProjects()
	 * @generated
	 */
	void setNrSubProjects(int value);

	/**
	 * Returns the value of the '<em><b>Has Checkin Rights</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Checkin Rights</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Checkin Rights</em>' attribute.
	 * @see #setHasCheckinRights(boolean)
	 * @see org.bimserver.models.store.StorePackage#getProjectSmall_HasCheckinRights()
	 * @model
	 * @generated
	 */
	boolean isHasCheckinRights();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ProjectSmall#isHasCheckinRights <em>Has Checkin Rights</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Checkin Rights</em>' attribute.
	 * @see #isHasCheckinRights()
	 * @generated
	 */
	void setHasCheckinRights(boolean value);

	/**
	 * Returns the value of the '<em><b>Last Revision Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Revision Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Revision Id</em>' attribute.
	 * @see #setLastRevisionId(long)
	 * @see org.bimserver.models.store.StorePackage#getProjectSmall_LastRevisionId()
	 * @model
	 * @generated
	 */
	long getLastRevisionId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ProjectSmall#getLastRevisionId <em>Last Revision Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Revision Id</em>' attribute.
	 * @see #getLastRevisionId()
	 * @generated
	 */
	void setLastRevisionId(long value);

	/**
	 * Returns the value of the '<em><b>Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' attribute.
	 * @see #setSchema(String)
	 * @see org.bimserver.models.store.StorePackage#getProjectSmall_Schema()
	 * @model
	 * @generated
	 */
	String getSchema();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ProjectSmall#getSchema <em>Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' attribute.
	 * @see #getSchema()
	 * @generated
	 */
	void setSchema(String value);

} // ProjectSmall
