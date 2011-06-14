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
 * A representation of the model object '<em><b>Ifc Labor Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLaborResource#getSkillSet <em>Skill Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLaborResource()
 * @model
 * @generated
 */
public interface IfcLaborResource extends IfcConstructionResource
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLaborResource_SkillSet()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSkillSet();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLaborResource#getSkillSet <em>Skill Set</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLaborResource#getSkillSet <em>Skill Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSkillSet()
	 * @see #getSkillSet()
	 * @see #setSkillSet(String)
	 * @generated
	 */
	void unsetSkillSet();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLaborResource#getSkillSet <em>Skill Set</em>}' attribute is set.
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
