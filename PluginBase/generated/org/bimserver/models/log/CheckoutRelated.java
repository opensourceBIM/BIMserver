/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.log;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.store.Checkout;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Checkout Related</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.log.CheckoutRelated#getCheckout <em>Checkout</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.log.LogPackage#getCheckoutRelated()
 * @model
 * @generated
 */
public interface CheckoutRelated extends LogAction {
	/**
	 * Returns the value of the '<em><b>Checkout</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Checkout#getLogs <em>Logs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkout</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkout</em>' reference.
	 * @see #setCheckout(Checkout)
	 * @see org.bimserver.models.log.LogPackage#getCheckoutRelated_Checkout()
	 * @see org.bimserver.models.store.Checkout#getLogs
	 * @model opposite="logs"
	 * @generated
	 */
	Checkout getCheckout();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.CheckoutRelated#getCheckout <em>Checkout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkout</em>' reference.
	 * @see #getCheckout()
	 * @generated
	 */
	void setCheckout(Checkout value);

} // CheckoutRelated
