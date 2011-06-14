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
 * A representation of the model object '<em><b>Ifc Property Set Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertySetDefinition#getPropertyDefinitionOf <em>Property Definition Of</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertySetDefinition#getDefinesType <em>Defines Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertySetDefinition()
 * @model
 * @generated
 */
public interface IfcPropertySetDefinition extends IfcPropertyDefinition
{
	/**
	 * Returns the value of the '<em><b>Property Definition Of</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelDefinesByProperties}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelDefinesByProperties#getRelatingPropertyDefinition <em>Relating Property Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Definition Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Definition Of</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertySetDefinition_PropertyDefinitionOf()
	 * @see org.bimserver.models.ifc2x3.IfcRelDefinesByProperties#getRelatingPropertyDefinition
	 * @model opposite="RelatingPropertyDefinition" upper="2"
	 * @generated
	 */
	EList<IfcRelDefinesByProperties> getPropertyDefinitionOf();

	/**
	 * Returns the value of the '<em><b>Defines Type</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcTypeObject}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcTypeObject#getHasPropertySets <em>Has Property Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defines Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defines Type</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertySetDefinition_DefinesType()
	 * @see org.bimserver.models.ifc2x3.IfcTypeObject#getHasPropertySets
	 * @model opposite="HasPropertySets" upper="2"
	 * @generated
	 */
	EList<IfcTypeObject> getDefinesType();

} // IfcPropertySetDefinition
