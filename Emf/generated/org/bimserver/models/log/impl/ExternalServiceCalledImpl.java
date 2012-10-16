/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.log.impl;

import org.bimserver.models.log.ExternalServiceCalled;
import org.bimserver.models.log.LogPackage;

import org.bimserver.models.store.NotifictionResultEnum;
import org.bimserver.models.store.Service;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Service Called</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.log.impl.ExternalServiceCalledImpl#getService <em>Service</em>}</li>
 *   <li>{@link org.bimserver.models.log.impl.ExternalServiceCalledImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.log.impl.ExternalServiceCalledImpl#getPercentage <em>Percentage</em>}</li>
 *   <li>{@link org.bimserver.models.log.impl.ExternalServiceCalledImpl#getInfos <em>Infos</em>}</li>
 *   <li>{@link org.bimserver.models.log.impl.ExternalServiceCalledImpl#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link org.bimserver.models.log.impl.ExternalServiceCalledImpl#getErrors <em>Errors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalServiceCalledImpl extends LogActionImpl implements ExternalServiceCalled {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalServiceCalledImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.EXTERNAL_SERVICE_CALLED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getService() {
		return (Service) eGet(LogPackage.Literals.EXTERNAL_SERVICE_CALLED__SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(Service newService) {
		eSet(LogPackage.Literals.EXTERNAL_SERVICE_CALLED__SERVICE, newService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotifictionResultEnum getState() {
		return (NotifictionResultEnum) eGet(LogPackage.Literals.EXTERNAL_SERVICE_CALLED__STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(NotifictionResultEnum newState) {
		eSet(LogPackage.Literals.EXTERNAL_SERVICE_CALLED__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPercentage() {
		return (Integer) eGet(LogPackage.Literals.EXTERNAL_SERVICE_CALLED__PERCENTAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercentage(int newPercentage) {
		eSet(LogPackage.Literals.EXTERNAL_SERVICE_CALLED__PERCENTAGE, newPercentage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getInfos() {
		return (EList<String>) eGet(LogPackage.Literals.EXTERNAL_SERVICE_CALLED__INFOS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getWarnings() {
		return (EList<String>) eGet(LogPackage.Literals.EXTERNAL_SERVICE_CALLED__WARNINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getErrors() {
		return (EList<String>) eGet(LogPackage.Literals.EXTERNAL_SERVICE_CALLED__ERRORS, true);
	}

} //ExternalServiceCalledImpl
