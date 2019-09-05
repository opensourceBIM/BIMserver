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
import org.bimserver.models.ifc4.IfcStructuralLoadTemperature;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Temperature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadTemperatureImpl#getDeltaTConstant <em>Delta TConstant</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadTemperatureImpl#getDeltaTConstantAsString <em>Delta TConstant As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadTemperatureImpl#getDeltaTY <em>Delta TY</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadTemperatureImpl#getDeltaTYAsString <em>Delta TY As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadTemperatureImpl#getDeltaTZ <em>Delta TZ</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadTemperatureImpl#getDeltaTZAsString <em>Delta TZ As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadTemperatureImpl extends IfcStructuralLoadStaticImpl implements IfcStructuralLoadTemperature {
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
		return Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDeltaTConstant() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeltaTConstant(double newDeltaTConstant) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT, newDeltaTConstant);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDeltaTConstant() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDeltaTConstant() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDeltaTConstantAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeltaTConstantAsString(String newDeltaTConstantAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT_AS_STRING, newDeltaTConstantAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDeltaTConstantAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDeltaTConstantAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TCONSTANT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDeltaTY() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeltaTY(double newDeltaTY) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY, newDeltaTY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDeltaTY() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDeltaTY() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDeltaTYAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeltaTYAsString(String newDeltaTYAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY_AS_STRING, newDeltaTYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDeltaTYAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDeltaTYAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDeltaTZ() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeltaTZ(double newDeltaTZ) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ, newDeltaTZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDeltaTZ() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDeltaTZ() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDeltaTZAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeltaTZAsString(String newDeltaTZAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ_AS_STRING, newDeltaTZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDeltaTZAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDeltaTZAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_TEMPERATURE__DELTA_TZ_AS_STRING);
	}

} //IfcStructuralLoadTemperatureImpl
