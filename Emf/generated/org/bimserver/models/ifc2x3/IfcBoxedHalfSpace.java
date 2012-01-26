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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Boxed Half Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoxedHalfSpace#getEnclosure <em>Enclosure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoxedHalfSpace()
 * @model
 * @generated
 */
public interface IfcBoxedHalfSpace extends IfcHalfSpaceSolid {
	/**
	 * Returns the value of the '<em><b>Enclosure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enclosure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enclosure</em>' reference.
	 * @see #isSetEnclosure()
	 * @see #unsetEnclosure()
	 * @see #setEnclosure(IfcBoundingBox)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoxedHalfSpace_Enclosure()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcBoundingBox getEnclosure();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoxedHalfSpace#getEnclosure <em>Enclosure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enclosure</em>' reference.
	 * @see #isSetEnclosure()
	 * @see #unsetEnclosure()
	 * @see #getEnclosure()
	 * @generated
	 */
	void setEnclosure(IfcBoundingBox value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoxedHalfSpace#getEnclosure <em>Enclosure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEnclosure()
	 * @see #getEnclosure()
	 * @see #setEnclosure(IfcBoundingBox)
	 * @generated
	 */
	void unsetEnclosure();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoxedHalfSpace#getEnclosure <em>Enclosure</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Enclosure</em>' reference is set.
	 * @see #unsetEnclosure()
	 * @see #getEnclosure()
	 * @see #setEnclosure(IfcBoundingBox)
	 * @generated
	 */
	boolean isSetEnclosure();

} // IfcBoxedHalfSpace
