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
 * A representation of the model object '<em><b>Ifc Curve Style Font And Scaling</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontAndScaling#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontAndScaling#getCurveFont <em>Curve Font</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontAndScaling#getCurveFontScaling <em>Curve Font Scaling</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontAndScaling#getCurveFontScalingAsString <em>Curve Font Scaling As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveStyleFontAndScaling()
 * @model
 * @generated
 */
public interface IfcCurveStyleFontAndScaling extends IfcCurveFontOrScaledCurveFontSelect
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveStyleFontAndScaling_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontAndScaling#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontAndScaling#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontAndScaling#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

	/**
	 * Returns the value of the '<em><b>Curve Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve Font</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve Font</em>' reference.
	 * @see #setCurveFont(IfcCurveStyleFontSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveStyleFontAndScaling_CurveFont()
	 * @model
	 * @generated
	 */
	IfcCurveStyleFontSelect getCurveFont();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontAndScaling#getCurveFont <em>Curve Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Font</em>' reference.
	 * @see #getCurveFont()
	 * @generated
	 */
	void setCurveFont(IfcCurveStyleFontSelect value);

	/**
	 * Returns the value of the '<em><b>Curve Font Scaling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve Font Scaling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve Font Scaling</em>' attribute.
	 * @see #setCurveFontScaling(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveStyleFontAndScaling_CurveFontScaling()
	 * @model
	 * @generated
	 */
	float getCurveFontScaling();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontAndScaling#getCurveFontScaling <em>Curve Font Scaling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Font Scaling</em>' attribute.
	 * @see #getCurveFontScaling()
	 * @generated
	 */
	void setCurveFontScaling(float value);

	/**
	 * Returns the value of the '<em><b>Curve Font Scaling As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve Font Scaling As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve Font Scaling As String</em>' attribute.
	 * @see #setCurveFontScalingAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveStyleFontAndScaling_CurveFontScalingAsString()
	 * @model
	 * @generated
	 */
	String getCurveFontScalingAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontAndScaling#getCurveFontScalingAsString <em>Curve Font Scaling As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Font Scaling As String</em>' attribute.
	 * @see #getCurveFontScalingAsString()
	 * @generated
	 */
	void setCurveFontScalingAsString(String value);

} // IfcCurveStyleFontAndScaling
