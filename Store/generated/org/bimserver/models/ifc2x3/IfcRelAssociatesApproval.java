/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Associates Approval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssociatesApproval#getRelatingApproval <em>Relating Approval</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssociatesApproval()
 * @model
 * @generated
 */
public interface IfcRelAssociatesApproval extends IfcRelAssociates {
	/**
	 * Returns the value of the '<em><b>Relating Approval</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Approval</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Approval</em>' reference.
	 * @see #setRelatingApproval(IfcApproval)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssociatesApproval_RelatingApproval()
	 * @model
	 * @generated
	 */
	IfcApproval getRelatingApproval();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssociatesApproval#getRelatingApproval <em>Relating Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Approval</em>' reference.
	 * @see #getRelatingApproval()
	 * @generated
	 */
	void setRelatingApproval(IfcApproval value);

} // IfcRelAssociatesApproval
