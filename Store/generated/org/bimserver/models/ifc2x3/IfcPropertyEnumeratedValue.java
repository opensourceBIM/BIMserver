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
 * A representation of the model object '<em><b>Ifc Property Enumerated Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue#getEnumerationValues <em>Enumeration Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyEnumeratedValue()
 * @model
 * @generated
 */
public interface IfcPropertyEnumeratedValue extends IfcSimpleProperty
{
	/**
	 * Returns the value of the '<em><b>Enumeration Values</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration Values</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyEnumeratedValue_EnumerationValues()
	 * @model
	 * @generated
	 */
	EList<IfcValue> getEnumerationValues();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyEnumeratedValue_EnumerationReference()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPropertyEnumeration getEnumerationReference();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEnumerationReference()
	 * @see #getEnumerationReference()
	 * @see #setEnumerationReference(IfcPropertyEnumeration)
	 * @generated
	 */
	void unsetEnumerationReference();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}' reference is set.
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
