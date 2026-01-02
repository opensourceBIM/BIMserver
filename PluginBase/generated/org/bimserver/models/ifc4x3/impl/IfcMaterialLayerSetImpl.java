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
import org.bimserver.models.ifc4x3.IfcMaterialLayer;
import org.bimserver.models.ifc4x3.IfcMaterialLayerSet;

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
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetImpl#getMaterialLayers <em>Material Layers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetImpl#getLayerSetName <em>Layer Set Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetImpl#getTotalThickness <em>Total Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetImpl#getTotalThicknessAsString <em>Total Thickness As String</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcMaterialLayer> getMaterialLayers() {
		return (EList<IfcMaterialLayer>) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_MaterialLayers(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLayerSetName() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_LayerSetName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLayerSetName(String newLayerSetName) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_LayerSetName(), newLayerSetName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLayerSetName() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_LayerSetName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLayerSetName() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_LayerSetName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTotalThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_TotalThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalThickness(double newTotalThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_TotalThickness(), newTotalThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTotalThickness() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_TotalThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTotalThickness() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_TotalThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTotalThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_TotalThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalThicknessAsString(String newTotalThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_TotalThicknessAsString(), newTotalThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTotalThicknessAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_TotalThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTotalThicknessAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSet_TotalThicknessAsString());
	}

} //IfcMaterialLayerSetImpl
