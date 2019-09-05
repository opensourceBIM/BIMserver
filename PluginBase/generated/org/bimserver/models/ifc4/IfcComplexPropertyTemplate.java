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
 * A representation of the model object '<em><b>Ifc Complex Property Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getUsageName <em>Usage Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getTemplateType <em>Template Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getHasPropertyTemplates <em>Has Property Templates</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcComplexPropertyTemplate()
 * @model
 * @generated
 */
public interface IfcComplexPropertyTemplate extends IfcPropertyTemplate {
	/**
	 * Returns the value of the '<em><b>Usage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Name</em>' attribute.
	 * @see #isSetUsageName()
	 * @see #unsetUsageName()
	 * @see #setUsageName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcComplexPropertyTemplate_UsageName()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUsageName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getUsageName <em>Usage Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Name</em>' attribute.
	 * @see #isSetUsageName()
	 * @see #unsetUsageName()
	 * @see #getUsageName()
	 * @generated
	 */
	void setUsageName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getUsageName <em>Usage Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUsageName()
	 * @see #getUsageName()
	 * @see #setUsageName(String)
	 * @generated
	 */
	void unsetUsageName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getUsageName <em>Usage Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Usage Name</em>' attribute is set.
	 * @see #unsetUsageName()
	 * @see #getUsageName()
	 * @see #setUsageName(String)
	 * @generated
	 */
	boolean isSetUsageName();

	/**
	 * Returns the value of the '<em><b>Template Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcComplexPropertyTemplateTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcComplexPropertyTemplateTypeEnum
	 * @see #isSetTemplateType()
	 * @see #unsetTemplateType()
	 * @see #setTemplateType(IfcComplexPropertyTemplateTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcComplexPropertyTemplate_TemplateType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcComplexPropertyTemplateTypeEnum getTemplateType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getTemplateType <em>Template Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcComplexPropertyTemplateTypeEnum
	 * @see #isSetTemplateType()
	 * @see #unsetTemplateType()
	 * @see #getTemplateType()
	 * @generated
	 */
	void setTemplateType(IfcComplexPropertyTemplateTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getTemplateType <em>Template Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTemplateType()
	 * @see #getTemplateType()
	 * @see #setTemplateType(IfcComplexPropertyTemplateTypeEnum)
	 * @generated
	 */
	void unsetTemplateType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getTemplateType <em>Template Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Template Type</em>' attribute is set.
	 * @see #unsetTemplateType()
	 * @see #getTemplateType()
	 * @see #setTemplateType(IfcComplexPropertyTemplateTypeEnum)
	 * @generated
	 */
	boolean isSetTemplateType();

	/**
	 * Returns the value of the '<em><b>Has Property Templates</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcPropertyTemplate}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcPropertyTemplate#getPartOfComplexTemplate <em>Part Of Complex Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Property Templates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Property Templates</em>' reference list.
	 * @see #isSetHasPropertyTemplates()
	 * @see #unsetHasPropertyTemplates()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcComplexPropertyTemplate_HasPropertyTemplates()
	 * @see org.bimserver.models.ifc4.IfcPropertyTemplate#getPartOfComplexTemplate
	 * @model opposite="PartOfComplexTemplate" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcPropertyTemplate> getHasPropertyTemplates();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getHasPropertyTemplates <em>Has Property Templates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasPropertyTemplates()
	 * @see #getHasPropertyTemplates()
	 * @generated
	 */
	void unsetHasPropertyTemplates();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getHasPropertyTemplates <em>Has Property Templates</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Property Templates</em>' reference list is set.
	 * @see #unsetHasPropertyTemplates()
	 * @see #getHasPropertyTemplates()
	 * @generated
	 */
	boolean isSetHasPropertyTemplates();

} // IfcComplexPropertyTemplate
