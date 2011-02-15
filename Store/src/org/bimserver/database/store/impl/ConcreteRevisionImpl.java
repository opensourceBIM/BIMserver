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
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.StorePackage;
import org.bimserver.emf.IdEObjectImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Revision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.impl.ConcreteRevisionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ConcreteRevisionImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ConcreteRevisionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ConcreteRevisionImpl#getChecksum <em>Checksum</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ConcreteRevisionImpl#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ConcreteRevisionImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ConcreteRevisionImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ConcreteRevisionImpl#getLastError <em>Last Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteRevisionImpl extends IdEObjectImpl implements ConcreteRevision {
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
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final CheckinState STATE_EDEFAULT = CheckinState.UPLOADING;

	/**
	 * The default value of the '{@link #getChecksum() <em>Checksum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChecksum()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] CHECKSUM_EDEFAULT = null;

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
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteRevisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.CONCRETE_REVISION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CONCRETE_REVISION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		Project project = (Project)eVirtualGet(StorePackage.CONCRETE_REVISION__PROJECT);
		if (project != null && ((EObject)project).eIsProxy()) {
			InternalEObject oldProject = (InternalEObject)project;
			project = (Project)eResolveProxy(oldProject);
			if (project != oldProject) {
				eVirtualSet(StorePackage.CONCRETE_REVISION__PROJECT, project);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.CONCRETE_REVISION__PROJECT, oldProject, project));
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
		return (Project)eVirtualGet(StorePackage.CONCRETE_REVISION__PROJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProject(Project newProject, NotificationChain msgs) {
		Object oldProject = eVirtualSet(StorePackage.CONCRETE_REVISION__PROJECT, newProject);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StorePackage.CONCRETE_REVISION__PROJECT, oldProject == EVIRTUAL_NO_VALUE ? null : oldProject, newProject);
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
		Project project = (Project)eVirtualGet(StorePackage.CONCRETE_REVISION__PROJECT);
		if (newProject != project) {
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject)project).eInverseRemove(this, StorePackage.PROJECT__CONCRETE_REVISIONS, Project.class, msgs);
			if (newProject != null)
				msgs = ((InternalEObject)newProject).eInverseAdd(this, StorePackage.PROJECT__CONCRETE_REVISIONS, Project.class, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CONCRETE_REVISION__PROJECT, newProject, newProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckinState getState() {
		return (CheckinState)eVirtualGet(StorePackage.CONCRETE_REVISION__STATE, STATE_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(CheckinState newState) {
		CheckinState state = newState == null ? STATE_EDEFAULT : newState;
		Object oldState = eVirtualSet(StorePackage.CONCRETE_REVISION__STATE, state);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CONCRETE_REVISION__STATE, oldState == EVIRTUAL_NO_VALUE ? STATE_EDEFAULT : oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getChecksum() {
		return (byte[])eVirtualGet(StorePackage.CONCRETE_REVISION__CHECKSUM, CHECKSUM_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChecksum(byte[] newChecksum) {
		byte[] checksum = newChecksum;
		Object oldChecksum = eVirtualSet(StorePackage.CONCRETE_REVISION__CHECKSUM, checksum);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CONCRETE_REVISION__CHECKSUM, oldChecksum == EVIRTUAL_NO_VALUE ? CHECKSUM_EDEFAULT : oldChecksum, checksum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Revision> getRevisions() {
		EList<Revision> revisions = (EList<Revision>)eVirtualGet(StorePackage.CONCRETE_REVISION__REVISIONS);
		if (revisions == null) {
			eVirtualSet(StorePackage.CONCRETE_REVISION__REVISIONS, revisions = new EObjectWithInverseResolvingEList.ManyInverse<Revision>(Revision.class, this, StorePackage.CONCRETE_REVISION__REVISIONS, StorePackage.REVISION__CONCRETE_REVISIONS));
		}
		return revisions;
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
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CONCRETE_REVISION__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return (Date)eVirtualGet(StorePackage.CONCRETE_REVISION__DATE, DATE_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date date = newDate;
		Object oldDate = eVirtualSet(StorePackage.CONCRETE_REVISION__DATE, date);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CONCRETE_REVISION__DATE, oldDate == EVIRTUAL_NO_VALUE ? DATE_EDEFAULT : oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastError() {
		return (String)eVirtualGet(StorePackage.CONCRETE_REVISION__LAST_ERROR, LAST_ERROR_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastError(String newLastError) {
		String lastError = newLastError;
		Object oldLastError = eVirtualSet(StorePackage.CONCRETE_REVISION__LAST_ERROR, lastError);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CONCRETE_REVISION__LAST_ERROR, oldLastError == EVIRTUAL_NO_VALUE ? LAST_ERROR_EDEFAULT : oldLastError, lastError));
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
			case StorePackage.CONCRETE_REVISION__PROJECT:
				Project project = (Project)eVirtualGet(StorePackage.CONCRETE_REVISION__PROJECT);
				if (project != null)
					msgs = ((InternalEObject)project).eInverseRemove(this, StorePackage.PROJECT__CONCRETE_REVISIONS, Project.class, msgs);
				return basicSetProject((Project)otherEnd, msgs);
			case StorePackage.CONCRETE_REVISION__REVISIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRevisions()).basicAdd(otherEnd, msgs);
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
			case StorePackage.CONCRETE_REVISION__PROJECT:
				return basicSetProject(null, msgs);
			case StorePackage.CONCRETE_REVISION__REVISIONS:
				return ((InternalEList<?>)getRevisions()).basicRemove(otherEnd, msgs);
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
			case StorePackage.CONCRETE_REVISION__ID:
				return getId();
			case StorePackage.CONCRETE_REVISION__PROJECT:
				if (resolve) return getProject();
				return basicGetProject();
			case StorePackage.CONCRETE_REVISION__STATE:
				return getState();
			case StorePackage.CONCRETE_REVISION__CHECKSUM:
				return getChecksum();
			case StorePackage.CONCRETE_REVISION__REVISIONS:
				return getRevisions();
			case StorePackage.CONCRETE_REVISION__SIZE:
				return getSize();
			case StorePackage.CONCRETE_REVISION__DATE:
				return getDate();
			case StorePackage.CONCRETE_REVISION__LAST_ERROR:
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
			case StorePackage.CONCRETE_REVISION__ID:
				setId((Integer)newValue);
				return;
			case StorePackage.CONCRETE_REVISION__PROJECT:
				setProject((Project)newValue);
				return;
			case StorePackage.CONCRETE_REVISION__STATE:
				setState((CheckinState)newValue);
				return;
			case StorePackage.CONCRETE_REVISION__CHECKSUM:
				setChecksum((byte[])newValue);
				return;
			case StorePackage.CONCRETE_REVISION__REVISIONS:
				getRevisions().clear();
				getRevisions().addAll((Collection<? extends Revision>)newValue);
				return;
			case StorePackage.CONCRETE_REVISION__SIZE:
				setSize((Long)newValue);
				return;
			case StorePackage.CONCRETE_REVISION__DATE:
				setDate((Date)newValue);
				return;
			case StorePackage.CONCRETE_REVISION__LAST_ERROR:
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
			case StorePackage.CONCRETE_REVISION__ID:
				setId(ID_EDEFAULT);
				return;
			case StorePackage.CONCRETE_REVISION__PROJECT:
				setProject((Project)null);
				return;
			case StorePackage.CONCRETE_REVISION__STATE:
				setState(STATE_EDEFAULT);
				return;
			case StorePackage.CONCRETE_REVISION__CHECKSUM:
				setChecksum(CHECKSUM_EDEFAULT);
				return;
			case StorePackage.CONCRETE_REVISION__REVISIONS:
				getRevisions().clear();
				return;
			case StorePackage.CONCRETE_REVISION__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case StorePackage.CONCRETE_REVISION__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case StorePackage.CONCRETE_REVISION__LAST_ERROR:
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
	@SuppressWarnings("unchecked")
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StorePackage.CONCRETE_REVISION__ID:
				return id != ID_EDEFAULT;
			case StorePackage.CONCRETE_REVISION__PROJECT:
				return eVirtualGet(StorePackage.CONCRETE_REVISION__PROJECT) != null;
			case StorePackage.CONCRETE_REVISION__STATE:
				return eVirtualGet(StorePackage.CONCRETE_REVISION__STATE, STATE_EDEFAULT) != STATE_EDEFAULT;
			case StorePackage.CONCRETE_REVISION__CHECKSUM:
				byte[] checksum = (byte[])eVirtualGet(StorePackage.CONCRETE_REVISION__CHECKSUM, CHECKSUM_EDEFAULT);
				return CHECKSUM_EDEFAULT == null ? checksum != null : !CHECKSUM_EDEFAULT.equals(checksum);
			case StorePackage.CONCRETE_REVISION__REVISIONS:
				EList<Revision> revisions = (EList<Revision>)eVirtualGet(StorePackage.CONCRETE_REVISION__REVISIONS);
				return revisions != null && !revisions.isEmpty();
			case StorePackage.CONCRETE_REVISION__SIZE:
				return size != SIZE_EDEFAULT;
			case StorePackage.CONCRETE_REVISION__DATE:
				Date date = (Date)eVirtualGet(StorePackage.CONCRETE_REVISION__DATE, DATE_EDEFAULT);
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case StorePackage.CONCRETE_REVISION__LAST_ERROR:
				String lastError = (String)eVirtualGet(StorePackage.CONCRETE_REVISION__LAST_ERROR, LAST_ERROR_EDEFAULT);
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
		result.append(", state: ");
		result.append(eVirtualGet(StorePackage.CONCRETE_REVISION__STATE, STATE_EDEFAULT));
		result.append(", checksum: ");
		result.append(eVirtualGet(StorePackage.CONCRETE_REVISION__CHECKSUM, CHECKSUM_EDEFAULT));
		result.append(", size: ");
		result.append(size);
		result.append(", date: ");
		result.append(eVirtualGet(StorePackage.CONCRETE_REVISION__DATE, DATE_EDEFAULT));
		result.append(", lastError: ");
		result.append(eVirtualGet(StorePackage.CONCRETE_REVISION__LAST_ERROR, LAST_ERROR_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //ConcreteRevisionImpl
