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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc TShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeWidth <em>Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeWidthAsString <em>Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeEdgeRadius <em>Flange Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeEdgeRadiusAsString <em>Flange Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebEdgeRadius <em>Web Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebEdgeRadiusAsString <em>Web Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebSlope <em>Web Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebSlopeAsString <em>Web Slope As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeSlope <em>Flange Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeSlopeAsString <em>Flange Slope As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef()
 * @model
 * @generated
 */
public interface IfcTShapeProfileDef extends IfcParameterizedProfileDef
{
	/**
	 * Returns the value of the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth</em>' attribute.
	 * @see #setDepth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_Depth()
	 * @model
	 * @generated
	 */
	float getDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth</em>' attribute.
	 * @see #getDepth()
	 * @generated
	 */
	void setDepth(float value);

	/**
	 * Returns the value of the '<em><b>Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth As String</em>' attribute.
	 * @see #setDepthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_DepthAsString()
	 * @model
	 * @generated
	 */
	String getDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getDepthAsString <em>Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth As String</em>' attribute.
	 * @see #getDepthAsString()
	 * @generated
	 */
	void setDepthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Flange Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Width</em>' attribute.
	 * @see #setFlangeWidth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_FlangeWidth()
	 * @model
	 * @generated
	 */
	float getFlangeWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeWidth <em>Flange Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Width</em>' attribute.
	 * @see #getFlangeWidth()
	 * @generated
	 */
	void setFlangeWidth(float value);

	/**
	 * Returns the value of the '<em><b>Flange Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Width As String</em>' attribute.
	 * @see #setFlangeWidthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_FlangeWidthAsString()
	 * @model
	 * @generated
	 */
	String getFlangeWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeWidthAsString <em>Flange Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Width As String</em>' attribute.
	 * @see #getFlangeWidthAsString()
	 * @generated
	 */
	void setFlangeWidthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Web Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Thickness</em>' attribute.
	 * @see #setWebThickness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_WebThickness()
	 * @model
	 * @generated
	 */
	float getWebThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Thickness</em>' attribute.
	 * @see #getWebThickness()
	 * @generated
	 */
	void setWebThickness(float value);

	/**
	 * Returns the value of the '<em><b>Web Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Thickness As String</em>' attribute.
	 * @see #setWebThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_WebThicknessAsString()
	 * @model
	 * @generated
	 */
	String getWebThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Thickness As String</em>' attribute.
	 * @see #getWebThicknessAsString()
	 * @generated
	 */
	void setWebThicknessAsString(String value);

	/**
	 * Returns the value of the '<em><b>Flange Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Thickness</em>' attribute.
	 * @see #setFlangeThickness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_FlangeThickness()
	 * @model
	 * @generated
	 */
	float getFlangeThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Thickness</em>' attribute.
	 * @see #getFlangeThickness()
	 * @generated
	 */
	void setFlangeThickness(float value);

	/**
	 * Returns the value of the '<em><b>Flange Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Thickness As String</em>' attribute.
	 * @see #setFlangeThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_FlangeThicknessAsString()
	 * @model
	 * @generated
	 */
	String getFlangeThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Thickness As String</em>' attribute.
	 * @see #getFlangeThicknessAsString()
	 * @generated
	 */
	void setFlangeThicknessAsString(String value);

