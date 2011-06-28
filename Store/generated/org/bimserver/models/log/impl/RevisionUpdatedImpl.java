/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.log.impl;

import org.bimserver.models.log.LogPackage;
import org.bimserver.models.log.RevisionUpdated;
import org.bimserver.models.store.Revision;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Revision Updated</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.log.impl.RevisionUpdatedImpl#getRevision <em>Revision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RevisionUpdatedImpl extends LogActionImpl implements RevisionUpdated {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RevisionUpdatedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.REVISION_UPDATED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getRevision() {
		return (Revision)eGet(LogPackage.Literals.REVISION_UPDATED__REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(Revision newRevision) {
		eSet(LogPackage.Literals.REVISION_UPDATED__REVISION, newRevision);
	}

} //RevisionUpdatedImpl
