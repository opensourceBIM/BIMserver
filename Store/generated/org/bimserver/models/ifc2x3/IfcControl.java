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
 * A representation of the model object '<em><b>Ifc Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcControl#getControls <em>Controls</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcControl()
 * @model
 * @generated
 */
public interface IfcControl extends IfcObject {
	/**
	 * Returns the value of the '<em><b>Controls</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelAssignsToControl}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelAssignsToControl#getRelatingControl <em>Relating Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controls</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controls</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcControl_Controls()
	 * @see org.bimserver.models.ifc2x3.IfcRelAssignsToControl#getRelatingControl
	 * @model opposite="RelatingControl"
	 * @generated
	 */
	EList<IfcRelAssignsToControl> getControls();

} // IfcControl
