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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Cartesian Transformation Operator3 D</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3D#getAxis3 <em>Axis3</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianTransformationOperator3D()
 * @model
 * @generated
 */
public interface IfcCartesianTransformationOperator3D extends IfcCartesianTransformationOperator
{
	/**
	 * Returns the value of the '<em><b>Axis3</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis3</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis3</em>' reference.
	 * @see #isSetAxis3()
	 * @see #unsetAxis3()
	 * @see #setAxis3(IfcDirection)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianTransformationOperator3D_Axis3()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirection getAxis3();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3D#getAxis3 <em>Axis3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis3</em>' reference.
	 * @see #isSetAxis3()
	 * @see #unsetAxis3()
	 * @see #getAxis3()
	 * @generated
	 */
	void setAxis3(IfcDirection value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3D#getAxis3 <em>Axis3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAxis3()
	 * @see #getAxis3()
	 * @see #setAxis3(IfcDirection)
	 * @generated
	 */
	void unsetAxis3();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3D#getAxis3 <em>Axis3</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Axis3</em>' reference is set.
	 * @see #unsetAxis3()
	 * @see #getAxis3()
	 * @see #setAxis3(IfcDirection)
	 * @generated
	 */
	boolean isSetAxis3();

} // IfcCartesianTransformationOperator3D
