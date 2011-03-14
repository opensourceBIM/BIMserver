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
 * A representation of the model object '<em><b>Ifc Arbitrary Profile Def With Voids</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcArbitraryProfileDefWithVoids#getInnerCurves <em>Inner Curves</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcArbitraryProfileDefWithVoids()
 * @model
 * @generated
 */
public interface IfcArbitraryProfileDefWithVoids extends IfcArbitraryClosedProfileDef {
	/**
	 * Returns the value of the '<em><b>Inner Curves</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcCurve}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Curves</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Curves</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcArbitraryProfileDefWithVoids_InnerCurves()
	 * @model
	 * @generated
	 */
	EList<IfcCurve> getInnerCurves();

} // IfcArbitraryProfileDefWithVoids
