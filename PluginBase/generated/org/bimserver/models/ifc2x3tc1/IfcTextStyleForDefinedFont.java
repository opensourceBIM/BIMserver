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

public interface IfcTextStyleForDefinedFont extends IfcCharacterStyleSelect {
	/**
	 * Returns the value of the '<em><b>Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colour</em>' reference.
	 * @see #setColour(IfcColour)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleForDefinedFont_Colour()
	 * @model
	 * @generated
	 */
	IfcColour getColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleForDefinedFont#getColour <em>Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colour</em>' reference.
	 * @see #getColour()
	 * @generated
	 */
	void setColour(IfcColour value);

	/**
	 * Returns the value of the '<em><b>Background Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Colour</em>' reference.
	 * @see #isSetBackgroundColour()
	 * @see #unsetBackgroundColour()
	 * @see #setBackgroundColour(IfcColour)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleForDefinedFont_BackgroundColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColour getBackgroundColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleForDefinedFont#getBackgroundColour <em>Background Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Colour</em>' reference.
	 * @see #isSetBackgroundColour()
	 * @see #unsetBackgroundColour()
	 * @see #getBackgroundColour()
	 * @generated
	 */
	void setBackgroundColour(IfcColour value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleForDefinedFont#getBackgroundColour <em>Background Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBackgroundColour()
	 * @see #getBackgroundColour()
	 * @see #setBackgroundColour(IfcColour)
	 * @generated
	 */
	void unsetBackgroundColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleForDefinedFont#getBackgroundColour <em>Background Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Background Colour</em>' reference is set.
	 * @see #unsetBackgroundColour()
	 * @see #getBackgroundColour()
	 * @see #setBackgroundColour(IfcColour)
	 * @generated
	 */
	boolean isSetBackgroundColour();

} // IfcTextStyleForDefinedFont
