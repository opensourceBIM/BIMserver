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
 * A representation of the model object '<em><b>Ifc Composite Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCompositeCurve#getSegments <em>Segments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCompositeCurve#isSelfIntersect <em>Self Intersect</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeCurve()
 * @model
 * @generated
 */
public interface IfcCompositeCurve extends IfcBoundedCurve {
	/**
	 * Returns the value of the '<em><b>Segments</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcCompositeCurveSegment}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcCompositeCurveSegment#getUsingCurves <em>Using Curves</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segments</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeCurve_Segments()
	 * @see org.bimserver.models.ifc2x3.IfcCompositeCurveSegment#getUsingCurves
	 * @model opposite="UsingCurves"
	 * @generated
	 */
	EList<IfcCompositeCurveSegment> getSegments();

	/**
	 * Returns the value of the '<em><b>Self Intersect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Intersect</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Intersect</em>' attribute.
	 * @see #setSelfIntersect(boolean)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeCurve_SelfIntersect()
	 * @model
	 * @generated
	 */
	boolean isSelfIntersect();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCompositeCurve#isSelfIntersect <em>Self Intersect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Intersect</em>' attribute.
	 * @see #isSelfIntersect()
	 * @generated
	 */
	void setSelfIntersect(boolean value);

} // IfcCompositeCurve
