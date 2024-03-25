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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcProfileProperties#getProfileDefinition <em>Profile Definition</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcProfileProperties()
 * @model
 * @generated
 */
public interface IfcProfileProperties extends IfcExtendedProperties {
	/**
	 * Returns the value of the '<em><b>Profile Definition</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcProfileDef#getHasProperties <em>Has Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Definition</em>' reference.
	 * @see #setProfileDefinition(IfcProfileDef)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcProfileProperties_ProfileDefinition()
	 * @see org.bimserver.models.ifc4x3.IfcProfileDef#getHasProperties
	 * @model opposite="HasProperties"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcProfileDef getProfileDefinition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcProfileProperties#getProfileDefinition <em>Profile Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Definition</em>' reference.
	 * @see #getProfileDefinition()
	 * @generated
	 */
	void setProfileDefinition(IfcProfileDef value);

} // IfcProfileProperties
