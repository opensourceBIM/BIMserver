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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Point By Distance Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getDistanceAlong <em>Distance Along</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLateral <em>Offset Lateral</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLateralAsString <em>Offset Lateral As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetVertical <em>Offset Vertical</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetVerticalAsString <em>Offset Vertical As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLongitudinal <em>Offset Longitudinal</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLongitudinalAsString <em>Offset Longitudinal As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getBasisCurve <em>Basis Curve</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPointByDistanceExpression()
 * @model
 * @generated
 */
public interface IfcPointByDistanceExpression extends IfcPoint {
	/**
	 * Returns the value of the '<em><b>Distance Along</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance Along</em>' reference.
	 * @see #setDistanceAlong(IfcCurveMeasureSelect)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPointByDistanceExpression_DistanceAlong()
	 * @model
	 * @generated
	 */
	IfcCurveMeasureSelect getDistanceAlong();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getDistanceAlong <em>Distance Along</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance Along</em>' reference.
	 * @see #getDistanceAlong()
	 * @generated
	 */
	void setDistanceAlong(IfcCurveMeasureSelect value);

	/**
	 * Returns the value of the '<em><b>Offset Lateral</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Lateral</em>' attribute.
	 * @see #isSetOffsetLateral()
	 * @see #unsetOffsetLateral()
	 * @see #setOffsetLateral(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPointByDistanceExpression_OffsetLateral()
	 * @model unsettable="true"
	 * @generated
	 */
	double getOffsetLateral();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLateral <em>Offset Lateral</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Lateral</em>' attribute.
	 * @see #isSetOffsetLateral()
	 * @see #unsetOffsetLateral()
	 * @see #getOffsetLateral()
	 * @generated
	 */
	void setOffsetLateral(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLateral <em>Offset Lateral</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffsetLateral()
	 * @see #getOffsetLateral()
	 * @see #setOffsetLateral(double)
	 * @generated
	 */
	void unsetOffsetLateral();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLateral <em>Offset Lateral</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset Lateral</em>' attribute is set.
	 * @see #unsetOffsetLateral()
	 * @see #getOffsetLateral()
	 * @see #setOffsetLateral(double)
	 * @generated
	 */
	boolean isSetOffsetLateral();

	/**
	 * Returns the value of the '<em><b>Offset Lateral As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Lateral As String</em>' attribute.
	 * @see #isSetOffsetLateralAsString()
	 * @see #unsetOffsetLateralAsString()
	 * @see #setOffsetLateralAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPointByDistanceExpression_OffsetLateralAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getOffsetLateralAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLateralAsString <em>Offset Lateral As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Lateral As String</em>' attribute.
	 * @see #isSetOffsetLateralAsString()
	 * @see #unsetOffsetLateralAsString()
	 * @see #getOffsetLateralAsString()
	 * @generated
	 */
	void setOffsetLateralAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLateralAsString <em>Offset Lateral As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffsetLateralAsString()
	 * @see #getOffsetLateralAsString()
	 * @see #setOffsetLateralAsString(String)
	 * @generated
	 */
	void unsetOffsetLateralAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLateralAsString <em>Offset Lateral As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset Lateral As String</em>' attribute is set.
	 * @see #unsetOffsetLateralAsString()
	 * @see #getOffsetLateralAsString()
	 * @see #setOffsetLateralAsString(String)
	 * @generated
	 */
	boolean isSetOffsetLateralAsString();

	/**
	 * Returns the value of the '<em><b>Offset Vertical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Vertical</em>' attribute.
	 * @see #isSetOffsetVertical()
	 * @see #unsetOffsetVertical()
	 * @see #setOffsetVertical(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPointByDistanceExpression_OffsetVertical()
	 * @model unsettable="true"
	 * @generated
	 */
	double getOffsetVertical();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetVertical <em>Offset Vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Vertical</em>' attribute.
	 * @see #isSetOffsetVertical()
	 * @see #unsetOffsetVertical()
	 * @see #getOffsetVertical()
	 * @generated
	 */
	void setOffsetVertical(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetVertical <em>Offset Vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffsetVertical()
	 * @see #getOffsetVertical()
	 * @see #setOffsetVertical(double)
	 * @generated
	 */
	void unsetOffsetVertical();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetVertical <em>Offset Vertical</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset Vertical</em>' attribute is set.
	 * @see #unsetOffsetVertical()
	 * @see #getOffsetVertical()
	 * @see #setOffsetVertical(double)
	 * @generated
	 */
	boolean isSetOffsetVertical();

	/**
	 * Returns the value of the '<em><b>Offset Vertical As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Vertical As String</em>' attribute.
	 * @see #isSetOffsetVerticalAsString()
	 * @see #unsetOffsetVerticalAsString()
	 * @see #setOffsetVerticalAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPointByDistanceExpression_OffsetVerticalAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getOffsetVerticalAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetVerticalAsString <em>Offset Vertical As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Vertical As String</em>' attribute.
	 * @see #isSetOffsetVerticalAsString()
	 * @see #unsetOffsetVerticalAsString()
	 * @see #getOffsetVerticalAsString()
	 * @generated
	 */
	void setOffsetVerticalAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetVerticalAsString <em>Offset Vertical As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffsetVerticalAsString()
	 * @see #getOffsetVerticalAsString()
	 * @see #setOffsetVerticalAsString(String)
	 * @generated
	 */
	void unsetOffsetVerticalAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetVerticalAsString <em>Offset Vertical As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset Vertical As String</em>' attribute is set.
	 * @see #unsetOffsetVerticalAsString()
	 * @see #getOffsetVerticalAsString()
	 * @see #setOffsetVerticalAsString(String)
	 * @generated
	 */
	boolean isSetOffsetVerticalAsString();

	/**
	 * Returns the value of the '<em><b>Offset Longitudinal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Longitudinal</em>' attribute.
	 * @see #isSetOffsetLongitudinal()
	 * @see #unsetOffsetLongitudinal()
	 * @see #setOffsetLongitudinal(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPointByDistanceExpression_OffsetLongitudinal()
	 * @model unsettable="true"
	 * @generated
	 */
	double getOffsetLongitudinal();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLongitudinal <em>Offset Longitudinal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Longitudinal</em>' attribute.
	 * @see #isSetOffsetLongitudinal()
	 * @see #unsetOffsetLongitudinal()
	 * @see #getOffsetLongitudinal()
	 * @generated
	 */
	void setOffsetLongitudinal(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLongitudinal <em>Offset Longitudinal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffsetLongitudinal()
	 * @see #getOffsetLongitudinal()
	 * @see #setOffsetLongitudinal(double)
	 * @generated
	 */
	void unsetOffsetLongitudinal();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLongitudinal <em>Offset Longitudinal</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset Longitudinal</em>' attribute is set.
	 * @see #unsetOffsetLongitudinal()
	 * @see #getOffsetLongitudinal()
	 * @see #setOffsetLongitudinal(double)
	 * @generated
	 */
	boolean isSetOffsetLongitudinal();

	/**
	 * Returns the value of the '<em><b>Offset Longitudinal As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Longitudinal As String</em>' attribute.
	 * @see #isSetOffsetLongitudinalAsString()
	 * @see #unsetOffsetLongitudinalAsString()
	 * @see #setOffsetLongitudinalAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPointByDistanceExpression_OffsetLongitudinalAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getOffsetLongitudinalAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLongitudinalAsString <em>Offset Longitudinal As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Longitudinal As String</em>' attribute.
	 * @see #isSetOffsetLongitudinalAsString()
	 * @see #unsetOffsetLongitudinalAsString()
	 * @see #getOffsetLongitudinalAsString()
	 * @generated
	 */
	void setOffsetLongitudinalAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLongitudinalAsString <em>Offset Longitudinal As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffsetLongitudinalAsString()
	 * @see #getOffsetLongitudinalAsString()
	 * @see #setOffsetLongitudinalAsString(String)
	 * @generated
	 */
	void unsetOffsetLongitudinalAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getOffsetLongitudinalAsString <em>Offset Longitudinal As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset Longitudinal As String</em>' attribute is set.
	 * @see #unsetOffsetLongitudinalAsString()
	 * @see #getOffsetLongitudinalAsString()
	 * @see #setOffsetLongitudinalAsString(String)
	 * @generated
	 */
	boolean isSetOffsetLongitudinalAsString();

	/**
	 * Returns the value of the '<em><b>Basis Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basis Curve</em>' reference.
	 * @see #setBasisCurve(IfcCurve)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPointByDistanceExpression_BasisCurve()
	 * @model
	 * @generated
	 */
	IfcCurve getBasisCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPointByDistanceExpression#getBasisCurve <em>Basis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis Curve</em>' reference.
	 * @see #getBasisCurve()
	 * @generated
	 */
	void setBasisCurve(IfcCurve value);

} // IfcPointByDistanceExpression
