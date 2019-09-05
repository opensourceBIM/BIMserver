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
 * A representation of the model object '<em><b>Ifc Rel Declares</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelDeclares#getRelatingContext <em>Relating Context</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelDeclares#getRelatedDefinitions <em>Related Definitions</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelDeclares()
 * @model
 * @generated
 */
public interface IfcRelDeclares extends IfcRelationship {
	/**
	 * Returns the value of the '<em><b>Relating Context</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcContext#getDeclares <em>Declares</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Context</em>' reference.
	 * @see #setRelatingContext(IfcContext)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelDeclares_RelatingContext()
	 * @see org.bimserver.models.ifc4.IfcContext#getDeclares
	 * @model opposite="Declares"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcContext getRelatingContext();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelDeclares#getRelatingContext <em>Relating Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Context</em>' reference.
	 * @see #getRelatingContext()
	 * @generated
	 */
	void setRelatingContext(IfcContext value);

	/**
	 * Returns the value of the '<em><b>Related Definitions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcDefinitionSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Definitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Definitions</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelDeclares_RelatedDefinitions()
	 * @model annotation="inverse"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcDefinitionSelect> getRelatedDefinitions();

} // IfcRelDeclares
