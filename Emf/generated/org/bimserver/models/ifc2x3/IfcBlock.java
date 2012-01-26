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
public interface IfcBlock extends IfcCsgPrimitive3D {
	/**
	 * Returns the value of the '<em><b>XLength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XLength</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XLength</em>' attribute.
	 * @see #isSetXLength()
	 * @see #unsetXLength()
	 * @see #setXLength(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_XLength()
	 * @model unsettable="true"
	 * @generated
	 */
	double getXLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getXLength <em>XLength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XLength</em>' attribute.
	 * @see #isSetXLength()
	 * @see #unsetXLength()
	 * @see #getXLength()
	 * @generated
	 */
	void setXLength(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getXLength <em>XLength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetXLength()
	 * @see #getXLength()
	 * @see #setXLength(double)
	 * @generated
	 */
	void unsetXLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getXLength <em>XLength</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>XLength</em>' attribute is set.
	 * @see #unsetXLength()
	 * @see #getXLength()
	 * @see #setXLength(double)
	 * @generated
	 */
	boolean isSetXLength();

	/**
	 * Returns the value of the '<em><b>XLength As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XLength As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XLength As String</em>' attribute.
	 * @see #isSetXLengthAsString()
	 * @see #unsetXLengthAsString()
	 * @see #setXLengthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_XLengthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getXLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getXLengthAsString <em>XLength As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XLength As String</em>' attribute.
	 * @see #isSetXLengthAsString()
	 * @see #unsetXLengthAsString()
	 * @see #getXLengthAsString()
	 * @generated
	 */
	void setXLengthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getXLengthAsString <em>XLength As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetXLengthAsString()
	 * @see #getXLengthAsString()
	 * @see #setXLengthAsString(String)
	 * @generated
	 */
	void unsetXLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getXLengthAsString <em>XLength As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>XLength As String</em>' attribute is set.
	 * @see #unsetXLengthAsString()
	 * @see #getXLengthAsString()
	 * @see #setXLengthAsString(String)
	 * @generated
	 */
	boolean isSetXLengthAsString();

	/**
	 * Returns the value of the '<em><b>YLength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YLength</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YLength</em>' attribute.
	 * @see #isSetYLength()
	 * @see #unsetYLength()
	 * @see #setYLength(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_YLength()
	 * @model unsettable="true"
	 * @generated
	 */
	double getYLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getYLength <em>YLength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YLength</em>' attribute.
	 * @see #isSetYLength()
	 * @see #unsetYLength()
	 * @see #getYLength()
	 * @generated
	 */
	void setYLength(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getYLength <em>YLength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetYLength()
	 * @see #getYLength()
	 * @see #setYLength(double)
	 * @generated
	 */
	void unsetYLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getYLength <em>YLength</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>YLength</em>' attribute is set.
	 * @see #unsetYLength()
	 * @see #getYLength()
	 * @see #setYLength(double)
	 * @generated
	 */
	boolean isSetYLength();

	/**
	 * Returns the value of the '<em><b>YLength As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YLength As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YLength As String</em>' attribute.
	 * @see #isSetYLengthAsString()
	 * @see #unsetYLengthAsString()
	 * @see #setYLengthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_YLengthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getYLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getYLengthAsString <em>YLength As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YLength As String</em>' attribute.
	 * @see #isSetYLengthAsString()
	 * @see #unsetYLengthAsString()
	 * @see #getYLengthAsString()
	 * @generated
	 */
	void setYLengthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getYLengthAsString <em>YLength As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetYLengthAsString()
	 * @see #getYLengthAsString()
	 * @see #setYLengthAsString(String)
	 * @generated
	 */
	void unsetYLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getYLengthAsString <em>YLength As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>YLength As String</em>' attribute is set.
	 * @see #unsetYLengthAsString()
	 * @see #getYLengthAsString()
	 * @see #setYLengthAsString(String)
	 * @generated
	 */
	boolean isSetYLengthAsString();

	/**
	 * Returns the value of the '<em><b>ZLength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ZLength</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZLength</em>' attribute.
	 * @see #isSetZLength()
	 * @see #unsetZLength()
	 * @see #setZLength(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_ZLength()
	 * @model unsettable="true"
	 * @generated
	 */
	double getZLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getZLength <em>ZLength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZLength</em>' attribute.
	 * @see #isSetZLength()
	 * @see #unsetZLength()
	 * @see #getZLength()
	 * @generated
	 */
	void setZLength(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getZLength <em>ZLength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetZLength()
	 * @see #getZLength()
	 * @see #setZLength(double)
	 * @generated
	 */
	void unsetZLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getZLength <em>ZLength</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>ZLength</em>' attribute is set.
	 * @see #unsetZLength()
	 * @see #getZLength()
	 * @see #setZLength(double)
	 * @generated
	 */
	boolean isSetZLength();

	/**
	 * Returns the value of the '<em><b>ZLength As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ZLength As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZLength As String</em>' attribute.
	 * @see #isSetZLengthAsString()
	 * @see #unsetZLengthAsString()
	 * @see #setZLengthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlock_ZLengthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getZLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getZLengthAsString <em>ZLength As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZLength As String</em>' attribute.
	 * @see #isSetZLengthAsString()
	 * @see #unsetZLengthAsString()
	 * @see #getZLengthAsString()
	 * @generated
	 */
	void setZLengthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getZLengthAsString <em>ZLength As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetZLengthAsString()
	 * @see #getZLengthAsString()
	 * @see #setZLengthAsString(String)
	 * @generated
	 */
	void unsetZLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBlock#getZLengthAsString <em>ZLength As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>ZLength As String</em>' attribute is set.
	 * @see #unsetZLengthAsString()
	 * @see #getZLengthAsString()
	 * @see #setZLengthAsString(String)
	 * @generated
	 */
	boolean isSetZLengthAsString();

} // IfcBlock
