/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.log.impl;

import org.bimserver.models.log.LogPackage;
import org.bimserver.models.log.NewCheckoutAdded;
import org.bimserver.models.store.Checkout;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Checkout Added</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.log.impl.NewCheckoutAddedImpl#getCheckout <em>Checkout</em>}</li>
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
	protected NewCheckoutAddedImpl() {
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
		return (Checkout)eGet(LogPackage.Literals.NEW_CHECKOUT_ADDED__CHECKOUT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckout(Checkout newCheckout) {
		eSet(LogPackage.Literals.NEW_CHECKOUT_ADDED__CHECKOUT, newCheckout);
	}

} //NewCheckoutAddedImpl
