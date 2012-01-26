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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Quantity Volume</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityVolume#getVolumeValue <em>Volume Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityVolume#getVolumeValueAsString <em>Volume Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityVolume()
 * @model
 * @generated
 */
public interface IfcQuantityVolume extends IfcPhysicalSimpleQuantity {
	/**
	 * Returns the value of the '<em><b>Volume Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume Value</em>' attribute.
	 * @see #isSetVolumeValue()
	 * @see #unsetVolumeValue()
	 * @see #setVolumeValue(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityVolume_VolumeValue()
	 * @model unsettable="true"
	 * @generated
	 */
	double getVolumeValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityVolume#getVolumeValue <em>Volume Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume Value</em>' attribute.
	 * @see #isSetVolumeValue()
	 * @see #unsetVolumeValue()
	 * @see #getVolumeValue()
	 * @generated
	 */
	void setVolumeValue(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityVolume#getVolumeValue <em>Volume Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVolumeValue()
	 * @see #getVolumeValue()
	 * @see #setVolumeValue(double)
	 * @generated
	 */
	void unsetVolumeValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityVolume#getVolumeValue <em>Volume Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Volume Value</em>' attribute is set.
	 * @see #unsetVolumeValue()
	 * @see #getVolumeValue()
	 * @see #setVolumeValue(double)
	 * @generated
	 */
	boolean isSetVolumeValue();

	/**
	 * Returns the value of the '<em><b>Volume Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume Value As String</em>' attribute.
	 * @see #isSetVolumeValueAsString()
	 * @see #unsetVolumeValueAsString()
	 * @see #setVolumeValueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityVolume_VolumeValueAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVolumeValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityVolume#getVolumeValueAsString <em>Volume Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume Value As String</em>' attribute.
	 * @see #isSetVolumeValueAsString()
	 * @see #unsetVolumeValueAsString()
	 * @see #getVolumeValueAsString()
	 * @generated
	 */
	void setVolumeValueAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityVolume#getVolumeValueAsString <em>Volume Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVolumeValueAsString()
	 * @see #getVolumeValueAsString()
	 * @see #setVolumeValueAsString(String)
	 * @generated
	 */
	void unsetVolumeValueAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityVolume#getVolumeValueAsString <em>Volume Value As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Volume Value As String</em>' attribute is set.
	 * @see #unsetVolumeValueAsString()
	 * @see #getVolumeValueAsString()
	 * @see #setVolumeValueAsString(String)
	 * @generated
	 */
	boolean isSetVolumeValueAsString();

} // IfcQuantityVolume
