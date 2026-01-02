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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcBenchmarkEnum;
import org.bimserver.models.ifc4x3.IfcMetric;
import org.bimserver.models.ifc4x3.IfcMetricValueSelect;
import org.bimserver.models.ifc4x3.IfcReference;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMetricImpl#getBenchmark <em>Benchmark</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMetricImpl#getValueSource <em>Value Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMetricImpl#getDataValue <em>Data Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMetricImpl#getReferencePath <em>Reference Path</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcMetric();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBenchmarkEnum getBenchmark() {
		return (IfcBenchmarkEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcMetric_Benchmark(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBenchmark(IfcBenchmarkEnum newBenchmark) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMetric_Benchmark(), newBenchmark);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValueSource() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMetric_ValueSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValueSource(String newValueSource) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMetric_ValueSource(), newValueSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetValueSource() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMetric_ValueSource());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetValueSource() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMetric_ValueSource());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMetricValueSelect getDataValue() {
		return (IfcMetricValueSelect) eGet(Ifc4x3Package.eINSTANCE.getIfcMetric_DataValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataValue(IfcMetricValueSelect newDataValue) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMetric_DataValue(), newDataValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDataValue() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMetric_DataValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDataValue() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMetric_DataValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReference getReferencePath() {
		return (IfcReference) eGet(Ifc4x3Package.eINSTANCE.getIfcMetric_ReferencePath(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferencePath(IfcReference newReferencePath) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMetric_ReferencePath(), newReferencePath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferencePath() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMetric_ReferencePath());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferencePath() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMetric_ReferencePath());
	}

} //IfcMetricImpl
