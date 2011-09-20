/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import org.bimserver.models.store.NewRevisionNotification;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Revision Notification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.NewRevisionNotificationImpl#getRevision <em>Revision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewRevisionNotificationImpl extends NotificationImpl implements NewRevisionNotification {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewRevisionNotificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.NEW_REVISION_NOTIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getRevision() {
		return (Revision)eGet(StorePackage.Literals.NEW_REVISION_NOTIFICATION__REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(Revision newRevision) {
		eSet(StorePackage.Literals.NEW_REVISION_NOTIFICATION__REVISION, newRevision);
	}

} //NewRevisionNotificationImpl
