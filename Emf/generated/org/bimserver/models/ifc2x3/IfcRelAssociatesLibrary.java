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
 * A representation of the model object '<em><b>Ifc Rel Associates Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssociatesLibrary#getRelatingLibrary <em>Relating Library</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssociatesLibrary()
 * @model
 * @generated
 */
public interface IfcRelAssociatesLibrary extends IfcRelAssociates {
	/**
	 * Returns the value of the '<em><b>Relating Library</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Library</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Library</em>' reference.
	 * @see #isSetRelatingLibrary()
	 * @see #unsetRelatingLibrary()
	 * @see #setRelatingLibrary(IfcLibrarySelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssociatesLibrary_RelatingLibrary()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLibrarySelect getRelatingLibrary();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssociatesLibrary#getRelatingLibrary <em>Relating Library</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Library</em>' reference.
	 * @see #isSetRelatingLibrary()
	 * @see #unsetRelatingLibrary()
	 * @see #getRelatingLibrary()
	 * @generated
	 */
	void setRelatingLibrary(IfcLibrarySelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssociatesLibrary#getRelatingLibrary <em>Relating Library</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingLibrary()
	 * @see #getRelatingLibrary()
	 * @see #setRelatingLibrary(IfcLibrarySelect)
	 * @generated
	 */
	void unsetRelatingLibrary();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssociatesLibrary#getRelatingLibrary <em>Relating Library</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Library</em>' reference is set.
	 * @see #unsetRelatingLibrary()
	 * @see #getRelatingLibrary()
	 * @see #setRelatingLibrary(IfcLibrarySelect)
	 * @generated
	 */
	boolean isSetRelatingLibrary();

} // IfcRelAssociatesLibrary
