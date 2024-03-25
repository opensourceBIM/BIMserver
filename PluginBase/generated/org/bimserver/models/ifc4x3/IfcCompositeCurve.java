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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Composite Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCompositeCurve#getSegments <em>Segments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCompositeCurve#getSelfIntersect <em>Self Intersect</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCompositeCurve#getClosedCurve <em>Closed Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCompositeCurve#getNSegments <em>NSegments</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCompositeCurve()
 * @model
 * @generated
 */
public interface IfcCompositeCurve extends IfcBoundedCurve {
	/**
	 * Returns the value of the '<em><b>Segments</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcSegment}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcSegment#getUsingCurves <em>Using Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segments</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCompositeCurve_Segments()
	 * @see org.bimserver.models.ifc4x3.IfcSegment#getUsingCurves
	 * @model opposite="UsingCurves"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcSegment> getSegments();

	/**
	 * Returns the value of the '<em><b>Self Intersect</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Intersect</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #setSelfIntersect(Tristate)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCompositeCurve_SelfIntersect()
	 * @model
	 * @generated
	 */
	Tristate getSelfIntersect();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCompositeCurve#getSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Intersect</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #getSelfIntersect()
	 * @generated
	 */
	void setSelfIntersect(Tristate value);

	/**
	 * Returns the value of the '<em><b>Closed Curve</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closed Curve</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #isSetClosedCurve()
	 * @see #unsetClosedCurve()
	 * @see #setClosedCurve(Tristate)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCompositeCurve_ClosedCurve()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	Tristate getClosedCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCompositeCurve#getClosedCurve <em>Closed Curve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closed Curve</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #isSetClosedCurve()
	 * @see #unsetClosedCurve()
	 * @see #getClosedCurve()
	 * @generated
	 */
	void setClosedCurve(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcCompositeCurve#getClosedCurve <em>Closed Curve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetClosedCurve()
	 * @see #getClosedCurve()
	 * @see #setClosedCurve(Tristate)
	 * @generated
	 */
	void unsetClosedCurve();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcCompositeCurve#getClosedCurve <em>Closed Curve</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Closed Curve</em>' attribute is set.
	 * @see #unsetClosedCurve()
	 * @see #getClosedCurve()
	 * @see #setClosedCurve(Tristate)
	 * @generated
	 */
	boolean isSetClosedCurve();

	/**
	 * Returns the value of the '<em><b>NSegments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>NSegments</em>' attribute.
	 * @see #isSetNSegments()
	 * @see #unsetNSegments()
	 * @see #setNSegments(long)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCompositeCurve_NSegments()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	long getNSegments();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCompositeCurve#getNSegments <em>NSegments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>NSegments</em>' attribute.
	 * @see #isSetNSegments()
	 * @see #unsetNSegments()
	 * @see #getNSegments()
	 * @generated
	 */
	void setNSegments(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcCompositeCurve#getNSegments <em>NSegments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNSegments()
	 * @see #getNSegments()
	 * @see #setNSegments(long)
	 * @generated
	 */
	void unsetNSegments();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcCompositeCurve#getNSegments <em>NSegments</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>NSegments</em>' attribute is set.
	 * @see #unsetNSegments()
	 * @see #getNSegments()
	 * @see #setNSegments(long)
	 * @generated
	 */
	boolean isSetNSegments();

} // IfcCompositeCurve
