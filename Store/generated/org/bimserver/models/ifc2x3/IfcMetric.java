/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMetric#getBenchmark <em>Benchmark</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMetric#getValueSource <em>Value Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMetric#getDataValue <em>Data Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMetric()
 * @model
 * @generated
 */
public interface IfcMetric extends IfcConstraint {
	/**
	 * Returns the value of the '<em><b>Benchmark</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcBenchmarkEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Benchmark</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Benchmark</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcBenchmarkEnum
	 * @see #setBenchmark(IfcBenchmarkEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMetric_Benchmark()
	 * @model
	 * @generated
	 */
	IfcBenchmarkEnum getBenchmark();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMetric#getBenchmark <em>Benchmark</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Benchmark</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcBenchmarkEnum
	 * @see #getBenchmark()
	 * @generated
	 */
	void setBenchmark(IfcBenchmarkEnum value);

	/**
	 * Returns the value of the '<em><b>Value Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Source</em>' attribute.
	 * @see #isSetValueSource()
	 * @see #unsetValueSource()
	 * @see #setValueSource(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMetric_ValueSource()
	 * @model unsettable="true"
	 * @generated
	 */
	String getValueSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMetric#getValueSource <em>Value Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Source</em>' attribute.
	 * @see #isSetValueSource()
	 * @see #unsetValueSource()
	 * @see #getValueSource()
	 * @generated
	 */
	void setValueSource(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcMetric#getValueSource <em>Value Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValueSource()
	 * @see #getValueSource()
	 * @see #setValueSource(String)
	 * @generated
	 */
	void unsetValueSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcMetric#getValueSource <em>Value Source</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Value Source</em>' attribute is set.
	 * @see #unsetValueSource()
	 * @see #getValueSource()
	 * @see #setValueSource(String)
	 * @generated
	 */
	boolean isSetValueSource();

	/**
	 * Returns the value of the '<em><b>Data Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Value</em>' reference.
	 * @see #setDataValue(IfcMetricValueSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMetric_DataValue()
	 * @model
	 * @generated
	 */
	IfcMetricValueSelect getDataValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMetric#getDataValue <em>Data Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Value</em>' reference.
	 * @see #getDataValue()
	 * @generated
	 */
	void setDataValue(IfcMetricValueSelect value);

} // IfcMetric
