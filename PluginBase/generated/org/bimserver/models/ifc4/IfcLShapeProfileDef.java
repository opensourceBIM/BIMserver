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

public interface IfcLShapeProfileDef extends IfcParameterizedProfileDef {
	/**
	 * Returns the value of the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth</em>' attribute.
	 * @see #setDepth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_Depth()
	 * @model
	 * @generated
	 */
	double getDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth</em>' attribute.
	 * @see #getDepth()
	 * @generated
	 */
	void setDepth(double value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_DepthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getDepthAsString <em>Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth As String</em>' attribute.
	 * @see #getDepthAsString()
	 * @generated
	 */
	void setDepthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #isSetWidth()
	 * @see #unsetWidth()
	 * @see #setWidth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_Width()
	 * @model unsettable="true"
	 * @generated
	 */
	double getWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #isSetWidth()
	 * @see #unsetWidth()
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWidth()
	 * @see #getWidth()
	 * @see #setWidth(double)
	 * @generated
	 */
	void unsetWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getWidth <em>Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Width</em>' attribute is set.
	 * @see #unsetWidth()
	 * @see #getWidth()
	 * @see #setWidth(double)
	 * @generated
	 */
	boolean isSetWidth();

	/**
	 * Returns the value of the '<em><b>Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width As String</em>' attribute.
	 * @see #isSetWidthAsString()
	 * @see #unsetWidthAsString()
	 * @see #setWidthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_WidthAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getWidthAsString <em>Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width As String</em>' attribute.
	 * @see #isSetWidthAsString()
	 * @see #unsetWidthAsString()
	 * @see #getWidthAsString()
	 * @generated
	 */
	void setWidthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getWidthAsString <em>Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWidthAsString()
	 * @see #getWidthAsString()
	 * @see #setWidthAsString(String)
	 * @generated
	 */
	void unsetWidthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getWidthAsString <em>Width As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Width As String</em>' attribute is set.
	 * @see #unsetWidthAsString()
	 * @see #getWidthAsString()
	 * @see #setWidthAsString(String)
	 * @generated
	 */
	boolean isSetWidthAsString();

	/**
	 * Returns the value of the '<em><b>Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thickness</em>' attribute.
	 * @see #setThickness(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_Thickness()
	 * @model
	 * @generated
	 */
	double getThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getThickness <em>Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thickness</em>' attribute.
	 * @see #getThickness()
	 * @generated
	 */
	void setThickness(double value);

	/**
	 * Returns the value of the '<em><b>Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thickness As String</em>' attribute.
	 * @see #setThicknessAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_ThicknessAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getThicknessAsString <em>Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thickness As String</em>' attribute.
	 * @see #getThicknessAsString()
	 * @generated
	 */
	void setThicknessAsString(String value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_FilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadius()
	 * @see #getFilletRadius()
	 * @see #setFilletRadius(double)
	 * @generated
	 */
	void unsetFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getFilletRadius <em>Fillet Radius</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_FilletRadiusAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadiusAsString()
	 * @see #getFilletRadiusAsString()
	 * @see #setFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_EdgeRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getEdgeRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getEdgeRadius <em>Edge Radius</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getEdgeRadius <em>Edge Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEdgeRadius()
	 * @see #getEdgeRadius()
	 * @see #setEdgeRadius(double)
	 * @generated
	 */
	void unsetEdgeRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getEdgeRadius <em>Edge Radius</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_EdgeRadiusAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getEdgeRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getEdgeRadiusAsString <em>Edge Radius As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getEdgeRadiusAsString <em>Edge Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEdgeRadiusAsString()
	 * @see #getEdgeRadiusAsString()
	 * @see #setEdgeRadiusAsString(String)
	 * @generated
	 */
	void unsetEdgeRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getEdgeRadiusAsString <em>Edge Radius As String</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Leg Slope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leg Slope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leg Slope</em>' attribute.
	 * @see #isSetLegSlope()
	 * @see #unsetLegSlope()
	 * @see #setLegSlope(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_LegSlope()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLegSlope();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getLegSlope <em>Leg Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leg Slope</em>' attribute.
	 * @see #isSetLegSlope()
	 * @see #unsetLegSlope()
	 * @see #getLegSlope()
	 * @generated
	 */
	void setLegSlope(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getLegSlope <em>Leg Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLegSlope()
	 * @see #getLegSlope()
	 * @see #setLegSlope(double)
	 * @generated
	 */
	void unsetLegSlope();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getLegSlope <em>Leg Slope</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Leg Slope</em>' attribute is set.
	 * @see #unsetLegSlope()
	 * @see #getLegSlope()
	 * @see #setLegSlope(double)
	 * @generated
	 */
	boolean isSetLegSlope();

	/**
	 * Returns the value of the '<em><b>Leg Slope As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leg Slope As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leg Slope As String</em>' attribute.
	 * @see #isSetLegSlopeAsString()
	 * @see #unsetLegSlopeAsString()
	 * @see #setLegSlopeAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLShapeProfileDef_LegSlopeAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLegSlopeAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getLegSlopeAsString <em>Leg Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leg Slope As String</em>' attribute.
	 * @see #isSetLegSlopeAsString()
	 * @see #unsetLegSlopeAsString()
	 * @see #getLegSlopeAsString()
	 * @generated
	 */
	void setLegSlopeAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getLegSlopeAsString <em>Leg Slope As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLegSlopeAsString()
	 * @see #getLegSlopeAsString()
	 * @see #setLegSlopeAsString(String)
	 * @generated
	 */
	void unsetLegSlopeAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLShapeProfileDef#getLegSlopeAsString <em>Leg Slope As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Leg Slope As String</em>' attribute is set.
	 * @see #unsetLegSlopeAsString()
	 * @see #getLegSlopeAsString()
	 * @see #setLegSlopeAsString(String)
	 * @generated
	 */
	boolean isSetLegSlopeAsString();

} // IfcLShapeProfileDef
