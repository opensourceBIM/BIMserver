/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.log;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server Log</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.log.ServerLog#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.log.LogPackage#getServerLog()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface ServerLog extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.log.LogAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' reference list.
	 * @see org.bimserver.models.log.LogPackage#getServerLog_Actions()
	 * @model
	 * @generated
	 */
	EList<LogAction> getActions();

} // ServerLog
