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

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Irregular Time Series Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIrregularTimeSeriesValue#getTimeStamp <em>Time Stamp</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIrregularTimeSeriesValue#getListValues <em>List Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIrregularTimeSeriesValue()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcIrregularTimeSeriesValue extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Time Stamp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Stamp</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Stamp</em>' reference.
	 * @see #isSetTimeStamp()
	 * @see #unsetTimeStamp()
	 * @see #setTimeStamp(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIrregularTimeSeriesValue_TimeStamp()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getTimeStamp();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIrregularTimeSeriesValue#getTimeStamp <em>Time Stamp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Stamp</em>' reference.
	 * @see #isSetTimeStamp()
	 * @see #unsetTimeStamp()
	 * @see #getTimeStamp()
	 * @generated
	 */
	void setTimeStamp(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIrregularTimeSeriesValue#getTimeStamp <em>Time Stamp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeStamp()
	 * @see #getTimeStamp()
	 * @see #setTimeStamp(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetTimeStamp();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIrregularTimeSeriesValue#getTimeStamp <em>Time Stamp</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Stamp</em>' reference is set.
	 * @see #unsetTimeStamp()
	 * @see #getTimeStamp()
	 * @see #setTimeStamp(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetTimeStamp();

	/**
	 * Returns the value of the '<em><b>List Values</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List Values</em>' reference list.
	 * @see #isSetListValues()
	 * @see #unsetListValues()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIrregularTimeSeriesValue_ListValues()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcValue> getListValues();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIrregularTimeSeriesValue#getListValues <em>List Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetListValues()
	 * @see #getListValues()
	 * @generated
	 */
	void unsetListValues();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIrregularTimeSeriesValue#getListValues <em>List Values</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>List Values</em>' reference list is set.
	 * @see #unsetListValues()
	 * @see #getListValues()
	 * @generated
	 */
	boolean isSetListValues();

} // IfcIrregularTimeSeriesValue
