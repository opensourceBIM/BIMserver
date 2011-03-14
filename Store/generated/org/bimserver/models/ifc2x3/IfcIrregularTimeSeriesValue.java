/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
	 * @see #setTimeStamp(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIrregularTimeSeriesValue_TimeStamp()
	 * @model
	 * @generated
	 */
	IfcDateTimeSelect getTimeStamp();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIrregularTimeSeriesValue#getTimeStamp <em>Time Stamp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Stamp</em>' reference.
	 * @see #getTimeStamp()
	 * @generated
	 */
	void setTimeStamp(IfcDateTimeSelect value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIrregularTimeSeriesValue_ListValues()
	 * @model
	 * @generated
	 */
	EList<IfcValue> getListValues();

} // IfcIrregularTimeSeriesValue
