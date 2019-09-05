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
 * A representation of the model object '<em><b>Ifc Classification Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassificationReference#getReferencedSource <em>Referenced Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassificationReference#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassificationReference#getSort <em>Sort</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassificationReference#getClassificationRefForObjects <em>Classification Ref For Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcClassificationReference#getHasReferences <em>Has References</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassificationReference()
 * @model
 * @generated
 */
public interface IfcClassificationReference extends IfcExternalReference, IfcClassificationReferenceSelect, IfcClassificationSelect {
	/**
	 * Returns the value of the '<em><b>Referenced Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Source</em>' reference.
	 * @see #isSetReferencedSource()
	 * @see #unsetReferencedSource()
	 * @see #setReferencedSource(IfcClassificationReferenceSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassificationReference_ReferencedSource()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcClassificationReferenceSelect getReferencedSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getReferencedSource <em>Referenced Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Source</em>' reference.
	 * @see #isSetReferencedSource()
	 * @see #unsetReferencedSource()
	 * @see #getReferencedSource()
	 * @generated
	 */
	void setReferencedSource(IfcClassificationReferenceSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getReferencedSource <em>Referenced Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencedSource()
	 * @see #getReferencedSource()
	 * @see #setReferencedSource(IfcClassificationReferenceSelect)
	 * @generated
	 */
	void unsetReferencedSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getReferencedSource <em>Referenced Source</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Referenced Source</em>' reference is set.
	 * @see #unsetReferencedSource()
	 * @see #getReferencedSource()
	 * @see #setReferencedSource(IfcClassificationReferenceSelect)
	 * @generated
	 */
	boolean isSetReferencedSource();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassificationReference_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Sort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sort</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sort</em>' attribute.
	 * @see #isSetSort()
	 * @see #unsetSort()
	 * @see #setSort(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassificationReference_Sort()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSort();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getSort <em>Sort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sort</em>' attribute.
	 * @see #isSetSort()
	 * @see #unsetSort()
	 * @see #getSort()
	 * @generated
	 */
	void setSort(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getSort <em>Sort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSort()
	 * @see #getSort()
	 * @see #setSort(String)
	 * @generated
	 */
	void unsetSort();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getSort <em>Sort</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sort</em>' attribute is set.
	 * @see #unsetSort()
	 * @see #getSort()
	 * @see #setSort(String)
	 * @generated
	 */
	boolean isSetSort();

	/**
	 * Returns the value of the '<em><b>Classification Ref For Objects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssociatesClassification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classification Ref For Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classification Ref For Objects</em>' reference list.
	 * @see #isSetClassificationRefForObjects()
	 * @see #unsetClassificationRefForObjects()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassificationReference_ClassificationRefForObjects()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssociatesClassification> getClassificationRefForObjects();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getClassificationRefForObjects <em>Classification Ref For Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetClassificationRefForObjects()
	 * @see #getClassificationRefForObjects()
	 * @generated
	 */
	void unsetClassificationRefForObjects();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getClassificationRefForObjects <em>Classification Ref For Objects</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Classification Ref For Objects</em>' reference list is set.
	 * @see #unsetClassificationRefForObjects()
	 * @see #getClassificationRefForObjects()
	 * @generated
	 */
	boolean isSetClassificationRefForObjects();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcClassificationReference_HasReferences()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcClassificationReference> getHasReferences();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getHasReferences <em>Has References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasReferences()
	 * @see #getHasReferences()
	 * @generated
	 */
	void unsetHasReferences();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcClassificationReference#getHasReferences <em>Has References</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has References</em>' reference list is set.
	 * @see #unsetHasReferences()
	 * @see #getHasReferences()
	 * @generated
	 */
	boolean isSetHasReferences();

} // IfcClassificationReference
