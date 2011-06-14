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
 * A representation of the model object '<em><b>Ifc Structural Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralMember#getReferencesElement <em>References Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralMember#getConnectedBy <em>Connected By</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralMember()
 * @model
 * @generated
 */
public interface IfcStructuralMember extends IfcStructuralItem
{
	/**
	 * Returns the value of the '<em><b>References Element</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatedStructuralMember <em>Related Structural Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References Element</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralMember_ReferencesElement()
	 * @see org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatedStructuralMember
	 * @model opposite="RelatedStructuralMember"
	 * @generated
	 */
	EList<IfcRelConnectsStructuralElement> getReferencesElement();

	/**
	 * Returns the value of the '<em><b>Connected By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralMember}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralMember#getRelatingStructuralMember <em>Relating Structural Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected By</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralMember_ConnectedBy()
	 * @see org.bimserver.models.ifc2x3.IfcRelConnectsStructuralMember#getRelatingStructuralMember
	 * @model opposite="RelatingStructuralMember"
	 * @generated
	 */
	EList<IfcRelConnectsStructuralMember> getConnectedBy();

} // IfcStructuralMember
