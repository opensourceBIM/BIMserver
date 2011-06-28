/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Geo Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.GeoTag#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.GeoTag#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.GeoTag#getX <em>X</em>}</li>
 *   <li>{@link org.bimserver.models.store.GeoTag#getY <em>Y</em>}</li>
 *   <li>{@link org.bimserver.models.store.GeoTag#getZ <em>Z</em>}</li>
 *   <li>{@link org.bimserver.models.store.GeoTag#getEpsg <em>Epsg</em>}</li>
 *   <li>{@link org.bimserver.models.store.GeoTag#getDirectionAngle <em>Direction Angle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getGeoTag()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface GeoTag extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.bimserver.models.store.StorePackage#getGeoTag_Enabled()
	 * @model
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GeoTag#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Project}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Project#getGeoTag <em>Geo Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getGeoTag_Projects()
	 * @see org.bimserver.models.store.Project#getGeoTag
	 * @model opposite="geoTag"
	 * @generated
	 */
	EList<Project> getProjects();

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(float)
	 * @see org.bimserver.models.store.StorePackage#getGeoTag_X()
	 * @model
	 * @generated
	 */
	float getX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GeoTag#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(float value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(float)
	 * @see org.bimserver.models.store.StorePackage#getGeoTag_Y()
	 * @model
	 * @generated
	 */
	float getY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GeoTag#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(float value);

	/**
	 * Returns the value of the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Z</em>' attribute.
	 * @see #setZ(float)
	 * @see org.bimserver.models.store.StorePackage#getGeoTag_Z()
	 * @model
	 * @generated
	 */
	float getZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GeoTag#getZ <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Z</em>' attribute.
	 * @see #getZ()
	 * @generated
	 */
	void setZ(float value);

	/**
	 * Returns the value of the '<em><b>Epsg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Epsg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Epsg</em>' attribute.
	 * @see #setEpsg(int)
	 * @see org.bimserver.models.store.StorePackage#getGeoTag_Epsg()
	 * @model
	 * @generated
	 */
	int getEpsg();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GeoTag#getEpsg <em>Epsg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Epsg</em>' attribute.
	 * @see #getEpsg()
	 * @generated
	 */
	void setEpsg(int value);

	/**
	 * Returns the value of the '<em><b>Direction Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction Angle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction Angle</em>' attribute.
	 * @see #setDirectionAngle(float)
	 * @see org.bimserver.models.store.StorePackage#getGeoTag_DirectionAngle()
	 * @model
	 * @generated
	 */
	float getDirectionAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GeoTag#getDirectionAngle <em>Direction Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction Angle</em>' attribute.
	 * @see #getDirectionAngle()
	 * @generated
	 */
	void setDirectionAngle(float value);

} // GeoTag
