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
 * A representation of the model object '<em><b>Ifc UShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeWidth <em>Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeWidthAsString <em>Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getEdgeRadius <em>Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getEdgeRadiusAsString <em>Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeSlope <em>Flange Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeSlopeAsString <em>Flange Slope As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef()
 * @model
 * @generated
 */
public interface IfcUShapeProfileDef extends IfcParameterizedProfileDef {
	/**
	 * Returns the value of the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth</em>' attribute.
	 * @see #isSetDepth()
	 * @see #unsetDepth()
	 * @see #setDepth(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_Depth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth</em>' attribute.
	 * @see #isSetDepth()
	 * @see #unsetDepth()
	 * @see #getDepth()
	 * @generated
	 */
	void setDepth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDepth()
	 * @see #getDepth()
	 * @see #setDepth(double)
	 * @generated
	 */
	void unsetDepth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getDepth <em>Depth</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Depth</em>' attribute is set.
	 * @see #unsetDepth()
	 * @see #getDepth()
	 * @see #setDepth(double)
	 * @generated
	 */
	boolean isSetDepth();

	/**
	 * Returns the value of the '<em><b>Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth As String</em>' attribute.
	 * @see #isSetDepthAsString()
	 * @see #unsetDepthAsString()
	 * @see #setDepthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_DepthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getDepthAsString <em>Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth As String</em>' attribute.
	 * @see #isSetDepthAsString()
	 * @see #unsetDepthAsString()
	 * @see #getDepthAsString()
	 * @generated
	 */
	void setDepthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getDepthAsString <em>Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDepthAsString()
	 * @see #getDepthAsString()
	 * @see #setDepthAsString(String)
	 * @generated
	 */
	void unsetDepthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getDepthAsString <em>Depth As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Depth As String</em>' attribute is set.
	 * @see #unsetDepthAsString()
	 * @see #getDepthAsString()
	 * @see #setDepthAsString(String)
	 * @generated
	 */
	boolean isSetDepthAsString();

	/**
	 * Returns the value of the '<em><b>Flange Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Width</em>' attribute.
	 * @see #isSetFlangeWidth()
	 * @see #unsetFlangeWidth()
	 * @see #setFlangeWidth(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_FlangeWidth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFlangeWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeWidth <em>Flange Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Width</em>' attribute.
	 * @see #isSetFlangeWidth()
	 * @see #unsetFlangeWidth()
	 * @see #getFlangeWidth()
	 * @generated
	 */
	void setFlangeWidth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeWidth <em>Flange Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeWidth()
	 * @see #getFlangeWidth()
	 * @see #setFlangeWidth(double)
	 * @generated
	 */
	void unsetFlangeWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeWidth <em>Flange Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flange Width</em>' attribute is set.
	 * @see #unsetFlangeWidth()
	 * @see #getFlangeWidth()
	 * @see #setFlangeWidth(double)
	 * @generated
	 */
	boolean isSetFlangeWidth();

	/**
	 * Returns the value of the '<em><b>Flange Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flange Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flange Width As String</em>' attribute.
	 * @see #isSetFlangeWidthAsString()
	 * @see #unsetFlangeWidthAsString()
	 * @see #setFlangeWidthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_FlangeWidthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFlangeWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeWidthAsString <em>Flange Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Width As String</em>' attribute.
	 * @see #isSetFlangeWidthAsString()
	 * @see #unsetFlangeWidthAsString()
	 * @see #getFlangeWidthAsString()
	 * @generated
	 */
	void setFlangeWidthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeWidthAsString <em>Flange Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeWidthAsString()
	 * @see #getFlangeWidthAsString()
	 * @see #setFlangeWidthAsString(String)
	 * @generated
	 */
	void unsetFlangeWidthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeWidthAsString <em>Flange Width As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flange Width As String</em>' attribute is set.
	 * @see #unsetFlangeWidthAsString()
	 * @see #getFlangeWidthAsString()
	 * @see #setFlangeWidthAsString(String)
	 * @generated
	 */
	boolean isSetFlangeWidthAsString();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_WebThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getWebThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWebThickness()
	 * @see #getWebThickness()
	 * @see #setWebThickness(double)
	 * @generated
	 */
	void unsetWebThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_WebThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWebThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWebThicknessAsString()
	 * @see #getWebThicknessAsString()
	 * @see #setWebThicknessAsString(String)
	 * @generated
	 */
	void unsetWebThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_FlangeThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFlangeThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeThickness()
	 * @see #getFlangeThickness()
	 * @see #setFlangeThickness(double)
	 * @generated
	 */
	void unsetFlangeThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_FlangeThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFlangeThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeThicknessAsString()
	 * @see #getFlangeThicknessAsString()
	 * @see #setFlangeThicknessAsString(String)
	 * @generated
	 */
	void unsetFlangeThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_FilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadius()
	 * @see #getFilletRadius()
	 * @see #setFilletRadius(double)
	 * @generated
	 */
	void unsetFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_FilletRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadiusAsString()
	 * @see #getFilletRadiusAsString()
	 * @see #setFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Edge Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Radius</em>' attribute.
	 * @see #isSetEdgeRadius()
	 * @see #unsetEdgeRadius()
	 * @see #setEdgeRadius(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_EdgeRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getEdgeRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getEdgeRadius <em>Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge Radius</em>' attribute.
	 * @see #isSetEdgeRadius()
	 * @see #unsetEdgeRadius()
	 * @see #getEdgeRadius()
	 * @generated
	 */
	void setEdgeRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getEdgeRadius <em>Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEdgeRadius()
	 * @see #getEdgeRadius()
	 * @see #setEdgeRadius(double)
	 * @generated
	 */
	void unsetEdgeRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getEdgeRadius <em>Edge Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Edge Radius</em>' attribute is set.
	 * @see #unsetEdgeRadius()
	 * @see #getEdgeRadius()
	 * @see #setEdgeRadius(double)
	 * @generated
	 */
	boolean isSetEdgeRadius();

