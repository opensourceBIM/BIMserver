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
 * A representation of the model object '<em><b>Ifc Rel Defines By Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelDefinesByObject#getRelatedObjects <em>Related Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelDefinesByObject#getRelatingObject <em>Relating Object</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelDefinesByObject()
 * @model
 * @generated
 */
public interface IfcRelDefinesByObject extends IfcRelDefines {
	/**
	 * Returns the value of the '<em><b>Related Objects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcObject}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcObject#getIsDeclaredBy <em>Is Declared By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Objects</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelDefinesByObject_RelatedObjects()
	 * @see org.bimserver.models.ifc4.IfcObject#getIsDeclaredBy
	 * @model opposite="IsDeclaredBy"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcObject> getRelatedObjects();

	/**
	 * Returns the value of the '<em><b>Relating Object</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcObject#getDeclares <em>Declares</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Object</em>' reference.
	 * @see #setRelatingObject(IfcObject)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelDefinesByObject_RelatingObject()
	 * @see org.bimserver.models.ifc4.IfcObject#getDeclares
	 * @model opposite="Declares"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcObject getRelatingObject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelDefinesByObject#getRelatingObject <em>Relating Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Object</em>' reference.
	 * @see #getRelatingObject()
	 * @generated
	 */
	void setRelatingObject(IfcObject value);

} // IfcRelDefinesByObject
