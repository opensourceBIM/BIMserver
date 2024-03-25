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
import org.bimserver.models.ifc4x3.IfcGeographicCRS;
import org.bimserver.models.ifc4x3.IfcNamedUnit;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Geographic CRS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGeographicCRSImpl#getPrimeMeridian <em>Prime Meridian</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGeographicCRSImpl#getAngleUnit <em>Angle Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGeographicCRSImpl#getHeightUnit <em>Height Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcGeographicCRSImpl extends IfcCoordinateReferenceSystemImpl implements IfcGeographicCRS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGeographicCRSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimeMeridian() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__PRIME_MERIDIAN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimeMeridian(String newPrimeMeridian) {
		eSet(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__PRIME_MERIDIAN, newPrimeMeridian);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPrimeMeridian() {
		eUnset(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__PRIME_MERIDIAN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPrimeMeridian() {
		return eIsSet(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__PRIME_MERIDIAN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcNamedUnit getAngleUnit() {
		return (IfcNamedUnit) eGet(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__ANGLE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAngleUnit(IfcNamedUnit newAngleUnit) {
		eSet(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__ANGLE_UNIT, newAngleUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAngleUnit() {
		eUnset(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__ANGLE_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAngleUnit() {
		return eIsSet(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__ANGLE_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcNamedUnit getHeightUnit() {
		return (IfcNamedUnit) eGet(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__HEIGHT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeightUnit(IfcNamedUnit newHeightUnit) {
		eSet(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__HEIGHT_UNIT, newHeightUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHeightUnit() {
		eUnset(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__HEIGHT_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHeightUnit() {
		return eIsSet(Ifc4x3Package.Literals.IFC_GEOGRAPHIC_CRS__HEIGHT_UNIT);
	}

} //IfcGeographicCRSImpl
