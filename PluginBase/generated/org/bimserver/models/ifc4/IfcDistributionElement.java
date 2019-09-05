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
 * A representation of the model object '<em><b>Ifc Distribution Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcDistributionElement#getHasPorts <em>Has Ports</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDistributionElement()
 * @model
 * @generated
 */
public interface IfcDistributionElement extends IfcElement {
	/**
	 * Returns the value of the '<em><b>Has Ports</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelConnectsPortToElement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelConnectsPortToElement#getRelatedElement <em>Related Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Ports</em>' reference list.
	 * @see #isSetHasPorts()
	 * @see #unsetHasPorts()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDistributionElement_HasPorts()
	 * @see org.bimserver.models.ifc4.IfcRelConnectsPortToElement#getRelatedElement
	 * @model opposite="RelatedElement" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelConnectsPortToElement> getHasPorts();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDistributionElement#getHasPorts <em>Has Ports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasPorts()
	 * @see #getHasPorts()
	 * @generated
	 */
	void unsetHasPorts();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDistributionElement#getHasPorts <em>Has Ports</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Ports</em>' reference list is set.
	 * @see #unsetHasPorts()
	 * @see #getHasPorts()
	 * @generated
	 */
	boolean isSetHasPorts();

} // IfcDistributionElement
