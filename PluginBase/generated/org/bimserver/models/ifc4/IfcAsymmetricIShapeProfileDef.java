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

public interface IfcAsymmetricIShapeProfileDef extends IfcParameterizedProfileDef {
	/**
	 * Returns the value of the '<em><b>Bottom Flange Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Flange Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Flange Width</em>' attribute.
	 * @see #setBottomFlangeWidth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_BottomFlangeWidth()
	 * @model
	 * @generated
	 */
	double getBottomFlangeWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeWidth <em>Bottom Flange Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Flange Width</em>' attribute.
	 * @see #getBottomFlangeWidth()
	 * @generated
	 */
	void setBottomFlangeWidth(double value);

	/**
	 * Returns the value of the '<em><b>Bottom Flange Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Flange Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Flange Width As String</em>' attribute.
	 * @see #setBottomFlangeWidthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_BottomFlangeWidthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getBottomFlangeWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeWidthAsString <em>Bottom Flange Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Flange Width As String</em>' attribute.
	 * @see #getBottomFlangeWidthAsString()
	 * @generated
	 */
	void setBottomFlangeWidthAsString(String value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_OverallDepth()
	 * @model
	 * @generated
	 */
	double getOverallDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getOverallDepth <em>Overall Depth</em>}' attribute.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_OverallDepthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getOverallDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getOverallDepthAsString <em>Overall Depth As String</em>}' attribute.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_WebThickness()
	 * @model
	 * @generated
	 */
	double getWebThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_WebThicknessAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getWebThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Thickness As String</em>' attribute.
	 * @see #getWebThicknessAsString()
	 * @generated
	 */
	void setWebThicknessAsString(String value);

	/**
	 * Returns the value of the '<em><b>Bottom Flange Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Flange Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Flange Thickness</em>' attribute.
	 * @see #setBottomFlangeThickness(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_BottomFlangeThickness()
	 * @model
	 * @generated
	 */
	double getBottomFlangeThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeThickness <em>Bottom Flange Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Flange Thickness</em>' attribute.
	 * @see #getBottomFlangeThickness()
	 * @generated
	 */
	void setBottomFlangeThickness(double value);

	/**
	 * Returns the value of the '<em><b>Bottom Flange Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Flange Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Flange Thickness As String</em>' attribute.
	 * @see #setBottomFlangeThicknessAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_BottomFlangeThicknessAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getBottomFlangeThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeThicknessAsString <em>Bottom Flange Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Flange Thickness As String</em>' attribute.
	 * @see #getBottomFlangeThicknessAsString()
	 * @generated
	 */
	void setBottomFlangeThicknessAsString(String value);

	/**
	 * Returns the value of the '<em><b>Bottom Flange Fillet Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Flange Fillet Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Flange Fillet Radius</em>' attribute.
	 * @see #isSetBottomFlangeFilletRadius()
	 * @see #unsetBottomFlangeFilletRadius()
	 * @see #setBottomFlangeFilletRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_BottomFlangeFilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBottomFlangeFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeFilletRadius <em>Bottom Flange Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Flange Fillet Radius</em>' attribute.
	 * @see #isSetBottomFlangeFilletRadius()
	 * @see #unsetBottomFlangeFilletRadius()
	 * @see #getBottomFlangeFilletRadius()
	 * @generated
	 */
	void setBottomFlangeFilletRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeFilletRadius <em>Bottom Flange Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomFlangeFilletRadius()
	 * @see #getBottomFlangeFilletRadius()
	 * @see #setBottomFlangeFilletRadius(double)
	 * @generated
	 */
	void unsetBottomFlangeFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeFilletRadius <em>Bottom Flange Fillet Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom Flange Fillet Radius</em>' attribute is set.
	 * @see #unsetBottomFlangeFilletRadius()
	 * @see #getBottomFlangeFilletRadius()
	 * @see #setBottomFlangeFilletRadius(double)
	 * @generated
	 */
	boolean isSetBottomFlangeFilletRadius();

