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

public interface IfcMaterialLayer extends IfcMaterialSelect, IfcObjectReferenceSelect {
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayer_Material()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcMaterial getMaterial();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getMaterial <em>Material</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getMaterial <em>Material</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaterial()
	 * @see #getMaterial()
	 * @see #setMaterial(IfcMaterial)
	 * @generated
	 */
	void unsetMaterial();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getMaterial <em>Material</em>}' reference is set.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayer_LayerThickness()
	 * @model
	 * @generated
	 */
	double getLayerThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getLayerThickness <em>Layer Thickness</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayer_LayerThicknessAsString()
	 * @model
	 * @generated
	 */
	String getLayerThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getLayerThicknessAsString <em>Layer Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Thickness As String</em>' attribute.
	 * @see #getLayerThicknessAsString()
	 * @generated
	 */
	void setLayerThicknessAsString(String value);

	/**
	 * Returns the value of the '<em><b>Is Ventilated</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ventilated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ventilated</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #isSetIsVentilated()
	 * @see #unsetIsVentilated()
	 * @see #setIsVentilated(Tristate)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayer_IsVentilated()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getIsVentilated();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getIsVentilated <em>Is Ventilated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ventilated</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #isSetIsVentilated()
	 * @see #unsetIsVentilated()
	 * @see #getIsVentilated()
	 * @generated
	 */
	void setIsVentilated(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getIsVentilated <em>Is Ventilated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsVentilated()
	 * @see #getIsVentilated()
	 * @see #setIsVentilated(Tristate)
	 * @generated
	 */
	void unsetIsVentilated();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getIsVentilated <em>Is Ventilated</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>To Material Layer Set</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getMaterialLayers <em>Material Layers</em>}'.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayer_ToMaterialLayerSet()
	 * @see org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getMaterialLayers
	 * @model opposite="MaterialLayers" unsettable="true"
	 * @generated
	 */
	IfcMaterialLayerSet getToMaterialLayerSet();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getToMaterialLayerSet <em>To Material Layer Set</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getToMaterialLayerSet <em>To Material Layer Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetToMaterialLayerSet()
	 * @see #getToMaterialLayerSet()
	 * @see #setToMaterialLayerSet(IfcMaterialLayerSet)
	 * @generated
	 */
	void unsetToMaterialLayerSet();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getToMaterialLayerSet <em>To Material Layer Set</em>}' reference is set.
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
