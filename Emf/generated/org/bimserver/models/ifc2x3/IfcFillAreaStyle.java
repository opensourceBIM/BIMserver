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
 * A representation of the model object '<em><b>Ifc Fill Area Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFillAreaStyle#getFillStyles <em>Fill Styles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyle()
 * @model
 * @generated
 */
public interface IfcFillAreaStyle extends IfcPresentationStyle, IfcPresentationStyleSelect {
	/**
	 * Returns the value of the '<em><b>Fill Styles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcFillStyleSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fill Styles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill Styles</em>' reference list.
	 * @see #isSetFillStyles()
	 * @see #unsetFillStyles()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyle_FillStyles()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcFillStyleSelect> getFillStyles();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyle#getFillStyles <em>Fill Styles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFillStyles()
	 * @see #getFillStyles()
	 * @generated
	 */
	void unsetFillStyles();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyle#getFillStyles <em>Fill Styles</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fill Styles</em>' reference list is set.
	 * @see #unsetFillStyles()
	 * @see #getFillStyles()
	 * @generated
	 */
	boolean isSetFillStyles();

} // IfcFillAreaStyle
