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
import org.bimserver.models.ifc4x3.IfcToroidalSurface;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Toroidal Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcToroidalSurfaceImpl#getMajorRadius <em>Major Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcToroidalSurfaceImpl#getMajorRadiusAsString <em>Major Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcToroidalSurfaceImpl#getMinorRadius <em>Minor Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcToroidalSurfaceImpl#getMinorRadiusAsString <em>Minor Radius As String</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcToroidalSurface();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMajorRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcToroidalSurface_MajorRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMajorRadius(double newMajorRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcToroidalSurface_MajorRadius(), newMajorRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMajorRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcToroidalSurface_MajorRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMajorRadiusAsString(String newMajorRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcToroidalSurface_MajorRadiusAsString(), newMajorRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMinorRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcToroidalSurface_MinorRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinorRadius(double newMinorRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcToroidalSurface_MinorRadius(), newMinorRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMinorRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcToroidalSurface_MinorRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinorRadiusAsString(String newMinorRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcToroidalSurface_MinorRadiusAsString(), newMinorRadiusAsString);
	}

} //IfcToroidalSurfaceImpl
