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
import org.bimserver.models.ifc4x3.IfcCurve;
import org.bimserver.models.ifc4x3.IfcCurveMeasureSelect;
import org.bimserver.models.ifc4x3.IfcPointByDistanceExpression;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Point By Distance Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPointByDistanceExpressionImpl#getDistanceAlong <em>Distance Along</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPointByDistanceExpressionImpl#getOffsetLateral <em>Offset Lateral</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPointByDistanceExpressionImpl#getOffsetLateralAsString <em>Offset Lateral As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPointByDistanceExpressionImpl#getOffsetVertical <em>Offset Vertical</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPointByDistanceExpressionImpl#getOffsetVerticalAsString <em>Offset Vertical As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPointByDistanceExpressionImpl#getOffsetLongitudinal <em>Offset Longitudinal</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPointByDistanceExpressionImpl#getOffsetLongitudinalAsString <em>Offset Longitudinal As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPointByDistanceExpressionImpl#getBasisCurve <em>Basis Curve</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPointByDistanceExpressionImpl extends IfcPointImpl implements IfcPointByDistanceExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPointByDistanceExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveMeasureSelect getDistanceAlong() {
		return (IfcCurveMeasureSelect) eGet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__DISTANCE_ALONG,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDistanceAlong(IfcCurveMeasureSelect newDistanceAlong) {
		eSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__DISTANCE_ALONG, newDistanceAlong);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOffsetLateral() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LATERAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetLateral(double newOffsetLateral) {
		eSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LATERAL, newOffsetLateral);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOffsetLateral() {
		eUnset(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LATERAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOffsetLateral() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LATERAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOffsetLateralAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LATERAL_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetLateralAsString(String newOffsetLateralAsString) {
		eSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LATERAL_AS_STRING,
				newOffsetLateralAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOffsetLateralAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LATERAL_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOffsetLateralAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LATERAL_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOffsetVertical() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_VERTICAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetVertical(double newOffsetVertical) {
		eSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_VERTICAL, newOffsetVertical);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOffsetVertical() {
		eUnset(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_VERTICAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOffsetVertical() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_VERTICAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOffsetVerticalAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_VERTICAL_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetVerticalAsString(String newOffsetVerticalAsString) {
		eSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_VERTICAL_AS_STRING,
				newOffsetVerticalAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOffsetVerticalAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_VERTICAL_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOffsetVerticalAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_VERTICAL_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOffsetLongitudinal() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LONGITUDINAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetLongitudinal(double newOffsetLongitudinal) {
		eSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LONGITUDINAL, newOffsetLongitudinal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOffsetLongitudinal() {
		eUnset(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LONGITUDINAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOffsetLongitudinal() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LONGITUDINAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOffsetLongitudinalAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LONGITUDINAL_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetLongitudinalAsString(String newOffsetLongitudinalAsString) {
		eSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LONGITUDINAL_AS_STRING,
				newOffsetLongitudinalAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOffsetLongitudinalAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LONGITUDINAL_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOffsetLongitudinalAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__OFFSET_LONGITUDINAL_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurve getBasisCurve() {
		return (IfcCurve) eGet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__BASIS_CURVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBasisCurve(IfcCurve newBasisCurve) {
		eSet(Ifc4x3Package.Literals.IFC_POINT_BY_DISTANCE_EXPRESSION__BASIS_CURVE, newBasisCurve);
	}

} //IfcPointByDistanceExpressionImpl
