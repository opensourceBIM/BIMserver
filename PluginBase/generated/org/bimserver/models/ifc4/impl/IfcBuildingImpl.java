/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc4.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcBuilding;
import org.bimserver.models.ifc4.IfcPostalAddress;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Building</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBuildingImpl#getElevationOfRefHeight <em>Elevation Of Ref Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBuildingImpl#getElevationOfRefHeightAsString <em>Elevation Of Ref Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBuildingImpl#getElevationOfTerrain <em>Elevation Of Terrain</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBuildingImpl#getElevationOfTerrainAsString <em>Elevation Of Terrain As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBuildingImpl#getBuildingAddress <em>Building Address</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBuildingImpl extends IfcSpatialStructureElementImpl implements IfcBuilding {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBuildingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_BUILDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getElevationOfRefHeight() {
		return (Double) eGet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElevationOfRefHeight(double newElevationOfRefHeight) {
		eSet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT, newElevationOfRefHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetElevationOfRefHeight() {
		eUnset(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetElevationOfRefHeight() {
		return eIsSet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getElevationOfRefHeightAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElevationOfRefHeightAsString(String newElevationOfRefHeightAsString) {
		eSet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT_AS_STRING, newElevationOfRefHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetElevationOfRefHeightAsString() {
		eUnset(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetElevationOfRefHeightAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_REF_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getElevationOfTerrain() {
		return (Double) eGet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElevationOfTerrain(double newElevationOfTerrain) {
		eSet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN, newElevationOfTerrain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetElevationOfTerrain() {
		eUnset(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetElevationOfTerrain() {
		return eIsSet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getElevationOfTerrainAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElevationOfTerrainAsString(String newElevationOfTerrainAsString) {
		eSet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN_AS_STRING, newElevationOfTerrainAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetElevationOfTerrainAsString() {
		eUnset(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetElevationOfTerrainAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_BUILDING__ELEVATION_OF_TERRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPostalAddress getBuildingAddress() {
		return (IfcPostalAddress) eGet(Ifc4Package.Literals.IFC_BUILDING__BUILDING_ADDRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuildingAddress(IfcPostalAddress newBuildingAddress) {
		eSet(Ifc4Package.Literals.IFC_BUILDING__BUILDING_ADDRESS, newBuildingAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBuildingAddress() {
		eUnset(Ifc4Package.Literals.IFC_BUILDING__BUILDING_ADDRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBuildingAddress() {
		return eIsSet(Ifc4Package.Literals.IFC_BUILDING__BUILDING_ADDRESS);
	}

} //IfcBuildingImpl
