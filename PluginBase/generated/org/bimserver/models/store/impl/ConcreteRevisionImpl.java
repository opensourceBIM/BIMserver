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
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DensityCollection;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Revision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getChecksum <em>Checksum</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getLastError <em>Last Error</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#isClear <em>Clear</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getSummary <em>Summary</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getIfcHeader <em>Ifc Header</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getBoundsUntransformed <em>Bounds Untransformed</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getOidCounters <em>Oid Counters</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getMultiplierToMm <em>Multiplier To Mm</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ConcreteRevisionImpl#getDensityCollection <em>Density Collection</em>}</li>
 * </ul>
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
	@Override
	public Integer getId() {
		return (Integer) eGet(StorePackage.Literals.CONCRETE_REVISION__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(Integer newId) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Project getProject() {
		return (Project) eGet(StorePackage.Literals.CONCRETE_REVISION__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProject(Project newProject) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__PROJECT, newProject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte[] getChecksum() {
		return (byte[]) eGet(StorePackage.Literals.CONCRETE_REVISION__CHECKSUM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setChecksum(byte[] newChecksum) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__CHECKSUM, newChecksum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Revision> getRevisions() {
		return (EList<Revision>) eGet(StorePackage.Literals.CONCRETE_REVISION__REVISIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getSize() {
		return (Long) eGet(StorePackage.Literals.CONCRETE_REVISION__SIZE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(Long newSize) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__SIZE, newSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDate() {
		return (Date) eGet(StorePackage.Literals.CONCRETE_REVISION__DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__DATE, newDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLastError() {
		return (String) eGet(StorePackage.Literals.CONCRETE_REVISION__LAST_ERROR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastError(String newLastError) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__LAST_ERROR, newLastError);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isClear() {
		return (Boolean) eGet(StorePackage.Literals.CONCRETE_REVISION__CLEAR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClear(boolean newClear) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__CLEAR, newClear);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RevisionSummary getSummary() {
		return (RevisionSummary) eGet(StorePackage.Literals.CONCRETE_REVISION__SUMMARY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSummary(RevisionSummary newSummary) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__SUMMARY, newSummary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public User getUser() {
		return (User) eGet(StorePackage.Literals.CONCRETE_REVISION__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUser(User newUser) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__USER, newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcHeader getIfcHeader() {
		return (IfcHeader) eGet(StorePackage.Literals.CONCRETE_REVISION__IFC_HEADER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIfcHeader(IfcHeader newIfcHeader) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__IFC_HEADER, newIfcHeader);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bounds getBounds() {
		return (Bounds) eGet(StorePackage.Literals.CONCRETE_REVISION__BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBounds(Bounds newBounds) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__BOUNDS, newBounds);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bounds getBoundsUntransformed() {
		return (Bounds) eGet(StorePackage.Literals.CONCRETE_REVISION__BOUNDS_UNTRANSFORMED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBoundsUntransformed(Bounds newBoundsUntransformed) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__BOUNDS_UNTRANSFORMED, newBoundsUntransformed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte[] getOidCounters() {
		return (byte[]) eGet(StorePackage.Literals.CONCRETE_REVISION__OID_COUNTERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOidCounters(byte[] newOidCounters) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__OID_COUNTERS, newOidCounters);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getMultiplierToMm() {
		return (Float) eGet(StorePackage.Literals.CONCRETE_REVISION__MULTIPLIER_TO_MM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMultiplierToMm(float newMultiplierToMm) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__MULTIPLIER_TO_MM, newMultiplierToMm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DensityCollection getDensityCollection() {
		return (DensityCollection) eGet(StorePackage.Literals.CONCRETE_REVISION__DENSITY_COLLECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDensityCollection(DensityCollection newDensityCollection) {
		eSet(StorePackage.Literals.CONCRETE_REVISION__DENSITY_COLLECTION, newDensityCollection);
	}

} //ConcreteRevisionImpl
