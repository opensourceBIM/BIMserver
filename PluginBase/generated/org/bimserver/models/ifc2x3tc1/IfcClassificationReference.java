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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcClassificationReference extends IfcExternalReference, IfcClassificationNotationSelect {
	/**
	 * Returns the value of the '<em><b>Referenced Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Source</em>' reference.
	 * @see #isSetReferencedSource()
	 * @see #unsetReferencedSource()
	 * @see #setReferencedSource(IfcClassification)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcClassificationReference_ReferencedSource()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcClassification getReferencedSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcClassificationReference#getReferencedSource <em>Referenced Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Source</em>' reference.
	 * @see #isSetReferencedSource()
	 * @see #unsetReferencedSource()
	 * @see #getReferencedSource()
	 * @generated
	 */
	void setReferencedSource(IfcClassification value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcClassificationReference#getReferencedSource <em>Referenced Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencedSource()
	 * @see #getReferencedSource()
	 * @see #setReferencedSource(IfcClassification)
	 * @generated
	 */
	void unsetReferencedSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcClassificationReference#getReferencedSource <em>Referenced Source</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Referenced Source</em>' reference is set.
	 * @see #unsetReferencedSource()
	 * @see #getReferencedSource()
	 * @see #setReferencedSource(IfcClassification)
	 * @generated
	 */
	boolean isSetReferencedSource();

} // IfcClassificationReference
