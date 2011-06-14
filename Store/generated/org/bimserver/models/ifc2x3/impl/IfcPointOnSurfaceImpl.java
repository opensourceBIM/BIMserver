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
import org.bimserver.models.ifc2x3.IfcPointOnSurface;
import org.bimserver.models.ifc2x3.IfcSurface;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Point On Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPointOnSurfaceImpl#getBasisSurface <em>Basis Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPointOnSurfaceImpl#getPointParameterU <em>Point Parameter U</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPointOnSurfaceImpl#getPointParameterUAsString <em>Point Parameter UAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPointOnSurfaceImpl#getPointParameterV <em>Point Parameter V</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPointOnSurfaceImpl#getPointParameterVAsString <em>Point Parameter VAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPointOnSurfaceImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPointOnSurfaceImpl extends IfcPointImpl implements IfcPointOnSurface
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPointOnSurfaceImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcPointOnSurface();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurface getBasisSurface()
	{
		return (IfcSurface)eGet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_BasisSurface(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisSurface(IfcSurface newBasisSurface)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_BasisSurface(), newBasisSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPointParameterU()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_PointParameterU(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointParameterU(float newPointParameterU)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_PointParameterU(), newPointParameterU);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPointParameterUAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_PointParameterUAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointParameterUAsString(String newPointParameterUAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_PointParameterUAsString(), newPointParameterUAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPointParameterV()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_PointParameterV(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointParameterV(float newPointParameterV)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_PointParameterV(), newPointParameterV);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPointParameterVAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_PointParameterVAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointParameterVAsString(String newPointParameterVAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_PointParameterVAsString(), newPointParameterVAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPointOnSurface_Dim(), newDim);
	}

} //IfcPointOnSurfaceImpl
