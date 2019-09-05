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
 * A representation of the model object '<em><b>Ifc Inventory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcInventory#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcInventory#getJurisdiction <em>Jurisdiction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcInventory#getResponsiblePersons <em>Responsible Persons</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcInventory#getLastUpdateDate <em>Last Update Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcInventory#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcInventory#getOriginalValue <em>Original Value</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcInventory()
 * @model
 * @generated
 */
public interface IfcInventory extends IfcGroup {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcInventoryTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcInventoryTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcInventoryTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcInventory_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcInventoryTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcInventoryTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcInventoryTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcInventoryTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcInventoryTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

	/**
	 * Returns the value of the '<em><b>Jurisdiction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jurisdiction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jurisdiction</em>' reference.
	 * @see #isSetJurisdiction()
	 * @see #unsetJurisdiction()
	 * @see #setJurisdiction(IfcActorSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcInventory_Jurisdiction()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getJurisdiction();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getJurisdiction <em>Jurisdiction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jurisdiction</em>' reference.
	 * @see #isSetJurisdiction()
	 * @see #unsetJurisdiction()
	 * @see #getJurisdiction()
	 * @generated
	 */
	void setJurisdiction(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getJurisdiction <em>Jurisdiction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetJurisdiction()
	 * @see #getJurisdiction()
	 * @see #setJurisdiction(IfcActorSelect)
	 * @generated
	 */
	void unsetJurisdiction();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getJurisdiction <em>Jurisdiction</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Jurisdiction</em>' reference is set.
	 * @see #unsetJurisdiction()
	 * @see #getJurisdiction()
	 * @see #setJurisdiction(IfcActorSelect)
	 * @generated
	 */
	boolean isSetJurisdiction();

	/**
	 * Returns the value of the '<em><b>Responsible Persons</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcPerson}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Responsible Persons</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Responsible Persons</em>' reference list.
	 * @see #isSetResponsiblePersons()
	 * @see #unsetResponsiblePersons()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcInventory_ResponsiblePersons()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcPerson> getResponsiblePersons();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getResponsiblePersons <em>Responsible Persons</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetResponsiblePersons()
	 * @see #getResponsiblePersons()
	 * @generated
	 */
	void unsetResponsiblePersons();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getResponsiblePersons <em>Responsible Persons</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Responsible Persons</em>' reference list is set.
	 * @see #unsetResponsiblePersons()
	 * @see #getResponsiblePersons()
	 * @generated
	 */
	boolean isSetResponsiblePersons();

	/**
	 * Returns the value of the '<em><b>Last Update Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Update Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Update Date</em>' attribute.
	 * @see #isSetLastUpdateDate()
	 * @see #unsetLastUpdateDate()
	 * @see #setLastUpdateDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcInventory_LastUpdateDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLastUpdateDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getLastUpdateDate <em>Last Update Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Update Date</em>' attribute.
	 * @see #isSetLastUpdateDate()
	 * @see #unsetLastUpdateDate()
	 * @see #getLastUpdateDate()
	 * @generated
	 */
	void setLastUpdateDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getLastUpdateDate <em>Last Update Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLastUpdateDate()
	 * @see #getLastUpdateDate()
	 * @see #setLastUpdateDate(String)
	 * @generated
	 */
	void unsetLastUpdateDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getLastUpdateDate <em>Last Update Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Last Update Date</em>' attribute is set.
	 * @see #unsetLastUpdateDate()
	 * @see #getLastUpdateDate()
	 * @see #setLastUpdateDate(String)
	 * @generated
	 */
	boolean isSetLastUpdateDate();

	/**
	 * Returns the value of the '<em><b>Current Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Value</em>' reference.
	 * @see #isSetCurrentValue()
	 * @see #unsetCurrentValue()
	 * @see #setCurrentValue(IfcCostValue)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcInventory_CurrentValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCostValue getCurrentValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getCurrentValue <em>Current Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Value</em>' reference.
	 * @see #isSetCurrentValue()
	 * @see #unsetCurrentValue()
	 * @see #getCurrentValue()
	 * @generated
	 */
	void setCurrentValue(IfcCostValue value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getCurrentValue <em>Current Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCurrentValue()
	 * @see #getCurrentValue()
	 * @see #setCurrentValue(IfcCostValue)
	 * @generated
	 */
	void unsetCurrentValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getCurrentValue <em>Current Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Current Value</em>' reference is set.
	 * @see #unsetCurrentValue()
	 * @see #getCurrentValue()
	 * @see #setCurrentValue(IfcCostValue)
	 * @generated
	 */
	boolean isSetCurrentValue();

	/**
	 * Returns the value of the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Value</em>' reference.
	 * @see #isSetOriginalValue()
	 * @see #unsetOriginalValue()
	 * @see #setOriginalValue(IfcCostValue)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcInventory_OriginalValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCostValue getOriginalValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getOriginalValue <em>Original Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Value</em>' reference.
	 * @see #isSetOriginalValue()
	 * @see #unsetOriginalValue()
	 * @see #getOriginalValue()
	 * @generated
	 */
	void setOriginalValue(IfcCostValue value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getOriginalValue <em>Original Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOriginalValue()
	 * @see #getOriginalValue()
	 * @see #setOriginalValue(IfcCostValue)
	 * @generated
	 */
	void unsetOriginalValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcInventory#getOriginalValue <em>Original Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Original Value</em>' reference is set.
	 * @see #unsetOriginalValue()
	 * @see #getOriginalValue()
	 * @see #setOriginalValue(IfcCostValue)
	 * @generated
	 */
	boolean isSetOriginalValue();

} // IfcInventory
