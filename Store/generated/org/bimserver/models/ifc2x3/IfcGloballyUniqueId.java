/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Globally Unique Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGloballyUniqueId#getWrappedValue <em>Wrapped Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGloballyUniqueId#getIfcRoot <em>Ifc Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGloballyUniqueId()
 * @model
 * @generated
 */
public interface IfcGloballyUniqueId extends WrappedValue {
	/**
	 * Returns the value of the '<em><b>Wrapped Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wrapped Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wrapped Value</em>' attribute.
	 * @see #setWrappedValue(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGloballyUniqueId_WrappedValue()
	 * @model
	 * @generated
	 */
	String getWrappedValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGloballyUniqueId#getWrappedValue <em>Wrapped Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wrapped Value</em>' attribute.
	 * @see #getWrappedValue()
	 * @generated
	 */
	void setWrappedValue(String value);

	/**
	 * Returns the value of the '<em><b>Ifc Root</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRoot#getGlobalId <em>Global Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifc Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Root</em>' reference.
	 * @see #setIfcRoot(IfcRoot)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGloballyUniqueId_IfcRoot()
	 * @see org.bimserver.models.ifc2x3.IfcRoot#getGlobalId
	 * @model opposite="GlobalId"
	 * @generated
	 */
	IfcRoot getIfcRoot();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGloballyUniqueId#getIfcRoot <em>Ifc Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ifc Root</em>' reference.
	 * @see #getIfcRoot()
	 * @generated
	 */
	void setIfcRoot(IfcRoot value);

} // IfcGloballyUniqueId
