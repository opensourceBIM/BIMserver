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
import org.bimserver.models.ifc2x3tc1.IfcConnectionPointEccentricity;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Point Eccentricity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionPointEccentricityImpl#getEccentricityInX <em>Eccentricity In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionPointEccentricityImpl#getEccentricityInXAsString <em>Eccentricity In XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionPointEccentricityImpl#getEccentricityInY <em>Eccentricity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionPointEccentricityImpl#getEccentricityInYAsString <em>Eccentricity In YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionPointEccentricityImpl#getEccentricityInZ <em>Eccentricity In Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionPointEccentricityImpl#getEccentricityInZAsString <em>Eccentricity In ZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConnectionPointEccentricityImpl extends IfcConnectionPointGeometryImpl
		implements IfcConnectionPointEccentricity {
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
		return Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getEccentricityInX() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInX(double newEccentricityInX) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_X, newEccentricityInX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInX() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInX() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEccentricityInXAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_XAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInXAsString(String newEccentricityInXAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_XAS_STRING,
				newEccentricityInXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInXAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInXAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getEccentricityInY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInY(double newEccentricityInY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Y, newEccentricityInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEccentricityInYAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_YAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInYAsString(String newEccentricityInYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_YAS_STRING,
				newEccentricityInYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getEccentricityInZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInZ(double newEccentricityInZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Z, newEccentricityInZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEccentricityInZAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_ZAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInZAsString(String newEccentricityInZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_ZAS_STRING,
				newEccentricityInZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_ECCENTRICITY__ECCENTRICITY_IN_ZAS_STRING);
	}

} //IfcConnectionPointEccentricityImpl
