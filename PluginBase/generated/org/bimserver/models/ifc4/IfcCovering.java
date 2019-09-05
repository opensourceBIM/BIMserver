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
 * A representation of the model object '<em><b>Ifc Covering</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcCovering#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcCovering#getCoversSpaces <em>Covers Spaces</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcCovering#getCoversElements <em>Covers Elements</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCovering()
 * @model
 * @generated
 */
public interface IfcCovering extends IfcBuildingElement {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcCoveringTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcCoveringTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcCoveringTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCovering_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCoveringTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCovering#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcCoveringTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcCoveringTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCovering#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcCoveringTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCovering#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcCoveringTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

	/**
	 * Returns the value of the '<em><b>Covers Spaces</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelCoversSpaces}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelCoversSpaces#getRelatedCoverings <em>Related Coverings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Covers Spaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Covers Spaces</em>' reference list.
	 * @see #isSetCoversSpaces()
	 * @see #unsetCoversSpaces()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCovering_CoversSpaces()
	 * @see org.bimserver.models.ifc4.IfcRelCoversSpaces#getRelatedCoverings
	 * @model opposite="RelatedCoverings" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelCoversSpaces> getCoversSpaces();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCovering#getCoversSpaces <em>Covers Spaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoversSpaces()
	 * @see #getCoversSpaces()
	 * @generated
	 */
	void unsetCoversSpaces();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCovering#getCoversSpaces <em>Covers Spaces</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Covers Spaces</em>' reference list is set.
	 * @see #unsetCoversSpaces()
	 * @see #getCoversSpaces()
	 * @generated
	 */
	boolean isSetCoversSpaces();

	/**
	 * Returns the value of the '<em><b>Covers Elements</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelCoversBldgElements}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelCoversBldgElements#getRelatedCoverings <em>Related Coverings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Covers Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Covers Elements</em>' reference list.
	 * @see #isSetCoversElements()
	 * @see #unsetCoversElements()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCovering_CoversElements()
	 * @see org.bimserver.models.ifc4.IfcRelCoversBldgElements#getRelatedCoverings
	 * @model opposite="RelatedCoverings" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelCoversBldgElements> getCoversElements();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCovering#getCoversElements <em>Covers Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoversElements()
	 * @see #getCoversElements()
	 * @generated
	 */
	void unsetCoversElements();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCovering#getCoversElements <em>Covers Elements</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Covers Elements</em>' reference list is set.
	 * @see #unsetCoversElements()
	 * @see #getCoversElements()
	 * @generated
	 */
	boolean isSetCoversElements();

} // IfcCovering
