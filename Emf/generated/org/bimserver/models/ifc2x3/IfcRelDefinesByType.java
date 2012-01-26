/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Defines By Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelDefinesByType#getRelatingType <em>Relating Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelDefinesByType()
 * @model
 * @generated
 */
public interface IfcRelDefinesByType extends IfcRelDefines {
	/**
	 * Returns the value of the '<em><b>Relating Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcTypeObject#getObjectTypeOf <em>Object Type Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Type</em>' reference.
	 * @see #isSetRelatingType()
	 * @see #unsetRelatingType()
	 * @see #setRelatingType(IfcTypeObject)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelDefinesByType_RelatingType()
	 * @see org.bimserver.models.ifc2x3.IfcTypeObject#getObjectTypeOf
	 * @model opposite="ObjectTypeOf" unsettable="true"
	 * @generated
	 */
	IfcTypeObject getRelatingType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelDefinesByType#getRelatingType <em>Relating Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Type</em>' reference.
	 * @see #isSetRelatingType()
	 * @see #unsetRelatingType()
	 * @see #getRelatingType()
	 * @generated
	 */
	void setRelatingType(IfcTypeObject value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelDefinesByType#getRelatingType <em>Relating Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingType()
	 * @see #getRelatingType()
	 * @see #setRelatingType(IfcTypeObject)
	 * @generated
	 */
	void unsetRelatingType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelDefinesByType#getRelatingType <em>Relating Type</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Type</em>' reference is set.
	 * @see #unsetRelatingType()
	 * @see #getRelatingType()
	 * @see #setRelatingType(IfcTypeObject)
	 * @generated
	 */
	boolean isSetRelatingType();

} // IfcRelDefinesByType
