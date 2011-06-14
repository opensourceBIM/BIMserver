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
 * A representation of the model object '<em><b>Ifc Energy Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getEnergySequence <em>Energy Sequence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getUserDefinedEnergySequence <em>User Defined Energy Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnergyProperties()
 * @model
 * @generated
 */
public interface IfcEnergyProperties extends IfcPropertySetDefinition
{
	/**
	 * Returns the value of the '<em><b>Energy Sequence</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcEnergySequenceEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Energy Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Energy Sequence</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcEnergySequenceEnum
	 * @see #setEnergySequence(IfcEnergySequenceEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnergyProperties_EnergySequence()
	 * @model
	 * @generated
	 */
	IfcEnergySequenceEnum getEnergySequence();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getEnergySequence <em>Energy Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Energy Sequence</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcEnergySequenceEnum
	 * @see #getEnergySequence()
	 * @generated
	 */
	void setEnergySequence(IfcEnergySequenceEnum value);

	/**
	 * Returns the value of the '<em><b>User Defined Energy Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Energy Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Energy Sequence</em>' attribute.
	 * @see #isSetUserDefinedEnergySequence()
	 * @see #unsetUserDefinedEnergySequence()
	 * @see #setUserDefinedEnergySequence(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnergyProperties_UserDefinedEnergySequence()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedEnergySequence();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getUserDefinedEnergySequence <em>User Defined Energy Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Energy Sequence</em>' attribute.
	 * @see #isSetUserDefinedEnergySequence()
	 * @see #unsetUserDefinedEnergySequence()
	 * @see #getUserDefinedEnergySequence()
	 * @generated
	 */
	void setUserDefinedEnergySequence(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getUserDefinedEnergySequence <em>User Defined Energy Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedEnergySequence()
	 * @see #getUserDefinedEnergySequence()
	 * @see #setUserDefinedEnergySequence(String)
	 * @generated
	 */
	void unsetUserDefinedEnergySequence();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getUserDefinedEnergySequence <em>User Defined Energy Sequence</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Energy Sequence</em>' attribute is set.
	 * @see #unsetUserDefinedEnergySequence()
	 * @see #getUserDefinedEnergySequence()
	 * @see #setUserDefinedEnergySequence(String)
	 * @generated
	 */
	boolean isSetUserDefinedEnergySequence();

} // IfcEnergyProperties
