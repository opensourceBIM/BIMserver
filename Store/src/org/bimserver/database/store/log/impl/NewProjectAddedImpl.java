/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.log.impl;

import org.bimserver.database.store.Project;
import org.bimserver.database.store.log.LogPackage;
import org.bimserver.database.store.log.NewProjectAdded;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Project Added</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.log.impl.NewProjectAddedImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.database.store.log.impl.NewProjectAddedImpl#getParentProject <em>Parent Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewProjectAddedImpl extends LogActionImpl implements NewProjectAdded {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewProjectAddedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.NEW_PROJECT_ADDED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		return (Project) eGet(LogPackage.Literals.NEW_PROJECT_ADDED__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		eSet(LogPackage.Literals.NEW_PROJECT_ADDED__PROJECT, newProject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getParentProject() {
		return (Project) eGet(LogPackage.Literals.NEW_PROJECT_ADDED__PARENT_PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentProject(Project newParentProject) {
		eSet(LogPackage.Literals.NEW_PROJECT_ADDED__PARENT_PROJECT, newParentProject);
	}

} //NewProjectAddedImpl
