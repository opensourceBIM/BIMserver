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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Grid Axis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getAxisTag <em>Axis Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getAxisCurve <em>Axis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getSameSense <em>Same Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getPartOfW <em>Part Of W</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getPartOfV <em>Part Of V</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getPartOfU <em>Part Of U</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getHasIntersections <em>Has Intersections</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGridAxis()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcGridAxis extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Axis Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis Tag</em>' attribute.
	 * @see #isSetAxisTag()
	 * @see #unsetAxisTag()
	 * @see #setAxisTag(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGridAxis_AxisTag()
	 * @model unsettable="true"
	 * @generated
	 */
	String getAxisTag();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getAxisTag <em>Axis Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis Tag</em>' attribute.
	 * @see #isSetAxisTag()
	 * @see #unsetAxisTag()
	 * @see #getAxisTag()
	 * @generated
	 */
	void setAxisTag(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getAxisTag <em>Axis Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAxisTag()
	 * @see #getAxisTag()
	 * @see #setAxisTag(String)
	 * @generated
	 */
	void unsetAxisTag();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getAxisTag <em>Axis Tag</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Axis Tag</em>' attribute is set.
	 * @see #unsetAxisTag()
	 * @see #getAxisTag()
	 * @see #setAxisTag(String)
	 * @generated
	 */
	boolean isSetAxisTag();

	/**
	 * Returns the value of the '<em><b>Axis Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis Curve</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis Curve</em>' reference.
	 * @see #setAxisCurve(IfcCurve)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGridAxis_AxisCurve()
	 * @model
	 * @generated
	 */
	IfcCurve getAxisCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getAxisCurve <em>Axis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis Curve</em>' reference.
	 * @see #getAxisCurve()
	 * @generated
	 */
	void setAxisCurve(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Same Sense</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Same Sense</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Same Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #setSameSense(Tristate)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGridAxis_SameSense()
	 * @model
	 * @generated
	 */
	Tristate getSameSense();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getSameSense <em>Same Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Same Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #getSameSense()
	 * @generated
	 */
	void setSameSense(Tristate value);

	/**
	 * Returns the value of the '<em><b>Part Of W</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcGrid}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcGrid#getWAxes <em>WAxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of W</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of W</em>' reference list.
	 * @see #isSetPartOfW()
	 * @see #unsetPartOfW()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGridAxis_PartOfW()
	 * @see org.bimserver.models.ifc2x3tc1.IfcGrid#getWAxes
	 * @model opposite="WAxes" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcGrid> getPartOfW();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getPartOfW <em>Part Of W</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPartOfW()
	 * @see #getPartOfW()
	 * @generated
	 */
	void unsetPartOfW();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getPartOfW <em>Part Of W</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Part Of W</em>' reference list is set.
	 * @see #unsetPartOfW()
	 * @see #getPartOfW()
	 * @generated
	 */
	boolean isSetPartOfW();

	/**
	 * Returns the value of the '<em><b>Part Of V</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcGrid}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcGrid#getVAxes <em>VAxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of V</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of V</em>' reference list.
	 * @see #isSetPartOfV()
	 * @see #unsetPartOfV()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGridAxis_PartOfV()
	 * @see org.bimserver.models.ifc2x3tc1.IfcGrid#getVAxes
	 * @model opposite="VAxes" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcGrid> getPartOfV();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getPartOfV <em>Part Of V</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPartOfV()
	 * @see #getPartOfV()
	 * @generated
	 */
	void unsetPartOfV();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getPartOfV <em>Part Of V</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Part Of V</em>' reference list is set.
	 * @see #unsetPartOfV()
	 * @see #getPartOfV()
	 * @generated
	 */
	boolean isSetPartOfV();

	/**
	 * Returns the value of the '<em><b>Part Of U</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcGrid}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcGrid#getUAxes <em>UAxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of U</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of U</em>' reference list.
	 * @see #isSetPartOfU()
	 * @see #unsetPartOfU()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGridAxis_PartOfU()
	 * @see org.bimserver.models.ifc2x3tc1.IfcGrid#getUAxes
	 * @model opposite="UAxes" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcGrid> getPartOfU();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getPartOfU <em>Part Of U</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPartOfU()
	 * @see #getPartOfU()
	 * @generated
	 */
	void unsetPartOfU();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getPartOfU <em>Part Of U</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Part Of U</em>' reference list is set.
	 * @see #unsetPartOfU()
	 * @see #getPartOfU()
	 * @generated
	 */
	boolean isSetPartOfU();

	/**
	 * Returns the value of the '<em><b>Has Intersections</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcVirtualGridIntersection}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcVirtualGridIntersection#getIntersectingAxes <em>Intersecting Axes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Intersections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Intersections</em>' reference list.
	 * @see #isSetHasIntersections()
	 * @see #unsetHasIntersections()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGridAxis_HasIntersections()
	 * @see org.bimserver.models.ifc2x3tc1.IfcVirtualGridIntersection#getIntersectingAxes
	 * @model opposite="IntersectingAxes" unsettable="true"
	 * @generated
	 */
	EList<IfcVirtualGridIntersection> getHasIntersections();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getHasIntersections <em>Has Intersections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasIntersections()
	 * @see #getHasIntersections()
	 * @generated
	 */
	void unsetHasIntersections();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getHasIntersections <em>Has Intersections</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Intersections</em>' reference list is set.
	 * @see #unsetHasIntersections()
	 * @see #getHasIntersections()
	 * @generated
	 */
	boolean isSetHasIntersections();

} // IfcGridAxis
