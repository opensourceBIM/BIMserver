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
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Revision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getChecksum <em>Checksum</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getLastError <em>Last Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteRevisionImpl extends IdEObjectImpl implements ConcreteRevision {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcreteRevisionImpl() {
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
		return (Integer)eGet(StorePackage.Literals.CONCRETE_REVISION__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		return (Project)eGet(StorePackage.Literals.CONCRETE_REVISION__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__PROJECT, newProject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckinState getState() {
		return (CheckinState)eGet(StorePackage.Literals.CONCRETE_REVISION__STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(CheckinState newState) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getChecksum() {
		return (byte[])eGet(StorePackage.Literals.CONCRETE_REVISION__CHECKSUM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChecksum(byte[] newChecksum) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__CHECKSUM, newChecksum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Revision> getRevisions() {
		return (EList<Revision>)eGet(StorePackage.Literals.CONCRETE_REVISION__REVISIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSize() {
		return (Long)eGet(StorePackage.Literals.CONCRETE_REVISION__SIZE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(long newSize) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__SIZE, newSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return (Date)eGet(StorePackage.Literals.CONCRETE_REVISION__DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__DATE, newDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastError() {
		return (String)eGet(StorePackage.Literals.CONCRETE_REVISION__LAST_ERROR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastError(String newLastError) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__LAST_ERROR, newLastError);
	}

} //ConcreteRevisionImpl
