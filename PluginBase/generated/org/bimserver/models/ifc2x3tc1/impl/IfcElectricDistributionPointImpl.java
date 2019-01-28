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
import org.bimserver.models.ifc2x3tc1.IfcElectricDistributionPoint;
import org.bimserver.models.ifc2x3tc1.IfcElectricDistributionPointFunctionEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Electric Distribution Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricDistributionPointImpl#getDistributionPointFunction <em>Distribution Point Function</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricDistributionPointImpl#getUserDefinedFunction <em>User Defined Function</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcElectricDistributionPointImpl extends IfcFlowControllerImpl implements IfcElectricDistributionPoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcElectricDistributionPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_ELECTRIC_DISTRIBUTION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricDistributionPointFunctionEnum getDistributionPointFunction() {
		return (IfcElectricDistributionPointFunctionEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_ELECTRIC_DISTRIBUTION_POINT__DISTRIBUTION_POINT_FUNCTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistributionPointFunction(IfcElectricDistributionPointFunctionEnum newDistributionPointFunction) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRIC_DISTRIBUTION_POINT__DISTRIBUTION_POINT_FUNCTION,
				newDistributionPointFunction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedFunction() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRIC_DISTRIBUTION_POINT__USER_DEFINED_FUNCTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedFunction(String newUserDefinedFunction) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRIC_DISTRIBUTION_POINT__USER_DEFINED_FUNCTION, newUserDefinedFunction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedFunction() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELECTRIC_DISTRIBUTION_POINT__USER_DEFINED_FUNCTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedFunction() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELECTRIC_DISTRIBUTION_POINT__USER_DEFINED_FUNCTION);
	}

} //IfcElectricDistributionPointImpl
