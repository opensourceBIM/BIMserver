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

public interface IfcPropertyReferenceValue extends IfcSimpleProperty {
	/**
	 * Returns the value of the '<em><b>Usage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Name</em>' attribute.
	 * @see #isSetUsageName()
	 * @see #unsetUsageName()
	 * @see #setUsageName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyReferenceValue_UsageName()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUsageName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyReferenceValue#getUsageName <em>Usage Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Name</em>' attribute.
	 * @see #isSetUsageName()
	 * @see #unsetUsageName()
	 * @see #getUsageName()
	 * @generated
	 */
	void setUsageName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyReferenceValue#getUsageName <em>Usage Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUsageName()
	 * @see #getUsageName()
	 * @see #setUsageName(String)
	 * @generated
	 */
	void unsetUsageName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyReferenceValue#getUsageName <em>Usage Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Usage Name</em>' attribute is set.
	 * @see #unsetUsageName()
	 * @see #getUsageName()
	 * @see #setUsageName(String)
	 * @generated
	 */
	boolean isSetUsageName();

	/**
	 * Returns the value of the '<em><b>Property Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Reference</em>' reference.
	 * @see #isSetPropertyReference()
	 * @see #unsetPropertyReference()
	 * @see #setPropertyReference(IfcObjectReferenceSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyReferenceValue_PropertyReference()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcObjectReferenceSelect getPropertyReference();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyReferenceValue#getPropertyReference <em>Property Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Reference</em>' reference.
	 * @see #isSetPropertyReference()
	 * @see #unsetPropertyReference()
	 * @see #getPropertyReference()
	 * @generated
	 */
	void setPropertyReference(IfcObjectReferenceSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyReferenceValue#getPropertyReference <em>Property Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPropertyReference()
	 * @see #getPropertyReference()
	 * @see #setPropertyReference(IfcObjectReferenceSelect)
	 * @generated
	 */
	void unsetPropertyReference();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyReferenceValue#getPropertyReference <em>Property Reference</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Property Reference</em>' reference is set.
	 * @see #unsetPropertyReference()
	 * @see #getPropertyReference()
	 * @see #setPropertyReference(IfcObjectReferenceSelect)
	 * @generated
	 */
	boolean isSetPropertyReference();

} // IfcPropertyReferenceValue
