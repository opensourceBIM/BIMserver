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
 * A representation of the model object '<em><b>Checkin Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.CheckinResult#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.CheckinResult#getRid <em>Rid</em>}</li>
 *   <li>{@link org.bimserver.models.store.CheckinResult#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getCheckinResult()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface CheckinResult extends IdEObject {
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
	 * @see org.bimserver.models.store.StorePackage#getCheckinResult_Revision()
	 * @model
	 * @generated
	 */
	Revision getRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.CheckinResult#getRevision <em>Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision</em>' reference.
	 * @see #getRevision()
	 * @generated
	 */
	void setRevision(Revision value);

	/**
	 * Returns the value of the '<em><b>Rid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rid</em>' attribute.
	 * @see #setRid(int)
	 * @see org.bimserver.models.store.StorePackage#getCheckinResult_Rid()
	 * @model
	 * @generated
	 */
	int getRid();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.CheckinResult#getRid <em>Rid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rid</em>' attribute.
	 * @see #getRid()
	 * @generated
	 */
	void setRid(int value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see org.bimserver.models.store.StorePackage#getCheckinResult_Project()
	 * @model
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.CheckinResult#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

} // CheckinResult