	/**
	 * Returns the value of the '<em><b>Bottom Flange Fillet Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Flange Fillet Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Flange Fillet Radius As String</em>' attribute.
	 * @see #isSetBottomFlangeFilletRadiusAsString()
	 * @see #unsetBottomFlangeFilletRadiusAsString()
	 * @see #setBottomFlangeFilletRadiusAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_BottomFlangeFilletRadiusAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getBottomFlangeFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeFilletRadiusAsString <em>Bottom Flange Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Flange Fillet Radius As String</em>' attribute.
	 * @see #isSetBottomFlangeFilletRadiusAsString()
	 * @see #unsetBottomFlangeFilletRadiusAsString()
	 * @see #getBottomFlangeFilletRadiusAsString()
	 * @generated
	 */
	void setBottomFlangeFilletRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeFilletRadiusAsString <em>Bottom Flange Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomFlangeFilletRadiusAsString()
	 * @see #getBottomFlangeFilletRadiusAsString()
	 * @see #setBottomFlangeFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetBottomFlangeFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeFilletRadiusAsString <em>Bottom Flange Fillet Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom Flange Fillet Radius As String</em>' attribute is set.
	 * @see #unsetBottomFlangeFilletRadiusAsString()
	 * @see #getBottomFlangeFilletRadiusAsString()
	 * @see #setBottomFlangeFilletRadiusAsString(String)
	 * @generated
	 */
	boolean isSetBottomFlangeFilletRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Top Flange Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Flange Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Flange Width</em>' attribute.
	 * @see #setTopFlangeWidth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_TopFlangeWidth()
	 * @model
	 * @generated
	 */
	double getTopFlangeWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeWidth <em>Top Flange Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Flange Width</em>' attribute.
	 * @see #getTopFlangeWidth()
	 * @generated
	 */
	void setTopFlangeWidth(double value);

	/**
	 * Returns the value of the '<em><b>Top Flange Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Flange Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Flange Width As String</em>' attribute.
	 * @see #setTopFlangeWidthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_TopFlangeWidthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTopFlangeWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeWidthAsString <em>Top Flange Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Flange Width As String</em>' attribute.
	 * @see #getTopFlangeWidthAsString()
	 * @generated
	 */
	void setTopFlangeWidthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Top Flange Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Flange Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Flange Thickness</em>' attribute.
	 * @see #isSetTopFlangeThickness()
	 * @see #unsetTopFlangeThickness()
	 * @see #setTopFlangeThickness(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_TopFlangeThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTopFlangeThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeThickness <em>Top Flange Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Flange Thickness</em>' attribute.
	 * @see #isSetTopFlangeThickness()
	 * @see #unsetTopFlangeThickness()
	 * @see #getTopFlangeThickness()
	 * @generated
	 */
	void setTopFlangeThickness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeThickness <em>Top Flange Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopFlangeThickness()
	 * @see #getTopFlangeThickness()
	 * @see #setTopFlangeThickness(double)
	 * @generated
	 */
	void unsetTopFlangeThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeThickness <em>Top Flange Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top Flange Thickness</em>' attribute is set.
	 * @see #unsetTopFlangeThickness()
	 * @see #getTopFlangeThickness()
	 * @see #setTopFlangeThickness(double)
	 * @generated
	 */
	boolean isSetTopFlangeThickness();

	/**
	 * Returns the value of the '<em><b>Top Flange Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Flange Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Flange Thickness As String</em>' attribute.
	 * @see #isSetTopFlangeThicknessAsString()
	 * @see #unsetTopFlangeThicknessAsString()
	 * @see #setTopFlangeThicknessAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_TopFlangeThicknessAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTopFlangeThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeThicknessAsString <em>Top Flange Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Flange Thickness As String</em>' attribute.
	 * @see #isSetTopFlangeThicknessAsString()
	 * @see #unsetTopFlangeThicknessAsString()
	 * @see #getTopFlangeThicknessAsString()
	 * @generated
	 */
	void setTopFlangeThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeThicknessAsString <em>Top Flange Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopFlangeThicknessAsString()
	 * @see #getTopFlangeThicknessAsString()
	 * @see #setTopFlangeThicknessAsString(String)
	 * @generated
	 */
	void unsetTopFlangeThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeThicknessAsString <em>Top Flange Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top Flange Thickness As String</em>' attribute is set.
	 * @see #unsetTopFlangeThicknessAsString()
	 * @see #getTopFlangeThicknessAsString()
	 * @see #setTopFlangeThicknessAsString(String)
	 * @generated
	 */
	boolean isSetTopFlangeThicknessAsString();

