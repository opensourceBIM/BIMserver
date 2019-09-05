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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcBenchmarkEnum;
import org.bimserver.models.ifc4.IfcMetric;
import org.bimserver.models.ifc4.IfcMetricValueSelect;
import org.bimserver.models.ifc4.IfcReference;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMetricImpl#getBenchmark <em>Benchmark</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMetricImpl#getValueSource <em>Value Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMetricImpl#getDataValue <em>Data Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMetricImpl#getReferencePath <em>Reference Path</em>}</li>
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
		return Ifc4Package.Literals.IFC_METRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBenchmarkEnum getBenchmark() {
		return (IfcBenchmarkEnum) eGet(Ifc4Package.Literals.IFC_METRIC__BENCHMARK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBenchmark(IfcBenchmarkEnum newBenchmark) {
		eSet(Ifc4Package.Literals.IFC_METRIC__BENCHMARK, newBenchmark);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValueSource() {
		return (String) eGet(Ifc4Package.Literals.IFC_METRIC__VALUE_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValueSource(String newValueSource) {
		eSet(Ifc4Package.Literals.IFC_METRIC__VALUE_SOURCE, newValueSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetValueSource() {
		eUnset(Ifc4Package.Literals.IFC_METRIC__VALUE_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetValueSource() {
		return eIsSet(Ifc4Package.Literals.IFC_METRIC__VALUE_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMetricValueSelect getDataValue() {
		return (IfcMetricValueSelect) eGet(Ifc4Package.Literals.IFC_METRIC__DATA_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataValue(IfcMetricValueSelect newDataValue) {
		eSet(Ifc4Package.Literals.IFC_METRIC__DATA_VALUE, newDataValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDataValue() {
		eUnset(Ifc4Package.Literals.IFC_METRIC__DATA_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDataValue() {
		return eIsSet(Ifc4Package.Literals.IFC_METRIC__DATA_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReference getReferencePath() {
		return (IfcReference) eGet(Ifc4Package.Literals.IFC_METRIC__REFERENCE_PATH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferencePath(IfcReference newReferencePath) {
		eSet(Ifc4Package.Literals.IFC_METRIC__REFERENCE_PATH, newReferencePath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferencePath() {
		eUnset(Ifc4Package.Literals.IFC_METRIC__REFERENCE_PATH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferencePath() {
		return eIsSet(Ifc4Package.Literals.IFC_METRIC__REFERENCE_PATH);
	}

} //IfcMetricImpl
