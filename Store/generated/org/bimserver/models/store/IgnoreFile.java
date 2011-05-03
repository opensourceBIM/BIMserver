/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;

import org.bimserver.models.ifc2x3.impl.Ifc2x3PackageImpl;

import org.bimserver.models.log.LogPackage;

import org.bimserver.models.log.impl.LogPackageImpl;

import org.bimserver.models.store.*;

import org.bimserver.models.store.impl.CheckoutImpl;
import org.bimserver.models.store.impl.ClashDetectionSettingsImpl;
import org.bimserver.models.store.impl.ClashImpl;
import org.bimserver.models.store.impl.ConcreteRevisionImpl;
import org.bimserver.models.store.impl.EidClashImpl;
import org.bimserver.models.store.impl.GeoTagImpl;
import org.bimserver.models.store.impl.GuidClashImpl;
import org.bimserver.models.store.impl.IgnoreFileImpl;
import org.bimserver.models.store.impl.ProjectImpl;
import org.bimserver.models.store.impl.RevisionImpl;
import org.bimserver.models.store.impl.SerializerImpl;
import org.bimserver.models.store.impl.SettingsImpl;
import org.bimserver.models.store.impl.UserImpl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ignore File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.IgnoreFile#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.IgnoreFile#getData <em>Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.IgnoreFile#getSerializers <em>Serializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.IgnoreFile#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getIgnoreFile()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IgnoreFile extends IdEObject
{
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
	 * @see org.bimserver.models.store.StorePackage#getIgnoreFile_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.IgnoreFile#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(byte[])
	 * @see org.bimserver.models.store.StorePackage#getIgnoreFile_Data()
	 * @model
	 * @generated
	 */
	byte[] getData();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.IgnoreFile#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(byte[] value);

	/**
	 * Returns the value of the '<em><b>Serializers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Serializer}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Serializer#getIgnoreFile <em>Ignore File</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serializers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serializers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getIgnoreFile_Serializers()
	 * @see org.bimserver.models.store.Serializer#getIgnoreFile
	 * @model opposite="ignoreFile"
	 * @generated
	 */
	EList<Serializer> getSerializers();

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Settings#getIgnoreFiles <em>Ignore Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' reference.
	 * @see #setSettings(Settings)
	 * @see org.bimserver.models.store.StorePackage#getIgnoreFile_Settings()
	 * @see org.bimserver.models.store.Settings#getIgnoreFiles
	 * @model opposite="ignoreFiles"
	 * @generated
	 */
	Settings getSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.IgnoreFile#getSettings <em>Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settings</em>' reference.
	 * @see #getSettings()
	 * @generated
	 */
	void setSettings(Settings value);

} // IgnoreFile
