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
import org.bimserver.models.ifc4.IfcConnectionPointEccentricity;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Point Eccentricity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConnectionPointEccentricityImpl#getEccentricityInX <em>Eccentricity In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConnectionPointEccentricityImpl#getEccentricityInXAsString <em>Eccentricity In XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConnectionPointEccentricityImpl#getEccentricityInY <em>Eccentricity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConnectionPointEccentricityImpl#getEccentricityInYAsString <em>Eccentricity In YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConnectionPointEccentricityImpl#getEccentricityInZ <em>Eccentricity In Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConnectionPointEccentricityImpl#getEccentricityInZAsString <em>Eccentricity In ZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConnectionPointEccentricityImpl extends IfcConnectionPointGeometryImpl implements IfcConnectionPointEccentricity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionPointEccentricityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEccentricityInX() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEccentricityInX(double newEccentricityInX) {
		eSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_X, newEccentricityInX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEccentricityInX() {
		eUnset(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEccentricityInX() {
		return eIsSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEccentricityInXAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEccentricityInXAsString(String newEccentricityInXAsString) {
		eSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_XAS_STRING, newEccentricityInXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEccentricityInXAsString() {
		eUnset(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEccentricityInXAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEccentricityInY() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEccentricityInY(double newEccentricityInY) {
		eSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Y, newEccentricityInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEccentricityInY() {
		eUnset(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEccentricityInY() {
		return eIsSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEccentricityInYAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEccentricityInYAsString(String newEccentricityInYAsString) {
		eSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_YAS_STRING, newEccentricityInYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEccentricityInYAsString() {
		eUnset(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEccentricityInYAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEccentricityInZ() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEccentricityInZ(double newEccentricityInZ) {
		eSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Z, newEccentricityInZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEccentricityInZ() {
		eUnset(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEccentricityInZ() {
		return eIsSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEccentricityInZAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEccentricityInZAsString(String newEccentricityInZAsString) {
		eSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_ZAS_STRING, newEccentricityInZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEccentricityInZAsString() {
		eUnset(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEccentricityInZAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_ZAS_STRING);
	}

} //IfcConnectionPointEccentricityImpl
