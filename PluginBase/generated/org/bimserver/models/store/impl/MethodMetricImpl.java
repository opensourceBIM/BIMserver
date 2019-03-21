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
package org.bimserver.models.store.impl;

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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.MethodMetric;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.MethodMetricImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.MethodMetricImpl#getNrCalls <em>Nr Calls</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.MethodMetricImpl#getLastCall <em>Last Call</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.MethodMetricImpl#getAverageMs <em>Average Ms</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.MethodMetricImpl#getShortestMs <em>Shortest Ms</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.MethodMetricImpl#getLongestMs <em>Longest Ms</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodMetricImpl extends IdEObjectImpl implements MethodMetric {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodMetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.METHOD_METRIC;
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
	@Override
	public String getName() {
		return (String) eGet(StorePackage.Literals.METHOD_METRIC__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(StorePackage.Literals.METHOD_METRIC__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getNrCalls() {
		return (Long) eGet(StorePackage.Literals.METHOD_METRIC__NR_CALLS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNrCalls(Long newNrCalls) {
		eSet(StorePackage.Literals.METHOD_METRIC__NR_CALLS, newNrCalls);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getLastCall() {
		return (Date) eGet(StorePackage.Literals.METHOD_METRIC__LAST_CALL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastCall(Date newLastCall) {
		eSet(StorePackage.Literals.METHOD_METRIC__LAST_CALL, newLastCall);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getAverageMs() {
		return (Long) eGet(StorePackage.Literals.METHOD_METRIC__AVERAGE_MS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAverageMs(Long newAverageMs) {
		eSet(StorePackage.Literals.METHOD_METRIC__AVERAGE_MS, newAverageMs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getShortestMs() {
		return (Long) eGet(StorePackage.Literals.METHOD_METRIC__SHORTEST_MS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShortestMs(Long newShortestMs) {
		eSet(StorePackage.Literals.METHOD_METRIC__SHORTEST_MS, newShortestMs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getLongestMs() {
		return (Long) eGet(StorePackage.Literals.METHOD_METRIC__LONGEST_MS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongestMs(Long newLongestMs) {
		eSet(StorePackage.Literals.METHOD_METRIC__LONGEST_MS, newLongestMs);
	}

} //MethodMetricImpl
