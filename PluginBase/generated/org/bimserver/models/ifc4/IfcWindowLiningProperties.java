/**
 * Copyright (C) 2009-2014 BIMserver.org
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
package org.bimserver.models.ifc4;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

public interface IfcWindowLiningProperties extends IfcPreDefinedPropertySet {
	/**
	 * Returns the value of the '<em><b>Lining Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Depth</em>' attribute.
	 * @see #isSetLiningDepth()
	 * @see #unsetLiningDepth()
	 * @see #setLiningDepth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_LiningDepth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLiningDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningDepth <em>Lining Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Depth</em>' attribute.
	 * @see #isSetLiningDepth()
	 * @see #unsetLiningDepth()
	 * @see #getLiningDepth()
	 * @generated
	 */
	void setLiningDepth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningDepth <em>Lining Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningDepth()
	 * @see #getLiningDepth()
	 * @see #setLiningDepth(double)
	 * @generated
	 */
	void unsetLiningDepth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningDepth <em>Lining Depth</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Depth</em>' attribute is set.
	 * @see #unsetLiningDepth()
	 * @see #getLiningDepth()
	 * @see #setLiningDepth(double)
	 * @generated
	 */
	boolean isSetLiningDepth();

	/**
	 * Returns the value of the '<em><b>Lining Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Depth As String</em>' attribute.
	 * @see #isSetLiningDepthAsString()
	 * @see #unsetLiningDepthAsString()
	 * @see #setLiningDepthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_LiningDepthAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLiningDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningDepthAsString <em>Lining Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Depth As String</em>' attribute.
	 * @see #isSetLiningDepthAsString()
	 * @see #unsetLiningDepthAsString()
	 * @see #getLiningDepthAsString()
	 * @generated
	 */
	void setLiningDepthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningDepthAsString <em>Lining Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningDepthAsString()
	 * @see #getLiningDepthAsString()
	 * @see #setLiningDepthAsString(String)
	 * @generated
	 */
	void unsetLiningDepthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningDepthAsString <em>Lining Depth As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Depth As String</em>' attribute is set.
	 * @see #unsetLiningDepthAsString()
	 * @see #getLiningDepthAsString()
	 * @see #setLiningDepthAsString(String)
	 * @generated
	 */
	boolean isSetLiningDepthAsString();

	/**
	 * Returns the value of the '<em><b>Lining Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Thickness</em>' attribute.
	 * @see #isSetLiningThickness()
	 * @see #unsetLiningThickness()
	 * @see #setLiningThickness(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_LiningThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLiningThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningThickness <em>Lining Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Thickness</em>' attribute.
	 * @see #isSetLiningThickness()
	 * @see #unsetLiningThickness()
	 * @see #getLiningThickness()
	 * @generated
	 */
	void setLiningThickness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningThickness <em>Lining Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningThickness()
	 * @see #getLiningThickness()
	 * @see #setLiningThickness(double)
	 * @generated
	 */
	void unsetLiningThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningThickness <em>Lining Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Thickness</em>' attribute is set.
	 * @see #unsetLiningThickness()
	 * @see #getLiningThickness()
	 * @see #setLiningThickness(double)
	 * @generated
	 */
	boolean isSetLiningThickness();

	/**
	 * Returns the value of the '<em><b>Lining Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Thickness As String</em>' attribute.
	 * @see #isSetLiningThicknessAsString()
	 * @see #unsetLiningThicknessAsString()
	 * @see #setLiningThicknessAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_LiningThicknessAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLiningThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningThicknessAsString <em>Lining Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Thickness As String</em>' attribute.
	 * @see #isSetLiningThicknessAsString()
	 * @see #unsetLiningThicknessAsString()
	 * @see #getLiningThicknessAsString()
	 * @generated
	 */
	void setLiningThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningThicknessAsString <em>Lining Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningThicknessAsString()
	 * @see #getLiningThicknessAsString()
	 * @see #setLiningThicknessAsString(String)
	 * @generated
	 */
	void unsetLiningThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningThicknessAsString <em>Lining Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Thickness As String</em>' attribute is set.
	 * @see #unsetLiningThicknessAsString()
	 * @see #getLiningThicknessAsString()
	 * @see #setLiningThicknessAsString(String)
	 * @generated
	 */
	boolean isSetLiningThicknessAsString();

	/**
	 * Returns the value of the '<em><b>Transom Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transom Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transom Thickness</em>' attribute.
	 * @see #isSetTransomThickness()
	 * @see #unsetTransomThickness()
	 * @see #setTransomThickness(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_TransomThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTransomThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getTransomThickness <em>Transom Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transom Thickness</em>' attribute.
	 * @see #isSetTransomThickness()
	 * @see #unsetTransomThickness()
	 * @see #getTransomThickness()
	 * @generated
	 */
	void setTransomThickness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getTransomThickness <em>Transom Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransomThickness()
	 * @see #getTransomThickness()
	 * @see #setTransomThickness(double)
	 * @generated
	 */
	void unsetTransomThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getTransomThickness <em>Transom Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transom Thickness</em>' attribute is set.
	 * @see #unsetTransomThickness()
	 * @see #getTransomThickness()
	 * @see #setTransomThickness(double)
	 * @generated
	 */
	boolean isSetTransomThickness();

	/**
	 * Returns the value of the '<em><b>Transom Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transom Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transom Thickness As String</em>' attribute.
	 * @see #isSetTransomThicknessAsString()
	 * @see #unsetTransomThicknessAsString()
	 * @see #setTransomThicknessAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_TransomThicknessAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTransomThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getTransomThicknessAsString <em>Transom Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transom Thickness As String</em>' attribute.
	 * @see #isSetTransomThicknessAsString()
	 * @see #unsetTransomThicknessAsString()
	 * @see #getTransomThicknessAsString()
	 * @generated
	 */
	void setTransomThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getTransomThicknessAsString <em>Transom Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransomThicknessAsString()
	 * @see #getTransomThicknessAsString()
	 * @see #setTransomThicknessAsString(String)
	 * @generated
	 */
	void unsetTransomThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getTransomThicknessAsString <em>Transom Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transom Thickness As String</em>' attribute is set.
	 * @see #unsetTransomThicknessAsString()
	 * @see #getTransomThicknessAsString()
	 * @see #setTransomThicknessAsString(String)
	 * @generated
	 */
	boolean isSetTransomThicknessAsString();

	/**
	 * Returns the value of the '<em><b>Mullion Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mullion Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mullion Thickness</em>' attribute.
	 * @see #isSetMullionThickness()
	 * @see #unsetMullionThickness()
	 * @see #setMullionThickness(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_MullionThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMullionThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getMullionThickness <em>Mullion Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mullion Thickness</em>' attribute.
	 * @see #isSetMullionThickness()
	 * @see #unsetMullionThickness()
	 * @see #getMullionThickness()
	 * @generated
	 */
	void setMullionThickness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getMullionThickness <em>Mullion Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMullionThickness()
	 * @see #getMullionThickness()
	 * @see #setMullionThickness(double)
	 * @generated
	 */
	void unsetMullionThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getMullionThickness <em>Mullion Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mullion Thickness</em>' attribute is set.
	 * @see #unsetMullionThickness()
	 * @see #getMullionThickness()
	 * @see #setMullionThickness(double)
	 * @generated
	 */
	boolean isSetMullionThickness();

	/**
	 * Returns the value of the '<em><b>Mullion Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mullion Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mullion Thickness As String</em>' attribute.
	 * @see #isSetMullionThicknessAsString()
	 * @see #unsetMullionThicknessAsString()
	 * @see #setMullionThicknessAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_MullionThicknessAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getMullionThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getMullionThicknessAsString <em>Mullion Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mullion Thickness As String</em>' attribute.
	 * @see #isSetMullionThicknessAsString()
	 * @see #unsetMullionThicknessAsString()
	 * @see #getMullionThicknessAsString()
	 * @generated
	 */
	void setMullionThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getMullionThicknessAsString <em>Mullion Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMullionThicknessAsString()
	 * @see #getMullionThicknessAsString()
	 * @see #setMullionThicknessAsString(String)
	 * @generated
	 */
	void unsetMullionThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getMullionThicknessAsString <em>Mullion Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mullion Thickness As String</em>' attribute is set.
	 * @see #unsetMullionThicknessAsString()
	 * @see #getMullionThicknessAsString()
	 * @see #setMullionThicknessAsString(String)
	 * @generated
	 */
	boolean isSetMullionThicknessAsString();

	/**
	 * Returns the value of the '<em><b>First Transom Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Transom Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Transom Offset</em>' attribute.
	 * @see #isSetFirstTransomOffset()
	 * @see #unsetFirstTransomOffset()
	 * @see #setFirstTransomOffset(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_FirstTransomOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFirstTransomOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstTransomOffset <em>First Transom Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Transom Offset</em>' attribute.
	 * @see #isSetFirstTransomOffset()
	 * @see #unsetFirstTransomOffset()
	 * @see #getFirstTransomOffset()
	 * @generated
	 */
	void setFirstTransomOffset(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstTransomOffset <em>First Transom Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFirstTransomOffset()
	 * @see #getFirstTransomOffset()
	 * @see #setFirstTransomOffset(double)
	 * @generated
	 */
	void unsetFirstTransomOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstTransomOffset <em>First Transom Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>First Transom Offset</em>' attribute is set.
	 * @see #unsetFirstTransomOffset()
	 * @see #getFirstTransomOffset()
	 * @see #setFirstTransomOffset(double)
	 * @generated
	 */
	boolean isSetFirstTransomOffset();

	/**
	 * Returns the value of the '<em><b>First Transom Offset As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Transom Offset As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Transom Offset As String</em>' attribute.
	 * @see #isSetFirstTransomOffsetAsString()
	 * @see #unsetFirstTransomOffsetAsString()
	 * @see #setFirstTransomOffsetAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_FirstTransomOffsetAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFirstTransomOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstTransomOffsetAsString <em>First Transom Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Transom Offset As String</em>' attribute.
	 * @see #isSetFirstTransomOffsetAsString()
	 * @see #unsetFirstTransomOffsetAsString()
	 * @see #getFirstTransomOffsetAsString()
	 * @generated
	 */
	void setFirstTransomOffsetAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstTransomOffsetAsString <em>First Transom Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFirstTransomOffsetAsString()
	 * @see #getFirstTransomOffsetAsString()
	 * @see #setFirstTransomOffsetAsString(String)
	 * @generated
	 */
	void unsetFirstTransomOffsetAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstTransomOffsetAsString <em>First Transom Offset As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>First Transom Offset As String</em>' attribute is set.
	 * @see #unsetFirstTransomOffsetAsString()
	 * @see #getFirstTransomOffsetAsString()
	 * @see #setFirstTransomOffsetAsString(String)
	 * @generated
	 */
	boolean isSetFirstTransomOffsetAsString();

	/**
	 * Returns the value of the '<em><b>Second Transom Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Transom Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Transom Offset</em>' attribute.
	 * @see #isSetSecondTransomOffset()
	 * @see #unsetSecondTransomOffset()
	 * @see #setSecondTransomOffset(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_SecondTransomOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSecondTransomOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondTransomOffset <em>Second Transom Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Transom Offset</em>' attribute.
	 * @see #isSetSecondTransomOffset()
	 * @see #unsetSecondTransomOffset()
	 * @see #getSecondTransomOffset()
	 * @generated
	 */
	void setSecondTransomOffset(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondTransomOffset <em>Second Transom Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondTransomOffset()
	 * @see #getSecondTransomOffset()
	 * @see #setSecondTransomOffset(double)
	 * @generated
	 */
	void unsetSecondTransomOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondTransomOffset <em>Second Transom Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Second Transom Offset</em>' attribute is set.
	 * @see #unsetSecondTransomOffset()
	 * @see #getSecondTransomOffset()
	 * @see #setSecondTransomOffset(double)
	 * @generated
	 */
	boolean isSetSecondTransomOffset();

	/**
	 * Returns the value of the '<em><b>Second Transom Offset As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Transom Offset As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Transom Offset As String</em>' attribute.
	 * @see #isSetSecondTransomOffsetAsString()
	 * @see #unsetSecondTransomOffsetAsString()
	 * @see #setSecondTransomOffsetAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_SecondTransomOffsetAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getSecondTransomOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondTransomOffsetAsString <em>Second Transom Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Transom Offset As String</em>' attribute.
	 * @see #isSetSecondTransomOffsetAsString()
	 * @see #unsetSecondTransomOffsetAsString()
	 * @see #getSecondTransomOffsetAsString()
	 * @generated
	 */
	void setSecondTransomOffsetAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondTransomOffsetAsString <em>Second Transom Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondTransomOffsetAsString()
	 * @see #getSecondTransomOffsetAsString()
	 * @see #setSecondTransomOffsetAsString(String)
	 * @generated
	 */
	void unsetSecondTransomOffsetAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondTransomOffsetAsString <em>Second Transom Offset As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Second Transom Offset As String</em>' attribute is set.
	 * @see #unsetSecondTransomOffsetAsString()
	 * @see #getSecondTransomOffsetAsString()
	 * @see #setSecondTransomOffsetAsString(String)
	 * @generated
	 */
	boolean isSetSecondTransomOffsetAsString();

	/**
	 * Returns the value of the '<em><b>First Mullion Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Mullion Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Mullion Offset</em>' attribute.
	 * @see #isSetFirstMullionOffset()
	 * @see #unsetFirstMullionOffset()
	 * @see #setFirstMullionOffset(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_FirstMullionOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFirstMullionOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstMullionOffset <em>First Mullion Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Mullion Offset</em>' attribute.
	 * @see #isSetFirstMullionOffset()
	 * @see #unsetFirstMullionOffset()
	 * @see #getFirstMullionOffset()
	 * @generated
	 */
	void setFirstMullionOffset(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstMullionOffset <em>First Mullion Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFirstMullionOffset()
	 * @see #getFirstMullionOffset()
	 * @see #setFirstMullionOffset(double)
	 * @generated
	 */
	void unsetFirstMullionOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstMullionOffset <em>First Mullion Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>First Mullion Offset</em>' attribute is set.
	 * @see #unsetFirstMullionOffset()
	 * @see #getFirstMullionOffset()
	 * @see #setFirstMullionOffset(double)
	 * @generated
	 */
	boolean isSetFirstMullionOffset();

	/**
	 * Returns the value of the '<em><b>First Mullion Offset As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Mullion Offset As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Mullion Offset As String</em>' attribute.
	 * @see #isSetFirstMullionOffsetAsString()
	 * @see #unsetFirstMullionOffsetAsString()
	 * @see #setFirstMullionOffsetAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_FirstMullionOffsetAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFirstMullionOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstMullionOffsetAsString <em>First Mullion Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Mullion Offset As String</em>' attribute.
	 * @see #isSetFirstMullionOffsetAsString()
	 * @see #unsetFirstMullionOffsetAsString()
	 * @see #getFirstMullionOffsetAsString()
	 * @generated
	 */
	void setFirstMullionOffsetAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstMullionOffsetAsString <em>First Mullion Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFirstMullionOffsetAsString()
	 * @see #getFirstMullionOffsetAsString()
	 * @see #setFirstMullionOffsetAsString(String)
	 * @generated
	 */
	void unsetFirstMullionOffsetAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getFirstMullionOffsetAsString <em>First Mullion Offset As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>First Mullion Offset As String</em>' attribute is set.
	 * @see #unsetFirstMullionOffsetAsString()
	 * @see #getFirstMullionOffsetAsString()
	 * @see #setFirstMullionOffsetAsString(String)
	 * @generated
	 */
	boolean isSetFirstMullionOffsetAsString();

	/**
	 * Returns the value of the '<em><b>Second Mullion Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Mullion Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Mullion Offset</em>' attribute.
	 * @see #isSetSecondMullionOffset()
	 * @see #unsetSecondMullionOffset()
	 * @see #setSecondMullionOffset(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_SecondMullionOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSecondMullionOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondMullionOffset <em>Second Mullion Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Mullion Offset</em>' attribute.
	 * @see #isSetSecondMullionOffset()
	 * @see #unsetSecondMullionOffset()
	 * @see #getSecondMullionOffset()
	 * @generated
	 */
	void setSecondMullionOffset(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondMullionOffset <em>Second Mullion Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondMullionOffset()
	 * @see #getSecondMullionOffset()
	 * @see #setSecondMullionOffset(double)
	 * @generated
	 */
	void unsetSecondMullionOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondMullionOffset <em>Second Mullion Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Second Mullion Offset</em>' attribute is set.
	 * @see #unsetSecondMullionOffset()
	 * @see #getSecondMullionOffset()
	 * @see #setSecondMullionOffset(double)
	 * @generated
	 */
	boolean isSetSecondMullionOffset();

	/**
	 * Returns the value of the '<em><b>Second Mullion Offset As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Mullion Offset As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Mullion Offset As String</em>' attribute.
	 * @see #isSetSecondMullionOffsetAsString()
	 * @see #unsetSecondMullionOffsetAsString()
	 * @see #setSecondMullionOffsetAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_SecondMullionOffsetAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getSecondMullionOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondMullionOffsetAsString <em>Second Mullion Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Mullion Offset As String</em>' attribute.
	 * @see #isSetSecondMullionOffsetAsString()
	 * @see #unsetSecondMullionOffsetAsString()
	 * @see #getSecondMullionOffsetAsString()
	 * @generated
	 */
	void setSecondMullionOffsetAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondMullionOffsetAsString <em>Second Mullion Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondMullionOffsetAsString()
	 * @see #getSecondMullionOffsetAsString()
	 * @see #setSecondMullionOffsetAsString(String)
	 * @generated
	 */
	void unsetSecondMullionOffsetAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getSecondMullionOffsetAsString <em>Second Mullion Offset As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Second Mullion Offset As String</em>' attribute is set.
	 * @see #unsetSecondMullionOffsetAsString()
	 * @see #getSecondMullionOffsetAsString()
	 * @see #setSecondMullionOffsetAsString(String)
	 * @generated
	 */
	boolean isSetSecondMullionOffsetAsString();

	/**
	 * Returns the value of the '<em><b>Shape Aspect Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape Aspect Style</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape Aspect Style</em>' reference.
	 * @see #isSetShapeAspectStyle()
	 * @see #unsetShapeAspectStyle()
	 * @see #setShapeAspectStyle(IfcShapeAspect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_ShapeAspectStyle()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcShapeAspect getShapeAspectStyle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getShapeAspectStyle <em>Shape Aspect Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape Aspect Style</em>' reference.
	 * @see #isSetShapeAspectStyle()
	 * @see #unsetShapeAspectStyle()
	 * @see #getShapeAspectStyle()
	 * @generated
	 */
	void setShapeAspectStyle(IfcShapeAspect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getShapeAspectStyle <em>Shape Aspect Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShapeAspectStyle()
	 * @see #getShapeAspectStyle()
	 * @see #setShapeAspectStyle(IfcShapeAspect)
	 * @generated
	 */
	void unsetShapeAspectStyle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getShapeAspectStyle <em>Shape Aspect Style</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shape Aspect Style</em>' reference is set.
	 * @see #unsetShapeAspectStyle()
	 * @see #getShapeAspectStyle()
	 * @see #setShapeAspectStyle(IfcShapeAspect)
	 * @generated
	 */
	boolean isSetShapeAspectStyle();

	/**
	 * Returns the value of the '<em><b>Lining Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Offset</em>' attribute.
	 * @see #isSetLiningOffset()
	 * @see #unsetLiningOffset()
	 * @see #setLiningOffset(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_LiningOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLiningOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningOffset <em>Lining Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Offset</em>' attribute.
	 * @see #isSetLiningOffset()
	 * @see #unsetLiningOffset()
	 * @see #getLiningOffset()
	 * @generated
	 */
	void setLiningOffset(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningOffset <em>Lining Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningOffset()
	 * @see #getLiningOffset()
	 * @see #setLiningOffset(double)
	 * @generated
	 */
	void unsetLiningOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningOffset <em>Lining Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Offset</em>' attribute is set.
	 * @see #unsetLiningOffset()
	 * @see #getLiningOffset()
	 * @see #setLiningOffset(double)
	 * @generated
	 */
	boolean isSetLiningOffset();

	/**
	 * Returns the value of the '<em><b>Lining Offset As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining Offset As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining Offset As String</em>' attribute.
	 * @see #isSetLiningOffsetAsString()
	 * @see #unsetLiningOffsetAsString()
	 * @see #setLiningOffsetAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_LiningOffsetAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLiningOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningOffsetAsString <em>Lining Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining Offset As String</em>' attribute.
	 * @see #isSetLiningOffsetAsString()
	 * @see #unsetLiningOffsetAsString()
	 * @see #getLiningOffsetAsString()
	 * @generated
	 */
	void setLiningOffsetAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningOffsetAsString <em>Lining Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningOffsetAsString()
	 * @see #getLiningOffsetAsString()
	 * @see #setLiningOffsetAsString(String)
	 * @generated
	 */
	void unsetLiningOffsetAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningOffsetAsString <em>Lining Offset As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining Offset As String</em>' attribute is set.
	 * @see #unsetLiningOffsetAsString()
	 * @see #getLiningOffsetAsString()
	 * @see #setLiningOffsetAsString(String)
	 * @generated
	 */
	boolean isSetLiningOffsetAsString();

	/**
	 * Returns the value of the '<em><b>Lining To Panel Offset X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining To Panel Offset X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining To Panel Offset X</em>' attribute.
	 * @see #isSetLiningToPanelOffsetX()
	 * @see #unsetLiningToPanelOffsetX()
	 * @see #setLiningToPanelOffsetX(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_LiningToPanelOffsetX()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLiningToPanelOffsetX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetX <em>Lining To Panel Offset X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining To Panel Offset X</em>' attribute.
	 * @see #isSetLiningToPanelOffsetX()
	 * @see #unsetLiningToPanelOffsetX()
	 * @see #getLiningToPanelOffsetX()
	 * @generated
	 */
	void setLiningToPanelOffsetX(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetX <em>Lining To Panel Offset X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningToPanelOffsetX()
	 * @see #getLiningToPanelOffsetX()
	 * @see #setLiningToPanelOffsetX(double)
	 * @generated
	 */
	void unsetLiningToPanelOffsetX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetX <em>Lining To Panel Offset X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining To Panel Offset X</em>' attribute is set.
	 * @see #unsetLiningToPanelOffsetX()
	 * @see #getLiningToPanelOffsetX()
	 * @see #setLiningToPanelOffsetX(double)
	 * @generated
	 */
	boolean isSetLiningToPanelOffsetX();

	/**
	 * Returns the value of the '<em><b>Lining To Panel Offset XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining To Panel Offset XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining To Panel Offset XAs String</em>' attribute.
	 * @see #isSetLiningToPanelOffsetXAsString()
	 * @see #unsetLiningToPanelOffsetXAsString()
	 * @see #setLiningToPanelOffsetXAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_LiningToPanelOffsetXAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLiningToPanelOffsetXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetXAsString <em>Lining To Panel Offset XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining To Panel Offset XAs String</em>' attribute.
	 * @see #isSetLiningToPanelOffsetXAsString()
	 * @see #unsetLiningToPanelOffsetXAsString()
	 * @see #getLiningToPanelOffsetXAsString()
	 * @generated
	 */
	void setLiningToPanelOffsetXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetXAsString <em>Lining To Panel Offset XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningToPanelOffsetXAsString()
	 * @see #getLiningToPanelOffsetXAsString()
	 * @see #setLiningToPanelOffsetXAsString(String)
	 * @generated
	 */
	void unsetLiningToPanelOffsetXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetXAsString <em>Lining To Panel Offset XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining To Panel Offset XAs String</em>' attribute is set.
	 * @see #unsetLiningToPanelOffsetXAsString()
	 * @see #getLiningToPanelOffsetXAsString()
	 * @see #setLiningToPanelOffsetXAsString(String)
	 * @generated
	 */
	boolean isSetLiningToPanelOffsetXAsString();

	/**
	 * Returns the value of the '<em><b>Lining To Panel Offset Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining To Panel Offset Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining To Panel Offset Y</em>' attribute.
	 * @see #isSetLiningToPanelOffsetY()
	 * @see #unsetLiningToPanelOffsetY()
	 * @see #setLiningToPanelOffsetY(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_LiningToPanelOffsetY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLiningToPanelOffsetY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetY <em>Lining To Panel Offset Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining To Panel Offset Y</em>' attribute.
	 * @see #isSetLiningToPanelOffsetY()
	 * @see #unsetLiningToPanelOffsetY()
	 * @see #getLiningToPanelOffsetY()
	 * @generated
	 */
	void setLiningToPanelOffsetY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetY <em>Lining To Panel Offset Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningToPanelOffsetY()
	 * @see #getLiningToPanelOffsetY()
	 * @see #setLiningToPanelOffsetY(double)
	 * @generated
	 */
	void unsetLiningToPanelOffsetY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetY <em>Lining To Panel Offset Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining To Panel Offset Y</em>' attribute is set.
	 * @see #unsetLiningToPanelOffsetY()
	 * @see #getLiningToPanelOffsetY()
	 * @see #setLiningToPanelOffsetY(double)
	 * @generated
	 */
	boolean isSetLiningToPanelOffsetY();

	/**
	 * Returns the value of the '<em><b>Lining To Panel Offset YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lining To Panel Offset YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lining To Panel Offset YAs String</em>' attribute.
	 * @see #isSetLiningToPanelOffsetYAsString()
	 * @see #unsetLiningToPanelOffsetYAsString()
	 * @see #setLiningToPanelOffsetYAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowLiningProperties_LiningToPanelOffsetYAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLiningToPanelOffsetYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetYAsString <em>Lining To Panel Offset YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lining To Panel Offset YAs String</em>' attribute.
	 * @see #isSetLiningToPanelOffsetYAsString()
	 * @see #unsetLiningToPanelOffsetYAsString()
	 * @see #getLiningToPanelOffsetYAsString()
	 * @generated
	 */
	void setLiningToPanelOffsetYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetYAsString <em>Lining To Panel Offset YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLiningToPanelOffsetYAsString()
	 * @see #getLiningToPanelOffsetYAsString()
	 * @see #setLiningToPanelOffsetYAsString(String)
	 * @generated
	 */
	void unsetLiningToPanelOffsetYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWindowLiningProperties#getLiningToPanelOffsetYAsString <em>Lining To Panel Offset YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lining To Panel Offset YAs String</em>' attribute is set.
	 * @see #unsetLiningToPanelOffsetYAsString()
	 * @see #getLiningToPanelOffsetYAsString()
	 * @see #setLiningToPanelOffsetYAsString(String)
	 * @generated
	 */
	boolean isSetLiningToPanelOffsetYAsString();

} // IfcWindowLiningProperties
