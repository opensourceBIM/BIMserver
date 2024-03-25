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
import org.bimserver.models.ifc4x3.IfcBoundaryCurve;
import org.bimserver.models.ifc4x3.IfcCurveBoundedSurface;
import org.bimserver.models.ifc4x3.IfcSurface;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Bounded Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurveBoundedSurfaceImpl#getBasisSurface <em>Basis Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurveBoundedSurfaceImpl#getBoundaries <em>Boundaries</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurveBoundedSurfaceImpl#getImplicitOuter <em>Implicit Outer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCurveBoundedSurfaceImpl extends IfcBoundedSurfaceImpl implements IfcCurveBoundedSurface {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCurveBoundedSurfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_CURVE_BOUNDED_SURFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurface getBasisSurface() {
		return (IfcSurface) eGet(Ifc4x3Package.Literals.IFC_CURVE_BOUNDED_SURFACE__BASIS_SURFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBasisSurface(IfcSurface newBasisSurface) {
		eSet(Ifc4x3Package.Literals.IFC_CURVE_BOUNDED_SURFACE__BASIS_SURFACE, newBasisSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcBoundaryCurve> getBoundaries() {
		return (EList<IfcBoundaryCurve>) eGet(Ifc4x3Package.Literals.IFC_CURVE_BOUNDED_SURFACE__BOUNDARIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getImplicitOuter() {
		return (Tristate) eGet(Ifc4x3Package.Literals.IFC_CURVE_BOUNDED_SURFACE__IMPLICIT_OUTER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImplicitOuter(Tristate newImplicitOuter) {
		eSet(Ifc4x3Package.Literals.IFC_CURVE_BOUNDED_SURFACE__IMPLICIT_OUTER, newImplicitOuter);
	}

} //IfcCurveBoundedSurfaceImpl
