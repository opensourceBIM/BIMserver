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
	public CheckoutImpl() {
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
		User user = (User)eVirtualGet(StorePackage.CHECKOUT__USER);
		if (user != null && ((EObject)user).eIsProxy()) {
			InternalEObject oldUser = (InternalEObject)user;
			user = (User)eResolveProxy(oldUser);
			if (user != oldUser) {
				eVirtualSet(StorePackage.CHECKOUT__USER, user);
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
		return (User)eVirtualGet(StorePackage.CHECKOUT__USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		User user = newUser;
		Object oldUser = eVirtualSet(StorePackage.CHECKOUT__USER, user);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__USER, oldUser == EVIRTUAL_NO_VALUE ? null : oldUser, user));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getRevision() {
		Revision revision = (Revision)eVirtualGet(StorePackage.CHECKOUT__REVISION);
		if (revision != null && ((EObject)revision).eIsProxy()) {
			InternalEObject oldRevision = (InternalEObject)revision;
			revision = (Revision)eResolveProxy(oldRevision);
			if (revision != oldRevision) {
				eVirtualSet(StorePackage.CHECKOUT__REVISION, revision);
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
		return (Revision)eVirtualGet(StorePackage.CHECKOUT__REVISION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRevision(Revision newRevision, NotificationChain msgs) {
		Object oldRevision = eVirtualSet(StorePackage.CHECKOUT__REVISION, newRevision);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__REVISION, oldRevision == EVIRTUAL_NO_VALUE ? null : oldRevision, newRevision);
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
		Revision revision = (Revision)eVirtualGet(StorePackage.CHECKOUT__REVISION);
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
		Project project = (Project)eVirtualGet(StorePackage.CHECKOUT__PROJECT);
		if (project != null && ((EObject)project).eIsProxy()) {
			InternalEObject oldProject = (InternalEObject)project;
			project = (Project)eResolveProxy(oldProject);
			if (project != oldProject) {
				eVirtualSet(StorePackage.CHECKOUT__PROJECT, project);
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
		return (Project)eVirtualGet(StorePackage.CHECKOUT__PROJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProject(Project newProject, NotificationChain msgs) {
		Object oldProject = eVirtualSet(StorePackage.CHECKOUT__PROJECT, newProject);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__PROJECT, oldProject == EVIRTUAL_NO_VALUE ? null : oldProject, newProject);
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
		Project project = (Project)eVirtualGet(StorePackage.CHECKOUT__PROJECT);
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
		return (Date)eVirtualGet(StorePackage.CHECKOUT__DATE, DATE_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date date = newDate;
		Object oldDate = eVirtualSet(StorePackage.CHECKOUT__DATE, date);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__DATE, oldDate == EVIRTUAL_NO_VALUE ? DATE_EDEFAULT : oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getCheckin() {
		Revision checkin = (Revision)eVirtualGet(StorePackage.CHECKOUT__CHECKIN);
		if (checkin != null && ((EObject)checkin).eIsProxy()) {
			InternalEObject oldCheckin = (InternalEObject)checkin;
			checkin = (Revision)eResolveProxy(oldCheckin);
			if (checkin != oldCheckin) {
				eVirtualSet(StorePackage.CHECKOUT__CHECKIN, checkin);
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
		return (Revision)eVirtualGet(StorePackage.CHECKOUT__CHECKIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckin(Revision newCheckin) {
		Revision checkin = newCheckin;
		Object oldCheckin = eVirtualSet(StorePackage.CHECKOUT__CHECKIN, checkin);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CHECKOUT__CHECKIN, oldCheckin == EVIRTUAL_NO_VALUE ? null : oldCheckin, checkin));
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
				Revision revision = (Revision)eVirtualGet(StorePackage.CHECKOUT__REVISION);
				if (revision != null)
					msgs = ((InternalEObject)revision).eInverseRemove(this, StorePackage.REVISION__CHECKOUTS, Revision.class, msgs);
				return basicSetRevision((Revision)otherEnd, msgs);
			case StorePackage.CHECKOUT__PROJECT:
				Project project = (Project)eVirtualGet(StorePackage.CHECKOUT__PROJECT);
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
				return eVirtualGet(StorePackage.CHECKOUT__USER) != null;
			case StorePackage.CHECKOUT__REVISION:
				return eVirtualGet(StorePackage.CHECKOUT__REVISION) != null;
			case StorePackage.CHECKOUT__PROJECT:
				return eVirtualGet(StorePackage.CHECKOUT__PROJECT) != null;
			case StorePackage.CHECKOUT__DATE:
				Date date = (Date)eVirtualGet(StorePackage.CHECKOUT__DATE, DATE_EDEFAULT);
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case StorePackage.CHECKOUT__CHECKIN:
				return eVirtualGet(StorePackage.CHECKOUT__CHECKIN) != null;
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
		result.append(eVirtualGet(StorePackage.CHECKOUT__DATE, DATE_EDEFAULT));
		result.append(", active: ");
		result.append(active);
		result.append(')');
		return result.toString();
	}

} //CheckoutImpl
