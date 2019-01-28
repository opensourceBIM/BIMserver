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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcActor#getTheActor <em>The Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcActor#getIsActingUpon <em>Is Acting Upon</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcActor()
 * @model
 * @generated
 */
public interface IfcActor extends IfcObject {
	/**
	 * Returns the value of the '<em><b>The Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Actor</em>' reference.
	 * @see #setTheActor(IfcActorSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcActor_TheActor()
	 * @model
	 * @generated
	 */
	IfcActorSelect getTheActor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcActor#getTheActor <em>The Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Actor</em>' reference.
	 * @see #getTheActor()
	 * @generated
	 */
	void setTheActor(IfcActorSelect value);

	/**
	 * Returns the value of the '<em><b>Is Acting Upon</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelAssignsToActor}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelAssignsToActor#getRelatingActor <em>Relating Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Acting Upon</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Acting Upon</em>' reference list.
	 * @see #isSetIsActingUpon()
	 * @see #unsetIsActingUpon()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcActor_IsActingUpon()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelAssignsToActor#getRelatingActor
	 * @model opposite="RelatingActor" unsettable="true"
	 * @generated
	 */
	EList<IfcRelAssignsToActor> getIsActingUpon();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcActor#getIsActingUpon <em>Is Acting Upon</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsActingUpon()
	 * @see #getIsActingUpon()
	 * @generated
	 */
	void unsetIsActingUpon();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcActor#getIsActingUpon <em>Is Acting Upon</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Acting Upon</em>' reference list is set.
	 * @see #unsetIsActingUpon()
	 * @see #getIsActingUpon()
	 * @generated
	 */
	boolean isSetIsActingUpon();

} // IfcActor
