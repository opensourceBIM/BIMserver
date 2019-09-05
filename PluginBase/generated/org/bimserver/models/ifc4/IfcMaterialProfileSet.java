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
 * A representation of the model object '<em><b>Ifc Material Profile Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getMaterialProfiles <em>Material Profiles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getCompositeProfile <em>Composite Profile</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfileSet()
 * @model
 * @generated
 */
public interface IfcMaterialProfileSet extends IfcMaterialDefinition {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfileSet_Name()
	 * @model unsettable="true"
	 *        annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfileSet_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Material Profiles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcMaterialProfile}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getToMaterialProfileSet <em>To Material Profile Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Material Profiles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Material Profiles</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfileSet_MaterialProfiles()
	 * @see org.bimserver.models.ifc4.IfcMaterialProfile#getToMaterialProfileSet
	 * @model opposite="ToMaterialProfileSet"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcMaterialProfile> getMaterialProfiles();

	/**
	 * Returns the value of the '<em><b>Composite Profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Profile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Profile</em>' reference.
	 * @see #isSetCompositeProfile()
	 * @see #unsetCompositeProfile()
	 * @see #setCompositeProfile(IfcCompositeProfileDef)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfileSet_CompositeProfile()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCompositeProfileDef getCompositeProfile();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getCompositeProfile <em>Composite Profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Profile</em>' reference.
	 * @see #isSetCompositeProfile()
	 * @see #unsetCompositeProfile()
	 * @see #getCompositeProfile()
	 * @generated
	 */
	void setCompositeProfile(IfcCompositeProfileDef value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getCompositeProfile <em>Composite Profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompositeProfile()
	 * @see #getCompositeProfile()
	 * @see #setCompositeProfile(IfcCompositeProfileDef)
	 * @generated
	 */
	void unsetCompositeProfile();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getCompositeProfile <em>Composite Profile</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Composite Profile</em>' reference is set.
	 * @see #unsetCompositeProfile()
	 * @see #getCompositeProfile()
	 * @see #setCompositeProfile(IfcCompositeProfileDef)
	 * @generated
	 */
	boolean isSetCompositeProfile();

} // IfcMaterialProfileSet
