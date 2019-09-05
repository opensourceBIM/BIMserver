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
 * A representation of the model object '<em><b>Ifc Material</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterial#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterial#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterial#getCategory <em>Category</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterial#getHasRepresentation <em>Has Representation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterial#getIsRelatedWith <em>Is Related With</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterial#getRelatesTo <em>Relates To</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterial()
 * @model
 * @generated
 */
public interface IfcMaterial extends IfcMaterialDefinition {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterial_Name()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #setDescription(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterial_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getDescription <em>Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Description</em>' attribute is set.
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	boolean isSetDescription();

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #isSetCategory()
	 * @see #unsetCategory()
	 * @see #setCategory(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterial_Category()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #isSetCategory()
	 * @see #unsetCategory()
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCategory()
	 * @see #getCategory()
	 * @see #setCategory(String)
	 * @generated
	 */
	void unsetCategory();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getCategory <em>Category</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Category</em>' attribute is set.
	 * @see #unsetCategory()
	 * @see #getCategory()
	 * @see #setCategory(String)
	 * @generated
	 */
	boolean isSetCategory();

	/**
	 * Returns the value of the '<em><b>Has Representation</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcMaterialDefinitionRepresentation}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcMaterialDefinitionRepresentation#getRepresentedMaterial <em>Represented Material</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Representation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Representation</em>' reference list.
	 * @see #isSetHasRepresentation()
	 * @see #unsetHasRepresentation()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterial_HasRepresentation()
	 * @see org.bimserver.models.ifc4.IfcMaterialDefinitionRepresentation#getRepresentedMaterial
	 * @model opposite="RepresentedMaterial" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcMaterialDefinitionRepresentation> getHasRepresentation();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getHasRepresentation <em>Has Representation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasRepresentation()
	 * @see #getHasRepresentation()
	 * @generated
	 */
	void unsetHasRepresentation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getHasRepresentation <em>Has Representation</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Representation</em>' reference list is set.
	 * @see #unsetHasRepresentation()
	 * @see #getHasRepresentation()
	 * @generated
	 */
	boolean isSetHasRepresentation();

	/**
	 * Returns the value of the '<em><b>Is Related With</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcMaterialRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcMaterialRelationship#getRelatedMaterials <em>Related Materials</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Related With</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Related With</em>' reference list.
	 * @see #isSetIsRelatedWith()
	 * @see #unsetIsRelatedWith()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterial_IsRelatedWith()
	 * @see org.bimserver.models.ifc4.IfcMaterialRelationship#getRelatedMaterials
	 * @model opposite="RelatedMaterials" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcMaterialRelationship> getIsRelatedWith();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getIsRelatedWith <em>Is Related With</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsRelatedWith()
	 * @see #getIsRelatedWith()
	 * @generated
	 */
	void unsetIsRelatedWith();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getIsRelatedWith <em>Is Related With</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Related With</em>' reference list is set.
	 * @see #unsetIsRelatedWith()
	 * @see #getIsRelatedWith()
	 * @generated
	 */
	boolean isSetIsRelatedWith();

	/**
	 * Returns the value of the '<em><b>Relates To</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcMaterialRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcMaterialRelationship#getRelatingMaterial <em>Relating Material</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relates To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relates To</em>' reference list.
	 * @see #isSetRelatesTo()
	 * @see #unsetRelatesTo()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterial_RelatesTo()
	 * @see org.bimserver.models.ifc4.IfcMaterialRelationship#getRelatingMaterial
	 * @model opposite="RelatingMaterial" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcMaterialRelationship> getRelatesTo();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getRelatesTo <em>Relates To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatesTo()
	 * @see #getRelatesTo()
	 * @generated
	 */
	void unsetRelatesTo();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterial#getRelatesTo <em>Relates To</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relates To</em>' reference list is set.
	 * @see #unsetRelatesTo()
	 * @see #getRelatesTo()
	 * @generated
	 */
	boolean isSetRelatesTo();

} // IfcMaterial
