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
 * A representation of the model object '<em><b>Ifc Property Enumerated Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcPropertyEnumeratedValue#getEnumerationValues <em>Enumeration Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyEnumeratedValue()
 * @model
 * @generated
 */
public interface IfcPropertyEnumeratedValue extends IfcSimpleProperty {
	/**
	 * Returns the value of the '<em><b>Enumeration Values</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration Values</em>' reference list.
	 * @see #isSetEnumerationValues()
	 * @see #unsetEnumerationValues()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyEnumeratedValue_EnumerationValues()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcValue> getEnumerationValues();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyEnumeratedValue#getEnumerationValues <em>Enumeration Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEnumerationValues()
	 * @see #getEnumerationValues()
	 * @generated
	 */
	void unsetEnumerationValues();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyEnumeratedValue#getEnumerationValues <em>Enumeration Values</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Enumeration Values</em>' reference list is set.
	 * @see #unsetEnumerationValues()
	 * @see #getEnumerationValues()
	 * @generated
	 */
	boolean isSetEnumerationValues();

	/**
	 * Returns the value of the '<em><b>Enumeration Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration Reference</em>' reference.
	 * @see #isSetEnumerationReference()
	 * @see #unsetEnumerationReference()
	 * @see #setEnumerationReference(IfcPropertyEnumeration)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyEnumeratedValue_EnumerationReference()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPropertyEnumeration getEnumerationReference();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration Reference</em>' reference.
	 * @see #isSetEnumerationReference()
	 * @see #unsetEnumerationReference()
	 * @see #getEnumerationReference()
	 * @generated
	 */
	void setEnumerationReference(IfcPropertyEnumeration value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEnumerationReference()
	 * @see #getEnumerationReference()
	 * @see #setEnumerationReference(IfcPropertyEnumeration)
	 * @generated
	 */
	void unsetEnumerationReference();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Enumeration Reference</em>' reference is set.
	 * @see #unsetEnumerationReference()
	 * @see #getEnumerationReference()
	 * @see #setEnumerationReference(IfcPropertyEnumeration)
	 * @generated
	 */
	boolean isSetEnumerationReference();

} // IfcPropertyEnumeratedValue
