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
import org.bimserver.models.ifc4.IfcCurve;
import org.bimserver.models.ifc4.IfcSurface;
import org.bimserver.models.ifc4.IfcSurfaceCurveSweptAreaSolid;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Curve Swept Area Solid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceCurveSweptAreaSolidImpl#getDirectrix <em>Directrix</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceCurveSweptAreaSolidImpl#getStartParam <em>Start Param</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceCurveSweptAreaSolidImpl#getStartParamAsString <em>Start Param As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceCurveSweptAreaSolidImpl#getEndParam <em>End Param</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceCurveSweptAreaSolidImpl#getEndParamAsString <em>End Param As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceCurveSweptAreaSolidImpl#getReferenceSurface <em>Reference Surface</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSurfaceCurveSweptAreaSolidImpl extends IfcSweptAreaSolidImpl implements IfcSurfaceCurveSweptAreaSolid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceCurveSweptAreaSolidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurve getDirectrix() {
		return (IfcCurve) eGet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__DIRECTRIX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDirectrix(IfcCurve newDirectrix) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__DIRECTRIX, newDirectrix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartParam() {
		return (Double) eGet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartParam(double newStartParam) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM, newStartParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStartParam() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStartParam() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartParamAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartParamAsString(String newStartParamAsString) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM_AS_STRING, newStartParamAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStartParamAsString() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStartParamAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEndParam() {
		return (Double) eGet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndParam(double newEndParam) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM, newEndParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEndParam() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEndParam() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEndParamAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndParamAsString(String newEndParamAsString) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM_AS_STRING, newEndParamAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEndParamAsString() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEndParamAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurface getReferenceSurface() {
		return (IfcSurface) eGet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__REFERENCE_SURFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceSurface(IfcSurface newReferenceSurface) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__REFERENCE_SURFACE, newReferenceSurface);
	}

} //IfcSurfaceCurveSweptAreaSolidImpl
