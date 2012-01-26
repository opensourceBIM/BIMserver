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
 * A representation of the model object '<em><b>Ifc Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLine#getPnt <em>Pnt</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLine#getDir <em>Dir</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLine()
 * @model
 * @generated
 */
public interface IfcLine extends IfcCurve {
	/**
	 * Returns the value of the '<em><b>Pnt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pnt</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pnt</em>' reference.
	 * @see #isSetPnt()
	 * @see #unsetPnt()
	 * @see #setPnt(IfcCartesianPoint)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLine_Pnt()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCartesianPoint getPnt();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLine#getPnt <em>Pnt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pnt</em>' reference.
	 * @see #isSetPnt()
	 * @see #unsetPnt()
	 * @see #getPnt()
	 * @generated
	 */
	void setPnt(IfcCartesianPoint value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLine#getPnt <em>Pnt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPnt()
	 * @see #getPnt()
	 * @see #setPnt(IfcCartesianPoint)
	 * @generated
	 */
	void unsetPnt();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLine#getPnt <em>Pnt</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pnt</em>' reference is set.
	 * @see #unsetPnt()
	 * @see #getPnt()
	 * @see #setPnt(IfcCartesianPoint)
	 * @generated
	 */
	boolean isSetPnt();

	/**
	 * Returns the value of the '<em><b>Dir</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dir</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dir</em>' reference.
	 * @see #isSetDir()
	 * @see #unsetDir()
	 * @see #setDir(IfcVector)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLine_Dir()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcVector getDir();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLine#getDir <em>Dir</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dir</em>' reference.
	 * @see #isSetDir()
	 * @see #unsetDir()
	 * @see #getDir()
	 * @generated
	 */
	void setDir(IfcVector value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLine#getDir <em>Dir</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDir()
	 * @see #getDir()
	 * @see #setDir(IfcVector)
	 * @generated
	 */
	void unsetDir();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLine#getDir <em>Dir</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dir</em>' reference is set.
	 * @see #unsetDir()
	 * @see #getDir()
	 * @see #setDir(IfcVector)
	 * @generated
	 */
	boolean isSetDir();

} // IfcLine
