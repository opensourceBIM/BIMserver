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

public interface IfcLaborResource extends IfcConstructionResource {
	/**
	 * Returns the value of the '<em><b>Skill Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Skill Set</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skill Set</em>' attribute.
	 * @see #isSetSkillSet()
	 * @see #unsetSkillSet()
	 * @see #setSkillSet(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLaborResource_SkillSet()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSkillSet();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLaborResource#getSkillSet <em>Skill Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skill Set</em>' attribute.
	 * @see #isSetSkillSet()
	 * @see #unsetSkillSet()
	 * @see #getSkillSet()
	 * @generated
	 */
	void setSkillSet(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLaborResource#getSkillSet <em>Skill Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSkillSet()
	 * @see #getSkillSet()
	 * @see #setSkillSet(String)
	 * @generated
	 */
	void unsetSkillSet();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLaborResource#getSkillSet <em>Skill Set</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Skill Set</em>' attribute is set.
	 * @see #unsetSkillSet()
	 * @see #getSkillSet()
	 * @see #setSkillSet(String)
	 * @generated
	 */
	boolean isSetSkillSet();

} // IfcLaborResource
