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
 * A representation of the model object '<em><b>Ifc Material</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterial#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterial#getHasRepresentation <em>Has Representation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterial#getClassifiedAs <em>Classified As</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterial()
 * @model
 * @generated
 */
public interface IfcMaterial extends IfcMaterialSelect, IfcObjectReferenceSelect
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterial_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterial#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Has Representation</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcMaterialDefinitionRepresentation}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcMaterialDefinitionRepresentation#getRepresentedMaterial <em>Represented Material</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Representation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Representation</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterial_HasRepresentation()
	 * @see org.bimserver.models.ifc2x3.IfcMaterialDefinitionRepresentation#getRepresentedMaterial
	 * @model opposite="RepresentedMaterial" upper="2"
	 * @generated
	 */
	EList<IfcMaterialDefinitionRepresentation> getHasRepresentation();

	/**
	 * Returns the value of the '<em><b>Classified As</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcMaterialClassificationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcMaterialClassificationRelationship#getClassifiedMaterial <em>Classified Material</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classified As</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classified As</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterial_ClassifiedAs()
	 * @see org.bimserver.models.ifc2x3.IfcMaterialClassificationRelationship#getClassifiedMaterial
	 * @model opposite="ClassifiedMaterial" upper="2"
	 * @generated
	 */
	EList<IfcMaterialClassificationRelationship> getClassifiedAs();

} // IfcMaterial
