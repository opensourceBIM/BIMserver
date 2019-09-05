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
 * A representation of the model object '<em><b>Ifc Rel Space Boundary1st Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel#getParentBoundary <em>Parent Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel#getInnerBoundaries <em>Inner Boundaries</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelSpaceBoundary1stLevel()
 * @model
 * @generated
 */
public interface IfcRelSpaceBoundary1stLevel extends IfcRelSpaceBoundary {
	/**
	 * Returns the value of the '<em><b>Parent Boundary</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel#getInnerBoundaries <em>Inner Boundaries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Boundary</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Boundary</em>' reference.
	 * @see #isSetParentBoundary()
	 * @see #unsetParentBoundary()
	 * @see #setParentBoundary(IfcRelSpaceBoundary1stLevel)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelSpaceBoundary1stLevel_ParentBoundary()
	 * @see org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel#getInnerBoundaries
	 * @model opposite="InnerBoundaries" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcRelSpaceBoundary1stLevel getParentBoundary();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel#getParentBoundary <em>Parent Boundary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Boundary</em>' reference.
	 * @see #isSetParentBoundary()
	 * @see #unsetParentBoundary()
	 * @see #getParentBoundary()
	 * @generated
	 */
	void setParentBoundary(IfcRelSpaceBoundary1stLevel value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel#getParentBoundary <em>Parent Boundary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParentBoundary()
	 * @see #getParentBoundary()
	 * @see #setParentBoundary(IfcRelSpaceBoundary1stLevel)
	 * @generated
	 */
	void unsetParentBoundary();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel#getParentBoundary <em>Parent Boundary</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parent Boundary</em>' reference is set.
	 * @see #unsetParentBoundary()
	 * @see #getParentBoundary()
	 * @see #setParentBoundary(IfcRelSpaceBoundary1stLevel)
	 * @generated
	 */
	boolean isSetParentBoundary();

	/**
	 * Returns the value of the '<em><b>Inner Boundaries</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel#getParentBoundary <em>Parent Boundary</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Boundaries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Boundaries</em>' reference list.
	 * @see #isSetInnerBoundaries()
	 * @see #unsetInnerBoundaries()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelSpaceBoundary1stLevel_InnerBoundaries()
	 * @see org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel#getParentBoundary
	 * @model opposite="ParentBoundary" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelSpaceBoundary1stLevel> getInnerBoundaries();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel#getInnerBoundaries <em>Inner Boundaries</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInnerBoundaries()
	 * @see #getInnerBoundaries()
	 * @generated
	 */
	void unsetInnerBoundaries();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary1stLevel#getInnerBoundaries <em>Inner Boundaries</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inner Boundaries</em>' reference list is set.
	 * @see #unsetInnerBoundaries()
	 * @see #getInnerBoundaries()
	 * @generated
	 */
	boolean isSetInnerBoundaries();

} // IfcRelSpaceBoundary1stLevel
