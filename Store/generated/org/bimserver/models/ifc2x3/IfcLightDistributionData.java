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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Light Distribution Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getMainPlaneAngle <em>Main Plane Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getMainPlaneAngleAsString <em>Main Plane Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getSecondaryPlaneAngle <em>Secondary Plane Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getSecondaryPlaneAngleAsString <em>Secondary Plane Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getLuminousIntensity <em>Luminous Intensity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getLuminousIntensityAsString <em>Luminous Intensity As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcLightDistributionData extends IdEObject
{
	/**
	 * Returns the value of the '<em><b>Main Plane Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Plane Angle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Plane Angle</em>' attribute.
	 * @see #setMainPlaneAngle(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_MainPlaneAngle()
	 * @model
	 * @generated
	 */
	float getMainPlaneAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getMainPlaneAngle <em>Main Plane Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Plane Angle</em>' attribute.
	 * @see #getMainPlaneAngle()
	 * @generated
	 */
	void setMainPlaneAngle(float value);

	/**
	 * Returns the value of the '<em><b>Main Plane Angle As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Plane Angle As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Plane Angle As String</em>' attribute.
	 * @see #setMainPlaneAngleAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_MainPlaneAngleAsString()
	 * @model
	 * @generated
	 */
	String getMainPlaneAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getMainPlaneAngleAsString <em>Main Plane Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Plane Angle As String</em>' attribute.
	 * @see #getMainPlaneAngleAsString()
	 * @generated
	 */
	void setMainPlaneAngleAsString(String value);

	/**
	 * Returns the value of the '<em><b>Secondary Plane Angle</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Plane Angle</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Plane Angle</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_SecondaryPlaneAngle()
	 * @model unique="false"
	 * @generated
	 */
	EList<Float> getSecondaryPlaneAngle();

	/**
	 * Returns the value of the '<em><b>Secondary Plane Angle As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Plane Angle As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Plane Angle As String</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_SecondaryPlaneAngleAsString()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getSecondaryPlaneAngleAsString();

	/**
	 * Returns the value of the '<em><b>Luminous Intensity</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Luminous Intensity</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Luminous Intensity</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_LuminousIntensity()
	 * @model unique="false"
	 * @generated
	 */
	EList<Float> getLuminousIntensity();

	/**
	 * Returns the value of the '<em><b>Luminous Intensity As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Luminous Intensity As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Luminous Intensity As String</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_LuminousIntensityAsString()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getLuminousIntensityAsString();

} // IfcLightDistributionData
