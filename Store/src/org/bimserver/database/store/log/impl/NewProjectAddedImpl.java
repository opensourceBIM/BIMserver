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
	public NewProjectAddedImpl() {
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
		Project project = (Project)eVirtualGet(LogPackage.NEW_PROJECT_ADDED__PROJECT);
		if (project != null && ((EObject)project).eIsProxy()) {
			InternalEObject oldProject = (InternalEObject)project;
			project = (Project)eResolveProxy(oldProject);
			if (project != oldProject) {
				eVirtualSet(LogPackage.NEW_PROJECT_ADDED__PROJECT, project);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LogPackage.NEW_PROJECT_ADDED__PROJECT, oldProject, project));
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
		return (Project)eVirtualGet(LogPackage.NEW_PROJECT_ADDED__PROJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		Project project = newProject;
		Object oldProject = eVirtualSet(LogPackage.NEW_PROJECT_ADDED__PROJECT, project);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.NEW_PROJECT_ADDED__PROJECT, oldProject == EVIRTUAL_NO_VALUE ? null : oldProject, project));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getParentProject() {
		Project parentProject = (Project)eVirtualGet(LogPackage.NEW_PROJECT_ADDED__PARENT_PROJECT);
		if (parentProject != null && ((EObject)parentProject).eIsProxy()) {
			InternalEObject oldParentProject = (InternalEObject)parentProject;
			parentProject = (Project)eResolveProxy(oldParentProject);
			if (parentProject != oldParentProject) {
				eVirtualSet(LogPackage.NEW_PROJECT_ADDED__PARENT_PROJECT, parentProject);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LogPackage.NEW_PROJECT_ADDED__PARENT_PROJECT, oldParentProject, parentProject));
			}
		}
		return parentProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project basicGetParentProject() {
		return (Project)eVirtualGet(LogPackage.NEW_PROJECT_ADDED__PARENT_PROJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentProject(Project newParentProject) {
		Project parentProject = newParentProject;
		Object oldParentProject = eVirtualSet(LogPackage.NEW_PROJECT_ADDED__PARENT_PROJECT, parentProject);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.NEW_PROJECT_ADDED__PARENT_PROJECT, oldParentProject == EVIRTUAL_NO_VALUE ? null : oldParentProject, parentProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LogPackage.NEW_PROJECT_ADDED__PROJECT:
				if (resolve) return getProject();
				return basicGetProject();
			case LogPackage.NEW_PROJECT_ADDED__PARENT_PROJECT:
				if (resolve) return getParentProject();
				return basicGetParentProject();
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
			case LogPackage.NEW_PROJECT_ADDED__PROJECT:
				setProject((Project)newValue);
				return;
			case LogPackage.NEW_PROJECT_ADDED__PARENT_PROJECT:
				setParentProject((Project)newValue);
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
			case LogPackage.NEW_PROJECT_ADDED__PROJECT:
				setProject((Project)null);
				return;
			case LogPackage.NEW_PROJECT_ADDED__PARENT_PROJECT:
				setParentProject((Project)null);
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
			case LogPackage.NEW_PROJECT_ADDED__PROJECT:
				return eVirtualGet(LogPackage.NEW_PROJECT_ADDED__PROJECT) != null;
			case LogPackage.NEW_PROJECT_ADDED__PARENT_PROJECT:
				return eVirtualGet(LogPackage.NEW_PROJECT_ADDED__PARENT_PROJECT) != null;
		}
		return super.eIsSet(featureID);
	}

} //NewProjectAddedImpl
