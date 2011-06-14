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
import org.bimserver.models.ifc2x3.IfcRightCircularCylinder;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Right Circular Cylinder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRightCircularCylinderImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRightCircularCylinderImpl#getHeightAsString <em>Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRightCircularCylinderImpl#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRightCircularCylinderImpl#getRadiusAsString <em>Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRightCircularCylinderImpl extends IfcCsgPrimitive3DImpl implements IfcRightCircularCylinder
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRightCircularCylinderImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRightCircularCylinder();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHeight()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRightCircularCylinder_Height(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(float newHeight)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRightCircularCylinder_Height(), newHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeightAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRightCircularCylinder_HeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeightAsString(String newHeightAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRightCircularCylinder_HeightAsString(), newHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRightCircularCylinder_Radius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadius(float newRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRightCircularCylinder_Radius(), newRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRightCircularCylinder_RadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadiusAsString(String newRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRightCircularCylinder_RadiusAsString(), newRadiusAsString);
	}

} //IfcRightCircularCylinderImpl
