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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Lag Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcLagTime#getLagValue <em>Lag Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcLagTime#getDurationType <em>Duration Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcLagTime()
 * @model
 * @generated
 */
public interface IfcLagTime extends IfcSchedulingTime {
	/**
	 * Returns the value of the '<em><b>Lag Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lag Value</em>' reference.
	 * @see #setLagValue(IfcTimeOrRatioSelect)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcLagTime_LagValue()
	 * @model
	 * @generated
	 */
	IfcTimeOrRatioSelect getLagValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcLagTime#getLagValue <em>Lag Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lag Value</em>' reference.
	 * @see #getLagValue()
	 * @generated
	 */
	void setLagValue(IfcTimeOrRatioSelect value);

	/**
	 * Returns the value of the '<em><b>Duration Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcTaskDurationEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcTaskDurationEnum
	 * @see #setDurationType(IfcTaskDurationEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcLagTime_DurationType()
	 * @model
	 * @generated
	 */
	IfcTaskDurationEnum getDurationType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcLagTime#getDurationType <em>Duration Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcTaskDurationEnum
	 * @see #getDurationType()
	 * @generated
	 */
	void setDurationType(IfcTaskDurationEnum value);

} // IfcLagTime
