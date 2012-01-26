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
	 * @see #isSetBottomXDim()
	 * @see #unsetBottomXDim()
	 * @see #setBottomXDim(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_BottomXDim()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBottomXDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getBottomXDim <em>Bottom XDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom XDim</em>' attribute.
	 * @see #isSetBottomXDim()
	 * @see #unsetBottomXDim()
	 * @see #getBottomXDim()
	 * @generated
	 */
	void setBottomXDim(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getBottomXDim <em>Bottom XDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomXDim()
	 * @see #getBottomXDim()
	 * @see #setBottomXDim(double)
	 * @generated
	 */
	void unsetBottomXDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getBottomXDim <em>Bottom XDim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom XDim</em>' attribute is set.
	 * @see #unsetBottomXDim()
	 * @see #getBottomXDim()
	 * @see #setBottomXDim(double)
	 * @generated
	 */
	boolean isSetBottomXDim();

	/**
	 * Returns the value of the '<em><b>Bottom XDim As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom XDim As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom XDim As String</em>' attribute.
	 * @see #isSetBottomXDimAsString()
	 * @see #unsetBottomXDimAsString()
	 * @see #setBottomXDimAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_BottomXDimAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBottomXDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getBottomXDimAsString <em>Bottom XDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom XDim As String</em>' attribute.
	 * @see #isSetBottomXDimAsString()
	 * @see #unsetBottomXDimAsString()
	 * @see #getBottomXDimAsString()
	 * @generated
	 */
	void setBottomXDimAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getBottomXDimAsString <em>Bottom XDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBottomXDimAsString()
	 * @see #getBottomXDimAsString()
	 * @see #setBottomXDimAsString(String)
	 * @generated
	 */
	void unsetBottomXDimAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getBottomXDimAsString <em>Bottom XDim As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bottom XDim As String</em>' attribute is set.
	 * @see #unsetBottomXDimAsString()
	 * @see #getBottomXDimAsString()
	 * @see #setBottomXDimAsString(String)
	 * @generated
	 */
	boolean isSetBottomXDimAsString();

	/**
	 * Returns the value of the '<em><b>Top XDim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top XDim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top XDim</em>' attribute.
	 * @see #isSetTopXDim()
	 * @see #unsetTopXDim()
	 * @see #setTopXDim(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_TopXDim()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTopXDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXDim <em>Top XDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top XDim</em>' attribute.
	 * @see #isSetTopXDim()
	 * @see #unsetTopXDim()
	 * @see #getTopXDim()
	 * @generated
	 */
	void setTopXDim(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXDim <em>Top XDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopXDim()
	 * @see #getTopXDim()
	 * @see #setTopXDim(double)
	 * @generated
	 */
	void unsetTopXDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXDim <em>Top XDim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top XDim</em>' attribute is set.
	 * @see #unsetTopXDim()
	 * @see #getTopXDim()
	 * @see #setTopXDim(double)
	 * @generated
	 */
	boolean isSetTopXDim();

	/**
	 * Returns the value of the '<em><b>Top XDim As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top XDim As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top XDim As String</em>' attribute.
	 * @see #isSetTopXDimAsString()
	 * @see #unsetTopXDimAsString()
	 * @see #setTopXDimAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_TopXDimAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTopXDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXDimAsString <em>Top XDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top XDim As String</em>' attribute.
	 * @see #isSetTopXDimAsString()
	 * @see #unsetTopXDimAsString()
	 * @see #getTopXDimAsString()
	 * @generated
	 */
	void setTopXDimAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXDimAsString <em>Top XDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopXDimAsString()
	 * @see #getTopXDimAsString()
	 * @see #setTopXDimAsString(String)
	 * @generated
	 */
	void unsetTopXDimAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXDimAsString <em>Top XDim As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top XDim As String</em>' attribute is set.
	 * @see #unsetTopXDimAsString()
	 * @see #getTopXDimAsString()
	 * @see #setTopXDimAsString(String)
	 * @generated
	 */
	boolean isSetTopXDimAsString();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_YDim()
	 * @model unsettable="true"
	 * @generated
	 */
	double getYDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getYDim <em>YDim</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getYDim <em>YDim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetYDim()
	 * @see #getYDim()
	 * @see #setYDim(double)
	 * @generated
	 */
	void unsetYDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getYDim <em>YDim</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_YDimAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getYDimAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getYDimAsString <em>YDim As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getYDimAsString <em>YDim As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetYDimAsString()
	 * @see #getYDimAsString()
	 * @see #setYDimAsString(String)
	 * @generated
	 */
	void unsetYDimAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getYDimAsString <em>YDim As String</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Top XOffset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top XOffset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top XOffset</em>' attribute.
	 * @see #isSetTopXOffset()
	 * @see #unsetTopXOffset()
	 * @see #setTopXOffset(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_TopXOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTopXOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXOffset <em>Top XOffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top XOffset</em>' attribute.
	 * @see #isSetTopXOffset()
	 * @see #unsetTopXOffset()
	 * @see #getTopXOffset()
	 * @generated
	 */
	void setTopXOffset(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXOffset <em>Top XOffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopXOffset()
	 * @see #getTopXOffset()
	 * @see #setTopXOffset(double)
	 * @generated
	 */
	void unsetTopXOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXOffset <em>Top XOffset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top XOffset</em>' attribute is set.
	 * @see #unsetTopXOffset()
	 * @see #getTopXOffset()
	 * @see #setTopXOffset(double)
	 * @generated
	 */
	boolean isSetTopXOffset();

	/**
	 * Returns the value of the '<em><b>Top XOffset As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top XOffset As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top XOffset As String</em>' attribute.
	 * @see #isSetTopXOffsetAsString()
	 * @see #unsetTopXOffsetAsString()
	 * @see #setTopXOffsetAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTrapeziumProfileDef_TopXOffsetAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTopXOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXOffsetAsString <em>Top XOffset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top XOffset As String</em>' attribute.
	 * @see #isSetTopXOffsetAsString()
	 * @see #unsetTopXOffsetAsString()
	 * @see #getTopXOffsetAsString()
	 * @generated
	 */
	void setTopXOffsetAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXOffsetAsString <em>Top XOffset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTopXOffsetAsString()
	 * @see #getTopXOffsetAsString()
	 * @see #setTopXOffsetAsString(String)
	 * @generated
	 */
	void unsetTopXOffsetAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef#getTopXOffsetAsString <em>Top XOffset As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Top XOffset As String</em>' attribute is set.
	 * @see #unsetTopXOffsetAsString()
	 * @see #getTopXOffsetAsString()
	 * @see #setTopXOffsetAsString(String)
	 * @generated
	 */
	boolean isSetTopXOffsetAsString();

} // IfcTrapeziumProfileDef
