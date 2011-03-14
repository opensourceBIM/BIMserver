/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Manifold Solid Brep</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcManifoldSolidBrep#getOuter <em>Outer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcManifoldSolidBrep()
 * @model
 * @generated
 */
public interface IfcManifoldSolidBrep extends IfcSolidModel {
	/**
	 * Returns the value of the '<em><b>Outer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer</em>' reference.
	 * @see #setOuter(IfcClosedShell)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcManifoldSolidBrep_Outer()
	 * @model
	 * @generated
	 */
	IfcClosedShell getOuter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcManifoldSolidBrep#getOuter <em>Outer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer</em>' reference.
	 * @see #getOuter()
	 * @generated
	 */
	void setOuter(IfcClosedShell value);

} // IfcManifoldSolidBrep
