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

public interface IfcSweptDiskSolidPolygonal extends IfcSweptDiskSolid {
	/**
	 * Returns the value of the '<em><b>Fillet Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fillet Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fillet Radius</em>' attribute.
	 * @see #isSetFilletRadius()
	 * @see #unsetFilletRadius()
	 * @see #setFilletRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptDiskSolidPolygonal_FilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolidPolygonal#getFilletRadius <em>Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fillet Radius</em>' attribute.
	 * @see #isSetFilletRadius()
	 * @see #unsetFilletRadius()
	 * @see #getFilletRadius()
	 * @generated
	 */
	void setFilletRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolidPolygonal#getFilletRadius <em>Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadius()
	 * @see #getFilletRadius()
	 * @see #setFilletRadius(double)
	 * @generated
	 */
	void unsetFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolidPolygonal#getFilletRadius <em>Fillet Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fillet Radius</em>' attribute is set.
	 * @see #unsetFilletRadius()
	 * @see #getFilletRadius()
	 * @see #setFilletRadius(double)
	 * @generated
	 */
	boolean isSetFilletRadius();

	/**
	 * Returns the value of the '<em><b>Fillet Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fillet Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fillet Radius As String</em>' attribute.
	 * @see #isSetFilletRadiusAsString()
	 * @see #unsetFilletRadiusAsString()
	 * @see #setFilletRadiusAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptDiskSolidPolygonal_FilletRadiusAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolidPolygonal#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fillet Radius As String</em>' attribute.
	 * @see #isSetFilletRadiusAsString()
	 * @see #unsetFilletRadiusAsString()
	 * @see #getFilletRadiusAsString()
	 * @generated
	 */
	void setFilletRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolidPolygonal#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilletRadiusAsString()
	 * @see #getFilletRadiusAsString()
	 * @see #setFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolidPolygonal#getFilletRadiusAsString <em>Fillet Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fillet Radius As String</em>' attribute is set.
	 * @see #unsetFilletRadiusAsString()
	 * @see #getFilletRadiusAsString()
	 * @see #setFilletRadiusAsString(String)
	 * @generated
	 */
	boolean isSetFilletRadiusAsString();

} // IfcSweptDiskSolidPolygonal
