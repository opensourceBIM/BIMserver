/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.log;

import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Added To Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.log.UserAddedToProject#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.log.UserAddedToProject#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.log.LogPackage#getUserAddedToProject()
 * @model
 * @generated
 */
public interface UserAddedToProject extends LogAction {
	/**
	 * Returns the value of the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' reference.
	 * @see #setUser(User)
	 * @see org.bimserver.models.log.LogPackage#getUserAddedToProject_User()
	 * @model
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.UserAddedToProject#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see org.bimserver.models.log.LogPackage#getUserAddedToProject_Project()
	 * @model
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.UserAddedToProject#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

} // UserAddedToProject
