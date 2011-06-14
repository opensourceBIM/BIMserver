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
 * A representation of the model object '<em><b>Ifc Feature Element Addition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFeatureElementAddition#getProjectsElements <em>Projects Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFeatureElementAddition()
 * @model
 * @generated
 */
public interface IfcFeatureElementAddition extends IfcFeatureElement
{
	/**
	 * Returns the value of the '<em><b>Projects Elements</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatedFeatureElement <em>Related Feature Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects Elements</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects Elements</em>' reference.
	 * @see #setProjectsElements(IfcRelProjectsElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFeatureElementAddition_ProjectsElements()
	 * @see org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatedFeatureElement
	 * @model opposite="RelatedFeatureElement"
	 * @generated
	 */
	IfcRelProjectsElement getProjectsElements();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFeatureElementAddition#getProjectsElements <em>Projects Elements</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Projects Elements</em>' reference.
	 * @see #getProjectsElements()
	 * @generated
	 */
	void setProjectsElements(IfcRelProjectsElement value);

} // IfcFeatureElementAddition
