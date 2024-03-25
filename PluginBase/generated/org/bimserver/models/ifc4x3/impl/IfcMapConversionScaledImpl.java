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
import org.bimserver.models.ifc4x3.IfcMapConversionScaled;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Map Conversion Scaled</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionScaledImpl#getFactorX <em>Factor X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionScaledImpl#getFactorXAsString <em>Factor XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionScaledImpl#getFactorY <em>Factor Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionScaledImpl#getFactorYAsString <em>Factor YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionScaledImpl#getFactorZ <em>Factor Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionScaledImpl#getFactorZAsString <em>Factor ZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMapConversionScaledImpl extends IfcMapConversionImpl implements IfcMapConversionScaled {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMapConversionScaledImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFactorX() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFactorX(double newFactorX) {
		eSet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_X, newFactorX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFactorXAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFactorXAsString(String newFactorXAsString) {
		eSet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_XAS_STRING, newFactorXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFactorY() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFactorY(double newFactorY) {
		eSet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_Y, newFactorY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFactorYAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFactorYAsString(String newFactorYAsString) {
		eSet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_YAS_STRING, newFactorYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFactorZ() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFactorZ(double newFactorZ) {
		eSet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_Z, newFactorZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFactorZAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFactorZAsString(String newFactorZAsString) {
		eSet(Ifc4x3Package.Literals.IFC_MAP_CONVERSION_SCALED__FACTOR_ZAS_STRING, newFactorZAsString);
	}

} //IfcMapConversionScaledImpl
