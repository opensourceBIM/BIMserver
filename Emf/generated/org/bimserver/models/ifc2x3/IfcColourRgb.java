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
public interface IfcColourRgb extends IfcColourSpecification, IfcColourOrFactor {
	/**
	 * Returns the value of the '<em><b>Red</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Red</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Red</em>' attribute.
	 * @see #isSetRed()
	 * @see #unsetRed()
	 * @see #setRed(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_Red()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getRed <em>Red</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Red</em>' attribute.
	 * @see #isSetRed()
	 * @see #unsetRed()
	 * @see #getRed()
	 * @generated
	 */
	void setRed(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getRed <em>Red</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRed()
	 * @see #getRed()
	 * @see #setRed(double)
	 * @generated
	 */
	void unsetRed();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getRed <em>Red</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Red</em>' attribute is set.
	 * @see #unsetRed()
	 * @see #getRed()
	 * @see #setRed(double)
	 * @generated
	 */
	boolean isSetRed();

	/**
	 * Returns the value of the '<em><b>Red As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Red As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Red As String</em>' attribute.
	 * @see #isSetRedAsString()
	 * @see #unsetRedAsString()
	 * @see #setRedAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_RedAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRedAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getRedAsString <em>Red As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Red As String</em>' attribute.
	 * @see #isSetRedAsString()
	 * @see #unsetRedAsString()
	 * @see #getRedAsString()
	 * @generated
	 */
	void setRedAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getRedAsString <em>Red As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRedAsString()
	 * @see #getRedAsString()
	 * @see #setRedAsString(String)
	 * @generated
	 */
	void unsetRedAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getRedAsString <em>Red As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Red As String</em>' attribute is set.
	 * @see #unsetRedAsString()
	 * @see #getRedAsString()
	 * @see #setRedAsString(String)
	 * @generated
	 */
	boolean isSetRedAsString();

	/**
	 * Returns the value of the '<em><b>Green</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Green</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Green</em>' attribute.
	 * @see #isSetGreen()
	 * @see #unsetGreen()
	 * @see #setGreen(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_Green()
	 * @model unsettable="true"
	 * @generated
	 */
	double getGreen();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getGreen <em>Green</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Green</em>' attribute.
	 * @see #isSetGreen()
	 * @see #unsetGreen()
	 * @see #getGreen()
	 * @generated
	 */
	void setGreen(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getGreen <em>Green</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetGreen()
	 * @see #getGreen()
	 * @see #setGreen(double)
	 * @generated
	 */
	void unsetGreen();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getGreen <em>Green</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Green</em>' attribute is set.
	 * @see #unsetGreen()
	 * @see #getGreen()
	 * @see #setGreen(double)
	 * @generated
	 */
	boolean isSetGreen();

	/**
	 * Returns the value of the '<em><b>Green As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Green As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Green As String</em>' attribute.
	 * @see #isSetGreenAsString()
	 * @see #unsetGreenAsString()
	 * @see #setGreenAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_GreenAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getGreenAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getGreenAsString <em>Green As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Green As String</em>' attribute.
	 * @see #isSetGreenAsString()
	 * @see #unsetGreenAsString()
	 * @see #getGreenAsString()
	 * @generated
	 */
	void setGreenAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getGreenAsString <em>Green As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetGreenAsString()
	 * @see #getGreenAsString()
	 * @see #setGreenAsString(String)
	 * @generated
	 */
	void unsetGreenAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getGreenAsString <em>Green As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Green As String</em>' attribute is set.
	 * @see #unsetGreenAsString()
	 * @see #getGreenAsString()
	 * @see #setGreenAsString(String)
	 * @generated
	 */
	boolean isSetGreenAsString();

	/**
	 * Returns the value of the '<em><b>Blue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blue</em>' attribute.
	 * @see #isSetBlue()
	 * @see #unsetBlue()
	 * @see #setBlue(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_Blue()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBlue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getBlue <em>Blue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blue</em>' attribute.
	 * @see #isSetBlue()
	 * @see #unsetBlue()
	 * @see #getBlue()
	 * @generated
	 */
	void setBlue(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getBlue <em>Blue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBlue()
	 * @see #getBlue()
	 * @see #setBlue(double)
	 * @generated
	 */
	void unsetBlue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getBlue <em>Blue</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Blue</em>' attribute is set.
	 * @see #unsetBlue()
	 * @see #getBlue()
	 * @see #setBlue(double)
	 * @generated
	 */
	boolean isSetBlue();

	/**
	 * Returns the value of the '<em><b>Blue As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blue As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blue As String</em>' attribute.
	 * @see #isSetBlueAsString()
	 * @see #unsetBlueAsString()
	 * @see #setBlueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcColourRgb_BlueAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBlueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getBlueAsString <em>Blue As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blue As String</em>' attribute.
	 * @see #isSetBlueAsString()
	 * @see #unsetBlueAsString()
	 * @see #getBlueAsString()
	 * @generated
	 */
	void setBlueAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getBlueAsString <em>Blue As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBlueAsString()
	 * @see #getBlueAsString()
	 * @see #setBlueAsString(String)
	 * @generated
	 */
	void unsetBlueAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcColourRgb#getBlueAsString <em>Blue As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Blue As String</em>' attribute is set.
	 * @see #unsetBlueAsString()
	 * @see #getBlueAsString()
	 * @see #setBlueAsString(String)
	 * @generated
	 */
	boolean isSetBlueAsString();

} // IfcColourRgb
