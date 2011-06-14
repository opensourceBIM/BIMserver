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
import org.bimserver.models.ifc2x3.IfcRegularTimeSeries;
import org.bimserver.models.ifc2x3.IfcTimeSeriesValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Regular Time Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRegularTimeSeriesImpl#getTimeStep <em>Time Step</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRegularTimeSeriesImpl#getTimeStepAsString <em>Time Step As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRegularTimeSeriesImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRegularTimeSeriesImpl extends IfcTimeSeriesImpl implements IfcRegularTimeSeries
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRegularTimeSeriesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRegularTimeSeries();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTimeStep()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRegularTimeSeries_TimeStep(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeStep(float newTimeStep)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRegularTimeSeries_TimeStep(), newTimeStep);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimeStepAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRegularTimeSeries_TimeStepAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeStepAsString(String newTimeStepAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRegularTimeSeries_TimeStepAsString(), newTimeStepAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcTimeSeriesValue> getValues()
	{
		return (EList<IfcTimeSeriesValue>)eGet(Ifc2x3Package.eINSTANCE.getIfcRegularTimeSeries_Values(), true);
	}

} //IfcRegularTimeSeriesImpl
