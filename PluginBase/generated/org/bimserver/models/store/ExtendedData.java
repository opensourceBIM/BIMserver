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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.ExtendedData#getUrl <em>Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedData#getFile <em>File</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedData#getSize <em>Size</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedData#getTitle <em>Title</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedData#getAdded <em>Added</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedData#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedData#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedData#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedData#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedData#getTimeToGenerate <em>Time To Generate</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getExtendedData()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface ExtendedData extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getExtendedData_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedData#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>File</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' reference.
	 * @see #setFile(File)
	 * @see org.bimserver.models.store.StorePackage#getExtendedData_File()
	 * @model
	 * @generated
	 */
	File getFile();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedData#getFile <em>File</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(File value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(long)
	 * @see org.bimserver.models.store.StorePackage#getExtendedData_Size()
	 * @model
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedData#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.bimserver.models.store.StorePackage#getExtendedData_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedData#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Added</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Added</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Added</em>' attribute.
	 * @see #setAdded(Date)
	 * @see org.bimserver.models.store.StorePackage#getExtendedData_Added()
	 * @model
	 * @generated
	 */
	Date getAdded();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedData#getAdded <em>Added</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Added</em>' attribute.
	 * @see #getAdded()
	 * @generated
	 */
	void setAdded(Date value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.User#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' reference.
	 * @see #setUser(User)
	 * @see org.bimserver.models.store.StorePackage#getExtendedData_User()
	 * @see org.bimserver.models.store.User#getExtendedData
	 * @model opposite="extendedData"
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedData#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);

	/**
	 * Returns the value of the '<em><b>Schema</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ExtendedDataSchema#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' reference.
	 * @see #setSchema(ExtendedDataSchema)
	 * @see org.bimserver.models.store.StorePackage#getExtendedData_Schema()
	 * @see org.bimserver.models.store.ExtendedDataSchema#getExtendedData
	 * @model opposite="extendedData"
	 * @generated
	 */
	ExtendedDataSchema getSchema();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedData#getSchema <em>Schema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' reference.
	 * @see #getSchema()
	 * @generated
	 */
	void setSchema(ExtendedDataSchema value);

	/**
	 * Returns the value of the '<em><b>Revision</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Revision#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision</em>' reference.
	 * @see #setRevision(Revision)
	 * @see org.bimserver.models.store.StorePackage#getExtendedData_Revision()
	 * @see org.bimserver.models.store.Revision#getExtendedData
	 * @model opposite="extendedData"
	 * @generated
	 */
	Revision getRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedData#getRevision <em>Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision</em>' reference.
	 * @see #getRevision()
	 * @generated
	 */
	void setRevision(Revision value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Project#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see org.bimserver.models.store.StorePackage#getExtendedData_Project()
	 * @see org.bimserver.models.store.Project#getExtendedData
	 * @model opposite="extendedData"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedData#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>Time To Generate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time To Generate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time To Generate</em>' attribute.
	 * @see #setTimeToGenerate(long)
	 * @see org.bimserver.models.store.StorePackage#getExtendedData_TimeToGenerate()
	 * @model
	 * @generated
	 */
	long getTimeToGenerate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedData#getTimeToGenerate <em>Time To Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time To Generate</em>' attribute.
	 * @see #getTimeToGenerate()
	 * @generated
	 */
	void setTimeToGenerate(long value);

} // ExtendedData
