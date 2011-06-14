/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcBenchmarkEnum;
import org.bimserver.models.ifc2x3.IfcMetric;
import org.bimserver.models.ifc2x3.IfcMetricValueSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMetricImpl#getBenchmark <em>Benchmark</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMetricImpl#getValueSource <em>Value Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMetricImpl#getDataValue <em>Data Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMetricImpl extends IfcConstraintImpl implements IfcMetric
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMetricImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.eINSTANCE.getIfcMetric();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBenchmarkEnum getBenchmark()
	{
		return (IfcBenchmarkEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcMetric_Benchmark(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBenchmark(IfcBenchmarkEnum newBenchmark)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMetric_Benchmark(), newBenchmark);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueSource()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMetric_ValueSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueSource(String newValueSource)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMetric_ValueSource(), newValueSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValueSource()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMetric_ValueSource());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValueSource()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMetric_ValueSource());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMetricValueSelect getDataValue()
	{
		return (IfcMetricValueSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcMetric_DataValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataValue(IfcMetricValueSelect newDataValue)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMetric_DataValue(), newDataValue);
	}

} //IfcMetricImpl
