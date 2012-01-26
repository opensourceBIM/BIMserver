/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Project Order Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProjectOrderRecord#getRecords <em>Records</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProjectOrderRecord#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProjectOrderRecord()
 * @model
 * @generated
 */
public interface IfcProjectOrderRecord extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Records</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelAssignsToProjectOrder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Records</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Records</em>' reference list.
	 * @see #isSetRecords()
	 * @see #unsetRecords()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProjectOrderRecord_Records()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcRelAssignsToProjectOrder> getRecords();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcProjectOrderRecord#getRecords <em>Records</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRecords()
	 * @see #getRecords()
	 * @generated
	 */
	void unsetRecords();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcProjectOrderRecord#getRecords <em>Records</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Records</em>' reference list is set.
	 * @see #unsetRecords()
	 * @see #getRecords()
	 * @generated
	 */
	boolean isSetRecords();

	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcProjectOrderRecordTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcProjectOrderRecordTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcProjectOrderRecordTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProjectOrderRecord_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcProjectOrderRecordTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcProjectOrderRecord#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcProjectOrderRecordTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcProjectOrderRecordTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcProjectOrderRecord#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcProjectOrderRecordTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcProjectOrderRecord#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcProjectOrderRecordTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

} // IfcProjectOrderRecord
