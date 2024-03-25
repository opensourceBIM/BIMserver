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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcMaterial;
import org.bimserver.models.ifc4x3.IfcMaterialRelationship;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialRelationshipImpl#getRelatingMaterial <em>Relating Material</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialRelationshipImpl#getRelatedMaterials <em>Related Materials</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialRelationshipImpl#getMaterialExpression <em>Material Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialRelationshipImpl extends IfcResourceLevelRelationshipImpl implements IfcMaterialRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_MATERIAL_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterial getRelatingMaterial() {
		return (IfcMaterial) eGet(Ifc4x3Package.Literals.IFC_MATERIAL_RELATIONSHIP__RELATING_MATERIAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingMaterial(IfcMaterial newRelatingMaterial) {
		eSet(Ifc4x3Package.Literals.IFC_MATERIAL_RELATIONSHIP__RELATING_MATERIAL, newRelatingMaterial);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcMaterial> getRelatedMaterials() {
		return (EList<IfcMaterial>) eGet(Ifc4x3Package.Literals.IFC_MATERIAL_RELATIONSHIP__RELATED_MATERIALS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMaterialExpression() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_MATERIAL_RELATIONSHIP__MATERIAL_EXPRESSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaterialExpression(String newMaterialExpression) {
		eSet(Ifc4x3Package.Literals.IFC_MATERIAL_RELATIONSHIP__MATERIAL_EXPRESSION, newMaterialExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMaterialExpression() {
		eUnset(Ifc4x3Package.Literals.IFC_MATERIAL_RELATIONSHIP__MATERIAL_EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMaterialExpression() {
		return eIsSet(Ifc4x3Package.Literals.IFC_MATERIAL_RELATIONSHIP__MATERIAL_EXPRESSION);
	}

} //IfcMaterialRelationshipImpl
