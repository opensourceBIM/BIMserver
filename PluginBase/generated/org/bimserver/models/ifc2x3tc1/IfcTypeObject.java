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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Type Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTypeObject#getApplicableOccurrence <em>Applicable Occurrence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTypeObject#getHasPropertySets <em>Has Property Sets</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTypeObject#getObjectTypeOf <em>Object Type Of</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTypeObject()
 * @model
 * @generated
 */
public interface IfcTypeObject extends IfcObjectDefinition {
	/**
	 * Returns the value of the '<em><b>Applicable Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applicable Occurrence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicable Occurrence</em>' attribute.
	 * @see #isSetApplicableOccurrence()
	 * @see #unsetApplicableOccurrence()
	 * @see #setApplicableOccurrence(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTypeObject_ApplicableOccurrence()
	 * @model unsettable="true"
	 * @generated
	 */
	String getApplicableOccurrence();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTypeObject#getApplicableOccurrence <em>Applicable Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applicable Occurrence</em>' attribute.
	 * @see #isSetApplicableOccurrence()
	 * @see #unsetApplicableOccurrence()
	 * @see #getApplicableOccurrence()
	 * @generated
	 */
	void setApplicableOccurrence(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTypeObject#getApplicableOccurrence <em>Applicable Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplicableOccurrence()
	 * @see #getApplicableOccurrence()
	 * @see #setApplicableOccurrence(String)
	 * @generated
	 */
	void unsetApplicableOccurrence();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTypeObject#getApplicableOccurrence <em>Applicable Occurrence</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applicable Occurrence</em>' attribute is set.
	 * @see #unsetApplicableOccurrence()
	 * @see #getApplicableOccurrence()
	 * @see #setApplicableOccurrence(String)
	 * @generated
	 */
	boolean isSetApplicableOccurrence();

	/**
	 * Returns the value of the '<em><b>Has Property Sets</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition#getDefinesType <em>Defines Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Property Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Property Sets</em>' reference list.
	 * @see #isSetHasPropertySets()
	 * @see #unsetHasPropertySets()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTypeObject_HasPropertySets()
	 * @see org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition#getDefinesType
	 * @model opposite="DefinesType" unsettable="true"
	 * @generated
	 */
	EList<IfcPropertySetDefinition> getHasPropertySets();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTypeObject#getHasPropertySets <em>Has Property Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasPropertySets()
	 * @see #getHasPropertySets()
	 * @generated
	 */
	void unsetHasPropertySets();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTypeObject#getHasPropertySets <em>Has Property Sets</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Property Sets</em>' reference list is set.
	 * @see #unsetHasPropertySets()
	 * @see #getHasPropertySets()
	 * @generated
	 */
	boolean isSetHasPropertySets();

	/**
	 * Returns the value of the '<em><b>Object Type Of</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType#getRelatingType <em>Relating Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Type Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Type Of</em>' reference list.
	 * @see #isSetObjectTypeOf()
	 * @see #unsetObjectTypeOf()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTypeObject_ObjectTypeOf()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType#getRelatingType
	 * @model opposite="RelatingType" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcRelDefinesByType> getObjectTypeOf();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTypeObject#getObjectTypeOf <em>Object Type Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetObjectTypeOf()
	 * @see #getObjectTypeOf()
	 * @generated
	 */
	void unsetObjectTypeOf();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTypeObject#getObjectTypeOf <em>Object Type Of</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Object Type Of</em>' reference list is set.
	 * @see #unsetObjectTypeOf()
	 * @see #getObjectTypeOf()
	 * @generated
	 */
	boolean isSetObjectTypeOf();

} // IfcTypeObject
