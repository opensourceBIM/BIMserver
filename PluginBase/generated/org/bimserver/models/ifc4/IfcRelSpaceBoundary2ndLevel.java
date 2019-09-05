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
 * A representation of the model object '<em><b>Ifc Rel Space Boundary2nd Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel#getCorrespondingBoundary <em>Corresponding Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel#getCorresponds <em>Corresponds</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelSpaceBoundary2ndLevel()
 * @model
 * @generated
 */
public interface IfcRelSpaceBoundary2ndLevel extends IfcRelSpaceBoundary1stLevel {
	/**
	 * Returns the value of the '<em><b>Corresponding Boundary</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel#getCorresponds <em>Corresponds</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corresponding Boundary</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corresponding Boundary</em>' reference.
	 * @see #isSetCorrespondingBoundary()
	 * @see #unsetCorrespondingBoundary()
	 * @see #setCorrespondingBoundary(IfcRelSpaceBoundary2ndLevel)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelSpaceBoundary2ndLevel_CorrespondingBoundary()
	 * @see org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel#getCorresponds
	 * @model opposite="Corresponds" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcRelSpaceBoundary2ndLevel getCorrespondingBoundary();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel#getCorrespondingBoundary <em>Corresponding Boundary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Corresponding Boundary</em>' reference.
	 * @see #isSetCorrespondingBoundary()
	 * @see #unsetCorrespondingBoundary()
	 * @see #getCorrespondingBoundary()
	 * @generated
	 */
	void setCorrespondingBoundary(IfcRelSpaceBoundary2ndLevel value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel#getCorrespondingBoundary <em>Corresponding Boundary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCorrespondingBoundary()
	 * @see #getCorrespondingBoundary()
	 * @see #setCorrespondingBoundary(IfcRelSpaceBoundary2ndLevel)
	 * @generated
	 */
	void unsetCorrespondingBoundary();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel#getCorrespondingBoundary <em>Corresponding Boundary</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Corresponding Boundary</em>' reference is set.
	 * @see #unsetCorrespondingBoundary()
	 * @see #getCorrespondingBoundary()
	 * @see #setCorrespondingBoundary(IfcRelSpaceBoundary2ndLevel)
	 * @generated
	 */
	boolean isSetCorrespondingBoundary();

	/**
	 * Returns the value of the '<em><b>Corresponds</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel#getCorrespondingBoundary <em>Corresponding Boundary</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corresponds</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corresponds</em>' reference list.
	 * @see #isSetCorresponds()
	 * @see #unsetCorresponds()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelSpaceBoundary2ndLevel_Corresponds()
	 * @see org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel#getCorrespondingBoundary
	 * @model opposite="CorrespondingBoundary" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelSpaceBoundary2ndLevel> getCorresponds();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel#getCorresponds <em>Corresponds</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCorresponds()
	 * @see #getCorresponds()
	 * @generated
	 */
	void unsetCorresponds();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel#getCorresponds <em>Corresponds</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Corresponds</em>' reference list is set.
	 * @see #unsetCorresponds()
	 * @see #getCorresponds()
	 * @generated
	 */
	boolean isSetCorresponds();

} // IfcRelSpaceBoundary2ndLevel
