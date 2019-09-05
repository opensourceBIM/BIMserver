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
 * A representation of the model object '<em><b>Ifc Rel Flow Control Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelFlowControlElements#getRelatedControlElements <em>Related Control Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelFlowControlElements#getRelatingFlowElement <em>Relating Flow Element</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelFlowControlElements()
 * @model
 * @generated
 */
public interface IfcRelFlowControlElements extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Related Control Elements</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcDistributionControlElement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcDistributionControlElement#getAssignedToFlowElement <em>Assigned To Flow Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Control Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Control Elements</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelFlowControlElements_RelatedControlElements()
	 * @see org.bimserver.models.ifc4.IfcDistributionControlElement#getAssignedToFlowElement
	 * @model opposite="AssignedToFlowElement"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcDistributionControlElement> getRelatedControlElements();

	/**
	 * Returns the value of the '<em><b>Relating Flow Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcDistributionFlowElement#getHasControlElements <em>Has Control Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Flow Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Flow Element</em>' reference.
	 * @see #setRelatingFlowElement(IfcDistributionFlowElement)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelFlowControlElements_RelatingFlowElement()
	 * @see org.bimserver.models.ifc4.IfcDistributionFlowElement#getHasControlElements
	 * @model opposite="HasControlElements"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcDistributionFlowElement getRelatingFlowElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelFlowControlElements#getRelatingFlowElement <em>Relating Flow Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Flow Element</em>' reference.
	 * @see #getRelatingFlowElement()
	 * @generated
	 */
	void setRelatingFlowElement(IfcDistributionFlowElement value);

} // IfcRelFlowControlElements
