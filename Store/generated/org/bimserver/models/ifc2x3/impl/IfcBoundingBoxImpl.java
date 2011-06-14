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
import org.bimserver.models.ifc2x3.IfcBoundingBox;
import org.bimserver.models.ifc2x3.IfcCartesianPoint;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Bounding Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundingBoxImpl#getCorner <em>Corner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundingBoxImpl#getXDim <em>XDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundingBoxImpl#getXDimAsString <em>XDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundingBoxImpl#getYDim <em>YDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundingBoxImpl#getYDimAsString <em>YDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundingBoxImpl#getZDim <em>ZDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundingBoxImpl#getZDimAsString <em>ZDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundingBoxImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBoundingBoxImpl extends IfcGeometricRepresentationItemImpl implements IfcBoundingBox
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBoundingBoxImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcBoundingBox();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint getCorner()
	{
		return (IfcCartesianPoint)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_Corner(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorner(IfcCartesianPoint newCorner)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_Corner(), newCorner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getXDim()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_XDim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXDim(float newXDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_XDim(), newXDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXDimAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_XDimAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXDimAsString(String newXDimAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_XDimAsString(), newXDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getYDim()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_YDim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYDim(float newYDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_YDim(), newYDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYDimAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_YDimAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYDimAsString(String newYDimAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_YDimAsString(), newYDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getZDim()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_ZDim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZDim(float newZDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_ZDim(), newZDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZDimAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_ZDimAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZDimAsString(String newZDimAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_ZDimAsString(), newZDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundingBox_Dim(), newDim);
	}

} //IfcBoundingBoxImpl
