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
 * A representation of the model object '<em><b>Ifc Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBlock#getXLength <em>XLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBlock#getXLengthAsString <em>XLength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBlock#getYLength <em>YLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBlock#getYLengthAsString <em>YLength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBlock#getZLength <em>ZLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBlock#getZLengthAsString <em>ZLength As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock()
 * @model
 * @generated
 */
public interface IfcBlock extends IfcCsgPrimitive3D
{
	/**
	 * Returns the value of the '<em><b>XLength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XLength</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XLength</em>' attribute.
	 * @see #setXLength(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_XLength()
	 * @model
	 * @generated
	 */
	float getXLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getXLength <em>XLength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XLength</em>' attribute.
	 * @see #getXLength()
	 * @generated
	 */
	void setXLength(float value);

	/**
	 * Returns the value of the '<em><b>XLength As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XLength As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XLength As String</em>' attribute.
	 * @see #setXLengthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_XLengthAsString()
	 * @model
	 * @generated
	 */
	String getXLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getXLengthAsString <em>XLength As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XLength As String</em>' attribute.
	 * @see #getXLengthAsString()
	 * @generated
	 */
	void setXLengthAsString(String value);

	/**
	 * Returns the value of the '<em><b>YLength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YLength</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YLength</em>' attribute.
	 * @see #setYLength(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_YLength()
	 * @model
	 * @generated
	 */
	float getYLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getYLength <em>YLength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YLength</em>' attribute.
	 * @see #getYLength()
	 * @generated
	 */
	void setYLength(float value);

	/**
	 * Returns the value of the '<em><b>YLength As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YLength As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YLength As String</em>' attribute.
	 * @see #setYLengthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_YLengthAsString()
	 * @model
	 * @generated
	 */
	String getYLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getYLengthAsString <em>YLength As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YLength As String</em>' attribute.
	 * @see #getYLengthAsString()
	 * @generated
	 */
	void setYLengthAsString(String value);

	/**
	 * Returns the value of the '<em><b>ZLength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ZLength</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZLength</em>' attribute.
	 * @see #setZLength(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_ZLength()
	 * @model
	 * @generated
	 */
	float getZLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getZLength <em>ZLength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZLength</em>' attribute.
	 * @see #getZLength()
	 * @generated
	 */
	void setZLength(float value);

	/**
	 * Returns the value of the '<em><b>ZLength As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ZLength As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZLength As String</em>' attribute.
	 * @see #setZLengthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_ZLengthAsString()
	 * @model
	 * @generated
	 */
	String getZLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getZLengthAsString <em>ZLength As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZLength As String</em>' attribute.
	 * @see #getZLengthAsString()
	 * @generated
	 */
	void setZLengthAsString(String value);

} // IfcBlock
