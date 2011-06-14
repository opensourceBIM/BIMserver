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
		return Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getBasisCurve()
	{
		return (IfcCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_BasisCurve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisCurve(IfcCurve newBasisCurve)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_BasisCurve(), newBasisCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDistance()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_Distance(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistance(float newDistance)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_Distance(), newDistance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDistanceAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_DistanceAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistanceAsString(String newDistanceAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_DistanceAsString(), newDistanceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSelfIntersect()
	{
		return (Boolean)eGet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_SelfIntersect(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfIntersect(boolean newSelfIntersect)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_SelfIntersect(), newSelfIntersect);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getRefDirection()
	{
		return (IfcDirection)eGet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_RefDirection(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefDirection(IfcDirection newRefDirection)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_RefDirection(), newRefDirection);
	}

} //IfcOffsetCurve3DImpl
