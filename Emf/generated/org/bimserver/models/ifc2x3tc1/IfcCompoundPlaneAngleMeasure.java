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
package org.bimserver.models.ifc2x3tc1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Compound Plane Angle Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCompoundPlaneAngleMeasure#getWrappedValue <em>Wrapped Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCompoundPlaneAngleMeasure()
 * @model
 * @generated
 */
public interface IfcCompoundPlaneAngleMeasure extends WrappedValue, IfcDerivedMeasureValue {
	/**
	 * Returns the value of the '<em><b>Wrapped Value</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wrapped Value</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wrapped Value</em>' attribute list.
	 * @see #isSetWrappedValue()
	 * @see #unsetWrappedValue()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCompoundPlaneAngleMeasure_WrappedValue()
	 * @model unsettable="true" upper="4"
	 * @generated
	 */
	EList<Integer> getWrappedValue();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCompoundPlaneAngleMeasure#getWrappedValue <em>Wrapped Value</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWrappedValue()
	 * @see #getWrappedValue()
	 * @generated
	 */
	void unsetWrappedValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCompoundPlaneAngleMeasure#getWrappedValue <em>Wrapped Value</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Wrapped Value</em>' attribute list is set.
	 * @see #unsetWrappedValue()
	 * @see #getWrappedValue()
	 * @generated
	 */
	boolean isSetWrappedValue();

} // IfcCompoundPlaneAngleMeasure
