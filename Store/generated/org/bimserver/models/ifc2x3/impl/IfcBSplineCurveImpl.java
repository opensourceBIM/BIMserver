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
import org.bimserver.models.ifc2x3.IfcBSplineCurve;
import org.bimserver.models.ifc2x3.IfcBSplineCurveForm;
import org.bimserver.models.ifc2x3.IfcCartesianPoint;

import org.bimserver.models.ifc2x3.impl.IfcBoundedCurveImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc BSpline Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBSplineCurveImpl#getDegree <em>Degree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBSplineCurveImpl#getControlPointsList <em>Control Points List</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBSplineCurveImpl#getCurveForm <em>Curve Form</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBSplineCurveImpl#isClosedCurve <em>Closed Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBSplineCurveImpl#isSelfIntersect <em>Self Intersect</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBSplineCurveImpl extends IfcBoundedCurveImpl implements IfcBSplineCurve
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
	protected IfcBSplineCurveImpl()
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
		return Ifc2x3Package.Literals.IFC_BSPLINE_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDegree()
	{
		return (Integer)eGet(Ifc2x3Package.Literals.IFC_BSPLINE_CURVE__DEGREE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDegree(int newDegree)
	{
		eSet(Ifc2x3Package.Literals.IFC_BSPLINE_CURVE__DEGREE, newDegree);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcCartesianPoint> getControlPointsList()
	{
		return (EList<IfcCartesianPoint>)eGet(Ifc2x3Package.Literals.IFC_BSPLINE_CURVE__CONTROL_POINTS_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBSplineCurveForm getCurveForm()
	{
		return (IfcBSplineCurveForm)eGet(Ifc2x3Package.Literals.IFC_BSPLINE_CURVE__CURVE_FORM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveForm(IfcBSplineCurveForm newCurveForm)
	{
		eSet(Ifc2x3Package.Literals.IFC_BSPLINE_CURVE__CURVE_FORM, newCurveForm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClosedCurve()
	{
		return (Boolean)eGet(Ifc2x3Package.Literals.IFC_BSPLINE_CURVE__CLOSED_CURVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClosedCurve(boolean newClosedCurve)
	{
		eSet(Ifc2x3Package.Literals.IFC_BSPLINE_CURVE__CLOSED_CURVE, newClosedCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSelfIntersect()
	{
		return (Boolean)eGet(Ifc2x3Package.Literals.IFC_BSPLINE_CURVE__SELF_INTERSECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfIntersect(boolean newSelfIntersect)
	{
		eSet(Ifc2x3Package.Literals.IFC_BSPLINE_CURVE__SELF_INTERSECT, newSelfIntersect);
	}

} //IfcBSplineCurveImpl
