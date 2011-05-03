/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

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
 * An implementation of the model object '<em><b>Clash Detection Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ClashDetectionSettingsImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ClashDetectionSettingsImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ClashDetectionSettingsImpl#getMargin <em>Margin</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ClashDetectionSettingsImpl#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ClashDetectionSettingsImpl#getIgnoredClasses <em>Ignored Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClashDetectionSettingsImpl extends IdEObjectImpl implements ClashDetectionSettings
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClashDetectionSettingsImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return StorePackage.Literals.CLASH_DETECTION_SETTINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled()
	{
		return (Boolean)eGet(StorePackage.Literals.CLASH_DETECTION_SETTINGS__ENABLED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled)
	{
		eSet(StorePackage.Literals.CLASH_DETECTION_SETTINGS__ENABLED, newEnabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Project> getProjects()
	{
		return (EList<Project>)eGet(StorePackage.Literals.CLASH_DETECTION_SETTINGS__PROJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMargin()
	{
		return (Float)eGet(StorePackage.Literals.CLASH_DETECTION_SETTINGS__MARGIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMargin(float newMargin)
	{
		eSet(StorePackage.Literals.CLASH_DETECTION_SETTINGS__MARGIN, newMargin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Revision> getRevisions()
	{
		return (EList<Revision>)eGet(StorePackage.Literals.CLASH_DETECTION_SETTINGS__REVISIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getIgnoredClasses()
	{
		return (EList<String>)eGet(StorePackage.Literals.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES, true);
	}

} //ClashDetectionSettingsImpl
