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
 * A representation of the model object '<em><b>Ifc Type Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcTypeResource#getIdentification <em>Identification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTypeResource#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTypeResource#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTypeResource#getResourceOf <em>Resource Of</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTypeResource()
 * @model
 * @generated
 */
public interface IfcTypeResource extends IfcTypeObject, IfcResourceSelect {
	/**
	 * Returns the value of the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identification</em>' attribute.
	 * @see #isSetIdentification()
	 * @see #unsetIdentification()
	 * @see #setIdentification(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTypeResource_Identification()
	 * @model unsettable="true"
	 * @generated
	 */
	String getIdentification();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTypeResource#getIdentification <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identification</em>' attribute.
	 * @see #isSetIdentification()
	 * @see #unsetIdentification()
	 * @see #getIdentification()
	 * @generated
	 */
	void setIdentification(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTypeResource#getIdentification <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIdentification()
	 * @see #getIdentification()
	 * @see #setIdentification(String)
	 * @generated
	 */
	void unsetIdentification();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTypeResource#getIdentification <em>Identification</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Identification</em>' attribute is set.
	 * @see #unsetIdentification()
	 * @see #getIdentification()
	 * @see #setIdentification(String)
	 * @generated
	 */
	boolean isSetIdentification();

	/**
	 * Returns the value of the '<em><b>Long Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Description</em>' attribute.
	 * @see #isSetLongDescription()
	 * @see #unsetLongDescription()
	 * @see #setLongDescription(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTypeResource_LongDescription()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLongDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTypeResource#getLongDescription <em>Long Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Description</em>' attribute.
	 * @see #isSetLongDescription()
	 * @see #unsetLongDescription()
	 * @see #getLongDescription()
	 * @generated
	 */
	void setLongDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTypeResource#getLongDescription <em>Long Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongDescription()
	 * @see #getLongDescription()
	 * @see #setLongDescription(String)
	 * @generated
	 */
	void unsetLongDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTypeResource#getLongDescription <em>Long Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Long Description</em>' attribute is set.
	 * @see #unsetLongDescription()
	 * @see #getLongDescription()
	 * @see #setLongDescription(String)
	 * @generated
	 */
	boolean isSetLongDescription();

	/**
	 * Returns the value of the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Type</em>' attribute.
	 * @see #isSetResourceType()
	 * @see #unsetResourceType()
	 * @see #setResourceType(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTypeResource_ResourceType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getResourceType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTypeResource#getResourceType <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Type</em>' attribute.
	 * @see #isSetResourceType()
	 * @see #unsetResourceType()
	 * @see #getResourceType()
	 * @generated
	 */
	void setResourceType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTypeResource#getResourceType <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetResourceType()
	 * @see #getResourceType()
	 * @see #setResourceType(String)
	 * @generated
	 */
	void unsetResourceType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTypeResource#getResourceType <em>Resource Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Resource Type</em>' attribute is set.
	 * @see #unsetResourceType()
	 * @see #getResourceType()
	 * @see #setResourceType(String)
	 * @generated
	 */
	boolean isSetResourceType();

	/**
	 * Returns the value of the '<em><b>Resource Of</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssignsToResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Of</em>' reference list.
	 * @see #isSetResourceOf()
	 * @see #unsetResourceOf()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTypeResource_ResourceOf()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssignsToResource> getResourceOf();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTypeResource#getResourceOf <em>Resource Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetResourceOf()
	 * @see #getResourceOf()
	 * @generated
	 */
	void unsetResourceOf();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTypeResource#getResourceOf <em>Resource Of</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Resource Of</em>' reference list is set.
	 * @see #unsetResourceOf()
	 * @see #getResourceOf()
	 * @generated
	 */
	boolean isSetResourceOf();

} // IfcTypeResource
