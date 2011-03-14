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
 * A representation of the model object '<em><b>Ifc Classification Notation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassificationNotation#getNotationFacets <em>Notation Facets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationNotation()
 * @model
 * @generated
 */
public interface IfcClassificationNotation extends IfcClassificationNotationSelect {
	/**
	 * Returns the value of the '<em><b>Notation Facets</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcClassificationNotationFacet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notation Facets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notation Facets</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationNotation_NotationFacets()
	 * @model
	 * @generated
	 */
	EList<IfcClassificationNotationFacet> getNotationFacets();

} // IfcClassificationNotation
