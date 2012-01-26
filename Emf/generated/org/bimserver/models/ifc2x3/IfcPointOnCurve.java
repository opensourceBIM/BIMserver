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
 * A representation of the model object '<em><b>Ifc Point On Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getBasisCurve <em>Basis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getPointParameter <em>Point Parameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getPointParameterAsString <em>Point Parameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnCurve()
 * @model
 * @generated
 */
public interface IfcPointOnCurve extends IfcPoint {
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnCurve_BasisCurve()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCurve getBasisCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getBasisCurve <em>Basis Curve</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getBasisCurve <em>Basis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBasisCurve()
	 * @see #getBasisCurve()
	 * @see #setBasisCurve(IfcCurve)
	 * @generated
	 */
	void unsetBasisCurve();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getBasisCurve <em>Basis Curve</em>}' reference is set.
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
	 * Returns the value of the '<em><b>Point Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point Parameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point Parameter</em>' attribute.
	 * @see #isSetPointParameter()
	 * @see #unsetPointParameter()
	 * @see #setPointParameter(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnCurve_PointParameter()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPointParameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getPointParameter <em>Point Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point Parameter</em>' attribute.
	 * @see #isSetPointParameter()
	 * @see #unsetPointParameter()
	 * @see #getPointParameter()
	 * @generated
	 */
	void setPointParameter(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getPointParameter <em>Point Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPointParameter()
	 * @see #getPointParameter()
	 * @see #setPointParameter(double)
	 * @generated
	 */
	void unsetPointParameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getPointParameter <em>Point Parameter</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Point Parameter</em>' attribute is set.
	 * @see #unsetPointParameter()
	 * @see #getPointParameter()
	 * @see #setPointParameter(double)
	 * @generated
	 */
	boolean isSetPointParameter();

	/**
	 * Returns the value of the '<em><b>Point Parameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point Parameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point Parameter As String</em>' attribute.
	 * @see #isSetPointParameterAsString()
	 * @see #unsetPointParameterAsString()
	 * @see #setPointParameterAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnCurve_PointParameterAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPointParameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getPointParameterAsString <em>Point Parameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point Parameter As String</em>' attribute.
	 * @see #isSetPointParameterAsString()
	 * @see #unsetPointParameterAsString()
	 * @see #getPointParameterAsString()
	 * @generated
	 */
	void setPointParameterAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getPointParameterAsString <em>Point Parameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPointParameterAsString()
	 * @see #getPointParameterAsString()
	 * @see #setPointParameterAsString(String)
	 * @generated
	 */
	void unsetPointParameterAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getPointParameterAsString <em>Point Parameter As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Point Parameter As String</em>' attribute is set.
	 * @see #unsetPointParameterAsString()
	 * @see #getPointParameterAsString()
	 * @see #setPointParameterAsString(String)
	 * @generated
	 */
	boolean isSetPointParameterAsString();

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #setDim(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnCurve_Dim()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	void unsetDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnCurve#getDim <em>Dim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dim</em>' attribute is set.
	 * @see #unsetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	boolean isSetDim();

} // IfcPointOnCurve
