/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Monetary Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMonetaryUnit#getCurrency <em>Currency</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMonetaryUnit()
 * @model
 * @generated
 */
public interface IfcMonetaryUnit extends IfcUnit {
	/**
	 * Returns the value of the '<em><b>Currency</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcCurrencyEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Currency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Currency</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcCurrencyEnum
	 * @see #setCurrency(IfcCurrencyEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMonetaryUnit_Currency()
	 * @model
	 * @generated
	 */
	IfcCurrencyEnum getCurrency();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMonetaryUnit#getCurrency <em>Currency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Currency</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcCurrencyEnum
	 * @see #getCurrency()
	 * @generated
	 */
	void setCurrency(IfcCurrencyEnum value);

} // IfcMonetaryUnit
