/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Quantity Weight</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValue <em>Weight Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValueAsString <em>Weight Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityWeight()
 * @model
 * @generated
 */
public interface IfcQuantityWeight extends IfcPhysicalSimpleQuantity {
	/**
	 * Returns the value of the '<em><b>Weight Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight Value</em>' attribute.
	 * @see #setWeightValue(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityWeight_WeightValue()
	 * @model
	 * @generated
	 */
	float getWeightValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValue <em>Weight Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight Value</em>' attribute.
	 * @see #getWeightValue()
	 * @generated
	 */
	void setWeightValue(float value);

	/**
	 * Returns the value of the '<em><b>Weight Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight Value As String</em>' attribute.
	 * @see #setWeightValueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityWeight_WeightValueAsString()
	 * @model
	 * @generated
	 */
	String getWeightValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityWeight#getWeightValueAsString <em>Weight Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight Value As String</em>' attribute.
	 * @see #getWeightValueAsString()
	 * @generated
	 */
	void setWeightValueAsString(String value);

} // IfcQuantityWeight
