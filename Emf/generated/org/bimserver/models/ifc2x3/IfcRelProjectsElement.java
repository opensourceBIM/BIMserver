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
 * A representation of the model object '<em><b>Ifc Rel Projects Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatedFeatureElement <em>Related Feature Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelProjectsElement()
 * @model
 * @generated
 */
public interface IfcRelProjectsElement extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcElement#getHasProjections <em>Has Projections</em>}'.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelProjectsElement_RelatingElement()
	 * @see org.bimserver.models.ifc2x3.IfcElement#getHasProjections
	 * @model opposite="HasProjections" unsettable="true"
	 * @generated
	 */
	IfcElement getRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatingElement <em>Relating Element</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatingElement <em>Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingElement()
	 * @see #getRelatingElement()
	 * @see #setRelatingElement(IfcElement)
	 * @generated
	 */
	void unsetRelatingElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatingElement <em>Relating Element</em>}' reference is set.
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
	 * Returns the value of the '<em><b>Related Feature Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcFeatureElementAddition#getProjectsElements <em>Projects Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Feature Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Feature Element</em>' reference.
	 * @see #isSetRelatedFeatureElement()
	 * @see #unsetRelatedFeatureElement()
	 * @see #setRelatedFeatureElement(IfcFeatureElementAddition)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelProjectsElement_RelatedFeatureElement()
	 * @see org.bimserver.models.ifc2x3.IfcFeatureElementAddition#getProjectsElements
	 * @model opposite="ProjectsElements" unsettable="true"
	 * @generated
	 */
	IfcFeatureElementAddition getRelatedFeatureElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatedFeatureElement <em>Related Feature Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Feature Element</em>' reference.
	 * @see #isSetRelatedFeatureElement()
	 * @see #unsetRelatedFeatureElement()
	 * @see #getRelatedFeatureElement()
	 * @generated
	 */
	void setRelatedFeatureElement(IfcFeatureElementAddition value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatedFeatureElement <em>Related Feature Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatedFeatureElement()
	 * @see #getRelatedFeatureElement()
	 * @see #setRelatedFeatureElement(IfcFeatureElementAddition)
	 * @generated
	 */
	void unsetRelatedFeatureElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatedFeatureElement <em>Related Feature Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Related Feature Element</em>' reference is set.
	 * @see #unsetRelatedFeatureElement()
	 * @see #getRelatedFeatureElement()
	 * @see #setRelatedFeatureElement(IfcFeatureElementAddition)
	 * @generated
	 */
	boolean isSetRelatedFeatureElement();

} // IfcRelProjectsElement
