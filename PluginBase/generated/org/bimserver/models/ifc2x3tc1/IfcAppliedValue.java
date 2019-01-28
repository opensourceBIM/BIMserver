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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Applied Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getAppliedValue <em>Applied Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getUnitBasis <em>Unit Basis</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getApplicableDate <em>Applicable Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getFixedUntilDate <em>Fixed Until Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getValuesReferenced <em>Values Referenced</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getValueOfComponents <em>Value Of Components</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getIsComponentIn <em>Is Component In</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAppliedValue()
 * @model
 * @generated
 */
public interface IfcAppliedValue extends IfcObjectReferenceSelect {
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAppliedValue_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getName <em>Name</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getName <em>Name</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #setDescription(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAppliedValue_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getDescription <em>Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Description</em>' attribute is set.
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	boolean isSetDescription();

	/**
	 * Returns the value of the '<em><b>Applied Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Value</em>' reference.
	 * @see #isSetAppliedValue()
	 * @see #unsetAppliedValue()
	 * @see #setAppliedValue(IfcAppliedValueSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAppliedValue_AppliedValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAppliedValueSelect getAppliedValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getAppliedValue <em>Applied Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Value</em>' reference.
	 * @see #isSetAppliedValue()
	 * @see #unsetAppliedValue()
	 * @see #getAppliedValue()
	 * @generated
	 */
	void setAppliedValue(IfcAppliedValueSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getAppliedValue <em>Applied Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAppliedValue()
	 * @see #getAppliedValue()
	 * @see #setAppliedValue(IfcAppliedValueSelect)
	 * @generated
	 */
	void unsetAppliedValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getAppliedValue <em>Applied Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applied Value</em>' reference is set.
	 * @see #unsetAppliedValue()
	 * @see #getAppliedValue()
	 * @see #setAppliedValue(IfcAppliedValueSelect)
	 * @generated
	 */
	boolean isSetAppliedValue();

	/**
	 * Returns the value of the '<em><b>Unit Basis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Basis</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Basis</em>' reference.
	 * @see #isSetUnitBasis()
	 * @see #unsetUnitBasis()
	 * @see #setUnitBasis(IfcMeasureWithUnit)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAppliedValue_UnitBasis()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcMeasureWithUnit getUnitBasis();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getUnitBasis <em>Unit Basis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Basis</em>' reference.
	 * @see #isSetUnitBasis()
	 * @see #unsetUnitBasis()
	 * @see #getUnitBasis()
	 * @generated
	 */
	void setUnitBasis(IfcMeasureWithUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getUnitBasis <em>Unit Basis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnitBasis()
	 * @see #getUnitBasis()
	 * @see #setUnitBasis(IfcMeasureWithUnit)
	 * @generated
	 */
	void unsetUnitBasis();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getUnitBasis <em>Unit Basis</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unit Basis</em>' reference is set.
	 * @see #unsetUnitBasis()
	 * @see #getUnitBasis()
	 * @see #setUnitBasis(IfcMeasureWithUnit)
	 * @generated
	 */
	boolean isSetUnitBasis();

	/**
	 * Returns the value of the '<em><b>Applicable Date</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applicable Date</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicable Date</em>' reference.
	 * @see #isSetApplicableDate()
	 * @see #unsetApplicableDate()
	 * @see #setApplicableDate(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAppliedValue_ApplicableDate()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getApplicableDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getApplicableDate <em>Applicable Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applicable Date</em>' reference.
	 * @see #isSetApplicableDate()
	 * @see #unsetApplicableDate()
	 * @see #getApplicableDate()
	 * @generated
	 */
	void setApplicableDate(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getApplicableDate <em>Applicable Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplicableDate()
	 * @see #getApplicableDate()
	 * @see #setApplicableDate(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetApplicableDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getApplicableDate <em>Applicable Date</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applicable Date</em>' reference is set.
	 * @see #unsetApplicableDate()
	 * @see #getApplicableDate()
	 * @see #setApplicableDate(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetApplicableDate();

	/**
	 * Returns the value of the '<em><b>Fixed Until Date</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Until Date</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Until Date</em>' reference.
	 * @see #isSetFixedUntilDate()
	 * @see #unsetFixedUntilDate()
	 * @see #setFixedUntilDate(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAppliedValue_FixedUntilDate()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getFixedUntilDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getFixedUntilDate <em>Fixed Until Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Until Date</em>' reference.
	 * @see #isSetFixedUntilDate()
	 * @see #unsetFixedUntilDate()
	 * @see #getFixedUntilDate()
	 * @generated
	 */
	void setFixedUntilDate(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getFixedUntilDate <em>Fixed Until Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFixedUntilDate()
	 * @see #getFixedUntilDate()
	 * @see #setFixedUntilDate(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetFixedUntilDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getFixedUntilDate <em>Fixed Until Date</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fixed Until Date</em>' reference is set.
	 * @see #unsetFixedUntilDate()
	 * @see #getFixedUntilDate()
	 * @see #setFixedUntilDate(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetFixedUntilDate();

	/**
	 * Returns the value of the '<em><b>Values Referenced</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcReferencesValueDocument}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcReferencesValueDocument#getReferencingValues <em>Referencing Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values Referenced</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values Referenced</em>' reference list.
	 * @see #isSetValuesReferenced()
	 * @see #unsetValuesReferenced()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAppliedValue_ValuesReferenced()
	 * @see org.bimserver.models.ifc2x3tc1.IfcReferencesValueDocument#getReferencingValues
	 * @model opposite="ReferencingValues" unsettable="true"
	 * @generated
	 */
	EList<IfcReferencesValueDocument> getValuesReferenced();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getValuesReferenced <em>Values Referenced</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValuesReferenced()
	 * @see #getValuesReferenced()
	 * @generated
	 */
	void unsetValuesReferenced();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getValuesReferenced <em>Values Referenced</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Values Referenced</em>' reference list is set.
	 * @see #unsetValuesReferenced()
	 * @see #getValuesReferenced()
	 * @generated
	 */
	boolean isSetValuesReferenced();

	/**
	 * Returns the value of the '<em><b>Value Of Components</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcAppliedValueRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValueRelationship#getComponentOfTotal <em>Component Of Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Of Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Of Components</em>' reference list.
	 * @see #isSetValueOfComponents()
	 * @see #unsetValueOfComponents()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAppliedValue_ValueOfComponents()
	 * @see org.bimserver.models.ifc2x3tc1.IfcAppliedValueRelationship#getComponentOfTotal
	 * @model opposite="ComponentOfTotal" unsettable="true"
	 * @generated
	 */
	EList<IfcAppliedValueRelationship> getValueOfComponents();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getValueOfComponents <em>Value Of Components</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValueOfComponents()
	 * @see #getValueOfComponents()
	 * @generated
	 */
	void unsetValueOfComponents();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getValueOfComponents <em>Value Of Components</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Value Of Components</em>' reference list is set.
	 * @see #unsetValueOfComponents()
	 * @see #getValueOfComponents()
	 * @generated
	 */
	boolean isSetValueOfComponents();

	/**
	 * Returns the value of the '<em><b>Is Component In</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcAppliedValueRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValueRelationship#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Component In</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Component In</em>' reference list.
	 * @see #isSetIsComponentIn()
	 * @see #unsetIsComponentIn()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAppliedValue_IsComponentIn()
	 * @see org.bimserver.models.ifc2x3tc1.IfcAppliedValueRelationship#getComponents
	 * @model opposite="Components" unsettable="true"
	 * @generated
	 */
	EList<IfcAppliedValueRelationship> getIsComponentIn();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getIsComponentIn <em>Is Component In</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsComponentIn()
	 * @see #getIsComponentIn()
	 * @generated
	 */
	void unsetIsComponentIn();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAppliedValue#getIsComponentIn <em>Is Component In</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Component In</em>' reference list is set.
	 * @see #unsetIsComponentIn()
	 * @see #getIsComponentIn()
	 * @generated
	 */
	boolean isSetIsComponentIn();

} // IfcAppliedValue
