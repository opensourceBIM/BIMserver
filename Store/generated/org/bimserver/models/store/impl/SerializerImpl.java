/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.store.IgnoreFile;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Serializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.SerializerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerImpl#getIgnoreFile <em>Ignore File</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerImpl#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SerializerImpl extends IdEObjectImpl implements Serializer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SerializerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.SERIALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(StorePackage.Literals.SERIALIZER__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(StorePackage.Literals.SERIALIZER__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(StorePackage.Literals.SERIALIZER__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.SERIALIZER__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return (String)eGet(StorePackage.Literals.SERIALIZER__CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		eSet(StorePackage.Literals.SERIALIZER__CLASS_NAME, newClassName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled() {
		return (Boolean)eGet(StorePackage.Literals.SERIALIZER__ENABLED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled) {
		eSet(StorePackage.Literals.SERIALIZER__ENABLED, newEnabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IgnoreFile getIgnoreFile() {
		return (IgnoreFile)eGet(StorePackage.Literals.SERIALIZER__IGNORE_FILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIgnoreFile(IgnoreFile newIgnoreFile) {
		eSet(StorePackage.Literals.SERIALIZER__IGNORE_FILE, newIgnoreFile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Settings getSettings() {
		return (Settings)eGet(StorePackage.Literals.SERIALIZER__SETTINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettings(Settings newSettings) {
		eSet(StorePackage.Literals.SERIALIZER__SETTINGS, newSettings);
	}

} //SerializerImpl