	/**
	 * Returns the value of the '<em><b>Fillet Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fillet Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fillet Radius</em>' attribute.
	 * @see #isSetFilletRadius()
	 * @see #unsetFilletRadius()
	 * @see #setFilletRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_FilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	float getFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fillet Radius</em>' attribute.
	 * @see #isSetFilletRadius()
	 * @see #unsetFilletRadius()
	 * @see #getFilletRadius()
	 * @generated
	 */
	void setFilletRadius(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadius()
	 * @see #getFilletRadius()
	 * @see #setFilletRadius(float)
	 * @generated
	 */
	void unsetFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fillet Radius</em>' attribute is set.
	 * @see #unsetFilletRadius()
	 * @see #getFilletRadius()
	 * @see #setFilletRadius(float)
	 * @generated
	 */
	boolean isSetFilletRadius();

	/**
	 * Returns the value of the '<em><b>Fillet Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fillet Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fillet Radius As String</em>' attribute.
	 * @see #isSetFilletRadiusAsString()
	 * @see #unsetFilletRadiusAsString()
	 * @see #setFilletRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_FilletRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fillet Radius As String</em>' attribute.
	 * @see #isSetFilletRadiusAsString()
	 * @see #unsetFilletRadiusAsString()
	 * @see #getFilletRadiusAsString()
	 * @generated
	 */
	void setFilletRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadiusAsString()
	 * @see #getFilletRadiusAsString()
	 * @see #setFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fillet Radius As String</em>' attribute is set.
	 * @see #unsetFilletRadiusAsString()
	 * @see #getFilletRadiusAsString()
	 * @see #setFilletRadiusAsString(String)
	 * @generated
	 */
	boolean isSetFilletRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Flange Edge Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Edge Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Edge Radius</em>' attribute.
	 * @see #isSetFlangeEdgeRadius()
	 * @see #unsetFlangeEdgeRadius()
	 * @see #setFlangeEdgeRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_FlangeEdgeRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	float getFlangeEdgeRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeEdgeRadius <em>Flange Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Edge Radius</em>' attribute.
	 * @see #isSetFlangeEdgeRadius()
	 * @see #unsetFlangeEdgeRadius()
	 * @see #getFlangeEdgeRadius()
	 * @generated
	 */
	void setFlangeEdgeRadius(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeEdgeRadius <em>Flange Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeEdgeRadius()
	 * @see #getFlangeEdgeRadius()
	 * @see #setFlangeEdgeRadius(float)
	 * @generated
	 */
	void unsetFlangeEdgeRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeEdgeRadius <em>Flange Edge Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flange Edge Radius</em>' attribute is set.
	 * @see #unsetFlangeEdgeRadius()
	 * @see #getFlangeEdgeRadius()
	 * @see #setFlangeEdgeRadius(float)
	 * @generated
	 */
	boolean isSetFlangeEdgeRadius();

	/**
	 * Returns the value of the '<em><b>Flange Edge Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Edge Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Edge Radius As String</em>' attribute.
	 * @see #isSetFlangeEdgeRadiusAsString()
	 * @see #unsetFlangeEdgeRadiusAsString()
	 * @see #setFlangeEdgeRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_FlangeEdgeRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFlangeEdgeRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeEdgeRadiusAsString <em>Flange Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Edge Radius As String</em>' attribute.
	 * @see #isSetFlangeEdgeRadiusAsString()
	 * @see #unsetFlangeEdgeRadiusAsString()
	 * @see #getFlangeEdgeRadiusAsString()
	 * @generated
	 */
	void setFlangeEdgeRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeEdgeRadiusAsString <em>Flange Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeEdgeRadiusAsString()
	 * @see #getFlangeEdgeRadiusAsString()
	 * @see #setFlangeEdgeRadiusAsString(String)
	 * @generated
	 */
	void unsetFlangeEdgeRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeEdgeRadiusAsString <em>Flange Edge Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flange Edge Radius As String</em>' attribute is set.
	 * @see #unsetFlangeEdgeRadiusAsString()
	 * @see #getFlangeEdgeRadiusAsString()
	 * @see #setFlangeEdgeRadiusAsString(String)
	 * @generated
	 */
	boolean isSetFlangeEdgeRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Web Edge Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Edge Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Edge Radius</em>' attribute.
	 * @see #isSetWebEdgeRadius()
	 * @see #unsetWebEdgeRadius()
	 * @see #setWebEdgeRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_WebEdgeRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	float getWebEdgeRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebEdgeRadius <em>Web Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Edge Radius</em>' attribute.
	 * @see #isSetWebEdgeRadius()
	 * @see #unsetWebEdgeRadius()
	 * @see #getWebEdgeRadius()
	 * @generated
	 */
	void setWebEdgeRadius(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebEdgeRadius <em>Web Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWebEdgeRadius()
	 * @see #getWebEdgeRadius()
	 * @see #setWebEdgeRadius(float)
	 * @generated
	 */
	void unsetWebEdgeRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebEdgeRadius <em>Web Edge Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Web Edge Radius</em>' attribute is set.
	 * @see #unsetWebEdgeRadius()
	 * @see #getWebEdgeRadius()
	 * @see #setWebEdgeRadius(float)
	 * @generated
	 */
	boolean isSetWebEdgeRadius();

	/**
	 * Returns the value of the '<em><b>Web Edge Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Edge Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Edge Radius As String</em>' attribute.
	 * @see #isSetWebEdgeRadiusAsString()
	 * @see #unsetWebEdgeRadiusAsString()
	 * @see #setWebEdgeRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_WebEdgeRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWebEdgeRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebEdgeRadiusAsString <em>Web Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Edge Radius As String</em>' attribute.
	 * @see #isSetWebEdgeRadiusAsString()
	 * @see #unsetWebEdgeRadiusAsString()
	 * @see #getWebEdgeRadiusAsString()
	 * @generated
	 */
	void setWebEdgeRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebEdgeRadiusAsString <em>Web Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWebEdgeRadiusAsString()
	 * @see #getWebEdgeRadiusAsString()
	 * @see #setWebEdgeRadiusAsString(String)
	 * @generated
	 */
	void unsetWebEdgeRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebEdgeRadiusAsString <em>Web Edge Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Web Edge Radius As String</em>' attribute is set.
	 * @see #unsetWebEdgeRadiusAsString()
	 * @see #getWebEdgeRadiusAsString()
	 * @see #setWebEdgeRadiusAsString(String)
	 * @generated
	 */
	boolean isSetWebEdgeRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Web Slope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Slope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Slope</em>' attribute.
	 * @see #isSetWebSlope()
	 * @see #unsetWebSlope()
	 * @see #setWebSlope(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_WebSlope()
	 * @model unsettable="true"
	 * @generated
	 */
	float getWebSlope();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebSlope <em>Web Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Slope</em>' attribute.
	 * @see #isSetWebSlope()
	 * @see #unsetWebSlope()
	 * @see #getWebSlope()
	 * @generated
	 */
	void setWebSlope(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebSlope <em>Web Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWebSlope()
	 * @see #getWebSlope()
	 * @see #setWebSlope(float)
	 * @generated
	 */
	void unsetWebSlope();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebSlope <em>Web Slope</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Web Slope</em>' attribute is set.
	 * @see #unsetWebSlope()
	 * @see #getWebSlope()
	 * @see #setWebSlope(float)
	 * @generated
	 */
	boolean isSetWebSlope();

	/**
	 * Returns the value of the '<em><b>Web Slope As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Slope As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Slope As String</em>' attribute.
	 * @see #isSetWebSlopeAsString()
	 * @see #unsetWebSlopeAsString()
	 * @see #setWebSlopeAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_WebSlopeAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWebSlopeAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebSlopeAsString <em>Web Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Slope As String</em>' attribute.
	 * @see #isSetWebSlopeAsString()
	 * @see #unsetWebSlopeAsString()
	 * @see #getWebSlopeAsString()
	 * @generated
	 */
	void setWebSlopeAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebSlopeAsString <em>Web Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWebSlopeAsString()
	 * @see #getWebSlopeAsString()
	 * @see #setWebSlopeAsString(String)
	 * @generated
	 */
	void unsetWebSlopeAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getWebSlopeAsString <em>Web Slope As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Web Slope As String</em>' attribute is set.
	 * @see #unsetWebSlopeAsString()
	 * @see #getWebSlopeAsString()
	 * @see #setWebSlopeAsString(String)
	 * @generated
	 */
	boolean isSetWebSlopeAsString();

	/**
	 * Returns the value of the '<em><b>Flange Slope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Slope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Slope</em>' attribute.
	 * @see #isSetFlangeSlope()
	 * @see #unsetFlangeSlope()
	 * @see #setFlangeSlope(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_FlangeSlope()
	 * @model unsettable="true"
	 * @generated
	 */
	float getFlangeSlope();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeSlope <em>Flange Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Slope</em>' attribute.
	 * @see #isSetFlangeSlope()
	 * @see #unsetFlangeSlope()
	 * @see #getFlangeSlope()
	 * @generated
	 */
	void setFlangeSlope(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeSlope <em>Flange Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeSlope()
	 * @see #getFlangeSlope()
	 * @see #setFlangeSlope(float)
	 * @generated
	 */
	void unsetFlangeSlope();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeSlope <em>Flange Slope</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flange Slope</em>' attribute is set.
	 * @see #unsetFlangeSlope()
	 * @see #getFlangeSlope()
	 * @see #setFlangeSlope(float)
	 * @generated
	 */
	boolean isSetFlangeSlope();

	/**
	 * Returns the value of the '<em><b>Flange Slope As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Slope As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Slope As String</em>' attribute.
	 * @see #isSetFlangeSlopeAsString()
	 * @see #unsetFlangeSlopeAsString()
	 * @see #setFlangeSlopeAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_FlangeSlopeAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFlangeSlopeAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeSlopeAsString <em>Flange Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Slope As String</em>' attribute.
	 * @see #isSetFlangeSlopeAsString()
	 * @see #unsetFlangeSlopeAsString()
	 * @see #getFlangeSlopeAsString()
	 * @generated
	 */
	void setFlangeSlopeAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeSlopeAsString <em>Flange Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeSlopeAsString()
	 * @see #getFlangeSlopeAsString()
	 * @see #setFlangeSlopeAsString(String)
	 * @generated
	 */
	void unsetFlangeSlopeAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getFlangeSlopeAsString <em>Flange Slope As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flange Slope As String</em>' attribute is set.
	 * @see #unsetFlangeSlopeAsString()
	 * @see #getFlangeSlopeAsString()
	 * @see #setFlangeSlopeAsString(String)
	 * @generated
	 */
	boolean isSetFlangeSlopeAsString();

	/**
	 * Returns the value of the '<em><b>Centre Of Gravity In Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Centre Of Gravity In Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Centre Of Gravity In Y</em>' attribute.
	 * @see #isSetCentreOfGravityInY()
	 * @see #unsetCentreOfGravityInY()
	 * @see #setCentreOfGravityInY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_CentreOfGravityInY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getCentreOfGravityInY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Centre Of Gravity In Y</em>' attribute.
	 * @see #isSetCentreOfGravityInY()
	 * @see #unsetCentreOfGravityInY()
	 * @see #getCentreOfGravityInY()
	 * @generated
	 */
	void setCentreOfGravityInY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCentreOfGravityInY()
	 * @see #getCentreOfGravityInY()
	 * @see #setCentreOfGravityInY(float)
	 * @generated
	 */
	void unsetCentreOfGravityInY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Centre Of Gravity In Y</em>' attribute is set.
	 * @see #unsetCentreOfGravityInY()
	 * @see #getCentreOfGravityInY()
	 * @see #setCentreOfGravityInY(float)
	 * @generated
	 */
	boolean isSetCentreOfGravityInY();

	/**
	 * Returns the value of the '<em><b>Centre Of Gravity In YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Centre Of Gravity In YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Centre Of Gravity In YAs String</em>' attribute.
	 * @see #isSetCentreOfGravityInYAsString()
	 * @see #unsetCentreOfGravityInYAsString()
	 * @see #setCentreOfGravityInYAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTShapeProfileDef_CentreOfGravityInYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCentreOfGravityInYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Centre Of Gravity In YAs String</em>' attribute.
	 * @see #isSetCentreOfGravityInYAsString()
	 * @see #unsetCentreOfGravityInYAsString()
	 * @see #getCentreOfGravityInYAsString()
	 * @generated
	 */
	void setCentreOfGravityInYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCentreOfGravityInYAsString()
	 * @see #getCentreOfGravityInYAsString()
	 * @see #setCentreOfGravityInYAsString(String)
	 * @generated
	 */
	void unsetCentreOfGravityInYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTShapeProfileDef#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Centre Of Gravity In YAs String</em>' attribute is set.
	 * @see #unsetCentreOfGravityInYAsString()
	 * @see #getCentreOfGravityInYAsString()
	 * @see #setCentreOfGravityInYAsString(String)
	 * @generated
	 */
	boolean isSetCentreOfGravityInYAsString();

} // IfcTShapeProfileDef
