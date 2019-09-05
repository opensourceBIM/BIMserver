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
import org.bimserver.models.ifc4.IfcBSplineCurveWithKnots;
import org.bimserver.models.ifc4.IfcKnotType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc BSpline Curve With Knots</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineCurveWithKnotsImpl#getKnotMultiplicities <em>Knot Multiplicities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineCurveWithKnotsImpl#getKnots <em>Knots</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineCurveWithKnotsImpl#getKnotsAsString <em>Knots As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineCurveWithKnotsImpl#getKnotSpec <em>Knot Spec</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBSplineCurveWithKnotsImpl#getUpperIndexOnKnots <em>Upper Index On Knots</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBSplineCurveWithKnotsImpl extends IfcBSplineCurveImpl implements IfcBSplineCurveWithKnots {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBSplineCurveWithKnotsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_BSPLINE_CURVE_WITH_KNOTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Long> getKnotMultiplicities() {
		return (EList<Long>) eGet(Ifc4Package.Literals.IFC_BSPLINE_CURVE_WITH_KNOTS__KNOT_MULTIPLICITIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getKnots() {
		return (EList<Double>) eGet(Ifc4Package.Literals.IFC_BSPLINE_CURVE_WITH_KNOTS__KNOTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getKnotsAsString() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_BSPLINE_CURVE_WITH_KNOTS__KNOTS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcKnotType getKnotSpec() {
		return (IfcKnotType) eGet(Ifc4Package.Literals.IFC_BSPLINE_CURVE_WITH_KNOTS__KNOT_SPEC, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKnotSpec(IfcKnotType newKnotSpec) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_CURVE_WITH_KNOTS__KNOT_SPEC, newKnotSpec);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getUpperIndexOnKnots() {
		return (Long) eGet(Ifc4Package.Literals.IFC_BSPLINE_CURVE_WITH_KNOTS__UPPER_INDEX_ON_KNOTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpperIndexOnKnots(long newUpperIndexOnKnots) {
		eSet(Ifc4Package.Literals.IFC_BSPLINE_CURVE_WITH_KNOTS__UPPER_INDEX_ON_KNOTS, newUpperIndexOnKnots);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUpperIndexOnKnots() {
		eUnset(Ifc4Package.Literals.IFC_BSPLINE_CURVE_WITH_KNOTS__UPPER_INDEX_ON_KNOTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUpperIndexOnKnots() {
		return eIsSet(Ifc4Package.Literals.IFC_BSPLINE_CURVE_WITH_KNOTS__UPPER_INDEX_ON_KNOTS);
	}

} //IfcBSplineCurveWithKnotsImpl
