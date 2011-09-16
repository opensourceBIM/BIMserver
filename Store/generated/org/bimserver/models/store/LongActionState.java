/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Long Action State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.LongActionState#getProgress <em>Progress</em>}</li>
 *   <li>{@link org.bimserver.models.store.LongActionState#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getLongActionState()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface LongActionState extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Progress</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Progress</em>' attribute.
	 * @see #setProgress(int)
	 * @see org.bimserver.models.store.StorePackage#getLongActionState_Progress()
	 * @model
	 * @generated
	 */
	int getProgress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.LongActionState#getProgress <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Progress</em>' attribute.
	 * @see #getProgress()
	 * @generated
	 */
	void setProgress(int value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.ActionState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.ActionState
	 * @see #setState(ActionState)
	 * @see org.bimserver.models.store.StorePackage#getLongActionState_State()
	 * @model
	 * @generated
	 */
	ActionState getState();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.LongActionState#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.ActionState
	 * @see #getState()
	 * @generated
	 */
	void setState(ActionState value);

} // LongActionState
