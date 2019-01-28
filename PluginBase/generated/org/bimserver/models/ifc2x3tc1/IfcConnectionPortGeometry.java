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

public interface IfcConnectionPortGeometry extends IfcConnectionGeometry {
	/**
	 * Returns the value of the '<em><b>Location At Relating Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location At Relating Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location At Relating Element</em>' reference.
	 * @see #setLocationAtRelatingElement(IfcAxis2Placement)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConnectionPortGeometry_LocationAtRelatingElement()
	 * @model
	 * @generated
	 */
	IfcAxis2Placement getLocationAtRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPortGeometry#getLocationAtRelatingElement <em>Location At Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location At Relating Element</em>' reference.
	 * @see #getLocationAtRelatingElement()
	 * @generated
	 */
	void setLocationAtRelatingElement(IfcAxis2Placement value);

	/**
	 * Returns the value of the '<em><b>Location At Related Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location At Related Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location At Related Element</em>' reference.
	 * @see #isSetLocationAtRelatedElement()
	 * @see #unsetLocationAtRelatedElement()
	 * @see #setLocationAtRelatedElement(IfcAxis2Placement)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConnectionPortGeometry_LocationAtRelatedElement()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAxis2Placement getLocationAtRelatedElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPortGeometry#getLocationAtRelatedElement <em>Location At Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location At Related Element</em>' reference.
	 * @see #isSetLocationAtRelatedElement()
	 * @see #unsetLocationAtRelatedElement()
	 * @see #getLocationAtRelatedElement()
	 * @generated
	 */
	void setLocationAtRelatedElement(IfcAxis2Placement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPortGeometry#getLocationAtRelatedElement <em>Location At Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLocationAtRelatedElement()
	 * @see #getLocationAtRelatedElement()
	 * @see #setLocationAtRelatedElement(IfcAxis2Placement)
	 * @generated
	 */
	void unsetLocationAtRelatedElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPortGeometry#getLocationAtRelatedElement <em>Location At Related Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Location At Related Element</em>' reference is set.
	 * @see #unsetLocationAtRelatedElement()
	 * @see #getLocationAtRelatedElement()
	 * @see #setLocationAtRelatedElement(IfcAxis2Placement)
	 * @generated
	 */
	boolean isSetLocationAtRelatedElement();

	/**
	 * Returns the value of the '<em><b>Profile Of Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Of Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Of Port</em>' reference.
	 * @see #setProfileOfPort(IfcProfileDef)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcConnectionPortGeometry_ProfileOfPort()
	 * @model
	 * @generated
	 */
	IfcProfileDef getProfileOfPort();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcConnectionPortGeometry#getProfileOfPort <em>Profile Of Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Of Port</em>' reference.
	 * @see #getProfileOfPort()
	 * @generated
	 */
	void setProfileOfPort(IfcProfileDef value);

} // IfcConnectionPortGeometry
