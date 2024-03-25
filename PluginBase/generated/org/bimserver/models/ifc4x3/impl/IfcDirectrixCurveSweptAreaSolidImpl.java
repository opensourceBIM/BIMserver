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
import org.bimserver.models.ifc4x3.IfcDirectrixCurveSweptAreaSolid;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Directrix Curve Swept Area Solid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDirectrixCurveSweptAreaSolidImpl#getDirectrix <em>Directrix</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDirectrixCurveSweptAreaSolidImpl#getStartParam <em>Start Param</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDirectrixCurveSweptAreaSolidImpl#getEndParam <em>End Param</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDirectrixCurveSweptAreaSolidImpl extends IfcSweptAreaSolidImpl
		implements IfcDirectrixCurveSweptAreaSolid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDirectrixCurveSweptAreaSolidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_DIRECTRIX_CURVE_SWEPT_AREA_SOLID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurve getDirectrix() {
		return (IfcCurve) eGet(Ifc4x3Package.Literals.IFC_DIRECTRIX_CURVE_SWEPT_AREA_SOLID__DIRECTRIX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDirectrix(IfcCurve newDirectrix) {
		eSet(Ifc4x3Package.Literals.IFC_DIRECTRIX_CURVE_SWEPT_AREA_SOLID__DIRECTRIX, newDirectrix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveMeasureSelect getStartParam() {
		return (IfcCurveMeasureSelect) eGet(Ifc4x3Package.Literals.IFC_DIRECTRIX_CURVE_SWEPT_AREA_SOLID__START_PARAM,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartParam(IfcCurveMeasureSelect newStartParam) {
		eSet(Ifc4x3Package.Literals.IFC_DIRECTRIX_CURVE_SWEPT_AREA_SOLID__START_PARAM, newStartParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStartParam() {
		eUnset(Ifc4x3Package.Literals.IFC_DIRECTRIX_CURVE_SWEPT_AREA_SOLID__START_PARAM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStartParam() {
		return eIsSet(Ifc4x3Package.Literals.IFC_DIRECTRIX_CURVE_SWEPT_AREA_SOLID__START_PARAM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveMeasureSelect getEndParam() {
		return (IfcCurveMeasureSelect) eGet(Ifc4x3Package.Literals.IFC_DIRECTRIX_CURVE_SWEPT_AREA_SOLID__END_PARAM,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndParam(IfcCurveMeasureSelect newEndParam) {
		eSet(Ifc4x3Package.Literals.IFC_DIRECTRIX_CURVE_SWEPT_AREA_SOLID__END_PARAM, newEndParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEndParam() {
		eUnset(Ifc4x3Package.Literals.IFC_DIRECTRIX_CURVE_SWEPT_AREA_SOLID__END_PARAM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEndParam() {
		return eIsSet(Ifc4x3Package.Literals.IFC_DIRECTRIX_CURVE_SWEPT_AREA_SOLID__END_PARAM);
	}

} //IfcDirectrixCurveSweptAreaSolidImpl
