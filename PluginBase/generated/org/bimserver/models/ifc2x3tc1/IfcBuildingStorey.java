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

public interface IfcBuildingStorey extends IfcSpatialStructureElement {
	/**
	 * Returns the value of the '<em><b>Elevation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elevation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elevation</em>' attribute.
	 * @see #isSetElevation()
	 * @see #unsetElevation()
	 * @see #setElevation(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBuildingStorey_Elevation()
	 * @model unsettable="true"
	 * @generated
	 */
	double getElevation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBuildingStorey#getElevation <em>Elevation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation</em>' attribute.
	 * @see #isSetElevation()
	 * @see #unsetElevation()
	 * @see #getElevation()
	 * @generated
	 */
	void setElevation(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBuildingStorey#getElevation <em>Elevation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevation()
	 * @see #getElevation()
	 * @see #setElevation(double)
	 * @generated
	 */
	void unsetElevation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBuildingStorey#getElevation <em>Elevation</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elevation</em>' attribute is set.
	 * @see #unsetElevation()
	 * @see #getElevation()
	 * @see #setElevation(double)
	 * @generated
	 */
	boolean isSetElevation();

	/**
	 * Returns the value of the '<em><b>Elevation As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elevation As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elevation As String</em>' attribute.
	 * @see #isSetElevationAsString()
	 * @see #unsetElevationAsString()
	 * @see #setElevationAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBuildingStorey_ElevationAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getElevationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBuildingStorey#getElevationAsString <em>Elevation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation As String</em>' attribute.
	 * @see #isSetElevationAsString()
	 * @see #unsetElevationAsString()
	 * @see #getElevationAsString()
	 * @generated
	 */
	void setElevationAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBuildingStorey#getElevationAsString <em>Elevation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationAsString()
	 * @see #getElevationAsString()
	 * @see #setElevationAsString(String)
	 * @generated
	 */
	void unsetElevationAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBuildingStorey#getElevationAsString <em>Elevation As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elevation As String</em>' attribute is set.
	 * @see #unsetElevationAsString()
	 * @see #getElevationAsString()
	 * @see #setElevationAsString(String)
	 * @generated
	 */
	boolean isSetElevationAsString();

} // IfcBuildingStorey
