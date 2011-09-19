/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.store.CompareContainer;
import org.bimserver.models.store.CompareItem;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compare Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.CompareContainerImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.CompareContainerImpl#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompareContainerImpl extends IdEObjectImpl implements CompareContainer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompareContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.COMPARE_CONTAINER;
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
	public String getType() {
		return (String)eGet(StorePackage.Literals.COMPARE_CONTAINER__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		eSet(StorePackage.Literals.COMPARE_CONTAINER__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<CompareItem> getItems() {
		return (EList<CompareItem>)eGet(StorePackage.Literals.COMPARE_CONTAINER__ITEMS, true);
	}

} //CompareContainerImpl
