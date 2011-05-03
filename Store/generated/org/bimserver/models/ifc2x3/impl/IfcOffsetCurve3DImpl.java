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
import org.bimserver.models.ifc2x3.IfcDirection;
import org.bimserver.models.ifc2x3.IfcOffsetCurve3D;

import org.bimserver.models.ifc2x3.impl.IfcCurveImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Offset Curve3 D</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOffsetCurve3DImpl#getBasisCurve <em>Basis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOffsetCurve3DImpl#getDistance <em>Distance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOffsetCurve3DImpl#getDistanceAsString <em>Distance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOffsetCurve3DImpl#isSelfIntersect <em>Self Intersect</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOffsetCurve3DImpl#getRefDirection <em>Ref Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcOffsetCurve3DImpl extends IfcCurveImpl implements IfcOffsetCurve3D
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
	protected IfcOffsetCurve3DImpl()
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
		return Ifc2x3Package.Literals.IFC_OFFSET_CURVE3_D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getBasisCurve()
	{
		return (IfcCurve)eGet(Ifc2x3Package.Literals.IFC_OFFSET_CURVE3_D__BASIS_CURVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisCurve(IfcCurve newBasisCurve)
	{
		eSet(Ifc2x3Package.Literals.IFC_OFFSET_CURVE3_D__BASIS_CURVE, newBasisCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDistance()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_OFFSET_CURVE3_D__DISTANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistance(float newDistance)
	{
		eSet(Ifc2x3Package.Literals.IFC_OFFSET_CURVE3_D__DISTANCE, newDistance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDistanceAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_OFFSET_CURVE3_D__DISTANCE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistanceAsString(String newDistanceAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_OFFSET_CURVE3_D__DISTANCE_AS_STRING, newDistanceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSelfIntersect()
	{
		return (Boolean)eGet(Ifc2x3Package.Literals.IFC_OFFSET_CURVE3_D__SELF_INTERSECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfIntersect(boolean newSelfIntersect)
	{
		eSet(Ifc2x3Package.Literals.IFC_OFFSET_CURVE3_D__SELF_INTERSECT, newSelfIntersect);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getRefDirection()
	{
		return (IfcDirection)eGet(Ifc2x3Package.Literals.IFC_OFFSET_CURVE3_D__REF_DIRECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefDirection(IfcDirection newRefDirection)
	{
		eSet(Ifc2x3Package.Literals.IFC_OFFSET_CURVE3_D__REF_DIRECTION, newRefDirection);
	}

} //IfcOffsetCurve3DImpl
