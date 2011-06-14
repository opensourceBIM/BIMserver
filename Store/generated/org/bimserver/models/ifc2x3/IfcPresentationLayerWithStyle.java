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
public interface IfcPresentationLayerWithStyle extends IfcPresentationLayerAssignment
{
	/**
	 * Returns the value of the '<em><b>Layer On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer On</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer On</em>' attribute.
	 * @see #setLayerOn(boolean)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPresentationLayerWithStyle_LayerOn()
	 * @model
	 * @generated
	 */
	boolean isLayerOn();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerOn <em>Layer On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer On</em>' attribute.
	 * @see #isLayerOn()
	 * @generated
	 */
	void setLayerOn(boolean value);

	/**
	 * Returns the value of the '<em><b>Layer Frozen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Frozen</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Frozen</em>' attribute.
	 * @see #setLayerFrozen(boolean)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPresentationLayerWithStyle_LayerFrozen()
	 * @model
	 * @generated
	 */
	boolean isLayerFrozen();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerFrozen <em>Layer Frozen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Frozen</em>' attribute.
	 * @see #isLayerFrozen()
	 * @generated
	 */
	void setLayerFrozen(boolean value);

	/**
	 * Returns the value of the '<em><b>Layer Blocked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Blocked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Blocked</em>' attribute.
	 * @see #setLayerBlocked(boolean)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPresentationLayerWithStyle_LayerBlocked()
	 * @model
	 * @generated
	 */
	boolean isLayerBlocked();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle#isLayerBlocked <em>Layer Blocked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Blocked</em>' attribute.
	 * @see #isLayerBlocked()
	 * @generated
	 */
	void setLayerBlocked(boolean value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPresentationLayerWithStyle_LayerStyles()
	 * @model
	 * @generated
	 */
	EList<IfcPresentationStyleSelect> getLayerStyles();

} // IfcPresentationLayerWithStyle
