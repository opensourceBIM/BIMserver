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

public interface IfcSimplePropertyTemplate extends IfcPropertyTemplate {
	/**
	 * Returns the value of the '<em><b>Template Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcSimplePropertyTemplateTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcSimplePropertyTemplateTypeEnum
	 * @see #isSetTemplateType()
	 * @see #unsetTemplateType()
	 * @see #setTemplateType(IfcSimplePropertyTemplateTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSimplePropertyTemplate_TemplateType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSimplePropertyTemplateTypeEnum getTemplateType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getTemplateType <em>Template Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcSimplePropertyTemplateTypeEnum
	 * @see #isSetTemplateType()
	 * @see #unsetTemplateType()
	 * @see #getTemplateType()
	 * @generated
	 */
	void setTemplateType(IfcSimplePropertyTemplateTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getTemplateType <em>Template Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTemplateType()
	 * @see #getTemplateType()
	 * @see #setTemplateType(IfcSimplePropertyTemplateTypeEnum)
	 * @generated
	 */
	void unsetTemplateType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getTemplateType <em>Template Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Template Type</em>' attribute is set.
	 * @see #unsetTemplateType()
	 * @see #getTemplateType()
	 * @see #setTemplateType(IfcSimplePropertyTemplateTypeEnum)
	 * @generated
	 */
	boolean isSetTemplateType();

	/**
	 * Returns the value of the '<em><b>Primary Measure Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Measure Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Measure Type</em>' attribute.
	 * @see #isSetPrimaryMeasureType()
	 * @see #unsetPrimaryMeasureType()
	 * @see #setPrimaryMeasureType(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSimplePropertyTemplate_PrimaryMeasureType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPrimaryMeasureType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getPrimaryMeasureType <em>Primary Measure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Measure Type</em>' attribute.
	 * @see #isSetPrimaryMeasureType()
	 * @see #unsetPrimaryMeasureType()
	 * @see #getPrimaryMeasureType()
	 * @generated
	 */
	void setPrimaryMeasureType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getPrimaryMeasureType <em>Primary Measure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPrimaryMeasureType()
	 * @see #getPrimaryMeasureType()
	 * @see #setPrimaryMeasureType(String)
	 * @generated
	 */
	void unsetPrimaryMeasureType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getPrimaryMeasureType <em>Primary Measure Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Primary Measure Type</em>' attribute is set.
	 * @see #unsetPrimaryMeasureType()
	 * @see #getPrimaryMeasureType()
	 * @see #setPrimaryMeasureType(String)
	 * @generated
	 */
	boolean isSetPrimaryMeasureType();

	/**
	 * Returns the value of the '<em><b>Secondary Measure Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Measure Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Measure Type</em>' attribute.
	 * @see #isSetSecondaryMeasureType()
	 * @see #unsetSecondaryMeasureType()
	 * @see #setSecondaryMeasureType(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSimplePropertyTemplate_SecondaryMeasureType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSecondaryMeasureType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getSecondaryMeasureType <em>Secondary Measure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secondary Measure Type</em>' attribute.
	 * @see #isSetSecondaryMeasureType()
	 * @see #unsetSecondaryMeasureType()
	 * @see #getSecondaryMeasureType()
	 * @generated
	 */
	void setSecondaryMeasureType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getSecondaryMeasureType <em>Secondary Measure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondaryMeasureType()
	 * @see #getSecondaryMeasureType()
	 * @see #setSecondaryMeasureType(String)
	 * @generated
	 */
	void unsetSecondaryMeasureType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getSecondaryMeasureType <em>Secondary Measure Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Secondary Measure Type</em>' attribute is set.
	 * @see #unsetSecondaryMeasureType()
	 * @see #getSecondaryMeasureType()
	 * @see #setSecondaryMeasureType(String)
	 * @generated
	 */
	boolean isSetSecondaryMeasureType();

	/**
	 * Returns the value of the '<em><b>Enumerators</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumerators</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumerators</em>' reference.
	 * @see #isSetEnumerators()
	 * @see #unsetEnumerators()
	 * @see #setEnumerators(IfcPropertyEnumeration)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSimplePropertyTemplate_Enumerators()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPropertyEnumeration getEnumerators();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getEnumerators <em>Enumerators</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumerators</em>' reference.
	 * @see #isSetEnumerators()
	 * @see #unsetEnumerators()
	 * @see #getEnumerators()
	 * @generated
	 */
	void setEnumerators(IfcPropertyEnumeration value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getEnumerators <em>Enumerators</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEnumerators()
	 * @see #getEnumerators()
	 * @see #setEnumerators(IfcPropertyEnumeration)
	 * @generated
	 */
	void unsetEnumerators();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getEnumerators <em>Enumerators</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Enumerators</em>' reference is set.
	 * @see #unsetEnumerators()
	 * @see #getEnumerators()
	 * @see #setEnumerators(IfcPropertyEnumeration)
	 * @generated
	 */
	boolean isSetEnumerators();

	/**
	 * Returns the value of the '<em><b>Primary Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Unit</em>' reference.
	 * @see #isSetPrimaryUnit()
	 * @see #unsetPrimaryUnit()
	 * @see #setPrimaryUnit(IfcUnit)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSimplePropertyTemplate_PrimaryUnit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcUnit getPrimaryUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getPrimaryUnit <em>Primary Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Unit</em>' reference.
	 * @see #isSetPrimaryUnit()
	 * @see #unsetPrimaryUnit()
	 * @see #getPrimaryUnit()
	 * @generated
	 */
	void setPrimaryUnit(IfcUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getPrimaryUnit <em>Primary Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPrimaryUnit()
	 * @see #getPrimaryUnit()
	 * @see #setPrimaryUnit(IfcUnit)
	 * @generated
	 */
	void unsetPrimaryUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getPrimaryUnit <em>Primary Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Primary Unit</em>' reference is set.
	 * @see #unsetPrimaryUnit()
	 * @see #getPrimaryUnit()
	 * @see #setPrimaryUnit(IfcUnit)
	 * @generated
	 */
	boolean isSetPrimaryUnit();

	/**
	 * Returns the value of the '<em><b>Secondary Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Unit</em>' reference.
	 * @see #isSetSecondaryUnit()
	 * @see #unsetSecondaryUnit()
	 * @see #setSecondaryUnit(IfcUnit)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSimplePropertyTemplate_SecondaryUnit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcUnit getSecondaryUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getSecondaryUnit <em>Secondary Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secondary Unit</em>' reference.
	 * @see #isSetSecondaryUnit()
	 * @see #unsetSecondaryUnit()
	 * @see #getSecondaryUnit()
	 * @generated
	 */
	void setSecondaryUnit(IfcUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getSecondaryUnit <em>Secondary Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSecondaryUnit()
	 * @see #getSecondaryUnit()
	 * @see #setSecondaryUnit(IfcUnit)
	 * @generated
	 */
	void unsetSecondaryUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getSecondaryUnit <em>Secondary Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Secondary Unit</em>' reference is set.
	 * @see #unsetSecondaryUnit()
	 * @see #getSecondaryUnit()
	 * @see #setSecondaryUnit(IfcUnit)
	 * @generated
	 */
	boolean isSetSecondaryUnit();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #setExpression(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSimplePropertyTemplate_Expression()
	 * @model unsettable="true"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExpression()
	 * @see #getExpression()
	 * @see #setExpression(String)
	 * @generated
	 */
	void unsetExpression();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getExpression <em>Expression</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expression</em>' attribute is set.
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @see #setExpression(String)
	 * @generated
	 */
	boolean isSetExpression();

	/**
	 * Returns the value of the '<em><b>Access State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcStateEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access State</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcStateEnum
	 * @see #isSetAccessState()
	 * @see #unsetAccessState()
	 * @see #setAccessState(IfcStateEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSimplePropertyTemplate_AccessState()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcStateEnum getAccessState();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getAccessState <em>Access State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access State</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcStateEnum
	 * @see #isSetAccessState()
	 * @see #unsetAccessState()
	 * @see #getAccessState()
	 * @generated
	 */
	void setAccessState(IfcStateEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getAccessState <em>Access State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAccessState()
	 * @see #getAccessState()
	 * @see #setAccessState(IfcStateEnum)
	 * @generated
	 */
	void unsetAccessState();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSimplePropertyTemplate#getAccessState <em>Access State</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Access State</em>' attribute is set.
	 * @see #unsetAccessState()
	 * @see #getAccessState()
	 * @see #setAccessState(IfcStateEnum)
	 * @generated
	 */
	boolean isSetAccessState();

} // IfcSimplePropertyTemplate
