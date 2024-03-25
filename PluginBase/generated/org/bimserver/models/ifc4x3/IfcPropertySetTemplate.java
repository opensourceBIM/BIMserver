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
package org.bimserver.models.ifc4x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Property Set Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getTemplateType <em>Template Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getApplicableEntity <em>Applicable Entity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getHasPropertyTemplates <em>Has Property Templates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getDefines <em>Defines</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPropertySetTemplate()
 * @model
 * @generated
 */
public interface IfcPropertySetTemplate extends IfcPropertyTemplateDefinition {
	/**
	 * Returns the value of the '<em><b>Template Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcPropertySetTemplateTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcPropertySetTemplateTypeEnum
	 * @see #isSetTemplateType()
	 * @see #unsetTemplateType()
	 * @see #setTemplateType(IfcPropertySetTemplateTypeEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPropertySetTemplate_TemplateType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPropertySetTemplateTypeEnum getTemplateType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getTemplateType <em>Template Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcPropertySetTemplateTypeEnum
	 * @see #isSetTemplateType()
	 * @see #unsetTemplateType()
	 * @see #getTemplateType()
	 * @generated
	 */
	void setTemplateType(IfcPropertySetTemplateTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getTemplateType <em>Template Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTemplateType()
	 * @see #getTemplateType()
	 * @see #setTemplateType(IfcPropertySetTemplateTypeEnum)
	 * @generated
	 */
	void unsetTemplateType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getTemplateType <em>Template Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Template Type</em>' attribute is set.
	 * @see #unsetTemplateType()
	 * @see #getTemplateType()
	 * @see #setTemplateType(IfcPropertySetTemplateTypeEnum)
	 * @generated
	 */
	boolean isSetTemplateType();

	/**
	 * Returns the value of the '<em><b>Applicable Entity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicable Entity</em>' attribute.
	 * @see #isSetApplicableEntity()
	 * @see #unsetApplicableEntity()
	 * @see #setApplicableEntity(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPropertySetTemplate_ApplicableEntity()
	 * @model unsettable="true"
	 * @generated
	 */
	String getApplicableEntity();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getApplicableEntity <em>Applicable Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applicable Entity</em>' attribute.
	 * @see #isSetApplicableEntity()
	 * @see #unsetApplicableEntity()
	 * @see #getApplicableEntity()
	 * @generated
	 */
	void setApplicableEntity(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getApplicableEntity <em>Applicable Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplicableEntity()
	 * @see #getApplicableEntity()
	 * @see #setApplicableEntity(String)
	 * @generated
	 */
	void unsetApplicableEntity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getApplicableEntity <em>Applicable Entity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applicable Entity</em>' attribute is set.
	 * @see #unsetApplicableEntity()
	 * @see #getApplicableEntity()
	 * @see #setApplicableEntity(String)
	 * @generated
	 */
	boolean isSetApplicableEntity();

	/**
	 * Returns the value of the '<em><b>Has Property Templates</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcPropertyTemplate}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcPropertyTemplate#getPartOfPsetTemplate <em>Part Of Pset Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Property Templates</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPropertySetTemplate_HasPropertyTemplates()
	 * @see org.bimserver.models.ifc4x3.IfcPropertyTemplate#getPartOfPsetTemplate
	 * @model opposite="PartOfPsetTemplate"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcPropertyTemplate> getHasPropertyTemplates();

	/**
	 * Returns the value of the '<em><b>Defines</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcRelDefinesByTemplate}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcRelDefinesByTemplate#getRelatingTemplate <em>Relating Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defines</em>' reference list.
	 * @see #isSetDefines()
	 * @see #unsetDefines()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPropertySetTemplate_Defines()
	 * @see org.bimserver.models.ifc4x3.IfcRelDefinesByTemplate#getRelatingTemplate
	 * @model opposite="RelatingTemplate" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelDefinesByTemplate> getDefines();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getDefines <em>Defines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDefines()
	 * @see #getDefines()
	 * @generated
	 */
	void unsetDefines();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getDefines <em>Defines</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Defines</em>' reference list is set.
	 * @see #unsetDefines()
	 * @see #getDefines()
	 * @generated
	 */
	boolean isSetDefines();

} // IfcPropertySetTemplate
