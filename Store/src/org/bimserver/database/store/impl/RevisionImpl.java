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
import org.eclipse.emf.ecore.util.BasicInternalEList;
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
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getBmi <em>Bmi</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.RevisionImpl#getNrClashes <em>Nr Clashes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RevisionImpl extends IdEObjectImpl implements Revision {
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
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

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
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final CheckinState STATE_EDEFAULT = CheckinState.UPLOADING;

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
	 * The default value of the '{@link #getLastError() <em>Last Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastError()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_ERROR_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getBmi() <em>Bmi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBmi()
	 * @generated
	 * @ordered
	 */
	protected static final int BMI_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBmi() <em>Bmi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBmi()
	 * @generated
	 * @ordered
	 */
	protected int bmi = BMI_EDEFAULT;

	/**
	 * The default value of the '{@link #getNrClashes() <em>Nr Clashes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNrClashes()
	 * @generated
	 * @ordered
	 */
	protected static final int NR_CLASHES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNrClashes() <em>Nr Clashes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNrClashes()
	 * @generated
	 * @ordered
	 */
	protected int nrClashes = NR_CLASHES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RevisionImpl() {
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
		id = newId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getUser() {
		User user = (User)eVirtualGet(StorePackage.REVISION__USER);
		if (user != null && ((EObject)user).eIsProxy()) {
			InternalEObject oldUser = (InternalEObject)user;
			user = (User)eResolveProxy(oldUser);
			if (user != oldUser) {
				eVirtualSet(StorePackage.REVISION__USER, user);
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
		return (User)eVirtualGet(StorePackage.REVISION__USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		User user = newUser;
		Object oldUser = eVirtualSet(StorePackage.REVISION__USER, user);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return (Date)eVirtualGet(StorePackage.REVISION__DATE, DATE_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date date = newDate;
		Object oldDate = eVirtualSet(StorePackage.REVISION__DATE, date);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return (String)eVirtualGet(StorePackage.REVISION__COMMENT, COMMENT_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String comment = newComment;
		Object oldComment = eVirtualSet(StorePackage.REVISION__COMMENT, comment);
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
		size = newSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConcreteRevision> getConcreteRevisions() {
		EList<ConcreteRevision> concreteRevisions = (EList<ConcreteRevision>)eVirtualGet(StorePackage.REVISION__CONCRETE_REVISIONS);
		if (concreteRevisions == null) {
			eVirtualSet(StorePackage.REVISION__CONCRETE_REVISIONS, concreteRevisions = new BasicInternalEList<ConcreteRevision>(ConcreteRevision.class));
		}
		return concreteRevisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteRevision getLastConcreteRevision() {
		ConcreteRevision lastConcreteRevision = (ConcreteRevision)eVirtualGet(StorePackage.REVISION__LAST_CONCRETE_REVISION);
		if (lastConcreteRevision != null && ((EObject)lastConcreteRevision).eIsProxy()) {
			InternalEObject oldLastConcreteRevision = (InternalEObject)lastConcreteRevision;
			lastConcreteRevision = (ConcreteRevision)eResolveProxy(oldLastConcreteRevision);
			if (lastConcreteRevision != oldLastConcreteRevision) {
				eVirtualSet(StorePackage.REVISION__LAST_CONCRETE_REVISION, lastConcreteRevision);
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
		return (ConcreteRevision)eVirtualGet(StorePackage.REVISION__LAST_CONCRETE_REVISION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastConcreteRevision(ConcreteRevision newLastConcreteRevision) {
		ConcreteRevision lastConcreteRevision = newLastConcreteRevision;
		Object oldLastConcreteRevision = eVirtualSet(StorePackage.REVISION__LAST_CONCRETE_REVISION, lastConcreteRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Checkout> getCheckouts() {
		EList<Checkout> checkouts = (EList<Checkout>)eVirtualGet(StorePackage.REVISION__CHECKOUTS);
		if (checkouts == null) {
			eVirtualSet(StorePackage.REVISION__CHECKOUTS, checkouts = new BasicInternalEList<Checkout>(Checkout.class));
		}
		return checkouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		Project project = (Project)eVirtualGet(StorePackage.REVISION__PROJECT);
		if (project != null && ((EObject)project).eIsProxy()) {
			InternalEObject oldProject = (InternalEObject)project;
			project = (Project)eResolveProxy(oldProject);
			if (project != oldProject) {
				eVirtualSet(StorePackage.REVISION__PROJECT, project);
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
		return (Project)eVirtualGet(StorePackage.REVISION__PROJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProject(Project newProject, NotificationChain msgs) {
		Object oldProject = eVirtualSet(StorePackage.REVISION__PROJECT, newProject);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		Project project = (Project)eVirtualGet(StorePackage.REVISION__PROJECT);
		if (newProject != project) {
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject)project).eInverseRemove(this, StorePackage.PROJECT__REVISIONS, Project.class, msgs);
			if (newProject != null)
				msgs = ((InternalEObject)newProject).eInverseAdd(this, StorePackage.PROJECT__REVISIONS, Project.class, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckinState getState() {
		return (CheckinState)eVirtualGet(StorePackage.REVISION__STATE, STATE_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(CheckinState newState) {
		CheckinState state = newState == null ? STATE_EDEFAULT : newState;
		Object oldState = eVirtualSet(StorePackage.REVISION__STATE, state);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Clash> getLastClashes() {
		EList<Clash> lastClashes = (EList<Clash>)eVirtualGet(StorePackage.REVISION__LAST_CLASHES);
		if (lastClashes == null) {
			eVirtualSet(StorePackage.REVISION__LAST_CLASHES, lastClashes = new BasicInternalEList<Clash>(Clash.class));
		}
		return lastClashes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTag() {
		return (String)eVirtualGet(StorePackage.REVISION__TAG, TAG_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTag(String newTag) {
		String tag = newTag;
		Object oldTag = eVirtualSet(StorePackage.REVISION__TAG, tag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastError() {
		return (String)eVirtualGet(StorePackage.REVISION__LAST_ERROR, LAST_ERROR_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastError(String newLastError) {
		String lastError = newLastError;
		Object oldLastError = eVirtualSet(StorePackage.REVISION__LAST_ERROR, lastError);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBmi() {
		return bmi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBmi(int newBmi) {
		bmi = newBmi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNrClashes() {
		return nrClashes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNrClashes(int newNrClashes) {
		nrClashes = newNrClashes;
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
				Project project = (Project)eVirtualGet(StorePackage.REVISION__PROJECT);
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
			case StorePackage.REVISION__BMI:
				return getBmi();
			case StorePackage.REVISION__NR_CLASHES:
				return getNrClashes();
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
			case StorePackage.REVISION__BMI:
				setBmi((Integer)newValue);
				return;
			case StorePackage.REVISION__NR_CLASHES:
				setNrClashes((Integer)newValue);
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
			case StorePackage.REVISION__BMI:
				setBmi(BMI_EDEFAULT);
				return;
			case StorePackage.REVISION__NR_CLASHES:
				setNrClashes(NR_CLASHES_EDEFAULT);
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
			case StorePackage.REVISION__ID:
				return id != ID_EDEFAULT;
			case StorePackage.REVISION__USER:
				return eVirtualGet(StorePackage.REVISION__USER) != null;
			case StorePackage.REVISION__DATE:
				Date date = (Date)eVirtualGet(StorePackage.REVISION__DATE, DATE_EDEFAULT);
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case StorePackage.REVISION__COMMENT:
				String comment = (String)eVirtualGet(StorePackage.REVISION__COMMENT, COMMENT_EDEFAULT);
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case StorePackage.REVISION__SIZE:
				return size != SIZE_EDEFAULT;
			case StorePackage.REVISION__CONCRETE_REVISIONS:
				EList<ConcreteRevision> concreteRevisions = (EList<ConcreteRevision>)eVirtualGet(StorePackage.REVISION__CONCRETE_REVISIONS);
				return concreteRevisions != null && !concreteRevisions.isEmpty();
			case StorePackage.REVISION__LAST_CONCRETE_REVISION:
				return eVirtualGet(StorePackage.REVISION__LAST_CONCRETE_REVISION) != null;
			case StorePackage.REVISION__CHECKOUTS:
				EList<Checkout> checkouts = (EList<Checkout>)eVirtualGet(StorePackage.REVISION__CHECKOUTS);
				return checkouts != null && !checkouts.isEmpty();
			case StorePackage.REVISION__PROJECT:
				return eVirtualGet(StorePackage.REVISION__PROJECT) != null;
			case StorePackage.REVISION__STATE:
				return eVirtualGet(StorePackage.REVISION__STATE, STATE_EDEFAULT) != STATE_EDEFAULT;
			case StorePackage.REVISION__LAST_CLASHES:
				EList<Clash> lastClashes = (EList<Clash>)eVirtualGet(StorePackage.REVISION__LAST_CLASHES);
				return lastClashes != null && !lastClashes.isEmpty();
			case StorePackage.REVISION__TAG:
				String tag = (String)eVirtualGet(StorePackage.REVISION__TAG, TAG_EDEFAULT);
				return TAG_EDEFAULT == null ? tag != null : !TAG_EDEFAULT.equals(tag);
			case StorePackage.REVISION__LAST_ERROR:
				String lastError = (String)eVirtualGet(StorePackage.REVISION__LAST_ERROR, LAST_ERROR_EDEFAULT);
				return LAST_ERROR_EDEFAULT == null ? lastError != null : !LAST_ERROR_EDEFAULT.equals(lastError);
			case StorePackage.REVISION__BMI:
				return bmi != BMI_EDEFAULT;
			case StorePackage.REVISION__NR_CLASHES:
				return nrClashes != NR_CLASHES_EDEFAULT;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", date: ");
		result.append(eVirtualGet(StorePackage.REVISION__DATE, DATE_EDEFAULT));
		result.append(", comment: ");
		result.append(eVirtualGet(StorePackage.REVISION__COMMENT, COMMENT_EDEFAULT));
		result.append(", size: ");
		result.append(size);
		result.append(", state: ");
		result.append(eVirtualGet(StorePackage.REVISION__STATE, STATE_EDEFAULT));
		result.append(", tag: ");
		result.append(eVirtualGet(StorePackage.REVISION__TAG, TAG_EDEFAULT));
		result.append(", lastError: ");
		result.append(eVirtualGet(StorePackage.REVISION__LAST_ERROR, LAST_ERROR_EDEFAULT));
		result.append(", bmi: ");
		result.append(bmi);
		result.append(", nrClashes: ");
		result.append(nrClashes);
		result.append(')');
		return result.toString();
	}

} //RevisionImpl
