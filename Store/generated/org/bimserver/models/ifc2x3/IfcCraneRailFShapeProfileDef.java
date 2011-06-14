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
public interface IfcCraneRailFShapeProfileDef extends IfcParameterizedProfileDef
{
	/**
	 * Returns the value of the '<em><b>Overall Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Height</em>' attribute.
	 * @see #setOverallHeight(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_OverallHeight()
	 * @model
	 * @generated
	 */
	float getOverallHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getOverallHeight <em>Overall Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Height</em>' attribute.
	 * @see #getOverallHeight()
	 * @generated
	 */
	void setOverallHeight(float value);

	/**
	 * Returns the value of the '<em><b>Overall Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Height As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Height As String</em>' attribute.
	 * @see #setOverallHeightAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_OverallHeightAsString()
	 * @model
	 * @generated
	 */
	String getOverallHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getOverallHeightAsString <em>Overall Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Height As String</em>' attribute.
	 * @see #getOverallHeightAsString()
	 * @generated
	 */
	void setOverallHeightAsString(String value);

	/**
	 * Returns the value of the '<em><b>Head Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Width</em>' attribute.
	 * @see #setHeadWidth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadWidth()
	 * @model
	 * @generated
	 */
	float getHeadWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadWidth <em>Head Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Width</em>' attribute.
	 * @see #getHeadWidth()
	 * @generated
	 */
	void setHeadWidth(float value);

	/**
	 * Returns the value of the '<em><b>Head Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Width As String</em>' attribute.
	 * @see #setHeadWidthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadWidthAsString()
	 * @model
	 * @generated
	 */
	String getHeadWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadWidthAsString <em>Head Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Width As String</em>' attribute.
	 * @see #getHeadWidthAsString()
	 * @generated
	 */
	void setHeadWidthAsString(String value);

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
	 * @see #setRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_Radius()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRadius();

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
	void setRadius(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRadius()
	 * @see #getRadius()
	 * @see #setRadius(float)
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
	 * @see #setRadius(float)
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
	 * @see #setHeadDepth2(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadDepth2()
	 * @model
	 * @generated
	 */
	float getHeadDepth2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth2 <em>Head Depth2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Depth2</em>' attribute.
	 * @see #getHeadDepth2()
	 * @generated
	 */
	void setHeadDepth2(float value);

	/**
	 * Returns the value of the '<em><b>Head Depth2 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Depth2 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Depth2 As String</em>' attribute.
	 * @see #setHeadDepth2AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadDepth2AsString()
	 * @model
	 * @generated
	 */
	String getHeadDepth2AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth2AsString <em>Head Depth2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Depth2 As String</em>' attribute.
	 * @see #getHeadDepth2AsString()
	 * @generated
	 */
	void setHeadDepth2AsString(String value);

	/**
	 * Returns the value of the '<em><b>Head Depth3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Depth3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Depth3</em>' attribute.
	 * @see #setHeadDepth3(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadDepth3()
	 * @model
	 * @generated
	 */
	float getHeadDepth3();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth3 <em>Head Depth3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Depth3</em>' attribute.
	 * @see #getHeadDepth3()
	 * @generated
	 */
	void setHeadDepth3(float value);

	/**
	 * Returns the value of the '<em><b>Head Depth3 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Depth3 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Depth3 As String</em>' attribute.
	 * @see #setHeadDepth3AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_HeadDepth3AsString()
	 * @model
	 * @generated
	 */
	String getHeadDepth3AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getHeadDepth3AsString <em>Head Depth3 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Depth3 As String</em>' attribute.
	 * @see #getHeadDepth3AsString()
	 * @generated
	 */
	void setHeadDepth3AsString(String value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_WebThickness()
	 * @model
	 * @generated
	 */
	float getWebThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getWebThickness <em>Web Thickness</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_WebThicknessAsString()
	 * @model
	 * @generated
	 */
	String getWebThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getWebThicknessAsString <em>Web Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Thickness As String</em>' attribute.
	 * @see #getWebThicknessAsString()
	 * @generated
	 */
	void setWebThicknessAsString(String value);

	/**
	 * Returns the value of the '<em><b>Base Depth1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Depth1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Depth1</em>' attribute.
	 * @see #setBaseDepth1(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_BaseDepth1()
	 * @model
	 * @generated
	 */
	float getBaseDepth1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth1 <em>Base Depth1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Depth1</em>' attribute.
	 * @see #getBaseDepth1()
	 * @generated
	 */
	void setBaseDepth1(float value);

	/**
	 * Returns the value of the '<em><b>Base Depth1 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Depth1 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Depth1 As String</em>' attribute.
	 * @see #setBaseDepth1AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_BaseDepth1AsString()
	 * @model
	 * @generated
	 */
	String getBaseDepth1AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth1AsString <em>Base Depth1 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Depth1 As String</em>' attribute.
	 * @see #getBaseDepth1AsString()
	 * @generated
	 */
	void setBaseDepth1AsString(String value);

	/**
	 * Returns the value of the '<em><b>Base Depth2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Depth2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Depth2</em>' attribute.
	 * @see #setBaseDepth2(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_BaseDepth2()
	 * @model
	 * @generated
	 */
	float getBaseDepth2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth2 <em>Base Depth2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Depth2</em>' attribute.
	 * @see #getBaseDepth2()
	 * @generated
	 */
	void setBaseDepth2(float value);

	/**
	 * Returns the value of the '<em><b>Base Depth2 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Depth2 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Depth2 As String</em>' attribute.
	 * @see #setBaseDepth2AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_BaseDepth2AsString()
	 * @model
	 * @generated
	 */
	String getBaseDepth2AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getBaseDepth2AsString <em>Base Depth2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Depth2 As String</em>' attribute.
	 * @see #getBaseDepth2AsString()
	 * @generated
	 */
	void setBaseDepth2AsString(String value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCraneRailFShapeProfileDef_CentreOfGravityInY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getCentreOfGravityInY();

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
	void setCentreOfGravityInY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCentreOfGravityInY()
	 * @see #getCentreOfGravityInY()
	 * @see #setCentreOfGravityInY(float)
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
