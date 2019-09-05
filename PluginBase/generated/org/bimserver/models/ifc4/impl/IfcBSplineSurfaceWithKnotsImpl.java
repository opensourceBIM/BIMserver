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
import org.bimserver.models.ifc4.IfcBSplineSurfaceWithKnots;
import org.bimserver.models.ifc4.IfcKnotType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc BSpline Surface With Knots</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceWithKnotsImpl#getUMultiplicities <em>UMultiplicities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceWithKnotsImpl#getVMultiplicities <em>VMultiplicities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceWithKnotsImpl#getUKnots <em>UKnots</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceWithKnotsImpl#getUKnotsAsString <em>UKnots As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceWithKnotsImpl#getVKnots <em>VKnots</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceWithKnotsImpl#getVKnotsAsString <em>VKnots As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceWithKnotsImpl#getKnotSpec <em>Knot Spec</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceWithKnotsImpl#getKnotVUpper <em>Knot VUpper</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineSurfaceWithKnotsImpl#getKnotUUpper <em>Knot UUpper</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBSplineSurfaceWithKnotsImpl extends IfcBSplineSurfaceImpl implements IfcBSplineSurfaceWithKnots {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBSplineSurfaceWithKnotsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Long> getUMultiplicities() {
		return (EList<Long>) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__UMULTIPLICITIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Long> getVMultiplicities() {
		return (EList<Long>) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__VMULTIPLICITIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getUKnots() {
		return (EList<Double>) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__UKNOTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getUKnotsAsString() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__UKNOTS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getVKnots() {
		return (EList<Double>) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__VKNOTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getVKnotsAsString() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__VKNOTS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcKnotType getKnotSpec() {
		return (IfcKnotType) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__KNOT_SPEC, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKnotSpec(IfcKnotType newKnotSpec) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__KNOT_SPEC, newKnotSpec);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getKnotVUpper() {
		return (Long) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__KNOT_VUPPER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKnotVUpper(long newKnotVUpper) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__KNOT_VUPPER, newKnotVUpper);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetKnotVUpper() {
		eUnset(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__KNOT_VUPPER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetKnotVUpper() {
		return eIsSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__KNOT_VUPPER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getKnotUUpper() {
		return (Long) eGet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__KNOT_UUPPER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKnotUUpper(long newKnotUUpper) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__KNOT_UUPPER, newKnotUUpper);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetKnotUUpper() {
		eUnset(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__KNOT_UUPPER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetKnotUUpper() {
		return eIsSet(Ifc4Package.Literals.IFC_BSPLINE_SURFACE_WITH_KNOTS__KNOT_UUPPER);
	}

} //IfcBSplineSurfaceWithKnotsImpl
