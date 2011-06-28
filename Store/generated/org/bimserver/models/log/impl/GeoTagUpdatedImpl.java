/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.log.impl;

import org.bimserver.models.log.GeoTagUpdated;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.GeoTag;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geo Tag Updated</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.log.impl.GeoTagUpdatedImpl#getGeoTag <em>Geo Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeoTagUpdatedImpl extends LogActionImpl implements GeoTagUpdated {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeoTagUpdatedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.GEO_TAG_UPDATED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeoTag getGeoTag() {
		return (GeoTag)eGet(LogPackage.Literals.GEO_TAG_UPDATED__GEO_TAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeoTag(GeoTag newGeoTag) {
		eSet(LogPackage.Literals.GEO_TAG_UPDATED__GEO_TAG, newGeoTag);
	}

} //GeoTagUpdatedImpl
