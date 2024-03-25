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
 * A representation of the model object '<em><b>Ifc Material Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcMaterialRelationship#getRelatingMaterial <em>Relating Material</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcMaterialRelationship#getRelatedMaterials <em>Related Materials</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcMaterialRelationship#getMaterialExpression <em>Material Expression</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMaterialRelationship()
 * @model
 * @generated
 */
public interface IfcMaterialRelationship extends IfcResourceLevelRelationship {
	/**
	 * Returns the value of the '<em><b>Relating Material</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcMaterial#getRelatesTo <em>Relates To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Material</em>' reference.
	 * @see #setRelatingMaterial(IfcMaterial)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMaterialRelationship_RelatingMaterial()
	 * @see org.bimserver.models.ifc4x3.IfcMaterial#getRelatesTo
	 * @model opposite="RelatesTo"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcMaterial getRelatingMaterial();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcMaterialRelationship#getRelatingMaterial <em>Relating Material</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Material</em>' reference.
	 * @see #getRelatingMaterial()
	 * @generated
	 */
	void setRelatingMaterial(IfcMaterial value);

	/**
	 * Returns the value of the '<em><b>Related Materials</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcMaterial}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcMaterial#getIsRelatedWith <em>Is Related With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Materials</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMaterialRelationship_RelatedMaterials()
	 * @see org.bimserver.models.ifc4x3.IfcMaterial#getIsRelatedWith
	 * @model opposite="IsRelatedWith"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcMaterial> getRelatedMaterials();

	/**
	 * Returns the value of the '<em><b>Material Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Material Expression</em>' attribute.
	 * @see #isSetMaterialExpression()
	 * @see #unsetMaterialExpression()
	 * @see #setMaterialExpression(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMaterialRelationship_MaterialExpression()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMaterialExpression();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcMaterialRelationship#getMaterialExpression <em>Material Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Material Expression</em>' attribute.
	 * @see #isSetMaterialExpression()
	 * @see #unsetMaterialExpression()
	 * @see #getMaterialExpression()
	 * @generated
	 */
	void setMaterialExpression(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcMaterialRelationship#getMaterialExpression <em>Material Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaterialExpression()
	 * @see #getMaterialExpression()
	 * @see #setMaterialExpression(String)
	 * @generated
	 */
	void unsetMaterialExpression();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcMaterialRelationship#getMaterialExpression <em>Material Expression</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Material Expression</em>' attribute is set.
	 * @see #unsetMaterialExpression()
	 * @see #getMaterialExpression()
	 * @see #setMaterialExpression(String)
	 * @generated
	 */
	boolean isSetMaterialExpression();

} // IfcMaterialRelationship
