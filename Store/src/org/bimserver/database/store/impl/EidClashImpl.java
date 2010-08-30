/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.impl;

import org.bimserver.database.store.EidClash;
import org.bimserver.database.store.StorePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Eid Clash</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.impl.EidClashImpl#getEid1 <em>Eid1</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.EidClashImpl#getEid2 <em>Eid2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EidClashImpl extends ClashImpl implements EidClash {
	/**
	 * The default value of the '{@link #getEid1() <em>Eid1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEid1()
	 * @generated
	 * @ordered
	 */
	protected static final long EID1_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getEid1() <em>Eid1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEid1()
	 * @generated
	 * @ordered
	 */
	protected long eid1 = EID1_EDEFAULT;

	/**
	 * The default value of the '{@link #getEid2() <em>Eid2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEid2()
	 * @generated
	 * @ordered
	 */
	protected static final long EID2_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getEid2() <em>Eid2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEid2()
	 * @generated
	 * @ordered
	 */
	protected long eid2 = EID2_EDEFAULT;

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
		return eid1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEid1(long newEid1) {
		long oldEid1 = eid1;
		eid1 = newEid1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.EID_CLASH__EID1, oldEid1, eid1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEid2() {
		return eid2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEid2(long newEid2) {
		long oldEid2 = eid2;
		eid2 = newEid2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.EID_CLASH__EID2, oldEid2, eid2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StorePackage.EID_CLASH__EID1:
				return getEid1();
			case StorePackage.EID_CLASH__EID2:
				return getEid2();
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
			case StorePackage.EID_CLASH__EID1:
				setEid1((Long)newValue);
				return;
			case StorePackage.EID_CLASH__EID2:
				setEid2((Long)newValue);
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
			case StorePackage.EID_CLASH__EID1:
				setEid1(EID1_EDEFAULT);
				return;
			case StorePackage.EID_CLASH__EID2:
				setEid2(EID2_EDEFAULT);
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
			case StorePackage.EID_CLASH__EID1:
				return eid1 != EID1_EDEFAULT;
			case StorePackage.EID_CLASH__EID2:
				return eid2 != EID2_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (eid1: ");
		result.append(eid1);
		result.append(", eid2: ");
		result.append(eid2);
		result.append(')');
		return result.toString();
	}

} //EidClashImpl
