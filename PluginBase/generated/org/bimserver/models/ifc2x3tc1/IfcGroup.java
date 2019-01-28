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

public interface IfcGroup extends IfcObject {
	/**
	 * Returns the value of the '<em><b>Is Grouped By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelAssignsToGroup#getRelatingGroup <em>Relating Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Grouped By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Grouped By</em>' reference.
	 * @see #isSetIsGroupedBy()
	 * @see #unsetIsGroupedBy()
	 * @see #setIsGroupedBy(IfcRelAssignsToGroup)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcGroup_IsGroupedBy()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelAssignsToGroup#getRelatingGroup
	 * @model opposite="RelatingGroup" unsettable="true"
	 * @generated
	 */
	IfcRelAssignsToGroup getIsGroupedBy();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGroup#getIsGroupedBy <em>Is Grouped By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Grouped By</em>' reference.
	 * @see #isSetIsGroupedBy()
	 * @see #unsetIsGroupedBy()
	 * @see #getIsGroupedBy()
	 * @generated
	 */
	void setIsGroupedBy(IfcRelAssignsToGroup value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGroup#getIsGroupedBy <em>Is Grouped By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsGroupedBy()
	 * @see #getIsGroupedBy()
	 * @see #setIsGroupedBy(IfcRelAssignsToGroup)
	 * @generated
	 */
	void unsetIsGroupedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcGroup#getIsGroupedBy <em>Is Grouped By</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Grouped By</em>' reference is set.
	 * @see #unsetIsGroupedBy()
	 * @see #getIsGroupedBy()
	 * @see #setIsGroupedBy(IfcRelAssignsToGroup)
	 * @generated
	 */
	boolean isSetIsGroupedBy();

} // IfcGroup
