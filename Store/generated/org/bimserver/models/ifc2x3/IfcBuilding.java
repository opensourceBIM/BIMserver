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
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Building</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfRefHeight <em>Elevation Of Ref Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfRefHeightAsString <em>Elevation Of Ref Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfTerrain <em>Elevation Of Terrain</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfTerrainAsString <em>Elevation Of Terrain As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBuilding#getBuildingAddress <em>Building Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBuilding()
 * @model
 * @generated
 */
public interface IfcBuilding extends IfcSpatialStructureElement
{
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
	 * @see #setElevationOfRefHeight(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBuilding_ElevationOfRefHeight()
	 * @model unsettable="true"
	 * @generated
	 */
	float getElevationOfRefHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfRefHeight <em>Elevation Of Ref Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation Of Ref Height</em>' attribute.
	 * @see #isSetElevationOfRefHeight()
	 * @see #unsetElevationOfRefHeight()
	 * @see #getElevationOfRefHeight()
	 * @generated
	 */
	void setElevationOfRefHeight(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfRefHeight <em>Elevation Of Ref Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationOfRefHeight()
	 * @see #getElevationOfRefHeight()
	 * @see #setElevationOfRefHeight(float)
	 * @generated
	 */
	void unsetElevationOfRefHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfRefHeight <em>Elevation Of Ref Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elevation Of Ref Height</em>' attribute is set.
	 * @see #unsetElevationOfRefHeight()
	 * @see #getElevationOfRefHeight()
	 * @see #setElevationOfRefHeight(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBuilding_ElevationOfRefHeightAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getElevationOfRefHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfRefHeightAsString <em>Elevation Of Ref Height As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfRefHeightAsString <em>Elevation Of Ref Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationOfRefHeightAsString()
	 * @see #getElevationOfRefHeightAsString()
	 * @see #setElevationOfRefHeightAsString(String)
	 * @generated
	 */
	void unsetElevationOfRefHeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfRefHeightAsString <em>Elevation Of Ref Height As String</em>}' attribute is set.
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
	 * @see #setElevationOfTerrain(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBuilding_ElevationOfTerrain()
	 * @model unsettable="true"
	 * @generated
	 */
	float getElevationOfTerrain();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfTerrain <em>Elevation Of Terrain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation Of Terrain</em>' attribute.
	 * @see #isSetElevationOfTerrain()
	 * @see #unsetElevationOfTerrain()
	 * @see #getElevationOfTerrain()
	 * @generated
	 */
	void setElevationOfTerrain(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfTerrain <em>Elevation Of Terrain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationOfTerrain()
	 * @see #getElevationOfTerrain()
	 * @see #setElevationOfTerrain(float)
	 * @generated
	 */
	void unsetElevationOfTerrain();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfTerrain <em>Elevation Of Terrain</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elevation Of Terrain</em>' attribute is set.
	 * @see #unsetElevationOfTerrain()
	 * @see #getElevationOfTerrain()
	 * @see #setElevationOfTerrain(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBuilding_ElevationOfTerrainAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getElevationOfTerrainAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfTerrainAsString <em>Elevation Of Terrain As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfTerrainAsString <em>Elevation Of Terrain As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationOfTerrainAsString()
	 * @see #getElevationOfTerrainAsString()
	 * @see #setElevationOfTerrainAsString(String)
	 * @generated
	 */
	void unsetElevationOfTerrainAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getElevationOfTerrainAsString <em>Elevation Of Terrain As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBuilding_BuildingAddress()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPostalAddress getBuildingAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getBuildingAddress <em>Building Address</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getBuildingAddress <em>Building Address</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBuildingAddress()
	 * @see #getBuildingAddress()
	 * @see #setBuildingAddress(IfcPostalAddress)
	 * @generated
	 */
	void unsetBuildingAddress();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBuilding#getBuildingAddress <em>Building Address</em>}' reference is set.
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
