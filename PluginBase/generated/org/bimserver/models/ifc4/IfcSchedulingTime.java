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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Scheduling Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcSchedulingTime#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSchedulingTime#getDataOrigin <em>Data Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSchedulingTime#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSchedulingTime()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcSchedulingTime extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSchedulingTime_Name()
	 * @model unsettable="true"
	 *        annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSchedulingTime#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSchedulingTime#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSchedulingTime#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

	/**
	 * Returns the value of the '<em><b>Data Origin</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcDataOriginEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Origin</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDataOriginEnum
	 * @see #isSetDataOrigin()
	 * @see #unsetDataOrigin()
	 * @see #setDataOrigin(IfcDataOriginEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSchedulingTime_DataOrigin()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDataOriginEnum getDataOrigin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSchedulingTime#getDataOrigin <em>Data Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Origin</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDataOriginEnum
	 * @see #isSetDataOrigin()
	 * @see #unsetDataOrigin()
	 * @see #getDataOrigin()
	 * @generated
	 */
	void setDataOrigin(IfcDataOriginEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSchedulingTime#getDataOrigin <em>Data Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDataOrigin()
	 * @see #getDataOrigin()
	 * @see #setDataOrigin(IfcDataOriginEnum)
	 * @generated
	 */
	void unsetDataOrigin();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSchedulingTime#getDataOrigin <em>Data Origin</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Data Origin</em>' attribute is set.
	 * @see #unsetDataOrigin()
	 * @see #getDataOrigin()
	 * @see #setDataOrigin(IfcDataOriginEnum)
	 * @generated
	 */
	boolean isSetDataOrigin();

	/**
	 * Returns the value of the '<em><b>User Defined Data Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Data Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Data Origin</em>' attribute.
	 * @see #isSetUserDefinedDataOrigin()
	 * @see #unsetUserDefinedDataOrigin()
	 * @see #setUserDefinedDataOrigin(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSchedulingTime_UserDefinedDataOrigin()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedDataOrigin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSchedulingTime#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Data Origin</em>' attribute.
	 * @see #isSetUserDefinedDataOrigin()
	 * @see #unsetUserDefinedDataOrigin()
	 * @see #getUserDefinedDataOrigin()
	 * @generated
	 */
	void setUserDefinedDataOrigin(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSchedulingTime#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedDataOrigin()
	 * @see #getUserDefinedDataOrigin()
	 * @see #setUserDefinedDataOrigin(String)
	 * @generated
	 */
	void unsetUserDefinedDataOrigin();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSchedulingTime#getUserDefinedDataOrigin <em>User Defined Data Origin</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Data Origin</em>' attribute is set.
	 * @see #unsetUserDefinedDataOrigin()
	 * @see #getUserDefinedDataOrigin()
	 * @see #setUserDefinedDataOrigin(String)
	 * @generated
	 */
	boolean isSetUserDefinedDataOrigin();

} // IfcSchedulingTime
