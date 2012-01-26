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
 * A representation of the model object '<em><b>Ifc Material Classification Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialClassificationRelationship#getMaterialClassifications <em>Material Classifications</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialClassificationRelationship#getClassifiedMaterial <em>Classified Material</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialClassificationRelationship()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcMaterialClassificationRelationship extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Material Classifications</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcClassificationNotationSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Material Classifications</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Material Classifications</em>' reference list.
	 * @see #isSetMaterialClassifications()
	 * @see #unsetMaterialClassifications()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialClassificationRelationship_MaterialClassifications()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcClassificationNotationSelect> getMaterialClassifications();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialClassificationRelationship#getMaterialClassifications <em>Material Classifications</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaterialClassifications()
	 * @see #getMaterialClassifications()
	 * @generated
	 */
	void unsetMaterialClassifications();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialClassificationRelationship#getMaterialClassifications <em>Material Classifications</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Material Classifications</em>' reference list is set.
	 * @see #unsetMaterialClassifications()
	 * @see #getMaterialClassifications()
	 * @generated
	 */
	boolean isSetMaterialClassifications();

	/**
	 * Returns the value of the '<em><b>Classified Material</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcMaterial#getClassifiedAs <em>Classified As</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classified Material</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classified Material</em>' reference.
	 * @see #isSetClassifiedMaterial()
	 * @see #unsetClassifiedMaterial()
	 * @see #setClassifiedMaterial(IfcMaterial)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialClassificationRelationship_ClassifiedMaterial()
	 * @see org.bimserver.models.ifc2x3.IfcMaterial#getClassifiedAs
	 * @model opposite="ClassifiedAs" unsettable="true"
	 * @generated
	 */
	IfcMaterial getClassifiedMaterial();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialClassificationRelationship#getClassifiedMaterial <em>Classified Material</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classified Material</em>' reference.
	 * @see #isSetClassifiedMaterial()
	 * @see #unsetClassifiedMaterial()
	 * @see #getClassifiedMaterial()
	 * @generated
	 */
	void setClassifiedMaterial(IfcMaterial value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialClassificationRelationship#getClassifiedMaterial <em>Classified Material</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetClassifiedMaterial()
	 * @see #getClassifiedMaterial()
	 * @see #setClassifiedMaterial(IfcMaterial)
	 * @generated
	 */
	void unsetClassifiedMaterial();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialClassificationRelationship#getClassifiedMaterial <em>Classified Material</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Classified Material</em>' reference is set.
	 * @see #unsetClassifiedMaterial()
	 * @see #getClassifiedMaterial()
	 * @see #setClassifiedMaterial(IfcMaterial)
	 * @generated
	 */
	boolean isSetClassifiedMaterial();

} // IfcMaterialClassificationRelationship
