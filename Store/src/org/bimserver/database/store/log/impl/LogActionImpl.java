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
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return (Date) eGet(LogPackage.Literals.LOG_ACTION__DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		eSet(LogPackage.Literals.LOG_ACTION__DATE, newDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getExecutor() {
		return (User) eGet(LogPackage.Literals.LOG_ACTION__EXECUTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutor(User newExecutor) {
		eSet(LogPackage.Literals.LOG_ACTION__EXECUTOR, newExecutor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessMethod getAccessMethod() {
		return (AccessMethod) eGet(LogPackage.Literals.LOG_ACTION__ACCESS_METHOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessMethod(AccessMethod newAccessMethod) {
		eSet(LogPackage.Literals.LOG_ACTION__ACCESS_METHOD, newAccessMethod);
	}

} //LogActionImpl
