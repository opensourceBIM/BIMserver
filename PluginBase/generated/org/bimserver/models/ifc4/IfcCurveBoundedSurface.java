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
 * A representation of the model object '<em><b>Ifc Curve Bounded Surface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcCurveBoundedSurface#getBasisSurface <em>Basis Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcCurveBoundedSurface#getBoundaries <em>Boundaries</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcCurveBoundedSurface#getImplicitOuter <em>Implicit Outer</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCurveBoundedSurface()
 * @model
 * @generated
 */
public interface IfcCurveBoundedSurface extends IfcBoundedSurface {
	/**
	 * Returns the value of the '<em><b>Basis Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basis Surface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basis Surface</em>' reference.
	 * @see #setBasisSurface(IfcSurface)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCurveBoundedSurface_BasisSurface()
	 * @model
	 * @generated
	 */
	IfcSurface getBasisSurface();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCurveBoundedSurface#getBasisSurface <em>Basis Surface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis Surface</em>' reference.
	 * @see #getBasisSurface()
	 * @generated
	 */
	void setBasisSurface(IfcSurface value);

	/**
	 * Returns the value of the '<em><b>Boundaries</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcBoundaryCurve}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boundaries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boundaries</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCurveBoundedSurface_Boundaries()
	 * @model
	 * @generated
	 */
	EList<IfcBoundaryCurve> getBoundaries();

	/**
	 * Returns the value of the '<em><b>Implicit Outer</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implicit Outer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implicit Outer</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setImplicitOuter(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCurveBoundedSurface_ImplicitOuter()
	 * @model
	 * @generated
	 */
	Tristate getImplicitOuter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCurveBoundedSurface#getImplicitOuter <em>Implicit Outer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit Outer</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getImplicitOuter()
	 * @generated
	 */
	void setImplicitOuter(Tristate value);

} // IfcCurveBoundedSurface
