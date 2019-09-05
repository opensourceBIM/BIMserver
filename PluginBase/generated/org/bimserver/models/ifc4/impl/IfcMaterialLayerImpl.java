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
import org.bimserver.models.ifc4.IfcMaterialLayer;
import org.bimserver.models.ifc4.IfcMaterialLayerSet;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerImpl#getMaterial <em>Material</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerImpl#getLayerThickness <em>Layer Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerImpl#getLayerThicknessAsString <em>Layer Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerImpl#getIsVentilated <em>Is Ventilated</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerImpl#getToMaterialLayerSet <em>To Material Layer Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialLayerImpl extends IfcMaterialDefinitionImpl implements IfcMaterialLayer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialLayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_MATERIAL_LAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterial getMaterial() {
		return (IfcMaterial) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__MATERIAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaterial(IfcMaterial newMaterial) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__MATERIAL, newMaterial);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMaterial() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER__MATERIAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMaterial() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__MATERIAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLayerThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__LAYER_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLayerThickness(double newLayerThickness) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__LAYER_THICKNESS, newLayerThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLayerThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__LAYER_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLayerThicknessAsString(String newLayerThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__LAYER_THICKNESS_AS_STRING, newLayerThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getIsVentilated() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__IS_VENTILATED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsVentilated(Tristate newIsVentilated) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__IS_VENTILATED, newIsVentilated);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsVentilated() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER__IS_VENTILATED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsVentilated() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__IS_VENTILATED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCategory() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__CATEGORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCategory(String newCategory) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__CATEGORY, newCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCategory() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER__CATEGORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCategory() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__CATEGORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getPriority() {
		return (Long) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__PRIORITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPriority(long newPriority) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__PRIORITY, newPriority);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPriority() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER__PRIORITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPriority() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__PRIORITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialLayerSet getToMaterialLayerSet() {
		return (IfcMaterialLayerSet) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__TO_MATERIAL_LAYER_SET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setToMaterialLayerSet(IfcMaterialLayerSet newToMaterialLayerSet) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__TO_MATERIAL_LAYER_SET, newToMaterialLayerSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetToMaterialLayerSet() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER__TO_MATERIAL_LAYER_SET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetToMaterialLayerSet() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER__TO_MATERIAL_LAYER_SET);
	}

} //IfcMaterialLayerImpl
