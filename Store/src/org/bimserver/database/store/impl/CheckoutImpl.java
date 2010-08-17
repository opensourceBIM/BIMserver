/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.impl;

import java.util.Date;

import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.emf.IdEObjectImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Checkout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.impl.CheckoutImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.CheckoutImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.CheckoutImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.CheckoutImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.CheckoutImpl#getCheckin <em>Checkin</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.CheckoutImpl#isActive <em>Active</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckoutImpl extends IdEObjectImpl implements Checkout {
	/**
	 * The cached value of the '{@link #getUser() <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected User user;

	/**
	 * The cached value of the '{@link #getRevision() <em>Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision()
	 * @generated
	 * @ordered
	 */
	protected Revision revision;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected Project project;

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
	 * The cached value of the '{@link #getCheckin() <em>Checkin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckin()
	 * @generated
	 * @ordered
	 */
	protected Revision checkin;

	/**
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;

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
	public User getUser() {
		if (user != null && ((EObject)user).eIsProxy()) {
			InternalEObject oldUser = (InternalEObject)user;
			user = (User)eResolveProxy(oldUser);
			if (user != oldUser) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.CHECKOUT__USER, oldUser, user));
			}
		}
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetUser() {
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		User oldUser = user;
		user = newUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__USER, oldUser, user));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getRevision() {
		if (revision != null && ((EObject)revision).eIsProxy()) {
			InternalEObject oldRevision = (InternalEObject)revision;
			revision = (Revision)eResolveProxy(oldRevision);
			if (revision != oldRevision) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.CHECKOUT__REVISION, oldRevision, revision));
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
		return revision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRevision(Revision newRevision, NotificationChain msgs) {
		Revision oldRevision = revision;
		revision = newRevision;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__REVISION, oldRevision, newRevision);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(Revision newRevision) {
		if (newRevision != revision) {
			NotificationChain msgs = null;
			if (revision != null)
				msgs = ((InternalEObject)revision).eInverseRemove(this, StorePackage.REVISION__CHECKOUTS, Revision.class, msgs);
			if (newRevision != null)
				msgs = ((InternalEObject)newRevision).eInverseAdd(this, StorePackage.REVISION__CHECKOUTS, Revision.class, msgs);
			msgs = basicSetRevision(newRevision, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__REVISION, newRevision, newRevision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		if (project != null && ((EObject)project).eIsProxy()) {
			InternalEObject oldProject = (InternalEObject)project;
			project = (Project)eResolveProxy(oldProject);
			if (project != oldProject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.CHECKOUT__PROJECT, oldProject, project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project basicGetProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProject(Project newProject, NotificationChain msgs) {
		Project oldProject = project;
		project = newProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__PROJECT, oldProject, newProject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		if (newProject != project) {
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject)project).eInverseRemove(this, StorePackage.PROJECT__CHECKOUTS, Project.class, msgs);
			if (newProject != null)
				msgs = ((InternalEObject)newProject).eInverseAdd(this, StorePackage.PROJECT__CHECKOUTS, Project.class, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__PROJECT, newProject, newProject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getCheckin() {
		if (checkin != null && ((EObject)checkin).eIsProxy()) {
			InternalEObject oldCheckin = (InternalEObject)checkin;
			checkin = (Revision)eResolveProxy(oldCheckin);
			if (checkin != oldCheckin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.CHECKOUT__CHECKIN, oldCheckin, checkin));
			}
		}
		return checkin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision basicGetCheckin() {
		return checkin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckin(Revision newCheckin) {
		Revision oldCheckin = checkin;
		checkin = newCheckin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__CHECKIN, oldCheckin, checkin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StorePackage.CHECKOUT__REVISION:
				if (revision != null)
					msgs = ((InternalEObject)revision).eInverseRemove(this, StorePackage.REVISION__CHECKOUTS, Revision.class, msgs);
				return basicSetRevision((Revision)otherEnd, msgs);
			case StorePackage.CHECKOUT__PROJECT:
				if (project != null)
					msgs = ((InternalEObject)project).eInverseRemove(this, StorePackage.PROJECT__CHECKOUTS, Project.class, msgs);
				return basicSetProject((Project)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StorePackage.CHECKOUT__REVISION:
				return basicSetRevision(null, msgs);
			case StorePackage.CHECKOUT__PROJECT:
				return basicSetProject(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StorePackage.CHECKOUT__USER:
				if (resolve) return getUser();
				return basicGetUser();
			case StorePackage.CHECKOUT__REVISION:
				if (resolve) return getRevision();
				return basicGetRevision();
			case StorePackage.CHECKOUT__PROJECT:
				if (resolve) return getProject();
				return basicGetProject();
			case StorePackage.CHECKOUT__DATE:
				return getDate();
			case StorePackage.CHECKOUT__CHECKIN:
				if (resolve) return getCheckin();
				return basicGetCheckin();
			case StorePackage.CHECKOUT__ACTIVE:
				return isActive();
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
			case StorePackage.CHECKOUT__USER:
				setUser((User)newValue);
				return;
			case StorePackage.CHECKOUT__REVISION:
				setRevision((Revision)newValue);
				return;
			case StorePackage.CHECKOUT__PROJECT:
				setProject((Project)newValue);
				return;
			case StorePackage.CHECKOUT__DATE:
				setDate((Date)newValue);
				return;
			case StorePackage.CHECKOUT__CHECKIN:
				setCheckin((Revision)newValue);
				return;
			case StorePackage.CHECKOUT__ACTIVE:
				setActive((Boolean)newValue);
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
			case StorePackage.CHECKOUT__USER:
				setUser((User)null);
				return;
			case StorePackage.CHECKOUT__REVISION:
				setRevision((Revision)null);
				return;
			case StorePackage.CHECKOUT__PROJECT:
				setProject((Project)null);
				return;
			case StorePackage.CHECKOUT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case StorePackage.CHECKOUT__CHECKIN:
				setCheckin((Revision)null);
				return;
			case StorePackage.CHECKOUT__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
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
			case StorePackage.CHECKOUT__USER:
				return user != null;
			case StorePackage.CHECKOUT__REVISION:
				return revision != null;
			case StorePackage.CHECKOUT__PROJECT:
				return project != null;
			case StorePackage.CHECKOUT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case StorePackage.CHECKOUT__CHECKIN:
				return checkin != null;
			case StorePackage.CHECKOUT__ACTIVE:
				return active != ACTIVE_EDEFAULT;
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
		result.append(", active: ");
		result.append(active);
		result.append(')');
		return result.toString();
	}

} //CheckoutImpl
