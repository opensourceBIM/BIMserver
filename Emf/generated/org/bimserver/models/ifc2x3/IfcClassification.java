/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Classification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassification#getSource <em>Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassification#getEdition <em>Edition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassification#getEditionDate <em>Edition Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassification#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassification#getContains <em>Contains</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassification()
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
	 * @see #isSetSource()
	 * @see #unsetSource()
	 * @see #setSource(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassification_Source()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #isSetSource()
	 * @see #unsetSource()
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSource()
	 * @see #getSource()
	 * @see #setSource(String)
	 * @generated
	 */
	void unsetSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getSource <em>Source</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Source</em>' attribute is set.
	 * @see #unsetSource()
	 * @see #getSource()
	 * @see #setSource(String)
	 * @generated
	 */
	boolean isSetSource();

	/**
	 * Returns the value of the '<em><b>Edition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edition</em>' attribute.
	 * @see #isSetEdition()
	 * @see #unsetEdition()
	 * @see #setEdition(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassification_Edition()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEdition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getEdition <em>Edition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edition</em>' attribute.
	 * @see #isSetEdition()
	 * @see #unsetEdition()
	 * @see #getEdition()
	 * @generated
	 */
	void setEdition(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getEdition <em>Edition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEdition()
	 * @see #getEdition()
	 * @see #setEdition(String)
	 * @generated
	 */
	void unsetEdition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getEdition <em>Edition</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Edition</em>' attribute is set.
	 * @see #unsetEdition()
	 * @see #getEdition()
	 * @see #setEdition(String)
	 * @generated
	 */
	boolean isSetEdition();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassification_EditionDate()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCalendarDate getEditionDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getEditionDate <em>Edition Date</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getEditionDate <em>Edition Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEditionDate()
	 * @see #getEditionDate()
	 * @see #setEditionDate(IfcCalendarDate)
	 * @generated
	 */
	void unsetEditionDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getEditionDate <em>Edition Date</em>}' reference is set.
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
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassification_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getName <em>Name</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getName <em>Name</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Contains</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcClassificationItem}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getItemOf <em>Item Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains</em>' reference list.
	 * @see #isSetContains()
	 * @see #unsetContains()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassification_Contains()
	 * @see org.bimserver.models.ifc2x3.IfcClassificationItem#getItemOf
	 * @model opposite="ItemOf" unsettable="true"
	 * @generated
	 */
	EList<IfcClassificationItem> getContains();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getContains <em>Contains</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContains()
	 * @see #getContains()
	 * @generated
	 */
	void unsetContains();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcClassification#getContains <em>Contains</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Contains</em>' reference list is set.
	 * @see #unsetContains()
	 * @see #getContains()
	 * @generated
	 */
	boolean isSetContains();

} // IfcClassification
