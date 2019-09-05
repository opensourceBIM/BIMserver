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
 * A representation of the model object '<em><b>Ifc Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcObject#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObject#getIsDeclaredBy <em>Is Declared By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObject#getDeclares <em>Declares</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObject#getIsTypedBy <em>Is Typed By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObject#getIsDefinedBy <em>Is Defined By</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObject()
 * @model
 * @generated
 */
public interface IfcObject extends IfcObjectDefinition {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObject_ObjectType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getObjectType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcObject#getObjectType <em>Object Type</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObject#getObjectType <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetObjectType()
	 * @see #getObjectType()
	 * @see #setObjectType(String)
	 * @generated
	 */
	void unsetObjectType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObject#getObjectType <em>Object Type</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Is Declared By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelDefinesByObject}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelDefinesByObject#getRelatedObjects <em>Related Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Declared By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Declared By</em>' reference list.
	 * @see #isSetIsDeclaredBy()
	 * @see #unsetIsDeclaredBy()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObject_IsDeclaredBy()
	 * @see org.bimserver.models.ifc4.IfcRelDefinesByObject#getRelatedObjects
	 * @model opposite="RelatedObjects" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelDefinesByObject> getIsDeclaredBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObject#getIsDeclaredBy <em>Is Declared By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsDeclaredBy()
	 * @see #getIsDeclaredBy()
	 * @generated
	 */
	void unsetIsDeclaredBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObject#getIsDeclaredBy <em>Is Declared By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Declared By</em>' reference list is set.
	 * @see #unsetIsDeclaredBy()
	 * @see #getIsDeclaredBy()
	 * @generated
	 */
	boolean isSetIsDeclaredBy();

	/**
	 * Returns the value of the '<em><b>Declares</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelDefinesByObject}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelDefinesByObject#getRelatingObject <em>Relating Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declares</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declares</em>' reference list.
	 * @see #isSetDeclares()
	 * @see #unsetDeclares()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObject_Declares()
	 * @see org.bimserver.models.ifc4.IfcRelDefinesByObject#getRelatingObject
	 * @model opposite="RelatingObject" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelDefinesByObject> getDeclares();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObject#getDeclares <em>Declares</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeclares()
	 * @see #getDeclares()
	 * @generated
	 */
	void unsetDeclares();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObject#getDeclares <em>Declares</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Declares</em>' reference list is set.
	 * @see #unsetDeclares()
	 * @see #getDeclares()
	 * @generated
	 */
	boolean isSetDeclares();

	/**
	 * Returns the value of the '<em><b>Is Typed By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelDefinesByType}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelDefinesByType#getRelatedObjects <em>Related Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Typed By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Typed By</em>' reference list.
	 * @see #isSetIsTypedBy()
	 * @see #unsetIsTypedBy()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObject_IsTypedBy()
	 * @see org.bimserver.models.ifc4.IfcRelDefinesByType#getRelatedObjects
	 * @model opposite="RelatedObjects" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelDefinesByType> getIsTypedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObject#getIsTypedBy <em>Is Typed By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsTypedBy()
	 * @see #getIsTypedBy()
	 * @generated
	 */
	void unsetIsTypedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObject#getIsTypedBy <em>Is Typed By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Typed By</em>' reference list is set.
	 * @see #unsetIsTypedBy()
	 * @see #getIsTypedBy()
	 * @generated
	 */
	boolean isSetIsTypedBy();

	/**
	 * Returns the value of the '<em><b>Is Defined By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelDefinesByProperties}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Defined By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Defined By</em>' reference list.
	 * @see #isSetIsDefinedBy()
	 * @see #unsetIsDefinedBy()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObject_IsDefinedBy()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelDefinesByProperties> getIsDefinedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObject#getIsDefinedBy <em>Is Defined By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsDefinedBy()
	 * @see #getIsDefinedBy()
	 * @generated
	 */
	void unsetIsDefinedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObject#getIsDefinedBy <em>Is Defined By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Defined By</em>' reference list is set.
	 * @see #unsetIsDefinedBy()
	 * @see #getIsDefinedBy()
	 * @generated
	 */
	boolean isSetIsDefinedBy();

} // IfcObject
