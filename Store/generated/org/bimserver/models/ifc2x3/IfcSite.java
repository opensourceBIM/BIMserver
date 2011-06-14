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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Site</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSite#getRefLatitude <em>Ref Latitude</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSite#getRefLongitude <em>Ref Longitude</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSite#getRefElevation <em>Ref Elevation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSite#getRefElevationAsString <em>Ref Elevation As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSite#getLandTitleNumber <em>Land Title Number</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSite#getSiteAddress <em>Site Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSite()
 * @model
 * @generated
 */
public interface IfcSite extends IfcSpatialStructureElement
{
	/**
	 * Returns the value of the '<em><b>Ref Latitude</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Latitude</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Latitude</em>' attribute list.
	 * @see #isSetRefLatitude()
	 * @see #unsetRefLatitude()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSite_RefLatitude()
	 * @model unique="false" unsettable="true" upper="3"
	 * @generated
	 */
	EList<Integer> getRefLatitude();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getRefLatitude <em>Ref Latitude</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRefLatitude()
	 * @see #getRefLatitude()
	 * @generated
	 */
	void unsetRefLatitude();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getRefLatitude <em>Ref Latitude</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ref Latitude</em>' attribute list is set.
	 * @see #unsetRefLatitude()
	 * @see #getRefLatitude()
	 * @generated
	 */
	boolean isSetRefLatitude();

	/**
	 * Returns the value of the '<em><b>Ref Longitude</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Longitude</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Longitude</em>' attribute list.
	 * @see #isSetRefLongitude()
	 * @see #unsetRefLongitude()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSite_RefLongitude()
	 * @model unique="false" unsettable="true" upper="3"
	 * @generated
	 */
	EList<Integer> getRefLongitude();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getRefLongitude <em>Ref Longitude</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRefLongitude()
	 * @see #getRefLongitude()
	 * @generated
	 */
	void unsetRefLongitude();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getRefLongitude <em>Ref Longitude</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ref Longitude</em>' attribute list is set.
	 * @see #unsetRefLongitude()
	 * @see #getRefLongitude()
	 * @generated
	 */
	boolean isSetRefLongitude();

	/**
	 * Returns the value of the '<em><b>Ref Elevation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Elevation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Elevation</em>' attribute.
	 * @see #isSetRefElevation()
	 * @see #unsetRefElevation()
	 * @see #setRefElevation(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSite_RefElevation()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRefElevation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getRefElevation <em>Ref Elevation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Elevation</em>' attribute.
	 * @see #isSetRefElevation()
	 * @see #unsetRefElevation()
	 * @see #getRefElevation()
	 * @generated
	 */
	void setRefElevation(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getRefElevation <em>Ref Elevation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRefElevation()
	 * @see #getRefElevation()
	 * @see #setRefElevation(float)
	 * @generated
	 */
	void unsetRefElevation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getRefElevation <em>Ref Elevation</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ref Elevation</em>' attribute is set.
	 * @see #unsetRefElevation()
	 * @see #getRefElevation()
	 * @see #setRefElevation(float)
	 * @generated
	 */
	boolean isSetRefElevation();

	/**
	 * Returns the value of the '<em><b>Ref Elevation As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Elevation As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Elevation As String</em>' attribute.
	 * @see #isSetRefElevationAsString()
	 * @see #unsetRefElevationAsString()
	 * @see #setRefElevationAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSite_RefElevationAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRefElevationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getRefElevationAsString <em>Ref Elevation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Elevation As String</em>' attribute.
	 * @see #isSetRefElevationAsString()
	 * @see #unsetRefElevationAsString()
	 * @see #getRefElevationAsString()
	 * @generated
	 */
	void setRefElevationAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getRefElevationAsString <em>Ref Elevation As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRefElevationAsString()
	 * @see #getRefElevationAsString()
	 * @see #setRefElevationAsString(String)
	 * @generated
	 */
	void unsetRefElevationAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getRefElevationAsString <em>Ref Elevation As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ref Elevation As String</em>' attribute is set.
	 * @see #unsetRefElevationAsString()
	 * @see #getRefElevationAsString()
	 * @see #setRefElevationAsString(String)
	 * @generated
	 */
	boolean isSetRefElevationAsString();

	/**
	 * Returns the value of the '<em><b>Land Title Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Land Title Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Land Title Number</em>' attribute.
	 * @see #isSetLandTitleNumber()
	 * @see #unsetLandTitleNumber()
	 * @see #setLandTitleNumber(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSite_LandTitleNumber()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLandTitleNumber();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getLandTitleNumber <em>Land Title Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Land Title Number</em>' attribute.
	 * @see #isSetLandTitleNumber()
	 * @see #unsetLandTitleNumber()
	 * @see #getLandTitleNumber()
	 * @generated
	 */
	void setLandTitleNumber(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getLandTitleNumber <em>Land Title Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLandTitleNumber()
	 * @see #getLandTitleNumber()
	 * @see #setLandTitleNumber(String)
	 * @generated
	 */
	void unsetLandTitleNumber();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getLandTitleNumber <em>Land Title Number</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Land Title Number</em>' attribute is set.
	 * @see #unsetLandTitleNumber()
	 * @see #getLandTitleNumber()
	 * @see #setLandTitleNumber(String)
	 * @generated
	 */
	boolean isSetLandTitleNumber();

	/**
	 * Returns the value of the '<em><b>Site Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Site Address</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Site Address</em>' reference.
	 * @see #isSetSiteAddress()
	 * @see #unsetSiteAddress()
	 * @see #setSiteAddress(IfcPostalAddress)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSite_SiteAddress()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPostalAddress getSiteAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getSiteAddress <em>Site Address</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Site Address</em>' reference.
	 * @see #isSetSiteAddress()
	 * @see #unsetSiteAddress()
	 * @see #getSiteAddress()
	 * @generated
	 */
	void setSiteAddress(IfcPostalAddress value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getSiteAddress <em>Site Address</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSiteAddress()
	 * @see #getSiteAddress()
	 * @see #setSiteAddress(IfcPostalAddress)
	 * @generated
	 */
	void unsetSiteAddress();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSite#getSiteAddress <em>Site Address</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Site Address</em>' reference is set.
	 * @see #unsetSiteAddress()
	 * @see #getSiteAddress()
	 * @see #setSiteAddress(IfcPostalAddress)
	 * @generated
	 */
	boolean isSetSiteAddress();

} // IfcSite
