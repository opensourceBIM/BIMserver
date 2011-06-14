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
 * A representation of the model object '<em><b>Ifc Rectangle Hollow Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getWallThickness <em>Wall Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getWallThicknessAsString <em>Wall Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getInnerFilletRadius <em>Inner Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getInnerFilletRadiusAsString <em>Inner Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getOuterFilletRadius <em>Outer Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getOuterFilletRadiusAsString <em>Outer Fillet Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangleHollowProfileDef()
 * @model
 * @generated
 */
public interface IfcRectangleHollowProfileDef extends IfcRectangleProfileDef
{
	/**
	 * Returns the value of the '<em><b>Wall Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wall Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wall Thickness</em>' attribute.
	 * @see #setWallThickness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangleHollowProfileDef_WallThickness()
	 * @model
	 * @generated
	 */
	float getWallThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getWallThickness <em>Wall Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wall Thickness</em>' attribute.
	 * @see #getWallThickness()
	 * @generated
	 */
	void setWallThickness(float value);

	/**
	 * Returns the value of the '<em><b>Wall Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wall Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wall Thickness As String</em>' attribute.
	 * @see #setWallThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangleHollowProfileDef_WallThicknessAsString()
	 * @model
	 * @generated
	 */
	String getWallThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getWallThicknessAsString <em>Wall Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wall Thickness As String</em>' attribute.
	 * @see #getWallThicknessAsString()
	 * @generated
	 */
	void setWallThicknessAsString(String value);

	/**
	 * Returns the value of the '<em><b>Inner Fillet Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Fillet Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Fillet Radius</em>' attribute.
	 * @see #isSetInnerFilletRadius()
	 * @see #unsetInnerFilletRadius()
	 * @see #setInnerFilletRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangleHollowProfileDef_InnerFilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	float getInnerFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getInnerFilletRadius <em>Inner Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Fillet Radius</em>' attribute.
	 * @see #isSetInnerFilletRadius()
	 * @see #unsetInnerFilletRadius()
	 * @see #getInnerFilletRadius()
	 * @generated
	 */
	void setInnerFilletRadius(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getInnerFilletRadius <em>Inner Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInnerFilletRadius()
	 * @see #getInnerFilletRadius()
	 * @see #setInnerFilletRadius(float)
	 * @generated
	 */
	void unsetInnerFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getInnerFilletRadius <em>Inner Fillet Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inner Fillet Radius</em>' attribute is set.
	 * @see #unsetInnerFilletRadius()
	 * @see #getInnerFilletRadius()
	 * @see #setInnerFilletRadius(float)
	 * @generated
	 */
	boolean isSetInnerFilletRadius();

	/**
	 * Returns the value of the '<em><b>Inner Fillet Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Fillet Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Fillet Radius As String</em>' attribute.
	 * @see #isSetInnerFilletRadiusAsString()
	 * @see #unsetInnerFilletRadiusAsString()
	 * @see #setInnerFilletRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangleHollowProfileDef_InnerFilletRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getInnerFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getInnerFilletRadiusAsString <em>Inner Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Fillet Radius As String</em>' attribute.
	 * @see #isSetInnerFilletRadiusAsString()
	 * @see #unsetInnerFilletRadiusAsString()
	 * @see #getInnerFilletRadiusAsString()
	 * @generated
	 */
	void setInnerFilletRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getInnerFilletRadiusAsString <em>Inner Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInnerFilletRadiusAsString()
	 * @see #getInnerFilletRadiusAsString()
	 * @see #setInnerFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetInnerFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getInnerFilletRadiusAsString <em>Inner Fillet Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inner Fillet Radius As String</em>' attribute is set.
	 * @see #unsetInnerFilletRadiusAsString()
	 * @see #getInnerFilletRadiusAsString()
	 * @see #setInnerFilletRadiusAsString(String)
	 * @generated
	 */
	boolean isSetInnerFilletRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Outer Fillet Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Fillet Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Fillet Radius</em>' attribute.
	 * @see #isSetOuterFilletRadius()
	 * @see #unsetOuterFilletRadius()
	 * @see #setOuterFilletRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangleHollowProfileDef_OuterFilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	float getOuterFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getOuterFilletRadius <em>Outer Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Fillet Radius</em>' attribute.
	 * @see #isSetOuterFilletRadius()
	 * @see #unsetOuterFilletRadius()
	 * @see #getOuterFilletRadius()
	 * @generated
	 */
	void setOuterFilletRadius(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getOuterFilletRadius <em>Outer Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOuterFilletRadius()
	 * @see #getOuterFilletRadius()
	 * @see #setOuterFilletRadius(float)
	 * @generated
	 */
	void unsetOuterFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getOuterFilletRadius <em>Outer Fillet Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Outer Fillet Radius</em>' attribute is set.
	 * @see #unsetOuterFilletRadius()
	 * @see #getOuterFilletRadius()
	 * @see #setOuterFilletRadius(float)
	 * @generated
	 */
	boolean isSetOuterFilletRadius();

	/**
	 * Returns the value of the '<em><b>Outer Fillet Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Fillet Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Fillet Radius As String</em>' attribute.
	 * @see #isSetOuterFilletRadiusAsString()
	 * @see #unsetOuterFilletRadiusAsString()
	 * @see #setOuterFilletRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangleHollowProfileDef_OuterFilletRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getOuterFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getOuterFilletRadiusAsString <em>Outer Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Fillet Radius As String</em>' attribute.
	 * @see #isSetOuterFilletRadiusAsString()
	 * @see #unsetOuterFilletRadiusAsString()
	 * @see #getOuterFilletRadiusAsString()
	 * @generated
	 */
	void setOuterFilletRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getOuterFilletRadiusAsString <em>Outer Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOuterFilletRadiusAsString()
	 * @see #getOuterFilletRadiusAsString()
	 * @see #setOuterFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetOuterFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef#getOuterFilletRadiusAsString <em>Outer Fillet Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Outer Fillet Radius As String</em>' attribute is set.
	 * @see #unsetOuterFilletRadiusAsString()
	 * @see #getOuterFilletRadiusAsString()
	 * @see #setOuterFilletRadiusAsString(String)
	 * @generated
	 */
	boolean isSetOuterFilletRadiusAsString();

} // IfcRectangleHollowProfileDef
