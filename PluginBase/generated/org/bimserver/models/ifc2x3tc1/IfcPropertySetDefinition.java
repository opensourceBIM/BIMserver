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
 * A representation of the model object '<em><b>Ifc Property Set Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition#getPropertyDefinitionOf <em>Property Definition Of</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition#getDefinesType <em>Defines Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcPropertySetDefinition()
 * @model
 * @generated
 */
public interface IfcPropertySetDefinition extends IfcPropertyDefinition {
	/**
	 * Returns the value of the '<em><b>Property Definition Of</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties#getRelatingPropertyDefinition <em>Relating Property Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Definition Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Definition Of</em>' reference list.
	 * @see #isSetPropertyDefinitionOf()
	 * @see #unsetPropertyDefinitionOf()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcPropertySetDefinition_PropertyDefinitionOf()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties#getRelatingPropertyDefinition
	 * @model opposite="RelatingPropertyDefinition" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcRelDefinesByProperties> getPropertyDefinitionOf();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition#getPropertyDefinitionOf <em>Property Definition Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPropertyDefinitionOf()
	 * @see #getPropertyDefinitionOf()
	 * @generated
	 */
	void unsetPropertyDefinitionOf();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition#getPropertyDefinitionOf <em>Property Definition Of</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Property Definition Of</em>' reference list is set.
	 * @see #unsetPropertyDefinitionOf()
	 * @see #getPropertyDefinitionOf()
	 * @generated
	 */
	boolean isSetPropertyDefinitionOf();

	/**
	 * Returns the value of the '<em><b>Defines Type</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcTypeObject}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcTypeObject#getHasPropertySets <em>Has Property Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defines Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defines Type</em>' reference list.
	 * @see #isSetDefinesType()
	 * @see #unsetDefinesType()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcPropertySetDefinition_DefinesType()
	 * @see org.bimserver.models.ifc2x3tc1.IfcTypeObject#getHasPropertySets
	 * @model opposite="HasPropertySets" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcTypeObject> getDefinesType();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition#getDefinesType <em>Defines Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDefinesType()
	 * @see #getDefinesType()
	 * @generated
	 */
	void unsetDefinesType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition#getDefinesType <em>Defines Type</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Defines Type</em>' reference list is set.
	 * @see #unsetDefinesType()
	 * @see #getDefinesType()
	 * @generated
	 */
	boolean isSetDefinesType();

} // IfcPropertySetDefinition