	/**
	 * Returns the value of the '<em><b>Top Flange Fillet Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Flange Fillet Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Flange Fillet Radius</em>' attribute.
	 * @see #isSetTopFlangeFilletRadius()
	 * @see #unsetTopFlangeFilletRadius()
	 * @see #setTopFlangeFilletRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTopFlangeFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeFilletRadius <em>Top Flange Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Flange Fillet Radius</em>' attribute.
	 * @see #isSetTopFlangeFilletRadius()
	 * @see #unsetTopFlangeFilletRadius()
	 * @see #getTopFlangeFilletRadius()
	 * @generated
	 */
	void setTopFlangeFilletRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeFilletRadius <em>Top Flange Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopFlangeFilletRadius()
	 * @see #getTopFlangeFilletRadius()
	 * @see #setTopFlangeFilletRadius(double)
	 * @generated
	 */
	void unsetTopFlangeFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeFilletRadius <em>Top Flange Fillet Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top Flange Fillet Radius</em>' attribute is set.
	 * @see #unsetTopFlangeFilletRadius()
	 * @see #getTopFlangeFilletRadius()
	 * @see #setTopFlangeFilletRadius(double)
	 * @generated
	 */
	boolean isSetTopFlangeFilletRadius();

	/**
	 * Returns the value of the '<em><b>Top Flange Fillet Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Flange Fillet Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Flange Fillet Radius As String</em>' attribute.
	 * @see #isSetTopFlangeFilletRadiusAsString()
	 * @see #unsetTopFlangeFilletRadiusAsString()
	 * @see #setTopFlangeFilletRadiusAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadiusAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTopFlangeFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeFilletRadiusAsString <em>Top Flange Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Flange Fillet Radius As String</em>' attribute.
	 * @see #isSetTopFlangeFilletRadiusAsString()
	 * @see #unsetTopFlangeFilletRadiusAsString()
	 * @see #getTopFlangeFilletRadiusAsString()
	 * @generated
	 */
	void setTopFlangeFilletRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeFilletRadiusAsString <em>Top Flange Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopFlangeFilletRadiusAsString()
	 * @see #getTopFlangeFilletRadiusAsString()
	 * @see #setTopFlangeFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetTopFlangeFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeFilletRadiusAsString <em>Top Flange Fillet Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top Flange Fillet Radius As String</em>' attribute is set.
	 * @see #unsetTopFlangeFilletRadiusAsString()
	 * @see #getTopFlangeFilletRadiusAsString()
	 * @see #setTopFlangeFilletRadiusAsString(String)
	 * @generated
	 */
	boolean isSetTopFlangeFilletRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Bottom Flange Edge Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Flange Edge Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Flange Edge Radius</em>' attribute.
	 * @see #isSetBottomFlangeEdgeRadius()
	 * @see #unsetBottomFlangeEdgeRadius()
	 * @see #setBottomFlangeEdgeRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_BottomFlangeEdgeRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBottomFlangeEdgeRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeEdgeRadius <em>Bottom Flange Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Flange Edge Radius</em>' attribute.
	 * @see #isSetBottomFlangeEdgeRadius()
	 * @see #unsetBottomFlangeEdgeRadius()
	 * @see #getBottomFlangeEdgeRadius()
	 * @generated
	 */
	void setBottomFlangeEdgeRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeEdgeRadius <em>Bottom Flange Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomFlangeEdgeRadius()
	 * @see #getBottomFlangeEdgeRadius()
	 * @see #setBottomFlangeEdgeRadius(double)
	 * @generated
	 */
	void unsetBottomFlangeEdgeRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeEdgeRadius <em>Bottom Flange Edge Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom Flange Edge Radius</em>' attribute is set.
	 * @see #unsetBottomFlangeEdgeRadius()
	 * @see #getBottomFlangeEdgeRadius()
	 * @see #setBottomFlangeEdgeRadius(double)
	 * @generated
	 */
	boolean isSetBottomFlangeEdgeRadius();

