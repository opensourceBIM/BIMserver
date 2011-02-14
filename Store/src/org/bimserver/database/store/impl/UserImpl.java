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
import org.eclipse.emf.ecore.util.BasicInternalEList;
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
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getValidationToken <em>Validation Token</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.UserImpl#getValidationTokenCreated <em>Validation Token Created</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends IdEObjectImpl implements User {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final ObjectState STATE_EDEFAULT = ObjectState.ACTIVE;

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
	 * The default value of the '{@link #getUserType() <em>User Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserType()
	 * @generated
	 * @ordered
	 */
	protected static final UserType USER_TYPE_EDEFAULT = UserType.ADMIN;

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
	 * The default value of the '{@link #getLastSeen() <em>Last Seen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSeen()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_SEEN_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getValidationToken() <em>Validation Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationToken()
	 * @generated
	 * @ordered
	 */
	protected static final String VALIDATION_TOKEN_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getValidationTokenCreated() <em>Validation Token Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationTokenCreated()
	 * @generated
	 * @ordered
	 */
	protected static final Date VALIDATION_TOKEN_CREATED_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserImpl() {
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
		return (String)eVirtualGet(StorePackage.USER__NAME, NAME_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String name = newName;
		Object oldName = eVirtualSet(StorePackage.USER__NAME, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return (String)eVirtualGet(StorePackage.USER__PASSWORD, PASSWORD_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String password = newPassword;
		Object oldPassword = eVirtualSet(StorePackage.USER__PASSWORD, password);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Project> getHasRightsOn() {
		EList<Project> hasRightsOn = (EList<Project>)eVirtualGet(StorePackage.USER__HAS_RIGHTS_ON);
		if (hasRightsOn == null) {
			eVirtualSet(StorePackage.USER__HAS_RIGHTS_ON, hasRightsOn = new BasicInternalEList<Project>(Project.class));
		}
		return hasRightsOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConcreteRevision> getRevisions() {
		EList<ConcreteRevision> revisions = (EList<ConcreteRevision>)eVirtualGet(StorePackage.USER__REVISIONS);
		if (revisions == null) {
			eVirtualSet(StorePackage.USER__REVISIONS, revisions = new BasicInternalEList<ConcreteRevision>(ConcreteRevision.class));
		}
		return revisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectState getState() {
		return (ObjectState)eVirtualGet(StorePackage.USER__STATE, STATE_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(ObjectState newState) {
		ObjectState state = newState == null ? STATE_EDEFAULT : newState;
		Object oldState = eVirtualSet(StorePackage.USER__STATE, state);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreatedOn() {
		return (Date)eVirtualGet(StorePackage.USER__CREATED_ON, CREATED_ON_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedOn(Date newCreatedOn) {
		Date createdOn = newCreatedOn;
		Object oldCreatedOn = eVirtualSet(StorePackage.USER__CREATED_ON, createdOn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getCreatedBy() {
		User createdBy = (User)eVirtualGet(StorePackage.USER__CREATED_BY);
		if (createdBy != null && ((EObject)createdBy).eIsProxy()) {
			InternalEObject oldCreatedBy = (InternalEObject)createdBy;
			createdBy = (User)eResolveProxy(oldCreatedBy);
			if (createdBy != oldCreatedBy) {
				eVirtualSet(StorePackage.USER__CREATED_BY, createdBy);
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
		return (User)eVirtualGet(StorePackage.USER__CREATED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedBy(User newCreatedBy) {
		User createdBy = newCreatedBy;
		Object oldCreatedBy = eVirtualSet(StorePackage.USER__CREATED_BY, createdBy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserType getUserType() {
		return (UserType)eVirtualGet(StorePackage.USER__USER_TYPE, USER_TYPE_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserType(UserType newUserType) {
		UserType userType = newUserType == null ? USER_TYPE_EDEFAULT : newUserType;
		Object oldUserType = eVirtualSet(StorePackage.USER__USER_TYPE, userType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return (String)eVirtualGet(StorePackage.USER__USERNAME, USERNAME_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String username = newUsername;
		Object oldUsername = eVirtualSet(StorePackage.USER__USERNAME, username);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastSeen() {
		return (Date)eVirtualGet(StorePackage.USER__LAST_SEEN, LAST_SEEN_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSeen(Date newLastSeen) {
		Date lastSeen = newLastSeen;
		Object oldLastSeen = eVirtualSet(StorePackage.USER__LAST_SEEN, lastSeen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValidationToken() {
		return (String)eVirtualGet(StorePackage.USER__VALIDATION_TOKEN, VALIDATION_TOKEN_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidationToken(String newValidationToken) {
		String validationToken = newValidationToken;
		Object oldValidationToken = eVirtualSet(StorePackage.USER__VALIDATION_TOKEN, validationToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getValidationTokenCreated() {
		return (Date)eVirtualGet(StorePackage.USER__VALIDATION_TOKEN_CREATED, VALIDATION_TOKEN_CREATED_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidationTokenCreated(Date newValidationTokenCreated) {
		Date validationTokenCreated = newValidationTokenCreated;
		Object oldValidationTokenCreated = eVirtualSet(StorePackage.USER__VALIDATION_TOKEN_CREATED, validationTokenCreated);
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
			case StorePackage.USER__VALIDATION_TOKEN:
				return getValidationToken();
			case StorePackage.USER__VALIDATION_TOKEN_CREATED:
				return getValidationTokenCreated();
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
			case StorePackage.USER__VALIDATION_TOKEN:
				setValidationToken((String)newValue);
				return;
			case StorePackage.USER__VALIDATION_TOKEN_CREATED:
				setValidationTokenCreated((Date)newValue);
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
			case StorePackage.USER__VALIDATION_TOKEN:
				setValidationToken(VALIDATION_TOKEN_EDEFAULT);
				return;
			case StorePackage.USER__VALIDATION_TOKEN_CREATED:
				setValidationTokenCreated(VALIDATION_TOKEN_CREATED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StorePackage.USER__NAME:
				String name = (String)eVirtualGet(StorePackage.USER__NAME, NAME_EDEFAULT);
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StorePackage.USER__PASSWORD:
				String password = (String)eVirtualGet(StorePackage.USER__PASSWORD, PASSWORD_EDEFAULT);
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case StorePackage.USER__HAS_RIGHTS_ON:
				EList<Project> hasRightsOn = (EList<Project>)eVirtualGet(StorePackage.USER__HAS_RIGHTS_ON);
				return hasRightsOn != null && !hasRightsOn.isEmpty();
			case StorePackage.USER__REVISIONS:
				EList<ConcreteRevision> revisions = (EList<ConcreteRevision>)eVirtualGet(StorePackage.USER__REVISIONS);
				return revisions != null && !revisions.isEmpty();
			case StorePackage.USER__STATE:
				return eVirtualGet(StorePackage.USER__STATE, STATE_EDEFAULT) != STATE_EDEFAULT;
			case StorePackage.USER__CREATED_ON:
				Date createdOn = (Date)eVirtualGet(StorePackage.USER__CREATED_ON, CREATED_ON_EDEFAULT);
				return CREATED_ON_EDEFAULT == null ? createdOn != null : !CREATED_ON_EDEFAULT.equals(createdOn);
			case StorePackage.USER__CREATED_BY:
				return eVirtualGet(StorePackage.USER__CREATED_BY) != null;
			case StorePackage.USER__USER_TYPE:
				return eVirtualGet(StorePackage.USER__USER_TYPE, USER_TYPE_EDEFAULT) != USER_TYPE_EDEFAULT;
			case StorePackage.USER__USERNAME:
				String username = (String)eVirtualGet(StorePackage.USER__USERNAME, USERNAME_EDEFAULT);
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case StorePackage.USER__LAST_SEEN:
				Date lastSeen = (Date)eVirtualGet(StorePackage.USER__LAST_SEEN, LAST_SEEN_EDEFAULT);
				return LAST_SEEN_EDEFAULT == null ? lastSeen != null : !LAST_SEEN_EDEFAULT.equals(lastSeen);
			case StorePackage.USER__VALIDATION_TOKEN:
				String validationToken = (String)eVirtualGet(StorePackage.USER__VALIDATION_TOKEN, VALIDATION_TOKEN_EDEFAULT);
				return VALIDATION_TOKEN_EDEFAULT == null ? validationToken != null : !VALIDATION_TOKEN_EDEFAULT.equals(validationToken);
			case StorePackage.USER__VALIDATION_TOKEN_CREATED:
				Date validationTokenCreated = (Date)eVirtualGet(StorePackage.USER__VALIDATION_TOKEN_CREATED, VALIDATION_TOKEN_CREATED_EDEFAULT);
				return VALIDATION_TOKEN_CREATED_EDEFAULT == null ? validationTokenCreated != null : !VALIDATION_TOKEN_CREATED_EDEFAULT.equals(validationTokenCreated);
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
		result.append(" (name: ");
		result.append(eVirtualGet(StorePackage.USER__NAME, NAME_EDEFAULT));
		result.append(", password: ");
		result.append(eVirtualGet(StorePackage.USER__PASSWORD, PASSWORD_EDEFAULT));
		result.append(", state: ");
		result.append(eVirtualGet(StorePackage.USER__STATE, STATE_EDEFAULT));
		result.append(", createdOn: ");
		result.append(eVirtualGet(StorePackage.USER__CREATED_ON, CREATED_ON_EDEFAULT));
		result.append(", userType: ");
		result.append(eVirtualGet(StorePackage.USER__USER_TYPE, USER_TYPE_EDEFAULT));
		result.append(", username: ");
		result.append(eVirtualGet(StorePackage.USER__USERNAME, USERNAME_EDEFAULT));
		result.append(", lastSeen: ");
		result.append(eVirtualGet(StorePackage.USER__LAST_SEEN, LAST_SEEN_EDEFAULT));
		result.append(", validationToken: ");
		result.append(eVirtualGet(StorePackage.USER__VALIDATION_TOKEN, VALIDATION_TOKEN_EDEFAULT));
		result.append(", validationTokenCreated: ");
		result.append(eVirtualGet(StorePackage.USER__VALIDATION_TOKEN_CREATED, VALIDATION_TOKEN_CREATED_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //UserImpl
