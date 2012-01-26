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
 * A representation of the model object '<em><b>Ifc Curve Bounded Plane</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getBasisSurface <em>Basis Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getOuterBoundary <em>Outer Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getInnerBoundaries <em>Inner Boundaries</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveBoundedPlane()
 * @model
 * @generated
 */
public interface IfcCurveBoundedPlane extends IfcBoundedSurface {
	/**
	 * Returns the value of the '<em><b>Basis Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basis Surface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basis Surface</em>' reference.
	 * @see #isSetBasisSurface()
	 * @see #unsetBasisSurface()
	 * @see #setBasisSurface(IfcPlane)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveBoundedPlane_BasisSurface()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPlane getBasisSurface();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getBasisSurface <em>Basis Surface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis Surface</em>' reference.
	 * @see #isSetBasisSurface()
	 * @see #unsetBasisSurface()
	 * @see #getBasisSurface()
	 * @generated
	 */
	void setBasisSurface(IfcPlane value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getBasisSurface <em>Basis Surface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBasisSurface()
	 * @see #getBasisSurface()
	 * @see #setBasisSurface(IfcPlane)
	 * @generated
	 */
	void unsetBasisSurface();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getBasisSurface <em>Basis Surface</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Basis Surface</em>' reference is set.
	 * @see #unsetBasisSurface()
	 * @see #getBasisSurface()
	 * @see #setBasisSurface(IfcPlane)
	 * @generated
	 */
	boolean isSetBasisSurface();

	/**
	 * Returns the value of the '<em><b>Outer Boundary</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Boundary</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Boundary</em>' reference.
	 * @see #isSetOuterBoundary()
	 * @see #unsetOuterBoundary()
	 * @see #setOuterBoundary(IfcCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveBoundedPlane_OuterBoundary()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCurve getOuterBoundary();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getOuterBoundary <em>Outer Boundary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Boundary</em>' reference.
	 * @see #isSetOuterBoundary()
	 * @see #unsetOuterBoundary()
	 * @see #getOuterBoundary()
	 * @generated
	 */
	void setOuterBoundary(IfcCurve value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getOuterBoundary <em>Outer Boundary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOuterBoundary()
	 * @see #getOuterBoundary()
	 * @see #setOuterBoundary(IfcCurve)
	 * @generated
	 */
	void unsetOuterBoundary();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getOuterBoundary <em>Outer Boundary</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Outer Boundary</em>' reference is set.
	 * @see #unsetOuterBoundary()
	 * @see #getOuterBoundary()
	 * @see #setOuterBoundary(IfcCurve)
	 * @generated
	 */
	boolean isSetOuterBoundary();

	/**
	 * Returns the value of the '<em><b>Inner Boundaries</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcCurve}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Boundaries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Boundaries</em>' reference list.
	 * @see #isSetInnerBoundaries()
	 * @see #unsetInnerBoundaries()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveBoundedPlane_InnerBoundaries()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcCurve> getInnerBoundaries();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getInnerBoundaries <em>Inner Boundaries</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInnerBoundaries()
	 * @see #getInnerBoundaries()
	 * @generated
	 */
	void unsetInnerBoundaries();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getInnerBoundaries <em>Inner Boundaries</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inner Boundaries</em>' reference list is set.
	 * @see #unsetInnerBoundaries()
	 * @see #getInnerBoundaries()
	 * @generated
	 */
	boolean isSetInnerBoundaries();

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #setDim(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveBoundedPlane_Dim()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	void unsetDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveBoundedPlane#getDim <em>Dim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dim</em>' attribute is set.
	 * @see #unsetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	boolean isSetDim();

} // IfcCurveBoundedPlane
