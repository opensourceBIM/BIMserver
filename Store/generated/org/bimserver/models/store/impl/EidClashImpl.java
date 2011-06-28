/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import org.bimserver.models.store.EidClash;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Eid Clash</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.EidClashImpl#getEid1 <em>Eid1</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.EidClashImpl#getEid2 <em>Eid2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EidClashImpl extends ClashImpl implements EidClash {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EidClashImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.EID_CLASH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEid1() {
		return (Long)eGet(StorePackage.Literals.EID_CLASH__EID1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEid1(long newEid1) {
		eSet(StorePackage.Literals.EID_CLASH__EID1, newEid1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEid2() {
		return (Long)eGet(StorePackage.Literals.EID_CLASH__EID2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEid2(long newEid2) {
		eSet(StorePackage.Literals.EID_CLASH__EID2, newEid2);
	}

} //EidClashImpl
