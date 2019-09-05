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
 * A representation of the model object '<em><b>Ifc Conversion Based Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcConversionBasedUnit#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcConversionBasedUnit#getConversionFactor <em>Conversion Factor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcConversionBasedUnit#getHasExternalReference <em>Has External Reference</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConversionBasedUnit()
 * @model
 * @generated
 */
public interface IfcConversionBasedUnit extends IfcNamedUnit, IfcResourceObjectSelect {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConversionBasedUnit_Name()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConversionBasedUnit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Conversion Factor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conversion Factor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conversion Factor</em>' reference.
	 * @see #setConversionFactor(IfcMeasureWithUnit)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConversionBasedUnit_ConversionFactor()
	 * @model
	 * @generated
	 */
	IfcMeasureWithUnit getConversionFactor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConversionBasedUnit#getConversionFactor <em>Conversion Factor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conversion Factor</em>' reference.
	 * @see #getConversionFactor()
	 * @generated
	 */
	void setConversionFactor(IfcMeasureWithUnit value);

	/**
	 * Returns the value of the '<em><b>Has External Reference</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcExternalReferenceRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has External Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has External Reference</em>' reference list.
	 * @see #isSetHasExternalReference()
	 * @see #unsetHasExternalReference()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConversionBasedUnit_HasExternalReference()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcExternalReferenceRelationship> getHasExternalReference();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConversionBasedUnit#getHasExternalReference <em>Has External Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasExternalReference()
	 * @see #getHasExternalReference()
	 * @generated
	 */
	void unsetHasExternalReference();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConversionBasedUnit#getHasExternalReference <em>Has External Reference</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has External Reference</em>' reference list is set.
	 * @see #unsetHasExternalReference()
	 * @see #getHasExternalReference()
	 * @generated
	 */
	boolean isSetHasExternalReference();

} // IfcConversionBasedUnit
