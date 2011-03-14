/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Quantity Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityArea#getAreaValue <em>Area Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcQuantityArea#getAreaValueAsString <em>Area Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityArea()
 * @model
 * @generated
 */
public interface IfcQuantityArea extends IfcPhysicalSimpleQuantity {
	/**
	 * Returns the value of the '<em><b>Area Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area Value</em>' attribute.
	 * @see #setAreaValue(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityArea_AreaValue()
	 * @model
	 * @generated
	 */
	float getAreaValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityArea#getAreaValue <em>Area Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area Value</em>' attribute.
	 * @see #getAreaValue()
	 * @generated
	 */
	void setAreaValue(float value);

	/**
	 * Returns the value of the '<em><b>Area Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area Value As String</em>' attribute.
	 * @see #setAreaValueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcQuantityArea_AreaValueAsString()
	 * @model
	 * @generated
	 */
	String getAreaValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcQuantityArea#getAreaValueAsString <em>Area Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area Value As String</em>' attribute.
	 * @see #getAreaValueAsString()
	 * @generated
	 */
	void setAreaValueAsString(String value);

} // IfcQuantityArea
