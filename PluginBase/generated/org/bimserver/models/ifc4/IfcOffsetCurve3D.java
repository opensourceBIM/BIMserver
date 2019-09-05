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

public interface IfcOffsetCurve3D extends IfcCurve {
	/**
	 * Returns the value of the '<em><b>Basis Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basis Curve</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basis Curve</em>' reference.
	 * @see #setBasisCurve(IfcCurve)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcOffsetCurve3D_BasisCurve()
	 * @model
	 * @generated
	 */
	IfcCurve getBasisCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcOffsetCurve3D#getBasisCurve <em>Basis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis Curve</em>' reference.
	 * @see #getBasisCurve()
	 * @generated
	 */
	void setBasisCurve(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance</em>' attribute.
	 * @see #setDistance(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcOffsetCurve3D_Distance()
	 * @model
	 * @generated
	 */
	double getDistance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcOffsetCurve3D#getDistance <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance</em>' attribute.
	 * @see #getDistance()
	 * @generated
	 */
	void setDistance(double value);

	/**
	 * Returns the value of the '<em><b>Distance As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance As String</em>' attribute.
	 * @see #setDistanceAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcOffsetCurve3D_DistanceAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getDistanceAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcOffsetCurve3D#getDistanceAsString <em>Distance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance As String</em>' attribute.
	 * @see #getDistanceAsString()
	 * @generated
	 */
	void setDistanceAsString(String value);

	/**
	 * Returns the value of the '<em><b>Self Intersect</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Intersect</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Intersect</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setSelfIntersect(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcOffsetCurve3D_SelfIntersect()
	 * @model
	 * @generated
	 */
	Tristate getSelfIntersect();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcOffsetCurve3D#getSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Intersect</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getSelfIntersect()
	 * @generated
	 */
	void setSelfIntersect(Tristate value);

	/**
	 * Returns the value of the '<em><b>Ref Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Direction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Direction</em>' reference.
	 * @see #setRefDirection(IfcDirection)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcOffsetCurve3D_RefDirection()
	 * @model
	 * @generated
	 */
	IfcDirection getRefDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcOffsetCurve3D#getRefDirection <em>Ref Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Direction</em>' reference.
	 * @see #getRefDirection()
	 * @generated
	 */
	void setRefDirection(IfcDirection value);

} // IfcOffsetCurve3D
