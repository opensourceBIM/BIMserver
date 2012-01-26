/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Connects Structural Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatedStructuralMember <em>Related Structural Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsStructuralElement()
 * @model
 * @generated
 */
public interface IfcRelConnectsStructuralElement extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcElement#getHasStructuralMember <em>Has Structural Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Element</em>' reference.
	 * @see #isSetRelatingElement()
	 * @see #unsetRelatingElement()
	 * @see #setRelatingElement(IfcElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsStructuralElement_RelatingElement()
	 * @see org.bimserver.models.ifc2x3.IfcElement#getHasStructuralMember
	 * @model opposite="HasStructuralMember" unsettable="true"
	 * @generated
	 */
	IfcElement getRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatingElement <em>Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Element</em>' reference.
	 * @see #isSetRelatingElement()
	 * @see #unsetRelatingElement()
	 * @see #getRelatingElement()
	 * @generated
	 */
	void setRelatingElement(IfcElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatingElement <em>Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingElement()
	 * @see #getRelatingElement()
	 * @see #setRelatingElement(IfcElement)
	 * @generated
	 */
	void unsetRelatingElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatingElement <em>Relating Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Element</em>' reference is set.
	 * @see #unsetRelatingElement()
	 * @see #getRelatingElement()
	 * @see #setRelatingElement(IfcElement)
	 * @generated
	 */
	boolean isSetRelatingElement();

	/**
	 * Returns the value of the '<em><b>Related Structural Member</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcStructuralMember#getReferencesElement <em>References Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Structural Member</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Structural Member</em>' reference.
	 * @see #isSetRelatedStructuralMember()
	 * @see #unsetRelatedStructuralMember()
	 * @see #setRelatedStructuralMember(IfcStructuralMember)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsStructuralElement_RelatedStructuralMember()
	 * @see org.bimserver.models.ifc2x3.IfcStructuralMember#getReferencesElement
	 * @model opposite="ReferencesElement" unsettable="true"
	 * @generated
	 */
	IfcStructuralMember getRelatedStructuralMember();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatedStructuralMember <em>Related Structural Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Structural Member</em>' reference.
	 * @see #isSetRelatedStructuralMember()
	 * @see #unsetRelatedStructuralMember()
	 * @see #getRelatedStructuralMember()
	 * @generated
	 */
	void setRelatedStructuralMember(IfcStructuralMember value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatedStructuralMember <em>Related Structural Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatedStructuralMember()
	 * @see #getRelatedStructuralMember()
	 * @see #setRelatedStructuralMember(IfcStructuralMember)
	 * @generated
	 */
	void unsetRelatedStructuralMember();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatedStructuralMember <em>Related Structural Member</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Related Structural Member</em>' reference is set.
	 * @see #unsetRelatedStructuralMember()
	 * @see #getRelatedStructuralMember()
	 * @see #setRelatedStructuralMember(IfcStructuralMember)
	 * @generated
	 */
	boolean isSetRelatedStructuralMember();

} // IfcRelConnectsStructuralElement
