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
public interface IfcBoundingBox extends IfcGeometricRepresentationItem
{
	/**
	 * Returns the value of the '<em><b>Corner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corner</em>' reference.
	 * @see #setCorner(IfcCartesianPoint)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_Corner()
	 * @model
	 * @generated
	 */
	IfcCartesianPoint getCorner();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getCorner <em>Corner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Corner</em>' reference.
	 * @see #getCorner()
	 * @generated
	 */
	void setCorner(IfcCartesianPoint value);

	/**
	 * Returns the value of the '<em><b>XDim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XDim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XDim</em>' attribute.
	 * @see #setXDim(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_XDim()
	 * @model
	 * @generated
	 */
	float getXDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getXDim <em>XDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XDim</em>' attribute.
	 * @see #getXDim()
	 * @generated
	 */
	void setXDim(float value);

	/**
	 * Returns the value of the '<em><b>XDim As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XDim As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XDim As String</em>' attribute.
	 * @see #setXDimAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_XDimAsString()
	 * @model
	 * @generated
	 */
	String getXDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getXDimAsString <em>XDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XDim As String</em>' attribute.
	 * @see #getXDimAsString()
	 * @generated
	 */
	void setXDimAsString(String value);

	/**
	 * Returns the value of the '<em><b>YDim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YDim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YDim</em>' attribute.
	 * @see #setYDim(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_YDim()
	 * @model
	 * @generated
	 */
	float getYDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getYDim <em>YDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YDim</em>' attribute.
	 * @see #getYDim()
	 * @generated
	 */
	void setYDim(float value);

	/**
	 * Returns the value of the '<em><b>YDim As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YDim As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YDim As String</em>' attribute.
	 * @see #setYDimAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_YDimAsString()
	 * @model
	 * @generated
	 */
	String getYDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getYDimAsString <em>YDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YDim As String</em>' attribute.
	 * @see #getYDimAsString()
	 * @generated
	 */
	void setYDimAsString(String value);

	/**
	 * Returns the value of the '<em><b>ZDim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ZDim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZDim</em>' attribute.
	 * @see #setZDim(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_ZDim()
	 * @model
	 * @generated
	 */
	float getZDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getZDim <em>ZDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZDim</em>' attribute.
	 * @see #getZDim()
	 * @generated
	 */
	void setZDim(float value);

	/**
	 * Returns the value of the '<em><b>ZDim As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ZDim As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ZDim As String</em>' attribute.
	 * @see #setZDimAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_ZDimAsString()
	 * @model
	 * @generated
	 */
	String getZDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getZDimAsString <em>ZDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZDim As String</em>' attribute.
	 * @see #getZDimAsString()
	 * @generated
	 */
	void setZDimAsString(String value);

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #setDim(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundingBox_Dim()
	 * @model derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundingBox#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

} // IfcBoundingBox
