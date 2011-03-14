/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Arbitrary Closed Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcArbitraryClosedProfileDef#getOuterCurve <em>Outer Curve</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcArbitraryClosedProfileDef()
 * @model
 * @generated
 */
public interface IfcArbitraryClosedProfileDef extends IfcProfileDef {
	/**
	 * Returns the value of the '<em><b>Outer Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Curve</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Curve</em>' reference.
	 * @see #setOuterCurve(IfcCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcArbitraryClosedProfileDef_OuterCurve()
	 * @model
	 * @generated
	 */
	IfcCurve getOuterCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcArbitraryClosedProfileDef#getOuterCurve <em>Outer Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Curve</em>' reference.
	 * @see #getOuterCurve()
	 * @generated
	 */
	void setOuterCurve(IfcCurve value);

} // IfcArbitraryClosedProfileDef
