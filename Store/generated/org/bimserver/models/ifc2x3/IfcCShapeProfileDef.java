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
 * A representation of the model object '<em><b>Ifc CShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getWidth <em>Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getWidthAsString <em>Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getWallThickness <em>Wall Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getWallThicknessAsString <em>Wall Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getGirth <em>Girth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getGirthAsString <em>Girth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getInternalFilletRadius <em>Internal Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getInternalFilletRadiusAsString <em>Internal Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef()
 * @model
 * @generated
 */
public interface IfcCShapeProfileDef extends IfcParameterizedProfileDef
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_Depth()
	 * @model
	 * @generated
	 */
	float getDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getDepth <em>Depth</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_DepthAsString()
	 * @model
	 * @generated
	 */
	String getDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getDepthAsString <em>Depth As String</em>}' attribute.
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
	 * @see #setWidth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_Width()
	 * @model
	 * @generated
	 */
	float getWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(float value);

	/**
	 * Returns the value of the '<em><b>Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width As String</em>' attribute.
	 * @see #setWidthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_WidthAsString()
	 * @model
	 * @generated
	 */
	String getWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getWidthAsString <em>Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width As String</em>' attribute.
	 * @see #getWidthAsString()
	 * @generated
	 */
	void setWidthAsString(String value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_WallThickness()
	 * @model
	 * @generated
	 */
	float getWallThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getWallThickness <em>Wall Thickness</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_WallThicknessAsString()
	 * @model
	 * @generated
	 */
	String getWallThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getWallThicknessAsString <em>Wall Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wall Thickness As String</em>' attribute.
	 * @see #getWallThicknessAsString()
	 * @generated
	 */
	void setWallThicknessAsString(String value);

	/**
	 * Returns the value of the '<em><b>Girth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Girth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Girth</em>' attribute.
	 * @see #setGirth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_Girth()
	 * @model
	 * @generated
	 */
	float getGirth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getGirth <em>Girth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Girth</em>' attribute.
	 * @see #getGirth()
	 * @generated
	 */
	void setGirth(float value);

	/**
	 * Returns the value of the '<em><b>Girth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Girth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Girth As String</em>' attribute.
	 * @see #setGirthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_GirthAsString()
	 * @model
	 * @generated
	 */
	String getGirthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getGirthAsString <em>Girth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Girth As String</em>' attribute.
	 * @see #getGirthAsString()
	 * @generated
	 */
	void setGirthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Internal Fillet Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Fillet Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Fillet Radius</em>' attribute.
	 * @see #isSetInternalFilletRadius()
	 * @see #unsetInternalFilletRadius()
	 * @see #setInternalFilletRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_InternalFilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	float getInternalFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getInternalFilletRadius <em>Internal Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Fillet Radius</em>' attribute.
	 * @see #isSetInternalFilletRadius()
	 * @see #unsetInternalFilletRadius()
	 * @see #getInternalFilletRadius()
	 * @generated
	 */
	void setInternalFilletRadius(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getInternalFilletRadius <em>Internal Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInternalFilletRadius()
	 * @see #getInternalFilletRadius()
	 * @see #setInternalFilletRadius(float)
	 * @generated
	 */
	void unsetInternalFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getInternalFilletRadius <em>Internal Fillet Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Internal Fillet Radius</em>' attribute is set.
	 * @see #unsetInternalFilletRadius()
	 * @see #getInternalFilletRadius()
	 * @see #setInternalFilletRadius(float)
	 * @generated
	 */
	boolean isSetInternalFilletRadius();

	/**
	 * Returns the value of the '<em><b>Internal Fillet Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Fillet Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Fillet Radius As String</em>' attribute.
	 * @see #isSetInternalFilletRadiusAsString()
	 * @see #unsetInternalFilletRadiusAsString()
	 * @see #setInternalFilletRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_InternalFilletRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getInternalFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getInternalFilletRadiusAsString <em>Internal Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Fillet Radius As String</em>' attribute.
	 * @see #isSetInternalFilletRadiusAsString()
	 * @see #unsetInternalFilletRadiusAsString()
	 * @see #getInternalFilletRadiusAsString()
	 * @generated
	 */
	void setInternalFilletRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getInternalFilletRadiusAsString <em>Internal Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInternalFilletRadiusAsString()
	 * @see #getInternalFilletRadiusAsString()
	 * @see #setInternalFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetInternalFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getInternalFilletRadiusAsString <em>Internal Fillet Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Internal Fillet Radius As String</em>' attribute is set.
	 * @see #unsetInternalFilletRadiusAsString()
	 * @see #getInternalFilletRadiusAsString()
	 * @see #setInternalFilletRadiusAsString(String)
	 * @generated
	 */
	boolean isSetInternalFilletRadiusAsString();

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
	 * @see #setCentreOfGravityInX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_CentreOfGravityInX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getCentreOfGravityInX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Centre Of Gravity In X</em>' attribute.
	 * @see #isSetCentreOfGravityInX()
	 * @see #unsetCentreOfGravityInX()
	 * @see #getCentreOfGravityInX()
	 * @generated
	 */
	void setCentreOfGravityInX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCentreOfGravityInX()
	 * @see #getCentreOfGravityInX()
	 * @see #setCentreOfGravityInX(float)
	 * @generated
	 */
	void unsetCentreOfGravityInX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Centre Of Gravity In X</em>' attribute is set.
	 * @see #unsetCentreOfGravityInX()
	 * @see #getCentreOfGravityInX()
	 * @see #setCentreOfGravityInX(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCShapeProfileDef_CentreOfGravityInXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCentreOfGravityInXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCentreOfGravityInXAsString()
	 * @see #getCentreOfGravityInXAsString()
	 * @see #setCentreOfGravityInXAsString(String)
	 * @generated
	 */
	void unsetCentreOfGravityInXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCShapeProfileDef#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Centre Of Gravity In XAs String</em>' attribute is set.
	 * @see #unsetCentreOfGravityInXAsString()
	 * @see #getCentreOfGravityInXAsString()
	 * @see #setCentreOfGravityInXAsString(String)
	 * @generated
	 */
	boolean isSetCentreOfGravityInXAsString();

} // IfcCShapeProfileDef
