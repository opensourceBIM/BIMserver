/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geo Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.GeoTagImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.GeoTagImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.GeoTagImpl#getX <em>X</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.GeoTagImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.GeoTagImpl#getZ <em>Z</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.GeoTagImpl#getEpsg <em>Epsg</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.GeoTagImpl#getDirectionAngle <em>Direction Angle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeoTagImpl extends IdEObjectImpl implements GeoTag {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeoTagImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.GEO_TAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled() {
		return (Boolean)eGet(StorePackage.Literals.GEO_TAG__ENABLED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled) {
		eSet(StorePackage.Literals.GEO_TAG__ENABLED, newEnabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Project> getProjects() {
		return (EList<Project>)eGet(StorePackage.Literals.GEO_TAG__PROJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getX() {
		return (Float)eGet(StorePackage.Literals.GEO_TAG__X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(float newX) {
		eSet(StorePackage.Literals.GEO_TAG__X, newX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getY() {
		return (Float)eGet(StorePackage.Literals.GEO_TAG__Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(float newY) {
		eSet(StorePackage.Literals.GEO_TAG__Y, newY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getZ() {
		return (Float)eGet(StorePackage.Literals.GEO_TAG__Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZ(float newZ) {
		eSet(StorePackage.Literals.GEO_TAG__Z, newZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEpsg() {
		return (Integer)eGet(StorePackage.Literals.GEO_TAG__EPSG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEpsg(int newEpsg) {
		eSet(StorePackage.Literals.GEO_TAG__EPSG, newEpsg);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDirectionAngle() {
		return (Float)eGet(StorePackage.Literals.GEO_TAG__DIRECTION_ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectionAngle(float newDirectionAngle) {
		eSet(StorePackage.Literals.GEO_TAG__DIRECTION_ANGLE, newDirectionAngle);
	}

} //GeoTagImpl
