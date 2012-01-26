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
	 * @see #isSetMainPlaneAngle()
	 * @see #unsetMainPlaneAngle()
	 * @see #setMainPlaneAngle(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_MainPlaneAngle()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMainPlaneAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getMainPlaneAngle <em>Main Plane Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Plane Angle</em>' attribute.
	 * @see #isSetMainPlaneAngle()
	 * @see #unsetMainPlaneAngle()
	 * @see #getMainPlaneAngle()
	 * @generated
	 */
	void setMainPlaneAngle(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getMainPlaneAngle <em>Main Plane Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMainPlaneAngle()
	 * @see #getMainPlaneAngle()
	 * @see #setMainPlaneAngle(double)
	 * @generated
	 */
	void unsetMainPlaneAngle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getMainPlaneAngle <em>Main Plane Angle</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Main Plane Angle</em>' attribute is set.
	 * @see #unsetMainPlaneAngle()
	 * @see #getMainPlaneAngle()
	 * @see #setMainPlaneAngle(double)
	 * @generated
	 */
	boolean isSetMainPlaneAngle();

	/**
	 * Returns the value of the '<em><b>Main Plane Angle As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Plane Angle As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Plane Angle As String</em>' attribute.
	 * @see #isSetMainPlaneAngleAsString()
	 * @see #unsetMainPlaneAngleAsString()
	 * @see #setMainPlaneAngleAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_MainPlaneAngleAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMainPlaneAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getMainPlaneAngleAsString <em>Main Plane Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Plane Angle As String</em>' attribute.
	 * @see #isSetMainPlaneAngleAsString()
	 * @see #unsetMainPlaneAngleAsString()
	 * @see #getMainPlaneAngleAsString()
	 * @generated
	 */
	void setMainPlaneAngleAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getMainPlaneAngleAsString <em>Main Plane Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMainPlaneAngleAsString()
	 * @see #getMainPlaneAngleAsString()
	 * @see #setMainPlaneAngleAsString(String)
	 * @generated
	 */
	void unsetMainPlaneAngleAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getMainPlaneAngleAsString <em>Main Plane Angle As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Main Plane Angle As String</em>' attribute is set.
	 * @see #unsetMainPlaneAngleAsString()
	 * @see #getMainPlaneAngleAsString()
	 * @see #setMainPlaneAngleAsString(String)
	 * @generated
	 */
	boolean isSetMainPlaneAngleAsString();

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
	 * @see #isSetSecondaryPlaneAngle()
	 * @see #unsetSecondaryPlaneAngle()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_SecondaryPlaneAngle()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Double> getSecondaryPlaneAngle();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getSecondaryPlaneAngle <em>Secondary Plane Angle</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondaryPlaneAngle()
	 * @see #getSecondaryPlaneAngle()
	 * @generated
	 */
	void unsetSecondaryPlaneAngle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getSecondaryPlaneAngle <em>Secondary Plane Angle</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Secondary Plane Angle</em>' attribute list is set.
	 * @see #unsetSecondaryPlaneAngle()
	 * @see #getSecondaryPlaneAngle()
	 * @generated
	 */
	boolean isSetSecondaryPlaneAngle();

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
	 * @see #isSetSecondaryPlaneAngleAsString()
	 * @see #unsetSecondaryPlaneAngleAsString()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_SecondaryPlaneAngleAsString()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getSecondaryPlaneAngleAsString();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getSecondaryPlaneAngleAsString <em>Secondary Plane Angle As String</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondaryPlaneAngleAsString()
	 * @see #getSecondaryPlaneAngleAsString()
	 * @generated
	 */
	void unsetSecondaryPlaneAngleAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getSecondaryPlaneAngleAsString <em>Secondary Plane Angle As String</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Secondary Plane Angle As String</em>' attribute list is set.
	 * @see #unsetSecondaryPlaneAngleAsString()
	 * @see #getSecondaryPlaneAngleAsString()
	 * @generated
	 */
	boolean isSetSecondaryPlaneAngleAsString();

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
	 * @see #isSetLuminousIntensity()
	 * @see #unsetLuminousIntensity()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_LuminousIntensity()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Double> getLuminousIntensity();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getLuminousIntensity <em>Luminous Intensity</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLuminousIntensity()
	 * @see #getLuminousIntensity()
	 * @generated
	 */
	void unsetLuminousIntensity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getLuminousIntensity <em>Luminous Intensity</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Luminous Intensity</em>' attribute list is set.
	 * @see #unsetLuminousIntensity()
	 * @see #getLuminousIntensity()
	 * @generated
	 */
	boolean isSetLuminousIntensity();

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
	 * @see #isSetLuminousIntensityAsString()
	 * @see #unsetLuminousIntensityAsString()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightDistributionData_LuminousIntensityAsString()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getLuminousIntensityAsString();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getLuminousIntensityAsString <em>Luminous Intensity As String</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLuminousIntensityAsString()
	 * @see #getLuminousIntensityAsString()
	 * @generated
	 */
	void unsetLuminousIntensityAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightDistributionData#getLuminousIntensityAsString <em>Luminous Intensity As String</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Luminous Intensity As String</em>' attribute list is set.
	 * @see #unsetLuminousIntensityAsString()
	 * @see #getLuminousIntensityAsString()
	 * @generated
	 */
	boolean isSetLuminousIntensityAsString();

} // IfcLightDistributionData
