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

public interface IfcRelVoidsElement extends IfcRelDecomposes {
	/**
	 * Returns the value of the '<em><b>Relating Building Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcElement#getHasOpenings <em>Has Openings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Building Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Building Element</em>' reference.
	 * @see #setRelatingBuildingElement(IfcElement)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelVoidsElement_RelatingBuildingElement()
	 * @see org.bimserver.models.ifc4.IfcElement#getHasOpenings
	 * @model opposite="HasOpenings"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcElement getRelatingBuildingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelVoidsElement#getRelatingBuildingElement <em>Relating Building Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Building Element</em>' reference.
	 * @see #getRelatingBuildingElement()
	 * @generated
	 */
	void setRelatingBuildingElement(IfcElement value);

	/**
	 * Returns the value of the '<em><b>Related Opening Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcFeatureElementSubtraction#getVoidsElements <em>Voids Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Opening Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Opening Element</em>' reference.
	 * @see #setRelatedOpeningElement(IfcFeatureElementSubtraction)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelVoidsElement_RelatedOpeningElement()
	 * @see org.bimserver.models.ifc4.IfcFeatureElementSubtraction#getVoidsElements
	 * @model opposite="VoidsElements"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcFeatureElementSubtraction getRelatedOpeningElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelVoidsElement#getRelatedOpeningElement <em>Related Opening Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Opening Element</em>' reference.
	 * @see #getRelatedOpeningElement()
	 * @generated
	 */
	void setRelatedOpeningElement(IfcFeatureElementSubtraction value);

} // IfcRelVoidsElement
