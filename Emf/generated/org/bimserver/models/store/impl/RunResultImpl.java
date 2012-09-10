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
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.store.RunResult;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Run Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.RunResultImpl#getRunOke <em>Run Oke</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RunResultImpl#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RunResultImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RunResultImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RunResultImpl#getDownloadId <em>Download Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RunResultImpl extends IdEObjectImpl implements RunResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RunResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.RUN_RESULT;
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
	public Boolean getRunOke() {
		return (Boolean) eGet(StorePackage.Literals.RUN_RESULT__RUN_OKE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunOke(Boolean newRunOke) {
		eSet(StorePackage.Literals.RUN_RESULT__RUN_OKE, newRunOke);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getWarnings() {
		return (EList<String>) eGet(StorePackage.Literals.RUN_RESULT__WARNINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getErrors() {
		return (EList<String>) eGet(StorePackage.Literals.RUN_RESULT__ERRORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutput() {
		return (String) eGet(StorePackage.Literals.RUN_RESULT__OUTPUT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(String newOutput) {
		eSet(StorePackage.Literals.RUN_RESULT__OUTPUT, newOutput);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getDownloadId() {
		return (Integer) eGet(StorePackage.Literals.RUN_RESULT__DOWNLOAD_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDownloadId(Integer newDownloadId) {
		eSet(StorePackage.Literals.RUN_RESULT__DOWNLOAD_ID, newDownloadId);
	}

} //RunResultImpl
