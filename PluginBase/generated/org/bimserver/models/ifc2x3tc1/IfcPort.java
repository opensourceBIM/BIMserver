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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcPort#getContainedIn <em>Contained In</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcPort#getConnectedFrom <em>Connected From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcPort#getConnectedTo <em>Connected To</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcPort()
 * @model
 * @generated
 */
public interface IfcPort extends IfcProduct {
	/**
	 * Returns the value of the '<em><b>Contained In</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelConnectsPortToElement#getRelatingPort <em>Relating Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained In</em>' reference.
	 * @see #isSetContainedIn()
	 * @see #unsetContainedIn()
	 * @see #setContainedIn(IfcRelConnectsPortToElement)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcPort_ContainedIn()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelConnectsPortToElement#getRelatingPort
	 * @model opposite="RelatingPort" unsettable="true"
	 * @generated
	 */
	IfcRelConnectsPortToElement getContainedIn();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcPort#getContainedIn <em>Contained In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained In</em>' reference.
	 * @see #isSetContainedIn()
	 * @see #unsetContainedIn()
	 * @see #getContainedIn()
	 * @generated
	 */
	void setContainedIn(IfcRelConnectsPortToElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcPort#getContainedIn <em>Contained In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContainedIn()
	 * @see #getContainedIn()
	 * @see #setContainedIn(IfcRelConnectsPortToElement)
	 * @generated
	 */
	void unsetContainedIn();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcPort#getContainedIn <em>Contained In</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Contained In</em>' reference is set.
	 * @see #unsetContainedIn()
	 * @see #getContainedIn()
	 * @see #setContainedIn(IfcRelConnectsPortToElement)
	 * @generated
	 */
	boolean isSetContainedIn();

	/**
	 * Returns the value of the '<em><b>Connected From</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelConnectsPorts}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelConnectsPorts#getRelatedPort <em>Related Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected From</em>' reference list.
	 * @see #isSetConnectedFrom()
	 * @see #unsetConnectedFrom()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcPort_ConnectedFrom()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelConnectsPorts#getRelatedPort
	 * @model opposite="RelatedPort" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcRelConnectsPorts> getConnectedFrom();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcPort#getConnectedFrom <em>Connected From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConnectedFrom()
	 * @see #getConnectedFrom()
	 * @generated
	 */
	void unsetConnectedFrom();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcPort#getConnectedFrom <em>Connected From</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Connected From</em>' reference list is set.
	 * @see #unsetConnectedFrom()
	 * @see #getConnectedFrom()
	 * @generated
	 */
	boolean isSetConnectedFrom();

	/**
	 * Returns the value of the '<em><b>Connected To</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelConnectsPorts}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelConnectsPorts#getRelatingPort <em>Relating Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected To</em>' reference list.
	 * @see #isSetConnectedTo()
	 * @see #unsetConnectedTo()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcPort_ConnectedTo()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelConnectsPorts#getRelatingPort
	 * @model opposite="RelatingPort" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcRelConnectsPorts> getConnectedTo();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcPort#getConnectedTo <em>Connected To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConnectedTo()
	 * @see #getConnectedTo()
	 * @generated
	 */
	void unsetConnectedTo();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcPort#getConnectedTo <em>Connected To</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Connected To</em>' reference list is set.
	 * @see #unsetConnectedTo()
	 * @see #getConnectedTo()
	 * @generated
	 */
	boolean isSetConnectedTo();

} // IfcPort
