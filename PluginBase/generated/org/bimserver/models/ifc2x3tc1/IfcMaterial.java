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
 * A representation of the model object '<em><b>Ifc Material</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMaterial#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMaterial#getHasRepresentation <em>Has Representation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMaterial#getClassifiedAs <em>Classified As</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterial()
 * @model
 * @generated
 */
public interface IfcMaterial extends IfcMaterialSelect, IfcObjectReferenceSelect {
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterial_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterial#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Has Representation</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcMaterialDefinitionRepresentation}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialDefinitionRepresentation#getRepresentedMaterial <em>Represented Material</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Representation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Representation</em>' reference list.
	 * @see #isSetHasRepresentation()
	 * @see #unsetHasRepresentation()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterial_HasRepresentation()
	 * @see org.bimserver.models.ifc2x3tc1.IfcMaterialDefinitionRepresentation#getRepresentedMaterial
	 * @model opposite="RepresentedMaterial" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcMaterialDefinitionRepresentation> getHasRepresentation();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterial#getHasRepresentation <em>Has Representation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasRepresentation()
	 * @see #getHasRepresentation()
	 * @generated
	 */
	void unsetHasRepresentation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterial#getHasRepresentation <em>Has Representation</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Representation</em>' reference list is set.
	 * @see #unsetHasRepresentation()
	 * @see #getHasRepresentation()
	 * @generated
	 */
	boolean isSetHasRepresentation();

	/**
	 * Returns the value of the '<em><b>Classified As</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcMaterialClassificationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialClassificationRelationship#getClassifiedMaterial <em>Classified Material</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classified As</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classified As</em>' reference list.
	 * @see #isSetClassifiedAs()
	 * @see #unsetClassifiedAs()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterial_ClassifiedAs()
	 * @see org.bimserver.models.ifc2x3tc1.IfcMaterialClassificationRelationship#getClassifiedMaterial
	 * @model opposite="ClassifiedMaterial" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcMaterialClassificationRelationship> getClassifiedAs();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterial#getClassifiedAs <em>Classified As</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetClassifiedAs()
	 * @see #getClassifiedAs()
	 * @generated
	 */
	void unsetClassifiedAs();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterial#getClassifiedAs <em>Classified As</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Classified As</em>' reference list is set.
	 * @see #unsetClassifiedAs()
	 * @see #getClassifiedAs()
	 * @generated
	 */
	boolean isSetClassifiedAs();

} // IfcMaterial
