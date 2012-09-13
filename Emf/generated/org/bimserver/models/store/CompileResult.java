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
 * A representation of the model object '<em><b>Compile Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.CompileResult#getCompileOke <em>Compile Oke</em>}</li>
 *   <li>{@link org.bimserver.models.store.CompileResult#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link org.bimserver.models.store.CompileResult#getErrors <em>Errors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getCompileResult()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface CompileResult extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Compile Oke</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compile Oke</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compile Oke</em>' attribute.
	 * @see #setCompileOke(Boolean)
	 * @see org.bimserver.models.store.StorePackage#getCompileResult_CompileOke()
	 * @model
	 * @generated
	 */
	Boolean getCompileOke();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.CompileResult#getCompileOke <em>Compile Oke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compile Oke</em>' attribute.
	 * @see #getCompileOke()
	 * @generated
	 */
	void setCompileOke(Boolean value);

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
	 * @see org.bimserver.models.store.StorePackage#getCompileResult_Warnings()
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
	 * @see org.bimserver.models.store.StorePackage#getCompileResult_Errors()
	 * @model
	 * @generated
	 */
	EList<String> getErrors();

} // CompileResult
