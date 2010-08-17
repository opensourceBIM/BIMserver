/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.impl;

import java.util.Collection;
import java.util.Date;

import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.ObjectState;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.emf.IdEObjectImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getHasRightsOn <em>Has Rights On</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getCreatedOn <em>Created On</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getCreatedBy <em>Created By</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getUserType <em>User Type</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getLastSeen <em>Last Seen</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends IdEObjectImpl implements User {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHasRightsOn() <em>Has Rights On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasRightsOn()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> hasRightsOn;

	/**
	 * The cached value of the '{@link #getRevisions() <em>Revisions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevisions()
	 * @generated
	 * @ordered
	 */
	protected EList<ConcreteRevision> revisions;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final ObjectState STATE_EDEFAULT = ObjectState.ACTIVE;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected ObjectState state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreatedOn() <em>Created On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedOn()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATED_ON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreatedOn() <em>Created On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedOn()
	 * @generated
	 * @ordered
	 */
	protected Date createdOn = CREATED_ON_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCreatedBy() <em>Created By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedBy()
	 * @generated
	 * @ordered
	 */
	protected User createdBy;

	/**
	 * The default value of the '{@link #getUserType() <em>User Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserType()
	 * @generated
	 * @ordered
	 */
	protected static final UserType USER_TYPE_EDEFAULT = UserType.ADMIN;

	/**
	 * The cached value of the '{@link #getUserType() <em>User Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserType()
	 * @generated
	 * @ordered
	 */
	protected UserType userType = USER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastSeen() <em>Last Seen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSeen()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_SEEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastSeen() <em>Last Seen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSeen()
	 * @generated
	 * @ordered
	 */
	protected Date lastSeen = LAST_SEEN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.USER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.USER__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Project> getHasRightsOn() {
		if (hasRightsOn == null) {
			hasRightsOn = new EObjectWithInverseResolvingEList.ManyInverse<Project>(Project.class, this, StorePackage.USER__HAS_RIGHTS_ON, StorePackage.PROJECT__HAS_AUTHORIZED_USERS);
		}
		return hasRightsOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteRevision> getRevisions() {
		if (revisions == null) {
			revisions = new EObjectResolvingEList<ConcreteRevision>(ConcreteRevision.class, this, StorePackage.USER__REVISIONS);
		}
		return revisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(ObjectState newState) {
		ObjectState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.USER__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedOn(Date newCreatedOn) {
		Date oldCreatedOn = createdOn;
		createdOn = newCreatedOn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.USER__CREATED_ON, oldCreatedOn, createdOn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getCreatedBy() {
		if (createdBy != null && ((EObject)createdBy).eIsProxy()) {
			InternalEObject oldCreatedBy = (InternalEObject)createdBy;
			createdBy = (User)eResolveProxy(oldCreatedBy);
			if (createdBy != oldCreatedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.USER__CREATED_BY, oldCreatedBy, createdBy));
			}
		}
		return createdBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetCreatedBy() {
		return createdBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedBy(User newCreatedBy) {
		User oldCreatedBy = createdBy;
		createdBy = newCreatedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.USER__CREATED_BY, oldCreatedBy, createdBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserType(UserType newUserType) {
		UserType oldUserType = userType;
		userType = newUserType == null ? USER_TYPE_EDEFAULT : newUserType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.USER__USER_TYPE, oldUserType, userType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.USER__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastSeen() {
		return lastSeen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSeen(Date newLastSeen) {
		Date oldLastSeen = lastSeen;
		lastSeen = newLastSeen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.USER__LAST_SEEN, oldLastSeen, lastSeen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StorePackage.USER__HAS_RIGHTS_ON:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHasRightsOn()).basicAdd(otherEnd, msgs);
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
			case StorePackage.USER__HAS_RIGHTS_ON:
				return ((InternalEList<?>)getHasRightsOn()).basicRemove(otherEnd, msgs);
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
			case StorePackage.USER__NAME:
				return getName();
			case StorePackage.USER__PASSWORD:
				return getPassword();
			case StorePackage.USER__HAS_RIGHTS_ON:
				return getHasRightsOn();
			case StorePackage.USER__REVISIONS:
				return getRevisions();
			case StorePackage.USER__STATE:
				return getState();
			case StorePackage.USER__CREATED_ON:
				return getCreatedOn();
			case StorePackage.USER__CREATED_BY:
				if (resolve) return getCreatedBy();
				return basicGetCreatedBy();
			case StorePackage.USER__USER_TYPE:
				return getUserType();
			case StorePackage.USER__USERNAME:
				return getUsername();
			case StorePackage.USER__LAST_SEEN:
				return getLastSeen();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StorePackage.USER__NAME:
				setName((String)newValue);
				return;
			case StorePackage.USER__PASSWORD:
				setPassword((String)newValue);
				return;
			case StorePackage.USER__HAS_RIGHTS_ON:
				getHasRightsOn().clear();
				getHasRightsOn().addAll((Collection<? extends Project>)newValue);
				return;
			case StorePackage.USER__REVISIONS:
				getRevisions().clear();
				getRevisions().addAll((Collection<? extends ConcreteRevision>)newValue);
				return;
			case StorePackage.USER__STATE:
				setState((ObjectState)newValue);
				return;
			case StorePackage.USER__CREATED_ON:
				setCreatedOn((Date)newValue);
				return;
			case StorePackage.USER__CREATED_BY:
				setCreatedBy((User)newValue);
				return;
			case StorePackage.USER__USER_TYPE:
				setUserType((UserType)newValue);
				return;
			case StorePackage.USER__USERNAME:
				setUsername((String)newValue);
				return;
			case StorePackage.USER__LAST_SEEN:
				setLastSeen((Date)newValue);
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
			case StorePackage.USER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StorePackage.USER__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case StorePackage.USER__HAS_RIGHTS_ON:
				getHasRightsOn().clear();
				return;
			case StorePackage.USER__REVISIONS:
				getRevisions().clear();
				return;
			case StorePackage.USER__STATE:
				setState(STATE_EDEFAULT);
				return;
			case StorePackage.USER__CREATED_ON:
				setCreatedOn(CREATED_ON_EDEFAULT);
				return;
			case StorePackage.USER__CREATED_BY:
				setCreatedBy((User)null);
				return;
			case StorePackage.USER__USER_TYPE:
				setUserType(USER_TYPE_EDEFAULT);
				return;
			case StorePackage.USER__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case StorePackage.USER__LAST_SEEN:
				setLastSeen(LAST_SEEN_EDEFAULT);
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
			case StorePackage.USER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StorePackage.USER__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case StorePackage.USER__HAS_RIGHTS_ON:
				return hasRightsOn != null && !hasRightsOn.isEmpty();
			case StorePackage.USER__REVISIONS:
				return revisions != null && !revisions.isEmpty();
			case StorePackage.USER__STATE:
				return state != STATE_EDEFAULT;
			case StorePackage.USER__CREATED_ON:
				return CREATED_ON_EDEFAULT == null ? createdOn != null : !CREATED_ON_EDEFAULT.equals(createdOn);
			case StorePackage.USER__CREATED_BY:
				return createdBy != null;
			case StorePackage.USER__USER_TYPE:
				return userType != USER_TYPE_EDEFAULT;
			case StorePackage.USER__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case StorePackage.USER__LAST_SEEN:
				return LAST_SEEN_EDEFAULT == null ? lastSeen != null : !LAST_SEEN_EDEFAULT.equals(lastSeen);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", password: ");
		result.append(password);
		result.append(", state: ");
		result.append(state);
		result.append(", createdOn: ");
		result.append(createdOn);
		result.append(", userType: ");
		result.append(userType);
		result.append(", username: ");
		result.append(username);
		result.append(", lastSeen: ");
		result.append(lastSeen);
		result.append(')');
		return result.toString();
	}

} //UserImpl
