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
 * A representation of the model object '<em><b>System Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.SystemInfo#getCpucores <em>Cpucores</em>}</li>
 *   <li>{@link org.bimserver.models.store.SystemInfo#getDatetime <em>Datetime</em>}</li>
 *   <li>{@link org.bimserver.models.store.SystemInfo#getOsname <em>Osname</em>}</li>
 *   <li>{@link org.bimserver.models.store.SystemInfo#getOsversion <em>Osversion</em>}</li>
 *   <li>{@link org.bimserver.models.store.SystemInfo#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.SystemInfo#getUserHome <em>User Home</em>}</li>
 *   <li>{@link org.bimserver.models.store.SystemInfo#getUserDir <em>User Dir</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getSystemInfo()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface SystemInfo extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Cpucores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cpucores</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpucores</em>' attribute.
	 * @see #setCpucores(int)
	 * @see org.bimserver.models.store.StorePackage#getSystemInfo_Cpucores()
	 * @model
	 * @generated
	 */
	int getCpucores();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SystemInfo#getCpucores <em>Cpucores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpucores</em>' attribute.
	 * @see #getCpucores()
	 * @generated
	 */
	void setCpucores(int value);

	/**
	 * Returns the value of the '<em><b>Datetime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datetime</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datetime</em>' attribute.
	 * @see #setDatetime(Date)
	 * @see org.bimserver.models.store.StorePackage#getSystemInfo_Datetime()
	 * @model
	 * @generated
	 */
	Date getDatetime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SystemInfo#getDatetime <em>Datetime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datetime</em>' attribute.
	 * @see #getDatetime()
	 * @generated
	 */
	void setDatetime(Date value);

	/**
	 * Returns the value of the '<em><b>Osname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Osname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Osname</em>' attribute.
	 * @see #setOsname(String)
	 * @see org.bimserver.models.store.StorePackage#getSystemInfo_Osname()
	 * @model
	 * @generated
	 */
	String getOsname();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SystemInfo#getOsname <em>Osname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Osname</em>' attribute.
	 * @see #getOsname()
	 * @generated
	 */
	void setOsname(String value);

	/**
	 * Returns the value of the '<em><b>Osversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Osversion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Osversion</em>' attribute.
	 * @see #setOsversion(String)
	 * @see org.bimserver.models.store.StorePackage#getSystemInfo_Osversion()
	 * @model
	 * @generated
	 */
	String getOsversion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SystemInfo#getOsversion <em>Osversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Osversion</em>' attribute.
	 * @see #getOsversion()
	 * @generated
	 */
	void setOsversion(String value);

	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see #setUserName(String)
	 * @see org.bimserver.models.store.StorePackage#getSystemInfo_UserName()
	 * @model
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SystemInfo#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value);

	/**
	 * Returns the value of the '<em><b>User Home</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Home</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Home</em>' attribute.
	 * @see #setUserHome(String)
	 * @see org.bimserver.models.store.StorePackage#getSystemInfo_UserHome()
	 * @model
	 * @generated
	 */
	String getUserHome();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SystemInfo#getUserHome <em>User Home</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Home</em>' attribute.
	 * @see #getUserHome()
	 * @generated
	 */
	void setUserHome(String value);

	/**
	 * Returns the value of the '<em><b>User Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Dir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Dir</em>' attribute.
	 * @see #setUserDir(String)
	 * @see org.bimserver.models.store.StorePackage#getSystemInfo_UserDir()
	 * @model
	 * @generated
	 */
	String getUserDir();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SystemInfo#getUserDir <em>User Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Dir</em>' attribute.
	 * @see #getUserDir()
	 * @generated
	 */
	void setUserDir(String value);

} // SystemInfo
