/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Project Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.NewProjectNotification#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getNewProjectNotification()
 * @model
 * @generated
 */
public interface NewProjectNotification extends Notification {
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
	 * @see org.bimserver.models.store.StorePackage#getNewProjectNotification_Project()
	 * @model
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewProjectNotification#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

} // NewProjectNotification
