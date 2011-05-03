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
import org.bimserver.models.ifc2x3.IfcCurveBoundedPlane;
import org.bimserver.models.ifc2x3.IfcPlane;

import org.bimserver.models.ifc2x3.impl.IfcBoundedSurfaceImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Bounded Plane</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveBoundedPlaneImpl#getBasisSurface <em>Basis Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveBoundedPlaneImpl#getOuterBoundary <em>Outer Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveBoundedPlaneImpl#getInnerBoundaries <em>Inner Boundaries</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveBoundedPlaneImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCurveBoundedPlaneImpl extends IfcBoundedSurfaceImpl implements IfcCurveBoundedPlane
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
	protected IfcCurveBoundedPlaneImpl()
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
		return Ifc2x3Package.Literals.IFC_CURVE_BOUNDED_PLANE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPlane getBasisSurface()
	{
		return (IfcPlane)eGet(Ifc2x3Package.Literals.IFC_CURVE_BOUNDED_PLANE__BASIS_SURFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisSurface(IfcPlane newBasisSurface)
	{
		eSet(Ifc2x3Package.Literals.IFC_CURVE_BOUNDED_PLANE__BASIS_SURFACE, newBasisSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getOuterBoundary()
	{
		return (IfcCurve)eGet(Ifc2x3Package.Literals.IFC_CURVE_BOUNDED_PLANE__OUTER_BOUNDARY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterBoundary(IfcCurve newOuterBoundary)
	{
		eSet(Ifc2x3Package.Literals.IFC_CURVE_BOUNDED_PLANE__OUTER_BOUNDARY, newOuterBoundary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcCurve> getInnerBoundaries()
	{
		return (EList<IfcCurve>)eGet(Ifc2x3Package.Literals.IFC_CURVE_BOUNDED_PLANE__INNER_BOUNDARIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim()
	{
		return (Integer)eGet(Ifc2x3Package.Literals.IFC_CURVE_BOUNDED_PLANE__DIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim)
	{
		eSet(Ifc2x3Package.Literals.IFC_CURVE_BOUNDED_PLANE__DIM, newDim);
	}

} //IfcCurveBoundedPlaneImpl
