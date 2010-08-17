/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.log.impl;

import java.util.Date;

import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogAction;
import org.bimserver.database.store.log.LogPackage;
import org.bimserver.emf.IdEObjectImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.log.impl.LogActionImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.database.store.log.impl.LogActionImpl#getExecutor <em>Executor</em>}</li>
 *   <li>{@link org.bimserver.database.store.log.impl.LogActionImpl#getAccessMethod <em>Access Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogActionImpl extends IdEObjectImpl implements LogAction {
	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExecutor() <em>Executor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutor()
	 * @generated
	 * @ordered
	 */
	protected User executor;

	/**
	 * The default value of the '{@link #getAccessMethod() <em>Access Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessMethod()
	 * @generated
	 * @ordered
	 */
	protected static final AccessMethod ACCESS_METHOD_EDEFAULT = AccessMethod.SOAP;

	/**
	 * The cached value of the '{@link #getAccessMethod() <em>Access Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessMethod()
	 * @generated
	 * @ordered
	 */
	protected AccessMethod accessMethod = ACCESS_METHOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.LOG_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ACTION__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getExecutor() {
		if (executor != null && ((EObject)executor).eIsProxy()) {
			InternalEObject oldExecutor = (InternalEObject)executor;
			executor = (User)eResolveProxy(oldExecutor);
			if (executor != oldExecutor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LogPackage.LOG_ACTION__EXECUTOR, oldExecutor, executor));
			}
		}
		return executor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetExecutor() {
		return executor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutor(User newExecutor) {
		User oldExecutor = executor;
		executor = newExecutor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ACTION__EXECUTOR, oldExecutor, executor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessMethod getAccessMethod() {
		return accessMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessMethod(AccessMethod newAccessMethod) {
		AccessMethod oldAccessMethod = accessMethod;
		accessMethod = newAccessMethod == null ? ACCESS_METHOD_EDEFAULT : newAccessMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ACTION__ACCESS_METHOD, oldAccessMethod, accessMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LogPackage.LOG_ACTION__DATE:
				return getDate();
			case LogPackage.LOG_ACTION__EXECUTOR:
				if (resolve) return getExecutor();
				return basicGetExecutor();
			case LogPackage.LOG_ACTION__ACCESS_METHOD:
				return getAccessMethod();
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
			case LogPackage.LOG_ACTION__DATE:
				setDate((Date)newValue);
				return;
			case LogPackage.LOG_ACTION__EXECUTOR:
				setExecutor((User)newValue);
				return;
			case LogPackage.LOG_ACTION__ACCESS_METHOD:
				setAccessMethod((AccessMethod)newValue);
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
			case LogPackage.LOG_ACTION__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case LogPackage.LOG_ACTION__EXECUTOR:
				setExecutor((User)null);
				return;
			case LogPackage.LOG_ACTION__ACCESS_METHOD:
				setAccessMethod(ACCESS_METHOD_EDEFAULT);
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
			case LogPackage.LOG_ACTION__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case LogPackage.LOG_ACTION__EXECUTOR:
				return executor != null;
			case LogPackage.LOG_ACTION__ACCESS_METHOD:
				return accessMethod != ACCESS_METHOD_EDEFAULT;
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
		result.append(" (date: ");
		result.append(date);
		result.append(", accessMethod: ");
		result.append(accessMethod);
		result.append(')');
		return result.toString();
	}

} //LogActionImpl
