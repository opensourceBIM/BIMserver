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
 * A representation of the model object '<em><b>Ifc Bounding Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getCorner <em>Corner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getXDim <em>XDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getXDimAsString <em>XDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getYDim <em>YDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getYDimAsString <em>YDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getZDim <em>ZDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getZDimAsString <em>ZDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox()
 * @model
 * @generated
 */
public interface IfcBoundingBox extends IfcGeometricRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Corner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corner</em>' reference.
	 * @see #isSetCorner()
	 * @see #unsetCorner()
	 * @see #setCorner(IfcCartesianPoint)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_Corner()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCartesianPoint getCorner();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getCorner <em>Corner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Corner</em>' reference.
	 * @see #isSetCorner()
	 * @see #unsetCorner()
	 * @see #getCorner()
	 * @generated
	 */
	void setCorner(IfcCartesianPoint value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getCorner <em>Corner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCorner()
	 * @see #getCorner()
	 * @see #setCorner(IfcCartesianPoint)
	 * @generated
	 */
	void unsetCorner();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getCorner <em>Corner</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Corner</em>' reference is set.
	 * @see #unsetCorner()
	 * @see #getCorner()
	 * @see #setCorner(IfcCartesianPoint)
	 * @generated
	 */
	boolean isSetCorner();

	/**
	 * Returns the value of the '<em><b>XDim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XDim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XDim</em>' attribute.
	 * @see #isSetXDim()
	 * @see #unsetXDim()
	 * @see #setXDim(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_XDim()
	 * @model unsettable="true"
	 * @generated
	 */
	double getXDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getXDim <em>XDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XDim</em>' attribute.
	 * @see #isSetXDim()
	 * @see #unsetXDim()
	 * @see #getXDim()
	 * @generated
	 */
	void setXDim(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getXDim <em>XDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetXDim()
	 * @see #getXDim()
	 * @see #setXDim(double)
	 * @generated
	 */
	void unsetXDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getXDim <em>XDim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>XDim</em>' attribute is set.
	 * @see #unsetXDim()
	 * @see #getXDim()
	 * @see #setXDim(double)
	 * @generated
	 */
	boolean isSetXDim();

	/**
	 * Returns the value of the '<em><b>XDim As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XDim As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XDim As String</em>' attribute.
	 * @see #isSetXDimAsString()
	 * @see #unsetXDimAsString()
	 * @see #setXDimAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_XDimAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getXDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getXDimAsString <em>XDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XDim As String</em>' attribute.
	 * @see #isSetXDimAsString()
	 * @see #unsetXDimAsString()
	 * @see #getXDimAsString()
	 * @generated
	 */
	void setXDimAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getXDimAsString <em>XDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetXDimAsString()
	 * @see #getXDimAsString()
	 * @see #setXDimAsString(String)
	 * @generated
	 */
	void unsetXDimAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getXDimAsString <em>XDim As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>XDim As String</em>' attribute is set.
	 * @see #unsetXDimAsString()
	 * @see #getXDimAsString()
	 * @see #setXDimAsString(String)
	 * @generated
	 */
	boolean isSetXDimAsString();

	/**
	 * Returns the value of the '<em><b>YDim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YDim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YDim</em>' attribute.
	 * @see #isSetYDim()
	 * @see #unsetYDim()
	 * @see #setYDim(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_YDim()
	 * @model unsettable="true"
	 * @generated
	 */
	double getYDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getYDim <em>YDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YDim</em>' attribute.
	 * @see #isSetYDim()
	 * @see #unsetYDim()
	 * @see #getYDim()
	 * @generated
	 */
	void setYDim(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getYDim <em>YDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetYDim()
	 * @see #getYDim()
	 * @see #setYDim(double)
	 * @generated
	 */
	void unsetYDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getYDim <em>YDim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>YDim</em>' attribute is set.
	 * @see #unsetYDim()
	 * @see #getYDim()
	 * @see #setYDim(double)
	 * @generated
	 */
	boolean isSetYDim();

	/**
	 * Returns the value of the '<em><b>YDim As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YDim As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YDim As String</em>' attribute.
	 * @see #isSetYDimAsString()
	 * @see #unsetYDimAsString()
	 * @see #setYDimAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_YDimAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getYDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getYDimAsString <em>YDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YDim As String</em>' attribute.
	 * @see #isSetYDimAsString()
	 * @see #unsetYDimAsString()
	 * @see #getYDimAsString()
	 * @generated
	 */
	void setYDimAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getYDimAsString <em>YDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetYDimAsString()
	 * @see #getYDimAsString()
	 * @see #setYDimAsString(String)
	 * @generated
	 */
	void unsetYDimAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getYDimAsString <em>YDim As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>YDim As String</em>' attribute is set.
	 * @see #unsetYDimAsString()
	 * @see #getYDimAsString()
	 * @see #setYDimAsString(String)
	 * @generated
	 */
	boolean isSetYDimAsString();

	/**
	 * Returns the value of the '<em><b>ZDim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ZDim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZDim</em>' attribute.
	 * @see #isSetZDim()
	 * @see #unsetZDim()
	 * @see #setZDim(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_ZDim()
	 * @model unsettable="true"
	 * @generated
	 */
	double getZDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getZDim <em>ZDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZDim</em>' attribute.
	 * @see #isSetZDim()
	 * @see #unsetZDim()
	 * @see #getZDim()
	 * @generated
	 */
	void setZDim(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getZDim <em>ZDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetZDim()
	 * @see #getZDim()
	 * @see #setZDim(double)
	 * @generated
	 */
	void unsetZDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getZDim <em>ZDim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>ZDim</em>' attribute is set.
	 * @see #unsetZDim()
	 * @see #getZDim()
	 * @see #setZDim(double)
	 * @generated
	 */
	boolean isSetZDim();

	/**
	 * Returns the value of the '<em><b>ZDim As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ZDim As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZDim As String</em>' attribute.
	 * @see #isSetZDimAsString()
	 * @see #unsetZDimAsString()
	 * @see #setZDimAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_ZDimAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getZDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getZDimAsString <em>ZDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZDim As String</em>' attribute.
	 * @see #isSetZDimAsString()
	 * @see #unsetZDimAsString()
	 * @see #getZDimAsString()
	 * @generated
	 */
	void setZDimAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getZDimAsString <em>ZDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetZDimAsString()
	 * @see #getZDimAsString()
	 * @see #setZDimAsString(String)
	 * @generated
	 */
	void unsetZDimAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getZDimAsString <em>ZDim As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>ZDim As String</em>' attribute is set.
	 * @see #unsetZDimAsString()
	 * @see #getZDimAsString()
	 * @see #setZDimAsString(String)
	 * @generated
	 */
	boolean isSetZDimAsString();

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #setDim(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_Dim()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	void unsetDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getDim <em>Dim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dim</em>' attribute is set.
	 * @see #unsetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	boolean isSetDim();

} // IfcBoundingBox
