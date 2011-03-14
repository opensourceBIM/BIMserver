/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Structural Planar Action Varying</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralPlanarActionVarying#getVaryingAppliedLoadLocation <em>Varying Applied Load Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralPlanarActionVarying#getSubsequentAppliedLoads <em>Subsequent Applied Loads</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralPlanarActionVarying()
 * @model
 * @generated
 */
public interface IfcStructuralPlanarActionVarying extends IfcStructuralPlanarAction {
	/**
	 * Returns the value of the '<em><b>Varying Applied Load Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Varying Applied Load Location</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Varying Applied Load Location</em>' reference.
	 * @see #setVaryingAppliedLoadLocation(IfcShapeAspect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralPlanarActionVarying_VaryingAppliedLoadLocation()
	 * @model
	 * @generated
	 */
	IfcShapeAspect getVaryingAppliedLoadLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralPlanarActionVarying#getVaryingAppliedLoadLocation <em>Varying Applied Load Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Varying Applied Load Location</em>' reference.
	 * @see #getVaryingAppliedLoadLocation()
	 * @generated
	 */
	void setVaryingAppliedLoadLocation(IfcShapeAspect value);

	/**
	 * Returns the value of the '<em><b>Subsequent Applied Loads</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcStructuralLoad}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsequent Applied Loads</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsequent Applied Loads</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralPlanarActionVarying_SubsequentAppliedLoads()
	 * @model
	 * @generated
	 */
	EList<IfcStructuralLoad> getSubsequentAppliedLoads();

} // IfcStructuralPlanarActionVarying