	/**
	 * Returns the value of the '<em><b>Edge Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Radius As String</em>' attribute.
	 * @see #isSetEdgeRadiusAsString()
	 * @see #unsetEdgeRadiusAsString()
	 * @see #setEdgeRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_EdgeRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEdgeRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getEdgeRadiusAsString <em>Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge Radius As String</em>' attribute.
	 * @see #isSetEdgeRadiusAsString()
	 * @see #unsetEdgeRadiusAsString()
	 * @see #getEdgeRadiusAsString()
	 * @generated
	 */
	void setEdgeRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getEdgeRadiusAsString <em>Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEdgeRadiusAsString()
	 * @see #getEdgeRadiusAsString()
	 * @see #setEdgeRadiusAsString(String)
	 * @generated
	 */
	void unsetEdgeRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getEdgeRadiusAsString <em>Edge Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Edge Radius As String</em>' attribute is set.
	 * @see #unsetEdgeRadiusAsString()
	 * @see #getEdgeRadiusAsString()
	 * @see #setEdgeRadiusAsString(String)
	 * @generated
	 */
	boolean isSetEdgeRadiusAsString();

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
	 * @see #setFlangeSlope(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_FlangeSlope()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFlangeSlope();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeSlope <em>Flange Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Slope</em>' attribute.
	 * @see #isSetFlangeSlope()
	 * @see #unsetFlangeSlope()
	 * @see #getFlangeSlope()
	 * @generated
	 */
	void setFlangeSlope(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeSlope <em>Flange Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeSlope()
	 * @see #getFlangeSlope()
	 * @see #setFlangeSlope(double)
	 * @generated
	 */
	void unsetFlangeSlope();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeSlope <em>Flange Slope</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flange Slope</em>' attribute is set.
	 * @see #unsetFlangeSlope()
	 * @see #getFlangeSlope()
	 * @see #setFlangeSlope(double)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_FlangeSlopeAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFlangeSlopeAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeSlopeAsString <em>Flange Slope As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeSlopeAsString <em>Flange Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeSlopeAsString()
	 * @see #getFlangeSlopeAsString()
	 * @see #setFlangeSlopeAsString(String)
	 * @generated
	 */
	void unsetFlangeSlopeAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getFlangeSlopeAsString <em>Flange Slope As String</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Centre Of Gravity In X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Centre Of Gravity In X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Centre Of Gravity In X</em>' attribute.
	 * @see #isSetCentreOfGravityInX()
	 * @see #unsetCentreOfGravityInX()
	 * @see #setCentreOfGravityInX(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_CentreOfGravityInX()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCentreOfGravityInX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Centre Of Gravity In X</em>' attribute.
	 * @see #isSetCentreOfGravityInX()
	 * @see #unsetCentreOfGravityInX()
	 * @see #getCentreOfGravityInX()
	 * @generated
	 */
	void setCentreOfGravityInX(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCentreOfGravityInX()
	 * @see #getCentreOfGravityInX()
	 * @see #setCentreOfGravityInX(double)
	 * @generated
	 */
	void unsetCentreOfGravityInX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Centre Of Gravity In X</em>' attribute is set.
	 * @see #unsetCentreOfGravityInX()
	 * @see #getCentreOfGravityInX()
	 * @see #setCentreOfGravityInX(double)
	 * @generated
	 */
	boolean isSetCentreOfGravityInX();

	/**
	 * Returns the value of the '<em><b>Centre Of Gravity In XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Centre Of Gravity In XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Centre Of Gravity In XAs String</em>' attribute.
	 * @see #isSetCentreOfGravityInXAsString()
	 * @see #unsetCentreOfGravityInXAsString()
	 * @see #setCentreOfGravityInXAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUShapeProfileDef_CentreOfGravityInXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCentreOfGravityInXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Centre Of Gravity In XAs String</em>' attribute.
	 * @see #isSetCentreOfGravityInXAsString()
	 * @see #unsetCentreOfGravityInXAsString()
	 * @see #getCentreOfGravityInXAsString()
	 * @generated
	 */
	void setCentreOfGravityInXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCentreOfGravityInXAsString()
	 * @see #getCentreOfGravityInXAsString()
	 * @see #setCentreOfGravityInXAsString(String)
	 * @generated
	 */
	void unsetCentreOfGravityInXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcUShapeProfileDef#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Centre Of Gravity In XAs String</em>' attribute is set.
	 * @see #unsetCentreOfGravityInXAsString()
	 * @see #getCentreOfGravityInXAsString()
	 * @see #setCentreOfGravityInXAsString(String)
	 * @generated
	 */
	boolean isSetCentreOfGravityInXAsString();

} // IfcUShapeProfileDef
