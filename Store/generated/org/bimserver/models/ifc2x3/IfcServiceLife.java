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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Service Life</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcServiceLife#getServiceLifeType <em>Service Life Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcServiceLife#getServiceLifeDuration <em>Service Life Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcServiceLife#getServiceLifeDurationAsString <em>Service Life Duration As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcServiceLife()
 * @model
 * @generated
 */
public interface IfcServiceLife extends IfcControl
{
	/**
	 * Returns the value of the '<em><b>Service Life Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcServiceLifeTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Life Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Life Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcServiceLifeTypeEnum
	 * @see #setServiceLifeType(IfcServiceLifeTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcServiceLife_ServiceLifeType()
	 * @model
	 * @generated
	 */
	IfcServiceLifeTypeEnum getServiceLifeType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcServiceLife#getServiceLifeType <em>Service Life Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Life Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcServiceLifeTypeEnum
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
	 * @see #setServiceLifeDuration(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcServiceLife_ServiceLifeDuration()
	 * @model
	 * @generated
	 */
	float getServiceLifeDuration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcServiceLife#getServiceLifeDuration <em>Service Life Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Life Duration</em>' attribute.
	 * @see #getServiceLifeDuration()
	 * @generated
	 */
	void setServiceLifeDuration(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcServiceLife_ServiceLifeDurationAsString()
	 * @model
	 * @generated
	 */
	String getServiceLifeDurationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcServiceLife#getServiceLifeDurationAsString <em>Service Life Duration As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Life Duration As String</em>' attribute.
	 * @see #getServiceLifeDurationAsString()
	 * @generated
	 */
	void setServiceLifeDurationAsString(String value);

} // IfcServiceLife
