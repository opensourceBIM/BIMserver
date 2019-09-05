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

public interface IfcSweptSurface extends IfcSurface {
	/**
	 * Returns the value of the '<em><b>Swept Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Swept Curve</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Swept Curve</em>' reference.
	 * @see #setSweptCurve(IfcProfileDef)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptSurface_SweptCurve()
	 * @model
	 * @generated
	 */
	IfcProfileDef getSweptCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptSurface#getSweptCurve <em>Swept Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Swept Curve</em>' reference.
	 * @see #getSweptCurve()
	 * @generated
	 */
	void setSweptCurve(IfcProfileDef value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' reference.
	 * @see #isSetPosition()
	 * @see #unsetPosition()
	 * @see #setPosition(IfcAxis2Placement3D)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptSurface_Position()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAxis2Placement3D getPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptSurface#getPosition <em>Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' reference.
	 * @see #isSetPosition()
	 * @see #unsetPosition()
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(IfcAxis2Placement3D value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSweptSurface#getPosition <em>Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPosition()
	 * @see #getPosition()
	 * @see #setPosition(IfcAxis2Placement3D)
	 * @generated
	 */
	void unsetPosition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSweptSurface#getPosition <em>Position</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Position</em>' reference is set.
	 * @see #unsetPosition()
	 * @see #getPosition()
	 * @see #setPosition(IfcAxis2Placement3D)
	 * @generated
	 */
	boolean isSetPosition();

} // IfcSweptSurface
