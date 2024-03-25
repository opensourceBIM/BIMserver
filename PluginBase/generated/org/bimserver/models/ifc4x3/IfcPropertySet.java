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
 * A representation of the model object '<em><b>Ifc Property Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPropertySet#getHasProperties <em>Has Properties</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPropertySet()
 * @model
 * @generated
 */
public interface IfcPropertySet extends IfcPropertySetDefinition {
	/**
	 * Returns the value of the '<em><b>Has Properties</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcProperty}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcProperty#getPartOfPset <em>Part Of Pset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Properties</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPropertySet_HasProperties()
	 * @see org.bimserver.models.ifc4x3.IfcProperty#getPartOfPset
	 * @model opposite="PartOfPset"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcProperty> getHasProperties();

} // IfcPropertySet
