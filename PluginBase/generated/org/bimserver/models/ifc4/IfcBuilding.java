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
package org.bimserver.models.ifc4;

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

public interface IfcBuilding extends IfcSpatialStructureElement {
	/**
	 * Returns the value of the '<em><b>Elevation Of Ref Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elevation Of Ref Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elevation Of Ref Height</em>' attribute.
	 * @see #isSetElevationOfRefHeight()
	 * @see #unsetElevationOfRefHeight()
	 * @see #setElevationOfRefHeight(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBuilding_ElevationOfRefHeight()
	 * @model unsettable="true"
	 * @generated
	 */
	double getElevationOfRefHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfRefHeight <em>Elevation Of Ref Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation Of Ref Height</em>' attribute.
	 * @see #isSetElevationOfRefHeight()
	 * @see #unsetElevationOfRefHeight()
	 * @see #getElevationOfRefHeight()
	 * @generated
	 */
	void setElevationOfRefHeight(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfRefHeight <em>Elevation Of Ref Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationOfRefHeight()
	 * @see #getElevationOfRefHeight()
	 * @see #setElevationOfRefHeight(double)
	 * @generated
	 */
	void unsetElevationOfRefHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfRefHeight <em>Elevation Of Ref Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elevation Of Ref Height</em>' attribute is set.
	 * @see #unsetElevationOfRefHeight()
	 * @see #getElevationOfRefHeight()
	 * @see #setElevationOfRefHeight(double)
	 * @generated
	 */
	boolean isSetElevationOfRefHeight();

	/**
	 * Returns the value of the '<em><b>Elevation Of Ref Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elevation Of Ref Height As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elevation Of Ref Height As String</em>' attribute.
	 * @see #isSetElevationOfRefHeightAsString()
	 * @see #unsetElevationOfRefHeightAsString()
	 * @see #setElevationOfRefHeightAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBuilding_ElevationOfRefHeightAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getElevationOfRefHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfRefHeightAsString <em>Elevation Of Ref Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation Of Ref Height As String</em>' attribute.
	 * @see #isSetElevationOfRefHeightAsString()
	 * @see #unsetElevationOfRefHeightAsString()
	 * @see #getElevationOfRefHeightAsString()
	 * @generated
	 */
	void setElevationOfRefHeightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfRefHeightAsString <em>Elevation Of Ref Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationOfRefHeightAsString()
	 * @see #getElevationOfRefHeightAsString()
	 * @see #setElevationOfRefHeightAsString(String)
	 * @generated
	 */
	void unsetElevationOfRefHeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfRefHeightAsString <em>Elevation Of Ref Height As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elevation Of Ref Height As String</em>' attribute is set.
	 * @see #unsetElevationOfRefHeightAsString()
	 * @see #getElevationOfRefHeightAsString()
	 * @see #setElevationOfRefHeightAsString(String)
	 * @generated
	 */
	boolean isSetElevationOfRefHeightAsString();

	/**
	 * Returns the value of the '<em><b>Elevation Of Terrain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elevation Of Terrain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elevation Of Terrain</em>' attribute.
	 * @see #isSetElevationOfTerrain()
	 * @see #unsetElevationOfTerrain()
	 * @see #setElevationOfTerrain(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBuilding_ElevationOfTerrain()
	 * @model unsettable="true"
	 * @generated
	 */
	double getElevationOfTerrain();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfTerrain <em>Elevation Of Terrain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation Of Terrain</em>' attribute.
	 * @see #isSetElevationOfTerrain()
	 * @see #unsetElevationOfTerrain()
	 * @see #getElevationOfTerrain()
	 * @generated
	 */
	void setElevationOfTerrain(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfTerrain <em>Elevation Of Terrain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationOfTerrain()
	 * @see #getElevationOfTerrain()
	 * @see #setElevationOfTerrain(double)
	 * @generated
	 */
	void unsetElevationOfTerrain();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfTerrain <em>Elevation Of Terrain</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elevation Of Terrain</em>' attribute is set.
	 * @see #unsetElevationOfTerrain()
	 * @see #getElevationOfTerrain()
	 * @see #setElevationOfTerrain(double)
	 * @generated
	 */
	boolean isSetElevationOfTerrain();

	/**
	 * Returns the value of the '<em><b>Elevation Of Terrain As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elevation Of Terrain As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elevation Of Terrain As String</em>' attribute.
	 * @see #isSetElevationOfTerrainAsString()
	 * @see #unsetElevationOfTerrainAsString()
	 * @see #setElevationOfTerrainAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBuilding_ElevationOfTerrainAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getElevationOfTerrainAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfTerrainAsString <em>Elevation Of Terrain As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation Of Terrain As String</em>' attribute.
	 * @see #isSetElevationOfTerrainAsString()
	 * @see #unsetElevationOfTerrainAsString()
	 * @see #getElevationOfTerrainAsString()
	 * @generated
	 */
	void setElevationOfTerrainAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfTerrainAsString <em>Elevation Of Terrain As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationOfTerrainAsString()
	 * @see #getElevationOfTerrainAsString()
	 * @see #setElevationOfTerrainAsString(String)
	 * @generated
	 */
	void unsetElevationOfTerrainAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getElevationOfTerrainAsString <em>Elevation Of Terrain As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elevation Of Terrain As String</em>' attribute is set.
	 * @see #unsetElevationOfTerrainAsString()
	 * @see #getElevationOfTerrainAsString()
	 * @see #setElevationOfTerrainAsString(String)
	 * @generated
	 */
	boolean isSetElevationOfTerrainAsString();

	/**
	 * Returns the value of the '<em><b>Building Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Building Address</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Building Address</em>' reference.
	 * @see #isSetBuildingAddress()
	 * @see #unsetBuildingAddress()
	 * @see #setBuildingAddress(IfcPostalAddress)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBuilding_BuildingAddress()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPostalAddress getBuildingAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getBuildingAddress <em>Building Address</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Building Address</em>' reference.
	 * @see #isSetBuildingAddress()
	 * @see #unsetBuildingAddress()
	 * @see #getBuildingAddress()
	 * @generated
	 */
	void setBuildingAddress(IfcPostalAddress value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getBuildingAddress <em>Building Address</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBuildingAddress()
	 * @see #getBuildingAddress()
	 * @see #setBuildingAddress(IfcPostalAddress)
	 * @generated
	 */
	void unsetBuildingAddress();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBuilding#getBuildingAddress <em>Building Address</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Building Address</em>' reference is set.
	 * @see #unsetBuildingAddress()
	 * @see #getBuildingAddress()
	 * @see #setBuildingAddress(IfcPostalAddress)
	 * @generated
	 */
	boolean isSetBuildingAddress();

} // IfcBuilding
