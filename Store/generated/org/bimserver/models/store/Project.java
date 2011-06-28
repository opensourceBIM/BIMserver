/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;

import java.util.Date;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.Project#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getHasAuthorizedUsers <em>Has Authorized Users</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getConcreteRevisions <em>Concrete Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getLastConcreteRevision <em>Last Concrete Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getLastRevision <em>Last Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getCheckouts <em>Checkouts</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getCreatedDate <em>Created Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getCreatedBy <em>Created By</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getGeoTag <em>Geo Tag</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getSubProjects <em>Sub Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getParent <em>Parent</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getClashDetectionSettings <em>Clash Detection Settings</em>}</li>
 *   <li>{@link org.bimserver.models.store.Project#getExportLengthMeasurePrefix <em>Export Length Measure Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getProject()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Project extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see org.bimserver.models.store.StorePackage#getProject_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.store.StorePackage#getProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Has Authorized Users</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.User}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.User#getHasRightsOn <em>Has Rights On</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Authorized Users</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Authorized Users</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getProject_HasAuthorizedUsers()
	 * @see org.bimserver.models.store.User#getHasRightsOn
	 * @model opposite="hasRightsOn"
	 * @generated
	 */
	EList<User> getHasAuthorizedUsers();

	/**
	 * Returns the value of the '<em><b>Concrete Revisions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ConcreteRevision}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ConcreteRevision#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Revisions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Revisions</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getProject_ConcreteRevisions()
	 * @see org.bimserver.models.store.ConcreteRevision#getProject
	 * @model opposite="project"
	 * @generated
	 */
	EList<ConcreteRevision> getConcreteRevisions();

	/**
	 * Returns the value of the '<em><b>Revisions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Revision}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Revision#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revisions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revisions</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getProject_Revisions()
	 * @see org.bimserver.models.store.Revision#getProject
	 * @model opposite="project"
	 * @generated
	 */
	EList<Revision> getRevisions();

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
	 * @see org.bimserver.models.store.StorePackage#getProject_LastConcreteRevision()
	 * @model
	 * @generated
	 */
	ConcreteRevision getLastConcreteRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getLastConcreteRevision <em>Last Concrete Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Concrete Revision</em>' reference.
	 * @see #getLastConcreteRevision()
	 * @generated
	 */
	void setLastConcreteRevision(ConcreteRevision value);

	/**
	 * Returns the value of the '<em><b>Last Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Revision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Revision</em>' reference.
	 * @see #setLastRevision(Revision)
	 * @see org.bimserver.models.store.StorePackage#getProject_LastRevision()
	 * @model
	 * @generated
	 */
	Revision getLastRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getLastRevision <em>Last Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Revision</em>' reference.
	 * @see #getLastRevision()
	 * @generated
	 */
	void setLastRevision(Revision value);

	/**
	 * Returns the value of the '<em><b>Checkouts</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Checkout}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Checkout#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkouts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkouts</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getProject_Checkouts()
	 * @see org.bimserver.models.store.Checkout#getProject
	 * @model opposite="project"
	 * @generated
	 */
	EList<Checkout> getCheckouts();

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.ObjectState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.ObjectState
	 * @see #setState(ObjectState)
	 * @see org.bimserver.models.store.StorePackage#getProject_State()
	 * @model
	 * @generated
	 */
	ObjectState getState();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.ObjectState
	 * @see #getState()
	 * @generated
	 */
	void setState(ObjectState value);

	/**
	 * Returns the value of the '<em><b>Created Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created Date</em>' attribute.
	 * @see #setCreatedDate(Date)
	 * @see org.bimserver.models.store.StorePackage#getProject_CreatedDate()
	 * @model
	 * @generated
	 */
	Date getCreatedDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getCreatedDate <em>Created Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created Date</em>' attribute.
	 * @see #getCreatedDate()
	 * @generated
	 */
	void setCreatedDate(Date value);

	/**
	 * Returns the value of the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created By</em>' reference.
	 * @see #setCreatedBy(User)
	 * @see org.bimserver.models.store.StorePackage#getProject_CreatedBy()
	 * @model
	 * @generated
	 */
	User getCreatedBy();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getCreatedBy <em>Created By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created By</em>' reference.
	 * @see #getCreatedBy()
	 * @generated
	 */
	void setCreatedBy(User value);

	/**
	 * Returns the value of the '<em><b>Geo Tag</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.GeoTag#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Geo Tag</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Geo Tag</em>' reference.
	 * @see #setGeoTag(GeoTag)
	 * @see org.bimserver.models.store.StorePackage#getProject_GeoTag()
	 * @see org.bimserver.models.store.GeoTag#getProjects
	 * @model opposite="projects"
	 * @generated
	 */
	GeoTag getGeoTag();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getGeoTag <em>Geo Tag</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Geo Tag</em>' reference.
	 * @see #getGeoTag()
	 * @generated
	 */
	void setGeoTag(GeoTag value);

	/**
	 * Returns the value of the '<em><b>Sub Projects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Project}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Project#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Projects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Projects</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getProject_SubProjects()
	 * @see org.bimserver.models.store.Project#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<Project> getSubProjects();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Project#getSubProjects <em>Sub Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Project)
	 * @see org.bimserver.models.store.StorePackage#getProject_Parent()
	 * @see org.bimserver.models.store.Project#getSubProjects
	 * @model opposite="subProjects"
	 * @generated
	 */
	Project getParent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Project value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.bimserver.models.store.StorePackage#getProject_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Clash Detection Settings</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ClashDetectionSettings#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clash Detection Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clash Detection Settings</em>' reference.
	 * @see #setClashDetectionSettings(ClashDetectionSettings)
	 * @see org.bimserver.models.store.StorePackage#getProject_ClashDetectionSettings()
	 * @see org.bimserver.models.store.ClashDetectionSettings#getProjects
	 * @model opposite="projects"
	 * @generated
	 */
	ClashDetectionSettings getClashDetectionSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getClashDetectionSettings <em>Clash Detection Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clash Detection Settings</em>' reference.
	 * @see #getClashDetectionSettings()
	 * @generated
	 */
	void setClashDetectionSettings(ClashDetectionSettings value);

	/**
	 * Returns the value of the '<em><b>Export Length Measure Prefix</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.SIPrefix}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Length Measure Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Length Measure Prefix</em>' attribute.
	 * @see org.bimserver.models.store.SIPrefix
	 * @see #setExportLengthMeasurePrefix(SIPrefix)
	 * @see org.bimserver.models.store.StorePackage#getProject_ExportLengthMeasurePrefix()
	 * @model
	 * @generated
	 */
	SIPrefix getExportLengthMeasurePrefix();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Project#getExportLengthMeasurePrefix <em>Export Length Measure Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Length Measure Prefix</em>' attribute.
	 * @see org.bimserver.models.store.SIPrefix
	 * @see #getExportLengthMeasurePrefix()
	 * @generated
	 */
	void setExportLengthMeasurePrefix(SIPrefix value);

} // Project
