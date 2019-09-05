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

public interface IfcFeatureElementSubtraction extends IfcFeatureElement {
	/**
	 * Returns the value of the '<em><b>Voids Elements</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelVoidsElement#getRelatedOpeningElement <em>Related Opening Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Voids Elements</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Voids Elements</em>' reference.
	 * @see #isSetVoidsElements()
	 * @see #unsetVoidsElements()
	 * @see #setVoidsElements(IfcRelVoidsElement)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcFeatureElementSubtraction_VoidsElements()
	 * @see org.bimserver.models.ifc4.IfcRelVoidsElement#getRelatedOpeningElement
	 * @model opposite="RelatedOpeningElement" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcRelVoidsElement getVoidsElements();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcFeatureElementSubtraction#getVoidsElements <em>Voids Elements</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voids Elements</em>' reference.
	 * @see #isSetVoidsElements()
	 * @see #unsetVoidsElements()
	 * @see #getVoidsElements()
	 * @generated
	 */
	void setVoidsElements(IfcRelVoidsElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcFeatureElementSubtraction#getVoidsElements <em>Voids Elements</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVoidsElements()
	 * @see #getVoidsElements()
	 * @see #setVoidsElements(IfcRelVoidsElement)
	 * @generated
	 */
	void unsetVoidsElements();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcFeatureElementSubtraction#getVoidsElements <em>Voids Elements</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Voids Elements</em>' reference is set.
	 * @see #unsetVoidsElements()
	 * @see #getVoidsElements()
	 * @see #setVoidsElements(IfcRelVoidsElement)
	 * @generated
	 */
	boolean isSetVoidsElements();

} // IfcFeatureElementSubtraction
