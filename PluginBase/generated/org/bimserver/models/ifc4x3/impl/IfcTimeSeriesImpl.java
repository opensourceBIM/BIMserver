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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcDataOriginEnum;
import org.bimserver.models.ifc4x3.IfcExternalReferenceRelationship;
import org.bimserver.models.ifc4x3.IfcTimeSeries;
import org.bimserver.models.ifc4x3.IfcTimeSeriesDataTypeEnum;
import org.bimserver.models.ifc4x3.IfcUnit;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Time Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTimeSeriesImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTimeSeriesImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTimeSeriesImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTimeSeriesImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTimeSeriesImpl#getTimeSeriesDataType <em>Time Series Data Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTimeSeriesImpl#getDataOrigin <em>Data Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTimeSeriesImpl#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTimeSeriesImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTimeSeriesImpl#getHasExternalReference <em>Has External Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTimeSeriesImpl extends IdEObjectImpl implements IfcTimeSeries {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTimeSeriesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcTimeSeries();
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
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartTime() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_StartTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartTime(String newStartTime) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_StartTime(), newStartTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEndTime() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_EndTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndTime(String newEndTime) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_EndTime(), newEndTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTimeSeriesDataTypeEnum getTimeSeriesDataType() {
		return (IfcTimeSeriesDataTypeEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_TimeSeriesDataType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeSeriesDataType(IfcTimeSeriesDataTypeEnum newTimeSeriesDataType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_TimeSeriesDataType(), newTimeSeriesDataType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDataOriginEnum getDataOrigin() {
		return (IfcDataOriginEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_DataOrigin(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataOrigin(IfcDataOriginEnum newDataOrigin) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_DataOrigin(), newDataOrigin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedDataOrigin() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_UserDefinedDataOrigin(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedDataOrigin(String newUserDefinedDataOrigin) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_UserDefinedDataOrigin(), newUserDefinedDataOrigin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedDataOrigin() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_UserDefinedDataOrigin());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedDataOrigin() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_UserDefinedDataOrigin());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcUnit getUnit() {
		return (IfcUnit) eGet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_Unit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnit(IfcUnit newUnit) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_Unit(), newUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUnit() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_Unit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUnit() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_Unit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcExternalReferenceRelationship> getHasExternalReference() {
		return (EList<IfcExternalReferenceRelationship>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcTimeSeries_HasExternalReference(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasExternalReference() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_HasExternalReference());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasExternalReference() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTimeSeries_HasExternalReference());
	}

} //IfcTimeSeriesImpl
