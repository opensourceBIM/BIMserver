/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Structural Load Single Force Warping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForceWarping#getWarpingMoment <em>Warping Moment</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForceWarping#getWarpingMomentAsString <em>Warping Moment As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForceWarping()
 * @model
 * @generated
 */
public interface IfcStructuralLoadSingleForceWarping extends IfcStructuralLoadSingleForce {
	/**
	 * Returns the value of the '<em><b>Warping Moment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warping Moment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warping Moment</em>' attribute.
	 * @see #isSetWarpingMoment()
	 * @see #unsetWarpingMoment()
	 * @see #setWarpingMoment(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForceWarping_WarpingMoment()
	 * @model unsettable="true"
	 * @generated
	 */
	float getWarpingMoment();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForceWarping#getWarpingMoment <em>Warping Moment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warping Moment</em>' attribute.
	 * @see #isSetWarpingMoment()
	 * @see #unsetWarpingMoment()
	 * @see #getWarpingMoment()
	 * @generated
	 */
	void setWarpingMoment(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForceWarping#getWarpingMoment <em>Warping Moment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWarpingMoment()
	 * @see #getWarpingMoment()
	 * @see #setWarpingMoment(float)
	 * @generated
	 */
	void unsetWarpingMoment();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForceWarping#getWarpingMoment <em>Warping Moment</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Warping Moment</em>' attribute is set.
	 * @see #unsetWarpingMoment()
	 * @see #getWarpingMoment()
	 * @see #setWarpingMoment(float)
	 * @generated
	 */
	boolean isSetWarpingMoment();

	/**
	 * Returns the value of the '<em><b>Warping Moment As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warping Moment As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warping Moment As String</em>' attribute.
	 * @see #isSetWarpingMomentAsString()
	 * @see #unsetWarpingMomentAsString()
	 * @see #setWarpingMomentAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWarpingMomentAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForceWarping#getWarpingMomentAsString <em>Warping Moment As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warping Moment As String</em>' attribute.
	 * @see #isSetWarpingMomentAsString()
	 * @see #unsetWarpingMomentAsString()
	 * @see #getWarpingMomentAsString()
	 * @generated
	 */
	void setWarpingMomentAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForceWarping#getWarpingMomentAsString <em>Warping Moment As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWarpingMomentAsString()
	 * @see #getWarpingMomentAsString()
	 * @see #setWarpingMomentAsString(String)
	 * @generated
	 */
	void unsetWarpingMomentAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForceWarping#getWarpingMomentAsString <em>Warping Moment As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Warping Moment As String</em>' attribute is set.
	 * @see #unsetWarpingMomentAsString()
	 * @see #getWarpingMomentAsString()
	 * @see #setWarpingMomentAsString(String)
	 * @generated
	 */
	boolean isSetWarpingMomentAsString();

} // IfcStructuralLoadSingleForceWarping
