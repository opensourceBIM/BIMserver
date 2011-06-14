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
 * A representation of the model object '<em><b>Ifc Building Storey</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBuildingStorey#getElevation <em>Elevation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBuildingStorey#getElevationAsString <em>Elevation As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBuildingStorey()
 * @model
 * @generated
 */
public interface IfcBuildingStorey extends IfcSpatialStructureElement
{
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
	 * @see #setElevation(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBuildingStorey_Elevation()
	 * @model unsettable="true"
	 * @generated
	 */
	float getElevation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuildingStorey#getElevation <em>Elevation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation</em>' attribute.
	 * @see #isSetElevation()
	 * @see #unsetElevation()
	 * @see #getElevation()
	 * @generated
	 */
	void setElevation(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuildingStorey#getElevation <em>Elevation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevation()
	 * @see #getElevation()
	 * @see #setElevation(float)
	 * @generated
	 */
	void unsetElevation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBuildingStorey#getElevation <em>Elevation</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elevation</em>' attribute is set.
	 * @see #unsetElevation()
	 * @see #getElevation()
	 * @see #setElevation(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBuildingStorey_ElevationAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getElevationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuildingStorey#getElevationAsString <em>Elevation As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuildingStorey#getElevationAsString <em>Elevation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationAsString()
	 * @see #getElevationAsString()
	 * @see #setElevationAsString(String)
	 * @generated
	 */
	void unsetElevationAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBuildingStorey#getElevationAsString <em>Elevation As String</em>}' attribute is set.
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
