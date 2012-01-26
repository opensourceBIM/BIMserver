/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Time Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getEndTime <em>End Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getTimeSeriesDataType <em>Time Series Data Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDataOrigin <em>Data Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDocumentedBy <em>Documented By</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeries()
 * @model
 * @generated
 */
public interface IfcTimeSeries extends IfcMetricValueSelect, IfcObjectReferenceSelect {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeries_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeries_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Start Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' reference.
	 * @see #isSetStartTime()
	 * @see #unsetStartTime()
	 * @see #setStartTime(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeries_StartTime()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getStartTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getStartTime <em>Start Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' reference.
	 * @see #isSetStartTime()
	 * @see #unsetStartTime()
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getStartTime <em>Start Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartTime()
	 * @see #getStartTime()
	 * @see #setStartTime(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetStartTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getStartTime <em>Start Time</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Time</em>' reference is set.
	 * @see #unsetStartTime()
	 * @see #getStartTime()
	 * @see #setStartTime(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetStartTime();

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Time</em>' reference.
	 * @see #isSetEndTime()
	 * @see #unsetEndTime()
	 * @see #setEndTime(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeries_EndTime()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getEndTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getEndTime <em>End Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Time</em>' reference.
	 * @see #isSetEndTime()
	 * @see #unsetEndTime()
	 * @see #getEndTime()
	 * @generated
	 */
	void setEndTime(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getEndTime <em>End Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndTime()
	 * @see #getEndTime()
	 * @see #setEndTime(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetEndTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getEndTime <em>End Time</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>End Time</em>' reference is set.
	 * @see #unsetEndTime()
	 * @see #getEndTime()
	 * @see #setEndTime(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetEndTime();

	/**
	 * Returns the value of the '<em><b>Time Series Data Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcTimeSeriesDataTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Series Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Series Data Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTimeSeriesDataTypeEnum
	 * @see #isSetTimeSeriesDataType()
	 * @see #unsetTimeSeriesDataType()
	 * @see #setTimeSeriesDataType(IfcTimeSeriesDataTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeries_TimeSeriesDataType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTimeSeriesDataTypeEnum getTimeSeriesDataType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getTimeSeriesDataType <em>Time Series Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Series Data Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTimeSeriesDataTypeEnum
	 * @see #isSetTimeSeriesDataType()
	 * @see #unsetTimeSeriesDataType()
	 * @see #getTimeSeriesDataType()
	 * @generated
	 */
	void setTimeSeriesDataType(IfcTimeSeriesDataTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getTimeSeriesDataType <em>Time Series Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeSeriesDataType()
	 * @see #getTimeSeriesDataType()
	 * @see #setTimeSeriesDataType(IfcTimeSeriesDataTypeEnum)
	 * @generated
	 */
	void unsetTimeSeriesDataType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getTimeSeriesDataType <em>Time Series Data Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Series Data Type</em>' attribute is set.
	 * @see #unsetTimeSeriesDataType()
	 * @see #getTimeSeriesDataType()
	 * @see #setTimeSeriesDataType(IfcTimeSeriesDataTypeEnum)
	 * @generated
	 */
	boolean isSetTimeSeriesDataType();

	/**
	 * Returns the value of the '<em><b>Data Origin</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcDataOriginEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Origin</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcDataOriginEnum
	 * @see #isSetDataOrigin()
	 * @see #unsetDataOrigin()
	 * @see #setDataOrigin(IfcDataOriginEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeries_DataOrigin()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDataOriginEnum getDataOrigin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDataOrigin <em>Data Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Origin</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcDataOriginEnum
	 * @see #isSetDataOrigin()
	 * @see #unsetDataOrigin()
	 * @see #getDataOrigin()
	 * @generated
	 */
	void setDataOrigin(IfcDataOriginEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDataOrigin <em>Data Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDataOrigin()
	 * @see #getDataOrigin()
	 * @see #setDataOrigin(IfcDataOriginEnum)
	 * @generated
	 */
	void unsetDataOrigin();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDataOrigin <em>Data Origin</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Data Origin</em>' attribute is set.
	 * @see #unsetDataOrigin()
	 * @see #getDataOrigin()
	 * @see #setDataOrigin(IfcDataOriginEnum)
	 * @generated
	 */
	boolean isSetDataOrigin();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeries_UserDefinedDataOrigin()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedDataOrigin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedDataOrigin()
	 * @see #getUserDefinedDataOrigin()
	 * @see #setUserDefinedDataOrigin(String)
	 * @generated
	 */
	void unsetUserDefinedDataOrigin();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeries_Unit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcUnit getUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getUnit <em>Unit</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcUnit)
	 * @generated
	 */
	void unsetUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getUnit <em>Unit</em>}' reference is set.
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
	 * Returns the value of the '<em><b>Documented By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship#getReferencedTimeSeries <em>Referenced Time Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documented By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documented By</em>' reference list.
	 * @see #isSetDocumentedBy()
	 * @see #unsetDocumentedBy()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeries_DocumentedBy()
	 * @see org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship#getReferencedTimeSeries
	 * @model opposite="ReferencedTimeSeries" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcTimeSeriesReferenceRelationship> getDocumentedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDocumentedBy <em>Documented By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDocumentedBy()
	 * @see #getDocumentedBy()
	 * @generated
	 */
	void unsetDocumentedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDocumentedBy <em>Documented By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Documented By</em>' reference list is set.
	 * @see #unsetDocumentedBy()
	 * @see #getDocumentedBy()
	 * @generated
	 */
	boolean isSetDocumentedBy();

} // IfcTimeSeries
