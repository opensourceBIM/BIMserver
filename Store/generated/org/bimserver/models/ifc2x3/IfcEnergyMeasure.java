/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Energy Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEnergyMeasure#getWrappedValue <em>Wrapped Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEnergyMeasure#getWrappedValueAsString <em>Wrapped Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnergyMeasure()
 * @model
 * @generated
 */
public interface IfcEnergyMeasure extends WrappedValue, IfcDerivedMeasureValue {
	/**
	 * Returns the value of the '<em><b>Wrapped Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wrapped Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wrapped Value</em>' attribute.
	 * @see #setWrappedValue(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnergyMeasure_WrappedValue()
	 * @model
	 * @generated
	 */
	float getWrappedValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnergyMeasure#getWrappedValue <em>Wrapped Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wrapped Value</em>' attribute.
	 * @see #getWrappedValue()
	 * @generated
	 */
	void setWrappedValue(float value);

	/**
	 * Returns the value of the '<em><b>Wrapped Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wrapped Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wrapped Value As String</em>' attribute.
	 * @see #setWrappedValueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnergyMeasure_WrappedValueAsString()
	 * @model
	 * @generated
	 */
	String getWrappedValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnergyMeasure#getWrappedValueAsString <em>Wrapped Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wrapped Value As String</em>' attribute.
	 * @see #getWrappedValueAsString()
	 * @generated
	 */
	void setWrappedValueAsString(String value);

} // IfcEnergyMeasure
