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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcCartesianTransformationOperator3DnonUniform extends IfcCartesianTransformationOperator3D {
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCartesianTransformationOperator3DnonUniform_Scale2()
	 * @model unsettable="true"
	 * @generated
	 */
	double getScale2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale2 <em>Scale2</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale2 <em>Scale2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScale2()
	 * @see #getScale2()
	 * @see #setScale2(double)
	 * @generated
	 */
	void unsetScale2();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale2 <em>Scale2</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCartesianTransformationOperator3DnonUniform_Scale2AsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScale2AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale2AsString <em>Scale2 As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale2AsString <em>Scale2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScale2AsString()
	 * @see #getScale2AsString()
	 * @see #setScale2AsString(String)
	 * @generated
	 */
	void unsetScale2AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale2AsString <em>Scale2 As String</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Scale3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale3</em>' attribute.
	 * @see #isSetScale3()
	 * @see #unsetScale3()
	 * @see #setScale3(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCartesianTransformationOperator3DnonUniform_Scale3()
	 * @model unsettable="true"
	 * @generated
	 */
	double getScale3();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale3 <em>Scale3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale3</em>' attribute.
	 * @see #isSetScale3()
	 * @see #unsetScale3()
	 * @see #getScale3()
	 * @generated
	 */
	void setScale3(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale3 <em>Scale3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScale3()
	 * @see #getScale3()
	 * @see #setScale3(double)
	 * @generated
	 */
	void unsetScale3();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale3 <em>Scale3</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Scale3</em>' attribute is set.
	 * @see #unsetScale3()
	 * @see #getScale3()
	 * @see #setScale3(double)
	 * @generated
	 */
	boolean isSetScale3();

	/**
	 * Returns the value of the '<em><b>Scale3 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale3 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale3 As String</em>' attribute.
	 * @see #isSetScale3AsString()
	 * @see #unsetScale3AsString()
	 * @see #setScale3AsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCartesianTransformationOperator3DnonUniform_Scale3AsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScale3AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale3AsString <em>Scale3 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale3 As String</em>' attribute.
	 * @see #isSetScale3AsString()
	 * @see #unsetScale3AsString()
	 * @see #getScale3AsString()
	 * @generated
	 */
	void setScale3AsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale3AsString <em>Scale3 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScale3AsString()
	 * @see #getScale3AsString()
	 * @see #setScale3AsString(String)
	 * @generated
	 */
	void unsetScale3AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform#getScale3AsString <em>Scale3 As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Scale3 As String</em>' attribute is set.
	 * @see #unsetScale3AsString()
	 * @see #getScale3AsString()
	 * @see #setScale3AsString(String)
	 * @generated
	 */
	boolean isSetScale3AsString();

} // IfcCartesianTransformationOperator3DnonUniform
