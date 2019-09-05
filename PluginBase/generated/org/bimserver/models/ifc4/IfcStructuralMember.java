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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Structural Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcStructuralMember#getConnectedBy <em>Connected By</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralMember()
 * @model
 * @generated
 */
public interface IfcStructuralMember extends IfcStructuralItem {
	/**
	 * Returns the value of the '<em><b>Connected By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getRelatingStructuralMember <em>Relating Structural Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected By</em>' reference list.
	 * @see #isSetConnectedBy()
	 * @see #unsetConnectedBy()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralMember_ConnectedBy()
	 * @see org.bimserver.models.ifc4.IfcRelConnectsStructuralMember#getRelatingStructuralMember
	 * @model opposite="RelatingStructuralMember" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelConnectsStructuralMember> getConnectedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralMember#getConnectedBy <em>Connected By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConnectedBy()
	 * @see #getConnectedBy()
	 * @generated
	 */
	void unsetConnectedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralMember#getConnectedBy <em>Connected By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Connected By</em>' reference list is set.
	 * @see #unsetConnectedBy()
	 * @see #getConnectedBy()
	 * @generated
	 */
	boolean isSetConnectedBy();

} // IfcStructuralMember
