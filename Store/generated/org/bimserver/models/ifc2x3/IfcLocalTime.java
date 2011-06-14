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
 * A representation of the model object '<em><b>Ifc Local Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLocalTime#getHourComponent <em>Hour Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLocalTime#getMinuteComponent <em>Minute Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLocalTime#getSecondComponent <em>Second Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLocalTime#getSecondComponentAsString <em>Second Component As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLocalTime#getZone <em>Zone</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLocalTime#getDaylightSavingOffset <em>Daylight Saving Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLocalTime()
 * @model
 * @generated
 */
public interface IfcLocalTime extends IfcDateTimeSelect, IfcObjectReferenceSelect
{
	/**
	 * Returns the value of the '<em><b>Hour Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hour Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hour Component</em>' attribute.
	 * @see #setHourComponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLocalTime_HourComponent()
	 * @model
	 * @generated
	 */
	int getHourComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getHourComponent <em>Hour Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hour Component</em>' attribute.
	 * @see #getHourComponent()
	 * @generated
	 */
	void setHourComponent(int value);

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
	 * @see #setMinuteComponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLocalTime_MinuteComponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getMinuteComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getMinuteComponent <em>Minute Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minute Component</em>' attribute.
	 * @see #isSetMinuteComponent()
	 * @see #unsetMinuteComponent()
	 * @see #getMinuteComponent()
	 * @generated
	 */
	void setMinuteComponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getMinuteComponent <em>Minute Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinuteComponent()
	 * @see #getMinuteComponent()
	 * @see #setMinuteComponent(int)
	 * @generated
	 */
	void unsetMinuteComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getMinuteComponent <em>Minute Component</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Minute Component</em>' attribute is set.
	 * @see #unsetMinuteComponent()
	 * @see #getMinuteComponent()
	 * @see #setMinuteComponent(int)
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
	 * @see #setSecondComponent(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLocalTime_SecondComponent()
	 * @model unsettable="true"
	 * @generated
	 */
	float getSecondComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getSecondComponent <em>Second Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Component</em>' attribute.
	 * @see #isSetSecondComponent()
	 * @see #unsetSecondComponent()
	 * @see #getSecondComponent()
	 * @generated
	 */
	void setSecondComponent(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getSecondComponent <em>Second Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondComponent()
	 * @see #getSecondComponent()
	 * @see #setSecondComponent(float)
	 * @generated
	 */
	void unsetSecondComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getSecondComponent <em>Second Component</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Second Component</em>' attribute is set.
	 * @see #unsetSecondComponent()
	 * @see #getSecondComponent()
	 * @see #setSecondComponent(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLocalTime_SecondComponentAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSecondComponentAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getSecondComponentAsString <em>Second Component As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getSecondComponentAsString <em>Second Component As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondComponentAsString()
	 * @see #getSecondComponentAsString()
	 * @see #setSecondComponentAsString(String)
	 * @generated
	 */
	void unsetSecondComponentAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getSecondComponentAsString <em>Second Component As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLocalTime_Zone()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCoordinatedUniversalTimeOffset getZone();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getZone <em>Zone</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getZone <em>Zone</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetZone()
	 * @see #getZone()
	 * @see #setZone(IfcCoordinatedUniversalTimeOffset)
	 * @generated
	 */
	void unsetZone();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getZone <em>Zone</em>}' reference is set.
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
	 * @see #setDaylightSavingOffset(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLocalTime_DaylightSavingOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	int getDaylightSavingOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getDaylightSavingOffset <em>Daylight Saving Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Daylight Saving Offset</em>' attribute.
	 * @see #isSetDaylightSavingOffset()
	 * @see #unsetDaylightSavingOffset()
	 * @see #getDaylightSavingOffset()
	 * @generated
	 */
	void setDaylightSavingOffset(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getDaylightSavingOffset <em>Daylight Saving Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDaylightSavingOffset()
	 * @see #getDaylightSavingOffset()
	 * @see #setDaylightSavingOffset(int)
	 * @generated
	 */
	void unsetDaylightSavingOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLocalTime#getDaylightSavingOffset <em>Daylight Saving Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Daylight Saving Offset</em>' attribute is set.
	 * @see #unsetDaylightSavingOffset()
	 * @see #getDaylightSavingOffset()
	 * @see #setDaylightSavingOffset(int)
	 * @generated
	 */
	boolean isSetDaylightSavingOffset();

} // IfcLocalTime
