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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcMaterial;
import org.bimserver.models.ifc4.IfcMaterialRelationship;
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
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialRelationshipImpl#getRelatingMaterial <em>Relating Material</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialRelationshipImpl#getRelatedMaterials <em>Related Materials</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialRelationshipImpl#getExpression <em>Expression</em>}</li>
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
		return Ifc4Package.Literals.IFC_MATERIAL_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterial getRelatingMaterial() {
		return (IfcMaterial) eGet(Ifc4Package.Literals.IFC_MATERIAL_RELATIONSHIP__RELATING_MATERIAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingMaterial(IfcMaterial newRelatingMaterial) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_RELATIONSHIP__RELATING_MATERIAL, newRelatingMaterial);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcMaterial> getRelatedMaterials() {
		return (EList<IfcMaterial>) eGet(Ifc4Package.Literals.IFC_MATERIAL_RELATIONSHIP__RELATED_MATERIALS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExpression() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_RELATIONSHIP__EXPRESSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpression(String newExpression) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_RELATIONSHIP__EXPRESSION, newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetExpression() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_RELATIONSHIP__EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetExpression() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_RELATIONSHIP__EXPRESSION);
	}

} //IfcMaterialRelationshipImpl
