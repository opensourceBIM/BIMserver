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
import org.bimserver.models.ifc2x3.IfcBuilding;
import org.bimserver.models.ifc2x3.IfcPostalAddress;

import org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Building</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBuildingImpl#getElevationOfRefHeight <em>Elevation Of Ref Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBuildingImpl#getElevationOfRefHeightAsString <em>Elevation Of Ref Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBuildingImpl#getElevationOfTerrain <em>Elevation Of Terrain</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBuildingImpl#getElevationOfTerrainAsString <em>Elevation Of Terrain As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBuildingImpl#getBuildingAddress <em>Building Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBuildingImpl extends IfcSpatialStructureElementImpl implements IfcBuilding
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
	protected IfcBuildingImpl()
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
		return Ifc2x3Package.Literals.IFC_BUILDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getElevationOfRefHeight()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevationOfRefHeight(float newElevationOfRefHeight)
	{
		eSet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT, newElevationOfRefHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevationOfRefHeight()
	{
		eUnset(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevationOfRefHeight()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElevationOfRefHeightAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevationOfRefHeightAsString(String newElevationOfRefHeightAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT_AS_STRING, newElevationOfRefHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevationOfRefHeightAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevationOfRefHeightAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getElevationOfTerrain()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevationOfTerrain(float newElevationOfTerrain)
	{
		eSet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN, newElevationOfTerrain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevationOfTerrain()
	{
		eUnset(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevationOfTerrain()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElevationOfTerrainAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevationOfTerrainAsString(String newElevationOfTerrainAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN_AS_STRING, newElevationOfTerrainAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevationOfTerrainAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevationOfTerrainAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPostalAddress getBuildingAddress()
	{
		return (IfcPostalAddress)eGet(Ifc2x3Package.Literals.IFC_BUILDING__BUILDING_ADDRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuildingAddress(IfcPostalAddress newBuildingAddress)
	{
		eSet(Ifc2x3Package.Literals.IFC_BUILDING__BUILDING_ADDRESS, newBuildingAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBuildingAddress()
	{
		eUnset(Ifc2x3Package.Literals.IFC_BUILDING__BUILDING_ADDRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBuildingAddress()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_BUILDING__BUILDING_ADDRESS);
	}

} //IfcBuildingImpl
