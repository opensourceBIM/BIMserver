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
package org.bimserver.models.ifc4;

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
	 * @see #setPnt(IfcCartesianPoint)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLine_Pnt()
	 * @model
	 * @generated
	 */
	IfcCartesianPoint getPnt();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLine#getPnt <em>Pnt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pnt</em>' reference.
	 * @see #getPnt()
	 * @generated
	 */
	void setPnt(IfcCartesianPoint value);

	/**
	 * Returns the value of the '<em><b>Dir</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dir</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dir</em>' reference.
	 * @see #setDir(IfcVector)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLine_Dir()
	 * @model
	 * @generated
	 */
	IfcVector getDir();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLine#getDir <em>Dir</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dir</em>' reference.
	 * @see #getDir()
	 * @generated
	 */
	void setDir(IfcVector value);

} // IfcLine
