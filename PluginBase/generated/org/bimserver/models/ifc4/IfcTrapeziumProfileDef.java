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

public interface IfcTrapeziumProfileDef extends IfcParameterizedProfileDef {
	/**
	 * Returns the value of the '<em><b>Bottom XDim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom XDim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom XDim</em>' attribute.
	 * @see #setBottomXDim(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrapeziumProfileDef_BottomXDim()
	 * @model
	 * @generated
	 */
	double getBottomXDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTrapeziumProfileDef#getBottomXDim <em>Bottom XDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom XDim</em>' attribute.
	 * @see #getBottomXDim()
	 * @generated
	 */
	void setBottomXDim(double value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrapeziumProfileDef_BottomXDimAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getBottomXDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTrapeziumProfileDef#getBottomXDimAsString <em>Bottom XDim As String</em>}' attribute.
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
	 * @see #setTopXDim(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrapeziumProfileDef_TopXDim()
	 * @model
	 * @generated
	 */
	double getTopXDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTrapeziumProfileDef#getTopXDim <em>Top XDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top XDim</em>' attribute.
	 * @see #getTopXDim()
	 * @generated
	 */
	void setTopXDim(double value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrapeziumProfileDef_TopXDimAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTopXDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTrapeziumProfileDef#getTopXDimAsString <em>Top XDim As String</em>}' attribute.
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
	 * @see #setYDim(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrapeziumProfileDef_YDim()
	 * @model
	 * @generated
	 */
	double getYDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTrapeziumProfileDef#getYDim <em>YDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YDim</em>' attribute.
	 * @see #getYDim()
	 * @generated
	 */
	void setYDim(double value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrapeziumProfileDef_YDimAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getYDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTrapeziumProfileDef#getYDimAsString <em>YDim As String</em>}' attribute.
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
	 * @see #setTopXOffset(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrapeziumProfileDef_TopXOffset()
	 * @model
	 * @generated
	 */
	double getTopXOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTrapeziumProfileDef#getTopXOffset <em>Top XOffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top XOffset</em>' attribute.
	 * @see #getTopXOffset()
	 * @generated
	 */
	void setTopXOffset(double value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTrapeziumProfileDef_TopXOffsetAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTopXOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTrapeziumProfileDef#getTopXOffsetAsString <em>Top XOffset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top XOffset As String</em>' attribute.
	 * @see #getTopXOffsetAsString()
	 * @generated
	 */
	void setTopXOffsetAsString(String value);

} // IfcTrapeziumProfileDef
