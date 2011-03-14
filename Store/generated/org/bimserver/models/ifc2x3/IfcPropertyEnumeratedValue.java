/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Property Enumerated Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue#getEnumerationValues <em>Enumeration Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyEnumeratedValue()
 * @model
 * @generated
 */
public interface IfcPropertyEnumeratedValue extends IfcSimpleProperty {
	/**
	 * Returns the value of the '<em><b>Enumeration Values</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration Values</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyEnumeratedValue_EnumerationValues()
	 * @model
	 * @generated
	 */
	EList<IfcValue> getEnumerationValues();

	/**
	 * Returns the value of the '<em><b>Enumeration Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration Reference</em>' reference.
	 * @see #isSetEnumerationReference()
	 * @see #unsetEnumerationReference()
	 * @see #setEnumerationReference(IfcPropertyEnumeration)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyEnumeratedValue_EnumerationReference()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPropertyEnumeration getEnumerationReference();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration Reference</em>' reference.
	 * @see #isSetEnumerationReference()
	 * @see #unsetEnumerationReference()
	 * @see #getEnumerationReference()
	 * @generated
	 */
	void setEnumerationReference(IfcPropertyEnumeration value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEnumerationReference()
	 * @see #getEnumerationReference()
	 * @see #setEnumerationReference(IfcPropertyEnumeration)
	 * @generated
	 */
	void unsetEnumerationReference();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue#getEnumerationReference <em>Enumeration Reference</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Enumeration Reference</em>' reference is set.
	 * @see #unsetEnumerationReference()
	 * @see #getEnumerationReference()
	 * @see #setEnumerationReference(IfcPropertyEnumeration)
	 * @generated
	 */
	boolean isSetEnumerationReference();

} // IfcPropertyEnumeratedValue
