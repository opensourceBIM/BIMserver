/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.log;

import org.bimserver.database.store.Revision;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Download</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.database.store.log.Download#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.database.store.log.Download#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.database.store.log.Download#isZipped <em>Zipped</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.database.store.log.LogPackage#getDownload()
 * @model
 * @generated
 */
public interface Download extends LogAction {
	/**
	 * Returns the value of the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision</em>' reference.
	 * @see #setRevision(Revision)
	 * @see org.bimserver.database.store.log.LogPackage#getDownload_Revision()
	 * @model
	 * @generated
	 */
	Revision getRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.log.Download#getRevision <em>Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision</em>' reference.
	 * @see #getRevision()
	 * @generated
	 */
	void setRevision(Revision value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.bimserver.database.store.log.LogPackage#getDownload_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.log.Download#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Zipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zipped</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zipped</em>' attribute.
	 * @see #setZipped(boolean)
	 * @see org.bimserver.database.store.log.LogPackage#getDownload_Zipped()
	 * @model
	 * @generated
	 */
	boolean isZipped();

	/**
	 * Sets the value of the '{@link org.bimserver.database.store.log.Download#isZipped <em>Zipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zipped</em>' attribute.
	 * @see #isZipped()
	 * @generated
	 */
	void setZipped(boolean value);

} // Download