	/**
	 * Returns the value of the '<em><b>Bottom Flange Edge Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Flange Edge Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Flange Edge Radius As String</em>' attribute.
	 * @see #isSetBottomFlangeEdgeRadiusAsString()
	 * @see #unsetBottomFlangeEdgeRadiusAsString()
	 * @see #setBottomFlangeEdgeRadiusAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_BottomFlangeEdgeRadiusAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getBottomFlangeEdgeRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeEdgeRadiusAsString <em>Bottom Flange Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Flange Edge Radius As String</em>' attribute.
	 * @see #isSetBottomFlangeEdgeRadiusAsString()
	 * @see #unsetBottomFlangeEdgeRadiusAsString()
	 * @see #getBottomFlangeEdgeRadiusAsString()
	 * @generated
	 */
	void setBottomFlangeEdgeRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeEdgeRadiusAsString <em>Bottom Flange Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomFlangeEdgeRadiusAsString()
	 * @see #getBottomFlangeEdgeRadiusAsString()
	 * @see #setBottomFlangeEdgeRadiusAsString(String)
	 * @generated
	 */
	void unsetBottomFlangeEdgeRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeEdgeRadiusAsString <em>Bottom Flange Edge Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom Flange Edge Radius As String</em>' attribute is set.
	 * @see #unsetBottomFlangeEdgeRadiusAsString()
	 * @see #getBottomFlangeEdgeRadiusAsString()
	 * @see #setBottomFlangeEdgeRadiusAsString(String)
	 * @generated
	 */
	boolean isSetBottomFlangeEdgeRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Bottom Flange Slope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Flange Slope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Flange Slope</em>' attribute.
	 * @see #isSetBottomFlangeSlope()
	 * @see #unsetBottomFlangeSlope()
	 * @see #setBottomFlangeSlope(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_BottomFlangeSlope()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBottomFlangeSlope();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeSlope <em>Bottom Flange Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Flange Slope</em>' attribute.
	 * @see #isSetBottomFlangeSlope()
	 * @see #unsetBottomFlangeSlope()
	 * @see #getBottomFlangeSlope()
	 * @generated
	 */
	void setBottomFlangeSlope(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeSlope <em>Bottom Flange Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomFlangeSlope()
	 * @see #getBottomFlangeSlope()
	 * @see #setBottomFlangeSlope(double)
	 * @generated
	 */
	void unsetBottomFlangeSlope();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeSlope <em>Bottom Flange Slope</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom Flange Slope</em>' attribute is set.
	 * @see #unsetBottomFlangeSlope()
	 * @see #getBottomFlangeSlope()
	 * @see #setBottomFlangeSlope(double)
	 * @generated
	 */
	boolean isSetBottomFlangeSlope();

	/**
	 * Returns the value of the '<em><b>Bottom Flange Slope As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Flange Slope As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Flange Slope As String</em>' attribute.
	 * @see #isSetBottomFlangeSlopeAsString()
	 * @see #unsetBottomFlangeSlopeAsString()
	 * @see #setBottomFlangeSlopeAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_BottomFlangeSlopeAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getBottomFlangeSlopeAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeSlopeAsString <em>Bottom Flange Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Flange Slope As String</em>' attribute.
	 * @see #isSetBottomFlangeSlopeAsString()
	 * @see #unsetBottomFlangeSlopeAsString()
	 * @see #getBottomFlangeSlopeAsString()
	 * @generated
	 */
	void setBottomFlangeSlopeAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeSlopeAsString <em>Bottom Flange Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomFlangeSlopeAsString()
	 * @see #getBottomFlangeSlopeAsString()
	 * @see #setBottomFlangeSlopeAsString(String)
	 * @generated
	 */
	void unsetBottomFlangeSlopeAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getBottomFlangeSlopeAsString <em>Bottom Flange Slope As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom Flange Slope As String</em>' attribute is set.
	 * @see #unsetBottomFlangeSlopeAsString()
	 * @see #getBottomFlangeSlopeAsString()
	 * @see #setBottomFlangeSlopeAsString(String)
	 * @generated
	 */
	boolean isSetBottomFlangeSlopeAsString();

	/**
	 * Returns the value of the '<em><b>Top Flange Edge Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Flange Edge Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Flange Edge Radius</em>' attribute.
	 * @see #isSetTopFlangeEdgeRadius()
	 * @see #unsetTopFlangeEdgeRadius()
	 * @see #setTopFlangeEdgeRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_TopFlangeEdgeRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTopFlangeEdgeRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeEdgeRadius <em>Top Flange Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Flange Edge Radius</em>' attribute.
	 * @see #isSetTopFlangeEdgeRadius()
	 * @see #unsetTopFlangeEdgeRadius()
	 * @see #getTopFlangeEdgeRadius()
	 * @generated
	 */
	void setTopFlangeEdgeRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeEdgeRadius <em>Top Flange Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopFlangeEdgeRadius()
	 * @see #getTopFlangeEdgeRadius()
	 * @see #setTopFlangeEdgeRadius(double)
	 * @generated
	 */
	void unsetTopFlangeEdgeRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeEdgeRadius <em>Top Flange Edge Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top Flange Edge Radius</em>' attribute is set.
	 * @see #unsetTopFlangeEdgeRadius()
	 * @see #getTopFlangeEdgeRadius()
	 * @see #setTopFlangeEdgeRadius(double)
	 * @generated
	 */
	boolean isSetTopFlangeEdgeRadius();

	/**
	 * Returns the value of the '<em><b>Top Flange Edge Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Flange Edge Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Flange Edge Radius As String</em>' attribute.
	 * @see #isSetTopFlangeEdgeRadiusAsString()
	 * @see #unsetTopFlangeEdgeRadiusAsString()
	 * @see #setTopFlangeEdgeRadiusAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_TopFlangeEdgeRadiusAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTopFlangeEdgeRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeEdgeRadiusAsString <em>Top Flange Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Flange Edge Radius As String</em>' attribute.
	 * @see #isSetTopFlangeEdgeRadiusAsString()
	 * @see #unsetTopFlangeEdgeRadiusAsString()
	 * @see #getTopFlangeEdgeRadiusAsString()
	 * @generated
	 */
	void setTopFlangeEdgeRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeEdgeRadiusAsString <em>Top Flange Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopFlangeEdgeRadiusAsString()
	 * @see #getTopFlangeEdgeRadiusAsString()
	 * @see #setTopFlangeEdgeRadiusAsString(String)
	 * @generated
	 */
	void unsetTopFlangeEdgeRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeEdgeRadiusAsString <em>Top Flange Edge Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top Flange Edge Radius As String</em>' attribute is set.
	 * @see #unsetTopFlangeEdgeRadiusAsString()
	 * @see #getTopFlangeEdgeRadiusAsString()
	 * @see #setTopFlangeEdgeRadiusAsString(String)
	 * @generated
	 */
	boolean isSetTopFlangeEdgeRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Top Flange Slope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Flange Slope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Flange Slope</em>' attribute.
	 * @see #isSetTopFlangeSlope()
	 * @see #unsetTopFlangeSlope()
	 * @see #setTopFlangeSlope(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_TopFlangeSlope()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTopFlangeSlope();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeSlope <em>Top Flange Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Flange Slope</em>' attribute.
	 * @see #isSetTopFlangeSlope()
	 * @see #unsetTopFlangeSlope()
	 * @see #getTopFlangeSlope()
	 * @generated
	 */
	void setTopFlangeSlope(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeSlope <em>Top Flange Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopFlangeSlope()
	 * @see #getTopFlangeSlope()
	 * @see #setTopFlangeSlope(double)
	 * @generated
	 */
	void unsetTopFlangeSlope();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeSlope <em>Top Flange Slope</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top Flange Slope</em>' attribute is set.
	 * @see #unsetTopFlangeSlope()
	 * @see #getTopFlangeSlope()
	 * @see #setTopFlangeSlope(double)
	 * @generated
	 */
	boolean isSetTopFlangeSlope();

	/**
	 * Returns the value of the '<em><b>Top Flange Slope As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Flange Slope As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Flange Slope As String</em>' attribute.
	 * @see #isSetTopFlangeSlopeAsString()
	 * @see #unsetTopFlangeSlopeAsString()
	 * @see #setTopFlangeSlopeAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsymmetricIShapeProfileDef_TopFlangeSlopeAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTopFlangeSlopeAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeSlopeAsString <em>Top Flange Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Flange Slope As String</em>' attribute.
	 * @see #isSetTopFlangeSlopeAsString()
	 * @see #unsetTopFlangeSlopeAsString()
	 * @see #getTopFlangeSlopeAsString()
	 * @generated
	 */
	void setTopFlangeSlopeAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeSlopeAsString <em>Top Flange Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopFlangeSlopeAsString()
	 * @see #getTopFlangeSlopeAsString()
	 * @see #setTopFlangeSlopeAsString(String)
	 * @generated
	 */
	void unsetTopFlangeSlopeAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef#getTopFlangeSlopeAsString <em>Top Flange Slope As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top Flange Slope As String</em>' attribute is set.
	 * @see #unsetTopFlangeSlopeAsString()
	 * @see #getTopFlangeSlopeAsString()
	 * @see #setTopFlangeSlopeAsString(String)
	 * @generated
	 */
	boolean isSetTopFlangeSlopeAsString();

} // IfcAsymmetricIShapeProfileDef
