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
 * A representation of the model object '<em><b>Ifc Crane Rail FShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getOverallHeight <em>Overall Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getOverallHeightAsString <em>Overall Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadWidth <em>Head Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadWidthAsString <em>Head Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getRadiusAsString <em>Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth2 <em>Head Depth2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth2AsString <em>Head Depth2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth3 <em>Head Depth3</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth3AsString <em>Head Depth3 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth1 <em>Base Depth1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth1AsString <em>Base Depth1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth2 <em>Base Depth2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth2AsString <em>Base Depth2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef()
 * @model
 * @generated
 */
public interface IfcCraneRailFShapeProfileDef extends IfcParameterizedProfileDef {
	/**
	 * Returns the value of the '<em><b>Overall Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Height</em>' attribute.
	 * @see #isSetOverallHeight()
	 * @see #unsetOverallHeight()
	 * @see #setOverallHeight(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_OverallHeight()
	 * @model unsettable="true"
	 * @generated
	 */
	double getOverallHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getOverallHeight <em>Overall Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Height</em>' attribute.
	 * @see #isSetOverallHeight()
	 * @see #unsetOverallHeight()
	 * @see #getOverallHeight()
	 * @generated
	 */
	void setOverallHeight(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getOverallHeight <em>Overall Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOverallHeight()
	 * @see #getOverallHeight()
	 * @see #setOverallHeight(double)
	 * @generated
	 */
	void unsetOverallHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getOverallHeight <em>Overall Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Overall Height</em>' attribute is set.
	 * @see #unsetOverallHeight()
	 * @see #getOverallHeight()
	 * @see #setOverallHeight(double)
	 * @generated
	 */
	boolean isSetOverallHeight();

	/**
	 * Returns the value of the '<em><b>Overall Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Height As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Height As String</em>' attribute.
	 * @see #isSetOverallHeightAsString()
	 * @see #unsetOverallHeightAsString()
	 * @see #setOverallHeightAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_OverallHeightAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getOverallHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getOverallHeightAsString <em>Overall Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Height As String</em>' attribute.
	 * @see #isSetOverallHeightAsString()
	 * @see #unsetOverallHeightAsString()
	 * @see #getOverallHeightAsString()
	 * @generated
	 */
	void setOverallHeightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getOverallHeightAsString <em>Overall Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOverallHeightAsString()
	 * @see #getOverallHeightAsString()
	 * @see #setOverallHeightAsString(String)
	 * @generated
	 */
	void unsetOverallHeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getOverallHeightAsString <em>Overall Height As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Overall Height As String</em>' attribute is set.
	 * @see #unsetOverallHeightAsString()
	 * @see #getOverallHeightAsString()
	 * @see #setOverallHeightAsString(String)
	 * @generated
	 */
	boolean isSetOverallHeightAsString();

	/**
	 * Returns the value of the '<em><b>Head Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Width</em>' attribute.
	 * @see #isSetHeadWidth()
	 * @see #unsetHeadWidth()
	 * @see #setHeadWidth(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadWidth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getHeadWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadWidth <em>Head Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Width</em>' attribute.
	 * @see #isSetHeadWidth()
	 * @see #unsetHeadWidth()
	 * @see #getHeadWidth()
	 * @generated
	 */
	void setHeadWidth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadWidth <em>Head Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeadWidth()
	 * @see #getHeadWidth()
	 * @see #setHeadWidth(double)
	 * @generated
	 */
	void unsetHeadWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadWidth <em>Head Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Head Width</em>' attribute is set.
	 * @see #unsetHeadWidth()
	 * @see #getHeadWidth()
	 * @see #setHeadWidth(double)
	 * @generated
	 */
	boolean isSetHeadWidth();

	/**
	 * Returns the value of the '<em><b>Head Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Width As String</em>' attribute.
	 * @see #isSetHeadWidthAsString()
	 * @see #unsetHeadWidthAsString()
	 * @see #setHeadWidthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadWidthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getHeadWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadWidthAsString <em>Head Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Width As String</em>' attribute.
	 * @see #isSetHeadWidthAsString()
	 * @see #unsetHeadWidthAsString()
	 * @see #getHeadWidthAsString()
	 * @generated
	 */
	void setHeadWidthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadWidthAsString <em>Head Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeadWidthAsString()
	 * @see #getHeadWidthAsString()
	 * @see #setHeadWidthAsString(String)
	 * @generated
	 */
	void unsetHeadWidthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadWidthAsString <em>Head Width As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Head Width As String</em>' attribute is set.
	 * @see #unsetHeadWidthAsString()
	 * @see #getHeadWidthAsString()
	 * @see #setHeadWidthAsString(String)
	 * @generated
	 */
	boolean isSetHeadWidthAsString();

	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #isSetRadius()
	 * @see #unsetRadius()
	 * @see #setRadius(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_Radius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #isSetRadius()
	 * @see #unsetRadius()
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRadius()
	 * @see #getRadius()
	 * @see #setRadius(double)
	 * @generated
	 */
	void unsetRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getRadius <em>Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Radius</em>' attribute is set.
	 * @see #unsetRadius()
	 * @see #getRadius()
	 * @see #setRadius(double)
	 * @generated
	 */
	boolean isSetRadius();

	/**
	 * Returns the value of the '<em><b>Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius As String</em>' attribute.
	 * @see #isSetRadiusAsString()
	 * @see #unsetRadiusAsString()
	 * @see #setRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_RadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getRadiusAsString <em>Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius As String</em>' attribute.
	 * @see #isSetRadiusAsString()
	 * @see #unsetRadiusAsString()
	 * @see #getRadiusAsString()
	 * @generated
	 */
	void setRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getRadiusAsString <em>Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRadiusAsString()
	 * @see #getRadiusAsString()
	 * @see #setRadiusAsString(String)
	 * @generated
	 */
	void unsetRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getRadiusAsString <em>Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Radius As String</em>' attribute is set.
	 * @see #unsetRadiusAsString()
	 * @see #getRadiusAsString()
	 * @see #setRadiusAsString(String)
	 * @generated
	 */
	boolean isSetRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Head Depth2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Depth2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Depth2</em>' attribute.
	 * @see #isSetHeadDepth2()
	 * @see #unsetHeadDepth2()
	 * @see #setHeadDepth2(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadDepth2()
	 * @model unsettable="true"
	 * @generated
	 */
	double getHeadDepth2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth2 <em>Head Depth2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Depth2</em>' attribute.
	 * @see #isSetHeadDepth2()
	 * @see #unsetHeadDepth2()
	 * @see #getHeadDepth2()
	 * @generated
	 */
	void setHeadDepth2(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth2 <em>Head Depth2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeadDepth2()
	 * @see #getHeadDepth2()
	 * @see #setHeadDepth2(double)
	 * @generated
	 */
	void unsetHeadDepth2();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth2 <em>Head Depth2</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Head Depth2</em>' attribute is set.
	 * @see #unsetHeadDepth2()
	 * @see #getHeadDepth2()
	 * @see #setHeadDepth2(double)
	 * @generated
	 */
	boolean isSetHeadDepth2();

	/**
	 * Returns the value of the '<em><b>Head Depth2 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Depth2 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Depth2 As String</em>' attribute.
	 * @see #isSetHeadDepth2AsString()
	 * @see #unsetHeadDepth2AsString()
	 * @see #setHeadDepth2AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadDepth2AsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getHeadDepth2AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth2AsString <em>Head Depth2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Depth2 As String</em>' attribute.
	 * @see #isSetHeadDepth2AsString()
	 * @see #unsetHeadDepth2AsString()
	 * @see #getHeadDepth2AsString()
	 * @generated
	 */
	void setHeadDepth2AsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth2AsString <em>Head Depth2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeadDepth2AsString()
	 * @see #getHeadDepth2AsString()
	 * @see #setHeadDepth2AsString(String)
	 * @generated
	 */
	void unsetHeadDepth2AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth2AsString <em>Head Depth2 As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Head Depth2 As String</em>' attribute is set.
	 * @see #unsetHeadDepth2AsString()
	 * @see #getHeadDepth2AsString()
	 * @see #setHeadDepth2AsString(String)
	 * @generated
	 */
	boolean isSetHeadDepth2AsString();

	/**
	 * Returns the value of the '<em><b>Head Depth3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Depth3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Depth3</em>' attribute.
	 * @see #isSetHeadDepth3()
	 * @see #unsetHeadDepth3()
	 * @see #setHeadDepth3(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadDepth3()
	 * @model unsettable="true"
	 * @generated
	 */
	double getHeadDepth3();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth3 <em>Head Depth3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Depth3</em>' attribute.
	 * @see #isSetHeadDepth3()
	 * @see #unsetHeadDepth3()
	 * @see #getHeadDepth3()
	 * @generated
	 */
	void setHeadDepth3(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth3 <em>Head Depth3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeadDepth3()
	 * @see #getHeadDepth3()
	 * @see #setHeadDepth3(double)
	 * @generated
	 */
	void unsetHeadDepth3();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth3 <em>Head Depth3</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Head Depth3</em>' attribute is set.
	 * @see #unsetHeadDepth3()
	 * @see #getHeadDepth3()
	 * @see #setHeadDepth3(double)
	 * @generated
	 */
	boolean isSetHeadDepth3();

	/**
	 * Returns the value of the '<em><b>Head Depth3 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Depth3 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Depth3 As String</em>' attribute.
	 * @see #isSetHeadDepth3AsString()
	 * @see #unsetHeadDepth3AsString()
	 * @see #setHeadDepth3AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadDepth3AsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getHeadDepth3AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth3AsString <em>Head Depth3 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Depth3 As String</em>' attribute.
	 * @see #isSetHeadDepth3AsString()
	 * @see #unsetHeadDepth3AsString()
	 * @see #getHeadDepth3AsString()
	 * @generated
	 */
	void setHeadDepth3AsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth3AsString <em>Head Depth3 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeadDepth3AsString()
	 * @see #getHeadDepth3AsString()
	 * @see #setHeadDepth3AsString(String)
	 * @generated
	 */
	void unsetHeadDepth3AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth3AsString <em>Head Depth3 As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Head Depth3 As String</em>' attribute is set.
	 * @see #unsetHeadDepth3AsString()
	 * @see #getHeadDepth3AsString()
	 * @see #setHeadDepth3AsString(String)
	 * @generated
	 */
	boolean isSetHeadDepth3AsString();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_WebThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getWebThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWebThickness()
	 * @see #getWebThickness()
	 * @see #setWebThickness(double)
	 * @generated
	 */
	void unsetWebThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_WebThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWebThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWebThicknessAsString()
	 * @see #getWebThicknessAsString()
	 * @see #setWebThicknessAsString(String)
	 * @generated
	 */
	void unsetWebThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Base Depth1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Depth1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Depth1</em>' attribute.
	 * @see #isSetBaseDepth1()
	 * @see #unsetBaseDepth1()
	 * @see #setBaseDepth1(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_BaseDepth1()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBaseDepth1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth1 <em>Base Depth1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Depth1</em>' attribute.
	 * @see #isSetBaseDepth1()
	 * @see #unsetBaseDepth1()
	 * @see #getBaseDepth1()
	 * @generated
	 */
	void setBaseDepth1(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth1 <em>Base Depth1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBaseDepth1()
	 * @see #getBaseDepth1()
	 * @see #setBaseDepth1(double)
	 * @generated
	 */
	void unsetBaseDepth1();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth1 <em>Base Depth1</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Base Depth1</em>' attribute is set.
	 * @see #unsetBaseDepth1()
	 * @see #getBaseDepth1()
	 * @see #setBaseDepth1(double)
	 * @generated
	 */
	boolean isSetBaseDepth1();

	/**
	 * Returns the value of the '<em><b>Base Depth1 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Depth1 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Depth1 As String</em>' attribute.
	 * @see #isSetBaseDepth1AsString()
	 * @see #unsetBaseDepth1AsString()
	 * @see #setBaseDepth1AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_BaseDepth1AsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBaseDepth1AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth1AsString <em>Base Depth1 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Depth1 As String</em>' attribute.
	 * @see #isSetBaseDepth1AsString()
	 * @see #unsetBaseDepth1AsString()
	 * @see #getBaseDepth1AsString()
	 * @generated
	 */
	void setBaseDepth1AsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth1AsString <em>Base Depth1 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBaseDepth1AsString()
	 * @see #getBaseDepth1AsString()
	 * @see #setBaseDepth1AsString(String)
	 * @generated
	 */
	void unsetBaseDepth1AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth1AsString <em>Base Depth1 As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Base Depth1 As String</em>' attribute is set.
	 * @see #unsetBaseDepth1AsString()
	 * @see #getBaseDepth1AsString()
	 * @see #setBaseDepth1AsString(String)
	 * @generated
	 */
	boolean isSetBaseDepth1AsString();

	/**
	 * Returns the value of the '<em><b>Base Depth2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Depth2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Depth2</em>' attribute.
	 * @see #isSetBaseDepth2()
	 * @see #unsetBaseDepth2()
	 * @see #setBaseDepth2(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_BaseDepth2()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBaseDepth2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth2 <em>Base Depth2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Depth2</em>' attribute.
	 * @see #isSetBaseDepth2()
	 * @see #unsetBaseDepth2()
	 * @see #getBaseDepth2()
	 * @generated
	 */
	void setBaseDepth2(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth2 <em>Base Depth2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBaseDepth2()
	 * @see #getBaseDepth2()
	 * @see #setBaseDepth2(double)
	 * @generated
	 */
	void unsetBaseDepth2();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth2 <em>Base Depth2</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Base Depth2</em>' attribute is set.
	 * @see #unsetBaseDepth2()
	 * @see #getBaseDepth2()
	 * @see #setBaseDepth2(double)
	 * @generated
	 */
	boolean isSetBaseDepth2();

	/**
	 * Returns the value of the '<em><b>Base Depth2 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Depth2 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Depth2 As String</em>' attribute.
	 * @see #isSetBaseDepth2AsString()
	 * @see #unsetBaseDepth2AsString()
	 * @see #setBaseDepth2AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_BaseDepth2AsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBaseDepth2AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth2AsString <em>Base Depth2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Depth2 As String</em>' attribute.
	 * @see #isSetBaseDepth2AsString()
	 * @see #unsetBaseDepth2AsString()
	 * @see #getBaseDepth2AsString()
	 * @generated
	 */
	void setBaseDepth2AsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth2AsString <em>Base Depth2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBaseDepth2AsString()
	 * @see #getBaseDepth2AsString()
	 * @see #setBaseDepth2AsString(String)
	 * @generated
	 */
	void unsetBaseDepth2AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth2AsString <em>Base Depth2 As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Base Depth2 As String</em>' attribute is set.
	 * @see #unsetBaseDepth2AsString()
	 * @see #getBaseDepth2AsString()
	 * @see #setBaseDepth2AsString(String)
	 * @generated
	 */
	boolean isSetBaseDepth2AsString();

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
	 * @see #setCentreOfGravityInY(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_CentreOfGravityInY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCentreOfGravityInY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Centre Of Gravity In Y</em>' attribute.
	 * @see #isSetCentreOfGravityInY()
	 * @see #unsetCentreOfGravityInY()
	 * @see #getCentreOfGravityInY()
	 * @generated
	 */
	void setCentreOfGravityInY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCentreOfGravityInY()
	 * @see #getCentreOfGravityInY()
	 * @see #setCentreOfGravityInY(double)
	 * @generated
	 */
	void unsetCentreOfGravityInY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Centre Of Gravity In Y</em>' attribute is set.
	 * @see #unsetCentreOfGravityInY()
	 * @see #getCentreOfGravityInY()
	 * @see #setCentreOfGravityInY(double)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_CentreOfGravityInYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCentreOfGravityInYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCentreOfGravityInYAsString()
	 * @see #getCentreOfGravityInYAsString()
	 * @see #setCentreOfGravityInYAsString(String)
	 * @generated
	 */
	void unsetCentreOfGravityInYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Centre Of Gravity In YAs String</em>' attribute is set.
	 * @see #unsetCentreOfGravityInYAsString()
	 * @see #getCentreOfGravityInYAsString()
	 * @see #setCentreOfGravityInYAsString(String)
	 * @generated
	 */
	boolean isSetCentreOfGravityInYAsString();

} // IfcCraneRailFShapeProfileDef
