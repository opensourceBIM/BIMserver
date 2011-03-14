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
 * A representation of the model object '<em><b>Ifc Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPort#getContainedIn <em>Contained In</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPort#getConnectedFrom <em>Connected From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPort#getConnectedTo <em>Connected To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPort()
 * @model
 * @generated
 */
public interface IfcPort extends IfcProduct {
	/**
	 * Returns the value of the '<em><b>Contained In</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelConnectsPortToElement#getRelatingPort <em>Relating Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained In</em>' reference.
	 * @see #setContainedIn(IfcRelConnectsPortToElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPort_ContainedIn()
	 * @see org.bimserver.models.ifc2x3.IfcRelConnectsPortToElement#getRelatingPort
	 * @model opposite="RelatingPort"
	 * @generated
	 */
	IfcRelConnectsPortToElement getContainedIn();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPort#getContainedIn <em>Contained In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained In</em>' reference.
	 * @see #getContainedIn()
	 * @generated
	 */
	void setContainedIn(IfcRelConnectsPortToElement value);

	/**
	 * Returns the value of the '<em><b>Connected From</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRelatedPort <em>Related Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected From</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPort_ConnectedFrom()
	 * @see org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRelatedPort
	 * @model opposite="RelatedPort" upper="2"
	 * @generated
	 */
	EList<IfcRelConnectsPorts> getConnectedFrom();

	/**
	 * Returns the value of the '<em><b>Connected To</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRelatingPort <em>Relating Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected To</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPort_ConnectedTo()
	 * @see org.bimserver.models.ifc2x3.IfcRelConnectsPorts#getRelatingPort
	 * @model opposite="RelatingPort" upper="2"
	 * @generated
	 */
	EList<IfcRelConnectsPorts> getConnectedTo();

} // IfcPort
