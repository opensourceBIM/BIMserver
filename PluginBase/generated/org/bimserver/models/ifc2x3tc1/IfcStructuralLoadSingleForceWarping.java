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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcStructuralLoadSingleForceWarping extends IfcStructuralLoadSingleForce {
	/**
	 * Returns the value of the '<em><b>Warping Moment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warping Moment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warping Moment</em>' attribute.
	 * @see #isSetWarpingMoment()
	 * @see #unsetWarpingMoment()
	 * @see #setWarpingMoment(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadSingleForceWarping_WarpingMoment()
	 * @model unsettable="true"
	 * @generated
	 */
	double getWarpingMoment();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadSingleForceWarping#getWarpingMoment <em>Warping Moment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warping Moment</em>' attribute.
	 * @see #isSetWarpingMoment()
	 * @see #unsetWarpingMoment()
	 * @see #getWarpingMoment()
	 * @generated
	 */
	void setWarpingMoment(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadSingleForceWarping#getWarpingMoment <em>Warping Moment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWarpingMoment()
	 * @see #getWarpingMoment()
	 * @see #setWarpingMoment(double)
	 * @generated
	 */
	void unsetWarpingMoment();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadSingleForceWarping#getWarpingMoment <em>Warping Moment</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Warping Moment</em>' attribute is set.
	 * @see #unsetWarpingMoment()
	 * @see #getWarpingMoment()
	 * @see #setWarpingMoment(double)
	 * @generated
	 */
	boolean isSetWarpingMoment();

	/**
	 * Returns the value of the '<em><b>Warping Moment As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warping Moment As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warping Moment As String</em>' attribute.
	 * @see #isSetWarpingMomentAsString()
	 * @see #unsetWarpingMomentAsString()
	 * @see #setWarpingMomentAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWarpingMomentAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadSingleForceWarping#getWarpingMomentAsString <em>Warping Moment As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warping Moment As String</em>' attribute.
	 * @see #isSetWarpingMomentAsString()
	 * @see #unsetWarpingMomentAsString()
	 * @see #getWarpingMomentAsString()
	 * @generated
	 */
	void setWarpingMomentAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadSingleForceWarping#getWarpingMomentAsString <em>Warping Moment As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWarpingMomentAsString()
	 * @see #getWarpingMomentAsString()
	 * @see #setWarpingMomentAsString(String)
	 * @generated
	 */
	void unsetWarpingMomentAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadSingleForceWarping#getWarpingMomentAsString <em>Warping Moment As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Warping Moment As String</em>' attribute is set.
	 * @see #unsetWarpingMomentAsString()
	 * @see #getWarpingMomentAsString()
	 * @see #setWarpingMomentAsString(String)
	 * @generated
	 */
	boolean isSetWarpingMomentAsString();

} // IfcStructuralLoadSingleForceWarping
