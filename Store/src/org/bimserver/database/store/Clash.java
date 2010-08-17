/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clash</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.database.store.Clash#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.database.store.Clash#getGuid1 <em>Guid1</em>}</li>
 *   <li>{@link org.bimserver.database.store.Clash#getGuid2 <em>Guid2</em>}</li>
 *   <li>{@link org.bimserver.database.store.Clash#getName1 <em>Name1</em>}</li>
 *   <li>{@link org.bimserver.database.store.Clash#getName2 <em>Name2</em>}</li>
 *   <li>{@link org.bimserver.database.store.Clash#getType1 <em>Type1</em>}</li>
 *   <li>{@link org.bimserver.database.store.Clash#getType2 <em>Type2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.database.store.StorePackage#getClash()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Clash extends IdEObject {
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
	 * @see org.bimserver.database.store.StorePackage#getClash_Guid1()
	 * @model
	 * @generated
	 */
	String getGuid1();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Clash#getGuid1 <em>Guid1</em>}' attribute.
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
	 * @see org.bimserver.database.store.StorePackage#getClash_Guid2()
	 * @model
	 * @generated
	 */
	String getGuid2();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Clash#getGuid2 <em>Guid2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guid2</em>' attribute.
	 * @see #getGuid2()
	 * @generated
	 */
	void setGuid2(String value);

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
	 * @see org.bimserver.database.store.StorePackage#getClash_Name1()
	 * @model
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Clash#getName1 <em>Name1</em>}' attribute.
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
	 * @see org.bimserver.database.store.StorePackage#getClash_Name2()
	 * @model
	 * @generated
	 */
	String getName2();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Clash#getName2 <em>Name2</em>}' attribute.
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
	 * @see org.bimserver.database.store.StorePackage#getClash_Type1()
	 * @model
	 * @generated
	 */
	String getType1();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Clash#getType1 <em>Type1</em>}' attribute.
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
	 * @see org.bimserver.database.store.StorePackage#getClash_Type2()
	 * @model
	 * @generated
	 */
	String getType2();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Clash#getType2 <em>Type2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type2</em>' attribute.
	 * @see #getType2()
	 * @generated
	 */
	void setType2(String value);

	/**
	 * Returns the value of the '<em><b>Revision</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.database.store.Revision#getLastClashes <em>Last Clashes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision</em>' reference.
	 * @see #setRevision(Revision)
	 * @see org.bimserver.database.store.StorePackage#getClash_Revision()
	 * @see org.bimserver.database.store.Revision#getLastClashes
	 * @model opposite="lastClashes"
	 * @generated
	 */
	Revision getRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.Clash#getRevision <em>Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision</em>' reference.
	 * @see #getRevision()
	 * @generated
	 */
	void setRevision(Revision value);

} // Clash
