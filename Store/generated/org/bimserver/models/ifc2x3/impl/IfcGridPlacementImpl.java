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
import org.bimserver.models.ifc2x3.IfcGridPlacement;
import org.bimserver.models.ifc2x3.IfcVirtualGridIntersection;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Grid Placement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridPlacementImpl#getPlacementLocation <em>Placement Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridPlacementImpl#getPlacementRefDirection <em>Placement Ref Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcGridPlacementImpl extends IfcObjectPlacementImpl implements IfcGridPlacement
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGridPlacementImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcGridPlacement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVirtualGridIntersection getPlacementLocation()
	{
		return (IfcVirtualGridIntersection)eGet(Ifc2x3Package.eINSTANCE.getIfcGridPlacement_PlacementLocation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlacementLocation(IfcVirtualGridIntersection newPlacementLocation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGridPlacement_PlacementLocation(), newPlacementLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVirtualGridIntersection getPlacementRefDirection()
	{
		return (IfcVirtualGridIntersection)eGet(Ifc2x3Package.eINSTANCE.getIfcGridPlacement_PlacementRefDirection(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlacementRefDirection(IfcVirtualGridIntersection newPlacementRefDirection)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGridPlacement_PlacementRefDirection(), newPlacementRefDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlacementRefDirection()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGridPlacement_PlacementRefDirection());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlacementRefDirection()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGridPlacement_PlacementRefDirection());
	}

} //IfcGridPlacementImpl
