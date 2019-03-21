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
import org.bimserver.models.log.RevisionRelated;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Revision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.Revision#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getComment <em>Comment</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getSize <em>Size</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getConcreteRevisions <em>Concrete Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getLastConcreteRevision <em>Last Concrete Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getCheckouts <em>Checkouts</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getTag <em>Tag</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getLastError <em>Last Error</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getBmi <em>Bmi</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getExtendedData <em>Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getLogs <em>Logs</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getService <em>Service</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#isHasGeometry <em>Has Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getBoundsUntransformed <em>Bounds Untransformed</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getBoundsMm <em>Bounds Mm</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getBoundsUntransformedMm <em>Bounds Untransformed Mm</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getServicesLinked <em>Services Linked</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getDensityCollection <em>Density Collection</em>}</li>
 *   <li>{@link org.bimserver.models.store.Revision#getNrPrimitives <em>Nr Primitives</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getRevision()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Revision extends IdEObject {
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
	 * @see org.bimserver.models.store.StorePackage#getRevision_Id()
	 * @model
	 * @generated
	 */
	Integer getId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Integer value);

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
	 * @see org.bimserver.models.store.StorePackage#getRevision_User()
	 * @model
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);

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
	 * @see org.bimserver.models.store.StorePackage#getRevision_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see org.bimserver.models.store.StorePackage#getRevision_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getRevision_Size()
	 * @model
	 * @generated
	 */
	Long getSize();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Long value);

	/**
	 * Returns the value of the '<em><b>Concrete Revisions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ConcreteRevision}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ConcreteRevision#getRevisions <em>Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Revisions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Revisions</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getRevision_ConcreteRevisions()
	 * @see org.bimserver.models.store.ConcreteRevision#getRevisions
	 * @model opposite="revisions"
	 * @generated
	 */
	EList<ConcreteRevision> getConcreteRevisions();

	/**
	 * Returns the value of the '<em><b>Last Concrete Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Concrete Revision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Concrete Revision</em>' reference.
	 * @see #setLastConcreteRevision(ConcreteRevision)
	 * @see org.bimserver.models.store.StorePackage#getRevision_LastConcreteRevision()
	 * @model
	 * @generated
	 */
	ConcreteRevision getLastConcreteRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getLastConcreteRevision <em>Last Concrete Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Concrete Revision</em>' reference.
	 * @see #getLastConcreteRevision()
	 * @generated
	 */
	void setLastConcreteRevision(ConcreteRevision value);

	/**
	 * Returns the value of the '<em><b>Checkouts</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Checkout}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Checkout#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkouts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkouts</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getRevision_Checkouts()
	 * @see org.bimserver.models.store.Checkout#getRevision
	 * @model opposite="revision"
	 * @generated
	 */
	EList<Checkout> getCheckouts();

	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Project#getRevisions <em>Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see org.bimserver.models.store.StorePackage#getRevision_Project()
	 * @see org.bimserver.models.store.Project#getRevisions
	 * @model opposite="revisions"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' attribute.
	 * @see #setTag(String)
	 * @see org.bimserver.models.store.StorePackage#getRevision_Tag()
	 * @model
	 * @generated
	 */
	String getTag();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' attribute.
	 * @see #getTag()
	 * @generated
	 */
	void setTag(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getRevision_LastError()
	 * @model
	 * @generated
	 */
	String getLastError();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getLastError <em>Last Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Error</em>' attribute.
	 * @see #getLastError()
	 * @generated
	 */
	void setLastError(String value);

	/**
	 * Returns the value of the '<em><b>Bmi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bmi</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bmi</em>' attribute.
	 * @see #setBmi(Integer)
	 * @see org.bimserver.models.store.StorePackage#getRevision_Bmi()
	 * @model
	 * @generated
	 */
	Integer getBmi();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getBmi <em>Bmi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bmi</em>' attribute.
	 * @see #getBmi()
	 * @generated
	 */
	void setBmi(Integer value);

	/**
	 * Returns the value of the '<em><b>Extended Data</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ExtendedData}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ExtendedData#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Data</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getRevision_ExtendedData()
	 * @see org.bimserver.models.store.ExtendedData#getRevision
	 * @model opposite="revision"
	 * @generated
	 */
	EList<ExtendedData> getExtendedData();

	/**
	 * Returns the value of the '<em><b>Logs</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.log.RevisionRelated}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.log.RevisionRelated#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logs</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getRevision_Logs()
	 * @see org.bimserver.models.log.RevisionRelated#getRevision
	 * @model opposite="revision"
	 * @generated
	 */
	EList<RevisionRelated> getLogs();

	/**
	 * Returns the value of the '<em><b>Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' reference.
	 * @see #setService(Service)
	 * @see org.bimserver.models.store.StorePackage#getRevision_Service()
	 * @model
	 * @generated
	 */
	Service getService();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getService <em>Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(Service value);

	/**
	 * Returns the value of the '<em><b>Has Geometry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Geometry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Geometry</em>' attribute.
	 * @see #setHasGeometry(boolean)
	 * @see org.bimserver.models.store.StorePackage#getRevision_HasGeometry()
	 * @model
	 * @generated
	 */
	boolean isHasGeometry();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#isHasGeometry <em>Has Geometry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Geometry</em>' attribute.
	 * @see #isHasGeometry()
	 * @generated
	 */
	void setHasGeometry(boolean value);

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
	 * @see org.bimserver.models.store.StorePackage#getRevision_Bounds()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Bounds getBounds();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getBounds <em>Bounds</em>}' reference.
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
	 * @see org.bimserver.models.store.StorePackage#getRevision_BoundsUntransformed()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Bounds getBoundsUntransformed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getBoundsUntransformed <em>Bounds Untransformed</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds Untransformed</em>' reference.
	 * @see #getBoundsUntransformed()
	 * @generated
	 */
	void setBoundsUntransformed(Bounds value);

	/**
	 * Returns the value of the '<em><b>Bounds Mm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds Mm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds Mm</em>' reference.
	 * @see #setBoundsMm(Bounds)
	 * @see org.bimserver.models.store.StorePackage#getRevision_BoundsMm()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Bounds getBoundsMm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getBoundsMm <em>Bounds Mm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds Mm</em>' reference.
	 * @see #getBoundsMm()
	 * @generated
	 */
	void setBoundsMm(Bounds value);

	/**
	 * Returns the value of the '<em><b>Bounds Untransformed Mm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds Untransformed Mm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds Untransformed Mm</em>' reference.
	 * @see #setBoundsUntransformedMm(Bounds)
	 * @see org.bimserver.models.store.StorePackage#getRevision_BoundsUntransformedMm()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Bounds getBoundsUntransformedMm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getBoundsUntransformedMm <em>Bounds Untransformed Mm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds Untransformed Mm</em>' reference.
	 * @see #getBoundsUntransformedMm()
	 * @generated
	 */
	void setBoundsUntransformedMm(Bounds value);

	/**
	 * Returns the value of the '<em><b>Services Linked</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.NewService}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services Linked</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services Linked</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getRevision_ServicesLinked()
	 * @model
	 * @generated
	 */
	EList<NewService> getServicesLinked();

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
	 * @see org.bimserver.models.store.StorePackage#getRevision_DensityCollection()
	 * @model
	 * @generated
	 */
	DensityCollection getDensityCollection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getDensityCollection <em>Density Collection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Density Collection</em>' reference.
	 * @see #getDensityCollection()
	 * @generated
	 */
	void setDensityCollection(DensityCollection value);

	/**
	 * Returns the value of the '<em><b>Nr Primitives</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nr Primitives</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Primitives</em>' attribute.
	 * @see #setNrPrimitives(long)
	 * @see org.bimserver.models.store.StorePackage#getRevision_NrPrimitives()
	 * @model
	 * @generated
	 */
	long getNrPrimitives();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Revision#getNrPrimitives <em>Nr Primitives</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Primitives</em>' attribute.
	 * @see #getNrPrimitives()
	 * @generated
	 */
	void setNrPrimitives(long value);

} // Revision
