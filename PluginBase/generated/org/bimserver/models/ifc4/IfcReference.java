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
 * A representation of the model object '<em><b>Ifc Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcReference#getTypeIdentifier <em>Type Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReference#getAttributeIdentifier <em>Attribute Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReference#getInstanceName <em>Instance Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReference#getListPositions <em>List Positions</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcReference#getInnerReference <em>Inner Reference</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReference()
 * @model
 * @generated
 */
public interface IfcReference extends IfcAppliedValueSelect, IfcMetricValueSelect {
	/**
	 * Returns the value of the '<em><b>Type Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Identifier</em>' attribute.
	 * @see #isSetTypeIdentifier()
	 * @see #unsetTypeIdentifier()
	 * @see #setTypeIdentifier(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReference_TypeIdentifier()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTypeIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReference#getTypeIdentifier <em>Type Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Identifier</em>' attribute.
	 * @see #isSetTypeIdentifier()
	 * @see #unsetTypeIdentifier()
	 * @see #getTypeIdentifier()
	 * @generated
	 */
	void setTypeIdentifier(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReference#getTypeIdentifier <em>Type Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTypeIdentifier()
	 * @see #getTypeIdentifier()
	 * @see #setTypeIdentifier(String)
	 * @generated
	 */
	void unsetTypeIdentifier();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReference#getTypeIdentifier <em>Type Identifier</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type Identifier</em>' attribute is set.
	 * @see #unsetTypeIdentifier()
	 * @see #getTypeIdentifier()
	 * @see #setTypeIdentifier(String)
	 * @generated
	 */
	boolean isSetTypeIdentifier();

	/**
	 * Returns the value of the '<em><b>Attribute Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Identifier</em>' attribute.
	 * @see #isSetAttributeIdentifier()
	 * @see #unsetAttributeIdentifier()
	 * @see #setAttributeIdentifier(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReference_AttributeIdentifier()
	 * @model unsettable="true"
	 * @generated
	 */
	String getAttributeIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReference#getAttributeIdentifier <em>Attribute Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Identifier</em>' attribute.
	 * @see #isSetAttributeIdentifier()
	 * @see #unsetAttributeIdentifier()
	 * @see #getAttributeIdentifier()
	 * @generated
	 */
	void setAttributeIdentifier(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReference#getAttributeIdentifier <em>Attribute Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAttributeIdentifier()
	 * @see #getAttributeIdentifier()
	 * @see #setAttributeIdentifier(String)
	 * @generated
	 */
	void unsetAttributeIdentifier();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReference#getAttributeIdentifier <em>Attribute Identifier</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Attribute Identifier</em>' attribute is set.
	 * @see #unsetAttributeIdentifier()
	 * @see #getAttributeIdentifier()
	 * @see #setAttributeIdentifier(String)
	 * @generated
	 */
	boolean isSetAttributeIdentifier();

	/**
	 * Returns the value of the '<em><b>Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Name</em>' attribute.
	 * @see #isSetInstanceName()
	 * @see #unsetInstanceName()
	 * @see #setInstanceName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReference_InstanceName()
	 * @model unsettable="true"
	 * @generated
	 */
	String getInstanceName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReference#getInstanceName <em>Instance Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Name</em>' attribute.
	 * @see #isSetInstanceName()
	 * @see #unsetInstanceName()
	 * @see #getInstanceName()
	 * @generated
	 */
	void setInstanceName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReference#getInstanceName <em>Instance Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInstanceName()
	 * @see #getInstanceName()
	 * @see #setInstanceName(String)
	 * @generated
	 */
	void unsetInstanceName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReference#getInstanceName <em>Instance Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Instance Name</em>' attribute is set.
	 * @see #unsetInstanceName()
	 * @see #getInstanceName()
	 * @see #setInstanceName(String)
	 * @generated
	 */
	boolean isSetInstanceName();

	/**
	 * Returns the value of the '<em><b>List Positions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Positions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List Positions</em>' attribute list.
	 * @see #isSetListPositions()
	 * @see #unsetListPositions()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReference_ListPositions()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Long> getListPositions();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReference#getListPositions <em>List Positions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetListPositions()
	 * @see #getListPositions()
	 * @generated
	 */
	void unsetListPositions();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReference#getListPositions <em>List Positions</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>List Positions</em>' attribute list is set.
	 * @see #unsetListPositions()
	 * @see #getListPositions()
	 * @generated
	 */
	boolean isSetListPositions();

	/**
	 * Returns the value of the '<em><b>Inner Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Reference</em>' reference.
	 * @see #isSetInnerReference()
	 * @see #unsetInnerReference()
	 * @see #setInnerReference(IfcReference)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReference_InnerReference()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcReference getInnerReference();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReference#getInnerReference <em>Inner Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Reference</em>' reference.
	 * @see #isSetInnerReference()
	 * @see #unsetInnerReference()
	 * @see #getInnerReference()
	 * @generated
	 */
	void setInnerReference(IfcReference value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReference#getInnerReference <em>Inner Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInnerReference()
	 * @see #getInnerReference()
	 * @see #setInnerReference(IfcReference)
	 * @generated
	 */
	void unsetInnerReference();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReference#getInnerReference <em>Inner Reference</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inner Reference</em>' reference is set.
	 * @see #unsetInnerReference()
	 * @see #getInnerReference()
	 * @see #setInnerReference(IfcReference)
	 * @generated
	 */
	boolean isSetInnerReference();

} // IfcReference
