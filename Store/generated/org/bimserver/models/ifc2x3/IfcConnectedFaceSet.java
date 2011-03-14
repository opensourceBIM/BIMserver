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
 * A representation of the model object '<em><b>Ifc Connected Face Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConnectedFaceSet#getCfsFaces <em>Cfs Faces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectedFaceSet()
 * @model
 * @generated
 */
public interface IfcConnectedFaceSet extends IfcTopologicalRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Cfs Faces</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcFace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cfs Faces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cfs Faces</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConnectedFaceSet_CfsFaces()
	 * @model
	 * @generated
	 */
	EList<IfcFace> getCfsFaces();

} // IfcConnectedFaceSet
