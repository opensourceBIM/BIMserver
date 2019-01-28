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
package org.bimserver.models.log;

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

import org.bimserver.models.store.NotifictionResultEnum;
import org.bimserver.models.store.Service;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Service Called</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.log.RemoteServiceCalled#getService <em>Service</em>}</li>
 *   <li>{@link org.bimserver.models.log.RemoteServiceCalled#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.log.RemoteServiceCalled#getPercentage <em>Percentage</em>}</li>
 *   <li>{@link org.bimserver.models.log.RemoteServiceCalled#getInfos <em>Infos</em>}</li>
 *   <li>{@link org.bimserver.models.log.RemoteServiceCalled#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link org.bimserver.models.log.RemoteServiceCalled#getErrors <em>Errors</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.log.LogPackage#getRemoteServiceCalled()
 * @model
 * @generated
 */
public interface RemoteServiceCalled extends LogAction {
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
	 * @see org.bimserver.models.log.LogPackage#getRemoteServiceCalled_Service()
	 * @model
	 * @generated
	 */
	Service getService();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.RemoteServiceCalled#getService <em>Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(Service value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.NotifictionResultEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.NotifictionResultEnum
	 * @see #setState(NotifictionResultEnum)
	 * @see org.bimserver.models.log.LogPackage#getRemoteServiceCalled_State()
	 * @model
	 * @generated
	 */
	NotifictionResultEnum getState();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.RemoteServiceCalled#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.NotifictionResultEnum
	 * @see #getState()
	 * @generated
	 */
	void setState(NotifictionResultEnum value);

	/**
	 * Returns the value of the '<em><b>Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percentage</em>' attribute.
	 * @see #setPercentage(int)
	 * @see org.bimserver.models.log.LogPackage#getRemoteServiceCalled_Percentage()
	 * @model
	 * @generated
	 */
	int getPercentage();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.RemoteServiceCalled#getPercentage <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percentage</em>' attribute.
	 * @see #getPercentage()
	 * @generated
	 */
	void setPercentage(int value);

	/**
	 * Returns the value of the '<em><b>Infos</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infos</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infos</em>' attribute list.
	 * @see org.bimserver.models.log.LogPackage#getRemoteServiceCalled_Infos()
	 * @model
	 * @generated
	 */
	EList<String> getInfos();

	/**
	 * Returns the value of the '<em><b>Warnings</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warnings</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warnings</em>' attribute list.
	 * @see org.bimserver.models.log.LogPackage#getRemoteServiceCalled_Warnings()
	 * @model
	 * @generated
	 */
	EList<String> getWarnings();

	/**
	 * Returns the value of the '<em><b>Errors</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Errors</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors</em>' attribute list.
	 * @see org.bimserver.models.log.LogPackage#getRemoteServiceCalled_Errors()
	 * @model
	 * @generated
	 */
	EList<String> getErrors();

} // RemoteServiceCalled
