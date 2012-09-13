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
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Run Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.RunResult#getRunOke <em>Run Oke</em>}</li>
 *   <li>{@link org.bimserver.models.store.RunResult#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link org.bimserver.models.store.RunResult#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.bimserver.models.store.RunResult#getOutput <em>Output</em>}</li>
 *   <li>{@link org.bimserver.models.store.RunResult#getDownloadId <em>Download Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getRunResult()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface RunResult extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Run Oke</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run Oke</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run Oke</em>' attribute.
	 * @see #setRunOke(Boolean)
	 * @see org.bimserver.models.store.StorePackage#getRunResult_RunOke()
	 * @model
	 * @generated
	 */
	Boolean getRunOke();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.RunResult#getRunOke <em>Run Oke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run Oke</em>' attribute.
	 * @see #getRunOke()
	 * @generated
	 */
	void setRunOke(Boolean value);

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
	 * @see org.bimserver.models.store.StorePackage#getRunResult_Warnings()
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
	 * @see org.bimserver.models.store.StorePackage#getRunResult_Errors()
	 * @model
	 * @generated
	 */
	EList<String> getErrors();

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' attribute.
	 * @see #setOutput(String)
	 * @see org.bimserver.models.store.StorePackage#getRunResult_Output()
	 * @model
	 * @generated
	 */
	String getOutput();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.RunResult#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(String value);

	/**
	 * Returns the value of the '<em><b>Download Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Download Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Download Id</em>' attribute.
	 * @see #setDownloadId(Integer)
	 * @see org.bimserver.models.store.StorePackage#getRunResult_DownloadId()
	 * @model
	 * @generated
	 */
	Integer getDownloadId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.RunResult#getDownloadId <em>Download Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Download Id</em>' attribute.
	 * @see #getDownloadId()
	 * @generated
	 */
	void setDownloadId(Integer value);

} // RunResult
