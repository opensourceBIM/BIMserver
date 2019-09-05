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
 * A representation of the model object '<em><b>Ifc Indexed Poly Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcIndexedPolyCurve#getPoints <em>Points</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcIndexedPolyCurve#getSegments <em>Segments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcIndexedPolyCurve#getSelfIntersect <em>Self Intersect</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedPolyCurve()
 * @model
 * @generated
 */
public interface IfcIndexedPolyCurve extends IfcBoundedCurve {
	/**
	 * Returns the value of the '<em><b>Points</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Points</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' reference.
	 * @see #setPoints(IfcCartesianPointList)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedPolyCurve_Points()
	 * @model
	 * @generated
	 */
	IfcCartesianPointList getPoints();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedPolyCurve#getPoints <em>Points</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Points</em>' reference.
	 * @see #getPoints()
	 * @generated
	 */
	void setPoints(IfcCartesianPointList value);

	/**
	 * Returns the value of the '<em><b>Segments</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcSegmentIndexSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segments</em>' reference list.
	 * @see #isSetSegments()
	 * @see #unsetSegments()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedPolyCurve_Segments()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcSegmentIndexSelect> getSegments();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedPolyCurve#getSegments <em>Segments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSegments()
	 * @see #getSegments()
	 * @generated
	 */
	void unsetSegments();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcIndexedPolyCurve#getSegments <em>Segments</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Segments</em>' reference list is set.
	 * @see #unsetSegments()
	 * @see #getSegments()
	 * @generated
	 */
	boolean isSetSegments();

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
	 * @see #isSetSelfIntersect()
	 * @see #unsetSelfIntersect()
	 * @see #setSelfIntersect(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedPolyCurve_SelfIntersect()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getSelfIntersect();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedPolyCurve#getSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Intersect</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetSelfIntersect()
	 * @see #unsetSelfIntersect()
	 * @see #getSelfIntersect()
	 * @generated
	 */
	void setSelfIntersect(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedPolyCurve#getSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSelfIntersect()
	 * @see #getSelfIntersect()
	 * @see #setSelfIntersect(Tristate)
	 * @generated
	 */
	void unsetSelfIntersect();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcIndexedPolyCurve#getSelfIntersect <em>Self Intersect</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Self Intersect</em>' attribute is set.
	 * @see #unsetSelfIntersect()
	 * @see #getSelfIntersect()
	 * @see #setSelfIntersect(Tristate)
	 * @generated
	 */
	boolean isSetSelfIntersect();

} // IfcIndexedPolyCurve
