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
import org.bimserver.models.ifc4.IfcDistributionPort;
import org.bimserver.models.ifc4.IfcDistributionPortTypeEnum;
import org.bimserver.models.ifc4.IfcDistributionSystemEnum;
import org.bimserver.models.ifc4.IfcFlowDirectionEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Distribution Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDistributionPortImpl#getFlowDirection <em>Flow Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDistributionPortImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDistributionPortImpl#getSystemType <em>System Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDistributionPortImpl extends IfcPortImpl implements IfcDistributionPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDistributionPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_DISTRIBUTION_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowDirectionEnum getFlowDirection() {
		return (IfcFlowDirectionEnum) eGet(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__FLOW_DIRECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlowDirection(IfcFlowDirectionEnum newFlowDirection) {
		eSet(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__FLOW_DIRECTION, newFlowDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFlowDirection() {
		eUnset(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__FLOW_DIRECTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFlowDirection() {
		return eIsSet(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__FLOW_DIRECTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionPortTypeEnum getPredefinedType() {
		return (IfcDistributionPortTypeEnum) eGet(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcDistributionPortTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionSystemEnum getSystemType() {
		return (IfcDistributionSystemEnum) eGet(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__SYSTEM_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSystemType(IfcDistributionSystemEnum newSystemType) {
		eSet(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__SYSTEM_TYPE, newSystemType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSystemType() {
		eUnset(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__SYSTEM_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSystemType() {
		return eIsSet(Ifc4Package.Literals.IFC_DISTRIBUTION_PORT__SYSTEM_TYPE);
	}

} //IfcDistributionPortImpl
