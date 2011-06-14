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
 * A representation of the model object '<em><b>Ifc Cartesian Transformation Operator2 Dnon Uniform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator2DnonUniform#getScale2 <em>Scale2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator2DnonUniform#getScale2AsString <em>Scale2 As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianTransformationOperator2DnonUniform()
 * @model
 * @generated
 */
public interface IfcCartesianTransformationOperator2DnonUniform extends IfcCartesianTransformationOperator2D
{
	/**
	 * Returns the value of the '<em><b>Scale2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale2</em>' attribute.
	 * @see #setScale2(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianTransformationOperator2DnonUniform_Scale2()
	 * @model
	 * @generated
	 */
	float getScale2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator2DnonUniform#getScale2 <em>Scale2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale2</em>' attribute.
	 * @see #getScale2()
	 * @generated
	 */
	void setScale2(float value);

	/**
	 * Returns the value of the '<em><b>Scale2 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale2 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale2 As String</em>' attribute.
	 * @see #setScale2AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianTransformationOperator2DnonUniform_Scale2AsString()
	 * @model
	 * @generated
	 */
	String getScale2AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator2DnonUniform#getScale2AsString <em>Scale2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale2 As String</em>' attribute.
	 * @see #getScale2AsString()
	 * @generated
	 */
	void setScale2AsString(String value);

} // IfcCartesianTransformationOperator2DnonUniform
