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
import org.bimserver.models.ifc2x3.IfcBuildingStorey;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Building Storey</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBuildingStoreyImpl#getElevation <em>Elevation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBuildingStoreyImpl#getElevationAsString <em>Elevation As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBuildingStoreyImpl extends IfcSpatialStructureElementImpl implements IfcBuildingStorey
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBuildingStoreyImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcBuildingStorey();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getElevation()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_Elevation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevation(float newElevation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_Elevation(), newElevation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevation()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_Elevation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevation()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_Elevation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElevationAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_ElevationAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevationAsString(String newElevationAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_ElevationAsString(), newElevationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevationAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_ElevationAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevationAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_ElevationAsString());
	}

} //IfcBuildingStoreyImpl
