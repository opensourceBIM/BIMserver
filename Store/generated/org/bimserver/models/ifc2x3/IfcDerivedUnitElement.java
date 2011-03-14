/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Derived Unit Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getExponent <em>Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDerivedUnitElement()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcDerivedUnitElement extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' reference.
	 * @see #setUnit(IfcNamedUnit)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDerivedUnitElement_Unit()
	 * @model
	 * @generated
	 */
	IfcNamedUnit getUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(IfcNamedUnit value);

	/**
	 * Returns the value of the '<em><b>Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exponent</em>' attribute.
	 * @see #setExponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDerivedUnitElement_Exponent()
	 * @model
	 * @generated
	 */
	int getExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDerivedUnitElement#getExponent <em>Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exponent</em>' attribute.
	 * @see #getExponent()
	 * @generated
	 */
	void setExponent(int value);

} // IfcDerivedUnitElement
