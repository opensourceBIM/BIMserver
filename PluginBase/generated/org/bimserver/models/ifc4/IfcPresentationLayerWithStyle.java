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
 * A representation of the model object '<em><b>Ifc Presentation Layer With Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcPresentationLayerWithStyle#getLayerOn <em>Layer On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPresentationLayerWithStyle#getLayerFrozen <em>Layer Frozen</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPresentationLayerWithStyle#getLayerBlocked <em>Layer Blocked</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPresentationLayerWithStyle#getLayerStyles <em>Layer Styles</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPresentationLayerWithStyle()
 * @model
 * @generated
 */
public interface IfcPresentationLayerWithStyle extends IfcPresentationLayerAssignment {
	/**
	 * Returns the value of the '<em><b>Layer On</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer On</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer On</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setLayerOn(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPresentationLayerWithStyle_LayerOn()
	 * @model
	 * @generated
	 */
	Tristate getLayerOn();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPresentationLayerWithStyle#getLayerOn <em>Layer On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer On</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getLayerOn()
	 * @generated
	 */
	void setLayerOn(Tristate value);

	/**
	 * Returns the value of the '<em><b>Layer Frozen</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Frozen</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Frozen</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setLayerFrozen(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPresentationLayerWithStyle_LayerFrozen()
	 * @model
	 * @generated
	 */
	Tristate getLayerFrozen();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPresentationLayerWithStyle#getLayerFrozen <em>Layer Frozen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Frozen</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getLayerFrozen()
	 * @generated
	 */
	void setLayerFrozen(Tristate value);

	/**
	 * Returns the value of the '<em><b>Layer Blocked</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Blocked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Blocked</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setLayerBlocked(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPresentationLayerWithStyle_LayerBlocked()
	 * @model
	 * @generated
	 */
	Tristate getLayerBlocked();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPresentationLayerWithStyle#getLayerBlocked <em>Layer Blocked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Blocked</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getLayerBlocked()
	 * @generated
	 */
	void setLayerBlocked(Tristate value);

	/**
	 * Returns the value of the '<em><b>Layer Styles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcPresentationStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Styles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Styles</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPresentationLayerWithStyle_LayerStyles()
	 * @model
	 * @generated
	 */
	EList<IfcPresentationStyle> getLayerStyles();

} // IfcPresentationLayerWithStyle
