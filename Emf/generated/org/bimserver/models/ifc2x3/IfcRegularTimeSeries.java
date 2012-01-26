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
 * A representation of the model object '<em><b>Ifc Regular Time Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getTimeStep <em>Time Step</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getTimeStepAsString <em>Time Step As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRegularTimeSeries()
 * @model
 * @generated
 */
public interface IfcRegularTimeSeries extends IfcTimeSeries {
	/**
	 * Returns the value of the '<em><b>Time Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Step</em>' attribute.
	 * @see #isSetTimeStep()
	 * @see #unsetTimeStep()
	 * @see #setTimeStep(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRegularTimeSeries_TimeStep()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTimeStep();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getTimeStep <em>Time Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Step</em>' attribute.
	 * @see #isSetTimeStep()
	 * @see #unsetTimeStep()
	 * @see #getTimeStep()
	 * @generated
	 */
	void setTimeStep(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getTimeStep <em>Time Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeStep()
	 * @see #getTimeStep()
	 * @see #setTimeStep(double)
	 * @generated
	 */
	void unsetTimeStep();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getTimeStep <em>Time Step</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Step</em>' attribute is set.
	 * @see #unsetTimeStep()
	 * @see #getTimeStep()
	 * @see #setTimeStep(double)
	 * @generated
	 */
	boolean isSetTimeStep();

	/**
	 * Returns the value of the '<em><b>Time Step As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Step As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Step As String</em>' attribute.
	 * @see #isSetTimeStepAsString()
	 * @see #unsetTimeStepAsString()
	 * @see #setTimeStepAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRegularTimeSeries_TimeStepAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTimeStepAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getTimeStepAsString <em>Time Step As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Step As String</em>' attribute.
	 * @see #isSetTimeStepAsString()
	 * @see #unsetTimeStepAsString()
	 * @see #getTimeStepAsString()
	 * @generated
	 */
	void setTimeStepAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getTimeStepAsString <em>Time Step As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeStepAsString()
	 * @see #getTimeStepAsString()
	 * @see #setTimeStepAsString(String)
	 * @generated
	 */
	void unsetTimeStepAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getTimeStepAsString <em>Time Step As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Step As String</em>' attribute is set.
	 * @see #unsetTimeStepAsString()
	 * @see #getTimeStepAsString()
	 * @see #setTimeStepAsString(String)
	 * @generated
	 */
	boolean isSetTimeStepAsString();

	/**
	 * Returns the value of the '<em><b>Values</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcTimeSeriesValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' reference list.
	 * @see #isSetValues()
	 * @see #unsetValues()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRegularTimeSeries_Values()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcTimeSeriesValue> getValues();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getValues <em>Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValues()
	 * @see #getValues()
	 * @generated
	 */
	void unsetValues();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getValues <em>Values</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Values</em>' reference list is set.
	 * @see #unsetValues()
	 * @see #getValues()
	 * @generated
	 */
	boolean isSetValues();

} // IfcRegularTimeSeries
