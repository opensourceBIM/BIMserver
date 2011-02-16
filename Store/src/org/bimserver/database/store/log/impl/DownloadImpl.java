/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.log.impl;

import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.Download;
import org.bimserver.database.store.log.LogPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Download</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.log.impl.DownloadImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.database.store.log.impl.DownloadImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.database.store.log.impl.DownloadImpl#isZipped <em>Zipped</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DownloadImpl extends LogActionImpl implements Download {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DownloadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.DOWNLOAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getRevision() {
		return (Revision) eGet(LogPackage.Literals.DOWNLOAD__REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(Revision newRevision) {
		eSet(LogPackage.Literals.DOWNLOAD__REVISION, newRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return (String) eGet(LogPackage.Literals.DOWNLOAD__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		eSet(LogPackage.Literals.DOWNLOAD__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isZipped() {
		return (Boolean) eGet(LogPackage.Literals.DOWNLOAD__ZIPPED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZipped(boolean newZipped) {
		eSet(LogPackage.Literals.DOWNLOAD__ZIPPED, newZipped);
	}

} //DownloadImpl
