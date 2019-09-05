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
 * A representation of the model object '<em><b>Ifc Applied Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcAppliedValue#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcAppliedValue#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcAppliedValue#getAppliedValue <em>Applied Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcAppliedValue#getUnitBasis <em>Unit Basis</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcAppliedValue#getApplicableDate <em>Applicable Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcAppliedValue#getFixedUntilDate <em>Fixed Until Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcAppliedValue#getCategory <em>Category</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcAppliedValue#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcAppliedValue#getArithmeticOperator <em>Arithmetic Operator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcAppliedValue#getComponents <em>Components</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcAppliedValue#getHasExternalReference <em>Has External Reference</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue()
 * @model
 * @generated
 */
public interface IfcAppliedValue extends IfcMetricValueSelect, IfcObjectReferenceSelect, IfcResourceObjectSelect {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue_Name()
	 * @model unsettable="true"
	 *        annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getName <em>Name</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getName <em>Name</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getDescription <em>Description</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue_AppliedValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAppliedValueSelect getAppliedValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getAppliedValue <em>Applied Value</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getAppliedValue <em>Applied Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAppliedValue()
	 * @see #getAppliedValue()
	 * @see #setAppliedValue(IfcAppliedValueSelect)
	 * @generated
	 */
	void unsetAppliedValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getAppliedValue <em>Applied Value</em>}' reference is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue_UnitBasis()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcMeasureWithUnit getUnitBasis();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getUnitBasis <em>Unit Basis</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getUnitBasis <em>Unit Basis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnitBasis()
	 * @see #getUnitBasis()
	 * @see #setUnitBasis(IfcMeasureWithUnit)
	 * @generated
	 */
	void unsetUnitBasis();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getUnitBasis <em>Unit Basis</em>}' reference is set.
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
	 * Returns the value of the '<em><b>Applicable Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applicable Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicable Date</em>' attribute.
	 * @see #isSetApplicableDate()
	 * @see #unsetApplicableDate()
	 * @see #setApplicableDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue_ApplicableDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getApplicableDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getApplicableDate <em>Applicable Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applicable Date</em>' attribute.
	 * @see #isSetApplicableDate()
	 * @see #unsetApplicableDate()
	 * @see #getApplicableDate()
	 * @generated
	 */
	void setApplicableDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getApplicableDate <em>Applicable Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplicableDate()
	 * @see #getApplicableDate()
	 * @see #setApplicableDate(String)
	 * @generated
	 */
	void unsetApplicableDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getApplicableDate <em>Applicable Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applicable Date</em>' attribute is set.
	 * @see #unsetApplicableDate()
	 * @see #getApplicableDate()
	 * @see #setApplicableDate(String)
	 * @generated
	 */
	boolean isSetApplicableDate();

	/**
	 * Returns the value of the '<em><b>Fixed Until Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Until Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Until Date</em>' attribute.
	 * @see #isSetFixedUntilDate()
	 * @see #unsetFixedUntilDate()
	 * @see #setFixedUntilDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue_FixedUntilDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFixedUntilDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getFixedUntilDate <em>Fixed Until Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Until Date</em>' attribute.
	 * @see #isSetFixedUntilDate()
	 * @see #unsetFixedUntilDate()
	 * @see #getFixedUntilDate()
	 * @generated
	 */
	void setFixedUntilDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getFixedUntilDate <em>Fixed Until Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFixedUntilDate()
	 * @see #getFixedUntilDate()
	 * @see #setFixedUntilDate(String)
	 * @generated
	 */
	void unsetFixedUntilDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getFixedUntilDate <em>Fixed Until Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fixed Until Date</em>' attribute is set.
	 * @see #unsetFixedUntilDate()
	 * @see #getFixedUntilDate()
	 * @see #setFixedUntilDate(String)
	 * @generated
	 */
	boolean isSetFixedUntilDate();

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #isSetCategory()
	 * @see #unsetCategory()
	 * @see #setCategory(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue_Category()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #isSetCategory()
	 * @see #unsetCategory()
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCategory()
	 * @see #getCategory()
	 * @see #setCategory(String)
	 * @generated
	 */
	void unsetCategory();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getCategory <em>Category</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Category</em>' attribute is set.
	 * @see #unsetCategory()
	 * @see #getCategory()
	 * @see #setCategory(String)
	 * @generated
	 */
	boolean isSetCategory();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #isSetCondition()
	 * @see #unsetCondition()
	 * @see #setCondition(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue_Condition()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #isSetCondition()
	 * @see #unsetCondition()
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCondition()
	 * @see #getCondition()
	 * @see #setCondition(String)
	 * @generated
	 */
	void unsetCondition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getCondition <em>Condition</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Condition</em>' attribute is set.
	 * @see #unsetCondition()
	 * @see #getCondition()
	 * @see #setCondition(String)
	 * @generated
	 */
	boolean isSetCondition();

	/**
	 * Returns the value of the '<em><b>Arithmetic Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcArithmeticOperatorEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arithmetic Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arithmetic Operator</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcArithmeticOperatorEnum
	 * @see #isSetArithmeticOperator()
	 * @see #unsetArithmeticOperator()
	 * @see #setArithmeticOperator(IfcArithmeticOperatorEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue_ArithmeticOperator()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcArithmeticOperatorEnum getArithmeticOperator();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getArithmeticOperator <em>Arithmetic Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arithmetic Operator</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcArithmeticOperatorEnum
	 * @see #isSetArithmeticOperator()
	 * @see #unsetArithmeticOperator()
	 * @see #getArithmeticOperator()
	 * @generated
	 */
	void setArithmeticOperator(IfcArithmeticOperatorEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getArithmeticOperator <em>Arithmetic Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetArithmeticOperator()
	 * @see #getArithmeticOperator()
	 * @see #setArithmeticOperator(IfcArithmeticOperatorEnum)
	 * @generated
	 */
	void unsetArithmeticOperator();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getArithmeticOperator <em>Arithmetic Operator</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Arithmetic Operator</em>' attribute is set.
	 * @see #unsetArithmeticOperator()
	 * @see #getArithmeticOperator()
	 * @see #setArithmeticOperator(IfcArithmeticOperatorEnum)
	 * @generated
	 */
	boolean isSetArithmeticOperator();

	/**
	 * Returns the value of the '<em><b>Components</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcAppliedValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' reference list.
	 * @see #isSetComponents()
	 * @see #unsetComponents()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue_Components()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcAppliedValue> getComponents();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getComponents <em>Components</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetComponents()
	 * @see #getComponents()
	 * @generated
	 */
	void unsetComponents();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getComponents <em>Components</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Components</em>' reference list is set.
	 * @see #unsetComponents()
	 * @see #getComponents()
	 * @generated
	 */
	boolean isSetComponents();

	/**
	 * Returns the value of the '<em><b>Has External Reference</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcExternalReferenceRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has External Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has External Reference</em>' reference list.
	 * @see #isSetHasExternalReference()
	 * @see #unsetHasExternalReference()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAppliedValue_HasExternalReference()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcExternalReferenceRelationship> getHasExternalReference();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getHasExternalReference <em>Has External Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasExternalReference()
	 * @see #getHasExternalReference()
	 * @generated
	 */
	void unsetHasExternalReference();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAppliedValue#getHasExternalReference <em>Has External Reference</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has External Reference</em>' reference list is set.
	 * @see #unsetHasExternalReference()
	 * @see #getHasExternalReference()
	 * @generated
	 */
	boolean isSetHasExternalReference();

} // IfcAppliedValue
