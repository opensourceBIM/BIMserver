/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Conversion Based Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConversionBasedUnit#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConversionBasedUnit#getConversionFactor <em>Conversion Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConversionBasedUnit()
 * @model
 * @generated
 */
public interface IfcConversionBasedUnit extends IfcNamedUnit {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConversionBasedUnit_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConversionBasedUnit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Conversion Factor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conversion Factor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conversion Factor</em>' reference.
	 * @see #setConversionFactor(IfcMeasureWithUnit)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConversionBasedUnit_ConversionFactor()
	 * @model
	 * @generated
	 */
	IfcMeasureWithUnit getConversionFactor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConversionBasedUnit#getConversionFactor <em>Conversion Factor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conversion Factor</em>' reference.
	 * @see #getConversionFactor()
	 * @generated
	 */
	void setConversionFactor(IfcMeasureWithUnit value);

} // IfcConversionBasedUnit
