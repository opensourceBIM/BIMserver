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
 * A representation of the model object '<em><b>Ifc Material Layer Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getMaterialLayers <em>Material Layers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getLayerSetName <em>Layer Set Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getTotalThickness <em>Total Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getTotalThicknessAsString <em>Total Thickness As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayerSet()
 * @model
 * @generated
 */
public interface IfcMaterialLayerSet extends IfcMaterialSelect {
	/**
	 * Returns the value of the '<em><b>Material Layers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getToMaterialLayerSet <em>To Material Layer Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Material Layers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Material Layers</em>' reference list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayerSet_MaterialLayers()
	 * @see org.bimserver.models.ifc2x3tc1.IfcMaterialLayer#getToMaterialLayerSet
	 * @model opposite="ToMaterialLayerSet"
	 * @generated
	 */
	EList<IfcMaterialLayer> getMaterialLayers();

	/**
	 * Returns the value of the '<em><b>Layer Set Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Set Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Set Name</em>' attribute.
	 * @see #isSetLayerSetName()
	 * @see #unsetLayerSetName()
	 * @see #setLayerSetName(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayerSet_LayerSetName()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLayerSetName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getLayerSetName <em>Layer Set Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Set Name</em>' attribute.
	 * @see #isSetLayerSetName()
	 * @see #unsetLayerSetName()
	 * @see #getLayerSetName()
	 * @generated
	 */
	void setLayerSetName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getLayerSetName <em>Layer Set Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLayerSetName()
	 * @see #getLayerSetName()
	 * @see #setLayerSetName(String)
	 * @generated
	 */
	void unsetLayerSetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getLayerSetName <em>Layer Set Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Layer Set Name</em>' attribute is set.
	 * @see #unsetLayerSetName()
	 * @see #getLayerSetName()
	 * @see #setLayerSetName(String)
	 * @generated
	 */
	boolean isSetLayerSetName();

	/**
	 * Returns the value of the '<em><b>Total Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Thickness</em>' attribute.
	 * @see #isSetTotalThickness()
	 * @see #unsetTotalThickness()
	 * @see #setTotalThickness(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayerSet_TotalThickness()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	double getTotalThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getTotalThickness <em>Total Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Thickness</em>' attribute.
	 * @see #isSetTotalThickness()
	 * @see #unsetTotalThickness()
	 * @see #getTotalThickness()
	 * @generated
	 */
	void setTotalThickness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getTotalThickness <em>Total Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTotalThickness()
	 * @see #getTotalThickness()
	 * @see #setTotalThickness(double)
	 * @generated
	 */
	void unsetTotalThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getTotalThickness <em>Total Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Total Thickness</em>' attribute is set.
	 * @see #unsetTotalThickness()
	 * @see #getTotalThickness()
	 * @see #setTotalThickness(double)
	 * @generated
	 */
	boolean isSetTotalThickness();

	/**
	 * Returns the value of the '<em><b>Total Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Thickness As String</em>' attribute.
	 * @see #isSetTotalThicknessAsString()
	 * @see #unsetTotalThicknessAsString()
	 * @see #setTotalThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMaterialLayerSet_TotalThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTotalThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getTotalThicknessAsString <em>Total Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Thickness As String</em>' attribute.
	 * @see #isSetTotalThicknessAsString()
	 * @see #unsetTotalThicknessAsString()
	 * @see #getTotalThicknessAsString()
	 * @generated
	 */
	void setTotalThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getTotalThicknessAsString <em>Total Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTotalThicknessAsString()
	 * @see #getTotalThicknessAsString()
	 * @see #setTotalThicknessAsString(String)
	 * @generated
	 */
	void unsetTotalThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet#getTotalThicknessAsString <em>Total Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Total Thickness As String</em>' attribute is set.
	 * @see #unsetTotalThicknessAsString()
	 * @see #getTotalThicknessAsString()
	 * @see #setTotalThicknessAsString(String)
	 * @generated
	 */
	boolean isSetTotalThicknessAsString();

} // IfcMaterialLayerSet
