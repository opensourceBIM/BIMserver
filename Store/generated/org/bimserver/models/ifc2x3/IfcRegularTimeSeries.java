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
public interface IfcRegularTimeSeries extends IfcTimeSeries
{
	/**
	 * Returns the value of the '<em><b>Time Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Step</em>' attribute.
	 * @see #setTimeStep(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRegularTimeSeries_TimeStep()
	 * @model
	 * @generated
	 */
	float getTimeStep();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getTimeStep <em>Time Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Step</em>' attribute.
	 * @see #getTimeStep()
	 * @generated
	 */
	void setTimeStep(float value);

	/**
	 * Returns the value of the '<em><b>Time Step As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Step As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Step As String</em>' attribute.
	 * @see #setTimeStepAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRegularTimeSeries_TimeStepAsString()
	 * @model
	 * @generated
	 */
	String getTimeStepAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRegularTimeSeries#getTimeStepAsString <em>Time Step As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Step As String</em>' attribute.
	 * @see #getTimeStepAsString()
	 * @generated
	 */
	void setTimeStepAsString(String value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRegularTimeSeries_Values()
	 * @model
	 * @generated
	 */
	EList<IfcTimeSeriesValue> getValues();

} // IfcRegularTimeSeries
