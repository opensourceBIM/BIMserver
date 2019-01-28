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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcTransportElement extends IfcElement {
	/**
	 * Returns the value of the '<em><b>Operation Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcTransportElementTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcTransportElementTypeEnum
	 * @see #isSetOperationType()
	 * @see #unsetOperationType()
	 * @see #setOperationType(IfcTransportElementTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTransportElement_OperationType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTransportElementTypeEnum getOperationType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getOperationType <em>Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcTransportElementTypeEnum
	 * @see #isSetOperationType()
	 * @see #unsetOperationType()
	 * @see #getOperationType()
	 * @generated
	 */
	void setOperationType(IfcTransportElementTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getOperationType <em>Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOperationType()
	 * @see #getOperationType()
	 * @see #setOperationType(IfcTransportElementTypeEnum)
	 * @generated
	 */
	void unsetOperationType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getOperationType <em>Operation Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Operation Type</em>' attribute is set.
	 * @see #unsetOperationType()
	 * @see #getOperationType()
	 * @see #setOperationType(IfcTransportElementTypeEnum)
	 * @generated
	 */
	boolean isSetOperationType();

	/**
	 * Returns the value of the '<em><b>Capacity By Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity By Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity By Weight</em>' attribute.
	 * @see #isSetCapacityByWeight()
	 * @see #unsetCapacityByWeight()
	 * @see #setCapacityByWeight(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTransportElement_CapacityByWeight()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCapacityByWeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByWeight <em>Capacity By Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity By Weight</em>' attribute.
	 * @see #isSetCapacityByWeight()
	 * @see #unsetCapacityByWeight()
	 * @see #getCapacityByWeight()
	 * @generated
	 */
	void setCapacityByWeight(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByWeight <em>Capacity By Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCapacityByWeight()
	 * @see #getCapacityByWeight()
	 * @see #setCapacityByWeight(double)
	 * @generated
	 */
	void unsetCapacityByWeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByWeight <em>Capacity By Weight</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Capacity By Weight</em>' attribute is set.
	 * @see #unsetCapacityByWeight()
	 * @see #getCapacityByWeight()
	 * @see #setCapacityByWeight(double)
	 * @generated
	 */
	boolean isSetCapacityByWeight();

	/**
	 * Returns the value of the '<em><b>Capacity By Weight As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity By Weight As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity By Weight As String</em>' attribute.
	 * @see #isSetCapacityByWeightAsString()
	 * @see #unsetCapacityByWeightAsString()
	 * @see #setCapacityByWeightAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTransportElement_CapacityByWeightAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCapacityByWeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByWeightAsString <em>Capacity By Weight As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity By Weight As String</em>' attribute.
	 * @see #isSetCapacityByWeightAsString()
	 * @see #unsetCapacityByWeightAsString()
	 * @see #getCapacityByWeightAsString()
	 * @generated
	 */
	void setCapacityByWeightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByWeightAsString <em>Capacity By Weight As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCapacityByWeightAsString()
	 * @see #getCapacityByWeightAsString()
	 * @see #setCapacityByWeightAsString(String)
	 * @generated
	 */
	void unsetCapacityByWeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByWeightAsString <em>Capacity By Weight As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Capacity By Weight As String</em>' attribute is set.
	 * @see #unsetCapacityByWeightAsString()
	 * @see #getCapacityByWeightAsString()
	 * @see #setCapacityByWeightAsString(String)
	 * @generated
	 */
	boolean isSetCapacityByWeightAsString();

	/**
	 * Returns the value of the '<em><b>Capacity By Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity By Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity By Number</em>' attribute.
	 * @see #isSetCapacityByNumber()
	 * @see #unsetCapacityByNumber()
	 * @see #setCapacityByNumber(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTransportElement_CapacityByNumber()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCapacityByNumber();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByNumber <em>Capacity By Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity By Number</em>' attribute.
	 * @see #isSetCapacityByNumber()
	 * @see #unsetCapacityByNumber()
	 * @see #getCapacityByNumber()
	 * @generated
	 */
	void setCapacityByNumber(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByNumber <em>Capacity By Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCapacityByNumber()
	 * @see #getCapacityByNumber()
	 * @see #setCapacityByNumber(double)
	 * @generated
	 */
	void unsetCapacityByNumber();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByNumber <em>Capacity By Number</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Capacity By Number</em>' attribute is set.
	 * @see #unsetCapacityByNumber()
	 * @see #getCapacityByNumber()
	 * @see #setCapacityByNumber(double)
	 * @generated
	 */
	boolean isSetCapacityByNumber();

	/**
	 * Returns the value of the '<em><b>Capacity By Number As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity By Number As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity By Number As String</em>' attribute.
	 * @see #isSetCapacityByNumberAsString()
	 * @see #unsetCapacityByNumberAsString()
	 * @see #setCapacityByNumberAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTransportElement_CapacityByNumberAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCapacityByNumberAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByNumberAsString <em>Capacity By Number As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity By Number As String</em>' attribute.
	 * @see #isSetCapacityByNumberAsString()
	 * @see #unsetCapacityByNumberAsString()
	 * @see #getCapacityByNumberAsString()
	 * @generated
	 */
	void setCapacityByNumberAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByNumberAsString <em>Capacity By Number As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCapacityByNumberAsString()
	 * @see #getCapacityByNumberAsString()
	 * @see #setCapacityByNumberAsString(String)
	 * @generated
	 */
	void unsetCapacityByNumberAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTransportElement#getCapacityByNumberAsString <em>Capacity By Number As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Capacity By Number As String</em>' attribute is set.
	 * @see #unsetCapacityByNumberAsString()
	 * @see #getCapacityByNumberAsString()
	 * @see #setCapacityByNumberAsString(String)
	 * @generated
	 */
	boolean isSetCapacityByNumberAsString();

} // IfcTransportElement
