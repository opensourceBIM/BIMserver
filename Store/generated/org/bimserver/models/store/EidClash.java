/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eid Clash</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.EidClash#getEid1 <em>Eid1</em>}</li>
 *   <li>{@link org.bimserver.models.store.EidClash#getEid2 <em>Eid2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getEidClash()
 * @model
 * @generated
 */
public interface EidClash extends Clash {
	/**
	 * Returns the value of the '<em><b>Eid1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eid1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eid1</em>' attribute.
	 * @see #setEid1(long)
	 * @see org.bimserver.models.store.StorePackage#getEidClash_Eid1()
	 * @model
	 * @generated
	 */
	long getEid1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.EidClash#getEid1 <em>Eid1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eid1</em>' attribute.
	 * @see #getEid1()
	 * @generated
	 */
	void setEid1(long value);

	/**
	 * Returns the value of the '<em><b>Eid2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eid2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eid2</em>' attribute.
	 * @see #setEid2(long)
	 * @see org.bimserver.models.store.StorePackage#getEidClash_Eid2()
	 * @model
	 * @generated
	 */
	long getEid2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.EidClash#getEid2 <em>Eid2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eid2</em>' attribute.
	 * @see #getEid2()
	 * @generated
	 */
	void setEid2(long value);

} // EidClash
