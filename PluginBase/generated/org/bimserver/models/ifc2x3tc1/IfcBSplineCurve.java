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
package org.bimserver.models.ifc2x3tc1;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc BSpline Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcBSplineCurve#getDegree <em>Degree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcBSplineCurve#getControlPointsList <em>Control Points List</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcBSplineCurve#getCurveForm <em>Curve Form</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcBSplineCurve#isClosedCurve <em>Closed Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcBSplineCurve#isSelfIntersect <em>Self Intersect</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBSplineCurve()
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
	 * @see #setDegree(long)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBSplineCurve_Degree()
	 * @model
	 * @generated
	 */
	long getDegree();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBSplineCurve#getDegree <em>Degree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Degree</em>' attribute.
	 * @see #getDegree()
	 * @generated
	 */
	void setDegree(long value);

	/**
	 * Returns the value of the '<em><b>Control Points List</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcCartesianPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control Points List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control Points List</em>' reference list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBSplineCurve_ControlPointsList()
	 * @model
	 * @generated
	 */
	EList<IfcCartesianPoint> getControlPointsList();

	/**
	 * Returns the value of the '<em><b>Curve Form</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcBSplineCurveForm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve Form</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve Form</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcBSplineCurveForm
	 * @see #setCurveForm(IfcBSplineCurveForm)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBSplineCurve_CurveForm()
	 * @model
	 * @generated
	 */
	IfcBSplineCurveForm getCurveForm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBSplineCurve#getCurveForm <em>Curve Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Form</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcBSplineCurveForm
	 * @see #getCurveForm()
	 * @generated
	 */
	void setCurveForm(IfcBSplineCurveForm value);

	/**
	 * Returns the value of the '<em><b>Closed Curve</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closed Curve</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closed Curve</em>' attribute.
	 * @see #setClosedCurve(boolean)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBSplineCurve_ClosedCurve()
	 * @model
	 * @generated
	 */
	boolean isClosedCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBSplineCurve#isClosedCurve <em>Closed Curve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closed Curve</em>' attribute.
	 * @see #isClosedCurve()
	 * @generated
	 */
	void setClosedCurve(boolean value);

	/**
	 * Returns the value of the '<em><b>Self Intersect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Intersect</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Intersect</em>' attribute.
	 * @see #setSelfIntersect(boolean)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBSplineCurve_SelfIntersect()
	 * @model
	 * @generated
	 */
	boolean isSelfIntersect();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBSplineCurve#isSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Intersect</em>' attribute.
	 * @see #isSelfIntersect()
	 * @generated
	 */
	void setSelfIntersect(boolean value);

} // IfcBSplineCurve
