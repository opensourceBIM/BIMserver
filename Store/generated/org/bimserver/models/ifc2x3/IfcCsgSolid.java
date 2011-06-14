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
 * A representation of the model object '<em><b>Ifc Csg Solid</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCsgSolid#getTreeRootExpression <em>Tree Root Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCsgSolid()
 * @model
 * @generated
 */
public interface IfcCsgSolid extends IfcSolidModel
{
	/**
	 * Returns the value of the '<em><b>Tree Root Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tree Root Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tree Root Expression</em>' reference.
	 * @see #setTreeRootExpression(IfcCsgSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCsgSolid_TreeRootExpression()
	 * @model
	 * @generated
	 */
	IfcCsgSelect getTreeRootExpression();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCsgSolid#getTreeRootExpression <em>Tree Root Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tree Root Expression</em>' reference.
	 * @see #getTreeRootExpression()
	 * @generated
	 */
	void setTreeRootExpression(IfcCsgSelect value);

} // IfcCsgSolid
