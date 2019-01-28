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
 * A representation of the model object '<em><b>Ifc Text Style Font Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontFamily <em>Font Family</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontStyle <em>Font Style</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontVariant <em>Font Variant</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontWeight <em>Font Weight</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontSize <em>Font Size</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleFontModel()
 * @model
 * @generated
 */
public interface IfcTextStyleFontModel extends IfcPreDefinedTextFont {
	/**
	 * Returns the value of the '<em><b>Font Family</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Family</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Family</em>' attribute list.
	 * @see #isSetFontFamily()
	 * @see #unsetFontFamily()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleFontModel_FontFamily()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getFontFamily();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontFamily <em>Font Family</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFontFamily()
	 * @see #getFontFamily()
	 * @generated
	 */
	void unsetFontFamily();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontFamily <em>Font Family</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Font Family</em>' attribute list is set.
	 * @see #unsetFontFamily()
	 * @see #getFontFamily()
	 * @generated
	 */
	boolean isSetFontFamily();

	/**
	 * Returns the value of the '<em><b>Font Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Style</em>' attribute.
	 * @see #isSetFontStyle()
	 * @see #unsetFontStyle()
	 * @see #setFontStyle(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleFontModel_FontStyle()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFontStyle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontStyle <em>Font Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Style</em>' attribute.
	 * @see #isSetFontStyle()
	 * @see #unsetFontStyle()
	 * @see #getFontStyle()
	 * @generated
	 */
	void setFontStyle(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontStyle <em>Font Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFontStyle()
	 * @see #getFontStyle()
	 * @see #setFontStyle(String)
	 * @generated
	 */
	void unsetFontStyle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontStyle <em>Font Style</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Font Style</em>' attribute is set.
	 * @see #unsetFontStyle()
	 * @see #getFontStyle()
	 * @see #setFontStyle(String)
	 * @generated
	 */
	boolean isSetFontStyle();

	/**
	 * Returns the value of the '<em><b>Font Variant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Variant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Variant</em>' attribute.
	 * @see #isSetFontVariant()
	 * @see #unsetFontVariant()
	 * @see #setFontVariant(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleFontModel_FontVariant()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFontVariant();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontVariant <em>Font Variant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Variant</em>' attribute.
	 * @see #isSetFontVariant()
	 * @see #unsetFontVariant()
	 * @see #getFontVariant()
	 * @generated
	 */
	void setFontVariant(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontVariant <em>Font Variant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFontVariant()
	 * @see #getFontVariant()
	 * @see #setFontVariant(String)
	 * @generated
	 */
	void unsetFontVariant();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontVariant <em>Font Variant</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Font Variant</em>' attribute is set.
	 * @see #unsetFontVariant()
	 * @see #getFontVariant()
	 * @see #setFontVariant(String)
	 * @generated
	 */
	boolean isSetFontVariant();

	/**
	 * Returns the value of the '<em><b>Font Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Weight</em>' attribute.
	 * @see #isSetFontWeight()
	 * @see #unsetFontWeight()
	 * @see #setFontWeight(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleFontModel_FontWeight()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFontWeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontWeight <em>Font Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Weight</em>' attribute.
	 * @see #isSetFontWeight()
	 * @see #unsetFontWeight()
	 * @see #getFontWeight()
	 * @generated
	 */
	void setFontWeight(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontWeight <em>Font Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFontWeight()
	 * @see #getFontWeight()
	 * @see #setFontWeight(String)
	 * @generated
	 */
	void unsetFontWeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontWeight <em>Font Weight</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Font Weight</em>' attribute is set.
	 * @see #unsetFontWeight()
	 * @see #getFontWeight()
	 * @see #setFontWeight(String)
	 * @generated
	 */
	boolean isSetFontWeight();

	/**
	 * Returns the value of the '<em><b>Font Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Size</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Size</em>' reference.
	 * @see #setFontSize(IfcSizeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleFontModel_FontSize()
	 * @model
	 * @generated
	 */
	IfcSizeSelect getFontSize();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleFontModel#getFontSize <em>Font Size</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Size</em>' reference.
	 * @see #getFontSize()
	 * @generated
	 */
	void setFontSize(IfcSizeSelect value);

} // IfcTextStyleFontModel
