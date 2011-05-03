/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCurve;
import org.bimserver.models.ifc2x3.IfcSurface;
import org.bimserver.models.ifc2x3.IfcSurfaceCurveSweptAreaSolid;

import org.bimserver.models.ifc2x3.impl.IfcSweptAreaSolidImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Curve Swept Area Solid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceCurveSweptAreaSolidImpl#getDirectrix <em>Directrix</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceCurveSweptAreaSolidImpl#getStartParam <em>Start Param</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceCurveSweptAreaSolidImpl#getStartParamAsString <em>Start Param As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceCurveSweptAreaSolidImpl#getEndParam <em>End Param</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceCurveSweptAreaSolidImpl#getEndParamAsString <em>End Param As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceCurveSweptAreaSolidImpl#getReferenceSurface <em>Reference Surface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSurfaceCurveSweptAreaSolidImpl extends IfcSweptAreaSolidImpl implements IfcSurfaceCurveSweptAreaSolid
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceCurveSweptAreaSolidImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getDirectrix()
	{
		return (IfcCurve)eGet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__DIRECTRIX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectrix(IfcCurve newDirectrix)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__DIRECTRIX, newDirectrix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getStartParam()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartParam(float newStartParam)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM, newStartParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStartParamAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartParamAsString(String newStartParamAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__START_PARAM_AS_STRING, newStartParamAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getEndParam()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndParam(float newEndParam)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM, newEndParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEndParamAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndParamAsString(String newEndParamAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__END_PARAM_AS_STRING, newEndParamAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurface getReferenceSurface()
	{
		return (IfcSurface)eGet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__REFERENCE_SURFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceSurface(IfcSurface newReferenceSurface)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID__REFERENCE_SURFACE, newReferenceSurface);
	}

} //IfcSurfaceCurveSweptAreaSolidImpl
