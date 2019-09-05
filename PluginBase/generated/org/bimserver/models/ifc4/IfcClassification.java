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
 * A representation of the model object '<em><b>Ifc Classification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassification#getSource <em>Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassification#getEdition <em>Edition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassification#getEditionDate <em>Edition Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassification#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassification#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassification#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassification#getReferenceTokens <em>Reference Tokens</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassification#getClassificationForObjects <em>Classification For Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassification#getHasReferences <em>Has References</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassification()
 * @model
 * @generated
 */
public interface IfcClassification extends IfcExternalInformation, IfcClassificationReferenceSelect, IfcClassificationSelect {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassification_Source()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getSource <em>Source</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSource()
	 * @see #getSource()
	 * @see #setSource(String)
	 * @generated
	 */
	void unsetSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getSource <em>Source</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassification_Edition()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEdition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getEdition <em>Edition</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getEdition <em>Edition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEdition()
	 * @see #getEdition()
	 * @see #setEdition(String)
	 * @generated
	 */
	void unsetEdition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getEdition <em>Edition</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Edition Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edition Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edition Date</em>' attribute.
	 * @see #isSetEditionDate()
	 * @see #unsetEditionDate()
	 * @see #setEditionDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassification_EditionDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEditionDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getEditionDate <em>Edition Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edition Date</em>' attribute.
	 * @see #isSetEditionDate()
	 * @see #unsetEditionDate()
	 * @see #getEditionDate()
	 * @generated
	 */
	void setEditionDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getEditionDate <em>Edition Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEditionDate()
	 * @see #getEditionDate()
	 * @see #setEditionDate(String)
	 * @generated
	 */
	void unsetEditionDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getEditionDate <em>Edition Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Edition Date</em>' attribute is set.
	 * @see #unsetEditionDate()
	 * @see #getEditionDate()
	 * @see #setEditionDate(String)
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassification_Name()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassification_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #isSetLocation()
	 * @see #unsetLocation()
	 * @see #setLocation(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassification_Location()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #isSetLocation()
	 * @see #unsetLocation()
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLocation()
	 * @see #getLocation()
	 * @see #setLocation(String)
	 * @generated
	 */
	void unsetLocation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getLocation <em>Location</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Location</em>' attribute is set.
	 * @see #unsetLocation()
	 * @see #getLocation()
	 * @see #setLocation(String)
	 * @generated
	 */
	boolean isSetLocation();

	/**
	 * Returns the value of the '<em><b>Reference Tokens</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Tokens</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Tokens</em>' attribute list.
	 * @see #isSetReferenceTokens()
	 * @see #unsetReferenceTokens()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassification_ReferenceTokens()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getReferenceTokens();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getReferenceTokens <em>Reference Tokens</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferenceTokens()
	 * @see #getReferenceTokens()
	 * @generated
	 */
	void unsetReferenceTokens();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getReferenceTokens <em>Reference Tokens</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reference Tokens</em>' attribute list is set.
	 * @see #unsetReferenceTokens()
	 * @see #getReferenceTokens()
	 * @generated
	 */
	boolean isSetReferenceTokens();

	/**
	 * Returns the value of the '<em><b>Classification For Objects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssociatesClassification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classification For Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classification For Objects</em>' reference list.
	 * @see #isSetClassificationForObjects()
	 * @see #unsetClassificationForObjects()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassification_ClassificationForObjects()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssociatesClassification> getClassificationForObjects();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getClassificationForObjects <em>Classification For Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetClassificationForObjects()
	 * @see #getClassificationForObjects()
	 * @generated
	 */
	void unsetClassificationForObjects();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getClassificationForObjects <em>Classification For Objects</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Classification For Objects</em>' reference list is set.
	 * @see #unsetClassificationForObjects()
	 * @see #getClassificationForObjects()
	 * @generated
	 */
	boolean isSetClassificationForObjects();

	/**
	 * Returns the value of the '<em><b>Has References</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcClassificationReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has References</em>' reference list.
	 * @see #isSetHasReferences()
	 * @see #unsetHasReferences()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassification_HasReferences()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcClassificationReference> getHasReferences();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getHasReferences <em>Has References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasReferences()
	 * @see #getHasReferences()
	 * @generated
	 */
	void unsetHasReferences();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassification#getHasReferences <em>Has References</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has References</em>' reference list is set.
	 * @see #unsetHasReferences()
	 * @see #getHasReferences()
	 * @generated
	 */
	boolean isSetHasReferences();

} // IfcClassification
