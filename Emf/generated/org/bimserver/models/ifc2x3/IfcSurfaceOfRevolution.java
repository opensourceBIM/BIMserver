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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Surface Of Revolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceOfRevolution#getAxisPosition <em>Axis Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceOfRevolution()
 * @model
 * @generated
 */
public interface IfcSurfaceOfRevolution extends IfcSweptSurface {
	/**
	 * Returns the value of the '<em><b>Axis Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis Position</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis Position</em>' reference.
	 * @see #isSetAxisPosition()
	 * @see #unsetAxisPosition()
	 * @see #setAxisPosition(IfcAxis1Placement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceOfRevolution_AxisPosition()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAxis1Placement getAxisPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfRevolution#getAxisPosition <em>Axis Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis Position</em>' reference.
	 * @see #isSetAxisPosition()
	 * @see #unsetAxisPosition()
	 * @see #getAxisPosition()
	 * @generated
	 */
	void setAxisPosition(IfcAxis1Placement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfRevolution#getAxisPosition <em>Axis Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAxisPosition()
	 * @see #getAxisPosition()
	 * @see #setAxisPosition(IfcAxis1Placement)
	 * @generated
	 */
	void unsetAxisPosition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfRevolution#getAxisPosition <em>Axis Position</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Axis Position</em>' reference is set.
	 * @see #unsetAxisPosition()
	 * @see #getAxisPosition()
	 * @see #setAxisPosition(IfcAxis1Placement)
	 * @generated
	 */
	boolean isSetAxisPosition();

} // IfcSurfaceOfRevolution
