/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;

import javax.activation.DataHandler;

import org.bimserver.emf.IdEObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Download Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.DownloadResult#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.DownloadResult#getRevisionNr <em>Revision Nr</em>}</li>
 *   <li>{@link org.bimserver.models.store.DownloadResult#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getDownloadResult()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface DownloadResult extends IdEObject {

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.bimserver.models.store.StorePackage#getDownloadResult_ProjectName()
	 * @model
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DownloadResult#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Revision Nr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision Nr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision Nr</em>' attribute.
	 * @see #setRevisionNr(int)
	 * @see org.bimserver.models.store.StorePackage#getDownloadResult_RevisionNr()
	 * @model
	 * @generated
	 */
	int getRevisionNr();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DownloadResult#getRevisionNr <em>Revision Nr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision Nr</em>' attribute.
	 * @see #getRevisionNr()
	 * @generated
	 */
	void setRevisionNr(int value);

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(DataHandler)
	 * @see org.bimserver.models.store.StorePackage#getDownloadResult_File()
	 * @model dataType="org.bimserver.models.store.DataHandler"
	 * @generated
	 */
	DataHandler getFile();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DownloadResult#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(DataHandler value);
} // DownloadResult
