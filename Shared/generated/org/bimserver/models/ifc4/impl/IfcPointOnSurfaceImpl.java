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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcPointOnSurface;
import org.bimserver.models.ifc4.IfcSurface;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Point On Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPointOnSurfaceImpl#getBasisSurface <em>Basis Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPointOnSurfaceImpl#getPointParameterU <em>Point Parameter U</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPointOnSurfaceImpl#getPointParameterUAsString <em>Point Parameter UAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPointOnSurfaceImpl#getPointParameterV <em>Point Parameter V</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPointOnSurfaceImpl#getPointParameterVAsString <em>Point Parameter VAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPointOnSurfaceImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPointOnSurfaceImpl extends IfcPointImpl implements IfcPointOnSurface {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPointOnSurfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_POINT_ON_SURFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurface getBasisSurface() {
		return (IfcSurface) eGet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__BASIS_SURFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisSurface(IfcSurface newBasisSurface) {
		eSet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__BASIS_SURFACE, newBasisSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPointParameterU() {
		return (Double) eGet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__POINT_PARAMETER_U, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointParameterU(double newPointParameterU) {
		eSet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__POINT_PARAMETER_U, newPointParameterU);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPointParameterUAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__POINT_PARAMETER_UAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointParameterUAsString(String newPointParameterUAsString) {
		eSet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__POINT_PARAMETER_UAS_STRING, newPointParameterUAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPointParameterV() {
		return (Double) eGet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__POINT_PARAMETER_V, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointParameterV(double newPointParameterV) {
		eSet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__POINT_PARAMETER_V, newPointParameterV);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPointParameterVAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__POINT_PARAMETER_VAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointParameterVAsString(String newPointParameterVAsString) {
		eSet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__POINT_PARAMETER_VAS_STRING, newPointParameterVAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim() {
		return (Integer) eGet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__DIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim) {
		eSet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__DIM, newDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDim() {
		eUnset(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__DIM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDim() {
		return eIsSet(Ifc4Package.Literals.IFC_POINT_ON_SURFACE__DIM);
	}

} //IfcPointOnSurfaceImpl
