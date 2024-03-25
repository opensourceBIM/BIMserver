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
 * A representation of the model object '<em><b>Ifc Directrix Curve Swept Area Solid</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcDirectrixCurveSweptAreaSolid#getDirectrix <em>Directrix</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcDirectrixCurveSweptAreaSolid#getStartParam <em>Start Param</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcDirectrixCurveSweptAreaSolid#getEndParam <em>End Param</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcDirectrixCurveSweptAreaSolid()
 * @model
 * @generated
 */
public interface IfcDirectrixCurveSweptAreaSolid extends IfcSweptAreaSolid {
	/**
	 * Returns the value of the '<em><b>Directrix</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directrix</em>' reference.
	 * @see #setDirectrix(IfcCurve)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcDirectrixCurveSweptAreaSolid_Directrix()
	 * @model
	 * @generated
	 */
	IfcCurve getDirectrix();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcDirectrixCurveSweptAreaSolid#getDirectrix <em>Directrix</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directrix</em>' reference.
	 * @see #getDirectrix()
	 * @generated
	 */
	void setDirectrix(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Start Param</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Param</em>' reference.
	 * @see #isSetStartParam()
	 * @see #unsetStartParam()
	 * @see #setStartParam(IfcCurveMeasureSelect)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcDirectrixCurveSweptAreaSolid_StartParam()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCurveMeasureSelect getStartParam();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcDirectrixCurveSweptAreaSolid#getStartParam <em>Start Param</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Param</em>' reference.
	 * @see #isSetStartParam()
	 * @see #unsetStartParam()
	 * @see #getStartParam()
	 * @generated
	 */
	void setStartParam(IfcCurveMeasureSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcDirectrixCurveSweptAreaSolid#getStartParam <em>Start Param</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartParam()
	 * @see #getStartParam()
	 * @see #setStartParam(IfcCurveMeasureSelect)
	 * @generated
	 */
	void unsetStartParam();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcDirectrixCurveSweptAreaSolid#getStartParam <em>Start Param</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Param</em>' reference is set.
	 * @see #unsetStartParam()
	 * @see #getStartParam()
	 * @see #setStartParam(IfcCurveMeasureSelect)
	 * @generated
	 */
	boolean isSetStartParam();

	/**
	 * Returns the value of the '<em><b>End Param</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Param</em>' reference.
	 * @see #isSetEndParam()
	 * @see #unsetEndParam()
	 * @see #setEndParam(IfcCurveMeasureSelect)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcDirectrixCurveSweptAreaSolid_EndParam()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCurveMeasureSelect getEndParam();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcDirectrixCurveSweptAreaSolid#getEndParam <em>End Param</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Param</em>' reference.
	 * @see #isSetEndParam()
	 * @see #unsetEndParam()
	 * @see #getEndParam()
	 * @generated
	 */
	void setEndParam(IfcCurveMeasureSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcDirectrixCurveSweptAreaSolid#getEndParam <em>End Param</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndParam()
	 * @see #getEndParam()
	 * @see #setEndParam(IfcCurveMeasureSelect)
	 * @generated
	 */
	void unsetEndParam();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcDirectrixCurveSweptAreaSolid#getEndParam <em>End Param</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>End Param</em>' reference is set.
	 * @see #unsetEndParam()
	 * @see #getEndParam()
	 * @see #setEndParam(IfcCurveMeasureSelect)
	 * @generated
	 */
	boolean isSetEndParam();

} // IfcDirectrixCurveSweptAreaSolid
