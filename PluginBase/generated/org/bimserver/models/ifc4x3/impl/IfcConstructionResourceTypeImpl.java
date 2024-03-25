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
import org.bimserver.models.ifc4x3.IfcAppliedValue;
import org.bimserver.models.ifc4x3.IfcConstructionResourceType;
import org.bimserver.models.ifc4x3.IfcPhysicalQuantity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Construction Resource Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcConstructionResourceTypeImpl#getBaseCosts <em>Base Costs</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcConstructionResourceTypeImpl#getBaseQuantity <em>Base Quantity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConstructionResourceTypeImpl extends IfcTypeResourceImpl implements IfcConstructionResourceType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConstructionResourceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_CONSTRUCTION_RESOURCE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcAppliedValue> getBaseCosts() {
		return (EList<IfcAppliedValue>) eGet(Ifc4x3Package.Literals.IFC_CONSTRUCTION_RESOURCE_TYPE__BASE_COSTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBaseCosts() {
		eUnset(Ifc4x3Package.Literals.IFC_CONSTRUCTION_RESOURCE_TYPE__BASE_COSTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBaseCosts() {
		return eIsSet(Ifc4x3Package.Literals.IFC_CONSTRUCTION_RESOURCE_TYPE__BASE_COSTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPhysicalQuantity getBaseQuantity() {
		return (IfcPhysicalQuantity) eGet(Ifc4x3Package.Literals.IFC_CONSTRUCTION_RESOURCE_TYPE__BASE_QUANTITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBaseQuantity(IfcPhysicalQuantity newBaseQuantity) {
		eSet(Ifc4x3Package.Literals.IFC_CONSTRUCTION_RESOURCE_TYPE__BASE_QUANTITY, newBaseQuantity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBaseQuantity() {
		eUnset(Ifc4x3Package.Literals.IFC_CONSTRUCTION_RESOURCE_TYPE__BASE_QUANTITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBaseQuantity() {
		return eIsSet(Ifc4x3Package.Literals.IFC_CONSTRUCTION_RESOURCE_TYPE__BASE_QUANTITY);
	}

} //IfcConstructionResourceTypeImpl
