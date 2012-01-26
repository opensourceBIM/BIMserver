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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Texture Coordinate Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextureCoordinateGenerator#getMode <em>Mode</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextureCoordinateGenerator#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextureCoordinateGenerator()
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
	 * @see #isSetMode()
	 * @see #unsetMode()
	 * @see #setMode(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextureCoordinateGenerator_Mode()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextureCoordinateGenerator#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #isSetMode()
	 * @see #unsetMode()
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextureCoordinateGenerator#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMode()
	 * @see #getMode()
	 * @see #setMode(String)
	 * @generated
	 */
	void unsetMode();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTextureCoordinateGenerator#getMode <em>Mode</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mode</em>' attribute is set.
	 * @see #unsetMode()
	 * @see #getMode()
	 * @see #setMode(String)
	 * @generated
	 */
	boolean isSetMode();

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcSimpleValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference list.
	 * @see #isSetParameter()
	 * @see #unsetParameter()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextureCoordinateGenerator_Parameter()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcSimpleValue> getParameter();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextureCoordinateGenerator#getParameter <em>Parameter</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParameter()
	 * @see #getParameter()
	 * @generated
	 */
	void unsetParameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTextureCoordinateGenerator#getParameter <em>Parameter</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parameter</em>' reference list is set.
	 * @see #unsetParameter()
	 * @see #getParameter()
	 * @generated
	 */
	boolean isSetParameter();

} // IfcTextureCoordinateGenerator
