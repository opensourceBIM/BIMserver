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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Grid Axis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGridAxis#getAxisTag <em>Axis Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGridAxis#getAxisCurve <em>Axis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGridAxis#getSameSense <em>Same Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGridAxis#getPartOfW <em>Part Of W</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGridAxis#getPartOfV <em>Part Of V</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGridAxis#getPartOfU <em>Part Of U</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGridAxis#getHasIntersections <em>Has Intersections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGridAxis()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcGridAxis extends IdEObject
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGridAxis_AxisTag()
	 * @model unsettable="true"
	 * @generated
	 */
	String getAxisTag();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGridAxis#getAxisTag <em>Axis Tag</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcGridAxis#getAxisTag <em>Axis Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAxisTag()
	 * @see #getAxisTag()
	 * @see #setAxisTag(String)
	 * @generated
	 */
	void unsetAxisTag();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcGridAxis#getAxisTag <em>Axis Tag</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGridAxis_AxisCurve()
	 * @model
	 * @generated
	 */
	IfcCurve getAxisCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGridAxis#getAxisCurve <em>Axis Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis Curve</em>' reference.
	 * @see #getAxisCurve()
	 * @generated
	 */
	void setAxisCurve(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Same Sense</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Same Sense</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Same Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setSameSense(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGridAxis_SameSense()
	 * @model
	 * @generated
	 */
	Tristate getSameSense();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGridAxis#getSameSense <em>Same Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Same Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getSameSense()
	 * @generated
	 */
	void setSameSense(Tristate value);

	/**
	 * Returns the value of the '<em><b>Part Of W</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcGrid}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcGrid#getWAxes <em>WAxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of W</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of W</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGridAxis_PartOfW()
	 * @see org.bimserver.models.ifc2x3.IfcGrid#getWAxes
	 * @model opposite="WAxes" upper="2"
	 * @generated
	 */
	EList<IfcGrid> getPartOfW();

	/**
	 * Returns the value of the '<em><b>Part Of V</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcGrid}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcGrid#getVAxes <em>VAxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of V</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of V</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGridAxis_PartOfV()
	 * @see org.bimserver.models.ifc2x3.IfcGrid#getVAxes
	 * @model opposite="VAxes" upper="2"
	 * @generated
	 */
	EList<IfcGrid> getPartOfV();

	/**
	 * Returns the value of the '<em><b>Part Of U</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcGrid}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcGrid#getUAxes <em>UAxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of U</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of U</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGridAxis_PartOfU()
	 * @see org.bimserver.models.ifc2x3.IfcGrid#getUAxes
	 * @model opposite="UAxes" upper="2"
	 * @generated
	 */
	EList<IfcGrid> getPartOfU();

	/**
	 * Returns the value of the '<em><b>Has Intersections</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcVirtualGridIntersection}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcVirtualGridIntersection#getIntersectingAxes <em>Intersecting Axes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Intersections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Intersections</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGridAxis_HasIntersections()
	 * @see org.bimserver.models.ifc2x3.IfcVirtualGridIntersection#getIntersectingAxes
	 * @model opposite="IntersectingAxes"
	 * @generated
	 */
	EList<IfcVirtualGridIntersection> getHasIntersections();

} // IfcGridAxis
