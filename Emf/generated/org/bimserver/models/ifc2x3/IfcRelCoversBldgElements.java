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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Covers Bldg Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelCoversBldgElements#getRelatingBuildingElement <em>Relating Building Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelCoversBldgElements#getRelatedCoverings <em>Related Coverings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelCoversBldgElements()
 * @model
 * @generated
 */
public interface IfcRelCoversBldgElements extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Building Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcElement#getHasCoverings <em>Has Coverings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Building Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Building Element</em>' reference.
	 * @see #isSetRelatingBuildingElement()
	 * @see #unsetRelatingBuildingElement()
	 * @see #setRelatingBuildingElement(IfcElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelCoversBldgElements_RelatingBuildingElement()
	 * @see org.bimserver.models.ifc2x3.IfcElement#getHasCoverings
	 * @model opposite="HasCoverings" unsettable="true"
	 * @generated
	 */
	IfcElement getRelatingBuildingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelCoversBldgElements#getRelatingBuildingElement <em>Relating Building Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Building Element</em>' reference.
	 * @see #isSetRelatingBuildingElement()
	 * @see #unsetRelatingBuildingElement()
	 * @see #getRelatingBuildingElement()
	 * @generated
	 */
	void setRelatingBuildingElement(IfcElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelCoversBldgElements#getRelatingBuildingElement <em>Relating Building Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingBuildingElement()
	 * @see #getRelatingBuildingElement()
	 * @see #setRelatingBuildingElement(IfcElement)
	 * @generated
	 */
	void unsetRelatingBuildingElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelCoversBldgElements#getRelatingBuildingElement <em>Relating Building Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Building Element</em>' reference is set.
	 * @see #unsetRelatingBuildingElement()
	 * @see #getRelatingBuildingElement()
	 * @see #setRelatingBuildingElement(IfcElement)
	 * @generated
	 */
	boolean isSetRelatingBuildingElement();

	/**
	 * Returns the value of the '<em><b>Related Coverings</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcCovering}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcCovering#getCovers <em>Covers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Coverings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Coverings</em>' reference list.
	 * @see #isSetRelatedCoverings()
	 * @see #unsetRelatedCoverings()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelCoversBldgElements_RelatedCoverings()
	 * @see org.bimserver.models.ifc2x3.IfcCovering#getCovers
	 * @model opposite="Covers" unsettable="true"
	 * @generated
	 */
	EList<IfcCovering> getRelatedCoverings();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelCoversBldgElements#getRelatedCoverings <em>Related Coverings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatedCoverings()
	 * @see #getRelatedCoverings()
	 * @generated
	 */
	void unsetRelatedCoverings();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelCoversBldgElements#getRelatedCoverings <em>Related Coverings</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Related Coverings</em>' reference list is set.
	 * @see #unsetRelatedCoverings()
	 * @see #getRelatedCoverings()
	 * @generated
	 */
	boolean isSetRelatedCoverings();

} // IfcRelCoversBldgElements
