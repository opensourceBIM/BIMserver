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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Classification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getSource <em>Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getEdition <em>Edition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getEditionDate <em>Edition Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getContains <em>Contains</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcClassification()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcClassification extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcClassification_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Edition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edition</em>' attribute.
	 * @see #setEdition(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcClassification_Edition()
	 * @model
	 * @generated
	 */
	String getEdition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getEdition <em>Edition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edition</em>' attribute.
	 * @see #getEdition()
	 * @generated
	 */
	void setEdition(String value);

	/**
	 * Returns the value of the '<em><b>Edition Date</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edition Date</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edition Date</em>' reference.
	 * @see #isSetEditionDate()
	 * @see #unsetEditionDate()
	 * @see #setEditionDate(IfcCalendarDate)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcClassification_EditionDate()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCalendarDate getEditionDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getEditionDate <em>Edition Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edition Date</em>' reference.
	 * @see #isSetEditionDate()
	 * @see #unsetEditionDate()
	 * @see #getEditionDate()
	 * @generated
	 */
	void setEditionDate(IfcCalendarDate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getEditionDate <em>Edition Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEditionDate()
	 * @see #getEditionDate()
	 * @see #setEditionDate(IfcCalendarDate)
	 * @generated
	 */
	void unsetEditionDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getEditionDate <em>Edition Date</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Edition Date</em>' reference is set.
	 * @see #unsetEditionDate()
	 * @see #getEditionDate()
	 * @see #setEditionDate(IfcCalendarDate)
	 * @generated
	 */
	boolean isSetEditionDate();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcClassification_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Contains</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcClassificationItem}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcClassificationItem#getItemOf <em>Item Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains</em>' reference list.
	 * @see #isSetContains()
	 * @see #unsetContains()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcClassification_Contains()
	 * @see org.bimserver.models.ifc2x3tc1.IfcClassificationItem#getItemOf
	 * @model opposite="ItemOf" unsettable="true"
	 * @generated
	 */
	EList<IfcClassificationItem> getContains();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getContains <em>Contains</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContains()
	 * @see #getContains()
	 * @generated
	 */
	void unsetContains();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcClassification#getContains <em>Contains</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Contains</em>' reference list is set.
	 * @see #unsetContains()
	 * @see #getContains()
	 * @generated
	 */
	boolean isSetContains();

} // IfcClassification
