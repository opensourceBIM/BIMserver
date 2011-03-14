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
 * A representation of the model object '<em><b>Ifc Property Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertyDefinition#getHasAssociations <em>Has Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyDefinition()
 * @model
 * @generated
 */
public interface IfcPropertyDefinition extends IfcRoot {
	/**
	 * Returns the value of the '<em><b>Has Associations</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelAssociates}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Associations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Associations</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyDefinition_HasAssociations()
	 * @model
	 * @generated
	 */
	EList<IfcRelAssociates> getHasAssociations();

} // IfcPropertyDefinition
