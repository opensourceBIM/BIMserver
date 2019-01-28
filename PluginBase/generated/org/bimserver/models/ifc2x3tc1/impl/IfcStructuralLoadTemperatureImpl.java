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
import org.bimserver.models.ifc2x3tc1.IfcStructuralLoadTemperature;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Temperature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadTemperatureImpl#getDeltaT_Constant <em>Delta TConstant</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadTemperatureImpl#getDeltaT_ConstantAsString <em>Delta TConstant As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadTemperatureImpl#getDeltaT_Y <em>Delta TY</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadTemperatureImpl#getDeltaT_YAsString <em>Delta TYAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadTemperatureImpl#getDeltaT_Z <em>Delta TZ</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralLoadTemperatureImpl#getDeltaT_ZAsString <em>Delta TZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadTemperatureImpl extends IfcStructuralLoadStaticImpl
		implements IfcStructuralLoadTemperature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadTemperatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDeltaT_Constant() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltaT_Constant(double newDeltaT_Constant) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT, newDeltaT_Constant);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDeltaT_Constant() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDeltaT_Constant() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeltaT_ConstantAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltaT_ConstantAsString(String newDeltaT_ConstantAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT_AS_STRING,
				newDeltaT_ConstantAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDeltaT_ConstantAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDeltaT_ConstantAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDeltaT_Y() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltaT_Y(double newDeltaT_Y) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY, newDeltaT_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDeltaT_Y() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDeltaT_Y() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeltaT_YAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TYAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltaT_YAsString(String newDeltaT_YAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TYAS_STRING, newDeltaT_YAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDeltaT_YAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TYAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDeltaT_YAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TYAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDeltaT_Z() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltaT_Z(double newDeltaT_Z) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ, newDeltaT_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDeltaT_Z() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDeltaT_Z() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeltaT_ZAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltaT_ZAsString(String newDeltaT_ZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZAS_STRING, newDeltaT_ZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDeltaT_ZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDeltaT_ZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZAS_STRING);
	}

} //IfcStructuralLoadTemperatureImpl
