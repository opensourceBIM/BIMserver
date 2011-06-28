/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;

import java.util.Date;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Revision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getChecksum <em>Checksum</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getSize <em>Size</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getLastError <em>Last Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getConcreteRevision()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface ConcreteRevision extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Project#getConcreteRevisions <em>Concrete Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Project()
	 * @see org.bimserver.models.store.Project#getConcreteRevisions
	 * @model opposite="concreteRevisions"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.CheckinState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.CheckinState
	 * @see #setState(CheckinState)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_State()
	 * @model
	 * @generated
	 */
	CheckinState getState();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.CheckinState
	 * @see #getState()
	 * @generated
	 */
	void setState(CheckinState value);

	/**
	 * Returns the value of the '<em><b>Checksum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checksum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checksum</em>' attribute.
	 * @see #setChecksum(byte[])
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Checksum()
	 * @model
	 * @generated
	 */
	byte[] getChecksum();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getChecksum <em>Checksum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checksum</em>' attribute.
	 * @see #getChecksum()
	 * @generated
	 */
	void setChecksum(byte[] value);

	/**
	 * Returns the value of the '<em><b>Revisions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Revision}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Revision#getConcreteRevisions <em>Concrete Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revisions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revisions</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Revisions()
	 * @see org.bimserver.models.store.Revision#getConcreteRevisions
	 * @model opposite="concreteRevisions"
	 * @generated
	 */
	EList<Revision> getRevisions();

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(long)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Size()
	 * @model
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Last Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Error</em>' attribute.
	 * @see #setLastError(String)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_LastError()
	 * @model
	 * @generated
	 */
	String getLastError();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getLastError <em>Last Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Error</em>' attribute.
	 * @see #getLastError()
	 * @generated
	 */
	void setLastError(String value);

} // ConcreteRevision
