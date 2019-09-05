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

public interface IfcMaterialLayer extends IfcMaterialDefinition {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayer_Material()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcMaterial getMaterial();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getMaterial <em>Material</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getMaterial <em>Material</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaterial()
	 * @see #getMaterial()
	 * @see #setMaterial(IfcMaterial)
	 * @generated
	 */
	void unsetMaterial();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getMaterial <em>Material</em>}' reference is set.
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
	 * Returns the value of the '<em><b>Layer Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Thickness</em>' attribute.
	 * @see #setLayerThickness(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayer_LayerThickness()
	 * @model
	 * @generated
	 */
	double getLayerThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getLayerThickness <em>Layer Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Thickness</em>' attribute.
	 * @see #getLayerThickness()
	 * @generated
	 */
	void setLayerThickness(double value);

	/**
	 * Returns the value of the '<em><b>Layer Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Thickness As String</em>' attribute.
	 * @see #setLayerThicknessAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayer_LayerThicknessAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLayerThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getLayerThicknessAsString <em>Layer Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Thickness As String</em>' attribute.
	 * @see #getLayerThicknessAsString()
	 * @generated
	 */
	void setLayerThicknessAsString(String value);

	/**
	 * Returns the value of the '<em><b>Is Ventilated</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ventilated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ventilated</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetIsVentilated()
	 * @see #unsetIsVentilated()
	 * @see #setIsVentilated(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayer_IsVentilated()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getIsVentilated();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getIsVentilated <em>Is Ventilated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ventilated</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetIsVentilated()
	 * @see #unsetIsVentilated()
	 * @see #getIsVentilated()
	 * @generated
	 */
	void setIsVentilated(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getIsVentilated <em>Is Ventilated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsVentilated()
	 * @see #getIsVentilated()
	 * @see #setIsVentilated(Tristate)
	 * @generated
	 */
	void unsetIsVentilated();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getIsVentilated <em>Is Ventilated</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Ventilated</em>' attribute is set.
	 * @see #unsetIsVentilated()
	 * @see #getIsVentilated()
	 * @see #setIsVentilated(Tristate)
	 * @generated
	 */
	boolean isSetIsVentilated();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayer_Name()
	 * @model unsettable="true"
	 *        annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getName <em>Name</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getName <em>Name</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayer_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getDescription <em>Description</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayer_Category()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getCategory <em>Category</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCategory()
	 * @see #getCategory()
	 * @see #setCategory(String)
	 * @generated
	 */
	void unsetCategory();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getCategory <em>Category</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayer_Priority()
	 * @model unsettable="true"
	 * @generated
	 */
	long getPriority();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getPriority <em>Priority</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPriority()
	 * @see #getPriority()
	 * @see #setPriority(long)
	 * @generated
	 */
	void unsetPriority();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getPriority <em>Priority</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>To Material Layer Set</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcMaterialLayerSet#getMaterialLayers <em>Material Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Material Layer Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Material Layer Set</em>' reference.
	 * @see #isSetToMaterialLayerSet()
	 * @see #unsetToMaterialLayerSet()
	 * @see #setToMaterialLayerSet(IfcMaterialLayerSet)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMaterialLayer_ToMaterialLayerSet()
	 * @see org.bimserver.models.ifc4.IfcMaterialLayerSet#getMaterialLayers
	 * @model opposite="MaterialLayers" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcMaterialLayerSet getToMaterialLayerSet();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getToMaterialLayerSet <em>To Material Layer Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Material Layer Set</em>' reference.
	 * @see #isSetToMaterialLayerSet()
	 * @see #unsetToMaterialLayerSet()
	 * @see #getToMaterialLayerSet()
	 * @generated
	 */
	void setToMaterialLayerSet(IfcMaterialLayerSet value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getToMaterialLayerSet <em>To Material Layer Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetToMaterialLayerSet()
	 * @see #getToMaterialLayerSet()
	 * @see #setToMaterialLayerSet(IfcMaterialLayerSet)
	 * @generated
	 */
	void unsetToMaterialLayerSet();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMaterialLayer#getToMaterialLayerSet <em>To Material Layer Set</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>To Material Layer Set</em>' reference is set.
	 * @see #unsetToMaterialLayerSet()
	 * @see #getToMaterialLayerSet()
	 * @see #setToMaterialLayerSet(IfcMaterialLayerSet)
	 * @generated
	 */
	boolean isSetToMaterialLayerSet();

} // IfcMaterialLayer
