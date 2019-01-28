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
 * A representation of the model object '<em><b>Ifc Reinforcement Definition Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementDefinitionProperties#getDefinitionType <em>Definition Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementDefinitionProperties#getReinforcementSectionDefinitions <em>Reinforcement Section Definitions</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementDefinitionProperties()
 * @model
 * @generated
 */
public interface IfcReinforcementDefinitionProperties extends IfcPropertySetDefinition {
	/**
	 * Returns the value of the '<em><b>Definition Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition Type</em>' attribute.
	 * @see #isSetDefinitionType()
	 * @see #unsetDefinitionType()
	 * @see #setDefinitionType(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementDefinitionProperties_DefinitionType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDefinitionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementDefinitionProperties#getDefinitionType <em>Definition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition Type</em>' attribute.
	 * @see #isSetDefinitionType()
	 * @see #unsetDefinitionType()
	 * @see #getDefinitionType()
	 * @generated
	 */
	void setDefinitionType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementDefinitionProperties#getDefinitionType <em>Definition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDefinitionType()
	 * @see #getDefinitionType()
	 * @see #setDefinitionType(String)
	 * @generated
	 */
	void unsetDefinitionType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcReinforcementDefinitionProperties#getDefinitionType <em>Definition Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Definition Type</em>' attribute is set.
	 * @see #unsetDefinitionType()
	 * @see #getDefinitionType()
	 * @see #setDefinitionType(String)
	 * @generated
	 */
	boolean isSetDefinitionType();

	/**
	 * Returns the value of the '<em><b>Reinforcement Section Definitions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcSectionReinforcementProperties}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reinforcement Section Definitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reinforcement Section Definitions</em>' reference list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcReinforcementDefinitionProperties_ReinforcementSectionDefinitions()
	 * @model
	 * @generated
	 */
	EList<IfcSectionReinforcementProperties> getReinforcementSectionDefinitions();

} // IfcReinforcementDefinitionProperties
