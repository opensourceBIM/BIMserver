/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.log.impl;

import org.bimserver.database.store.Project;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.LogPackage;
import org.bimserver.database.store.log.UserRemovedFromProject;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Removed From Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.log.impl.UserRemovedFromProjectImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.database.store.log.impl.UserRemovedFromProjectImpl#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserRemovedFromProjectImpl extends LogActionImpl implements UserRemovedFromProject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserRemovedFromProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.USER_REMOVED_FROM_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getUser() {
		return (User) eGet(LogPackage.Literals.USER_REMOVED_FROM_PROJECT__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		eSet(LogPackage.Literals.USER_REMOVED_FROM_PROJECT__USER, newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		return (Project) eGet(LogPackage.Literals.USER_REMOVED_FROM_PROJECT__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		eSet(LogPackage.Literals.USER_REMOVED_FROM_PROJECT__PROJECT, newProject);
	}

} //UserRemovedFromProjectImpl
