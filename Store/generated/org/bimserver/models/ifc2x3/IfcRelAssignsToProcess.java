/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Assigns To Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssignsToProcess#getRelatingProcess <em>Relating Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssignsToProcess#getQuantityInProcess <em>Quantity In Process</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssignsToProcess()
 * @model
 * @generated
 */
public interface IfcRelAssignsToProcess extends IfcRelAssigns {
	/**
	 * Returns the value of the '<em><b>Relating Process</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcProcess#getOperatesOn <em>Operates On</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Process</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Process</em>' reference.
	 * @see #setRelatingProcess(IfcProcess)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssignsToProcess_RelatingProcess()
	 * @see org.bimserver.models.ifc2x3.IfcProcess#getOperatesOn
	 * @model opposite="OperatesOn"
	 * @generated
	 */
	IfcProcess getRelatingProcess();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssignsToProcess#getRelatingProcess <em>Relating Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Process</em>' reference.
	 * @see #getRelatingProcess()
	 * @generated
	 */
	void setRelatingProcess(IfcProcess value);

	/**
	 * Returns the value of the '<em><b>Quantity In Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantity In Process</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantity In Process</em>' reference.
	 * @see #isSetQuantityInProcess()
	 * @see #unsetQuantityInProcess()
	 * @see #setQuantityInProcess(IfcMeasureWithUnit)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssignsToProcess_QuantityInProcess()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcMeasureWithUnit getQuantityInProcess();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssignsToProcess#getQuantityInProcess <em>Quantity In Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity In Process</em>' reference.
	 * @see #isSetQuantityInProcess()
	 * @see #unsetQuantityInProcess()
	 * @see #getQuantityInProcess()
	 * @generated
	 */
	void setQuantityInProcess(IfcMeasureWithUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssignsToProcess#getQuantityInProcess <em>Quantity In Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuantityInProcess()
	 * @see #getQuantityInProcess()
	 * @see #setQuantityInProcess(IfcMeasureWithUnit)
	 * @generated
	 */
	void unsetQuantityInProcess();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssignsToProcess#getQuantityInProcess <em>Quantity In Process</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quantity In Process</em>' reference is set.
	 * @see #unsetQuantityInProcess()
	 * @see #getQuantityInProcess()
	 * @see #setQuantityInProcess(IfcMeasureWithUnit)
	 * @generated
	 */
	boolean isSetQuantityInProcess();

} // IfcRelAssignsToProcess
