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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Light Distribution Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLightDistributionData#getMainPlaneAngle <em>Main Plane Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLightDistributionData#getMainPlaneAngleAsString <em>Main Plane Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLightDistributionData#getSecondaryPlaneAngle <em>Secondary Plane Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLightDistributionData#getSecondaryPlaneAngleAsString <em>Secondary Plane Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLightDistributionData#getLuminousIntensity <em>Luminous Intensity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLightDistributionData#getLuminousIntensityAsString <em>Luminous Intensity As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightDistributionData()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcLightDistributionData extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Main Plane Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Plane Angle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Plane Angle</em>' attribute.
	 * @see #setMainPlaneAngle(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightDistributionData_MainPlaneAngle()
	 * @model
	 * @generated
	 */
	double getMainPlaneAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightDistributionData#getMainPlaneAngle <em>Main Plane Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Plane Angle</em>' attribute.
	 * @see #getMainPlaneAngle()
	 * @generated
	 */
	void setMainPlaneAngle(double value);

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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightDistributionData_MainPlaneAngleAsString()
	 * @model
	 * @generated
	 */
	String getMainPlaneAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLightDistributionData#getMainPlaneAngleAsString <em>Main Plane Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Plane Angle As String</em>' attribute.
	 * @see #getMainPlaneAngleAsString()
	 * @generated
	 */
	void setMainPlaneAngleAsString(String value);

	/**
	 * Returns the value of the '<em><b>Secondary Plane Angle</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Plane Angle</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Plane Angle</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightDistributionData_SecondaryPlaneAngle()
	 * @model unique="false"
	 * @generated
	 */
	EList<Double> getSecondaryPlaneAngle();

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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightDistributionData_SecondaryPlaneAngleAsString()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getSecondaryPlaneAngleAsString();

	/**
	 * Returns the value of the '<em><b>Luminous Intensity</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Luminous Intensity</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Luminous Intensity</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightDistributionData_LuminousIntensity()
	 * @model unique="false"
	 * @generated
	 */
	EList<Double> getLuminousIntensity();

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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLightDistributionData_LuminousIntensityAsString()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getLuminousIntensityAsString();

} // IfcLightDistributionData
