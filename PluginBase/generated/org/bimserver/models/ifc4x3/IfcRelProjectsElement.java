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
 * A representation of the model object '<em><b>Ifc Rel Projects Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelProjectsElement#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelProjectsElement#getRelatedFeatureElement <em>Related Feature Element</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelProjectsElement()
 * @model
 * @generated
 */
public interface IfcRelProjectsElement extends IfcRelDecomposes {
	/**
	 * Returns the value of the '<em><b>Relating Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcElement#getHasProjections <em>Has Projections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Element</em>' reference.
	 * @see #setRelatingElement(IfcElement)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelProjectsElement_RelatingElement()
	 * @see org.bimserver.models.ifc4x3.IfcElement#getHasProjections
	 * @model opposite="HasProjections"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcElement getRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelProjectsElement#getRelatingElement <em>Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Element</em>' reference.
	 * @see #getRelatingElement()
	 * @generated
	 */
	void setRelatingElement(IfcElement value);

	/**
	 * Returns the value of the '<em><b>Related Feature Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcFeatureElementAddition#getProjectsElements <em>Projects Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Feature Element</em>' reference.
	 * @see #setRelatedFeatureElement(IfcFeatureElementAddition)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelProjectsElement_RelatedFeatureElement()
	 * @see org.bimserver.models.ifc4x3.IfcFeatureElementAddition#getProjectsElements
	 * @model opposite="ProjectsElements"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcFeatureElementAddition getRelatedFeatureElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelProjectsElement#getRelatedFeatureElement <em>Related Feature Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Feature Element</em>' reference.
	 * @see #getRelatedFeatureElement()
	 * @generated
	 */
	void setRelatedFeatureElement(IfcFeatureElementAddition value);

} // IfcRelProjectsElement
