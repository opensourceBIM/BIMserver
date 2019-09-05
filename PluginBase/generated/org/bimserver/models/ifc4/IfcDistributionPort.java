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

public interface IfcDistributionPort extends IfcPort {
	/**
	 * Returns the value of the '<em><b>Flow Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcFlowDirectionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flow Direction</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcFlowDirectionEnum
	 * @see #isSetFlowDirection()
	 * @see #unsetFlowDirection()
	 * @see #setFlowDirection(IfcFlowDirectionEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDistributionPort_FlowDirection()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcFlowDirectionEnum getFlowDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDistributionPort#getFlowDirection <em>Flow Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flow Direction</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcFlowDirectionEnum
	 * @see #isSetFlowDirection()
	 * @see #unsetFlowDirection()
	 * @see #getFlowDirection()
	 * @generated
	 */
	void setFlowDirection(IfcFlowDirectionEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDistributionPort#getFlowDirection <em>Flow Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFlowDirection()
	 * @see #getFlowDirection()
	 * @see #setFlowDirection(IfcFlowDirectionEnum)
	 * @generated
	 */
	void unsetFlowDirection();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDistributionPort#getFlowDirection <em>Flow Direction</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Flow Direction</em>' attribute is set.
	 * @see #unsetFlowDirection()
	 * @see #getFlowDirection()
	 * @see #setFlowDirection(IfcFlowDirectionEnum)
	 * @generated
	 */
	boolean isSetFlowDirection();

	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcDistributionPortTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDistributionPortTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcDistributionPortTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDistributionPort_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDistributionPortTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDistributionPort#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDistributionPortTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcDistributionPortTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDistributionPort#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcDistributionPortTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDistributionPort#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcDistributionPortTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

	/**
	 * Returns the value of the '<em><b>System Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcDistributionSystemEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDistributionSystemEnum
	 * @see #isSetSystemType()
	 * @see #unsetSystemType()
	 * @see #setSystemType(IfcDistributionSystemEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDistributionPort_SystemType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDistributionSystemEnum getSystemType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDistributionPort#getSystemType <em>System Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDistributionSystemEnum
	 * @see #isSetSystemType()
	 * @see #unsetSystemType()
	 * @see #getSystemType()
	 * @generated
	 */
	void setSystemType(IfcDistributionSystemEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDistributionPort#getSystemType <em>System Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSystemType()
	 * @see #getSystemType()
	 * @see #setSystemType(IfcDistributionSystemEnum)
	 * @generated
	 */
	void unsetSystemType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDistributionPort#getSystemType <em>System Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>System Type</em>' attribute is set.
	 * @see #unsetSystemType()
	 * @see #getSystemType()
	 * @see #setSystemType(IfcDistributionSystemEnum)
	 * @generated
	 */
	boolean isSetSystemType();

} // IfcDistributionPort
