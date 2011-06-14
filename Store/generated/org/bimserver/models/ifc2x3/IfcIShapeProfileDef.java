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
 * A representation of the model object '<em><b>Ifc IShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallWidth <em>Overall Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallWidthAsString <em>Overall Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallDepth <em>Overall Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallDepthAsString <em>Overall Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef()
 * @model
 * @generated
 */
public interface IfcIShapeProfileDef extends IfcParameterizedProfileDef
{
	/**
	 * Returns the value of the '<em><b>Overall Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Width</em>' attribute.
	 * @see #setOverallWidth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_OverallWidth()
	 * @model
	 * @generated
	 */
	float getOverallWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallWidth <em>Overall Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Width</em>' attribute.
	 * @see #getOverallWidth()
	 * @generated
	 */
	void setOverallWidth(float value);

	/**
	 * Returns the value of the '<em><b>Overall Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Width As String</em>' attribute.
	 * @see #setOverallWidthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_OverallWidthAsString()
	 * @model
	 * @generated
	 */
	String getOverallWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallWidthAsString <em>Overall Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Width As String</em>' attribute.
	 * @see #getOverallWidthAsString()
	 * @generated
	 */
	void setOverallWidthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Overall Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Depth</em>' attribute.
	 * @see #setOverallDepth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_OverallDepth()
	 * @model
	 * @generated
	 */
	float getOverallDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallDepth <em>Overall Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Depth</em>' attribute.
	 * @see #getOverallDepth()
	 * @generated
	 */
	void setOverallDepth(float value);

	/**
	 * Returns the value of the '<em><b>Overall Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Depth As String</em>' attribute.
	 * @see #setOverallDepthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_OverallDepthAsString()
	 * @model
	 * @generated
	 */
	String getOverallDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallDepthAsString <em>Overall Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Depth As String</em>' attribute.
	 * @see #getOverallDepthAsString()
	 * @generated
	 */
	void setOverallDepthAsString(String value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_WebThickness()
	 * @model
	 * @generated
	 */
	float getWebThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_WebThicknessAsString()
	 * @model
	 * @generated
	 */
	String getWebThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_FlangeThickness()
	 * @model
	 * @generated
	 */
	float getFlangeThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_FlangeThicknessAsString()
	 * @model
	 * @generated
	 */
	String getFlangeThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_FilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	float getFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadius()
	 * @see #getFilletRadius()
	 * @see #setFilletRadius(float)
	 * @generated
	 */
	void unsetFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_FilletRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadiusAsString()
	 * @see #getFilletRadiusAsString()
	 * @see #setFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fillet Radius As String</em>' attribute is set.
	 * @see #unsetFilletRadiusAsString()
	 * @see #getFilletRadiusAsString()
	 * @see #setFilletRadiusAsString(String)
	 * @generated
	 */
	boolean isSetFilletRadiusAsString();

} // IfcIShapeProfileDef
