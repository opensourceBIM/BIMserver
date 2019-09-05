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
 * A representation of the model object '<em><b>Ifc Complex Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcComplexProperty#getUsageName <em>Usage Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcComplexProperty#getHasProperties <em>Has Properties</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcComplexProperty()
 * @model
 * @generated
 */
public interface IfcComplexProperty extends IfcProperty {
	/**
	 * Returns the value of the '<em><b>Usage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Name</em>' attribute.
	 * @see #setUsageName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcComplexProperty_UsageName()
	 * @model
	 * @generated
	 */
	String getUsageName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcComplexProperty#getUsageName <em>Usage Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Name</em>' attribute.
	 * @see #getUsageName()
	 * @generated
	 */
	void setUsageName(String value);

	/**
	 * Returns the value of the '<em><b>Has Properties</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcProperty}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcProperty#getPartOfComplex <em>Part Of Complex</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Properties</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcComplexProperty_HasProperties()
	 * @see org.bimserver.models.ifc4.IfcProperty#getPartOfComplex
	 * @model opposite="PartOfComplex"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcProperty> getHasProperties();

} // IfcComplexProperty
