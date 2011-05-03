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
 * A representation of the model object '<em><b>Clash</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.Clash#getName1 <em>Name1</em>}</li>
 *   <li>{@link org.bimserver.models.store.Clash#getName2 <em>Name2</em>}</li>
 *   <li>{@link org.bimserver.models.store.Clash#getType1 <em>Type1</em>}</li>
 *   <li>{@link org.bimserver.models.store.Clash#getType2 <em>Type2</em>}</li>
 *   <li>{@link org.bimserver.models.store.Clash#getRevision1 <em>Revision1</em>}</li>
 *   <li>{@link org.bimserver.models.store.Clash#getRevision2 <em>Revision2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getClash()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Clash extends IdEObject
{
	/**
	 * Returns the value of the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name1</em>' attribute.
	 * @see #setName1(String)
	 * @see org.bimserver.models.store.StorePackage#getClash_Name1()
	 * @model
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

	/**
	 * Returns the value of the '<em><b>Name2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name2</em>' attribute.
	 * @see #setName2(String)
	 * @see org.bimserver.models.store.StorePackage#getClash_Name2()
	 * @model
	 * @generated
	 */
	String getName2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getName2 <em>Name2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name2</em>' attribute.
	 * @see #getName2()
	 * @generated
	 */
	void setName2(String value);

	/**
	 * Returns the value of the '<em><b>Type1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type1</em>' attribute.
	 * @see #setType1(String)
	 * @see org.bimserver.models.store.StorePackage#getClash_Type1()
	 * @model
	 * @generated
	 */
	String getType1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getType1 <em>Type1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type1</em>' attribute.
	 * @see #getType1()
	 * @generated
	 */
	void setType1(String value);

	/**
	 * Returns the value of the '<em><b>Type2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type2</em>' attribute.
	 * @see #setType2(String)
	 * @see org.bimserver.models.store.StorePackage#getClash_Type2()
	 * @model
	 * @generated
	 */
	String getType2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getType2 <em>Type2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type2</em>' attribute.
	 * @see #getType2()
	 * @generated
	 */
	void setType2(String value);

	/**
	 * Returns the value of the '<em><b>Revision1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision1</em>' reference.
	 * @see #setRevision1(Revision)
	 * @see org.bimserver.models.store.StorePackage#getClash_Revision1()
	 * @model
	 * @generated
	 */
	Revision getRevision1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getRevision1 <em>Revision1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision1</em>' reference.
	 * @see #getRevision1()
	 * @generated
	 */
	void setRevision1(Revision value);

	/**
	 * Returns the value of the '<em><b>Revision2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision2</em>' reference.
	 * @see #setRevision2(Revision)
	 * @see org.bimserver.models.store.StorePackage#getClash_Revision2()
	 * @model
	 * @generated
	 */
	Revision getRevision2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getRevision2 <em>Revision2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision2</em>' reference.
	 * @see #getRevision2()
	 * @generated
	 */
	void setRevision2(Revision value);

} // Clash
