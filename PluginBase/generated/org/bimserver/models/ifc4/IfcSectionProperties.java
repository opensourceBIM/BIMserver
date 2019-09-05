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

public interface IfcSectionProperties extends IfcPreDefinedProperties {
	/**
	 * Returns the value of the '<em><b>Section Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcSectionTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcSectionTypeEnum
	 * @see #setSectionType(IfcSectionTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionProperties_SectionType()
	 * @model
	 * @generated
	 */
	IfcSectionTypeEnum getSectionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSectionProperties#getSectionType <em>Section Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcSectionTypeEnum
	 * @see #getSectionType()
	 * @generated
	 */
	void setSectionType(IfcSectionTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Start Profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Profile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Profile</em>' reference.
	 * @see #setStartProfile(IfcProfileDef)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionProperties_StartProfile()
	 * @model
	 * @generated
	 */
	IfcProfileDef getStartProfile();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSectionProperties#getStartProfile <em>Start Profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Profile</em>' reference.
	 * @see #getStartProfile()
	 * @generated
	 */
	void setStartProfile(IfcProfileDef value);

	/**
	 * Returns the value of the '<em><b>End Profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Profile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Profile</em>' reference.
	 * @see #isSetEndProfile()
	 * @see #unsetEndProfile()
	 * @see #setEndProfile(IfcProfileDef)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionProperties_EndProfile()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcProfileDef getEndProfile();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSectionProperties#getEndProfile <em>End Profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Profile</em>' reference.
	 * @see #isSetEndProfile()
	 * @see #unsetEndProfile()
	 * @see #getEndProfile()
	 * @generated
	 */
	void setEndProfile(IfcProfileDef value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSectionProperties#getEndProfile <em>End Profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndProfile()
	 * @see #getEndProfile()
	 * @see #setEndProfile(IfcProfileDef)
	 * @generated
	 */
	void unsetEndProfile();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSectionProperties#getEndProfile <em>End Profile</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>End Profile</em>' reference is set.
	 * @see #unsetEndProfile()
	 * @see #getEndProfile()
	 * @see #setEndProfile(IfcProfileDef)
	 * @generated
	 */
	boolean isSetEndProfile();

} // IfcSectionProperties
