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
 * A representation of the model object '<em><b>Ifc Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPath#getEdgeList <em>Edge List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPath()
 * @model
 * @generated
 */
public interface IfcPath extends IfcTopologicalRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Edge List</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcOrientedEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge List</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPath_EdgeList()
	 * @model
	 * @generated
	 */
	EList<IfcOrientedEdge> getEdgeList();

} // IfcPath
