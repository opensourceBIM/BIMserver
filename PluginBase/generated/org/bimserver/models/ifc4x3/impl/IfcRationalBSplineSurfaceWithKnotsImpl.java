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
import org.bimserver.models.ifc4x3.IfcRationalBSplineSurfaceWithKnots;
import org.bimserver.models.ifc4x3.ListOfEDouble;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rational BSpline Surface With Knots</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRationalBSplineSurfaceWithKnotsImpl#getWeightsData <em>Weights Data</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRationalBSplineSurfaceWithKnotsImpl#getWeights <em>Weights</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRationalBSplineSurfaceWithKnotsImpl#getWeightsAsString <em>Weights As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRationalBSplineSurfaceWithKnotsImpl extends IfcBSplineSurfaceWithKnotsImpl
		implements IfcRationalBSplineSurfaceWithKnots {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRationalBSplineSurfaceWithKnotsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_RATIONAL_BSPLINE_SURFACE_WITH_KNOTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ListOfEDouble> getWeightsData() {
		return (EList<ListOfEDouble>) eGet(Ifc4x3Package.Literals.IFC_RATIONAL_BSPLINE_SURFACE_WITH_KNOTS__WEIGHTS_DATA,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWeights() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_RATIONAL_BSPLINE_SURFACE_WITH_KNOTS__WEIGHTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWeights(double newWeights) {
		eSet(Ifc4x3Package.Literals.IFC_RATIONAL_BSPLINE_SURFACE_WITH_KNOTS__WEIGHTS, newWeights);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWeights() {
		eUnset(Ifc4x3Package.Literals.IFC_RATIONAL_BSPLINE_SURFACE_WITH_KNOTS__WEIGHTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWeights() {
		return eIsSet(Ifc4x3Package.Literals.IFC_RATIONAL_BSPLINE_SURFACE_WITH_KNOTS__WEIGHTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWeightsAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_RATIONAL_BSPLINE_SURFACE_WITH_KNOTS__WEIGHTS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWeightsAsString(String newWeightsAsString) {
		eSet(Ifc4x3Package.Literals.IFC_RATIONAL_BSPLINE_SURFACE_WITH_KNOTS__WEIGHTS_AS_STRING, newWeightsAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWeightsAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_RATIONAL_BSPLINE_SURFACE_WITH_KNOTS__WEIGHTS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWeightsAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_RATIONAL_BSPLINE_SURFACE_WITH_KNOTS__WEIGHTS_AS_STRING);
	}

} //IfcRationalBSplineSurfaceWithKnotsImpl
