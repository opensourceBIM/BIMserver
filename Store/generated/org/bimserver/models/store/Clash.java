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
 * A representation of the model object '<em><b>Clash</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.Clash#getName1 <em>Name1</em>}</li>
 *   <li>{@link org.bimserver.models.store.Clash#getName2 <em>Name2</em>}</li>
 *   <li>{@link org.bimserver.models.store.Clash#getType1 <em>Type1</em>}</li>
 *   <li>{@link org.bimserver.models.store.Clash#getType2 <em>Type2</em>}</li>
 *   <li>{@link org.bimserver.models.store.Clash#getRevision1 <em>Revision1</em>}</li>
 *   <li>{@link org.bimserver.models.store.Clash#getRevision2 <em>Revision2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getClash()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Clash extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name1</em>' attribute.
	 * @see #setName1(String)
	 * @see org.bimserver.models.store.StorePackage#getClash_Name1()
	 * @model
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

	/**
	 * Returns the value of the '<em><b>Name2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name2</em>' attribute.
	 * @see #setName2(String)
	 * @see org.bimserver.models.store.StorePackage#getClash_Name2()
	 * @model
	 * @generated
	 */
	String getName2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getName2 <em>Name2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name2</em>' attribute.
	 * @see #getName2()
	 * @generated
	 */
	void setName2(String value);

	/**
	 * Returns the value of the '<em><b>Type1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type1</em>' attribute.
	 * @see #setType1(String)
	 * @see org.bimserver.models.store.StorePackage#getClash_Type1()
	 * @model
	 * @generated
	 */
	String getType1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getType1 <em>Type1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type1</em>' attribute.
	 * @see #getType1()
	 * @generated
	 */
	void setType1(String value);

	/**
	 * Returns the value of the '<em><b>Type2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type2</em>' attribute.
	 * @see #setType2(String)
	 * @see org.bimserver.models.store.StorePackage#getClash_Type2()
	 * @model
	 * @generated
	 */
	String getType2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getType2 <em>Type2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type2</em>' attribute.
	 * @see #getType2()
	 * @generated
	 */
	void setType2(String value);

	/**
	 * Returns the value of the '<em><b>Revision1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision1</em>' reference.
	 * @see #setRevision1(Revision)
	 * @see org.bimserver.models.store.StorePackage#getClash_Revision1()
	 * @model
	 * @generated
	 */
	Revision getRevision1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getRevision1 <em>Revision1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision1</em>' reference.
	 * @see #getRevision1()
	 * @generated
	 */
	void setRevision1(Revision value);

	/**
	 * Returns the value of the '<em><b>Revision2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision2</em>' reference.
	 * @see #setRevision2(Revision)
	 * @see org.bimserver.models.store.StorePackage#getClash_Revision2()
	 * @model
	 * @generated
	 */
	Revision getRevision2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Clash#getRevision2 <em>Revision2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision2</em>' reference.
	 * @see #getRevision2()
	 * @generated
	 */
	void setRevision2(Revision value);

} // Clash
