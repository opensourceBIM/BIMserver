/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guid Clash</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.GuidClash#getGuid1 <em>Guid1</em>}</li>
 *   <li>{@link org.bimserver.models.store.GuidClash#getGuid2 <em>Guid2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getGuidClash()
 * @model
 * @generated
 */
public interface GuidClash extends Clash {
	/**
	 * Returns the value of the '<em><b>Guid1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guid1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guid1</em>' attribute.
	 * @see #setGuid1(String)
	 * @see org.bimserver.models.store.StorePackage#getGuidClash_Guid1()
	 * @model
	 * @generated
	 */
	String getGuid1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GuidClash#getGuid1 <em>Guid1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guid1</em>' attribute.
	 * @see #getGuid1()
	 * @generated
	 */
	void setGuid1(String value);

	/**
	 * Returns the value of the '<em><b>Guid2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guid2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guid2</em>' attribute.
	 * @see #setGuid2(String)
	 * @see org.bimserver.models.store.StorePackage#getGuidClash_Guid2()
	 * @model
	 * @generated
	 */
	String getGuid2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GuidClash#getGuid2 <em>Guid2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guid2</em>' attribute.
	 * @see #getGuid2()
	 * @generated
	 */
	void setGuid2(String value);

} // GuidClash
