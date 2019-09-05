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

public interface IfcRelInterferesElements extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcElement#getInterferesElements <em>Interferes Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Element</em>' reference.
	 * @see #setRelatingElement(IfcElement)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelInterferesElements_RelatingElement()
	 * @see org.bimserver.models.ifc4.IfcElement#getInterferesElements
	 * @model opposite="InterferesElements"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcElement getRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelInterferesElements#getRelatingElement <em>Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Element</em>' reference.
	 * @see #getRelatingElement()
	 * @generated
	 */
	void setRelatingElement(IfcElement value);

	/**
	 * Returns the value of the '<em><b>Related Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcElement#getIsInterferedByElements <em>Is Interfered By Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Element</em>' reference.
	 * @see #setRelatedElement(IfcElement)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelInterferesElements_RelatedElement()
	 * @see org.bimserver.models.ifc4.IfcElement#getIsInterferedByElements
	 * @model opposite="IsInterferedByElements"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcElement getRelatedElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelInterferesElements#getRelatedElement <em>Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Element</em>' reference.
	 * @see #getRelatedElement()
	 * @generated
	 */
	void setRelatedElement(IfcElement value);

	/**
	 * Returns the value of the '<em><b>Interference Geometry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interference Geometry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interference Geometry</em>' reference.
	 * @see #isSetInterferenceGeometry()
	 * @see #unsetInterferenceGeometry()
	 * @see #setInterferenceGeometry(IfcConnectionGeometry)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelInterferesElements_InterferenceGeometry()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcConnectionGeometry getInterferenceGeometry();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelInterferesElements#getInterferenceGeometry <em>Interference Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interference Geometry</em>' reference.
	 * @see #isSetInterferenceGeometry()
	 * @see #unsetInterferenceGeometry()
	 * @see #getInterferenceGeometry()
	 * @generated
	 */
	void setInterferenceGeometry(IfcConnectionGeometry value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRelInterferesElements#getInterferenceGeometry <em>Interference Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInterferenceGeometry()
	 * @see #getInterferenceGeometry()
	 * @see #setInterferenceGeometry(IfcConnectionGeometry)
	 * @generated
	 */
	void unsetInterferenceGeometry();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRelInterferesElements#getInterferenceGeometry <em>Interference Geometry</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Interference Geometry</em>' reference is set.
	 * @see #unsetInterferenceGeometry()
	 * @see #getInterferenceGeometry()
	 * @see #setInterferenceGeometry(IfcConnectionGeometry)
	 * @generated
	 */
	boolean isSetInterferenceGeometry();

	/**
	 * Returns the value of the '<em><b>Interference Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interference Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interference Type</em>' attribute.
	 * @see #isSetInterferenceType()
	 * @see #unsetInterferenceType()
	 * @see #setInterferenceType(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelInterferesElements_InterferenceType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getInterferenceType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelInterferesElements#getInterferenceType <em>Interference Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interference Type</em>' attribute.
	 * @see #isSetInterferenceType()
	 * @see #unsetInterferenceType()
	 * @see #getInterferenceType()
	 * @generated
	 */
	void setInterferenceType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRelInterferesElements#getInterferenceType <em>Interference Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInterferenceType()
	 * @see #getInterferenceType()
	 * @see #setInterferenceType(String)
	 * @generated
	 */
	void unsetInterferenceType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRelInterferesElements#getInterferenceType <em>Interference Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Interference Type</em>' attribute is set.
	 * @see #unsetInterferenceType()
	 * @see #getInterferenceType()
	 * @see #setInterferenceType(String)
	 * @generated
	 */
	boolean isSetInterferenceType();

	/**
	 * Returns the value of the '<em><b>Implied Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implied Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implied Order</em>' attribute.
	 * @see #setImpliedOrder(boolean)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelInterferesElements_ImpliedOrder()
	 * @model
	 * @generated
	 */
	boolean isImpliedOrder();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelInterferesElements#isImpliedOrder <em>Implied Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implied Order</em>' attribute.
	 * @see #isImpliedOrder()
	 * @generated
	 */
	void setImpliedOrder(boolean value);

} // IfcRelInterferesElements
