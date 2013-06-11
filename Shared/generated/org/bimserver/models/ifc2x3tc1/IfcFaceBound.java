/**
 * Copyright (C) 2009-2013 BIMserver.org
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Face Bound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcFaceBound#getBound <em>Bound</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcFaceBound#getOrientation <em>Orientation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcFaceBound()
 * @model
 * @generated
 */
public interface IfcFaceBound extends IfcTopologicalRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound</em>' reference.
	 * @see #setBound(IfcLoop)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcFaceBound_Bound()
	 * @model
	 * @generated
	 */
	IfcLoop getBound();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFaceBound#getBound <em>Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound</em>' reference.
	 * @see #getBound()
	 * @generated
	 */
	void setBound(IfcLoop value);

	/**
	 * Returns the value of the '<em><b>Orientation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orientation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientation</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #setOrientation(Tristate)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcFaceBound_Orientation()
	 * @model
	 * @generated
	 */
	Tristate getOrientation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFaceBound#getOrientation <em>Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #getOrientation()
	 * @generated
	 */
	void setOrientation(Tristate value);

} // IfcFaceBound
