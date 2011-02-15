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
	 * An array of objects representing the values of non-primitive features.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Object[] eVirtualValues;

	/**
	 * A bit field representing the indices of non-primitive feature values.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int eVirtualIndexBits0;

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
	 * The default value of the '{@link #getAccessMethod() <em>Access Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessMethod()
	 * @generated
	 * @ordered
	 */
	protected static final AccessMethod ACCESS_METHOD_EDEFAULT = AccessMethod.SOAP;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogActionImpl() {
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
		return (Date)eVirtualGet(LogPackage.LOG_ACTION__DATE, DATE_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date date = newDate;
		Object oldDate = eVirtualSet(LogPackage.LOG_ACTION__DATE, date);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ACTION__DATE, oldDate == EVIRTUAL_NO_VALUE ? DATE_EDEFAULT : oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getExecutor() {
		User executor = (User)eVirtualGet(LogPackage.LOG_ACTION__EXECUTOR);
		if (executor != null && ((EObject)executor).eIsProxy()) {
			InternalEObject oldExecutor = (InternalEObject)executor;
			executor = (User)eResolveProxy(oldExecutor);
			if (executor != oldExecutor) {
				eVirtualSet(LogPackage.LOG_ACTION__EXECUTOR, executor);
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
		return (User)eVirtualGet(LogPackage.LOG_ACTION__EXECUTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutor(User newExecutor) {
		User executor = newExecutor;
		Object oldExecutor = eVirtualSet(LogPackage.LOG_ACTION__EXECUTOR, executor);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ACTION__EXECUTOR, oldExecutor == EVIRTUAL_NO_VALUE ? null : oldExecutor, executor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessMethod getAccessMethod() {
		return (AccessMethod)eVirtualGet(LogPackage.LOG_ACTION__ACCESS_METHOD, ACCESS_METHOD_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessMethod(AccessMethod newAccessMethod) {
		AccessMethod accessMethod = newAccessMethod == null ? ACCESS_METHOD_EDEFAULT : newAccessMethod;
		Object oldAccessMethod = eVirtualSet(LogPackage.LOG_ACTION__ACCESS_METHOD, accessMethod);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_ACTION__ACCESS_METHOD, oldAccessMethod == EVIRTUAL_NO_VALUE ? ACCESS_METHOD_EDEFAULT : oldAccessMethod, accessMethod));
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
				Date date = (Date)eVirtualGet(LogPackage.LOG_ACTION__DATE, DATE_EDEFAULT);
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case LogPackage.LOG_ACTION__EXECUTOR:
				return eVirtualGet(LogPackage.LOG_ACTION__EXECUTOR) != null;
			case LogPackage.LOG_ACTION__ACCESS_METHOD:
				return eVirtualGet(LogPackage.LOG_ACTION__ACCESS_METHOD, ACCESS_METHOD_EDEFAULT) != ACCESS_METHOD_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Object[] eVirtualValues() {
		return eVirtualValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void eSetVirtualValues(Object[] newValues) {
		eVirtualValues = newValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eVirtualIndexBits(int offset) {
		switch (offset) {
			case 0 :
				return eVirtualIndexBits0;
			default :
				throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void eSetVirtualIndexBits(int offset, int newIndexBits) {
		switch (offset) {
			case 0 :
				eVirtualIndexBits0 = newIndexBits;
				break;
			default :
				throw new IndexOutOfBoundsException();
		}
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
		result.append(eVirtualGet(LogPackage.LOG_ACTION__DATE, DATE_EDEFAULT));
		result.append(", accessMethod: ");
		result.append(eVirtualGet(LogPackage.LOG_ACTION__ACCESS_METHOD, ACCESS_METHOD_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //LogActionImpl
