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

public interface IfcCartesianTransformationOperator2DnonUniform extends IfcCartesianTransformationOperator2D {
	/**
	 * Returns the value of the '<em><b>Scale2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale2</em>' attribute.
	 * @see #isSetScale2()
	 * @see #unsetScale2()
	 * @see #setScale2(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCartesianTransformationOperator2DnonUniform_Scale2()
	 * @model unsettable="true"
	 * @generated
	 */
	double getScale2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScale2 <em>Scale2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale2</em>' attribute.
	 * @see #isSetScale2()
	 * @see #unsetScale2()
	 * @see #getScale2()
	 * @generated
	 */
	void setScale2(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScale2 <em>Scale2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScale2()
	 * @see #getScale2()
	 * @see #setScale2(double)
	 * @generated
	 */
	void unsetScale2();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScale2 <em>Scale2</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Scale2</em>' attribute is set.
	 * @see #unsetScale2()
	 * @see #getScale2()
	 * @see #setScale2(double)
	 * @generated
	 */
	boolean isSetScale2();

	/**
	 * Returns the value of the '<em><b>Scale2 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale2 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale2 As String</em>' attribute.
	 * @see #isSetScale2AsString()
	 * @see #unsetScale2AsString()
	 * @see #setScale2AsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCartesianTransformationOperator2DnonUniform_Scale2AsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getScale2AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScale2AsString <em>Scale2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale2 As String</em>' attribute.
	 * @see #isSetScale2AsString()
	 * @see #unsetScale2AsString()
	 * @see #getScale2AsString()
	 * @generated
	 */
	void setScale2AsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScale2AsString <em>Scale2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScale2AsString()
	 * @see #getScale2AsString()
	 * @see #setScale2AsString(String)
	 * @generated
	 */
	void unsetScale2AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScale2AsString <em>Scale2 As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Scale2 As String</em>' attribute is set.
	 * @see #unsetScale2AsString()
	 * @see #getScale2AsString()
	 * @see #setScale2AsString(String)
	 * @generated
	 */
	boolean isSetScale2AsString();

	/**
	 * Returns the value of the '<em><b>Scl2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scl2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scl2</em>' attribute.
	 * @see #isSetScl2()
	 * @see #unsetScl2()
	 * @see #setScl2(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCartesianTransformationOperator2DnonUniform_Scl2()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	double getScl2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScl2 <em>Scl2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scl2</em>' attribute.
	 * @see #isSetScl2()
	 * @see #unsetScl2()
	 * @see #getScl2()
	 * @generated
	 */
	void setScl2(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScl2 <em>Scl2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScl2()
	 * @see #getScl2()
	 * @see #setScl2(double)
	 * @generated
	 */
	void unsetScl2();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScl2 <em>Scl2</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Scl2</em>' attribute is set.
	 * @see #unsetScl2()
	 * @see #getScl2()
	 * @see #setScl2(double)
	 * @generated
	 */
	boolean isSetScl2();

	/**
	 * Returns the value of the '<em><b>Scl2 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scl2 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scl2 As String</em>' attribute.
	 * @see #isSetScl2AsString()
	 * @see #unsetScl2AsString()
	 * @see #setScl2AsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCartesianTransformationOperator2DnonUniform_Scl2AsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getScl2AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScl2AsString <em>Scl2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scl2 As String</em>' attribute.
	 * @see #isSetScl2AsString()
	 * @see #unsetScl2AsString()
	 * @see #getScl2AsString()
	 * @generated
	 */
	void setScl2AsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScl2AsString <em>Scl2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScl2AsString()
	 * @see #getScl2AsString()
	 * @see #setScl2AsString(String)
	 * @generated
	 */
	void unsetScl2AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform#getScl2AsString <em>Scl2 As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Scl2 As String</em>' attribute is set.
	 * @see #unsetScl2AsString()
	 * @see #getScl2AsString()
	 * @see #setScl2AsString(String)
	 * @generated
	 */
	boolean isSetScl2AsString();

} // IfcCartesianTransformationOperator2DnonUniform
