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
 * A representation of the model object '<em><b>Ifc Classification Notation Facet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassificationNotationFacet#getNotationValue <em>Notation Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationNotationFacet()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcClassificationNotationFacet extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Notation Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notation Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notation Value</em>' attribute.
	 * @see #setNotationValue(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationNotationFacet_NotationValue()
	 * @model
	 * @generated
	 */
	String getNotationValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationNotationFacet#getNotationValue <em>Notation Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notation Value</em>' attribute.
	 * @see #getNotationValue()
	 * @generated
	 */
	void setNotationValue(String value);

} // IfcClassificationNotationFacet
