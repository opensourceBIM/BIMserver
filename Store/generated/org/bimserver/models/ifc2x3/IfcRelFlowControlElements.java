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
 * A representation of the model object '<em><b>Ifc Rel Flow Control Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelFlowControlElements#getRelatedControlElements <em>Related Control Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelFlowControlElements#getRelatingFlowElement <em>Relating Flow Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelFlowControlElements()
 * @model
 * @generated
 */
public interface IfcRelFlowControlElements extends IfcRelConnects
{
	/**
	 * Returns the value of the '<em><b>Related Control Elements</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcDistributionControlElement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcDistributionControlElement#getAssignedToFlowElement <em>Assigned To Flow Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Control Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Control Elements</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelFlowControlElements_RelatedControlElements()
	 * @see org.bimserver.models.ifc2x3.IfcDistributionControlElement#getAssignedToFlowElement
	 * @model opposite="AssignedToFlowElement"
	 * @generated
	 */
	EList<IfcDistributionControlElement> getRelatedControlElements();

	/**
	 * Returns the value of the '<em><b>Relating Flow Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcDistributionFlowElement#getHasControlElements <em>Has Control Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Flow Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Flow Element</em>' reference.
	 * @see #setRelatingFlowElement(IfcDistributionFlowElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelFlowControlElements_RelatingFlowElement()
	 * @see org.bimserver.models.ifc2x3.IfcDistributionFlowElement#getHasControlElements
	 * @model opposite="HasControlElements"
	 * @generated
	 */
	IfcDistributionFlowElement getRelatingFlowElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelFlowControlElements#getRelatingFlowElement <em>Relating Flow Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Flow Element</em>' reference.
	 * @see #getRelatingFlowElement()
	 * @generated
	 */
	void setRelatingFlowElement(IfcDistributionFlowElement value);

} // IfcRelFlowControlElements
