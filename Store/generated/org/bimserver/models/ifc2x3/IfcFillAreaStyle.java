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
 * A representation of the model object '<em><b>Ifc Fill Area Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFillAreaStyle#getFillStyles <em>Fill Styles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyle()
 * @model
 * @generated
 */
public interface IfcFillAreaStyle extends IfcPresentationStyle, IfcPresentationStyleSelect {
	/**
	 * Returns the value of the '<em><b>Fill Styles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcFillStyleSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fill Styles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill Styles</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyle_FillStyles()
	 * @model
	 * @generated
	 */
	EList<IfcFillStyleSelect> getFillStyles();

} // IfcFillAreaStyle
