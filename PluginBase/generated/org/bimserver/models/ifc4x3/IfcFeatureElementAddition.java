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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Feature Element Addition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcFeatureElementAddition#getProjectsElements <em>Projects Elements</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcFeatureElementAddition()
 * @model
 * @generated
 */
public interface IfcFeatureElementAddition extends IfcFeatureElement {
	/**
	 * Returns the value of the '<em><b>Projects Elements</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcRelProjectsElement#getRelatedFeatureElement <em>Related Feature Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects Elements</em>' reference.
	 * @see #isSetProjectsElements()
	 * @see #unsetProjectsElements()
	 * @see #setProjectsElements(IfcRelProjectsElement)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcFeatureElementAddition_ProjectsElements()
	 * @see org.bimserver.models.ifc4x3.IfcRelProjectsElement#getRelatedFeatureElement
	 * @model opposite="RelatedFeatureElement" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcRelProjectsElement getProjectsElements();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcFeatureElementAddition#getProjectsElements <em>Projects Elements</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Projects Elements</em>' reference.
	 * @see #isSetProjectsElements()
	 * @see #unsetProjectsElements()
	 * @see #getProjectsElements()
	 * @generated
	 */
	void setProjectsElements(IfcRelProjectsElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcFeatureElementAddition#getProjectsElements <em>Projects Elements</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetProjectsElements()
	 * @see #getProjectsElements()
	 * @see #setProjectsElements(IfcRelProjectsElement)
	 * @generated
	 */
	void unsetProjectsElements();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcFeatureElementAddition#getProjectsElements <em>Projects Elements</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Projects Elements</em>' reference is set.
	 * @see #unsetProjectsElements()
	 * @see #getProjectsElements()
	 * @see #setProjectsElements(IfcRelProjectsElement)
	 * @generated
	 */
	boolean isSetProjectsElements();

} // IfcFeatureElementAddition
