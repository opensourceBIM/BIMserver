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
 * A representation of the model object '<em><b>Ifc Rational Bezier Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRationalBezierCurve#getWeightsData <em>Weights Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRationalBezierCurve()
 * @model
 * @generated
 */
public interface IfcRationalBezierCurve extends IfcBezierCurve {
	/**
	 * Returns the value of the '<em><b>Weights Data</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weights Data</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weights Data</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRationalBezierCurve_WeightsData()
	 * @model unique="false"
	 * @generated
	 */
	EList<Float> getWeightsData();

} // IfcRationalBezierCurve
