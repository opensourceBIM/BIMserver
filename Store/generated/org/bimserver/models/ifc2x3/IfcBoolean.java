/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Boolean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoolean#getWrappedValue <em>Wrapped Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoolean()
 * @model
 * @generated
 */
public interface IfcBoolean extends WrappedValue, IfcValue {
	/**
	 * Returns the value of the '<em><b>Wrapped Value</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wrapped Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wrapped Value</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setWrappedValue(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoolean_WrappedValue()
	 * @model
	 * @generated
	 */
	Tristate getWrappedValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoolean#getWrappedValue <em>Wrapped Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wrapped Value</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getWrappedValue()
	 * @generated
	 */
	void setWrappedValue(Tristate value);

} // IfcBoolean
