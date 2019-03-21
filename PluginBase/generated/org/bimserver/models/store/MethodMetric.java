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
 * A representation of the model object '<em><b>Method Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.MethodMetric#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.MethodMetric#getNrCalls <em>Nr Calls</em>}</li>
 *   <li>{@link org.bimserver.models.store.MethodMetric#getLastCall <em>Last Call</em>}</li>
 *   <li>{@link org.bimserver.models.store.MethodMetric#getAverageMs <em>Average Ms</em>}</li>
 *   <li>{@link org.bimserver.models.store.MethodMetric#getShortestMs <em>Shortest Ms</em>}</li>
 *   <li>{@link org.bimserver.models.store.MethodMetric#getLongestMs <em>Longest Ms</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getMethodMetric()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface MethodMetric extends IdEObject {
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
	 * @see org.bimserver.models.store.StorePackage#getMethodMetric_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.MethodMetric#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Nr Calls</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nr Calls</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Calls</em>' attribute.
	 * @see #setNrCalls(Long)
	 * @see org.bimserver.models.store.StorePackage#getMethodMetric_NrCalls()
	 * @model
	 * @generated
	 */
	Long getNrCalls();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.MethodMetric#getNrCalls <em>Nr Calls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Calls</em>' attribute.
	 * @see #getNrCalls()
	 * @generated
	 */
	void setNrCalls(Long value);

	/**
	 * Returns the value of the '<em><b>Last Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Call</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Call</em>' attribute.
	 * @see #setLastCall(Date)
	 * @see org.bimserver.models.store.StorePackage#getMethodMetric_LastCall()
	 * @model
	 * @generated
	 */
	Date getLastCall();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.MethodMetric#getLastCall <em>Last Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Call</em>' attribute.
	 * @see #getLastCall()
	 * @generated
	 */
	void setLastCall(Date value);

	/**
	 * Returns the value of the '<em><b>Average Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Average Ms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Average Ms</em>' attribute.
	 * @see #setAverageMs(Long)
	 * @see org.bimserver.models.store.StorePackage#getMethodMetric_AverageMs()
	 * @model
	 * @generated
	 */
	Long getAverageMs();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.MethodMetric#getAverageMs <em>Average Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Average Ms</em>' attribute.
	 * @see #getAverageMs()
	 * @generated
	 */
	void setAverageMs(Long value);

	/**
	 * Returns the value of the '<em><b>Shortest Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shortest Ms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shortest Ms</em>' attribute.
	 * @see #setShortestMs(Long)
	 * @see org.bimserver.models.store.StorePackage#getMethodMetric_ShortestMs()
	 * @model
	 * @generated
	 */
	Long getShortestMs();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.MethodMetric#getShortestMs <em>Shortest Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shortest Ms</em>' attribute.
	 * @see #getShortestMs()
	 * @generated
	 */
	void setShortestMs(Long value);

	/**
	 * Returns the value of the '<em><b>Longest Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longest Ms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longest Ms</em>' attribute.
	 * @see #setLongestMs(Long)
	 * @see org.bimserver.models.store.StorePackage#getMethodMetric_LongestMs()
	 * @model
	 * @generated
	 */
	Long getLongestMs();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.MethodMetric#getLongestMs <em>Longest Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longest Ms</em>' attribute.
	 * @see #getLongestMs()
	 * @generated
	 */
	void setLongestMs(Long value);

} // MethodMetric
