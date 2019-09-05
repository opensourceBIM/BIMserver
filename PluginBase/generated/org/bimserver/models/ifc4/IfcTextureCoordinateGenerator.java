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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Texture Coordinate Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcTextureCoordinateGenerator#getMode <em>Mode</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTextureCoordinateGenerator#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTextureCoordinateGenerator#getParameterAsString <em>Parameter As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTextureCoordinateGenerator()
 * @model
 * @generated
 */
public interface IfcTextureCoordinateGenerator extends IfcTextureCoordinate {
	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTextureCoordinateGenerator_Mode()
	 * @model
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTextureCoordinateGenerator#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' attribute list.
	 * @see #isSetParameter()
	 * @see #unsetParameter()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTextureCoordinateGenerator_Parameter()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Double> getParameter();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTextureCoordinateGenerator#getParameter <em>Parameter</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParameter()
	 * @see #getParameter()
	 * @generated
	 */
	void unsetParameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTextureCoordinateGenerator#getParameter <em>Parameter</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parameter</em>' attribute list is set.
	 * @see #unsetParameter()
	 * @see #getParameter()
	 * @generated
	 */
	boolean isSetParameter();

	/**
	 * Returns the value of the '<em><b>Parameter As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter As String</em>' attribute list.
	 * @see #isSetParameterAsString()
	 * @see #unsetParameterAsString()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTextureCoordinateGenerator_ParameterAsString()
	 * @model unique="false" unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getParameterAsString();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTextureCoordinateGenerator#getParameterAsString <em>Parameter As String</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParameterAsString()
	 * @see #getParameterAsString()
	 * @generated
	 */
	void unsetParameterAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTextureCoordinateGenerator#getParameterAsString <em>Parameter As String</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parameter As String</em>' attribute list is set.
	 * @see #unsetParameterAsString()
	 * @see #getParameterAsString()
	 * @generated
	 */
	boolean isSetParameterAsString();

} // IfcTextureCoordinateGenerator
