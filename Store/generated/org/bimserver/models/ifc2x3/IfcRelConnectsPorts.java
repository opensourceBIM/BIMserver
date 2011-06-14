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
 * A representation of the model object '<em><b>Ifc Rel Connects Ports</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRelatingPort <em>Relating Port</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRelatedPort <em>Related Port</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRealizingElement <em>Realizing Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsPorts()
 * @model
 * @generated
 */
public interface IfcRelConnectsPorts extends IfcRelConnects
{
	/**
	 * Returns the value of the '<em><b>Relating Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcPort#getConnectedTo <em>Connected To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Port</em>' reference.
	 * @see #setRelatingPort(IfcPort)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsPorts_RelatingPort()
	 * @see org.bimserver.models.ifc2x3.IfcPort#getConnectedTo
	 * @model opposite="ConnectedTo"
	 * @generated
	 */
	IfcPort getRelatingPort();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRelatingPort <em>Relating Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Port</em>' reference.
	 * @see #getRelatingPort()
	 * @generated
	 */
	void setRelatingPort(IfcPort value);

	/**
	 * Returns the value of the '<em><b>Related Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcPort#getConnectedFrom <em>Connected From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Port</em>' reference.
	 * @see #setRelatedPort(IfcPort)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsPorts_RelatedPort()
	 * @see org.bimserver.models.ifc2x3.IfcPort#getConnectedFrom
	 * @model opposite="ConnectedFrom"
	 * @generated
	 */
	IfcPort getRelatedPort();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRelatedPort <em>Related Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Port</em>' reference.
	 * @see #getRelatedPort()
	 * @generated
	 */
	void setRelatedPort(IfcPort value);

	/**
	 * Returns the value of the '<em><b>Realizing Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realizing Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realizing Element</em>' reference.
	 * @see #isSetRealizingElement()
	 * @see #unsetRealizingElement()
	 * @see #setRealizingElement(IfcElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsPorts_RealizingElement()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcElement getRealizingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRealizingElement <em>Realizing Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realizing Element</em>' reference.
	 * @see #isSetRealizingElement()
	 * @see #unsetRealizingElement()
	 * @see #getRealizingElement()
	 * @generated
	 */
	void setRealizingElement(IfcElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRealizingElement <em>Realizing Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRealizingElement()
	 * @see #getRealizingElement()
	 * @see #setRealizingElement(IfcElement)
	 * @generated
	 */
	void unsetRealizingElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRealizingElement <em>Realizing Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Realizing Element</em>' reference is set.
	 * @see #unsetRealizingElement()
	 * @see #getRealizingElement()
	 * @see #setRealizingElement(IfcElement)
	 * @generated
	 */
	boolean isSetRealizingElement();

} // IfcRelConnectsPorts
