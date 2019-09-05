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
 * A representation of the model object '<em><b>Ifc Property Set Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcPropertySetDefinition#getDefinesType <em>Defines Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPropertySetDefinition#getIsDefinedBy <em>Is Defined By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPropertySetDefinition#getDefinesOccurrence <em>Defines Occurrence</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertySetDefinition()
 * @model
 * @generated
 */
public interface IfcPropertySetDefinition extends IfcPropertyDefinition, IfcPropertySetDefinitionSelect {
	/**
	 * Returns the value of the '<em><b>Defines Type</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcTypeObject}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcTypeObject#getHasPropertySets <em>Has Property Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defines Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defines Type</em>' reference list.
	 * @see #isSetDefinesType()
	 * @see #unsetDefinesType()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertySetDefinition_DefinesType()
	 * @see org.bimserver.models.ifc4.IfcTypeObject#getHasPropertySets
	 * @model opposite="HasPropertySets" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcTypeObject> getDefinesType();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertySetDefinition#getDefinesType <em>Defines Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDefinesType()
	 * @see #getDefinesType()
	 * @generated
	 */
	void unsetDefinesType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertySetDefinition#getDefinesType <em>Defines Type</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Defines Type</em>' reference list is set.
	 * @see #unsetDefinesType()
	 * @see #getDefinesType()
	 * @generated
	 */
	boolean isSetDefinesType();

	/**
	 * Returns the value of the '<em><b>Is Defined By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelDefinesByTemplate}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelDefinesByTemplate#getRelatedPropertySets <em>Related Property Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Defined By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Defined By</em>' reference list.
	 * @see #isSetIsDefinedBy()
	 * @see #unsetIsDefinedBy()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertySetDefinition_IsDefinedBy()
	 * @see org.bimserver.models.ifc4.IfcRelDefinesByTemplate#getRelatedPropertySets
	 * @model opposite="RelatedPropertySets" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelDefinesByTemplate> getIsDefinedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertySetDefinition#getIsDefinedBy <em>Is Defined By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsDefinedBy()
	 * @see #getIsDefinedBy()
	 * @generated
	 */
	void unsetIsDefinedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertySetDefinition#getIsDefinedBy <em>Is Defined By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Defined By</em>' reference list is set.
	 * @see #unsetIsDefinedBy()
	 * @see #getIsDefinedBy()
	 * @generated
	 */
	boolean isSetIsDefinedBy();

	/**
	 * Returns the value of the '<em><b>Defines Occurrence</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelDefinesByProperties}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defines Occurrence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defines Occurrence</em>' reference list.
	 * @see #isSetDefinesOccurrence()
	 * @see #unsetDefinesOccurrence()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertySetDefinition_DefinesOccurrence()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelDefinesByProperties> getDefinesOccurrence();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertySetDefinition#getDefinesOccurrence <em>Defines Occurrence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDefinesOccurrence()
	 * @see #getDefinesOccurrence()
	 * @generated
	 */
	void unsetDefinesOccurrence();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertySetDefinition#getDefinesOccurrence <em>Defines Occurrence</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Defines Occurrence</em>' reference list is set.
	 * @see #unsetDefinesOccurrence()
	 * @see #getDefinesOccurrence()
	 * @generated
	 */
	boolean isSetDefinesOccurrence();

} // IfcPropertySetDefinition
