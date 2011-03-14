/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Boundary Node Condition Warping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeConditionWarping()
 * @model
 * @generated
 */
public interface IfcBoundaryNodeConditionWarping extends IfcBoundaryNodeCondition {
	/**
	 * Returns the value of the '<em><b>Warping Stiffness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warping Stiffness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warping Stiffness</em>' attribute.
	 * @see #isSetWarpingStiffness()
	 * @see #unsetWarpingStiffness()
	 * @see #setWarpingStiffness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeConditionWarping_WarpingStiffness()
	 * @model unsettable="true"
	 * @generated
	 */
	float getWarpingStiffness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warping Stiffness</em>' attribute.
	 * @see #isSetWarpingStiffness()
	 * @see #unsetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @generated
	 */
	void setWarpingStiffness(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @see #setWarpingStiffness(float)
	 * @generated
	 */
	void unsetWarpingStiffness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Warping Stiffness</em>' attribute is set.
	 * @see #unsetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @see #setWarpingStiffness(float)
	 * @generated
	 */
	boolean isSetWarpingStiffness();

	/**
	 * Returns the value of the '<em><b>Warping Stiffness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warping Stiffness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warping Stiffness As String</em>' attribute.
	 * @see #isSetWarpingStiffnessAsString()
	 * @see #unsetWarpingStiffnessAsString()
	 * @see #setWarpingStiffnessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeConditionWarping_WarpingStiffnessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWarpingStiffnessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warping Stiffness As String</em>' attribute.
	 * @see #isSetWarpingStiffnessAsString()
	 * @see #unsetWarpingStiffnessAsString()
	 * @see #getWarpingStiffnessAsString()
	 * @generated
	 */
	void setWarpingStiffnessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWarpingStiffnessAsString()
	 * @see #getWarpingStiffnessAsString()
	 * @see #setWarpingStiffnessAsString(String)
	 * @generated
	 */
	void unsetWarpingStiffnessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Warping Stiffness As String</em>' attribute is set.
	 * @see #unsetWarpingStiffnessAsString()
	 * @see #getWarpingStiffnessAsString()
	 * @see #setWarpingStiffnessAsString(String)
	 * @generated
	 */
	boolean isSetWarpingStiffnessAsString();

} // IfcBoundaryNodeConditionWarping
