/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;

import java.util.Date;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getNumberOfProjects <em>Number Of Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getNumberOfUsers <em>Number Of Users</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getNumberOfRevisions <em>Number Of Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getNumberOfCheckouts <em>Number Of Checkouts</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getDatabaseSizeInBytes <em>Database Size In Bytes</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getCreated <em>Created</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getGenericLines <em>Generic Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface DatabaseInformation extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Number Of Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Projects</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Projects</em>' attribute.
	 * @see #setNumberOfProjects(int)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_NumberOfProjects()
	 * @model
	 * @generated
	 */
	int getNumberOfProjects();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfProjects <em>Number Of Projects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Projects</em>' attribute.
	 * @see #getNumberOfProjects()
	 * @generated
	 */
	void setNumberOfProjects(int value);

	/**
	 * Returns the value of the '<em><b>Number Of Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Users</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Users</em>' attribute.
	 * @see #setNumberOfUsers(int)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_NumberOfUsers()
	 * @model
	 * @generated
	 */
	int getNumberOfUsers();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfUsers <em>Number Of Users</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Users</em>' attribute.
	 * @see #getNumberOfUsers()
	 * @generated
	 */
	void setNumberOfUsers(int value);

	/**
	 * Returns the value of the '<em><b>Number Of Revisions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Revisions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Revisions</em>' attribute.
	 * @see #setNumberOfRevisions(int)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_NumberOfRevisions()
	 * @model
	 * @generated
	 */
	int getNumberOfRevisions();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfRevisions <em>Number Of Revisions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Revisions</em>' attribute.
	 * @see #getNumberOfRevisions()
	 * @generated
	 */
	void setNumberOfRevisions(int value);

	/**
	 * Returns the value of the '<em><b>Number Of Checkouts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Checkouts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Checkouts</em>' attribute.
	 * @see #setNumberOfCheckouts(int)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_NumberOfCheckouts()
	 * @model
	 * @generated
	 */
	int getNumberOfCheckouts();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfCheckouts <em>Number Of Checkouts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Checkouts</em>' attribute.
	 * @see #getNumberOfCheckouts()
	 * @generated
	 */
	void setNumberOfCheckouts(int value);

	/**
	 * Returns the value of the '<em><b>Database Size In Bytes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database Size In Bytes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database Size In Bytes</em>' attribute.
	 * @see #setDatabaseSizeInBytes(long)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_DatabaseSizeInBytes()
	 * @model
	 * @generated
	 */
	long getDatabaseSizeInBytes();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getDatabaseSizeInBytes <em>Database Size In Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database Size In Bytes</em>' attribute.
	 * @see #getDatabaseSizeInBytes()
	 * @generated
	 */
	void setDatabaseSizeInBytes(long value);

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
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(Date)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_Created()
	 * @model
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Schema Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Version</em>' attribute.
	 * @see #setSchemaVersion(int)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_SchemaVersion()
	 * @model
	 * @generated
	 */
	int getSchemaVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getSchemaVersion <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema Version</em>' attribute.
	 * @see #getSchemaVersion()
	 * @generated
	 */
	void setSchemaVersion(int value);

	/**
	 * Returns the value of the '<em><b>Generic Lines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generic Lines</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generic Lines</em>' attribute.
	 * @see #setGenericLines(String)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_GenericLines()
	 * @model
	 * @generated
	 */
	String getGenericLines();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getGenericLines <em>Generic Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generic Lines</em>' attribute.
	 * @see #getGenericLines()
	 * @generated
	 */
	void setGenericLines(String value);

} // DatabaseInformation
