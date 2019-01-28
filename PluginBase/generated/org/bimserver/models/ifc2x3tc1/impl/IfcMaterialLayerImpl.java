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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayer;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMaterialLayerImpl#getMaterial <em>Material</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMaterialLayerImpl#getLayerThickness <em>Layer Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMaterialLayerImpl#getLayerThicknessAsString <em>Layer Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMaterialLayerImpl#getIsVentilated <em>Is Ventilated</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMaterialLayerImpl#getToMaterialLayerSet <em>To Material Layer Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialLayerImpl extends IdEObjectImpl implements IfcMaterialLayer {
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
		return Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterial getMaterial() {
		return (IfcMaterial) eGet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__MATERIAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaterial(IfcMaterial newMaterial) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__MATERIAL, newMaterial);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaterial() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__MATERIAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaterial() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__MATERIAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLayerThickness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__LAYER_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerThickness(double newLayerThickness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__LAYER_THICKNESS, newLayerThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLayerThicknessAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__LAYER_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerThicknessAsString(String newLayerThicknessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__LAYER_THICKNESS_AS_STRING, newLayerThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getIsVentilated() {
		return (Tristate) eGet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__IS_VENTILATED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsVentilated(Tristate newIsVentilated) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__IS_VENTILATED, newIsVentilated);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsVentilated() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__IS_VENTILATED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsVentilated() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__IS_VENTILATED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialLayerSet getToMaterialLayerSet() {
		return (IfcMaterialLayerSet) eGet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__TO_MATERIAL_LAYER_SET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToMaterialLayerSet(IfcMaterialLayerSet newToMaterialLayerSet) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__TO_MATERIAL_LAYER_SET, newToMaterialLayerSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetToMaterialLayerSet() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__TO_MATERIAL_LAYER_SET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetToMaterialLayerSet() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER__TO_MATERIAL_LAYER_SET);
	}

} //IfcMaterialLayerImpl
