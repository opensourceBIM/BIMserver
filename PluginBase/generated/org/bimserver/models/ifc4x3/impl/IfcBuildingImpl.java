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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcBuilding;
import org.bimserver.models.ifc4x3.IfcPostalAddress;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Building</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBuildingImpl#getElevationOfRefHeight <em>Elevation Of Ref Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBuildingImpl#getElevationOfRefHeightAsString <em>Elevation Of Ref Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBuildingImpl#getElevationOfTerrain <em>Elevation Of Terrain</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBuildingImpl#getElevationOfTerrainAsString <em>Elevation Of Terrain As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBuildingImpl#getBuildingAddress <em>Building Address</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBuildingImpl extends IfcFacilityImpl implements IfcBuilding {
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
		return Ifc4x3Package.eINSTANCE.getIfcBuilding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getElevationOfRefHeight() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfRefHeight(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElevationOfRefHeight(double newElevationOfRefHeight) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfRefHeight(), newElevationOfRefHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetElevationOfRefHeight() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfRefHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetElevationOfRefHeight() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfRefHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getElevationOfRefHeightAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfRefHeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElevationOfRefHeightAsString(String newElevationOfRefHeightAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfRefHeightAsString(), newElevationOfRefHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetElevationOfRefHeightAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfRefHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetElevationOfRefHeightAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfRefHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getElevationOfTerrain() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfTerrain(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElevationOfTerrain(double newElevationOfTerrain) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfTerrain(), newElevationOfTerrain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetElevationOfTerrain() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfTerrain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetElevationOfTerrain() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfTerrain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getElevationOfTerrainAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfTerrainAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElevationOfTerrainAsString(String newElevationOfTerrainAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfTerrainAsString(), newElevationOfTerrainAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetElevationOfTerrainAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfTerrainAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetElevationOfTerrainAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBuilding_ElevationOfTerrainAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPostalAddress getBuildingAddress() {
		return (IfcPostalAddress) eGet(Ifc4x3Package.eINSTANCE.getIfcBuilding_BuildingAddress(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuildingAddress(IfcPostalAddress newBuildingAddress) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBuilding_BuildingAddress(), newBuildingAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBuildingAddress() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBuilding_BuildingAddress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBuildingAddress() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBuilding_BuildingAddress());
	}

} //IfcBuildingImpl
