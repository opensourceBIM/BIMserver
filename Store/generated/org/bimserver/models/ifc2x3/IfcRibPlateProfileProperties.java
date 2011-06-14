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
 * A representation of the model object '<em><b>Ifc Rib Plate Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getThickness <em>Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getThicknessAsString <em>Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibHeight <em>Rib Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibHeightAsString <em>Rib Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibWidth <em>Rib Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibWidthAsString <em>Rib Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibSpacing <em>Rib Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibSpacingAsString <em>Rib Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRibPlateProfileProperties()
 * @model
 * @generated
 */
public interface IfcRibPlateProfileProperties extends IfcProfileProperties
{
	/**
	 * Returns the value of the '<em><b>Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thickness</em>' attribute.
	 * @see #isSetThickness()
	 * @see #unsetThickness()
	 * @see #setThickness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRibPlateProfileProperties_Thickness()
	 * @model unsettable="true"
	 * @generated
	 */
	float getThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getThickness <em>Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thickness</em>' attribute.
	 * @see #isSetThickness()
	 * @see #unsetThickness()
	 * @see #getThickness()
	 * @generated
	 */
	void setThickness(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getThickness <em>Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThickness()
	 * @see #getThickness()
	 * @see #setThickness(float)
	 * @generated
	 */
	void unsetThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getThickness <em>Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thickness</em>' attribute is set.
	 * @see #unsetThickness()
	 * @see #getThickness()
	 * @see #setThickness(float)
	 * @generated
	 */
	boolean isSetThickness();

	/**
	 * Returns the value of the '<em><b>Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thickness As String</em>' attribute.
	 * @see #isSetThicknessAsString()
	 * @see #unsetThicknessAsString()
	 * @see #setThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRibPlateProfileProperties_ThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getThicknessAsString <em>Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thickness As String</em>' attribute.
	 * @see #isSetThicknessAsString()
	 * @see #unsetThicknessAsString()
	 * @see #getThicknessAsString()
	 * @generated
	 */
	void setThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getThicknessAsString <em>Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThicknessAsString()
	 * @see #getThicknessAsString()
	 * @see #setThicknessAsString(String)
	 * @generated
	 */
	void unsetThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getThicknessAsString <em>Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thickness As String</em>' attribute is set.
	 * @see #unsetThicknessAsString()
	 * @see #getThicknessAsString()
	 * @see #setThicknessAsString(String)
	 * @generated
	 */
	boolean isSetThicknessAsString();

	/**
	 * Returns the value of the '<em><b>Rib Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rib Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rib Height</em>' attribute.
	 * @see #isSetRibHeight()
	 * @see #unsetRibHeight()
	 * @see #setRibHeight(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRibPlateProfileProperties_RibHeight()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRibHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibHeight <em>Rib Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rib Height</em>' attribute.
	 * @see #isSetRibHeight()
	 * @see #unsetRibHeight()
	 * @see #getRibHeight()
	 * @generated
	 */
	void setRibHeight(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibHeight <em>Rib Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRibHeight()
	 * @see #getRibHeight()
	 * @see #setRibHeight(float)
	 * @generated
	 */
	void unsetRibHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibHeight <em>Rib Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rib Height</em>' attribute is set.
	 * @see #unsetRibHeight()
	 * @see #getRibHeight()
	 * @see #setRibHeight(float)
	 * @generated
	 */
	boolean isSetRibHeight();

	/**
	 * Returns the value of the '<em><b>Rib Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rib Height As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rib Height As String</em>' attribute.
	 * @see #isSetRibHeightAsString()
	 * @see #unsetRibHeightAsString()
	 * @see #setRibHeightAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRibPlateProfileProperties_RibHeightAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRibHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibHeightAsString <em>Rib Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rib Height As String</em>' attribute.
	 * @see #isSetRibHeightAsString()
	 * @see #unsetRibHeightAsString()
	 * @see #getRibHeightAsString()
	 * @generated
	 */
	void setRibHeightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibHeightAsString <em>Rib Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRibHeightAsString()
	 * @see #getRibHeightAsString()
	 * @see #setRibHeightAsString(String)
	 * @generated
	 */
	void unsetRibHeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibHeightAsString <em>Rib Height As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rib Height As String</em>' attribute is set.
	 * @see #unsetRibHeightAsString()
	 * @see #getRibHeightAsString()
	 * @see #setRibHeightAsString(String)
	 * @generated
	 */
	boolean isSetRibHeightAsString();

	/**
	 * Returns the value of the '<em><b>Rib Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rib Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rib Width</em>' attribute.
	 * @see #isSetRibWidth()
	 * @see #unsetRibWidth()
	 * @see #setRibWidth(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRibPlateProfileProperties_RibWidth()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRibWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibWidth <em>Rib Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rib Width</em>' attribute.
	 * @see #isSetRibWidth()
	 * @see #unsetRibWidth()
	 * @see #getRibWidth()
	 * @generated
	 */
	void setRibWidth(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibWidth <em>Rib Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRibWidth()
	 * @see #getRibWidth()
	 * @see #setRibWidth(float)
	 * @generated
	 */
	void unsetRibWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibWidth <em>Rib Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rib Width</em>' attribute is set.
	 * @see #unsetRibWidth()
	 * @see #getRibWidth()
	 * @see #setRibWidth(float)
	 * @generated
	 */
	boolean isSetRibWidth();

	/**
	 * Returns the value of the '<em><b>Rib Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rib Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rib Width As String</em>' attribute.
	 * @see #isSetRibWidthAsString()
	 * @see #unsetRibWidthAsString()
	 * @see #setRibWidthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRibPlateProfileProperties_RibWidthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRibWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibWidthAsString <em>Rib Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rib Width As String</em>' attribute.
	 * @see #isSetRibWidthAsString()
	 * @see #unsetRibWidthAsString()
	 * @see #getRibWidthAsString()
	 * @generated
	 */
	void setRibWidthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibWidthAsString <em>Rib Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRibWidthAsString()
	 * @see #getRibWidthAsString()
	 * @see #setRibWidthAsString(String)
	 * @generated
	 */
	void unsetRibWidthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibWidthAsString <em>Rib Width As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rib Width As String</em>' attribute is set.
	 * @see #unsetRibWidthAsString()
	 * @see #getRibWidthAsString()
	 * @see #setRibWidthAsString(String)
	 * @generated
	 */
	boolean isSetRibWidthAsString();

	/**
	 * Returns the value of the '<em><b>Rib Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rib Spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rib Spacing</em>' attribute.
	 * @see #isSetRibSpacing()
	 * @see #unsetRibSpacing()
	 * @see #setRibSpacing(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRibPlateProfileProperties_RibSpacing()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRibSpacing();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibSpacing <em>Rib Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rib Spacing</em>' attribute.
	 * @see #isSetRibSpacing()
	 * @see #unsetRibSpacing()
	 * @see #getRibSpacing()
	 * @generated
	 */
	void setRibSpacing(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibSpacing <em>Rib Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRibSpacing()
	 * @see #getRibSpacing()
	 * @see #setRibSpacing(float)
	 * @generated
	 */
	void unsetRibSpacing();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibSpacing <em>Rib Spacing</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rib Spacing</em>' attribute is set.
	 * @see #unsetRibSpacing()
	 * @see #getRibSpacing()
	 * @see #setRibSpacing(float)
	 * @generated
	 */
	boolean isSetRibSpacing();

	/**
	 * Returns the value of the '<em><b>Rib Spacing As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rib Spacing As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rib Spacing As String</em>' attribute.
	 * @see #isSetRibSpacingAsString()
	 * @see #unsetRibSpacingAsString()
	 * @see #setRibSpacingAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRibPlateProfileProperties_RibSpacingAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRibSpacingAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibSpacingAsString <em>Rib Spacing As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rib Spacing As String</em>' attribute.
	 * @see #isSetRibSpacingAsString()
	 * @see #unsetRibSpacingAsString()
	 * @see #getRibSpacingAsString()
	 * @generated
	 */
	void setRibSpacingAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibSpacingAsString <em>Rib Spacing As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRibSpacingAsString()
	 * @see #getRibSpacingAsString()
	 * @see #setRibSpacingAsString(String)
	 * @generated
	 */
	void unsetRibSpacingAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getRibSpacingAsString <em>Rib Spacing As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rib Spacing As String</em>' attribute is set.
	 * @see #unsetRibSpacingAsString()
	 * @see #getRibSpacingAsString()
	 * @see #setRibSpacingAsString(String)
	 * @generated
	 */
	boolean isSetRibSpacingAsString();

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcRibPlateDirectionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcRibPlateDirectionEnum
	 * @see #setDirection(IfcRibPlateDirectionEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRibPlateProfileProperties_Direction()
	 * @model
	 * @generated
	 */
	IfcRibPlateDirectionEnum getDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcRibPlateDirectionEnum
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(IfcRibPlateDirectionEnum value);

} // IfcRibPlateProfileProperties
