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

import javax.activation.DataHandler;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Download Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.DownloadResult#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.DownloadResult#getRevisionNr <em>Revision Nr</em>}</li>
 *   <li>{@link org.bimserver.models.store.DownloadResult#getFile <em>File</em>}</li>
 *   <li>{@link org.bimserver.models.store.DownloadResult#getSerializerOid <em>Serializer Oid</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getDownloadResult()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface DownloadResult extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.bimserver.models.store.StorePackage#getDownloadResult_ProjectName()
	 * @model
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DownloadResult#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Revision Nr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision Nr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision Nr</em>' attribute.
	 * @see #setRevisionNr(Integer)
	 * @see org.bimserver.models.store.StorePackage#getDownloadResult_RevisionNr()
	 * @model
	 * @generated
	 */
	Integer getRevisionNr();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DownloadResult#getRevisionNr <em>Revision Nr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision Nr</em>' attribute.
	 * @see #getRevisionNr()
	 * @generated
	 */
	void setRevisionNr(Integer value);

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(DataHandler)
	 * @see org.bimserver.models.store.StorePackage#getDownloadResult_File()
	 * @model dataType="org.bimserver.models.store.DataHandler"
	 * @generated
	 */
	DataHandler getFile();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DownloadResult#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(DataHandler value);

	/**
	 * Returns the value of the '<em><b>Serializer Oid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serializer Oid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serializer Oid</em>' attribute.
	 * @see #setSerializerOid(long)
	 * @see org.bimserver.models.store.StorePackage#getDownloadResult_SerializerOid()
	 * @model
	 * @generated
	 */
	long getSerializerOid();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DownloadResult#getSerializerOid <em>Serializer Oid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serializer Oid</em>' attribute.
	 * @see #getSerializerOid()
	 * @generated
	 */
	void setSerializerOid(long value);

} // DownloadResult
