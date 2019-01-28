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

public interface IfcLocalTime extends IfcDateTimeSelect, IfcObjectReferenceSelect {
	/**
	 * Returns the value of the '<em><b>Hour Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hour Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hour Component</em>' attribute.
	 * @see #setHourComponent(long)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLocalTime_HourComponent()
	 * @model
	 * @generated
	 */
	long getHourComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getHourComponent <em>Hour Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hour Component</em>' attribute.
	 * @see #getHourComponent()
	 * @generated
	 */
	void setHourComponent(long value);

	/**
	 * Returns the value of the '<em><b>Minute Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minute Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minute Component</em>' attribute.
	 * @see #isSetMinuteComponent()
	 * @see #unsetMinuteComponent()
	 * @see #setMinuteComponent(long)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLocalTime_MinuteComponent()
	 * @model unsettable="true"
	 * @generated
	 */
	long getMinuteComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getMinuteComponent <em>Minute Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minute Component</em>' attribute.
	 * @see #isSetMinuteComponent()
	 * @see #unsetMinuteComponent()
	 * @see #getMinuteComponent()
	 * @generated
	 */
	void setMinuteComponent(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getMinuteComponent <em>Minute Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinuteComponent()
	 * @see #getMinuteComponent()
	 * @see #setMinuteComponent(long)
	 * @generated
	 */
	void unsetMinuteComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getMinuteComponent <em>Minute Component</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Minute Component</em>' attribute is set.
	 * @see #unsetMinuteComponent()
	 * @see #getMinuteComponent()
	 * @see #setMinuteComponent(long)
	 * @generated
	 */
	boolean isSetMinuteComponent();

	/**
	 * Returns the value of the '<em><b>Second Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Component</em>' attribute.
	 * @see #isSetSecondComponent()
	 * @see #unsetSecondComponent()
	 * @see #setSecondComponent(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLocalTime_SecondComponent()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSecondComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getSecondComponent <em>Second Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Component</em>' attribute.
	 * @see #isSetSecondComponent()
	 * @see #unsetSecondComponent()
	 * @see #getSecondComponent()
	 * @generated
	 */
	void setSecondComponent(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getSecondComponent <em>Second Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondComponent()
	 * @see #getSecondComponent()
	 * @see #setSecondComponent(double)
	 * @generated
	 */
	void unsetSecondComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getSecondComponent <em>Second Component</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Second Component</em>' attribute is set.
	 * @see #unsetSecondComponent()
	 * @see #getSecondComponent()
	 * @see #setSecondComponent(double)
	 * @generated
	 */
	boolean isSetSecondComponent();

	/**
	 * Returns the value of the '<em><b>Second Component As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Component As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Component As String</em>' attribute.
	 * @see #isSetSecondComponentAsString()
	 * @see #unsetSecondComponentAsString()
	 * @see #setSecondComponentAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLocalTime_SecondComponentAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSecondComponentAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getSecondComponentAsString <em>Second Component As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Component As String</em>' attribute.
	 * @see #isSetSecondComponentAsString()
	 * @see #unsetSecondComponentAsString()
	 * @see #getSecondComponentAsString()
	 * @generated
	 */
	void setSecondComponentAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getSecondComponentAsString <em>Second Component As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondComponentAsString()
	 * @see #getSecondComponentAsString()
	 * @see #setSecondComponentAsString(String)
	 * @generated
	 */
	void unsetSecondComponentAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getSecondComponentAsString <em>Second Component As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Second Component As String</em>' attribute is set.
	 * @see #unsetSecondComponentAsString()
	 * @see #getSecondComponentAsString()
	 * @see #setSecondComponentAsString(String)
	 * @generated
	 */
	boolean isSetSecondComponentAsString();

	/**
	 * Returns the value of the '<em><b>Zone</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zone</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zone</em>' reference.
	 * @see #isSetZone()
	 * @see #unsetZone()
	 * @see #setZone(IfcCoordinatedUniversalTimeOffset)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLocalTime_Zone()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCoordinatedUniversalTimeOffset getZone();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getZone <em>Zone</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zone</em>' reference.
	 * @see #isSetZone()
	 * @see #unsetZone()
	 * @see #getZone()
	 * @generated
	 */
	void setZone(IfcCoordinatedUniversalTimeOffset value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getZone <em>Zone</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetZone()
	 * @see #getZone()
	 * @see #setZone(IfcCoordinatedUniversalTimeOffset)
	 * @generated
	 */
	void unsetZone();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getZone <em>Zone</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Zone</em>' reference is set.
	 * @see #unsetZone()
	 * @see #getZone()
	 * @see #setZone(IfcCoordinatedUniversalTimeOffset)
	 * @generated
	 */
	boolean isSetZone();

	/**
	 * Returns the value of the '<em><b>Daylight Saving Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Daylight Saving Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Daylight Saving Offset</em>' attribute.
	 * @see #isSetDaylightSavingOffset()
	 * @see #unsetDaylightSavingOffset()
	 * @see #setDaylightSavingOffset(long)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLocalTime_DaylightSavingOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	long getDaylightSavingOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getDaylightSavingOffset <em>Daylight Saving Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Daylight Saving Offset</em>' attribute.
	 * @see #isSetDaylightSavingOffset()
	 * @see #unsetDaylightSavingOffset()
	 * @see #getDaylightSavingOffset()
	 * @generated
	 */
	void setDaylightSavingOffset(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getDaylightSavingOffset <em>Daylight Saving Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDaylightSavingOffset()
	 * @see #getDaylightSavingOffset()
	 * @see #setDaylightSavingOffset(long)
	 * @generated
	 */
	void unsetDaylightSavingOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalTime#getDaylightSavingOffset <em>Daylight Saving Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Daylight Saving Offset</em>' attribute is set.
	 * @see #unsetDaylightSavingOffset()
	 * @see #getDaylightSavingOffset()
	 * @see #setDaylightSavingOffset(long)
	 * @generated
	 */
	boolean isSetDaylightSavingOffset();

} // IfcLocalTime
