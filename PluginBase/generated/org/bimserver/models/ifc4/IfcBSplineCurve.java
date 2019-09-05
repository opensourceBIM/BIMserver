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
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineCurve#getDegree <em>Degree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineCurve#getControlPointsList <em>Control Points List</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineCurve#getCurveForm <em>Curve Form</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineCurve#getClosedCurve <em>Closed Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineCurve#getSelfIntersect <em>Self Intersect</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineCurve#getUpperIndexOnControlPoints <em>Upper Index On Control Points</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurve()
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurve_Degree()
	 * @model
	 * @generated
	 */
	long getDegree();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineCurve#getDegree <em>Degree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Degree</em>' attribute.
	 * @see #getDegree()
	 * @generated
	 */
	void setDegree(long value);

	/**
	 * Returns the value of the '<em><b>Control Points List</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcCartesianPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control Points List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control Points List</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurve_ControlPointsList()
	 * @model
	 * @generated
	 */
	EList<IfcCartesianPoint> getControlPointsList();

	/**
	 * Returns the value of the '<em><b>Curve Form</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcBSplineCurveForm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curve Form</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curve Form</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcBSplineCurveForm
	 * @see #setCurveForm(IfcBSplineCurveForm)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurve_CurveForm()
	 * @model
	 * @generated
	 */
	IfcBSplineCurveForm getCurveForm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineCurve#getCurveForm <em>Curve Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curve Form</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcBSplineCurveForm
	 * @see #getCurveForm()
	 * @generated
	 */
	void setCurveForm(IfcBSplineCurveForm value);

	/**
	 * Returns the value of the '<em><b>Closed Curve</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closed Curve</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closed Curve</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setClosedCurve(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurve_ClosedCurve()
	 * @model
	 * @generated
	 */
	Tristate getClosedCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineCurve#getClosedCurve <em>Closed Curve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closed Curve</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getClosedCurve()
	 * @generated
	 */
	void setClosedCurve(Tristate value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurve_SelfIntersect()
	 * @model
	 * @generated
	 */
	Tristate getSelfIntersect();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineCurve#getSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Intersect</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getSelfIntersect()
	 * @generated
	 */
	void setSelfIntersect(Tristate value);

	/**
	 * Returns the value of the '<em><b>Upper Index On Control Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Index On Control Points</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Index On Control Points</em>' attribute.
	 * @see #isSetUpperIndexOnControlPoints()
	 * @see #unsetUpperIndexOnControlPoints()
	 * @see #setUpperIndexOnControlPoints(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurve_UpperIndexOnControlPoints()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	long getUpperIndexOnControlPoints();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineCurve#getUpperIndexOnControlPoints <em>Upper Index On Control Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Index On Control Points</em>' attribute.
	 * @see #isSetUpperIndexOnControlPoints()
	 * @see #unsetUpperIndexOnControlPoints()
	 * @see #getUpperIndexOnControlPoints()
	 * @generated
	 */
	void setUpperIndexOnControlPoints(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineCurve#getUpperIndexOnControlPoints <em>Upper Index On Control Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUpperIndexOnControlPoints()
	 * @see #getUpperIndexOnControlPoints()
	 * @see #setUpperIndexOnControlPoints(long)
	 * @generated
	 */
	void unsetUpperIndexOnControlPoints();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBSplineCurve#getUpperIndexOnControlPoints <em>Upper Index On Control Points</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Upper Index On Control Points</em>' attribute is set.
	 * @see #unsetUpperIndexOnControlPoints()
	 * @see #getUpperIndexOnControlPoints()
	 * @see #setUpperIndexOnControlPoints(long)
	 * @generated
	 */
	boolean isSetUpperIndexOnControlPoints();

} // IfcBSplineCurve
