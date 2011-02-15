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
import org.bimserver.database.store.log.UserAddedToProject;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Added To Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.log.impl.UserAddedToProjectImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.database.store.log.impl.UserAddedToProjectImpl#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserAddedToProjectImpl extends LogActionImpl implements UserAddedToProject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserAddedToProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.USER_ADDED_TO_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getUser() {
		User user = (User)eVirtualGet(LogPackage.USER_ADDED_TO_PROJECT__USER);
		if (user != null && ((EObject)user).eIsProxy()) {
			InternalEObject oldUser = (InternalEObject)user;
			user = (User)eResolveProxy(oldUser);
			if (user != oldUser) {
				eVirtualSet(LogPackage.USER_ADDED_TO_PROJECT__USER, user);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LogPackage.USER_ADDED_TO_PROJECT__USER, oldUser, user));
			}
		}
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetUser() {
		return (User)eVirtualGet(LogPackage.USER_ADDED_TO_PROJECT__USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		User user = newUser;
		Object oldUser = eVirtualSet(LogPackage.USER_ADDED_TO_PROJECT__USER, user);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.USER_ADDED_TO_PROJECT__USER, oldUser == EVIRTUAL_NO_VALUE ? null : oldUser, user));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		Project project = (Project)eVirtualGet(LogPackage.USER_ADDED_TO_PROJECT__PROJECT);
		if (project != null && ((EObject)project).eIsProxy()) {
			InternalEObject oldProject = (InternalEObject)project;
			project = (Project)eResolveProxy(oldProject);
			if (project != oldProject) {
				eVirtualSet(LogPackage.USER_ADDED_TO_PROJECT__PROJECT, project);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LogPackage.USER_ADDED_TO_PROJECT__PROJECT, oldProject, project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project basicGetProject() {
		return (Project)eVirtualGet(LogPackage.USER_ADDED_TO_PROJECT__PROJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		Project project = newProject;
		Object oldProject = eVirtualSet(LogPackage.USER_ADDED_TO_PROJECT__PROJECT, project);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.USER_ADDED_TO_PROJECT__PROJECT, oldProject == EVIRTUAL_NO_VALUE ? null : oldProject, project));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LogPackage.USER_ADDED_TO_PROJECT__USER:
				if (resolve) return getUser();
				return basicGetUser();
			case LogPackage.USER_ADDED_TO_PROJECT__PROJECT:
				if (resolve) return getProject();
				return basicGetProject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LogPackage.USER_ADDED_TO_PROJECT__USER:
				setUser((User)newValue);
				return;
			case LogPackage.USER_ADDED_TO_PROJECT__PROJECT:
				setProject((Project)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LogPackage.USER_ADDED_TO_PROJECT__USER:
				setUser((User)null);
				return;
			case LogPackage.USER_ADDED_TO_PROJECT__PROJECT:
				setProject((Project)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LogPackage.USER_ADDED_TO_PROJECT__USER:
				return eVirtualGet(LogPackage.USER_ADDED_TO_PROJECT__USER) != null;
			case LogPackage.USER_ADDED_TO_PROJECT__PROJECT:
				return eVirtualGet(LogPackage.USER_ADDED_TO_PROJECT__PROJECT) != null;
		}
		return super.eIsSet(featureID);
	}

} //UserAddedToProjectImpl
