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

public interface IfcCurveStyle extends IfcPresentationStyle, IfcPresentationStyleSelect {
	/**
	 * Returns the value of the '<em><b>Curve Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve Font</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve Font</em>' reference.
	 * @see #isSetCurveFont()
	 * @see #unsetCurveFont()
	 * @see #setCurveFont(IfcCurveFontOrScaledCurveFontSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCurveStyle_CurveFont()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCurveFontOrScaledCurveFontSelect getCurveFont();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getCurveFont <em>Curve Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Font</em>' reference.
	 * @see #isSetCurveFont()
	 * @see #unsetCurveFont()
	 * @see #getCurveFont()
	 * @generated
	 */
	void setCurveFont(IfcCurveFontOrScaledCurveFontSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getCurveFont <em>Curve Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCurveFont()
	 * @see #getCurveFont()
	 * @see #setCurveFont(IfcCurveFontOrScaledCurveFontSelect)
	 * @generated
	 */
	void unsetCurveFont();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getCurveFont <em>Curve Font</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Curve Font</em>' reference is set.
	 * @see #unsetCurveFont()
	 * @see #getCurveFont()
	 * @see #setCurveFont(IfcCurveFontOrScaledCurveFontSelect)
	 * @generated
	 */
	boolean isSetCurveFont();

	/**
	 * Returns the value of the '<em><b>Curve Width</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve Width</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve Width</em>' reference.
	 * @see #isSetCurveWidth()
	 * @see #unsetCurveWidth()
	 * @see #setCurveWidth(IfcSizeSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCurveStyle_CurveWidth()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSizeSelect getCurveWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getCurveWidth <em>Curve Width</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Width</em>' reference.
	 * @see #isSetCurveWidth()
	 * @see #unsetCurveWidth()
	 * @see #getCurveWidth()
	 * @generated
	 */
	void setCurveWidth(IfcSizeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getCurveWidth <em>Curve Width</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCurveWidth()
	 * @see #getCurveWidth()
	 * @see #setCurveWidth(IfcSizeSelect)
	 * @generated
	 */
	void unsetCurveWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getCurveWidth <em>Curve Width</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Curve Width</em>' reference is set.
	 * @see #unsetCurveWidth()
	 * @see #getCurveWidth()
	 * @see #setCurveWidth(IfcSizeSelect)
	 * @generated
	 */
	boolean isSetCurveWidth();

	/**
	 * Returns the value of the '<em><b>Curve Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve Colour</em>' reference.
	 * @see #isSetCurveColour()
	 * @see #unsetCurveColour()
	 * @see #setCurveColour(IfcColour)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCurveStyle_CurveColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColour getCurveColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getCurveColour <em>Curve Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Colour</em>' reference.
	 * @see #isSetCurveColour()
	 * @see #unsetCurveColour()
	 * @see #getCurveColour()
	 * @generated
	 */
	void setCurveColour(IfcColour value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getCurveColour <em>Curve Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCurveColour()
	 * @see #getCurveColour()
	 * @see #setCurveColour(IfcColour)
	 * @generated
	 */
	void unsetCurveColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getCurveColour <em>Curve Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Curve Colour</em>' reference is set.
	 * @see #unsetCurveColour()
	 * @see #getCurveColour()
	 * @see #setCurveColour(IfcColour)
	 * @generated
	 */
	boolean isSetCurveColour();

	/**
	 * Returns the value of the '<em><b>Model Or Draughting</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Or Draughting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Or Draughting</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetModelOrDraughting()
	 * @see #unsetModelOrDraughting()
	 * @see #setModelOrDraughting(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCurveStyle_ModelOrDraughting()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getModelOrDraughting();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getModelOrDraughting <em>Model Or Draughting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Or Draughting</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetModelOrDraughting()
	 * @see #unsetModelOrDraughting()
	 * @see #getModelOrDraughting()
	 * @generated
	 */
	void setModelOrDraughting(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getModelOrDraughting <em>Model Or Draughting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetModelOrDraughting()
	 * @see #getModelOrDraughting()
	 * @see #setModelOrDraughting(Tristate)
	 * @generated
	 */
	void unsetModelOrDraughting();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCurveStyle#getModelOrDraughting <em>Model Or Draughting</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Model Or Draughting</em>' attribute is set.
	 * @see #unsetModelOrDraughting()
	 * @see #getModelOrDraughting()
	 * @see #setModelOrDraughting(Tristate)
	 * @generated
	 */
	boolean isSetModelOrDraughting();

} // IfcCurveStyle
