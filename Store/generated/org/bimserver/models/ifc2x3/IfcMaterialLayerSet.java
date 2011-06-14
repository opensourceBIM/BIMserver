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
 * A representation of the model object '<em><b>Ifc Material Layer Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSet#getMaterialLayers <em>Material Layers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSet#getLayerSetName <em>Layer Set Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSet#getTotalThickness <em>Total Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSet#getTotalThicknessAsString <em>Total Thickness As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSet()
 * @model
 * @generated
 */
public interface IfcMaterialLayerSet extends IfcMaterialSelect
{
	/**
	 * Returns the value of the '<em><b>Material Layers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcMaterialLayer}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcMaterialLayer#getToMaterialLayerSet <em>To Material Layer Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Material Layers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Material Layers</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSet_MaterialLayers()
	 * @see org.bimserver.models.ifc2x3.IfcMaterialLayer#getToMaterialLayerSet
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSet_LayerSetName()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLayerSetName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSet#getLayerSetName <em>Layer Set Name</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSet#getLayerSetName <em>Layer Set Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLayerSetName()
	 * @see #getLayerSetName()
	 * @see #setLayerSetName(String)
	 * @generated
	 */
	void unsetLayerSetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSet#getLayerSetName <em>Layer Set Name</em>}' attribute is set.
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
	 * @see #setTotalThickness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSet_TotalThickness()
	 * @model derived="true"
	 * @generated
	 */
	float getTotalThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSet#getTotalThickness <em>Total Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Thickness</em>' attribute.
	 * @see #getTotalThickness()
	 * @generated
	 */
	void setTotalThickness(float value);

	/**
	 * Returns the value of the '<em><b>Total Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Thickness As String</em>' attribute.
	 * @see #setTotalThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialLayerSet_TotalThicknessAsString()
	 * @model
	 * @generated
	 */
	String getTotalThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialLayerSet#getTotalThicknessAsString <em>Total Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Thickness As String</em>' attribute.
	 * @see #getTotalThicknessAsString()
	 * @generated
	 */
	void setTotalThicknessAsString(String value);

} // IfcMaterialLayerSet
