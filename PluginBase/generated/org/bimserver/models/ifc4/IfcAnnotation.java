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
 * A representation of the model object '<em><b>Ifc Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcAnnotation#getContainedInStructure <em>Contained In Structure</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAnnotation()
 * @model
 * @generated
 */
public interface IfcAnnotation extends IfcProduct {
	/**
	 * Returns the value of the '<em><b>Contained In Structure</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelContainedInSpatialStructure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained In Structure</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained In Structure</em>' reference list.
	 * @see #isSetContainedInStructure()
	 * @see #unsetContainedInStructure()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAnnotation_ContainedInStructure()
	 * @model unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelContainedInSpatialStructure> getContainedInStructure();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAnnotation#getContainedInStructure <em>Contained In Structure</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContainedInStructure()
	 * @see #getContainedInStructure()
	 * @generated
	 */
	void unsetContainedInStructure();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAnnotation#getContainedInStructure <em>Contained In Structure</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Contained In Structure</em>' reference list is set.
	 * @see #unsetContainedInStructure()
	 * @see #getContainedInStructure()
	 * @generated
	 */
	boolean isSetContainedInStructure();

} // IfcAnnotation
