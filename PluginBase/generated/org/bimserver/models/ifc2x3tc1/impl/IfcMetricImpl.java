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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcBenchmarkEnum;
import org.bimserver.models.ifc2x3tc1.IfcMetric;
import org.bimserver.models.ifc2x3tc1.IfcMetricValueSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMetricImpl#getBenchmark <em>Benchmark</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMetricImpl#getValueSource <em>Value Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMetricImpl#getDataValue <em>Data Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMetricImpl extends IfcConstraintImpl implements IfcMetric {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_METRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBenchmarkEnum getBenchmark() {
		return (IfcBenchmarkEnum) eGet(Ifc2x3tc1Package.Literals.IFC_METRIC__BENCHMARK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBenchmark(IfcBenchmarkEnum newBenchmark) {
		eSet(Ifc2x3tc1Package.Literals.IFC_METRIC__BENCHMARK, newBenchmark);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueSource() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_METRIC__VALUE_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueSource(String newValueSource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_METRIC__VALUE_SOURCE, newValueSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValueSource() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_METRIC__VALUE_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValueSource() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_METRIC__VALUE_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMetricValueSelect getDataValue() {
		return (IfcMetricValueSelect) eGet(Ifc2x3tc1Package.Literals.IFC_METRIC__DATA_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataValue(IfcMetricValueSelect newDataValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_METRIC__DATA_VALUE, newDataValue);
	}

} //IfcMetricImpl
