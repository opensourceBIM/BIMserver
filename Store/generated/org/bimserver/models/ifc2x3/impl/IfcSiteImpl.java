/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcPostalAddress;
import org.bimserver.models.ifc2x3.IfcSite;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Site</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSiteImpl#getRefLatitude <em>Ref Latitude</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSiteImpl#getRefLongitude <em>Ref Longitude</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSiteImpl#getRefElevation <em>Ref Elevation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSiteImpl#getRefElevationAsString <em>Ref Elevation As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSiteImpl#getLandTitleNumber <em>Land Title Number</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSiteImpl#getSiteAddress <em>Site Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSiteImpl extends IfcSpatialStructureElementImpl implements IfcSite {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSiteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSite();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Integer> getRefLatitude() {
		return (EList<Integer>)eGet(Ifc2x3Package.eINSTANCE.getIfcSite_RefLatitude(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRefLatitude() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSite_RefLatitude());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefLatitude() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSite_RefLatitude());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Integer> getRefLongitude() {
		return (EList<Integer>)eGet(Ifc2x3Package.eINSTANCE.getIfcSite_RefLongitude(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRefLongitude() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSite_RefLongitude());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefLongitude() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSite_RefLongitude());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRefElevation() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSite_RefElevation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefElevation(float newRefElevation) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSite_RefElevation(), newRefElevation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRefElevation() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSite_RefElevation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefElevation() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSite_RefElevation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRefElevationAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSite_RefElevationAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefElevationAsString(String newRefElevationAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSite_RefElevationAsString(), newRefElevationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRefElevationAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSite_RefElevationAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefElevationAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSite_RefElevationAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLandTitleNumber() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSite_LandTitleNumber(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLandTitleNumber(String newLandTitleNumber) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSite_LandTitleNumber(), newLandTitleNumber);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLandTitleNumber() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSite_LandTitleNumber());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLandTitleNumber() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSite_LandTitleNumber());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPostalAddress getSiteAddress() {
		return (IfcPostalAddress)eGet(Ifc2x3Package.eINSTANCE.getIfcSite_SiteAddress(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSiteAddress(IfcPostalAddress newSiteAddress) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSite_SiteAddress(), newSiteAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSiteAddress() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSite_SiteAddress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSiteAddress() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSite_SiteAddress());
	}

} //IfcSiteImpl
