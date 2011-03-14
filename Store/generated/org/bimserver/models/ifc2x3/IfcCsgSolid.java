/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Csg Solid</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCsgSolid#getTreeRootExpression <em>Tree Root Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCsgSolid()
 * @model
 * @generated
 */
public interface IfcCsgSolid extends IfcSolidModel {
	/**
	 * Returns the value of the '<em><b>Tree Root Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tree Root Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tree Root Expression</em>' reference.
	 * @see #setTreeRootExpression(IfcCsgSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCsgSolid_TreeRootExpression()
	 * @model
	 * @generated
	 */
	IfcCsgSelect getTreeRootExpression();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCsgSolid#getTreeRootExpression <em>Tree Root Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tree Root Expression</em>' reference.
	 * @see #getTreeRootExpression()
	 * @generated
	 */
	void setTreeRootExpression(IfcCsgSelect value);

} // IfcCsgSolid
