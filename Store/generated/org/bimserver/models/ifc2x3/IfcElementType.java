/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElementType#getElementType <em>Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElementType()
 * @model
 * @generated
 */
public interface IfcElementType extends IfcTypeProduct {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' attribute.
	 * @see #isSetElementType()
	 * @see #unsetElementType()
	 * @see #setElementType(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElementType_ElementType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getElementType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcElementType#getElementType <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' attribute.
	 * @see #isSetElementType()
	 * @see #unsetElementType()
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcElementType#getElementType <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElementType()
	 * @see #getElementType()
	 * @see #setElementType(String)
	 * @generated
	 */
	void unsetElementType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcElementType#getElementType <em>Element Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Element Type</em>' attribute is set.
	 * @see #unsetElementType()
	 * @see #getElementType()
	 * @see #setElementType(String)
	 * @generated
	 */
	boolean isSetElementType();

} // IfcElementType
