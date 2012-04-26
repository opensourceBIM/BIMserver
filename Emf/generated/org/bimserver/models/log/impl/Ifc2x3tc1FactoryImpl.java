/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.log.impl;

import org.bimserver.models.log.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Ifc2x3tc1FactoryImpl extends EFactoryImpl implements Ifc2x3tc1Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Ifc2x3tc1Factory init() {
		try {
			Ifc2x3tc1Factory theIfc2x3tc1Factory = (Ifc2x3tc1Factory) EPackage.Registry.INSTANCE.getEFactory("log");
			if (theIfc2x3tc1Factory != null) {
				return theIfc2x3tc1Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Ifc2x3tc1FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifc2x3tc1FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case Ifc2x3tc1Package.LOG_ACTION:
			return (EObject) createLogAction();
		case Ifc2x3tc1Package.SERVER_LOG:
			return (EObject) createServerLog();
		case Ifc2x3tc1Package.NEW_USER_ADDED:
			return (EObject) createNewUserAdded();
		case Ifc2x3tc1Package.NEW_PROJECT_ADDED:
			return (EObject) createNewProjectAdded();
		case Ifc2x3tc1Package.REVISION_BRANCHED:
			return (EObject) createRevisionBranched();
		case Ifc2x3tc1Package.NEW_REVISION_ADDED:
			return (EObject) createNewRevisionAdded();
		case Ifc2x3tc1Package.NEW_CHECKOUT_ADDED:
			return (EObject) createNewCheckoutAdded();
		case Ifc2x3tc1Package.SETTINGS_SAVED:
			return (EObject) createSettingsSaved();
		case Ifc2x3tc1Package.USER_ADDED_TO_PROJECT:
			return (EObject) createUserAddedToProject();
		case Ifc2x3tc1Package.NEW_OBJECT_IDM_UPLOADED:
			return (EObject) createNewObjectIDMUploaded();
		case Ifc2x3tc1Package.DOWNLOAD:
			return (EObject) createDownload();
		case Ifc2x3tc1Package.USER_REMOVED_FROM_PROJECT:
			return (EObject) createUserRemovedFromProject();
		case Ifc2x3tc1Package.PROJECT_DELETED:
			return (EObject) createProjectDeleted();
		case Ifc2x3tc1Package.USER_DELETED:
			return (EObject) createUserDeleted();
		case Ifc2x3tc1Package.PASSWORD_RESET:
			return (EObject) createPasswordReset();
		case Ifc2x3tc1Package.DATABASE_CREATED:
			return (EObject) createDatabaseCreated();
		case Ifc2x3tc1Package.SERVER_STARTED:
			return (EObject) createServerStarted();
		case Ifc2x3tc1Package.PROJECT_UPDATED:
			return (EObject) createProjectUpdated();
		case Ifc2x3tc1Package.USER_UNDELETED:
			return (EObject) createUserUndeleted();
		case Ifc2x3tc1Package.PROJECT_UNDELETED:
			return (EObject) createProjectUndeleted();
		case Ifc2x3tc1Package.REVISION_UPDATED:
			return (EObject) createRevisionUpdated();
		case Ifc2x3tc1Package.GEO_TAG_UPDATED:
			return (EObject) createGeoTagUpdated();
		case Ifc2x3tc1Package.CLASH_DETECTION_SETTINGS_UPDATED:
			return (EObject) createClashDetectionSettingsUpdated();
		case Ifc2x3tc1Package.PASSWORD_CHANGED:
			return (EObject) createPasswordChanged();
		case Ifc2x3tc1Package.USER_CHANGED:
			return (EObject) createUserChanged();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case Ifc2x3tc1Package.ACCESS_METHOD:
			return createAccessMethodFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case Ifc2x3tc1Package.ACCESS_METHOD:
			return convertAccessMethodToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogAction createLogAction() {
		LogActionImpl logAction = new LogActionImpl();
		return logAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerLog createServerLog() {
		ServerLogImpl serverLog = new ServerLogImpl();
		return serverLog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewUserAdded createNewUserAdded() {
		NewUserAddedImpl newUserAdded = new NewUserAddedImpl();
		return newUserAdded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewProjectAdded createNewProjectAdded() {
		NewProjectAddedImpl newProjectAdded = new NewProjectAddedImpl();
		return newProjectAdded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RevisionBranched createRevisionBranched() {
		RevisionBranchedImpl revisionBranched = new RevisionBranchedImpl();
		return revisionBranched;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewRevisionAdded createNewRevisionAdded() {
		NewRevisionAddedImpl newRevisionAdded = new NewRevisionAddedImpl();
		return newRevisionAdded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewCheckoutAdded createNewCheckoutAdded() {
		NewCheckoutAddedImpl newCheckoutAdded = new NewCheckoutAddedImpl();
		return newCheckoutAdded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SettingsSaved createSettingsSaved() {
		SettingsSavedImpl settingsSaved = new SettingsSavedImpl();
		return settingsSaved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserAddedToProject createUserAddedToProject() {
		UserAddedToProjectImpl userAddedToProject = new UserAddedToProjectImpl();
		return userAddedToProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewObjectIDMUploaded createNewObjectIDMUploaded() {
		NewObjectIDMUploadedImpl newObjectIDMUploaded = new NewObjectIDMUploadedImpl();
		return newObjectIDMUploaded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Download createDownload() {
		DownloadImpl download = new DownloadImpl();
		return download;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserRemovedFromProject createUserRemovedFromProject() {
		UserRemovedFromProjectImpl userRemovedFromProject = new UserRemovedFromProjectImpl();
		return userRemovedFromProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectDeleted createProjectDeleted() {
		ProjectDeletedImpl projectDeleted = new ProjectDeletedImpl();
		return projectDeleted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserDeleted createUserDeleted() {
		UserDeletedImpl userDeleted = new UserDeletedImpl();
		return userDeleted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PasswordReset createPasswordReset() {
		PasswordResetImpl passwordReset = new PasswordResetImpl();
		return passwordReset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseCreated createDatabaseCreated() {
		DatabaseCreatedImpl databaseCreated = new DatabaseCreatedImpl();
		return databaseCreated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerStarted createServerStarted() {
		ServerStartedImpl serverStarted = new ServerStartedImpl();
		return serverStarted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectUpdated createProjectUpdated() {
		ProjectUpdatedImpl projectUpdated = new ProjectUpdatedImpl();
		return projectUpdated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserUndeleted createUserUndeleted() {
		UserUndeletedImpl userUndeleted = new UserUndeletedImpl();
		return userUndeleted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectUndeleted createProjectUndeleted() {
		ProjectUndeletedImpl projectUndeleted = new ProjectUndeletedImpl();
		return projectUndeleted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RevisionUpdated createRevisionUpdated() {
		RevisionUpdatedImpl revisionUpdated = new RevisionUpdatedImpl();
		return revisionUpdated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeoTagUpdated createGeoTagUpdated() {
		GeoTagUpdatedImpl geoTagUpdated = new GeoTagUpdatedImpl();
		return geoTagUpdated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClashDetectionSettingsUpdated createClashDetectionSettingsUpdated() {
		ClashDetectionSettingsUpdatedImpl clashDetectionSettingsUpdated = new ClashDetectionSettingsUpdatedImpl();
		return clashDetectionSettingsUpdated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PasswordChanged createPasswordChanged() {
		PasswordChangedImpl passwordChanged = new PasswordChangedImpl();
		return passwordChanged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserChanged createUserChanged() {
		UserChangedImpl userChanged = new UserChangedImpl();
		return userChanged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessMethod createAccessMethodFromString(EDataType eDataType, String initialValue) {
		AccessMethod result = AccessMethod.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifc2x3tc1Package getIfc2x3tc1Package() {
		return (Ifc2x3tc1Package) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Ifc2x3tc1Package getPackage() {
		return Ifc2x3tc1Package.eINSTANCE;
	}

} //Ifc2x3tc1FactoryImpl
