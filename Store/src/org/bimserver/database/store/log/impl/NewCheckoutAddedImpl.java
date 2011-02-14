/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.log.impl;

import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.log.LogPackage;
import org.bimserver.database.store.log.NewCheckoutAdded;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Checkout Added</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.log.impl.NewCheckoutAddedImpl#getCheckout <em>Checkout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewCheckoutAddedImpl extends LogActionImpl implements NewCheckoutAdded {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewCheckoutAddedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.NEW_CHECKOUT_ADDED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Checkout getCheckout() {
		Checkout checkout = (Checkout)eVirtualGet(LogPackage.NEW_CHECKOUT_ADDED__CHECKOUT);
		if (checkout != null && ((EObject)checkout).eIsProxy()) {
			InternalEObject oldCheckout = (InternalEObject)checkout;
			checkout = (Checkout)eResolveProxy(oldCheckout);
			if (checkout != oldCheckout) {
				eVirtualSet(LogPackage.NEW_CHECKOUT_ADDED__CHECKOUT, checkout);
			}
		}
		return checkout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Checkout basicGetCheckout() {
		return (Checkout)eVirtualGet(LogPackage.NEW_CHECKOUT_ADDED__CHECKOUT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckout(Checkout newCheckout) {
		Checkout checkout = newCheckout;
		Object oldCheckout = eVirtualSet(LogPackage.NEW_CHECKOUT_ADDED__CHECKOUT, checkout);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LogPackage.NEW_CHECKOUT_ADDED__CHECKOUT:
				if (resolve) return getCheckout();
				return basicGetCheckout();
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
			case LogPackage.NEW_CHECKOUT_ADDED__CHECKOUT:
				setCheckout((Checkout)newValue);
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
			case LogPackage.NEW_CHECKOUT_ADDED__CHECKOUT:
				setCheckout((Checkout)null);
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
			case LogPackage.NEW_CHECKOUT_ADDED__CHECKOUT:
				return eVirtualGet(LogPackage.NEW_CHECKOUT_ADDED__CHECKOUT) != null;
		}
		return super.eIsSet(featureID);
	}

} //NewCheckoutAddedImpl
