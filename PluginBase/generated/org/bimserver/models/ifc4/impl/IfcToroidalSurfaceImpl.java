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
import org.bimserver.models.ifc4.IfcToroidalSurface;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Toroidal Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcToroidalSurfaceImpl#getMajorRadius <em>Major Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcToroidalSurfaceImpl#getMajorRadiusAsString <em>Major Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcToroidalSurfaceImpl#getMinorRadius <em>Minor Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcToroidalSurfaceImpl#getMinorRadiusAsString <em>Minor Radius As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcToroidalSurfaceImpl extends IfcElementarySurfaceImpl implements IfcToroidalSurface {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcToroidalSurfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TOROIDAL_SURFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMajorRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TOROIDAL_SURFACE__MAJOR_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMajorRadius(double newMajorRadius) {
		eSet(Ifc4Package.Literals.IFC_TOROIDAL_SURFACE__MAJOR_RADIUS, newMajorRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMajorRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TOROIDAL_SURFACE__MAJOR_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMajorRadiusAsString(String newMajorRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_TOROIDAL_SURFACE__MAJOR_RADIUS_AS_STRING, newMajorRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMinorRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TOROIDAL_SURFACE__MINOR_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinorRadius(double newMinorRadius) {
		eSet(Ifc4Package.Literals.IFC_TOROIDAL_SURFACE__MINOR_RADIUS, newMinorRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMinorRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TOROIDAL_SURFACE__MINOR_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinorRadiusAsString(String newMinorRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_TOROIDAL_SURFACE__MINOR_RADIUS_AS_STRING, newMinorRadiusAsString);
	}

} //IfcToroidalSurfaceImpl
