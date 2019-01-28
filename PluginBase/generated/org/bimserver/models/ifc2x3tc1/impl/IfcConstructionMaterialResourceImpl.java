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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcActorSelect;
import org.bimserver.models.ifc2x3tc1.IfcConstructionMaterialResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Construction Material Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstructionMaterialResourceImpl#getSuppliers <em>Suppliers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstructionMaterialResourceImpl#getUsageRatio <em>Usage Ratio</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstructionMaterialResourceImpl#getUsageRatioAsString <em>Usage Ratio As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConstructionMaterialResourceImpl extends IfcConstructionResourceImpl
		implements IfcConstructionMaterialResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConstructionMaterialResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcActorSelect> getSuppliers() {
		return (EList<IfcActorSelect>) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE__SUPPLIERS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuppliers() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE__SUPPLIERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuppliers() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE__SUPPLIERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUsageRatio() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE__USAGE_RATIO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageRatio(double newUsageRatio) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE__USAGE_RATIO, newUsageRatio);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsageRatio() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE__USAGE_RATIO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsageRatio() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE__USAGE_RATIO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsageRatioAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE__USAGE_RATIO_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageRatioAsString(String newUsageRatioAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE__USAGE_RATIO_AS_STRING,
				newUsageRatioAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsageRatioAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE__USAGE_RATIO_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsageRatioAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_MATERIAL_RESOURCE__USAGE_RATIO_AS_STRING);
	}

} //IfcConstructionMaterialResourceImpl
