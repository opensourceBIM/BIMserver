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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Structural Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralItem#getAssignedStructuralActivity <em>Assigned Structural Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralItem()
 * @model
 * @generated
 */
public interface IfcStructuralItem extends IfcProduct, IfcStructuralActivityAssignmentSelect
{
	/**
	 * Returns the value of the '<em><b>Assigned Structural Activity</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralActivity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned Structural Activity</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned Structural Activity</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralItem_AssignedStructuralActivity()
	 * @model
	 * @generated
	 */
	EList<IfcRelConnectsStructuralActivity> getAssignedStructuralActivity();

} // IfcStructuralItem
