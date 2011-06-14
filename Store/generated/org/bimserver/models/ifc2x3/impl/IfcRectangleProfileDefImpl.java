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
import org.bimserver.models.ifc2x3.IfcRectangleProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rectangle Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangleProfileDefImpl#getXDim <em>XDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangleProfileDefImpl#getXDimAsString <em>XDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangleProfileDefImpl#getYDim <em>YDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangleProfileDefImpl#getYDimAsString <em>YDim As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRectangleProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcRectangleProfileDef
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRectangleProfileDefImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRectangleProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getXDim()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangleProfileDef_XDim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXDim(float newXDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangleProfileDef_XDim(), newXDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXDimAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangleProfileDef_XDimAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXDimAsString(String newXDimAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangleProfileDef_XDimAsString(), newXDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getYDim()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangleProfileDef_YDim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYDim(float newYDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangleProfileDef_YDim(), newYDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYDimAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangleProfileDef_YDimAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYDimAsString(String newYDimAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangleProfileDef_YDimAsString(), newYDimAsString);
	}

} //IfcRectangleProfileDefImpl
