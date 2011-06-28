/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import org.bimserver.models.store.GuidClash;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guid Clash</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.GuidClashImpl#getGuid1 <em>Guid1</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.GuidClashImpl#getGuid2 <em>Guid2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuidClashImpl extends ClashImpl implements GuidClash {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuidClashImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.GUID_CLASH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuid1() {
		return (String)eGet(StorePackage.Literals.GUID_CLASH__GUID1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuid1(String newGuid1) {
		eSet(StorePackage.Literals.GUID_CLASH__GUID1, newGuid1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuid2() {
		return (String)eGet(StorePackage.Literals.GUID_CLASH__GUID2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuid2(String newGuid2) {
		eSet(StorePackage.Literals.GUID_CLASH__GUID2, newGuid2);
	}

} //GuidClashImpl
