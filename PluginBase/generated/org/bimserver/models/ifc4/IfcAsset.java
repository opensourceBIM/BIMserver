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

public interface IfcAsset extends IfcGroup {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsset_Identification()
	 * @model unsettable="true"
	 * @generated
	 */
	String getIdentification();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getIdentification <em>Identification</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getIdentification <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIdentification()
	 * @see #getIdentification()
	 * @see #setIdentification(String)
	 * @generated
	 */
	void unsetIdentification();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getIdentification <em>Identification</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsset_OriginalValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCostValue getOriginalValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getOriginalValue <em>Original Value</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getOriginalValue <em>Original Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOriginalValue()
	 * @see #getOriginalValue()
	 * @see #setOriginalValue(IfcCostValue)
	 * @generated
	 */
	void unsetOriginalValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getOriginalValue <em>Original Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Original Value</em>' reference is set.
	 * @see #unsetOriginalValue()
	 * @see #getOriginalValue()
	 * @see #setOriginalValue(IfcCostValue)
	 * @generated
	 */
	boolean isSetOriginalValue();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsset_CurrentValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCostValue getCurrentValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getCurrentValue <em>Current Value</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getCurrentValue <em>Current Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCurrentValue()
	 * @see #getCurrentValue()
	 * @see #setCurrentValue(IfcCostValue)
	 * @generated
	 */
	void unsetCurrentValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getCurrentValue <em>Current Value</em>}' reference is set.
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
	 * Returns the value of the '<em><b>Total Replacement Cost</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Replacement Cost</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Replacement Cost</em>' reference.
	 * @see #isSetTotalReplacementCost()
	 * @see #unsetTotalReplacementCost()
	 * @see #setTotalReplacementCost(IfcCostValue)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsset_TotalReplacementCost()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCostValue getTotalReplacementCost();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getTotalReplacementCost <em>Total Replacement Cost</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Replacement Cost</em>' reference.
	 * @see #isSetTotalReplacementCost()
	 * @see #unsetTotalReplacementCost()
	 * @see #getTotalReplacementCost()
	 * @generated
	 */
	void setTotalReplacementCost(IfcCostValue value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getTotalReplacementCost <em>Total Replacement Cost</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTotalReplacementCost()
	 * @see #getTotalReplacementCost()
	 * @see #setTotalReplacementCost(IfcCostValue)
	 * @generated
	 */
	void unsetTotalReplacementCost();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getTotalReplacementCost <em>Total Replacement Cost</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Total Replacement Cost</em>' reference is set.
	 * @see #unsetTotalReplacementCost()
	 * @see #getTotalReplacementCost()
	 * @see #setTotalReplacementCost(IfcCostValue)
	 * @generated
	 */
	boolean isSetTotalReplacementCost();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #isSetOwner()
	 * @see #unsetOwner()
	 * @see #setOwner(IfcActorSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsset_Owner()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getOwner();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #isSetOwner()
	 * @see #unsetOwner()
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOwner()
	 * @see #getOwner()
	 * @see #setOwner(IfcActorSelect)
	 * @generated
	 */
	void unsetOwner();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getOwner <em>Owner</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Owner</em>' reference is set.
	 * @see #unsetOwner()
	 * @see #getOwner()
	 * @see #setOwner(IfcActorSelect)
	 * @generated
	 */
	boolean isSetOwner();

	/**
	 * Returns the value of the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' reference.
	 * @see #isSetUser()
	 * @see #unsetUser()
	 * @see #setUser(IfcActorSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsset_User()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getUser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' reference.
	 * @see #isSetUser()
	 * @see #unsetUser()
	 * @see #getUser()
	 * @generated
	 */
	void setUser(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUser()
	 * @see #getUser()
	 * @see #setUser(IfcActorSelect)
	 * @generated
	 */
	void unsetUser();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getUser <em>User</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User</em>' reference is set.
	 * @see #unsetUser()
	 * @see #getUser()
	 * @see #setUser(IfcActorSelect)
	 * @generated
	 */
	boolean isSetUser();

	/**
	 * Returns the value of the '<em><b>Responsible Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Responsible Person</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Responsible Person</em>' reference.
	 * @see #isSetResponsiblePerson()
	 * @see #unsetResponsiblePerson()
	 * @see #setResponsiblePerson(IfcPerson)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsset_ResponsiblePerson()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPerson getResponsiblePerson();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getResponsiblePerson <em>Responsible Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsible Person</em>' reference.
	 * @see #isSetResponsiblePerson()
	 * @see #unsetResponsiblePerson()
	 * @see #getResponsiblePerson()
	 * @generated
	 */
	void setResponsiblePerson(IfcPerson value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getResponsiblePerson <em>Responsible Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetResponsiblePerson()
	 * @see #getResponsiblePerson()
	 * @see #setResponsiblePerson(IfcPerson)
	 * @generated
	 */
	void unsetResponsiblePerson();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getResponsiblePerson <em>Responsible Person</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Responsible Person</em>' reference is set.
	 * @see #unsetResponsiblePerson()
	 * @see #getResponsiblePerson()
	 * @see #setResponsiblePerson(IfcPerson)
	 * @generated
	 */
	boolean isSetResponsiblePerson();

	/**
	 * Returns the value of the '<em><b>Incorporation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incorporation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incorporation Date</em>' attribute.
	 * @see #isSetIncorporationDate()
	 * @see #unsetIncorporationDate()
	 * @see #setIncorporationDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsset_IncorporationDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getIncorporationDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getIncorporationDate <em>Incorporation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incorporation Date</em>' attribute.
	 * @see #isSetIncorporationDate()
	 * @see #unsetIncorporationDate()
	 * @see #getIncorporationDate()
	 * @generated
	 */
	void setIncorporationDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getIncorporationDate <em>Incorporation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIncorporationDate()
	 * @see #getIncorporationDate()
	 * @see #setIncorporationDate(String)
	 * @generated
	 */
	void unsetIncorporationDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getIncorporationDate <em>Incorporation Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Incorporation Date</em>' attribute is set.
	 * @see #unsetIncorporationDate()
	 * @see #getIncorporationDate()
	 * @see #setIncorporationDate(String)
	 * @generated
	 */
	boolean isSetIncorporationDate();

	/**
	 * Returns the value of the '<em><b>Depreciated Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depreciated Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depreciated Value</em>' reference.
	 * @see #isSetDepreciatedValue()
	 * @see #unsetDepreciatedValue()
	 * @see #setDepreciatedValue(IfcCostValue)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAsset_DepreciatedValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCostValue getDepreciatedValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getDepreciatedValue <em>Depreciated Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depreciated Value</em>' reference.
	 * @see #isSetDepreciatedValue()
	 * @see #unsetDepreciatedValue()
	 * @see #getDepreciatedValue()
	 * @generated
	 */
	void setDepreciatedValue(IfcCostValue value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getDepreciatedValue <em>Depreciated Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDepreciatedValue()
	 * @see #getDepreciatedValue()
	 * @see #setDepreciatedValue(IfcCostValue)
	 * @generated
	 */
	void unsetDepreciatedValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAsset#getDepreciatedValue <em>Depreciated Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Depreciated Value</em>' reference is set.
	 * @see #unsetDepreciatedValue()
	 * @see #getDepreciatedValue()
	 * @see #setDepreciatedValue(IfcCostValue)
	 * @generated
	 */
	boolean isSetDepreciatedValue();

} // IfcAsset
