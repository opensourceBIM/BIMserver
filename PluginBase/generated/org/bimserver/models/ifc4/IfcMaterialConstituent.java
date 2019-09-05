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

public interface IfcMaterialConstituent extends IfcMaterialDefinition {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialConstituent_Name()
	 * @model unsettable="true"
	 *        annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getName <em>Name</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getName <em>Name</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialConstituent_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getDescription <em>Description</em>}' attribute is set.
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
	 * @see #setMaterial(IfcMaterial)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialConstituent_Material()
	 * @model
	 * @generated
	 */
	IfcMaterial getMaterial();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getMaterial <em>Material</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Material</em>' reference.
	 * @see #getMaterial()
	 * @generated
	 */
	void setMaterial(IfcMaterial value);

	/**
	 * Returns the value of the '<em><b>Fraction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fraction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fraction</em>' attribute.
	 * @see #isSetFraction()
	 * @see #unsetFraction()
	 * @see #setFraction(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialConstituent_Fraction()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFraction();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getFraction <em>Fraction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fraction</em>' attribute.
	 * @see #isSetFraction()
	 * @see #unsetFraction()
	 * @see #getFraction()
	 * @generated
	 */
	void setFraction(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getFraction <em>Fraction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFraction()
	 * @see #getFraction()
	 * @see #setFraction(double)
	 * @generated
	 */
	void unsetFraction();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getFraction <em>Fraction</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fraction</em>' attribute is set.
	 * @see #unsetFraction()
	 * @see #getFraction()
	 * @see #setFraction(double)
	 * @generated
	 */
	boolean isSetFraction();

	/**
	 * Returns the value of the '<em><b>Fraction As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fraction As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fraction As String</em>' attribute.
	 * @see #isSetFractionAsString()
	 * @see #unsetFractionAsString()
	 * @see #setFractionAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialConstituent_FractionAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFractionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getFractionAsString <em>Fraction As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fraction As String</em>' attribute.
	 * @see #isSetFractionAsString()
	 * @see #unsetFractionAsString()
	 * @see #getFractionAsString()
	 * @generated
	 */
	void setFractionAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getFractionAsString <em>Fraction As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFractionAsString()
	 * @see #getFractionAsString()
	 * @see #setFractionAsString(String)
	 * @generated
	 */
	void unsetFractionAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getFractionAsString <em>Fraction As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fraction As String</em>' attribute is set.
	 * @see #unsetFractionAsString()
	 * @see #getFractionAsString()
	 * @see #setFractionAsString(String)
	 * @generated
	 */
	boolean isSetFractionAsString();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialConstituent_Category()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getCategory <em>Category</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCategory()
	 * @see #getCategory()
	 * @see #setCategory(String)
	 * @generated
	 */
	void unsetCategory();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getCategory <em>Category</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>To Material Constituent Set</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcMaterialConstituentSet#getMaterialConstituents <em>Material Constituents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Material Constituent Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Material Constituent Set</em>' reference.
	 * @see #isSetToMaterialConstituentSet()
	 * @see #unsetToMaterialConstituentSet()
	 * @see #setToMaterialConstituentSet(IfcMaterialConstituentSet)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialConstituent_ToMaterialConstituentSet()
	 * @see org.bimserver.models.ifc4.IfcMaterialConstituentSet#getMaterialConstituents
	 * @model opposite="MaterialConstituents" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcMaterialConstituentSet getToMaterialConstituentSet();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getToMaterialConstituentSet <em>To Material Constituent Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Material Constituent Set</em>' reference.
	 * @see #isSetToMaterialConstituentSet()
	 * @see #unsetToMaterialConstituentSet()
	 * @see #getToMaterialConstituentSet()
	 * @generated
	 */
	void setToMaterialConstituentSet(IfcMaterialConstituentSet value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getToMaterialConstituentSet <em>To Material Constituent Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetToMaterialConstituentSet()
	 * @see #getToMaterialConstituentSet()
	 * @see #setToMaterialConstituentSet(IfcMaterialConstituentSet)
	 * @generated
	 */
	void unsetToMaterialConstituentSet();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialConstituent#getToMaterialConstituentSet <em>To Material Constituent Set</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>To Material Constituent Set</em>' reference is set.
	 * @see #unsetToMaterialConstituentSet()
	 * @see #getToMaterialConstituentSet()
	 * @see #setToMaterialConstituentSet(IfcMaterialConstituentSet)
	 * @generated
	 */
	boolean isSetToMaterialConstituentSet();

} // IfcMaterialConstituent
