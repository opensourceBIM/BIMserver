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
import org.bimserver.models.ifc2x3tc1.IfcDistributionControlElement;
import org.bimserver.models.ifc2x3tc1.IfcRelFlowControlElements;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Distribution Control Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDistributionControlElementImpl#getControlElementId <em>Control Element Id</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDistributionControlElementImpl#getAssignedToFlowElement <em>Assigned To Flow Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDistributionControlElementImpl extends IfcDistributionElementImpl
		implements IfcDistributionControlElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDistributionControlElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_DISTRIBUTION_CONTROL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getControlElementId() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DISTRIBUTION_CONTROL_ELEMENT__CONTROL_ELEMENT_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlElementId(String newControlElementId) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DISTRIBUTION_CONTROL_ELEMENT__CONTROL_ELEMENT_ID, newControlElementId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetControlElementId() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DISTRIBUTION_CONTROL_ELEMENT__CONTROL_ELEMENT_ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetControlElementId() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DISTRIBUTION_CONTROL_ELEMENT__CONTROL_ELEMENT_ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelFlowControlElements> getAssignedToFlowElement() {
		return (EList<IfcRelFlowControlElements>) eGet(
				Ifc2x3tc1Package.Literals.IFC_DISTRIBUTION_CONTROL_ELEMENT__ASSIGNED_TO_FLOW_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAssignedToFlowElement() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DISTRIBUTION_CONTROL_ELEMENT__ASSIGNED_TO_FLOW_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAssignedToFlowElement() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DISTRIBUTION_CONTROL_ELEMENT__ASSIGNED_TO_FLOW_ELEMENT);
	}

} //IfcDistributionControlElementImpl
