/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Quantity Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityTime#getTimeValue <em>Time Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityTime#getTimeValueAsString <em>Time Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityTime()
 * @model
 * @generated
 */
public interface IfcQuantityTime extends IfcPhysicalSimpleQuantity {
	/**
	 * Returns the value of the '<em><b>Time Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Value</em>' attribute.
	 * @see #setTimeValue(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityTime_TimeValue()
	 * @model
	 * @generated
	 */
	float getTimeValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityTime#getTimeValue <em>Time Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Value</em>' attribute.
	 * @see #getTimeValue()
	 * @generated
	 */
	void setTimeValue(float value);

	/**
	 * Returns the value of the '<em><b>Time Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Value As String</em>' attribute.
	 * @see #setTimeValueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityTime_TimeValueAsString()
	 * @model
	 * @generated
	 */
	String getTimeValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityTime#getTimeValueAsString <em>Time Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Value As String</em>' attribute.
	 * @see #getTimeValueAsString()
	 * @generated
	 */
	void setTimeValueAsString(String value);

} // IfcQuantityTime
