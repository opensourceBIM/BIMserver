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
package org.bimserver.models.ifc4x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcGroup#getIsGroupedBy <em>Is Grouped By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcGroup#getReferencedInStructures <em>Referenced In Structures</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGroup()
 * @model
 * @generated
 */
public interface IfcGroup extends IfcObject, IfcSpatialReferenceSelect {
	/**
	 * Returns the value of the '<em><b>Is Grouped By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcRelAssignsToGroup}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcRelAssignsToGroup#getRelatingGroup <em>Relating Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Grouped By</em>' reference list.
	 * @see #isSetIsGroupedBy()
	 * @see #unsetIsGroupedBy()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGroup_IsGroupedBy()
	 * @see org.bimserver.models.ifc4x3.IfcRelAssignsToGroup#getRelatingGroup
	 * @model opposite="RelatingGroup" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssignsToGroup> getIsGroupedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcGroup#getIsGroupedBy <em>Is Grouped By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsGroupedBy()
	 * @see #getIsGroupedBy()
	 * @generated
	 */
	void unsetIsGroupedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcGroup#getIsGroupedBy <em>Is Grouped By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Grouped By</em>' reference list is set.
	 * @see #unsetIsGroupedBy()
	 * @see #getIsGroupedBy()
	 * @generated
	 */
	boolean isSetIsGroupedBy();

	/**
	 * Returns the value of the '<em><b>Referenced In Structures</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcRelReferencedInSpatialStructure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced In Structures</em>' reference list.
	 * @see #isSetReferencedInStructures()
	 * @see #unsetReferencedInStructures()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcGroup_ReferencedInStructures()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelReferencedInSpatialStructure> getReferencedInStructures();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcGroup#getReferencedInStructures <em>Referenced In Structures</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencedInStructures()
	 * @see #getReferencedInStructures()
	 * @generated
	 */
	void unsetReferencedInStructures();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcGroup#getReferencedInStructures <em>Referenced In Structures</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Referenced In Structures</em>' reference list is set.
	 * @see #unsetReferencedInStructures()
	 * @see #getReferencedInStructures()
	 * @generated
	 */
	boolean isSetReferencedInStructures();

} // IfcGroup
