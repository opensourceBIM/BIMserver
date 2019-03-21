/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.store.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.Date;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.geometry.Bounds;
import org.bimserver.models.log.RevisionRelated;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DensityCollection;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.NewService;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.Service;
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
 * </p>
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
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getLastError <em>Last Error</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getBmi <em>Bmi</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getExtendedData <em>Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getLogs <em>Logs</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getService <em>Service</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#isHasGeometry <em>Has Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getBoundsUntransformed <em>Bounds Untransformed</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getBoundsMm <em>Bounds Mm</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getBoundsUntransformedMm <em>Bounds Untransformed Mm</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getServicesLinked <em>Services Linked</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getDensityCollection <em>Density Collection</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RevisionImpl#getNrPrimitives <em>Nr Primitives</em>}</li>
 * </ul>
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
	@Override
	public Integer getId() {
		return (Integer) eGet(StorePackage.Literals.REVISION__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(Integer newId) {
		eSet(StorePackage.Literals.REVISION__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public User getUser() {
		return (User) eGet(StorePackage.Literals.REVISION__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUser(User newUser) {
		eSet(StorePackage.Literals.REVISION__USER, newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDate() {
		return (Date) eGet(StorePackage.Literals.REVISION__DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		eSet(StorePackage.Literals.REVISION__DATE, newDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getComment() {
		return (String) eGet(StorePackage.Literals.REVISION__COMMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComment(String newComment) {
		eSet(StorePackage.Literals.REVISION__COMMENT, newComment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getSize() {
		return (Long) eGet(StorePackage.Literals.REVISION__SIZE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(Long newSize) {
		eSet(StorePackage.Literals.REVISION__SIZE, newSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ConcreteRevision> getConcreteRevisions() {
		return (EList<ConcreteRevision>) eGet(StorePackage.Literals.REVISION__CONCRETE_REVISIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConcreteRevision getLastConcreteRevision() {
		return (ConcreteRevision) eGet(StorePackage.Literals.REVISION__LAST_CONCRETE_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastConcreteRevision(ConcreteRevision newLastConcreteRevision) {
		eSet(StorePackage.Literals.REVISION__LAST_CONCRETE_REVISION, newLastConcreteRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Checkout> getCheckouts() {
		return (EList<Checkout>) eGet(StorePackage.Literals.REVISION__CHECKOUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Project getProject() {
		return (Project) eGet(StorePackage.Literals.REVISION__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProject(Project newProject) {
		eSet(StorePackage.Literals.REVISION__PROJECT, newProject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTag() {
		return (String) eGet(StorePackage.Literals.REVISION__TAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTag(String newTag) {
		eSet(StorePackage.Literals.REVISION__TAG, newTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLastError() {
		return (String) eGet(StorePackage.Literals.REVISION__LAST_ERROR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastError(String newLastError) {
		eSet(StorePackage.Literals.REVISION__LAST_ERROR, newLastError);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getBmi() {
		return (Integer) eGet(StorePackage.Literals.REVISION__BMI, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBmi(Integer newBmi) {
		eSet(StorePackage.Literals.REVISION__BMI, newBmi);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ExtendedData> getExtendedData() {
		return (EList<ExtendedData>) eGet(StorePackage.Literals.REVISION__EXTENDED_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<RevisionRelated> getLogs() {
		return (EList<RevisionRelated>) eGet(StorePackage.Literals.REVISION__LOGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Service getService() {
		return (Service) eGet(StorePackage.Literals.REVISION__SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setService(Service newService) {
		eSet(StorePackage.Literals.REVISION__SERVICE, newService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasGeometry() {
		return (Boolean) eGet(StorePackage.Literals.REVISION__HAS_GEOMETRY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasGeometry(boolean newHasGeometry) {
		eSet(StorePackage.Literals.REVISION__HAS_GEOMETRY, newHasGeometry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bounds getBounds() {
		return (Bounds) eGet(StorePackage.Literals.REVISION__BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBounds(Bounds newBounds) {
		eSet(StorePackage.Literals.REVISION__BOUNDS, newBounds);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bounds getBoundsUntransformed() {
		return (Bounds) eGet(StorePackage.Literals.REVISION__BOUNDS_UNTRANSFORMED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBoundsUntransformed(Bounds newBoundsUntransformed) {
		eSet(StorePackage.Literals.REVISION__BOUNDS_UNTRANSFORMED, newBoundsUntransformed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bounds getBoundsMm() {
		return (Bounds) eGet(StorePackage.Literals.REVISION__BOUNDS_MM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBoundsMm(Bounds newBoundsMm) {
		eSet(StorePackage.Literals.REVISION__BOUNDS_MM, newBoundsMm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bounds getBoundsUntransformedMm() {
		return (Bounds) eGet(StorePackage.Literals.REVISION__BOUNDS_UNTRANSFORMED_MM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBoundsUntransformedMm(Bounds newBoundsUntransformedMm) {
		eSet(StorePackage.Literals.REVISION__BOUNDS_UNTRANSFORMED_MM, newBoundsUntransformedMm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<NewService> getServicesLinked() {
		return (EList<NewService>) eGet(StorePackage.Literals.REVISION__SERVICES_LINKED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DensityCollection getDensityCollection() {
		return (DensityCollection) eGet(StorePackage.Literals.REVISION__DENSITY_COLLECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDensityCollection(DensityCollection newDensityCollection) {
		eSet(StorePackage.Literals.REVISION__DENSITY_COLLECTION, newDensityCollection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getNrPrimitives() {
		return (Long) eGet(StorePackage.Literals.REVISION__NR_PRIMITIVES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNrPrimitives(long newNrPrimitives) {
		eSet(StorePackage.Literals.REVISION__NR_PRIMITIVES, newNrPrimitives);
	}

} //RevisionImpl
