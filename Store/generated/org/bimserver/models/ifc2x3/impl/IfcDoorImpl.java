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
import org.bimserver.models.ifc2x3.IfcDoor;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Door</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorImpl#getOverallHeight <em>Overall Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorImpl#getOverallHeightAsString <em>Overall Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorImpl#getOverallWidth <em>Overall Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorImpl#getOverallWidthAsString <em>Overall Width As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDoorImpl extends IfcBuildingElementImpl implements IfcDoor
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDoorImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcDoor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getOverallHeight()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallHeight(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallHeight(float newOverallHeight)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallHeight(), newOverallHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOverallHeight()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOverallHeight()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverallHeightAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallHeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallHeightAsString(String newOverallHeightAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallHeightAsString(), newOverallHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOverallHeightAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOverallHeightAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getOverallWidth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallWidth(float newOverallWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallWidth(), newOverallWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOverallWidth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOverallWidth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverallWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallWidthAsString(String newOverallWidthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallWidthAsString(), newOverallWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOverallWidthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOverallWidthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoor_OverallWidthAsString());
	}

} //IfcDoorImpl
