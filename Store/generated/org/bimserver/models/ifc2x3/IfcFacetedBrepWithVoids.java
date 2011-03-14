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
 * A representation of the model object '<em><b>Ifc Faceted Brep With Voids</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFacetedBrepWithVoids#getVoids <em>Voids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFacetedBrepWithVoids()
 * @model
 * @generated
 */
public interface IfcFacetedBrepWithVoids extends IfcManifoldSolidBrep {
	/**
	 * Returns the value of the '<em><b>Voids</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcClosedShell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Voids</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Voids</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFacetedBrepWithVoids_Voids()
	 * @model
	 * @generated
	 */
	EList<IfcClosedShell> getVoids();

} // IfcFacetedBrepWithVoids
