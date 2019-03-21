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
package org.bimserver.models.store;

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

import org.bimserver.emf.IdEObject;
import org.bimserver.models.geometry.Bounds;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Revision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getChecksum <em>Checksum</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getSize <em>Size</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getLastError <em>Last Error</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#isClear <em>Clear</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getSummary <em>Summary</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getIfcHeader <em>Ifc Header</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getBoundsUntransformed <em>Bounds Untransformed</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getOidCounters <em>Oid Counters</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getMultiplierToMm <em>Multiplier To Mm</em>}</li>
 *   <li>{@link org.bimserver.models.store.ConcreteRevision#getDensityCollection <em>Density Collection</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getConcreteRevision()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface ConcreteRevision extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(Integer)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Id()
	 * @model
	 * @generated
	 */
	Integer getId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Integer value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Project#getConcreteRevisions <em>Concrete Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Project()
	 * @see org.bimserver.models.store.Project#getConcreteRevisions
	 * @model opposite="concreteRevisions"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>Checksum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checksum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checksum</em>' attribute.
	 * @see #setChecksum(byte[])
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Checksum()
	 * @model
	 * @generated
	 */
	byte[] getChecksum();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getChecksum <em>Checksum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checksum</em>' attribute.
	 * @see #getChecksum()
	 * @generated
	 */
	void setChecksum(byte[] value);

	/**
	 * Returns the value of the '<em><b>Revisions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Revision}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Revision#getConcreteRevisions <em>Concrete Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revisions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revisions</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Revisions()
	 * @see org.bimserver.models.store.Revision#getConcreteRevisions
	 * @model opposite="concreteRevisions"
	 * @generated
	 */
	EList<Revision> getRevisions();

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(Long)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Size()
	 * @model
	 * @generated
	 */
	Long getSize();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Long value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Last Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Error</em>' attribute.
	 * @see #setLastError(String)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_LastError()
	 * @model
	 * @generated
	 */
	String getLastError();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getLastError <em>Last Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Error</em>' attribute.
	 * @see #getLastError()
	 * @generated
	 */
	void setLastError(String value);

	/**
	 * Returns the value of the '<em><b>Clear</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clear</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear</em>' attribute.
	 * @see #setClear(boolean)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Clear()
	 * @model
	 * @generated
	 */
	boolean isClear();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#isClear <em>Clear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear</em>' attribute.
	 * @see #isClear()
	 * @generated
	 */
	void setClear(boolean value);

	/**
	 * Returns the value of the '<em><b>Summary</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Summary</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Summary</em>' reference.
	 * @see #setSummary(RevisionSummary)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Summary()
	 * @model
	 * @generated
	 */
	RevisionSummary getSummary();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getSummary <em>Summary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Summary</em>' reference.
	 * @see #getSummary()
	 * @generated
	 */
	void setSummary(RevisionSummary value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' reference.
	 * @see #setUser(User)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_User()
	 * @model
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);

	/**
	 * Returns the value of the '<em><b>Ifc Header</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifc Header</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Header</em>' reference.
	 * @see #setIfcHeader(IfcHeader)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_IfcHeader()
	 * @model
	 * @generated
	 */
	IfcHeader getIfcHeader();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getIfcHeader <em>Ifc Header</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ifc Header</em>' reference.
	 * @see #getIfcHeader()
	 * @generated
	 */
	void setIfcHeader(IfcHeader value);

	/**
	 * Returns the value of the '<em><b>Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds</em>' reference.
	 * @see #setBounds(Bounds)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_Bounds()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Bounds getBounds();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getBounds <em>Bounds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds</em>' reference.
	 * @see #getBounds()
	 * @generated
	 */
	void setBounds(Bounds value);

	/**
	 * Returns the value of the '<em><b>Bounds Untransformed</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds Untransformed</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds Untransformed</em>' reference.
	 * @see #setBoundsUntransformed(Bounds)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_BoundsUntransformed()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Bounds getBoundsUntransformed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getBoundsUntransformed <em>Bounds Untransformed</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds Untransformed</em>' reference.
	 * @see #getBoundsUntransformed()
	 * @generated
	 */
	void setBoundsUntransformed(Bounds value);

	/**
	 * Returns the value of the '<em><b>Oid Counters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oid Counters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oid Counters</em>' attribute.
	 * @see #setOidCounters(byte[])
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_OidCounters()
	 * @model
	 * @generated
	 */
	byte[] getOidCounters();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getOidCounters <em>Oid Counters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oid Counters</em>' attribute.
	 * @see #getOidCounters()
	 * @generated
	 */
	void setOidCounters(byte[] value);

	/**
	 * Returns the value of the '<em><b>Multiplier To Mm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplier To Mm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplier To Mm</em>' attribute.
	 * @see #setMultiplierToMm(float)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_MultiplierToMm()
	 * @model
	 * @generated
	 */
	float getMultiplierToMm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getMultiplierToMm <em>Multiplier To Mm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplier To Mm</em>' attribute.
	 * @see #getMultiplierToMm()
	 * @generated
	 */
	void setMultiplierToMm(float value);

	/**
	 * Returns the value of the '<em><b>Density Collection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Density Collection</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Density Collection</em>' reference.
	 * @see #setDensityCollection(DensityCollection)
	 * @see org.bimserver.models.store.StorePackage#getConcreteRevision_DensityCollection()
	 * @model
	 * @generated
	 */
	DensityCollection getDensityCollection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ConcreteRevision#getDensityCollection <em>Density Collection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Density Collection</em>' reference.
	 * @see #getDensityCollection()
	 * @generated
	 */
	void setDensityCollection(DensityCollection value);

} // ConcreteRevision
