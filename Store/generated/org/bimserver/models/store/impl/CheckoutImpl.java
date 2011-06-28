/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import java.util.Date;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Checkout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.CheckoutImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.CheckoutImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.CheckoutImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.CheckoutImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.CheckoutImpl#getCheckin <em>Checkin</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.CheckoutImpl#isActive <em>Active</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckoutImpl extends IdEObjectImpl implements Checkout {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CheckoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.CHECKOUT;
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
	public User getUser() {
		return (User)eGet(StorePackage.Literals.CHECKOUT__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		eSet(StorePackage.Literals.CHECKOUT__USER, newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getRevision() {
		return (Revision)eGet(StorePackage.Literals.CHECKOUT__REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(Revision newRevision) {
		eSet(StorePackage.Literals.CHECKOUT__REVISION, newRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		return (Project)eGet(StorePackage.Literals.CHECKOUT__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		eSet(StorePackage.Literals.CHECKOUT__PROJECT, newProject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return (Date)eGet(StorePackage.Literals.CHECKOUT__DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		eSet(StorePackage.Literals.CHECKOUT__DATE, newDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getCheckin() {
		return (Revision)eGet(StorePackage.Literals.CHECKOUT__CHECKIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckin(Revision newCheckin) {
		eSet(StorePackage.Literals.CHECKOUT__CHECKIN, newCheckin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return (Boolean)eGet(StorePackage.Literals.CHECKOUT__ACTIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		eSet(StorePackage.Literals.CHECKOUT__ACTIVE, newActive);
	}

} //CheckoutImpl
