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

public interface IfcMaterialProfile extends IfcMaterialDefinition {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfile_Name()
	 * @model unsettable="true"
	 *        annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getName <em>Name</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getName <em>Name</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfile_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Material</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Material</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Material</em>' reference.
	 * @see #isSetMaterial()
	 * @see #unsetMaterial()
	 * @see #setMaterial(IfcMaterial)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfile_Material()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcMaterial getMaterial();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getMaterial <em>Material</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Material</em>' reference.
	 * @see #isSetMaterial()
	 * @see #unsetMaterial()
	 * @see #getMaterial()
	 * @generated
	 */
	void setMaterial(IfcMaterial value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getMaterial <em>Material</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaterial()
	 * @see #getMaterial()
	 * @see #setMaterial(IfcMaterial)
	 * @generated
	 */
	void unsetMaterial();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getMaterial <em>Material</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Material</em>' reference is set.
	 * @see #unsetMaterial()
	 * @see #getMaterial()
	 * @see #setMaterial(IfcMaterial)
	 * @generated
	 */
	boolean isSetMaterial();

	/**
	 * Returns the value of the '<em><b>Profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile</em>' reference.
	 * @see #setProfile(IfcProfileDef)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfile_Profile()
	 * @model
	 * @generated
	 */
	IfcProfileDef getProfile();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getProfile <em>Profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile</em>' reference.
	 * @see #getProfile()
	 * @generated
	 */
	void setProfile(IfcProfileDef value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #isSetPriority()
	 * @see #unsetPriority()
	 * @see #setPriority(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfile_Priority()
	 * @model unsettable="true"
	 * @generated
	 */
	long getPriority();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #isSetPriority()
	 * @see #unsetPriority()
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPriority()
	 * @see #getPriority()
	 * @see #setPriority(long)
	 * @generated
	 */
	void unsetPriority();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getPriority <em>Priority</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Priority</em>' attribute is set.
	 * @see #unsetPriority()
	 * @see #getPriority()
	 * @see #setPriority(long)
	 * @generated
	 */
	boolean isSetPriority();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfile_Category()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getCategory <em>Category</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCategory()
	 * @see #getCategory()
	 * @see #setCategory(String)
	 * @generated
	 */
	void unsetCategory();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getCategory <em>Category</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>To Material Profile Set</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcMaterialProfileSet#getMaterialProfiles <em>Material Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Material Profile Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Material Profile Set</em>' reference.
	 * @see #isSetToMaterialProfileSet()
	 * @see #unsetToMaterialProfileSet()
	 * @see #setToMaterialProfileSet(IfcMaterialProfileSet)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialProfile_ToMaterialProfileSet()
	 * @see org.bimserver.models.ifc4.IfcMaterialProfileSet#getMaterialProfiles
	 * @model opposite="MaterialProfiles" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcMaterialProfileSet getToMaterialProfileSet();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getToMaterialProfileSet <em>To Material Profile Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Material Profile Set</em>' reference.
	 * @see #isSetToMaterialProfileSet()
	 * @see #unsetToMaterialProfileSet()
	 * @see #getToMaterialProfileSet()
	 * @generated
	 */
	void setToMaterialProfileSet(IfcMaterialProfileSet value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getToMaterialProfileSet <em>To Material Profile Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetToMaterialProfileSet()
	 * @see #getToMaterialProfileSet()
	 * @see #setToMaterialProfileSet(IfcMaterialProfileSet)
	 * @generated
	 */
	void unsetToMaterialProfileSet();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialProfile#getToMaterialProfileSet <em>To Material Profile Set</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>To Material Profile Set</em>' reference is set.
	 * @see #unsetToMaterialProfileSet()
	 * @see #getToMaterialProfileSet()
	 * @see #setToMaterialProfileSet(IfcMaterialProfileSet)
	 * @generated
	 */
	boolean isSetToMaterialProfileSet();

} // IfcMaterialProfile
