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
 * A representation of the model object '<em><b>Ifc Move</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMove#getMoveFrom <em>Move From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMove#getMoveTo <em>Move To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMove#getPunchList <em>Punch List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMove()
 * @model
 * @generated
 */
public interface IfcMove extends IfcTask {
	/**
	 * Returns the value of the '<em><b>Move From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Move From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Move From</em>' reference.
	 * @see #isSetMoveFrom()
	 * @see #unsetMoveFrom()
	 * @see #setMoveFrom(IfcSpatialStructureElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMove_MoveFrom()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSpatialStructureElement getMoveFrom();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMove#getMoveFrom <em>Move From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Move From</em>' reference.
	 * @see #isSetMoveFrom()
	 * @see #unsetMoveFrom()
	 * @see #getMoveFrom()
	 * @generated
	 */
	void setMoveFrom(IfcSpatialStructureElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMove#getMoveFrom <em>Move From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMoveFrom()
	 * @see #getMoveFrom()
	 * @see #setMoveFrom(IfcSpatialStructureElement)
	 * @generated
	 */
	void unsetMoveFrom();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMove#getMoveFrom <em>Move From</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Move From</em>' reference is set.
	 * @see #unsetMoveFrom()
	 * @see #getMoveFrom()
	 * @see #setMoveFrom(IfcSpatialStructureElement)
	 * @generated
	 */
	boolean isSetMoveFrom();

	/**
	 * Returns the value of the '<em><b>Move To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Move To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Move To</em>' reference.
	 * @see #isSetMoveTo()
	 * @see #unsetMoveTo()
	 * @see #setMoveTo(IfcSpatialStructureElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMove_MoveTo()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSpatialStructureElement getMoveTo();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMove#getMoveTo <em>Move To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Move To</em>' reference.
	 * @see #isSetMoveTo()
	 * @see #unsetMoveTo()
	 * @see #getMoveTo()
	 * @generated
	 */
	void setMoveTo(IfcSpatialStructureElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMove#getMoveTo <em>Move To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMoveTo()
	 * @see #getMoveTo()
	 * @see #setMoveTo(IfcSpatialStructureElement)
	 * @generated
	 */
	void unsetMoveTo();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMove#getMoveTo <em>Move To</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Move To</em>' reference is set.
	 * @see #unsetMoveTo()
	 * @see #getMoveTo()
	 * @see #setMoveTo(IfcSpatialStructureElement)
	 * @generated
	 */
	boolean isSetMoveTo();

	/**
	 * Returns the value of the '<em><b>Punch List</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Punch List</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Punch List</em>' attribute list.
	 * @see #isSetPunchList()
	 * @see #unsetPunchList()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMove_PunchList()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getPunchList();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMove#getPunchList <em>Punch List</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPunchList()
	 * @see #getPunchList()
	 * @generated
	 */
	void unsetPunchList();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMove#getPunchList <em>Punch List</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Punch List</em>' attribute list is set.
	 * @see #unsetPunchList()
	 * @see #getPunchList()
	 * @generated
	 */
	boolean isSetPunchList();

} // IfcMove
