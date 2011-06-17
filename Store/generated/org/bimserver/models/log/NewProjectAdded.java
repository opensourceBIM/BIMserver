/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.log;

import org.bimserver.models.store.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Project Added</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.log.NewProjectAdded#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.log.NewProjectAdded#getParentProject <em>Parent Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.log.LogPackage#getNewProjectAdded()
 * @model
 * @generated
 */
public interface NewProjectAdded extends LogAction {
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
	 * @see org.bimserver.models.log.LogPackage#getNewProjectAdded_Project()
	 * @model
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.NewProjectAdded#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>Parent Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Project</em>' reference.
	 * @see #setParentProject(Project)
	 * @see org.bimserver.models.log.LogPackage#getNewProjectAdded_ParentProject()
	 * @model
	 * @generated
	 */
	Project getParentProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.NewProjectAdded#getParentProject <em>Parent Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Project</em>' reference.
	 * @see #getParentProject()
	 * @generated
	 */
	void setParentProject(Project value);

} // NewProjectAdded
