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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc BSpline Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#getDegree <em>Degree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#getControlPointsList <em>Control Points List</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#getCurveForm <em>Curve Form</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#isClosedCurve <em>Closed Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#isSelfIntersect <em>Self Intersect</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBSplineCurve()
 * @model
 * @generated
 */
public interface IfcBSplineCurve extends IfcBoundedCurve {
	/**
	 * Returns the value of the '<em><b>Degree</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Degree</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Degree</em>' attribute.
	 * @see #isSetDegree()
	 * @see #unsetDegree()
	 * @see #setDegree(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBSplineCurve_Degree()
	 * @model unsettable="true"
	 * @generated
	 */
	int getDegree();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#getDegree <em>Degree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Degree</em>' attribute.
	 * @see #isSetDegree()
	 * @see #unsetDegree()
	 * @see #getDegree()
	 * @generated
	 */
	void setDegree(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#getDegree <em>Degree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDegree()
	 * @see #getDegree()
	 * @see #setDegree(int)
	 * @generated
	 */
	void unsetDegree();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#getDegree <em>Degree</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Degree</em>' attribute is set.
	 * @see #unsetDegree()
	 * @see #getDegree()
	 * @see #setDegree(int)
	 * @generated
	 */
	boolean isSetDegree();

	/**
	 * Returns the value of the '<em><b>Control Points List</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcCartesianPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control Points List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control Points List</em>' reference list.
	 * @see #isSetControlPointsList()
	 * @see #unsetControlPointsList()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBSplineCurve_ControlPointsList()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcCartesianPoint> getControlPointsList();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#getControlPointsList <em>Control Points List</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetControlPointsList()
	 * @see #getControlPointsList()
	 * @generated
	 */
	void unsetControlPointsList();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#getControlPointsList <em>Control Points List</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Control Points List</em>' reference list is set.
	 * @see #unsetControlPointsList()
	 * @see #getControlPointsList()
	 * @generated
	 */
	boolean isSetControlPointsList();

	/**
	 * Returns the value of the '<em><b>Curve Form</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcBSplineCurveForm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve Form</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve Form</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcBSplineCurveForm
	 * @see #isSetCurveForm()
	 * @see #unsetCurveForm()
	 * @see #setCurveForm(IfcBSplineCurveForm)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBSplineCurve_CurveForm()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcBSplineCurveForm getCurveForm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#getCurveForm <em>Curve Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Form</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcBSplineCurveForm
	 * @see #isSetCurveForm()
	 * @see #unsetCurveForm()
	 * @see #getCurveForm()
	 * @generated
	 */
	void setCurveForm(IfcBSplineCurveForm value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#getCurveForm <em>Curve Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCurveForm()
	 * @see #getCurveForm()
	 * @see #setCurveForm(IfcBSplineCurveForm)
	 * @generated
	 */
	void unsetCurveForm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#getCurveForm <em>Curve Form</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Curve Form</em>' attribute is set.
	 * @see #unsetCurveForm()
	 * @see #getCurveForm()
	 * @see #setCurveForm(IfcBSplineCurveForm)
	 * @generated
	 */
	boolean isSetCurveForm();

	/**
	 * Returns the value of the '<em><b>Closed Curve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closed Curve</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closed Curve</em>' attribute.
	 * @see #isSetClosedCurve()
	 * @see #unsetClosedCurve()
	 * @see #setClosedCurve(boolean)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBSplineCurve_ClosedCurve()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isClosedCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#isClosedCurve <em>Closed Curve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closed Curve</em>' attribute.
	 * @see #isSetClosedCurve()
	 * @see #unsetClosedCurve()
	 * @see #isClosedCurve()
	 * @generated
	 */
	void setClosedCurve(boolean value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#isClosedCurve <em>Closed Curve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetClosedCurve()
	 * @see #isClosedCurve()
	 * @see #setClosedCurve(boolean)
	 * @generated
	 */
	void unsetClosedCurve();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#isClosedCurve <em>Closed Curve</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Closed Curve</em>' attribute is set.
	 * @see #unsetClosedCurve()
	 * @see #isClosedCurve()
	 * @see #setClosedCurve(boolean)
	 * @generated
	 */
	boolean isSetClosedCurve();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBSplineCurve_SelfIntersect()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isSelfIntersect();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#isSelfIntersect <em>Self Intersect</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#isSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSelfIntersect()
	 * @see #isSelfIntersect()
	 * @see #setSelfIntersect(boolean)
	 * @generated
	 */
	void unsetSelfIntersect();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBSplineCurve#isSelfIntersect <em>Self Intersect</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Self Intersect</em>' attribute is set.
	 * @see #unsetSelfIntersect()
	 * @see #isSelfIntersect()
	 * @see #setSelfIntersect(boolean)
	 * @generated
	 */
	boolean isSetSelfIntersect();

} // IfcBSplineCurve
