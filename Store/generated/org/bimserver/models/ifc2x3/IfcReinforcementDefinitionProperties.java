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
 * A representation of the model object '<em><b>Ifc Reinforcement Definition Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcReinforcementDefinitionProperties#getDefinitionType <em>Definition Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcReinforcementDefinitionProperties#getReinforcementSectionDefinitions <em>Reinforcement Section Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcementDefinitionProperties()
 * @model
 * @generated
 */
public interface IfcReinforcementDefinitionProperties extends IfcPropertySetDefinition
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcementDefinitionProperties_DefinitionType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDefinitionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcementDefinitionProperties#getDefinitionType <em>Definition Type</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcementDefinitionProperties#getDefinitionType <em>Definition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDefinitionType()
	 * @see #getDefinitionType()
	 * @see #setDefinitionType(String)
	 * @generated
	 */
	void unsetDefinitionType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcementDefinitionProperties#getDefinitionType <em>Definition Type</em>}' attribute is set.
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
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reinforcement Section Definitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reinforcement Section Definitions</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcementDefinitionProperties_ReinforcementSectionDefinitions()
	 * @model
	 * @generated
	 */
	EList<IfcSectionReinforcementProperties> getReinforcementSectionDefinitions();

} // IfcReinforcementDefinitionProperties
