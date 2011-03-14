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
 * A representation of the model object '<em><b>Ifc Rel Connects Path Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsPathElements#getRelatingPriorities <em>Relating Priorities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsPathElements#getRelatedPriorities <em>Related Priorities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsPathElements#getRelatedConnectionType <em>Related Connection Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsPathElements#getRelatingConnectionType <em>Relating Connection Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsPathElements()
 * @model
 * @generated
 */
public interface IfcRelConnectsPathElements extends IfcRelConnectsElements {
	/**
	 * Returns the value of the '<em><b>Relating Priorities</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Priorities</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Priorities</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsPathElements_RelatingPriorities()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getRelatingPriorities();

	/**
	 * Returns the value of the '<em><b>Related Priorities</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Priorities</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Priorities</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsPathElements_RelatedPriorities()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getRelatedPriorities();

	/**
	 * Returns the value of the '<em><b>Related Connection Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcConnectionTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Connection Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Connection Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcConnectionTypeEnum
	 * @see #setRelatedConnectionType(IfcConnectionTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsPathElements_RelatedConnectionType()
	 * @model
	 * @generated
	 */
	IfcConnectionTypeEnum getRelatedConnectionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsPathElements#getRelatedConnectionType <em>Related Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Connection Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcConnectionTypeEnum
	 * @see #getRelatedConnectionType()
	 * @generated
	 */
	void setRelatedConnectionType(IfcConnectionTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Relating Connection Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcConnectionTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Connection Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Connection Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcConnectionTypeEnum
	 * @see #setRelatingConnectionType(IfcConnectionTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsPathElements_RelatingConnectionType()
	 * @model
	 * @generated
	 */
	IfcConnectionTypeEnum getRelatingConnectionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsPathElements#getRelatingConnectionType <em>Relating Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Connection Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcConnectionTypeEnum
	 * @see #getRelatingConnectionType()
	 * @generated
	 */
	void setRelatingConnectionType(IfcConnectionTypeEnum value);

} // IfcRelConnectsPathElements
