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

public interface IfcRelAssignsToActor extends IfcRelAssigns {
	/**
	 * Returns the value of the '<em><b>Relating Actor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcActor#getIsActingUpon <em>Is Acting Upon</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Actor</em>' reference.
	 * @see #setRelatingActor(IfcActor)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRelAssignsToActor_RelatingActor()
	 * @see org.bimserver.models.ifc2x3tc1.IfcActor#getIsActingUpon
	 * @model opposite="IsActingUpon"
	 * @generated
	 */
	IfcActor getRelatingActor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRelAssignsToActor#getRelatingActor <em>Relating Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Actor</em>' reference.
	 * @see #getRelatingActor()
	 * @generated
	 */
	void setRelatingActor(IfcActor value);

	/**
	 * Returns the value of the '<em><b>Acting Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acting Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acting Role</em>' reference.
	 * @see #isSetActingRole()
	 * @see #unsetActingRole()
	 * @see #setActingRole(IfcActorRole)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRelAssignsToActor_ActingRole()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorRole getActingRole();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRelAssignsToActor#getActingRole <em>Acting Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acting Role</em>' reference.
	 * @see #isSetActingRole()
	 * @see #unsetActingRole()
	 * @see #getActingRole()
	 * @generated
	 */
	void setActingRole(IfcActorRole value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRelAssignsToActor#getActingRole <em>Acting Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActingRole()
	 * @see #getActingRole()
	 * @see #setActingRole(IfcActorRole)
	 * @generated
	 */
	void unsetActingRole();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRelAssignsToActor#getActingRole <em>Acting Role</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Acting Role</em>' reference is set.
	 * @see #unsetActingRole()
	 * @see #getActingRole()
	 * @see #setActingRole(IfcActorRole)
	 * @generated
	 */
	boolean isSetActingRole();

} // IfcRelAssignsToActor
