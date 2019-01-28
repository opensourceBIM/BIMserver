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
import org.bimserver.models.ifc2x3tc1.IfcConstructionResource;
import org.bimserver.models.ifc2x3tc1.IfcMeasureWithUnit;
import org.bimserver.models.ifc2x3tc1.IfcResourceConsumptionEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Construction Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstructionResourceImpl#getResourceIdentifier <em>Resource Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstructionResourceImpl#getResourceGroup <em>Resource Group</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstructionResourceImpl#getResourceConsumption <em>Resource Consumption</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConstructionResourceImpl#getBaseQuantity <em>Base Quantity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConstructionResourceImpl extends IfcResourceImpl implements IfcConstructionResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConstructionResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceIdentifier() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceIdentifier(String newResourceIdentifier) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_IDENTIFIER, newResourceIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResourceIdentifier() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResourceIdentifier() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceGroup() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceGroup(String newResourceGroup) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_GROUP, newResourceGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResourceGroup() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResourceGroup() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcResourceConsumptionEnum getResourceConsumption() {
		return (IfcResourceConsumptionEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_CONSUMPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceConsumption(IfcResourceConsumptionEnum newResourceConsumption) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_CONSUMPTION, newResourceConsumption);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResourceConsumption() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_CONSUMPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResourceConsumption() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__RESOURCE_CONSUMPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureWithUnit getBaseQuantity() {
		return (IfcMeasureWithUnit) eGet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__BASE_QUANTITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseQuantity(IfcMeasureWithUnit newBaseQuantity) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__BASE_QUANTITY, newBaseQuantity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBaseQuantity() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__BASE_QUANTITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBaseQuantity() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONSTRUCTION_RESOURCE__BASE_QUANTITY);
	}

} //IfcConstructionResourceImpl
