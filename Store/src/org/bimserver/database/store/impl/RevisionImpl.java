/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.impl;

import java.util.Collection;
import java.util.Date;

import org.bimserver.database.store.CheckinState;
import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.Clash;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
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
 * An implementation of the model object '<em><b>Revision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getConcreteRevisions <em>Concrete Revisions</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getLastConcreteRevision <em>Last Concrete Revision</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getCheckouts <em>Checkouts</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getLastClashes <em>Last Clashes</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getLastError <em>Last Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RevisionImpl extends IdEObjectImpl implements Revision {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final long SIZE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected long size = SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConcreteRevisions() <em>Concrete Revisions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcreteRevisions()
	 * @generated
	 * @ordered
	 */
	protected EList<ConcreteRevision> concreteRevisions;

	/**
	 * The cached value of the '{@link #getLastConcreteRevision() <em>Last Concrete Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastConcreteRevision()
	 * @generated
	 * @ordered
	 */
	protected ConcreteRevision lastConcreteRevision;

	/**
	 * The cached value of the '{@link #getCheckouts() <em>Checkouts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckouts()
	 * @generated
	 * @ordered
	 */
	protected EList<Checkout> checkouts;

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
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final CheckinState STATE_EDEFAULT = CheckinState.UPLOADING;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected CheckinState state = STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLastClashes() <em>Last Clashes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastClashes()
	 * @generated
	 * @ordered
	 */
	protected EList<Clash> lastClashes;

	/**
	 * The default value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected static final String TAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected String tag = TAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastError() <em>Last Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastError()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_ERROR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastError() <em>Last Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastError()
	 * @generated
	 * @ordered
	 */
	protected String lastError = LAST_ERROR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RevisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.REVISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.REVISION__ID, oldId, id));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.REVISION__USER, oldUser, user));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.REVISION__USER, oldUser, user));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.REVISION__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.REVISION__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(long newSize) {
		long oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.REVISION__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteRevision> getConcreteRevisions() {
		if (concreteRevisions == null) {
			concreteRevisions = new EObjectWithInverseResolvingEList.ManyInverse<ConcreteRevision>(ConcreteRevision.class, this, StorePackage.REVISION__CONCRETE_REVISIONS, StorePackage.CONCRETE_REVISION__REVISIONS);
		}
		return concreteRevisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteRevision getLastConcreteRevision() {
		if (lastConcreteRevision != null && ((EObject)lastConcreteRevision).eIsProxy()) {
			InternalEObject oldLastConcreteRevision = (InternalEObject)lastConcreteRevision;
			lastConcreteRevision = (ConcreteRevision)eResolveProxy(oldLastConcreteRevision);
			if (lastConcreteRevision != oldLastConcreteRevision) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.REVISION__LAST_CONCRETE_REVISION, oldLastConcreteRevision, lastConcreteRevision));
			}
		}
		return lastConcreteRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteRevision basicGetLastConcreteRevision() {
		return lastConcreteRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastConcreteRevision(ConcreteRevision newLastConcreteRevision) {
		ConcreteRevision oldLastConcreteRevision = lastConcreteRevision;
		lastConcreteRevision = newLastConcreteRevision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.REVISION__LAST_CONCRETE_REVISION, oldLastConcreteRevision, lastConcreteRevision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Checkout> getCheckouts() {
		if (checkouts == null) {
			checkouts = new EObjectWithInverseResolvingEList<Checkout>(Checkout.class, this, StorePackage.REVISION__CHECKOUTS, StorePackage.CHECKOUT__REVISION);
		}
		return checkouts;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.REVISION__PROJECT, oldProject, project));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StorePackage.REVISION__PROJECT, oldProject, newProject);
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
				msgs = ((InternalEObject)project).eInverseRemove(this, StorePackage.PROJECT__REVISIONS, Project.class, msgs);
			if (newProject != null)
				msgs = ((InternalEObject)newProject).eInverseAdd(this, StorePackage.PROJECT__REVISIONS, Project.class, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.REVISION__PROJECT, newProject, newProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckinState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(CheckinState newState) {
		CheckinState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.REVISION__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Clash> getLastClashes() {
		if (lastClashes == null) {
			lastClashes = new EObjectResolvingEList<Clash>(Clash.class, this, StorePackage.REVISION__LAST_CLASHES);
		}
		return lastClashes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTag(String newTag) {
		String oldTag = tag;
		tag = newTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.REVISION__TAG, oldTag, tag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastError() {
		return lastError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastError(String newLastError) {
		String oldLastError = lastError;
		lastError = newLastError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.REVISION__LAST_ERROR, oldLastError, lastError));
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
			case StorePackage.REVISION__CONCRETE_REVISIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConcreteRevisions()).basicAdd(otherEnd, msgs);
			case StorePackage.REVISION__CHECKOUTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCheckouts()).basicAdd(otherEnd, msgs);
			case StorePackage.REVISION__PROJECT:
				if (project != null)
					msgs = ((InternalEObject)project).eInverseRemove(this, StorePackage.PROJECT__REVISIONS, Project.class, msgs);
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
			case StorePackage.REVISION__CONCRETE_REVISIONS:
				return ((InternalEList<?>)getConcreteRevisions()).basicRemove(otherEnd, msgs);
			case StorePackage.REVISION__CHECKOUTS:
				return ((InternalEList<?>)getCheckouts()).basicRemove(otherEnd, msgs);
			case StorePackage.REVISION__PROJECT:
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
			case StorePackage.REVISION__ID:
				return getId();
			case StorePackage.REVISION__USER:
				if (resolve) return getUser();
				return basicGetUser();
			case StorePackage.REVISION__DATE:
				return getDate();
			case StorePackage.REVISION__COMMENT:
				return getComment();
			case StorePackage.REVISION__SIZE:
				return getSize();
			case StorePackage.REVISION__CONCRETE_REVISIONS:
				return getConcreteRevisions();
			case StorePackage.REVISION__LAST_CONCRETE_REVISION:
				if (resolve) return getLastConcreteRevision();
				return basicGetLastConcreteRevision();
			case StorePackage.REVISION__CHECKOUTS:
				return getCheckouts();
			case StorePackage.REVISION__PROJECT:
				if (resolve) return getProject();
				return basicGetProject();
			case StorePackage.REVISION__STATE:
				return getState();
			case StorePackage.REVISION__LAST_CLASHES:
				return getLastClashes();
			case StorePackage.REVISION__TAG:
				return getTag();
			case StorePackage.REVISION__LAST_ERROR:
				return getLastError();
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
			case StorePackage.REVISION__ID:
				setId((Integer)newValue);
				return;
			case StorePackage.REVISION__USER:
				setUser((User)newValue);
				return;
			case StorePackage.REVISION__DATE:
				setDate((Date)newValue);
				return;
			case StorePackage.REVISION__COMMENT:
				setComment((String)newValue);
				return;
			case StorePackage.REVISION__SIZE:
				setSize((Long)newValue);
				return;
			case StorePackage.REVISION__CONCRETE_REVISIONS:
				getConcreteRevisions().clear();
				getConcreteRevisions().addAll((Collection<? extends ConcreteRevision>)newValue);
				return;
			case StorePackage.REVISION__LAST_CONCRETE_REVISION:
				setLastConcreteRevision((ConcreteRevision)newValue);
				return;
			case StorePackage.REVISION__CHECKOUTS:
				getCheckouts().clear();
				getCheckouts().addAll((Collection<? extends Checkout>)newValue);
				return;
			case StorePackage.REVISION__PROJECT:
				setProject((Project)newValue);
				return;
			case StorePackage.REVISION__STATE:
				setState((CheckinState)newValue);
				return;
			case StorePackage.REVISION__LAST_CLASHES:
				getLastClashes().clear();
				getLastClashes().addAll((Collection<? extends Clash>)newValue);
				return;
			case StorePackage.REVISION__TAG:
				setTag((String)newValue);
				return;
			case StorePackage.REVISION__LAST_ERROR:
				setLastError((String)newValue);
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
			case StorePackage.REVISION__ID:
				setId(ID_EDEFAULT);
				return;
			case StorePackage.REVISION__USER:
				setUser((User)null);
				return;
			case StorePackage.REVISION__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case StorePackage.REVISION__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case StorePackage.REVISION__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case StorePackage.REVISION__CONCRETE_REVISIONS:
				getConcreteRevisions().clear();
				return;
			case StorePackage.REVISION__LAST_CONCRETE_REVISION:
				setLastConcreteRevision((ConcreteRevision)null);
				return;
			case StorePackage.REVISION__CHECKOUTS:
				getCheckouts().clear();
				return;
			case StorePackage.REVISION__PROJECT:
				setProject((Project)null);
				return;
			case StorePackage.REVISION__STATE:
				setState(STATE_EDEFAULT);
				return;
			case StorePackage.REVISION__LAST_CLASHES:
				getLastClashes().clear();
				return;
			case StorePackage.REVISION__TAG:
				setTag(TAG_EDEFAULT);
				return;
			case StorePackage.REVISION__LAST_ERROR:
				setLastError(LAST_ERROR_EDEFAULT);
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
			case StorePackage.REVISION__ID:
				return id != ID_EDEFAULT;
			case StorePackage.REVISION__USER:
				return user != null;
			case StorePackage.REVISION__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case StorePackage.REVISION__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case StorePackage.REVISION__SIZE:
				return size != SIZE_EDEFAULT;
			case StorePackage.REVISION__CONCRETE_REVISIONS:
				return concreteRevisions != null && !concreteRevisions.isEmpty();
			case StorePackage.REVISION__LAST_CONCRETE_REVISION:
				return lastConcreteRevision != null;
			case StorePackage.REVISION__CHECKOUTS:
				return checkouts != null && !checkouts.isEmpty();
			case StorePackage.REVISION__PROJECT:
				return project != null;
			case StorePackage.REVISION__STATE:
				return state != STATE_EDEFAULT;
			case StorePackage.REVISION__LAST_CLASHES:
				return lastClashes != null && !lastClashes.isEmpty();
			case StorePackage.REVISION__TAG:
				return TAG_EDEFAULT == null ? tag != null : !TAG_EDEFAULT.equals(tag);
			case StorePackage.REVISION__LAST_ERROR:
				return LAST_ERROR_EDEFAULT == null ? lastError != null : !LAST_ERROR_EDEFAULT.equals(lastError);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", date: ");
		result.append(date);
		result.append(", comment: ");
		result.append(comment);
		result.append(", size: ");
		result.append(size);
		result.append(", state: ");
		result.append(state);
		result.append(", tag: ");
		result.append(tag);
		result.append(", lastError: ");
		result.append(lastError);
		result.append(')');
		return result.toString();
	}

} //RevisionImpl
