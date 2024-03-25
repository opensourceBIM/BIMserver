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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Positions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelPositions#getRelatingPositioningElement <em>Relating Positioning Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelPositions#getRelatedProducts <em>Related Products</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelPositions()
 * @model
 * @generated
 */
public interface IfcRelPositions extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Positioning Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcPositioningElement#getPositions <em>Positions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Positioning Element</em>' reference.
	 * @see #setRelatingPositioningElement(IfcPositioningElement)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelPositions_RelatingPositioningElement()
	 * @see org.bimserver.models.ifc4x3.IfcPositioningElement#getPositions
	 * @model opposite="Positions"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcPositioningElement getRelatingPositioningElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelPositions#getRelatingPositioningElement <em>Relating Positioning Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Positioning Element</em>' reference.
	 * @see #getRelatingPositioningElement()
	 * @generated
	 */
	void setRelatingPositioningElement(IfcPositioningElement value);

	/**
	 * Returns the value of the '<em><b>Related Products</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcProduct}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcProduct#getPositionedRelativeTo <em>Positioned Relative To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Products</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelPositions_RelatedProducts()
	 * @see org.bimserver.models.ifc4x3.IfcProduct#getPositionedRelativeTo
	 * @model opposite="PositionedRelativeTo"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcProduct> getRelatedProducts();

} // IfcRelPositions
