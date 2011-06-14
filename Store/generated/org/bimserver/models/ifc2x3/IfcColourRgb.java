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
 * A representation of the model object '<em><b>Ifc Colour Rgb</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcColourRgb#getRed <em>Red</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcColourRgb#getRedAsString <em>Red As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcColourRgb#getGreen <em>Green</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcColourRgb#getGreenAsString <em>Green As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcColourRgb#getBlue <em>Blue</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcColourRgb#getBlueAsString <em>Blue As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb()
 * @model
 * @generated
 */
public interface IfcColourRgb extends IfcColourSpecification, IfcColourOrFactor
{
	/**
	 * Returns the value of the '<em><b>Red</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Red</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Red</em>' attribute.
	 * @see #setRed(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_Red()
	 * @model
	 * @generated
	 */
	float getRed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getRed <em>Red</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Red</em>' attribute.
	 * @see #getRed()
	 * @generated
	 */
	void setRed(float value);

	/**
	 * Returns the value of the '<em><b>Red As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Red As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Red As String</em>' attribute.
	 * @see #setRedAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_RedAsString()
	 * @model
	 * @generated
	 */
	String getRedAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getRedAsString <em>Red As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Red As String</em>' attribute.
	 * @see #getRedAsString()
	 * @generated
	 */
	void setRedAsString(String value);

	/**
	 * Returns the value of the '<em><b>Green</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Green</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Green</em>' attribute.
	 * @see #setGreen(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_Green()
	 * @model
	 * @generated
	 */
	float getGreen();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getGreen <em>Green</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Green</em>' attribute.
	 * @see #getGreen()
	 * @generated
	 */
	void setGreen(float value);

	/**
	 * Returns the value of the '<em><b>Green As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Green As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Green As String</em>' attribute.
	 * @see #setGreenAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_GreenAsString()
	 * @model
	 * @generated
	 */
	String getGreenAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getGreenAsString <em>Green As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Green As String</em>' attribute.
	 * @see #getGreenAsString()
	 * @generated
	 */
	void setGreenAsString(String value);

	/**
	 * Returns the value of the '<em><b>Blue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blue</em>' attribute.
	 * @see #setBlue(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_Blue()
	 * @model
	 * @generated
	 */
	float getBlue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getBlue <em>Blue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blue</em>' attribute.
	 * @see #getBlue()
	 * @generated
	 */
	void setBlue(float value);

	/**
	 * Returns the value of the '<em><b>Blue As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blue As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blue As String</em>' attribute.
	 * @see #setBlueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_BlueAsString()
	 * @model
	 * @generated
	 */
	String getBlueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getBlueAsString <em>Blue As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blue As String</em>' attribute.
	 * @see #getBlueAsString()
	 * @generated
	 */
	void setBlueAsString(String value);

} // IfcColourRgb
