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
	 * @see #setOverallWidth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_OverallWidth()
	 * @model
	 * @generated
	 */
	double getOverallWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getOverallWidth <em>Overall Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Width</em>' attribute.
	 * @see #getOverallWidth()
	 * @generated
	 */
	void setOverallWidth(double value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_OverallWidthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getOverallWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getOverallWidthAsString <em>Overall Width As String</em>}' attribute.
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
	 * @see #setOverallDepth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_OverallDepth()
	 * @model
	 * @generated
	 */
	double getOverallDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getOverallDepth <em>Overall Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Depth</em>' attribute.
	 * @see #getOverallDepth()
	 * @generated
	 */
	void setOverallDepth(double value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_OverallDepthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getOverallDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getOverallDepthAsString <em>Overall Depth As String</em>}' attribute.
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
	 * @see #setWebThickness(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_WebThickness()
	 * @model
	 * @generated
	 */
	double getWebThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Thickness</em>' attribute.
	 * @see #getWebThickness()
	 * @generated
	 */
	void setWebThickness(double value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_WebThicknessAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getWebThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute.
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
	 * @see #setFlangeThickness(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_FlangeThickness()
	 * @model
	 * @generated
	 */
	double getFlangeThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeThickness <em>Flange Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Thickness</em>' attribute.
	 * @see #getFlangeThickness()
	 * @generated
	 */
	void setFlangeThickness(double value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_FlangeThicknessAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFlangeThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeThicknessAsString <em>Flange Thickness As String</em>}' attribute.
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
	 * @see #setFilletRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_FilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadius()
	 * @see #getFilletRadius()
	 * @see #setFilletRadius(double)
	 * @generated
	 */
	void unsetFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_FilletRadiusAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadiusAsString()
	 * @see #getFilletRadiusAsString()
	 * @see #setFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute is set.
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
	 * @see #setFlangeEdgeRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_FlangeEdgeRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFlangeEdgeRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeEdgeRadius <em>Flange Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flange Edge Radius</em>' attribute.
	 * @see #isSetFlangeEdgeRadius()
	 * @see #unsetFlangeEdgeRadius()
	 * @see #getFlangeEdgeRadius()
	 * @generated
	 */
	void setFlangeEdgeRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeEdgeRadius <em>Flange Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeEdgeRadius()
	 * @see #getFlangeEdgeRadius()
	 * @see #setFlangeEdgeRadius(double)
	 * @generated
	 */
	void unsetFlangeEdgeRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeEdgeRadius <em>Flange Edge Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flange Edge Radius</em>' attribute is set.
	 * @see #unsetFlangeEdgeRadius()
	 * @see #getFlangeEdgeRadius()
	 * @see #setFlangeEdgeRadius(double)
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_FlangeEdgeRadiusAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFlangeEdgeRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeEdgeRadiusAsString <em>Flange Edge Radius As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeEdgeRadiusAsString <em>Flange Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeEdgeRadiusAsString()
	 * @see #getFlangeEdgeRadiusAsString()
	 * @see #setFlangeEdgeRadiusAsString(String)
	 * @generated
	 */
	void unsetFlangeEdgeRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeEdgeRadiusAsString <em>Flange Edge Radius As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_FlangeSlope()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFlangeSlope();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeSlope <em>Flange Slope</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeSlope <em>Flange Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeSlope()
	 * @see #getFlangeSlope()
	 * @see #setFlangeSlope(double)
	 * @generated
	 */
	void unsetFlangeSlope();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeSlope <em>Flange Slope</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIShapeProfileDef_FlangeSlopeAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFlangeSlopeAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeSlopeAsString <em>Flange Slope As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeSlopeAsString <em>Flange Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlangeSlopeAsString()
	 * @see #getFlangeSlopeAsString()
	 * @see #setFlangeSlopeAsString(String)
	 * @generated
	 */
	void unsetFlangeSlopeAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcIShapeProfileDef#getFlangeSlopeAsString <em>Flange Slope As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flange Slope As String</em>' attribute is set.
	 * @see #unsetFlangeSlopeAsString()
	 * @see #getFlangeSlopeAsString()
	 * @see #setFlangeSlopeAsString(String)
	 * @generated
	 */
	boolean isSetFlangeSlopeAsString();

} // IfcIShapeProfileDef
