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
 * A representation of the model object '<em><b>Ifc Trapezium Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getBottomXDim <em>Bottom XDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getBottomXDimAsString <em>Bottom XDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXDim <em>Top XDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXDimAsString <em>Top XDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getYDim <em>YDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getYDimAsString <em>YDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXOffset <em>Top XOffset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXOffsetAsString <em>Top XOffset As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef()
 * @model
 * @generated
 */
public interface IfcTrapeziumProfileDef extends IfcParameterizedProfileDef
{
	/**
	 * Returns the value of the '<em><b>Bottom XDim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom XDim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom XDim</em>' attribute.
	 * @see #setBottomXDim(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_BottomXDim()
	 * @model
	 * @generated
	 */
	float getBottomXDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getBottomXDim <em>Bottom XDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom XDim</em>' attribute.
	 * @see #getBottomXDim()
	 * @generated
	 */
	void setBottomXDim(float value);

	/**
	 * Returns the value of the '<em><b>Bottom XDim As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom XDim As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom XDim As String</em>' attribute.
	 * @see #setBottomXDimAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_BottomXDimAsString()
	 * @model
	 * @generated
	 */
	String getBottomXDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getBottomXDimAsString <em>Bottom XDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom XDim As String</em>' attribute.
	 * @see #getBottomXDimAsString()
	 * @generated
	 */
	void setBottomXDimAsString(String value);

	/**
	 * Returns the value of the '<em><b>Top XDim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top XDim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top XDim</em>' attribute.
	 * @see #setTopXDim(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_TopXDim()
	 * @model
	 * @generated
	 */
	float getTopXDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXDim <em>Top XDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top XDim</em>' attribute.
	 * @see #getTopXDim()
	 * @generated
	 */
	void setTopXDim(float value);

	/**
	 * Returns the value of the '<em><b>Top XDim As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top XDim As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top XDim As String</em>' attribute.
	 * @see #setTopXDimAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_TopXDimAsString()
	 * @model
	 * @generated
	 */
	String getTopXDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXDimAsString <em>Top XDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top XDim As String</em>' attribute.
	 * @see #getTopXDimAsString()
	 * @generated
	 */
	void setTopXDimAsString(String value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_YDim()
	 * @model
	 * @generated
	 */
	float getYDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getYDim <em>YDim</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_YDimAsString()
	 * @model
	 * @generated
	 */
	String getYDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getYDimAsString <em>YDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YDim As String</em>' attribute.
	 * @see #getYDimAsString()
	 * @generated
	 */
	void setYDimAsString(String value);

	/**
	 * Returns the value of the '<em><b>Top XOffset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top XOffset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top XOffset</em>' attribute.
	 * @see #setTopXOffset(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_TopXOffset()
	 * @model
	 * @generated
	 */
	float getTopXOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXOffset <em>Top XOffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top XOffset</em>' attribute.
	 * @see #getTopXOffset()
	 * @generated
	 */
	void setTopXOffset(float value);

	/**
	 * Returns the value of the '<em><b>Top XOffset As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top XOffset As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top XOffset As String</em>' attribute.
	 * @see #setTopXOffsetAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_TopXOffsetAsString()
	 * @model
	 * @generated
	 */
	String getTopXOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXOffsetAsString <em>Top XOffset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top XOffset As String</em>' attribute.
	 * @see #getTopXOffsetAsString()
	 * @generated
	 */
	void setTopXOffsetAsString(String value);

} // IfcTrapeziumProfileDef
