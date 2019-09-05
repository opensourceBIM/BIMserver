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
 * A representation of the model object '<em><b>Ifc Property Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcPropertyTemplate#getPartOfComplexTemplate <em>Part Of Complex Template</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPropertyTemplate#getPartOfPsetTemplate <em>Part Of Pset Template</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyTemplate()
 * @model
 * @generated
 */
public interface IfcPropertyTemplate extends IfcPropertyTemplateDefinition {
	/**
	 * Returns the value of the '<em><b>Part Of Complex Template</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getHasPropertyTemplates <em>Has Property Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of Complex Template</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of Complex Template</em>' reference list.
	 * @see #isSetPartOfComplexTemplate()
	 * @see #unsetPartOfComplexTemplate()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyTemplate_PartOfComplexTemplate()
	 * @see org.bimserver.models.ifc4.IfcComplexPropertyTemplate#getHasPropertyTemplates
	 * @model opposite="HasPropertyTemplates" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcComplexPropertyTemplate> getPartOfComplexTemplate();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyTemplate#getPartOfComplexTemplate <em>Part Of Complex Template</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPartOfComplexTemplate()
	 * @see #getPartOfComplexTemplate()
	 * @generated
	 */
	void unsetPartOfComplexTemplate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyTemplate#getPartOfComplexTemplate <em>Part Of Complex Template</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Part Of Complex Template</em>' reference list is set.
	 * @see #unsetPartOfComplexTemplate()
	 * @see #getPartOfComplexTemplate()
	 * @generated
	 */
	boolean isSetPartOfComplexTemplate();

	/**
	 * Returns the value of the '<em><b>Part Of Pset Template</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcPropertySetTemplate}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcPropertySetTemplate#getHasPropertyTemplates <em>Has Property Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of Pset Template</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of Pset Template</em>' reference list.
	 * @see #isSetPartOfPsetTemplate()
	 * @see #unsetPartOfPsetTemplate()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertyTemplate_PartOfPsetTemplate()
	 * @see org.bimserver.models.ifc4.IfcPropertySetTemplate#getHasPropertyTemplates
	 * @model opposite="HasPropertyTemplates" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcPropertySetTemplate> getPartOfPsetTemplate();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPropertyTemplate#getPartOfPsetTemplate <em>Part Of Pset Template</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPartOfPsetTemplate()
	 * @see #getPartOfPsetTemplate()
	 * @generated
	 */
	void unsetPartOfPsetTemplate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPropertyTemplate#getPartOfPsetTemplate <em>Part Of Pset Template</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Part Of Pset Template</em>' reference list is set.
	 * @see #unsetPartOfPsetTemplate()
	 * @see #getPartOfPsetTemplate()
	 * @generated
	 */
	boolean isSetPartOfPsetTemplate();

} // IfcPropertyTemplate
