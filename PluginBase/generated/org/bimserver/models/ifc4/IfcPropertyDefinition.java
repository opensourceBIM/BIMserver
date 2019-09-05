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
 * A representation of the model object '<em><b>Ifc Property Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcPropertyDefinition#getHasContext <em>Has Context</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPropertyDefinition#getHasAssociations <em>Has Associations</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyDefinition()
 * @model
 * @generated
 */
public interface IfcPropertyDefinition extends IfcRoot, IfcDefinitionSelect {
	/**
	 * Returns the value of the '<em><b>Has Context</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelDeclares}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Context</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Context</em>' reference list.
	 * @see #isSetHasContext()
	 * @see #unsetHasContext()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyDefinition_HasContext()
	 * @model unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelDeclares> getHasContext();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyDefinition#getHasContext <em>Has Context</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasContext()
	 * @see #getHasContext()
	 * @generated
	 */
	void unsetHasContext();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyDefinition#getHasContext <em>Has Context</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Context</em>' reference list is set.
	 * @see #unsetHasContext()
	 * @see #getHasContext()
	 * @generated
	 */
	boolean isSetHasContext();

	/**
	 * Returns the value of the '<em><b>Has Associations</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssociates}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Associations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Associations</em>' reference list.
	 * @see #isSetHasAssociations()
	 * @see #unsetHasAssociations()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyDefinition_HasAssociations()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssociates> getHasAssociations();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyDefinition#getHasAssociations <em>Has Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasAssociations()
	 * @see #getHasAssociations()
	 * @generated
	 */
	void unsetHasAssociations();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyDefinition#getHasAssociations <em>Has Associations</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Associations</em>' reference list is set.
	 * @see #unsetHasAssociations()
	 * @see #getHasAssociations()
	 * @generated
	 */
	boolean isSetHasAssociations();

} // IfcPropertyDefinition
