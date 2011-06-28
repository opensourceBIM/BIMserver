/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import java.util.Date;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.Clash;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Revision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getConcreteRevisions <em>Concrete Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getLastConcreteRevision <em>Last Concrete Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getCheckouts <em>Checkouts</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getLastClashes <em>Last Clashes</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getLastError <em>Last Error</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getBmi <em>Bmi</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getNrClashes <em>Nr Clashes</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getLaid <em>Laid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RevisionImpl extends IdEObjectImpl implements Revision {
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
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return (Integer)eGet(StorePackage.Literals.REVISION__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		eSet(StorePackage.Literals.REVISION__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getUser() {
		return (User)eGet(StorePackage.Literals.REVISION__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		eSet(StorePackage.Literals.REVISION__USER, newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return (Date)eGet(StorePackage.Literals.REVISION__DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		eSet(StorePackage.Literals.REVISION__DATE, newDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return (String)eGet(StorePackage.Literals.REVISION__COMMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		eSet(StorePackage.Literals.REVISION__COMMENT, newComment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSize() {
		return (Long)eGet(StorePackage.Literals.REVISION__SIZE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(long newSize) {
		eSet(StorePackage.Literals.REVISION__SIZE, newSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConcreteRevision> getConcreteRevisions() {
		return (EList<ConcreteRevision>)eGet(StorePackage.Literals.REVISION__CONCRETE_REVISIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteRevision getLastConcreteRevision() {
		return (ConcreteRevision)eGet(StorePackage.Literals.REVISION__LAST_CONCRETE_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastConcreteRevision(ConcreteRevision newLastConcreteRevision) {
		eSet(StorePackage.Literals.REVISION__LAST_CONCRETE_REVISION, newLastConcreteRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Checkout> getCheckouts() {
		return (EList<Checkout>)eGet(StorePackage.Literals.REVISION__CHECKOUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		return (Project)eGet(StorePackage.Literals.REVISION__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		eSet(StorePackage.Literals.REVISION__PROJECT, newProject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckinState getState() {
		return (CheckinState)eGet(StorePackage.Literals.REVISION__STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(CheckinState newState) {
		eSet(StorePackage.Literals.REVISION__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Clash> getLastClashes() {
		return (EList<Clash>)eGet(StorePackage.Literals.REVISION__LAST_CLASHES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTag() {
		return (String)eGet(StorePackage.Literals.REVISION__TAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTag(String newTag) {
		eSet(StorePackage.Literals.REVISION__TAG, newTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastError() {
		return (String)eGet(StorePackage.Literals.REVISION__LAST_ERROR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastError(String newLastError) {
		eSet(StorePackage.Literals.REVISION__LAST_ERROR, newLastError);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBmi() {
		return (Integer)eGet(StorePackage.Literals.REVISION__BMI, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBmi(int newBmi) {
		eSet(StorePackage.Literals.REVISION__BMI, newBmi);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNrClashes() {
		return (Integer)eGet(StorePackage.Literals.REVISION__NR_CLASHES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNrClashes(int newNrClashes) {
		eSet(StorePackage.Literals.REVISION__NR_CLASHES, newNrClashes);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLaid() {
		return (Long)eGet(StorePackage.Literals.REVISION__LAID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaid(long newLaid) {
		eSet(StorePackage.Literals.REVISION__LAID, newLaid);
	}

} //RevisionImpl
