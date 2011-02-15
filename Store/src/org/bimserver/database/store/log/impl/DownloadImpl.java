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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isZipped() <em>Zipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isZipped()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ZIPPED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isZipped() <em>Zipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isZipped()
	 * @generated
	 * @ordered
	 */
	protected boolean zipped = ZIPPED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DownloadImpl() {
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
		Revision revision = (Revision)eVirtualGet(LogPackage.DOWNLOAD__REVISION);
		if (revision != null && ((EObject)revision).eIsProxy()) {
			InternalEObject oldRevision = (InternalEObject)revision;
			revision = (Revision)eResolveProxy(oldRevision);
			if (revision != oldRevision) {
				eVirtualSet(LogPackage.DOWNLOAD__REVISION, revision);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LogPackage.DOWNLOAD__REVISION, oldRevision, revision));
			}
		}
		return revision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision basicGetRevision() {
		return (Revision)eVirtualGet(LogPackage.DOWNLOAD__REVISION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(Revision newRevision) {
		Revision revision = newRevision;
		Object oldRevision = eVirtualSet(LogPackage.DOWNLOAD__REVISION, revision);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.DOWNLOAD__REVISION, oldRevision == EVIRTUAL_NO_VALUE ? null : oldRevision, revision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return (String)eVirtualGet(LogPackage.DOWNLOAD__TYPE, TYPE_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String type = newType;
		Object oldType = eVirtualSet(LogPackage.DOWNLOAD__TYPE, type);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.DOWNLOAD__TYPE, oldType == EVIRTUAL_NO_VALUE ? TYPE_EDEFAULT : oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isZipped() {
		return zipped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZipped(boolean newZipped) {
		boolean oldZipped = zipped;
		zipped = newZipped;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.DOWNLOAD__ZIPPED, oldZipped, zipped));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LogPackage.DOWNLOAD__REVISION:
				if (resolve) return getRevision();
				return basicGetRevision();
			case LogPackage.DOWNLOAD__TYPE:
				return getType();
			case LogPackage.DOWNLOAD__ZIPPED:
				return isZipped();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LogPackage.DOWNLOAD__REVISION:
				setRevision((Revision)newValue);
				return;
			case LogPackage.DOWNLOAD__TYPE:
				setType((String)newValue);
				return;
			case LogPackage.DOWNLOAD__ZIPPED:
				setZipped((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LogPackage.DOWNLOAD__REVISION:
				setRevision((Revision)null);
				return;
			case LogPackage.DOWNLOAD__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case LogPackage.DOWNLOAD__ZIPPED:
				setZipped(ZIPPED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LogPackage.DOWNLOAD__REVISION:
				return eVirtualGet(LogPackage.DOWNLOAD__REVISION) != null;
			case LogPackage.DOWNLOAD__TYPE:
				String type = (String)eVirtualGet(LogPackage.DOWNLOAD__TYPE, TYPE_EDEFAULT);
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case LogPackage.DOWNLOAD__ZIPPED:
				return zipped != ZIPPED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(eVirtualGet(LogPackage.DOWNLOAD__TYPE, TYPE_EDEFAULT));
		result.append(", zipped: ");
		result.append(zipped);
		result.append(')');
		return result.toString();
	}

} //DownloadImpl
