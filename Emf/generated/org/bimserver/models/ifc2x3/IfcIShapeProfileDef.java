/**
 * Copyright (C) 2011  BIMserver.org
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
public interface IfcIShapeProfileDef extends IfcParameterizedProfileDef {
	/**
	 * Returns the value of the '<em><b>Overall Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Width</em>' attribute.
	 * @see #isSetOverallWidth()
	 * @see #unsetOverallWidth()
	 * @see #setOverallWidth(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_OverallWidth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getOverallWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallWidth <em>Overall Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Width</em>' attribute.
	 * @see #isSetOverallWidth()
	 * @see #unsetOverallWidth()
	 * @see #getOverallWidth()
	 * @generated
	 */
	void setOverallWidth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallWidth <em>Overall Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOverallWidth()
	 * @see #getOverallWidth()
	 * @see #setOverallWidth(double)
	 * @generated
	 */
	void unsetOverallWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallWidth <em>Overall Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Overall Width</em>' attribute is set.
	 * @see #unsetOverallWidth()
	 * @see #getOverallWidth()
	 * @see #setOverallWidth(double)
	 * @generated
	 */
	boolean isSetOverallWidth();

	/**
	 * Returns the value of the '<em><b>Overall Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Width As String</em>' attribute.
	 * @see #isSetOverallWidthAsString()
	 * @see #unsetOverallWidthAsString()
	 * @see #setOverallWidthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_OverallWidthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getOverallWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallWidthAsString <em>Overall Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Width As String</em>' attribute.
	 * @see #isSetOverallWidthAsString()
	 * @see #unsetOverallWidthAsString()
	 * @see #getOverallWidthAsString()
	 * @generated
	 */
	void setOverallWidthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallWidthAsString <em>Overall Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOverallWidthAsString()
	 * @see #getOverallWidthAsString()
	 * @see #setOverallWidthAsString(String)
	 * @generated
	 */
	void unsetOverallWidthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallWidthAsString <em>Overall Width As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Overall Width As String</em>' attribute is set.
	 * @see #unsetOverallWidthAsString()
	 * @see #getOverallWidthAsString()
	 * @see #setOverallWidthAsString(String)
	 * @generated
	 */
	boolean isSetOverallWidthAsString();

	/**
	 * Returns the value of the '<em><b>Overall Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Depth</em>' attribute.
	 * @see #isSetOverallDepth()
	 * @see #unsetOverallDepth()
	 * @see #setOverallDepth(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_OverallDepth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getOverallDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallDepth <em>Overall Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Depth</em>' attribute.
	 * @see #isSetOverallDepth()
	 * @see #unsetOverallDepth()
	 * @see #getOverallDepth()
	 * @generated
	 */
	void setOverallDepth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallDepth <em>Overall Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOverallDepth()
	 * @see #getOverallDepth()
	 * @see #setOverallDepth(double)
	 * @generated
	 */
	void unsetOverallDepth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallDepth <em>Overall Depth</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Overall Depth</em>' attribute is set.
	 * @see #unsetOverallDepth()
	 * @see #getOverallDepth()
	 * @see #setOverallDepth(double)
	 * @generated
	 */
	boolean isSetOverallDepth();

	/**
	 * Returns the value of the '<em><b>Overall Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Depth As String</em>' attribute.
	 * @see #isSetOverallDepthAsString()
	 * @see #unsetOverallDepthAsString()
	 * @see #setOverallDepthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_OverallDepthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getOverallDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallDepthAsString <em>Overall Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Depth As String</em>' attribute.
	 * @see #isSetOverallDepthAsString()
	 * @see #unsetOverallDepthAsString()
	 * @see #getOverallDepthAsString()
	 * @generated
	 */
	void setOverallDepthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallDepthAsString <em>Overall Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOverallDepthAsString()
	 * @see #getOverallDepthAsString()
	 * @see #setOverallDepthAsString(String)
	 * @generated
	 */
	void unsetOverallDepthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getOverallDepthAsString <em>Overall Depth As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Overall Depth As String</em>' attribute is set.
	 * @see #unsetOverallDepthAsString()
	 * @see #getOverallDepthAsString()
	 * @see #setOverallDepthAsString(String)
	 * @generated
	 */
	boolean isSetOverallDepthAsString();

	/**
	 * Returns the value of the '<em><b>Web Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Thickness</em>' attribute.
	 * @see #isSetWebThickness()
	 * @see #unsetWebThickness()
	 * @see #setWebThickness(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_WebThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getWebThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Thickness</em>' attribute.
	 * @see #isSetWebThickness()
	 * @see #unsetWebThickness()
	 * @see #getWebThickness()
	 * @generated
	 */
	void setWebThickness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWebThickness()
	 * @see #getWebThickness()
	 * @see #setWebThickness(double)
	 * @generated
	 */
	void unsetWebThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Web Thickness</em>' attribute is set.
	 * @see #unsetWebThickness()
	 * @see #getWebThickness()
	 * @see #setWebThickness(double)
	 * @generated
	 */
	boolean isSetWebThickness();

	/**
	 * Returns the value of the '<em><b>Web Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Thickness As String</em>' attribute.
	 * @see #isSetWebThicknessAsString()
	 * @see #unsetWebThicknessAsString()
	 * @see #setWebThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_WebThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWebThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Thickness As String</em>' attribute.
	 * @see #isSetWebThicknessAsString()
	 * @see #unsetWebThicknessAsString()
	 * @see #getWebThicknessAsString()
	 * @generated
	 */
	void setWebThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWebThicknessAsString()
	 * @see #getWebThicknessAsString()
	 * @see #setWebThicknessAsString(String)
	 * @generated
	 */
	void unsetWebThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Web Thickness As String</em>' attribute is set.
	 * @see #unsetWebThicknessAsString()
	 * @see #getWebThicknessAsString()
	 * @see #setWebThicknessAsString(String)
	 * @generated
	 */
	boolean isSetWebThicknessAsString();

	/**
	 * Returns the value of the '<em><b>Flange Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Thickness</em>' attribute.
	 * @see #isSetFlangeThickness()
	 * @see #unsetFlangeThickness()
	 * @see #setFlangeThickness(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_FlangeThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFlangeThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Thickness</em>' attribute.
	 * @see #isSetFlangeThickness()
	 * @see #unsetFlangeThickness()
	 * @see #getFlangeThickness()
	 * @generated
	 */
	void setFlangeThickness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeThickness()
	 * @see #getFlangeThickness()
	 * @see #setFlangeThickness(double)
	 * @generated
	 */
	void unsetFlangeThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flange Thickness</em>' attribute is set.
	 * @see #unsetFlangeThickness()
	 * @see #getFlangeThickness()
	 * @see #setFlangeThickness(double)
	 * @generated
	 */
	boolean isSetFlangeThickness();

	/**
	 * Returns the value of the '<em><b>Flange Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Thickness As String</em>' attribute.
	 * @see #isSetFlangeThicknessAsString()
	 * @see #unsetFlangeThicknessAsString()
	 * @see #setFlangeThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_FlangeThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFlangeThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Thickness As String</em>' attribute.
	 * @see #isSetFlangeThicknessAsString()
	 * @see #unsetFlangeThicknessAsString()
	 * @see #getFlangeThicknessAsString()
	 * @generated
	 */
	void setFlangeThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeThicknessAsString()
	 * @see #getFlangeThicknessAsString()
	 * @see #setFlangeThicknessAsString(String)
	 * @generated
	 */
	void unsetFlangeThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flange Thickness As String</em>' attribute is set.
	 * @see #unsetFlangeThicknessAsString()
	 * @see #getFlangeThicknessAsString()
	 * @see #setFlangeThicknessAsString(String)
	 * @generated
	 */
	boolean isSetFlangeThicknessAsString();

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
	 * @see #setFilletRadius(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcIShapeProfileDef_FilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFilletRadius();

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
	void setFilletRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcIShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadius()
	 * @see #getFilletRadius()
	 * @see #setFilletRadius(double)
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
	 * @see #setFilletRadius(double)
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
