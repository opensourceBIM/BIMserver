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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Covers Spaces</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelCoversSpaces#getRelatingSpace <em>Relating Space</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRelCoversSpaces#getRelatedCoverings <em>Related Coverings</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelCoversSpaces()
 * @model
 * @generated
 */
public interface IfcRelCoversSpaces extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Space</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcSpace#getHasCoverings <em>Has Coverings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Space</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Space</em>' reference.
	 * @see #setRelatingSpace(IfcSpace)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelCoversSpaces_RelatingSpace()
	 * @see org.bimserver.models.ifc4.IfcSpace#getHasCoverings
	 * @model opposite="HasCoverings"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcSpace getRelatingSpace();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRelCoversSpaces#getRelatingSpace <em>Relating Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Space</em>' reference.
	 * @see #getRelatingSpace()
	 * @generated
	 */
	void setRelatingSpace(IfcSpace value);

	/**
	 * Returns the value of the '<em><b>Related Coverings</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcCovering}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcCovering#getCoversSpaces <em>Covers Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Coverings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Coverings</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRelCoversSpaces_RelatedCoverings()
	 * @see org.bimserver.models.ifc4.IfcCovering#getCoversSpaces
	 * @model opposite="CoversSpaces"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcCovering> getRelatedCoverings();

} // IfcRelCoversSpaces
