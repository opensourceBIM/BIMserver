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
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.Version#getMajor <em>Major</em>}</li>
 *   <li>{@link org.bimserver.models.store.Version#getMinor <em>Minor</em>}</li>
 *   <li>{@link org.bimserver.models.store.Version#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.Version#getFullString <em>Full String</em>}</li>
 *   <li>{@link org.bimserver.models.store.Version#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.Version#getDownloadUrl <em>Download Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.Version#getSupportUrl <em>Support Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.Version#getSupportEmail <em>Support Email</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getVersion()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Version extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Major</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Major</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Major</em>' attribute.
	 * @see #setMajor(Integer)
	 * @see org.bimserver.models.store.StorePackage#getVersion_Major()
	 * @model
	 * @generated
	 */
	Integer getMajor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Version#getMajor <em>Major</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Major</em>' attribute.
	 * @see #getMajor()
	 * @generated
	 */
	void setMajor(Integer value);

	/**
	 * Returns the value of the '<em><b>Minor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minor</em>' attribute.
	 * @see #setMinor(Integer)
	 * @see org.bimserver.models.store.StorePackage#getVersion_Minor()
	 * @model
	 * @generated
	 */
	Integer getMinor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Version#getMinor <em>Minor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minor</em>' attribute.
	 * @see #getMinor()
	 * @generated
	 */
	void setMinor(Integer value);

	/**
	 * Returns the value of the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision</em>' attribute.
	 * @see #setRevision(Integer)
	 * @see org.bimserver.models.store.StorePackage#getVersion_Revision()
	 * @model
	 * @generated
	 */
	Integer getRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Version#getRevision <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision</em>' attribute.
	 * @see #getRevision()
	 * @generated
	 */
	void setRevision(Integer value);

	/**
	 * Returns the value of the '<em><b>Full String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Full String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full String</em>' attribute.
	 * @see #setFullString(String)
	 * @see org.bimserver.models.store.StorePackage#getVersion_FullString()
	 * @model
	 * @generated
	 */
	String getFullString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Version#getFullString <em>Full String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Full String</em>' attribute.
	 * @see #getFullString()
	 * @generated
	 */
	void setFullString(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getVersion_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Version#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Download Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Download Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Download Url</em>' attribute.
	 * @see #setDownloadUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getVersion_DownloadUrl()
	 * @model
	 * @generated
	 */
	String getDownloadUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Version#getDownloadUrl <em>Download Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Download Url</em>' attribute.
	 * @see #getDownloadUrl()
	 * @generated
	 */
	void setDownloadUrl(String value);

	/**
	 * Returns the value of the '<em><b>Support Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Support Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Support Url</em>' attribute.
	 * @see #setSupportUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getVersion_SupportUrl()
	 * @model
	 * @generated
	 */
	String getSupportUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Version#getSupportUrl <em>Support Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Support Url</em>' attribute.
	 * @see #getSupportUrl()
	 * @generated
	 */
	void setSupportUrl(String value);

	/**
	 * Returns the value of the '<em><b>Support Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Support Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Support Email</em>' attribute.
	 * @see #setSupportEmail(String)
	 * @see org.bimserver.models.store.StorePackage#getVersion_SupportEmail()
	 * @model
	 * @generated
	 */
	String getSupportEmail();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Version#getSupportEmail <em>Support Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Support Email</em>' attribute.
	 * @see #getSupportEmail()
	 * @generated
	 */
	void setSupportEmail(String value);

} // Version
