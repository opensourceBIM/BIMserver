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
package org.bimserver.models.ifc4;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Time Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcTimeSeries#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTimeSeries#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTimeSeries#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTimeSeries#getEndTime <em>End Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTimeSeries#getTimeSeriesDataType <em>Time Series Data Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTimeSeries#getDataOrigin <em>Data Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTimeSeries#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTimeSeries#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTimeSeries#getHasExternalReference <em>Has External Reference</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTimeSeries()
 * @model
 * @generated
 */
public interface IfcTimeSeries extends IfcMetricValueSelect, IfcObjectReferenceSelect, IfcResourceObjectSelect {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTimeSeries_Name()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #setDescription(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTimeSeries_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getDescription <em>Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Description</em>' attribute is set.
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	boolean isSetDescription();

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTimeSeries_StartTime()
	 * @model
	 * @generated
	 */
	String getStartTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(String value);

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see #setEndTime(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTimeSeries_EndTime()
	 * @model
	 * @generated
	 */
	String getEndTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getEndTime <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Time</em>' attribute.
	 * @see #getEndTime()
	 * @generated
	 */
	void setEndTime(String value);

	/**
	 * Returns the value of the '<em><b>Time Series Data Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcTimeSeriesDataTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Series Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Series Data Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcTimeSeriesDataTypeEnum
	 * @see #setTimeSeriesDataType(IfcTimeSeriesDataTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTimeSeries_TimeSeriesDataType()
	 * @model
	 * @generated
	 */
	IfcTimeSeriesDataTypeEnum getTimeSeriesDataType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getTimeSeriesDataType <em>Time Series Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Series Data Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcTimeSeriesDataTypeEnum
	 * @see #getTimeSeriesDataType()
	 * @generated
	 */
	void setTimeSeriesDataType(IfcTimeSeriesDataTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Data Origin</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcDataOriginEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Origin</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDataOriginEnum
	 * @see #setDataOrigin(IfcDataOriginEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTimeSeries_DataOrigin()
	 * @model
	 * @generated
	 */
	IfcDataOriginEnum getDataOrigin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getDataOrigin <em>Data Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Origin</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDataOriginEnum
	 * @see #getDataOrigin()
	 * @generated
	 */
	void setDataOrigin(IfcDataOriginEnum value);

	/**
	 * Returns the value of the '<em><b>User Defined Data Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Data Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Data Origin</em>' attribute.
	 * @see #isSetUserDefinedDataOrigin()
	 * @see #unsetUserDefinedDataOrigin()
	 * @see #setUserDefinedDataOrigin(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTimeSeries_UserDefinedDataOrigin()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedDataOrigin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Data Origin</em>' attribute.
	 * @see #isSetUserDefinedDataOrigin()
	 * @see #unsetUserDefinedDataOrigin()
	 * @see #getUserDefinedDataOrigin()
	 * @generated
	 */
	void setUserDefinedDataOrigin(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedDataOrigin()
	 * @see #getUserDefinedDataOrigin()
	 * @see #setUserDefinedDataOrigin(String)
	 * @generated
	 */
	void unsetUserDefinedDataOrigin();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Data Origin</em>' attribute is set.
	 * @see #unsetUserDefinedDataOrigin()
	 * @see #getUserDefinedDataOrigin()
	 * @see #setUserDefinedDataOrigin(String)
	 * @generated
	 */
	boolean isSetUserDefinedDataOrigin();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' reference.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #setUnit(IfcUnit)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTimeSeries_Unit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcUnit getUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(IfcUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcUnit)
	 * @generated
	 */
	void unsetUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getUnit <em>Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unit</em>' reference is set.
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcUnit)
	 * @generated
	 */
	boolean isSetUnit();

	/**
	 * Returns the value of the '<em><b>Has External Reference</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcExternalReferenceRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has External Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has External Reference</em>' reference list.
	 * @see #isSetHasExternalReference()
	 * @see #unsetHasExternalReference()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTimeSeries_HasExternalReference()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcExternalReferenceRelationship> getHasExternalReference();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getHasExternalReference <em>Has External Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasExternalReference()
	 * @see #getHasExternalReference()
	 * @generated
	 */
	void unsetHasExternalReference();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTimeSeries#getHasExternalReference <em>Has External Reference</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has External Reference</em>' reference list is set.
	 * @see #unsetHasExternalReference()
	 * @see #getHasExternalReference()
	 * @generated
	 */
	boolean isSetHasExternalReference();

} // IfcTimeSeries
