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
 * A representation of the model object '<em><b>Ifc Offset Curve3 D</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getBasisCurve <em>Basis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getDistance <em>Distance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getDistanceAsString <em>Distance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#isSelfIntersect <em>Self Intersect</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getRefDirection <em>Ref Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOffsetCurve3D()
 * @model
 * @generated
 */
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
	 * @see #isSetBasisCurve()
	 * @see #unsetBasisCurve()
	 * @see #setBasisCurve(IfcCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOffsetCurve3D_BasisCurve()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCurve getBasisCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getBasisCurve <em>Basis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis Curve</em>' reference.
	 * @see #isSetBasisCurve()
	 * @see #unsetBasisCurve()
	 * @see #getBasisCurve()
	 * @generated
	 */
	void setBasisCurve(IfcCurve value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getBasisCurve <em>Basis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBasisCurve()
	 * @see #getBasisCurve()
	 * @see #setBasisCurve(IfcCurve)
	 * @generated
	 */
	void unsetBasisCurve();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getBasisCurve <em>Basis Curve</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Basis Curve</em>' reference is set.
	 * @see #unsetBasisCurve()
	 * @see #getBasisCurve()
	 * @see #setBasisCurve(IfcCurve)
	 * @generated
	 */
	boolean isSetBasisCurve();

	/**
	 * Returns the value of the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance</em>' attribute.
	 * @see #isSetDistance()
	 * @see #unsetDistance()
	 * @see #setDistance(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOffsetCurve3D_Distance()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDistance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getDistance <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance</em>' attribute.
	 * @see #isSetDistance()
	 * @see #unsetDistance()
	 * @see #getDistance()
	 * @generated
	 */
	void setDistance(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getDistance <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDistance()
	 * @see #getDistance()
	 * @see #setDistance(double)
	 * @generated
	 */
	void unsetDistance();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getDistance <em>Distance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Distance</em>' attribute is set.
	 * @see #unsetDistance()
	 * @see #getDistance()
	 * @see #setDistance(double)
	 * @generated
	 */
	boolean isSetDistance();

	/**
	 * Returns the value of the '<em><b>Distance As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance As String</em>' attribute.
	 * @see #isSetDistanceAsString()
	 * @see #unsetDistanceAsString()
	 * @see #setDistanceAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOffsetCurve3D_DistanceAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDistanceAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getDistanceAsString <em>Distance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance As String</em>' attribute.
	 * @see #isSetDistanceAsString()
	 * @see #unsetDistanceAsString()
	 * @see #getDistanceAsString()
	 * @generated
	 */
	void setDistanceAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getDistanceAsString <em>Distance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDistanceAsString()
	 * @see #getDistanceAsString()
	 * @see #setDistanceAsString(String)
	 * @generated
	 */
	void unsetDistanceAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getDistanceAsString <em>Distance As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Distance As String</em>' attribute is set.
	 * @see #unsetDistanceAsString()
	 * @see #getDistanceAsString()
	 * @see #setDistanceAsString(String)
	 * @generated
	 */
	boolean isSetDistanceAsString();

	/**
	 * Returns the value of the '<em><b>Self Intersect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Intersect</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Intersect</em>' attribute.
	 * @see #isSetSelfIntersect()
	 * @see #unsetSelfIntersect()
	 * @see #setSelfIntersect(boolean)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOffsetCurve3D_SelfIntersect()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isSelfIntersect();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#isSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Intersect</em>' attribute.
	 * @see #isSetSelfIntersect()
	 * @see #unsetSelfIntersect()
	 * @see #isSelfIntersect()
	 * @generated
	 */
	void setSelfIntersect(boolean value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#isSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSelfIntersect()
	 * @see #isSelfIntersect()
	 * @see #setSelfIntersect(boolean)
	 * @generated
	 */
	void unsetSelfIntersect();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#isSelfIntersect <em>Self Intersect</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Self Intersect</em>' attribute is set.
	 * @see #unsetSelfIntersect()
	 * @see #isSelfIntersect()
	 * @see #setSelfIntersect(boolean)
	 * @generated
	 */
	boolean isSetSelfIntersect();

	/**
	 * Returns the value of the '<em><b>Ref Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Direction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Direction</em>' reference.
	 * @see #isSetRefDirection()
	 * @see #unsetRefDirection()
	 * @see #setRefDirection(IfcDirection)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOffsetCurve3D_RefDirection()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirection getRefDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getRefDirection <em>Ref Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Direction</em>' reference.
	 * @see #isSetRefDirection()
	 * @see #unsetRefDirection()
	 * @see #getRefDirection()
	 * @generated
	 */
	void setRefDirection(IfcDirection value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getRefDirection <em>Ref Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRefDirection()
	 * @see #getRefDirection()
	 * @see #setRefDirection(IfcDirection)
	 * @generated
	 */
	void unsetRefDirection();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOffsetCurve3D#getRefDirection <em>Ref Direction</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ref Direction</em>' reference is set.
	 * @see #unsetRefDirection()
	 * @see #getRefDirection()
	 * @see #setRefDirection(IfcDirection)
	 * @generated
	 */
	boolean isSetRefDirection();

} // IfcOffsetCurve3D
