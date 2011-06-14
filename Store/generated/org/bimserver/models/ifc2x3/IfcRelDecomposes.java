/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Decomposes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelDecomposes#getRelatingObject <em>Relating Object</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelDecomposes#getRelatedObjects <em>Related Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelDecomposes()
 * @model
 * @generated
 */
public interface IfcRelDecomposes extends IfcRelationship
{
	/**
	 * Returns the value of the '<em><b>Relating Object</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcObjectDefinition#getIsDecomposedBy <em>Is Decomposed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Object</em>' reference.
	 * @see #setRelatingObject(IfcObjectDefinition)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelDecomposes_RelatingObject()
	 * @see org.bimserver.models.ifc2x3.IfcObjectDefinition#getIsDecomposedBy
	 * @model opposite="IsDecomposedBy"
	 * @generated
	 */
	IfcObjectDefinition getRelatingObject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelDecomposes#getRelatingObject <em>Relating Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Object</em>' reference.
	 * @see #getRelatingObject()
	 * @generated
	 */
	void setRelatingObject(IfcObjectDefinition value);

	/**
	 * Returns the value of the '<em><b>Related Objects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcObjectDefinition}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcObjectDefinition#getDecomposes <em>Decomposes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Objects</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelDecomposes_RelatedObjects()
	 * @see org.bimserver.models.ifc2x3.IfcObjectDefinition#getDecomposes
	 * @model opposite="Decomposes"
	 * @generated
	 */
	EList<IfcObjectDefinition> getRelatedObjects();

} // IfcRelDecomposes
