/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Associates Applied Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssociatesAppliedValue#getRelatingAppliedValue <em>Relating Applied Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssociatesAppliedValue()
 * @model
 * @generated
 */
public interface IfcRelAssociatesAppliedValue extends IfcRelAssociates {
	/**
	 * Returns the value of the '<em><b>Relating Applied Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Applied Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Applied Value</em>' reference.
	 * @see #setRelatingAppliedValue(IfcAppliedValue)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssociatesAppliedValue_RelatingAppliedValue()
	 * @model
	 * @generated
	 */
	IfcAppliedValue getRelatingAppliedValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssociatesAppliedValue#getRelatingAppliedValue <em>Relating Applied Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Applied Value</em>' reference.
	 * @see #getRelatingAppliedValue()
	 * @generated
	 */
	void setRelatingAppliedValue(IfcAppliedValue value);

} // IfcRelAssociatesAppliedValue
