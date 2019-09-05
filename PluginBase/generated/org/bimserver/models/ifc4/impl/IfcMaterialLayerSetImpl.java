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
import org.bimserver.models.ifc4.IfcMaterialLayer;
import org.bimserver.models.ifc4.IfcMaterialLayerSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Layer Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetImpl#getMaterialLayers <em>Material Layers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetImpl#getLayerSetName <em>Layer Set Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetImpl#getTotalThickness <em>Total Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetImpl#getTotalThicknessAsString <em>Total Thickness As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialLayerSetImpl extends IfcMaterialDefinitionImpl implements IfcMaterialLayerSet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialLayerSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcMaterialLayer> getMaterialLayers() {
		return (EList<IfcMaterialLayer>) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__MATERIAL_LAYERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLayerSetName() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__LAYER_SET_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLayerSetName(String newLayerSetName) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__LAYER_SET_NAME, newLayerSetName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLayerSetName() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__LAYER_SET_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLayerSetName() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__LAYER_SET_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTotalThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalThickness(double newTotalThickness) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS, newTotalThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTotalThickness() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTotalThickness() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTotalThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalThicknessAsString(String newTotalThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS_AS_STRING, newTotalThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTotalThicknessAsString() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTotalThicknessAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS_AS_STRING);
	}

} //IfcMaterialLayerSetImpl
