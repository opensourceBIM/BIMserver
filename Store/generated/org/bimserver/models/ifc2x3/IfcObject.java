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
 * A representation of the model object '<em><b>Ifc Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcObject#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcObject#getIsDefinedBy <em>Is Defined By</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObject()
 * @model
 * @generated
 */
public interface IfcObject extends IfcObjectDefinition
{
	/**
	 * Returns the value of the '<em><b>Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Type</em>' attribute.
	 * @see #isSetObjectType()
	 * @see #unsetObjectType()
	 * @see #setObjectType(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObject_ObjectType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getObjectType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcObject#getObjectType <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Type</em>' attribute.
	 * @see #isSetObjectType()
	 * @see #unsetObjectType()
	 * @see #getObjectType()
	 * @generated
	 */
	void setObjectType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcObject#getObjectType <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetObjectType()
	 * @see #getObjectType()
	 * @see #setObjectType(String)
	 * @generated
	 */
	void unsetObjectType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcObject#getObjectType <em>Object Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Object Type</em>' attribute is set.
	 * @see #unsetObjectType()
	 * @see #getObjectType()
	 * @see #setObjectType(String)
	 * @generated
	 */
	boolean isSetObjectType();

	/**
	 * Returns the value of the '<em><b>Is Defined By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelDefines}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelDefines#getRelatedObjects <em>Related Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Defined By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Defined By</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObject_IsDefinedBy()
	 * @see org.bimserver.models.ifc2x3.IfcRelDefines#getRelatedObjects
	 * @model opposite="RelatedObjects"
	 * @generated
	 */
	EList<IfcRelDefines> getIsDefinedBy();

} // IfcObject
