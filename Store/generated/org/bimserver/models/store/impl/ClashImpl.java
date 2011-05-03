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
 * An implementation of the model object '<em><b>Clash</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ClashImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ClashImpl#getName2 <em>Name2</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ClashImpl#getType1 <em>Type1</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ClashImpl#getType2 <em>Type2</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ClashImpl#getRevision1 <em>Revision1</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ClashImpl#getRevision2 <em>Revision2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClashImpl extends IdEObjectImpl implements Clash
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClashImpl()
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
		return StorePackage.Literals.CLASH;
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
	public String getName1()
	{
		return (String)eGet(StorePackage.Literals.CLASH__NAME1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName1(String newName1)
	{
		eSet(StorePackage.Literals.CLASH__NAME1, newName1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName2()
	{
		return (String)eGet(StorePackage.Literals.CLASH__NAME2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName2(String newName2)
	{
		eSet(StorePackage.Literals.CLASH__NAME2, newName2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType1()
	{
		return (String)eGet(StorePackage.Literals.CLASH__TYPE1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType1(String newType1)
	{
		eSet(StorePackage.Literals.CLASH__TYPE1, newType1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType2()
	{
		return (String)eGet(StorePackage.Literals.CLASH__TYPE2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType2(String newType2)
	{
		eSet(StorePackage.Literals.CLASH__TYPE2, newType2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getRevision1()
	{
		return (Revision)eGet(StorePackage.Literals.CLASH__REVISION1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision1(Revision newRevision1)
	{
		eSet(StorePackage.Literals.CLASH__REVISION1, newRevision1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getRevision2()
	{
		return (Revision)eGet(StorePackage.Literals.CLASH__REVISION2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision2(Revision newRevision2)
	{
		eSet(StorePackage.Literals.CLASH__REVISION2, newRevision2);
	}

} //ClashImpl
