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
 * A representation of the model object '<em><b>Ifc Presentation Layer With Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerOn <em>Layer On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerFrozen <em>Layer Frozen</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerBlocked <em>Layer Blocked</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#getLayerStyles <em>Layer Styles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPresentationLayerWithStyle()
 * @model
 * @generated
 */
public interface IfcPresentationLayerWithStyle extends IfcPresentationLayerAssignment {
	/**
	 * Returns the value of the '<em><b>Layer On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer On</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer On</em>' attribute.
	 * @see #isSetLayerOn()
	 * @see #unsetLayerOn()
	 * @see #setLayerOn(boolean)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPresentationLayerWithStyle_LayerOn()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isLayerOn();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerOn <em>Layer On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer On</em>' attribute.
	 * @see #isSetLayerOn()
	 * @see #unsetLayerOn()
	 * @see #isLayerOn()
	 * @generated
	 */
	void setLayerOn(boolean value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerOn <em>Layer On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLayerOn()
	 * @see #isLayerOn()
	 * @see #setLayerOn(boolean)
	 * @generated
	 */
	void unsetLayerOn();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerOn <em>Layer On</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Layer On</em>' attribute is set.
	 * @see #unsetLayerOn()
	 * @see #isLayerOn()
	 * @see #setLayerOn(boolean)
	 * @generated
	 */
	boolean isSetLayerOn();

	/**
	 * Returns the value of the '<em><b>Layer Frozen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Frozen</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Frozen</em>' attribute.
	 * @see #isSetLayerFrozen()
	 * @see #unsetLayerFrozen()
	 * @see #setLayerFrozen(boolean)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPresentationLayerWithStyle_LayerFrozen()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isLayerFrozen();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerFrozen <em>Layer Frozen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Frozen</em>' attribute.
	 * @see #isSetLayerFrozen()
	 * @see #unsetLayerFrozen()
	 * @see #isLayerFrozen()
	 * @generated
	 */
	void setLayerFrozen(boolean value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerFrozen <em>Layer Frozen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLayerFrozen()
	 * @see #isLayerFrozen()
	 * @see #setLayerFrozen(boolean)
	 * @generated
	 */
	void unsetLayerFrozen();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerFrozen <em>Layer Frozen</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Layer Frozen</em>' attribute is set.
	 * @see #unsetLayerFrozen()
	 * @see #isLayerFrozen()
	 * @see #setLayerFrozen(boolean)
	 * @generated
	 */
	boolean isSetLayerFrozen();

	/**
	 * Returns the value of the '<em><b>Layer Blocked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Blocked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Blocked</em>' attribute.
	 * @see #isSetLayerBlocked()
	 * @see #unsetLayerBlocked()
	 * @see #setLayerBlocked(boolean)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPresentationLayerWithStyle_LayerBlocked()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isLayerBlocked();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerBlocked <em>Layer Blocked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Blocked</em>' attribute.
	 * @see #isSetLayerBlocked()
	 * @see #unsetLayerBlocked()
	 * @see #isLayerBlocked()
	 * @generated
	 */
	void setLayerBlocked(boolean value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerBlocked <em>Layer Blocked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLayerBlocked()
	 * @see #isLayerBlocked()
	 * @see #setLayerBlocked(boolean)
	 * @generated
	 */
	void unsetLayerBlocked();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerBlocked <em>Layer Blocked</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Layer Blocked</em>' attribute is set.
	 * @see #unsetLayerBlocked()
	 * @see #isLayerBlocked()
	 * @see #setLayerBlocked(boolean)
	 * @generated
	 */
	boolean isSetLayerBlocked();

	/**
	 * Returns the value of the '<em><b>Layer Styles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcPresentationStyleSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Styles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Styles</em>' reference list.
	 * @see #isSetLayerStyles()
	 * @see #unsetLayerStyles()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPresentationLayerWithStyle_LayerStyles()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcPresentationStyleSelect> getLayerStyles();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#getLayerStyles <em>Layer Styles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLayerStyles()
	 * @see #getLayerStyles()
	 * @generated
	 */
	void unsetLayerStyles();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#getLayerStyles <em>Layer Styles</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Layer Styles</em>' reference list is set.
	 * @see #unsetLayerStyles()
	 * @see #getLayerStyles()
	 * @generated
	 */
	boolean isSetLayerStyles();

} // IfcPresentationLayerWithStyle
