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
import org.bimserver.models.ifc2x3.IfcPointOnCurve;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Point On Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPointOnCurveImpl#getBasisCurve <em>Basis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPointOnCurveImpl#getPointParameter <em>Point Parameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPointOnCurveImpl#getPointParameterAsString <em>Point Parameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPointOnCurveImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPointOnCurveImpl extends IfcPointImpl implements IfcPointOnCurve
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPointOnCurveImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcPointOnCurve();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getBasisCurve()
	{
		return (IfcCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcPointOnCurve_BasisCurve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisCurve(IfcCurve newBasisCurve)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPointOnCurve_BasisCurve(), newBasisCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPointParameter()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcPointOnCurve_PointParameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointParameter(float newPointParameter)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPointOnCurve_PointParameter(), newPointParameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPointParameterAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPointOnCurve_PointParameterAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointParameterAsString(String newPointParameterAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPointOnCurve_PointParameterAsString(), newPointParameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcPointOnCurve_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPointOnCurve_Dim(), newDim);
	}

} //IfcPointOnCurveImpl
