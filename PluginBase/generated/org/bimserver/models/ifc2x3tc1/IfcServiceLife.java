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

public interface IfcServiceLife extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Service Life Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcServiceLifeTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Life Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Life Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcServiceLifeTypeEnum
	 * @see #setServiceLifeType(IfcServiceLifeTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcServiceLife_ServiceLifeType()
	 * @model
	 * @generated
	 */
	IfcServiceLifeTypeEnum getServiceLifeType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcServiceLife#getServiceLifeType <em>Service Life Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Life Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcServiceLifeTypeEnum
	 * @see #getServiceLifeType()
	 * @generated
	 */
	void setServiceLifeType(IfcServiceLifeTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Service Life Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Life Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Life Duration</em>' attribute.
	 * @see #setServiceLifeDuration(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcServiceLife_ServiceLifeDuration()
	 * @model
	 * @generated
	 */
	double getServiceLifeDuration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcServiceLife#getServiceLifeDuration <em>Service Life Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Life Duration</em>' attribute.
	 * @see #getServiceLifeDuration()
	 * @generated
	 */
	void setServiceLifeDuration(double value);

	/**
	 * Returns the value of the '<em><b>Service Life Duration As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Life Duration As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Life Duration As String</em>' attribute.
	 * @see #setServiceLifeDurationAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcServiceLife_ServiceLifeDurationAsString()
	 * @model
	 * @generated
	 */
	String getServiceLifeDurationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcServiceLife#getServiceLifeDurationAsString <em>Service Life Duration As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Life Duration As String</em>' attribute.
	 * @see #getServiceLifeDurationAsString()
	 * @generated
	 */
	void setServiceLifeDurationAsString(String value);

} // IfcServiceLife
