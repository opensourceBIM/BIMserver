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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDataOriginEnum;
import org.bimserver.models.ifc2x3.IfcDateTimeSelect;
import org.bimserver.models.ifc2x3.IfcTimeSeries;
import org.bimserver.models.ifc2x3.IfcTimeSeriesDataTypeEnum;
import org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship;
import org.bimserver.models.ifc2x3.IfcUnit;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Time Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesImpl#getTimeSeriesDataType <em>Time Series Data Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesImpl#getDataOrigin <em>Data Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesImpl#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesImpl#getDocumentedBy <em>Documented By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTimeSeriesImpl extends IdEObjectImpl implements IfcTimeSeries
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTimeSeriesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcTimeSeries();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getStartTime()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_StartTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(IfcDateTimeSelect newStartTime)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_StartTime(), newStartTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getEndTime()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_EndTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndTime(IfcDateTimeSelect newEndTime)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_EndTime(), newEndTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeriesDataTypeEnum getTimeSeriesDataType()
	{
		return (IfcTimeSeriesDataTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_TimeSeriesDataType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeSeriesDataType(IfcTimeSeriesDataTypeEnum newTimeSeriesDataType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_TimeSeriesDataType(), newTimeSeriesDataType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDataOriginEnum getDataOrigin()
	{
		return (IfcDataOriginEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_DataOrigin(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataOrigin(IfcDataOriginEnum newDataOrigin)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_DataOrigin(), newDataOrigin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedDataOrigin()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_UserDefinedDataOrigin(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedDataOrigin(String newUserDefinedDataOrigin)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_UserDefinedDataOrigin(), newUserDefinedDataOrigin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedDataOrigin()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_UserDefinedDataOrigin());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedDataOrigin()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_UserDefinedDataOrigin());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnit getUnit()
	{
		return (IfcUnit)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_Unit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(IfcUnit newUnit)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_Unit(), newUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUnit()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_Unit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUnit()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_Unit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcTimeSeriesReferenceRelationship> getDocumentedBy()
	{
		return (EList<IfcTimeSeriesReferenceRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeries_DocumentedBy(), true);
	}

} //IfcTimeSeriesImpl
