/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Physical Simple Quantity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPhysicalSimpleQuantity#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPhysicalSimpleQuantity()
 * @model
 * @generated
 */
public interface IfcPhysicalSimpleQuantity extends IfcPhysicalQuantity {
	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' reference.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #setUnit(IfcNamedUnit)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPhysicalSimpleQuantity_Unit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcNamedUnit getUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPhysicalSimpleQuantity#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(IfcNamedUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPhysicalSimpleQuantity#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcNamedUnit)
	 * @generated
	 */
	void unsetUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPhysicalSimpleQuantity#getUnit <em>Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unit</em>' reference is set.
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @see #setUnit(IfcNamedUnit)
	 * @generated
	 */
	boolean isSetUnit();

} // IfcPhysicalSimpleQuantity
